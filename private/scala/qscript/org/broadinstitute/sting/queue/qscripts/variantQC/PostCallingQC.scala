import org.broadinstitute.sting.queue.QScript
import org.broadinstitute.sting.queue.extensions.gatk._

class PostCallingQC extends QScript {
  qscript =>

  @Argument(shortName = "R", doc="ref", required=false)
  var referenceFile: File = new File("/humgen/1kg/reference/human_g1k_v37.fasta")

  // todo  -- should accept separate indel and snp vcf's, right now script will assume they're combined in one
  @Argument(shortName = "eval", doc="VCFs to evaluate")
  var evalVCFs: List[File] = Nil

  @Argument(shortName = "L", doc="intervals", required=false)
  val myIntervals: List[String] = Nil

  @Argument(shortName = "XL", doc="exclude intervals", required=false)
  var myExcludeIntervals: List[String] = Nil

  @Argument(shortName = "RPath", doc="RPath", required=false)
  var RPath: File = new File("../R")

  @Argument(shortName = "dbSNP", doc="dbSNP", required=false)
  val dbSNP: File = new File("/humgen/gsa-hpprojects/GATK/bundle/current/b37/dbsnp_137.b37.vcf")

  @Argument(shortName = "goldStandardIndels", doc="Path to gold standard indels", required=false)
  val goldStandardIndels: File = new File("/humgen/gsa-hpprojects/GATK/bundle/current/b37/Mills_and_1000G_gold_standard.indels.b37.sites.vcf")

  @Argument(shortName = "nt", doc="nt", required=false)
  val num_threads: Int = 1

  def script() {
    for ( evalVCF <- evalVCFs ) {
      // The basic summary eval, by AC
      val byAC = new Eval(evalVCF, ".byAC", Seq("AlleleCount"))
      add(byAC)

      // The basic summary eval broken down by sample
      val bySample = new Eval(evalVCF, ".bySample", Seq("Sample"))
      add(bySample)

      // The basic summary eval broken down by sample
      val indelQC = new Eval(evalVCF, ".indelQC", Seq("Sample"))
      indelQC.stratificationModule = Seq("EvalRod", "CompRod", "Sample", "TandemRepeat", "OneBPIndel")
      indelQC.evalModule = List("IndelSummary", "IndelLengthHistogram")
      add(indelQC)

      val qc = new QCRScript(evalVCF, byAC.out, bySample.out, indelQC.out)
      add(qc)
    }
  }

  class Eval(evalVCF: File, prefix: String, extraStrats: Seq[String]) extends VariantEval {
    this.reference_sequence = referenceFile
    this.intervalsString = myIntervals
    this.excludeIntervalsString = myExcludeIntervals
    this.eval :+= evalVCF
    this.dbsnp = dbSNP
    this.doNotUseAllStandardModules = true
    this.gold = goldStandardIndels
    this.evalModule = List("TiTvVariantEvaluator", "CountVariants", "CompOverlap", "IndelSummary")
    this.doNotUseAllStandardStratifications = true
    this.stratificationModule = Seq("EvalRod", "CompRod", "Novelty", "FunctionalClass") ++ extraStrats
    this.num_threads = qscript.num_threads
    this.memoryLimit = 8
    this.out = swapExt(evalVCF, ".vcf", prefix + ".eval")
  }

  class QCRScript(@Input var vcf: File, @Input var byAC: File, @Input var bySite: File, @Input var indelQC: File) extends CommandLineFunction {
    @Output var pdf: File = swapExt(vcf, ".vcf", ".pdf")
    private val project = vcf.getName.stripSuffix(".vcf")
    def commandLine = "Rscript %s/variantCallQC.R %s %s %s %s %s".format(RPath, project, bySite, byAC, indelQC, pdf)
  }
}
