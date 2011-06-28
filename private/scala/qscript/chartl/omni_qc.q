import java.io.{FileReader, File, BufferedReader}
import net.sf.picard.reference.FastaSequenceFile
import org.broadinstitute.sting.datasources.pipeline.Pipeline
import org.broadinstitute.sting.gatk.contexts.variantcontext.VariantContextUtils
import org.broadinstitute.sting.gatk.DownsampleType
import org.broadinstitute.sting.gatk.walkers.genotyper.GenotypeCalculationModel.Model
import org.broadinstitute.sting.queue.extensions.gatk._
import org.broadinstitute.sting.queue.extensions.samtools._
import org.broadinstitute.sting.queue.{QException, QScript}
import collection.JavaConversions._
import org.broadinstitute.sting.utils.yaml.YamlUtils
import scala.collection.mutable.HashMap

class omni_qc extends QScript {
  qscript =>

  // NON-OMNI VCF FILES
  var pilot3_release_vcf = new TaggedFile("/humgen/gsa-scr1/chartl/projects/pilot3/merge_release/ALL.exon.2010_03.genotypes.vcf","vcf")
  var pilot1_ceu_vcf = new TaggedFile("/humgen/1kg/releases/pilot_project/2010_07/low_coverage/snps/CEU.low_coverage.2010_07.genotypes.vcf.gz","vcf")
  var pilot1_chb_vcf = new TaggedFile("/humgen/1kg/releases/pilot_project/2010_07/low_coverage/snps/CHBJPT.low_coverage.2010_07.genotypes.vcf.gz","vcf")
  var pilot1_yri_vcf = new TaggedFile("/humgen/1kg/releases/pilot_project/2010_07/low_coverage/snps/YRI.low_coverage.2010_07.genotypes.vcf.gz","vcf")
  var august_calls_EUR = new TaggedFile("/humgen/1kg/processing/release/august/EUR.vcf","vcf")
  var august_calls_ASN = new TaggedFile("/humgen/1kg/processing/release/august/ASN.vcf","vcf")
  var august_calls_AFR = new TaggedFile("/humgen/1kg/processing/release/august/AFR.vcf","vcf")
  var august_calls_EUR_refined = new TaggedFile("/humgen/1kg/processing/release/august/bgzip_for_release/EUR.beagle.vcf.gz","vcf")
  var august_calls_ASN_refined = new TaggedFile("/humgen/1kg/processing/release/august/bgzip_for_release/ASN.beagle.vcf.gz","vcf")
  var august_calls_AFR_refined = new TaggedFile("/humgen/1kg/processing/release/august/bgzip_for_release/AFR.beagle.vcf.gz","vcf")
  var hiseq_calls_vcf = new TaggedFile("/humgen/gsa-scr1/chartl/projects/omni/resources/NA12878.HiSeq.v9.b36.vcf.gz","vcf")
  var pilot1_with_na12878_vcf = new TaggedFile("/humgen/1kg/analysis/bamsForDataProcessingPapers/lowpass_b36/calls/v2/N60/lowpass.N60.recal.mG6.retranche.vcf","vcf")
  var pilot1_na12878_beagle = new File("/humgen/1kg/analysis/bamsForDataProcessingPapers/lowpass_b36/calls/beagle/lowpass.N60.recal.CEUTSI.bgl.output.vcf")
  //var august_calls_other_genotypes = _

  // OMNI VCF FILES
  var OMNI_b36_vcf = new TaggedFile("/humgen/illumina/1kg_seq_vcfs/Illumina_HapMap_Omni_2.5_764samples.vcf","vcf")
  var OMNI_b37_vcf = new TaggedFile("/broad/shptmp/chartl/Omni_2.5_764_samples.b37.deduped.vcf","vcf")
  var OMNI_hapmap_b36_vcf = new TaggedFile("/humgen/gsa-scr1/chartl/projects/omni/resources_oct7/Omni_2_5_pilot.b36.vcf","vcf")
  var OMNI_b36_panel_vcf = new TaggedFile("/broad/shptmp/chartl/omni/vcfs/Omni_b36_with_panel_sets.vcf","vcf")
  var OMNI_b37_birdseed = new File("/humgen/gsa-scr1/chartl/projects/omni/resources_oct7/OMNI_birdseed_only.vcf")
  var OMNI_b37_joint = new File("/humgen/gsa-scr1/chartl/projects/omni/resources_oct7/OMNI_joint_birdseed_lowpass.vcf")

