package org.broadinstitute.sting.queue.qscripts.bqsr

import org.broadinstitute.sting.utils.recalibration.RecalUtils
import org.broadinstitute.sting.gatk.walkers.bqsr.RecalUtils
import org.broadinstitute.sting.queue.extensions.gatk.BaseQualityScoreRecalibrator
import org.broadinstitute.sting.queue.QScript
import org.broadinstitute.sting.queue.util.QScriptUtils

class BQSR extends QScript {

  @Input(doc="dbsnp ROD to use (must be in VCF format)", fullName="dbsnp", shortName="d", required=true) var dbSNP: Seq[File] = Seq()
  @Input(shortName = "recal", required=false, doc = "recalibration report") var recalFile: File = null

  @Argument(shortName = "b",  required=true,  doc = "List of BAM files")           var bamList: File = _
  @Argument(shortName = "i",  required=false, doc = "Intervals file")              var intervalsFile: List[File] = Nil
  @Argument(shortName = "mcs",required=false, doc = "mismatches context size")     var mismatchesContextSize = 6
  @Argument(shortName = "ics",required=false, doc = "insertions context size")     var insertionsContextSize = 6
  @Argument(shortName = "dcs",required=false, doc = "deletions context size")      var deletionsContextSize = 2
  @Argument(shortName = "r",  required=false, doc = "Reference sequence")          var referenceFile: File = new File("/humgen/1kg/reference/human_g1k_v37_decoy.fasta")
  @Argument(shortName = "m",  required=false, doc = "memory limit")                var memLimit: Int = 4
  @Argument(shortName = "qq", required=false, doc = "quantization lvls")           var nLevels: Int = 0
  @Argument(shortName = "k",  required=false, doc = "keep intermediate files")     var keepIntermediates: Boolean = true
  @Argument(shortName = "s",  required=false, doc = "scatter/gather")              var scatter: Int = 50
  @Argument(shortName = "np", required=false, doc = "don't generate plots")        var noPlots: Boolean = false
  @Argument(shortName = "rg", required=false, doc = "single read group filter")    var goodReadGroup: String = _
  @Argument(shortName = "nt", required=false, doc = "use multiple threads")        var nThreads: Int = 2
  @Argument(shortName = "nr", required=false, doc = "no recalibration (2nd pass)") var noRecalibration: Boolean = false

  def script() {
    val bams = QScriptUtils.createSeqFromFile(bamList)
    val firstPass:  Boolean = recalFile == null
    val secondPass: Boolean = !noRecalibration
    for (bam <- bams) {
      val inRecalFile = swapExt(bam, ".bam", ".original.grp")
      val outRecalFile = swapExt(bam, ".bam", ".recal.grp")
      if (firstPass)
        add(BQSR(bam, inRecalFile, null, goodReadGroup, !secondPass && keepIntermediates, true))
      if (secondPass)
        add(BQSR(bam, outRecalFile, inRecalFile, goodReadGroup, keepIntermediates, noPlots))
    }
  }

  case class BQSR (bam: File, output: File, input: File, readGroup: String, keepCSV: Boolean, dontGeneratePlots: Boolean) extends BaseQualityScoreRecalibrator {
    this.reference_sequence = referenceFile
    this.intervalsString = intervalsFile
    this.out = output
    this.input_file :+= bam
    this.knownSites ++= dbSNP
    this.memoryLimit = memLimit
    this.qq = nLevels
    this.mcs = mismatchesContextSize
    this.ics = insertionsContextSize
    this.dcs = deletionsContextSize
    this.BQSR = input
    this.no_plots = if (scatter > 0) {dontGeneratePlots} else {true}
    this.keep_intermediate_files = if (scatter > 0) {keepCSV} else {false}
    this.solid_nocall_strategy = RecalUtils.SOLID_NOCALL_STRATEGY.PURGE_READ
    this.scatterCount = scatter
  }
}
