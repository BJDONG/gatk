package org.broadinstitute.sting.queue.qscripts.performance

import org.broadinstitute.sting.queue.QScript
import org.broadinstitute.sting.queue.extensions.gatk._
import java.lang.Math
import org.broadinstitute.sting.utils.PathUtils
import org.broadinstitute.sting.gatk.walkers.genotyper.GenotypeLikelihoodsCalculationModel
import org.broadinstitute.sting.utils.baq.BAQ
import org.broadinstitute.sting.commandline.ClassType

class GATKPerformanceOverTime extends QScript {
  @Argument(shortName = "results", doc="results", required=false)
  val resultsDir: File = new File("runResults")

  @Argument(shortName = "resources", doc="resources", required=true)
  val resourcesDir: String = ""

  @Argument(shortName = "myJarFile", doc="Path to the current GATK jar file", required=true)
  val myJarFile: File = null

  @Argument(shortName = "iterations", doc="it", required=false)
  val iterations: Int = 2

  @Argument(shortName = "smallData", doc="it", required=false)
  val smallData: Boolean = false

  @Argument(shortName = "justDeepWGS", doc="it", required=false)
  val justDeepWGS: Boolean = false

  @Argument(shortName = "skipBAQ", doc="it", required=false)
  val skipBAQ: Boolean = false

  @Argument(shortName = "assessment", doc="Which assessments should we run?", required=false)
  val assessmentsArg: Set[String] = Assessment.values map(_.toString)
  var assessments: Set[Assessment.Assessment] = _

  @Argument(shortName = "ntTest", doc="For each value provided we will use -nt VALUE in the multi-threaded tests", required=false)
  @ClassType(classOf[Int])
  val ntTests: List[Int] = List(1, 2, 3, 4, 6, 8, 10, 12, 16, 20, 24)

  @Argument(shortName = "steps", doc="steps", required=false)
  val steps: Int = 10

  @Argument(shortName = "maxNSamples", doc="maxNSamples", required=false)
  val maxNSamples: Int = 1000000

  val singleTestsPerIteration = 3

  val MY_TAG = "GATKPerformanceOverTime"
  val RECAL_BAM_FILENAME = "CEUTrio.HiSeq.WGS.b37_decoy.NA12878.clean.dedup.recal.20GAV.8.bam"
  val RECAL_GATKREPORT_FILENAME = "CEUTrio.HiSeq.WGS.b37_decoy.NA12878.clean.dedup.recal.20GAV.8.grp"
  val dbSNP_FILENAME = "dbsnp_132.b37.vcf"
  val BIG_VCF_WITH_GENOTYPES = "ALL.chr1.phase1_release_v3.20101123.snps_indels_svs.genotypes.vcf.gz"
  val BIG_VCF_WITH_GENOTYPES_16_COMPATIBLE = new File("/humgen/gsa-hpprojects/GATK/bundle/1.5/b37/1000G_omni2.5.b37.vcf")
  val b37_FILENAME = "human_g1k_v37.fasta"

  val manyDeepExomeSamples = "combined_5022.bam"
  val manyDeepExomeIntervals = "1:1104385-1684501"

  def makeResource(x: String): File = new File("%s/%s".format(resourcesDir, x))
  def makeChunk(x: Int): File = makeResource("chunk_%d.vcf".format(x))
  def COMBINE_FILES: List[File] = Range(1,10).map(makeChunk).toList

  class AssessmentParameters(val name: String,
                             val bamList: File,
                             val fullIntervals: String,
                             val shortIntervals: String,
                             val nSamples: Int,
                             val dcov: Int,
                             val baq: Boolean) {
    def addIntervals(gatkCmd : CommandLineGATK, useFull: Boolean): CommandLineGATK = {
      val intervals = if (useFull && ! smallData) fullIntervals else shortIntervals
      val maybeFile = makeResource(intervals)
      if ( maybeFile.exists() )
        gatkCmd.intervals :+= maybeFile
      else
        gatkCmd.intervalsString :+= intervals
      gatkCmd
    }
  }

  // TODO -- count the number of lines in the bam.list file
  val WGSAssessment = new AssessmentParameters("WGS.multiSample.4x", "wgs.bam.list.local.list", "wgs.bam.list.select.intervals", "20:10000000-11000000", 1103, 50, true)
  val WGSDeepAssessment = new AssessmentParameters("WGS.singleSample.60x", "wgs.deep.bam.list.local.list", "wgs.deep.bam.list.select.intervals", "1", 1, 250, true)
  val WExAssessment = new AssessmentParameters("WEx.multiSample.150x", "wex.bam.list.local.list", "wex.bam.list.select.intervals", "wex.bam.list.small.intervals", 140, 500, true)