  // INTERVALS
  var pilot3_interval_list: String = "/humgen/gsa-hpprojects/1kg/1kg_pilot3/documents/CenterSpecificTargetLists/results/p3overlap.targets.b36.interval_list"
  var pilot1_interval_list: String = "/broad/shptmp/chartl/omni/resources/Omni_b36_sites.interval.list"
  var hiseq_interval_list: String = "/broad/shptmp/chartl/omni/resources/Omni_b36_sites.interval.list"
  var production_interval_list: String = "/broad/shptmp/chartl/omni/resources/Omni_b37_sites.chr20.interval.list"

  // REFERENCES
  var b36_ref = new File("/humgen/1kg/reference/human_b36_both.fasta")
  var b37_ref = new File("/humgen/1kg/reference/human_g1k_v37.fasta")

  // OTHER
  val analysis_dir = "/broad/shptmp/chartl/omni/"
  val resources_dir = analysis_dir + "resources/"
  val scratch_dir = analysis_dir + "scratch/"
  val eval_dir = analysis_dir + "eval/"
  val vcf_dir = analysis_dir + "vcfs/"
  val p1_ceu_only = scratch_dir+"Pilot1_CEU_only_sites.intervals.list"
  val p1_chbjpt_only = scratch_dir+"Pilot1_CHBJPT_only_sites.intervals.list"
  val p1_yri_only = scratch_dir+"Pilot1_YRI_only_sites.intervals.list"

  // OTHER CHIPS

  val OMNI_QUAD_1KG = new File("/humgen/gsa-scr1/chartl/projects/omni/resources_oct7/other_chips/1KG_OMNI.ref_fixed.vcf")
  val AFFY_6_0 = new File("/humgen/gsa-scr1/chartl/projects/omni/resources_oct7/other_chips/1KG_ARRAY.ref_fixed.vcf")

  trait OmniArgs extends CommandLineGATK {
    this.jarFile = new File("/humgen/gsa-scr1/chartl/sting/dist/GenomeAnalysisTK.jar")
  }

  class vcf2bed extends CommandLineFunction {
    @Input(doc="A VCF file to be put into an interval list") var in_vcf: File = _
    @Output(doc="An interval list file to be used with -L") var out_list: File = _

    def commandLine = "python /humgen/gsa-scr1/chartl/projects/omni/scripts/vcf2bed.py %s %s".format(in_vcf.getAbsolutePath,out_list.getAbsolutePath)
  }

  class GetSampleOverlap extends CommandLineFunction {
    @Input(doc="A list of VCF files for which to calculate the sample overlap") var in_vcfs: List[File] = Nil
    @Output(doc="A file to which to write the overlapping sample names") var outFile: File = _

    /*def commandLine = "grep #CHR %s | sed 's/.vcf:/\\t/g' | cut -f11- | tr '\\t' '\\n' | sort | uniq -c | awk '$1 == %d' | awk '{print $2}' > %s".format(
    in_vcfs.foldLeft[String]("")( (str,f) => if ( str.equals("") ) str + f.getAbsolutePath else str + " " + f.getAbsolutePath),
    in_vcfs.size,
    outFile.getAbsolutePath
    )*/
    def commandLine = "python /humgen/gsa-scr1/chartl/projects/omni/scripts/getOverlapSamples.py %s %s".format(
      in_vcfs.foldLeft[String]("")( (str,f) => if ( str.equals("") ) str + f.getAbsolutePath else str + " " + f.getAbsolutePath),
      outFile.getAbsolutePath
      )
  }

  class GunzipFile extends CommandLineFunction {
    @Input(doc="file to gunzip") var gunzipMe: File = _
    @Output(doc="file to gunzip to") var outFile: File = _