  val GATK_RELEASE_DIR = new File("/humgen/gsa-hpprojects/GATK/bin/")
  val GATKs: Map[String, File] = Map(
    "v2.cur" -> myJarFile, // TODO -- how do I get this value?
    "v1.6" -> findMostRecentGATKVersion("1.6"))

  object Assessment extends Enumeration {
    type Assessment = Value
    val UG, UG_NT, CL, CL_NT, CV, CV_NT, VE, VE_NT, SV, BQSR_NT, PRINT_READS_NT, MANY_SAMPLES_NT = Value
  }

  val NCT_ASSESSMENTS = List(Assessment.UG_NT, Assessment.CL_NT, Assessment.BQSR_NT, Assessment.PRINT_READS_NT, Assessment.MANY_SAMPLES_NT)
  def supportsNCT(assessment: Assessment.Assessment) = NCT_ASSESSMENTS contains assessment

  val NO_NT_ASSESSMENTS = List(Assessment.PRINT_READS_NT, Assessment.MANY_SAMPLES_NT)
  def supportsNT(assessment: Assessment.Assessment) = ! (NO_NT_ASSESSMENTS contains assessment)

  trait UNIVERSAL_GATK_ARGS extends CommandLineGATK {
    this.logging_level = "INFO"
    this.reference_sequence = makeResource(b37_FILENAME)
    this.memoryLimit = 4
  }

  def script() {
    assessments = assessmentsArg.map(Assessment.withName(_))

    if ( ! resultsDir.exists ) resultsDir.mkdirs()

    // iterate over GATK's and data sets
    for ( iteration <- 0 until iterations ) {
      for ( (gatkName, gatkJar) <- GATKs ) {

        enqueueCommandsForEachAssessment(iteration, gatkName, gatkJar)
        enqueueMultiThreadedCommands(iteration, gatkName, gatkJar)
        enqueueSingleTestCommands(iteration, gatkName, gatkJar)
      }
    }
  }

  def enqueueMultiThreadedCommands(iteration: Int, gatkName: String, gatkJar: File) {
    // GATK v2 specific tests
    if ( assessments.contains(Assessment.CV_NT) ) {
      if ( gatkName.contains("v2") ) {
        for ( outputBCF <- List(true, false) ) {
          def makeCV(): CommandLineGATK = {
            val outputName = if ( outputBCF ) "bcf" else "vcf"
            val CV = new CombineVariants with UNIVERSAL_GATK_ARGS
            CV.configureJobReport(Map( "iteration" -> iteration, "gatk" -> gatkName, "assessment" -> outputName))
            CV.jarFile = gatkJar
            CV.variant = List(makeResource(BIG_VCF_WITH_GENOTYPES))
            CV.out = new File("/dev/null")
            CV.bcf = outputBCF
            CV
          }
          addMultiThreadedTest(gatkName, Assessment.CV_NT, makeCV)
        }
      }
    }

    if ( assessments.contains(Assessment.BQSR_NT) ) {
      def makeBQSR(): BaseRecalibrator = {
        val BQSR = new MyBaseRecalibrator(gatkName.contains("v2"))
        BQSR.configureJobReport(Map( "iteration" -> iteration, "gatk" -> gatkName, "assessment" -> "20GAV.8.bam"))
        BQSR.jarFile = gatkJar
        BQSR
      }
      addMultiThreadedTest(gatkName, Assessment.BQSR_NT, makeBQSR, 8) // max nt until BQSR is performant
    }

    if ( assessments.contains(Assessment.MANY_SAMPLES_NT) ) {
      def makeUG(): UnifiedGenotyper = {
        val ug = new Call(makeResource(manyDeepExomeSamples), 1, "manyDeepExomes", false) with UNIVERSAL_GATK_ARGS
        ug.intervalsString :+= manyDeepExomeIntervals
        ug.configureJobReport(Map( "iteration" -> iteration, "gatk" -> gatkName, "assessment" -> "manyDeepExomes"))
        ug.jarFile = gatkJar
        ug.glm = GenotypeLikelihoodsCalculationModel.Model.SNP
        ug.memoryLimit = 16
        ug
      }
      addMultiThreadedTest(gatkName, Assessment.MANY_SAMPLES_NT, makeUG, scaleMem = false)
    }

    if ( assessments.contains(Assessment.PRINT_READS_NT) ) {
      for ( assessment <- List("BQSR", "BAQ") ) {
        def makePrintReads(): PrintReads = {
          val PR = new PrintReads with UNIVERSAL_GATK_ARGS
          PR.intervalsString = List("1", "2", "3", "4", "5")
          PR.input_file :+= makeResource(RECAL_BAM_FILENAME)
          PR.out = new File("/dev/null")
          PR.memoryLimit = 4
          if ( assessment.equals("BQSR") )
            PR.baq = BAQ.CalculationMode.RECALCULATE
          else
            PR.BQSR = makeResource(RECAL_GATKREPORT_FILENAME)
          PR.configureJobReport(Map( "iteration" -> iteration, "gatk" -> gatkName, "assessment" -> assessment))
          PR.jarFile = gatkJar
          PR
        }
        addMultiThreadedTest(gatkName, Assessment.PRINT_READS_NT, makePrintReads, scaleMem = false)
      }
    }
  }