    def commandLine = "gunzip -c %s > %s".format(gunzipMe.getAbsolutePath,outFile.getAbsolutePath)
  }

  def script = {

    /** Convert other chips to merged VCFs **/

    //var august_call_other_chips: List[(String,File)] = processAuxiliaryChipData(august_calls_other_genotypes)


    /** Unzip the pilot 1 VCFs and dump them into the resources directory **/

    var gunzip_p1_ceu = new GunzipFile
    var gunzip_p1_chb = new GunzipFile
    var gunzip_p1_yri = new GunzipFile
    var gunzip_hiseq = new GunzipFile
    var gunzip_ag_eur = new GunzipFile
    var gunzip_ag_asn = new GunzipFile
    var gunzip_ag_afr = new GunzipFile

    gunzip_p1_ceu.gunzipMe = pilot1_ceu_vcf
    gunzip_p1_ceu.outFile = new File(resources_dir+"CEU.low_coverage.genotypes.vcf")
    gunzip_p1_chb.gunzipMe = pilot1_chb_vcf
    gunzip_p1_chb.outFile = new File(resources_dir+"CHB.low_coverage.genotypes.vcf")
    gunzip_p1_yri.gunzipMe = pilot1_yri_vcf
    gunzip_p1_yri.outFile = new File(resources_dir+"YRI.low_coverage.genotypes.vcf")
    gunzip_hiseq.gunzipMe = hiseq_calls_vcf
    gunzip_hiseq.outFile = new File(resources_dir+"HiSeq.b36.vcf")
    gunzip_ag_eur.gunzipMe = august_calls_EUR_refined
    gunzip_ag_eur.outFile = new File(resources_dir+"EUR.refined.vcf")
    gunzip_ag_asn.gunzipMe = august_calls_ASN_refined
    gunzip_ag_asn.outFile = new File(resources_dir+"ASN.refined.vcf")
    gunzip_ag_afr.gunzipMe = august_calls_AFR_refined
    gunzip_ag_afr.outFile = new File(resources_dir+"AFR.refined.vcf")

    add(gunzip_p1_ceu,gunzip_p1_yri,gunzip_p1_chb,gunzip_hiseq,gunzip_ag_eur,gunzip_ag_asn,gunzip_ag_afr)

    /** fix the omni ref bases **/
    var fix_421 = new FixRefBases with OmniArgs
    var fix_764 = new FixRefBases with OmniArgs
    var fix_764_b37 = new FixRefBases with OmniArgs

    fix_421.variantVCF = OMNI_hapmap_b36_vcf
    fix_421.reference_sequence = b36_ref
    fix_421.out = new File(vcf_dir+swapExt(OMNI_hapmap_b36_vcf.getName,".vcf",".ref_fixed.vcf"))
    fix_421.bypassException = true
    fix_764.variantVCF = OMNI_b36_vcf
    fix_764.reference_sequence = b36_ref
    fix_764.out = new File(vcf_dir+swapExt(OMNI_b36_vcf.getName,".vcf",".ref_fixed.vcf"))
    fix_764.bypassException = true
    fix_764_b37.variantVCF = OMNI_b37_vcf
    fix_764_b37.reference_sequence = b37_ref
    fix_764_b37.out = new File(vcf_dir+swapExt(OMNI_b37_vcf.getName,".vcf",".ref_fixed.vcf"))
    fix_764_b37.bypassException = true
    
    add(fix_421,fix_764,fix_764_b37)

    /** Propagate AC/AN annotations to Omni files via variant annotator **/       
    var annotate_421 = new VariantAnnotator with OmniArgs
    var annotate_764 = new VariantAnnotator with OmniArgs
    var annotate_764_b37 = new VariantAnnotator with OmniArgs

    annotate_421.variantVCF = OMNI_hapmap_b36_vcf
    annotate_421.reference_sequence = b36_ref
    annotate_421.annotation :+= "ChromosomeCounts"
    annotate_421.out = new File(vcf_dir+swapExt(annotate_421.variantVCF.getName,".vcf",".annot.vcf"))
    annotate_764.variantVCF = OMNI_b36_vcf
    annotate_764.reference_sequence = b36_ref
    annotate_764.annotation :+= "ChromosomeCounts"
    annotate_764.out = new File(vcf_dir+swapExt(annotate_764.variantVCF.getName,".vcf",".annot.vcf"))
    annotate_764_b37.variantVCF = OMNI_b37_vcf
    annotate_764_b37.reference_sequence = b37_ref
    annotate_764_b37.annotation :+= "ChromosomeCounts"
    annotate_764_b37.out = new File(vcf_dir+swapExt(annotate_764_b37.variantVCF.getName,".vcf",".annot.vcf"))

    add(annotate_421,annotate_764,annotate_764_b37)

    /** Eval the omni chip against the various comps **/
    runEval(annotate_764.out,gunzip_p1_ceu.outFile,"OMNI_764","Pilot1_CEU",pilot1_interval_list, b36_ref)
    runEval(annotate_421.out,gunzip_p1_ceu.outFile,"OMNI_421","Pilot1_CEU",pilot1_interval_list, b36_ref,true)
    //runEval(OMNI_hapmap_b36_vcf,gunzip_p1_ceu.outFile,"OMNI_421_Unfixed","Pilot1_CEU",pilot1_interval_list,b36_ref)
    runEval(annotate_764.out,gunzip_p1_chb.outFile,"OMNI_764","Pilot1_CHB",pilot1_interval_list, b36_ref)
    runEval(annotate_421.out,gunzip_p1_chb.outFile,"OMNI_421","Pilot1_CHB",pilot1_interval_list, b36_ref)
    runEval(annotate_764.out,gunzip_p1_yri.outFile,"OMNI_764","Pilot1_YRI",pilot1_interval_list, b36_ref)
    runEval(annotate_421.out,gunzip_p1_yri.outFile,"OMNI_421","Pilot1_YRI",pilot1_interval_list, b36_ref)
    runEval(annotate_764.out,pilot3_release_vcf,"OMNI_764","Pilot3",pilot3_interval_list, b36_ref)
    runEval(annotate_421.out,pilot3_release_vcf,"OMNI_421","Pilot3",pilot3_interval_list, b36_ref)
    runEval(annotate_764_b37.out,gunzip_ag_eur.outFile,"OMNI_764","August_EUR",production_interval_list, b37_ref)
    runEval(annotate_764_b37.out,gunzip_ag_asn.outFile,"OMNI_764","August_ASN",production_interval_list, b37_ref)
    runEval(annotate_764_b37.out,gunzip_ag_afr.outFile,"OMNI_764","Ausust_AFR",production_interval_list, b37_ref)
    runEval(annotate_764.out,gunzip_hiseq.outFile,"OMNI_764","HiSeq",hiseq_interval_list, b36_ref)
    runEval(annotate_764.out,annotate_421.out,"OMNI_764","OMNI_421_FIXED",pilot1_interval_list,b36_ref)
    runEval(annotate_764.out,OMNI_QUAD_1KG,"OMNI_764","OMNI_QUAD",pilot1_interval_list,b36_ref)
    runEval(annotate_764.out,AFFY_6_0,"OMNI_764","AFFY_6_0",pilot1_interval_list,b36_ref)
    runEval(OMNI_b37_birdseed,gunzip_ag_eur.outFile,"OMNI_birdseed","August_EUR",production_interval_list,b37_ref)
    runEval(OMNI_b37_joint,gunzip_ag_eur.outFile,"OMNI_joint","August_EUR",production_interval_list,b37_ref)
    runEval(OMNI_QUAD_1KG,gunzip_p1_ceu.outFile,"OMNI_QUAD_1KG","Pilot1_CEU",pilot1_interval_list,b36_ref)
    runEval(AFFY_6_0,gunzip_p1_ceu.outFile,"AFFY_6_0","Pilot1_CEU",pilot1_interval_list,b36_ref)

    var eval1KG_exclude = new VariantEval with OmniArgs
    eval1KG_exclude.samples :+= "/broad/shptmp/chartl/omni/scratch/OMNI_764_vs_Pilot3.sample_overlap.exclude.mixups.txt"
    eval1KG_exclude.rodBind :+= new RodBind("evalOMNI_764","VCF",annotate_764.out)
    eval1KG_exclude.rodBind :+= new RodBind("compPilot3","VCF",pilot3_release_vcf)
    eval1KG_exclude.evalModule :+= "GenotypeConcordance"
    eval1KG_exclude.evalModule :+= "SimpleMetricsBySample"
    eval1KG_exclude.reference_sequence = b36_ref
    eval1KG_exclude.reportType = VE2TemplateType.CSV
    eval1KG_exclude.intervalsString :+= pilot3_interval_list
    eval1KG_exclude.out = new File(eval_dir+"%s_vs_%s.%s".format("OMNI_764","Pilot3","exclude.mixups.eval.csv"))

    add(eval1KG_exclude)

    runAFComparison(annotate_764.out, gunzip_p1_ceu.outFile, gunzip_p1_chb.outFile, gunzip_p1_yri.outFile)

    var subset421: SelectVariants = new SelectVariants with OmniArgs
    subset421.reference_sequence = b36_ref
    subset421.sample :+= (new File(scratch_dir+"OMNI_421_vs_Pilot1_CEU.sample_overlap.txt")).getAbsolutePath
    subset421.variantVCF = annotate_764.out
    subset421.out = new File(vcf_dir+swapExt(annotate_764.out.getName,".vcf",".subset.pilot1CEU.vcf"))

    add(subset421)// lastly to find things in the three-way pilot venn

    var combine: CombineVariants = new CombineVariants with OmniArgs
    combine.reference_sequence = b36_ref
    combine.rodBind :+= new RodBind("CEU","VCF",gunzip_p1_ceu.outFile)
    combine.rodBind :+= new RodBind("ASN","VCF",gunzip_p1_chb.outFile)
    combine.rodBind :+= new RodBind("YRI","VCF",gunzip_p1_yri.outFile)
    combine.genotypeMergeOptions = VariantContextUtils.GenotypeMergeType.UNIQUIFY
    combine.priority = "%s,%s,%s".format("CEU","ASN","YRI")
    combine.out = new File(vcf_dir+"Pilot1_Populations_Combined.vcf")

    add(combine)

    selectSites(OMNI_b36_panel_vcf,p1_ceu_only,"ceu_only_sites")
    selectSites(OMNI_b36_panel_vcf,p1_chbjpt_only,"chbjpt_only_sites")
    selectSites(OMNI_b36_panel_vcf,p1_yri_only,"yri_only_sites")

    runBeagleAnalysis(new File(vcf_dir + "Illumina_HapMap_Omni_2.5_764samples.annot.stripped.vcf"))

  }

  def processAuxiliaryChipData(otherChips: File) : List[(String,File)] = {
    // todo ==== me
    return Nil
  }

  def runEval(eval: File, comp: File, eBase: String, cBase: String, intervals: String, reference: File, interesting: Boolean = false) = {
    var base = "%s_vs_%s".format(eBase,cBase)
    var getOverlap = new GetSampleOverlap
    getOverlap.in_vcfs :+= eval
    getOverlap.in_vcfs :+= comp
    getOverlap.outFile = new File(scratch_dir+base+".sample_overlap.txt")
    add(getOverlap)

    var vEval = new VariantEval with OmniArgs
    vEval.samples :+= getOverlap.outFile.getAbsolutePath
    vEval.rodBind :+= new RodBind("eval"+eBase,"VCF",eval)
    vEval.rodBind :+= new RodBind("comp"+cBase,"VCF",comp)
    vEval.evalModule :+= "GenotypeConcordance"
    vEval.evalModule :+= "SimpleMetricsBySample"
    vEval.intervalsString :+= intervals
    vEval.reference_sequence = reference
    vEval.reportType = VE2TemplateType.CSV

    vEval.out = new File(eval_dir+base+".eval.csv")

    if ( interesting ) {
      vEval.discordantInteresting = true
      vEval.outputVCF = new File(vcf_dir+"%s_vs_%s.interesting_sites.vcf".format(eBase,cBase))
    }

    add(vEval)

  }