  def enqueueSingleTestCommands(iteration: Int, gatkName: String, gatkJar: File) {
    for ( subiteration <- 0 until singleTestsPerIteration ) {
      trait VersionOverrides extends CommandLineGATK {
        this.jarFile = gatkJar
        this.configureJobReport(Map( "iteration" -> iteration, "gatk" -> gatkName))
      }

      val CV = new CombineVariants with UNIVERSAL_GATK_ARGS with VersionOverrides
      CV.variant = COMBINE_FILES
      CV.intervalsString = List("1", "2", "3", "4", "5")
      CV.out = new File("/dev/null")
      if ( assessments.contains(Assessment.CV) )
        addGATKCommand(CV)

      val SV = new SelectVariants with UNIVERSAL_GATK_ARGS with VersionOverrides
      SV.variant = BIG_VCF_WITH_GENOTYPES_16_COMPATIBLE
      SV.sample_name = List("HG00096") // IMPORTANT THAT THIS SAMPLE BE IN CHUNK ONE
      SV.out = new File("/dev/null")
      if ( assessments.contains(Assessment.SV) )
        addGATKCommand(SV)

      def makeVE(): CommandLineGATK = {
        val VE = new VariantEval with UNIVERSAL_GATK_ARGS with VersionOverrides
        VE.eval :+= BIG_VCF_WITH_GENOTYPES_16_COMPATIBLE
        VE.out = new File("/dev/null")
        VE.comp :+= new TaggedFile(makeResource(dbSNP_FILENAME), "dbSNP")
        VE.addJobReportBinding("assessment", BIG_VCF_WITH_GENOTYPES_16_COMPATIBLE.getName)
        VE
      }

      if ( assessments.contains(Assessment.VE) ) {
        addGATKCommand(makeVE())
      }

      if ( assessments.contains(Assessment.VE_NT) )
        addMultiThreadedTest(gatkName, Assessment.VE_NT, makeVE)
    }
  }

  def enqueueCommandsForEachAssessment(iteration: Int, gatkName: String, gatkJar: File) {
    val dataSets = if ( justDeepWGS ) List(WGSDeepAssessment) else List(WGSAssessment, WGSDeepAssessment, WExAssessment)

    for ( assess <- dataSets ) {
      for (nSamples <- divideSamples(assess.nSamples) ) {
        val sublist = new SliceList(assess.name, nSamples, makeResource(assess.bamList))
        if ( iteration == 0 ) add(sublist) // todo - remove condition when Queue bug is fixed
        val name: String = "%s/assess.%s_gatk.%s_iter.%d".format(resultsDir, assess.name, gatkName, iteration)

        trait VersionOverrides extends CommandLineGATK {
          this.jarFile = gatkJar
          this.dcov = assess.dcov

          this.configureJobReport(Map(
            "iteration" -> iteration,
            "gatk" -> gatkName,
            "nSamples" -> nSamples,
            "assessment" -> assess.name))
        }

        // SNP calling
        if ( assessments.contains(Assessment.UG) )
          addGATKCommand(assess.addIntervals(new Call(sublist.list, nSamples, name, assess.baq) with VersionOverrides, false))
        if ( assessments.contains(Assessment.UG_NT) && nSamples == assess.nSamples )
          addMultiThreadedTest(gatkName, Assessment.UG_NT, () => assess.addIntervals(new Call(sublist.list, nSamples, name, assess.baq) with VersionOverrides, false))

        // CountLoci
        if ( assessments.contains(Assessment.CL) )
          addGATKCommand(assess.addIntervals(new MyCountLoci(sublist.list, nSamples, name) with VersionOverrides, true))
        if ( assessments.contains(Assessment.CL_NT) && nSamples == assess.nSamples )
          addMultiThreadedTest(gatkName, Assessment.CL_NT, () => assess.addIntervals(new MyCountLoci(sublist.list, nSamples, name) with VersionOverrides, true))
      }
    }
  }

  def addMultiThreadedTest(gatkName: String,
                           assessment: Assessment.Assessment,
                           makeCommand: () => CommandLineGATK,
                           maxNT : Int = 1000,
                           scaleMem : Boolean = true) {
    if ( ntTests.size >= 1 ) {
      for ( nt <- ntTests ) {
        if ( nt <= maxNT ) {
          for ( useNT <- List(true, false) ) {
            if ( ( useNT && supportsNT(assessment)) ||
                 (! useNT && supportsNCT(assessment) && gatkName.contains("v2.cur") )) {
              // TODO -- fix v2.cur testing
              val cmd = makeCommand()
              if ( useNT )
                cmd.nt = nt
              else
                cmd.nct = nt
              if ( scaleMem )
                cmd.memoryLimit = cmd.memoryLimit * (if ( nt >= 8 ) (if (nt>=16) 4 else 2) else 1)
              cmd.addJobReportBinding("nt", nt)
              cmd.addJobReportBinding("ntType", if ( useNT ) "nt" else "nct")
              cmd.analysisName = cmd.analysisName + ".nt"
              addGATKCommand(cmd)
            }
          }
        }
      }
    }
  }

  def divideSamples(nTotalSamples: Int): List[Int] = {
    val maxLog10: Double = Math.log10(Math.min(maxNSamples, nTotalSamples))
    val stepSize: Double = maxLog10 / steps
    val ten: Double = 10.0
    def deLog(x: Int): Int = Math.round(Math.pow(ten, stepSize * x)).toInt
    dedupe(Range(0, steps+1).map(deLog).toList)
  }

  class Call(@Input(doc="foo") bamList: File, n: Int, name: String, useBaq: Boolean) extends UnifiedGenotyper with UNIVERSAL_GATK_ARGS {
    this.input_file :+= bamList
    this.stand_call_conf = 10.0
    this.glm = GenotypeLikelihoodsCalculationModel.Model.BOTH
    //this.baq = if ( ! skipBAQ && useBaq ) org.broadinstitute.sting.utils.baq.BAQ.CalculationMode.RECALCULATE else org.broadinstitute.sting.utils.baq.BAQ.CalculationMode.OFF
    @Output(doc="foo") var outVCF: File = new File("/dev/null")
    this.o = outVCF
  }

  class MyCountLoci(@Input(doc="foo") bamList: File, n: Int, name: String) extends CountLoci with UNIVERSAL_GATK_ARGS {
    this.input_file :+= bamList
    @Output(doc="foo") var outFile: File = new File("/dev/null")
    this.o = outFile
  }

  class SliceList(prefix: String, n: Int, @Input bamList: File) extends CommandLineFunction {
    this.analysisName = "SliceList"
    @Output(doc="foo") var list: File = new File("%s/%s.bams.%d.list".format(resultsDir.getPath, prefix, n))
    def commandLine = "head -n %d %s | awk '{print \"%s/\" $1}' > %s".format(n, bamList, resourcesDir, list)
  }

  def addGATKCommand(gatkCmd: CommandLineGATK) {
    if ( gatkCmd.jarFile == null || ! gatkCmd.jarFile.getAbsolutePath.matches(".*-1.[0-9]*-.*") )
      gatkCmd.tag = MY_TAG
    add(gatkCmd)
  }

  def dedupe(elements:List[Int]):List[Int] = {
    if (elements.isEmpty)
      elements
    else
      elements.head :: dedupe(for (x <- elements.tail if x != elements.head) yield x)
  }

  /**
   * Walk over the GATK released directories to find the most recent JAR files corresponding
   * to the version prefix.  For example, providing input "GenomeAnalysisTK-1.2" will
   * return the full path to the most recent GenomeAnalysisTK.jar in the GATK_RELEASE_DIR
   * in directories that match GATK_RELEASE_DIR/GenomeAnalysisTK-1.2*
   */
  def findMostRecentGATKVersion(version: String): File = {
    PathUtils.findMostRecentGATKVersion(GATK_RELEASE_DIR, version)
  }

  /**
   * This is a total abuse of the Queue system.  Override the command line function and remove the
   * -o /dev/null argument which isn't present in BQSR v1.  Otherwise this system magically
   * @param v2
   */
  class MyBaseRecalibrator(val v2: Boolean) extends BaseRecalibrator with UNIVERSAL_GATK_ARGS {
    this.intervalsString = List("1", "2", "3", "4", "5")
    this.knownSites :+= makeResource(dbSNP_FILENAME)
    // must explicitly list the covariates so that BQSR v1 works
    this.input_file :+= makeResource(RECAL_BAM_FILENAME)
    this.out = new File("/dev/null")
    this.memoryLimit = 12

    if ( ! v2 ) {
      this.analysis_type = "CountCovariates" // BQSR v1 name is CountCovariates
    }

    // terrible terrible hack.  Explicitly remove the -o output which isn't present in v1
    override def commandLine(): String = {
      val covariates = "-cov ReadGroupCovariate -cov QualityScoreCovariate -cov CycleCovariate -cov DinucCovariate"
      if ( ! v2 )
        super.commandLine.replace("'-o' '/dev/null'", covariates)
      else
        super.commandLine
    }
  }
}