  def swapExt(s: String, d: String, f: String) : String = {
    return s.stripSuffix(d)+f
  }

  def runAFComparison(omni: File, p1ceu: File, p1asn: File, p1yri:File ) : Boolean = {
    // step one, set up some of the info
    var populations : List[String] = Nil // these are the pilot 1 populations
    populations :+= "CEU"
    populations :+= "CHBJPT"
    populations :+= "YRI"
    var panels : List[String] = Nil // these are the analysis panels
    panels :+= "EUR"
    panels :+= "ASN"
    panels :+= "ASW"
    panels :+= "AFR"
    panels :+= "ADM"
    // step two -- subset the OMNI chip to the actual sample names
    var nameToSubset: HashMap[String,SelectVariants] = new HashMap[String,SelectVariants]
    for ( p <- populations ) {
      nameToSubset += p -> sampleSubset(p,omni)
    }

    for ( p <- panels ) {
      nameToSubset += p -> sampleSubset(p,omni)
    }

    // step three -- compare the pilot 1 files against all populations and panels
    
    runComps("Pilot1CEU",p1ceu,"CEU",nameToSubset("CEU").out)
    runComps("Pilot1CEU",p1ceu,"EUR",nameToSubset("EUR").out)
    runComps("Pilot1CHBJPT",p1asn,"CHBJPT",nameToSubset("CHBJPT").out)
    runComps("Pilot1CHBJPT",p1asn,"ASN",nameToSubset("ASN").out)
    runComps("Pilot1YRI",p1yri,"YRI",nameToSubset("YRI").out)
    runComps("Pilot1YRI",p1yri,"AFR",nameToSubset("AFR").out)
    runComps("EUR",nameToSubset("EUR").out,"AFR",nameToSubset("AFR").out)
    runComps("EUR",nameToSubset("EUR").out,"ASN",nameToSubset("ASN").out)
    runComps("EUR",nameToSubset("EUR").out,"ASW",nameToSubset("ASW").out)
    runComps("EUR",nameToSubset("EUR").out,"AMR",nameToSubset("ADM").out)


    var panelCombine: CombineVariants = new CombineVariants with OmniArgs
    panelCombine.reference_sequence = b36_ref
    panelCombine.priority = ""
    for ( p <- panels ) {
      panelCombine.rodBind :+= new RodBind(p,"VCF",nameToSubset(p).out)
      panelCombine.priority = if ( panelCombine.priority.equals("") ) p else panelCombine.priority + "," + p
    }
    panelCombine.out = OMNI_b36_panel_vcf
    panelCombine.genotypeMergeOptions = VariantContextUtils.GenotypeMergeType.REQUIRE_UNIQUE
    panelCombine.variantMergeOptions = VariantContextUtils.VariantMergeType.UNION
    panelCombine.setKey = "panel"

    add(panelCombine)
    return true

  }

  def getOmniSampleListByPanel(panel: String) : String = {
    return scratch_dir+"OMNI_764_%s.txt".format(panel)
  }

  def sampleSubset(panel: String, omni: File) : SelectVariants = {
    var sv : SelectVariants = new SelectVariants with OmniArgs
    sv.reference_sequence = b36_ref
    sv.variantVCF = omni
    sv.sample :+= getOmniSampleListByPanel(panel)
    sv.out = new File(vcf_dir+swapExt(omni.getName,".vcf",".%s.vcf".format(panel)))
    add(sv)
    return sv
  }

  def runComps(eBase: String, evalVCF: File, cBase: String, compVCF: File) = {
    var eval: VariantEval = new VariantEval with OmniArgs
    eval.reference_sequence = b36_ref
    eval.rodBind :+= new RodBind("eval%s".format(eBase),"VCF",evalVCF)
    eval.rodBind :+= new RodBind("comp%s".format(cBase),"VCF",compVCF)
    eval.noStandard = true
    eval.E :+= "AlleleFrequencyComparison"
    eval.reportType = VE2TemplateType.CSV
    eval.out = new File(eval_dir+"%s_vs_%s_allele_frequency.eval".format(eBase,cBase))

    add(eval)

    var combine: CombineVariants = new CombineVariants with OmniArgs
    combine.reference_sequence = b36_ref
    combine.rodBind :+= new RodBind(eBase,"VCF",evalVCF)
    combine.rodBind :+= new RodBind(cBase,"VCF",compVCF)
    combine.out = new File(vcf_dir+"%s_plus_%s.vcf".format(eBase,cBase))
    combine.genotypeMergeOptions = VariantContextUtils.GenotypeMergeType.UNIQUIFY
    combine.priority = "%s,%s".format(eBase,cBase)

    //add(combine)

  }

  def selectSites(vcf: File, intervals: String, base: String) {
    var sv = new SelectVariants with OmniArgs
    sv.reference_sequence = b36_ref
    sv.variantVCF = vcf
    sv.out = swapExt(vcf,".vcf",base+".vcf")
    sv.intervalsString :+= intervals

    add(sv)
  }

  def runBeagleAnalysis(omnivcf: File) {
    var combine : CombineVariants  = new CombineVariants with OmniArgs
    combine.reference_sequence = b36_ref
    for ( c <- 1 until 23) {
      combine.rodBind :+= new RodBind("beagle%s".format(c),"VCF",runBeagle(omnivcf,"%s".format(c)))
      if ( c > 1 ) {
        combine.priority = combine.priority+",%s%s".format("beagle",c)
      } else {
        combine.priority = "%s%s".format("beagle",c)
      }
    }
    combine.genotypeMergeOptions = VariantContextUtils.GenotypeMergeType.PRIORITIZE
    combine.variantMergeOptions = VariantContextUtils.VariantMergeType.UNION

    combine.out = swapExt(pilot1_with_na12878_vcf,".vcf",".beagle_refined_with_omni.vcf")

    add(combine)

    var select : SelectVariants = new SelectVariants with OmniArgs
    select.reference_sequence = b36_ref
    select.variantVCF = combine.out
    select.sample :+= "NA12878"
    select.out = new File(vcf_dir + "NA12878.lowpass.beagle.refined.with.pilot1.vcf")

    add(select)

    var eval : VariantEval = new VariantEval with OmniArgs
    eval.reference_sequence = b36_ref
    eval.rodBind :+= new RodBind("evalNA12878LowPass","VCF",select.out)
    eval.rodBind :+= new RodBind("compNA12878HiSeq","VCF",hiseq_calls_vcf)
    eval.E :+= "GenotypeConcordance"
    eval.out = new File(eval_dir+"NA12878.lowpass.beagle.vs.HiSeq.eval")
    eval.excludeIntervals :+= new File(pilot1_interval_list)
    eval.reportType = VE2TemplateType.CSV

    add(eval)

    var eval2: VariantEval = new VariantEval with OmniArgs
    eval2.reference_sequence = b36_ref
    eval2.rodBind :+= new RodBind("evalNA12878Beagle","VCF",pilot1_na12878_beagle)
    eval2.rodBind :+= new RodBind("compNA12878HiSeq","VCF",hiseq_calls_vcf)
    eval2.E :+= "GenotypeConcordance"
    eval2.sample :+= "NA12878"
    eval2.out = new File(eval_dir+"NA12878.lowpass.nochip.vs.Hiseq.eval")
    eval2.excludeIntervals :+= new File(pilot1_interval_list)
    eval2.reportType = VE2TemplateType.CSV

    add(eval2)

    var eval3: VariantEval = new VariantEval with OmniArgs
    eval3.reference_sequence = b36_ref
    eval3.rodBind :+= new RodBind("evalNA12878NoBeagle","VCF",pilot1_with_na12878_vcf)
    eval3.rodBind :+= new RodBind("compNA12878HiSeq","VCF",hiseq_calls_vcf)
    eval3.E :+= "GenotypeConcordance"
    eval3.sample :+= "NA12878"
    eval3.out = new File(eval_dir+"NA12878.lowpass.nochip.norefined.vs.Hiseq.eval")
    eval3.excludeIntervals :+= new File(pilot1_interval_list)
    eval3.reportType = VE2TemplateType.CSV

    add(eval3)
  }

  def runBeagle(omnivcf: File, chr: String): File = {
    var beagleInput = new ProduceBeagleInput with OmniArgs
    beagleInput.reference_sequence = b36_ref
    beagleInput.intervalsString :+= chr
    beagleInput.variantVCF = pilot1_with_na12878_vcf
    beagleInput.rodBind :+= new RodBind("validation","VCF",omnivcf)
    beagleInput.validation_genotype_ptrue = 0.99
    beagleInput.out = new File(scratch_dir+"/"+swapExt(beagleInput.variantVCF.getName,".vcf",".%s.beagle".format(chr)))
    println (beagleInput.out.getAbsolutePath)

    var runBeagle : BeagleRefinement = new BeagleRefinement
    runBeagle.beagleInput = beagleInput.out
    runBeagle.beagleOutputBase = "Pilot1_NA12878_Beagle_with_OMNI_chr%s".format(chr)
    runBeagle.beagleMemoryGigs = 6
    runBeagle.memoryLimit = 6
    runBeagle.beagleOutputDir = ""
    runBeagle.freezeOutputs

    var gunzipPhased = new GunzipFile
    gunzipPhased.gunzipMe = runBeagle.beaglePhasedFile
    gunzipPhased.outFile = new File(scratch_dir+swapExt(runBeagle.beaglePhasedFile.getName,".gz",""))

    var gunzipLike = new GunzipFile
    gunzipLike.gunzipMe = runBeagle.beagleLikelihoods
    gunzipLike.outFile = new File(scratch_dir+swapExt(runBeagle.beagleLikelihoods.getName,".gz",""))  


    var convertBack : BeagleOutputToVCF = new BeagleOutputToVCF with OmniArgs
    convertBack.reference_sequence = b36_ref
    convertBack.variantVCF = pilot1_with_na12878_vcf
    convertBack.intervalsString :+= chr
    convertBack.rodBind :+= new RodBind("beagleR2","beagle",runBeagle.beagleRSquared)
    convertBack.rodBind :+= new RodBind("beagleProbs","beagle",gunzipLike.outFile)
    convertBack.rodBind :+= new RodBind("beaglePhased","beagle",gunzipPhased.outFile)
    convertBack.out = new File(vcf_dir+swapExt(pilot1_with_na12878_vcf.getName,".vcf",".chr%s.beagle_refined_plus_omni.vcf".format(chr)))

    add(beagleInput,runBeagle,gunzipPhased,gunzipLike,convertBack)

    return convertBack.out
  }

  class BeagleRefinement extends CommandLineFunction {
    @Input(doc="The beagle input file") var beagleInput: File = _
    var beagleOutputBase: String = _
    var beagleMemoryGigs: Int = 4

    /**
     * Note: These get set
     */
    @Output(doc="The beagle phased file") var beaglePhasedFile: File = _
    @Output(doc="The beagle likelihood file") var beagleLikelihoods: File = _
    @Output(doc="The beagle r2 file") var beagleRSquared: File = _
    var beagleOutputDir: String = _

    def freezeOutputs = {
      if ( beagleOutputDir == null && beagleInput.getParent == null ) {
        beagleOutputDir = ""
      } else if ( beagleOutputDir == null ) {
        beagleOutputDir = beagleInput.getParent+"/"
      }
      beaglePhasedFile = new File(beagleOutputDir+beagleOutputBase+"."+beagleInput.getName+".phased.gz")
      beagleLikelihoods = new File(beagleOutputDir+beagleOutputBase+"."+beagleInput.getName+".gprobs.gz")
      beagleRSquared = new File(beagleOutputDir+beagleOutputBase+"."+beagleInput.getName+".r2")
    }

    def commandLine = "java -Djava.io.tmpdir=%s -Xmx%dg -jar /humgen/gsa-hpprojects/software/beagle/beagle.jar like=%s out=%s".format(beagleInput.getParent,beagleMemoryGigs,beagleInput.getAbsolutePath,beagleOutputBase)
  }
}
