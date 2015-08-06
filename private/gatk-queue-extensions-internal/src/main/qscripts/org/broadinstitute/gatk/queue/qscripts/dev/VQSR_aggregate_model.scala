/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 (“BROAD”) and the LICENSEE and is effective at the date the downloading is completed (“EFFECTIVE DATE”).
* 
* WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
* WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
* NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
* 
* 1. DEFINITIONS
* 1.1 PROGRAM shall mean copyright in the object code and source code known as GATK3 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute.org/gatk on the EFFECTIVE DATE.
* 
* 2. LICENSE
* 2.1 Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. LICENSEE hereby automatically grants to BROAD a non-exclusive, royalty-free, irrevocable license to any LICENSEE bug fixes or modifications to the PROGRAM with unlimited rights to sublicense and/or distribute.  LICENSEE agrees to provide any such modifications and bug fixes to BROAD promptly upon their creation.
* The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only. For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
* 2.2 No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD. LICENSEE shall ensure that all of its users agree to the terms of this Agreement. LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
* 2.3 License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.
* 
* 3. PHONE-HOME FEATURE
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system (“PHONE-HOME”) which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2015 Broad Institute, Inc.
* Notice of attribution: The GATK3 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
* LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
* 
* 5. INDEMNIFICATION
* LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
* 
* 6. NO REPRESENTATIONS OR WARRANTIES
* THE PROGRAM IS DELIVERED AS IS. BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
* IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
* 
* 7. ASSIGNMENT
* This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
* 
* 8. MISCELLANEOUS
* 8.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
* 8.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
* 8.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
* 8.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested. All notices under this Agreement shall be deemed effective upon receipt.
* 8.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter.
* 8.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
* 8.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.gatk.queue.qscripts.dev

import org.broadinstitute.gatk.queue.QScript
import org.broadinstitute.gatk.queue.extensions.gatk._
import org.broadinstitute.gatk.tools.phonehome.GATKRunReport
import org.broadinstitute.gatk.queue.util.QScriptUtils
import org.broadinstitute.gatk.queue.function._
import org.broadinstitute.gatk.utils.variant.GATKVariantContextUtils.FilteredRecordMergeType
import org.broadinstitute.gatk.utils.variant.GATKVariantContextUtils.MultipleAllelesMergeType
import htsjdk.variant.variantcontext.VariantContext
import org.broadinstitute.gatk.utils.commandline.ClassType

class VQSR_aggregate_model extends QScript {

  @Argument(shortName = "L",  required=false, doc = "Intervals file")
  var intervalsFile: List[File] = Nil
  @Argument(shortName = "I",  required=true, doc = "Input bam list")
  var bamList: File = new File("")
  @Argument(shortName = "o",  required=true, doc = "Output directory")
  var outputDir: String = ""
  @Argument(shortName = "sc",  required=false, doc = "base scatter count for an HC job")
  var scatterHC: Int = 2


val latestdbSNP = "/humgen/gsa-hpprojects/GATK/bundle/current/b37/dbsnp_138.b37.vcf"  // Best Practices v4
  val hapmapSites = "/humgen/gsa-hpprojects/GATK/bundle/current/b37/hapmap_3.3.b37.vcf"                       // Best Practices v4
  val hapmapGenotypes = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/HapMap/3.3/genotypes_r27_nr.b37_fwd.vcf"                       // Best Practices v4
  val omni_b37_sites = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/Omni2.5_chip/Omni25_sites_2141_samples.b37.vcf"    // Best Practices v4
  val omni_b37_genotypes = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/Omni2.5_chip/Omni25_genotypes_2141_samples.b37.vcf"    // Best Practices v4
  val training_1000G = "/humgen/1kg/processing/official_release/phase1/projectConsensus/phase1.wgs.projectConsensus.v2b.recal.highQuality.vcf"  // from the MethodDevelopmentCallingPipeline scala script
  val indelGoldStandardCallset  = "/humgen/gsa-hpprojects/GATK/bundle/current/b37/Mills_and_1000G_gold_standard.indels.b37.vcf" // Best Practices v4
  val dbSNP_129 = "/humgen/gsa-hpprojects/GATK/data/dbsnp_129_b37.vcf"
  val omni_mono: String = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/Omni2.5_chip/Omni25_monomorphic_2141_samples.b37.vcf"

  val excludeComplexIntervals: File = new File("/humgen/gsa-hpprojects/NA12878Collection/knowledgeBase/complexRegions.doNotAssess.interval_list")
  val okayToMissWEx: File = new File("/humgen/gsa-hpprojects/dev/Tableau/rawCallingTest/okayToMiss.WEX.vcf")
  val okayToMissPCRplus: File = new File("/humgen/gsa-hpprojects/dev/Tableau/rawCallingTest/okayToMiss.PCR+.vcf")
  val okayToMissPCRfree: File = new File("/humgen/gsa-hpprojects/dev/Tableau/rawCallingTest/okayToMiss.PCR-.vcf")

  val axiom_bad: File = new File("/humgen/gsa-hpprojects/dev/rpoplin/randomForest/trainingSets/Axiom_Exome_Plus.genotypes.all_populations.monomorphic.biallelic.vcf")
  val axiom_good: File = new File("/humgen/gsa-hpprojects/dev/rpoplin/randomForest/trainingSets/Axiom_Exome_Plus.genotypes.all_populations.poly.vcf")
  val omni_bad: File = new File("/humgen/gsa-hpprojects/dev/rpoplin/randomForest/trainingSets/Omni25_monomorphic_2141_samples.b37.vcf")

  def script() {

  // Single Sample Calling with HC
  val singleSampleBams = QScriptUtils.createSeqFromFile(bamList)
  for( bamIndex <- 0 until singleSampleBams.size ) {
        val singleSampleBam = singleSampleBams(bamIndex)
        val sshcVCF = swapExt(singleSampleBam, ".bam", ".vcf")
        recalibrateSNPsAndIndels( sshcVCF, false, singleSampleBams )
      }
  }

  trait BaseCommandArguments extends CommandLineGATK with RetryMemoryLimit {
    this.logging_level = "INFO"
    this.reference_sequence = new File("/humgen/1kg/reference/human_g1k_v37_decoy.fasta")
    this.intervalsString = intervalsFile
    this.memoryLimit = 2
  }


  /****************************************************************************************
  *                3.)   VariantRecalibrator                                              *
  *****************************************************************************************/

    class VQSRBase(vcf:File) extends VariantRecalibrator with BaseCommandArguments {
      this.input :+= vcf
      //this.nt = 4
      this.allPoly = true
      this.tranche ++= List("100.0", "99.9", "99.8", "99.7", "99.5", "99.3", "99.0", "98.5", "98.0", "97.0", "95.0", "90.0")
      this.memoryLimit = 18
      this.tranches_file = swapExt(outputDir, vcf, ".vcf", ".tranches")
      this.recal_file = swapExt(outputDir, vcf, ".vcf", ".recal")
      //this.rscript_file = swapExt(outputDir, vcf, ".vcf", ".vqsr.R")
    }

    // 3a)
    class snpRecal(snpVCF: File, useUGAnnotations: Boolean) extends VQSRBase(snpVCF) with BaseCommandArguments{
      this.resource :+= new TaggedFile( hapmapSites, "known=false,training=true,truth=true,prior=15.0" )
      this.resource :+= new TaggedFile( omni_b37_sites, "known=false,training=true,truth=true,prior=12.0" ) // truth=false on the bast practices v4
      this.resource :+= new TaggedFile( training_1000G, "known=false,training=true,truth=false,prior=10.0" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( axiom_good, "known=false,training=true,truth=false,prior=9.0" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( axiom_bad, "bad=true" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( omni_bad, "bad=true" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( dbSNP_129, "known=true,training=false,truth=false,prior=2.0" )    // prior=6.0 on the bast practices v4
      this.resource :+= new TaggedFile( latestdbSNP, "known=false,training=false,truth=false,prior=7.0" )    // prior=6.0 on the bast practices v4
      this.use_annotation ++= List("QD", "FS", "ReadPosRankSum", "MQRankSum", "MQ", "HaplotypeScore", "InbreedingCoeff")
      this.mode = org.broadinstitute.gatk.tools.walkers.variantrecalibration.VariantRecalibratorArgumentCollection.Mode.SNP
      this.maxGaussians = 6
      this.maxNumTrainingData = 4000000
      this.analysisName = "VQSR"
    }

    // 3b)
    class indelRecal(indelVCF: String, useUGAnnotations: Boolean) extends VQSRBase(indelVCF) with BaseCommandArguments {
      this.resource :+= new TaggedFile( indelGoldStandardCallset, "known=false,training=true,truth=true,prior=12.0" ) // known=true on the bast practices v4
      this.resource :+= new TaggedFile( axiom_good, "known=false,training=true,truth=false,prior=8.0" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( axiom_bad, "bad=true" )	// not part of the bast practices v4
      this.resource :+= new TaggedFile( latestdbSNP, "known=true,prior=2.0" )  						// not part of the bast practices v4
      this.mode = org.broadinstitute.gatk.tools.walkers.variantrecalibration.VariantRecalibratorArgumentCollection.Mode.INDEL
      this.use_annotation ++= List("FS", "ReadPosRankSum", "MQRankSum", "QD", "InbreedingCoeff")
      this.maxGaussians = 6
      this.maxNumTrainingData = 4000000
      this.analysisName = "VQSR"
    }

    /****************************************************************************************
      *               4.) Apply the recalibration table to the appropriate tranches         *
      ***************************************************************************************/

    class applyVQSRBase(vqsr: VariantRecalibrator) extends ApplyRecalibration with BaseCommandArguments  {
      val in = vqsr.input(0)
      this.input :+= in
      this.tranches_file = vqsr.tranches_file
      this.recal_file = vqsr.recal_file
      this.memoryLimit = 6
      this.out = swapExt(outputDir, in, ".unfiltered.vcf", ".recalibrated.vcf")
    }

    class applySnpVQSR(vqsr: VariantRecalibrator, useUGAnnotations: Boolean) extends applyVQSRBase(vqsr) with BaseCommandArguments {
      this.mode = org.broadinstitute.gatk.tools.walkers.variantrecalibration.VariantRecalibratorArgumentCollection.Mode.SNP
      this.ts_filter_level = 99.7
      if(useUGAnnotations)
        this.ts_filter_level = 99.5
      this.analysisName = "VQSR"
    }

    class applyIndelVQSR(vqsr: VariantRecalibrator, useUGAnnotations: Boolean) extends applyVQSRBase(vqsr) with BaseCommandArguments {
      this.mode = org.broadinstitute.gatk.tools.walkers.variantrecalibration.VariantRecalibratorArgumentCollection.Mode.INDEL
      this.ts_filter_level = 99.3
      if(useUGAnnotations)
        this.ts_filter_level = 99.3
      this.analysisName = "VQSR"
    }

    def recalibrateSNPsAndIndels(snpsAndIndelsVCF: File, useUGAnnotations: Boolean, aggregateFiles: Seq[File]): File = {
      val selectSNPs = new SelectVariants with BaseCommandArguments
      selectSNPs.V = snpsAndIndelsVCF
      selectSNPs.selectType = List(VariantContext.Type.SNP)
      selectSNPs.out = swapExt(outputDir, snpsAndIndelsVCF, ".vcf", ".snps.vcf")
      selectSNPs.isIntermediate = true
      selectSNPs.analysisName = "VQSR"

      val selectIndels = new SelectVariants with BaseCommandArguments
      selectIndels.V = snpsAndIndelsVCF
      selectIndels.selectType = List(VariantContext.Type.INDEL, VariantContext.Type.MIXED, VariantContext.Type.MNP, VariantContext.Type.SYMBOLIC)
      selectIndels.out = swapExt(outputDir, snpsAndIndelsVCF, ".vcf", ".indels.vcf")
      selectIndels.isIntermediate = true
      selectIndels.analysisName = "VQSR"

      val snpRecalibrator = new snpRecal(selectSNPs.out, useUGAnnotations)
      val snpApplyVQSR = new applySnpVQSR(snpRecalibrator, useUGAnnotations)
      snpApplyVQSR.isIntermediate = true
      val indelRecalibrator = new indelRecal(selectIndels.out, useUGAnnotations)
      val indelApplyVQSR = new applyIndelVQSR(indelRecalibrator, useUGAnnotations)
      indelApplyVQSR.isIntermediate = true

      val recal = swapExt(outputDir, snpsAndIndelsVCF, ".unfiltered.vcf", ".recalibrated.vcf")
      val combineSNPsIndels = new CombineSNPsIndels(snpApplyVQSR.out, indelApplyVQSR.out)
      combineSNPsIndels.out = recal

      val roc = new ROCCurveNA12878 with BaseCommandArguments
      roc.project = "alone"
      roc.V = combineSNPsIndels.out
      roc.out = swapExt(combineSNPsIndels.out, ".vcf", ".dat")




      val selectSNPs_agg = new SelectVariants with BaseCommandArguments
      selectSNPs_agg.V = snpsAndIndelsVCF
      selectSNPs_agg.selectType = List(VariantContext.Type.SNP)
      selectSNPs_agg.out = swapExt(outputDir, snpsAndIndelsVCF, ".vcf", ".aggregate.snps.vcf")
      selectSNPs_agg.isIntermediate = true
      selectSNPs_agg.analysisName = "VQSR"

      val selectIndels_agg = new SelectVariants with BaseCommandArguments
      selectIndels_agg.V = snpsAndIndelsVCF
      selectIndels_agg.selectType = List(VariantContext.Type.INDEL, VariantContext.Type.MIXED, VariantContext.Type.MNP, VariantContext.Type.SYMBOLIC)
      selectIndels_agg.out = swapExt(outputDir, snpsAndIndelsVCF, ".vcf", ".aggregate.indels.vcf")
      selectIndels_agg.isIntermediate = true
      selectIndels_agg.analysisName = "VQSR"

      val snpRecalibrator_agg = new snpRecal(selectSNPs_agg.out, useUGAnnotations)
      val snpApplyVQSR_agg = new applySnpVQSR(snpRecalibrator_agg, useUGAnnotations)
      snpApplyVQSR_agg.isIntermediate = true
      val indelRecalibrator_agg = new indelRecal(selectIndels_agg.out, useUGAnnotations)
      val indelApplyVQSR_agg = new applyIndelVQSR(indelRecalibrator_agg, useUGAnnotations)
      indelApplyVQSR_agg.isIntermediate = true

      for( bamIndex <- 0 until aggregateFiles.size ) {
        val singleSampleBam = aggregateFiles(bamIndex)
        val sshcVCF = swapExt(singleSampleBam, ".bam", ".vcf")
        if( !sshcVCF.getName().equals(snpsAndIndelsVCF.getName()) ) {
          snpRecalibrator_agg.aggregate :+= sshcVCF
          indelRecalibrator_agg.aggregate :+= sshcVCF
        }
      }

      val recal_agg = swapExt(outputDir, snpsAndIndelsVCF, ".unfiltered.vcf", ".recalibrated.aggregate.vcf")
      val combineSNPsIndels_agg = new CombineSNPsIndels(snpApplyVQSR_agg.out, indelApplyVQSR_agg.out)
      combineSNPsIndels_agg.out = recal_agg

      val roc_agg = new ROCCurveNA12878 with BaseCommandArguments
      roc_agg.project = "aggregate"
      roc_agg.V = combineSNPsIndels_agg.out
      roc_agg.out = swapExt(combineSNPsIndels_agg.out, ".vcf", ".dat")



      add(selectSNPs, selectIndels, snpRecalibrator, snpApplyVQSR, indelRecalibrator, indelApplyVQSR, combineSNPsIndels, roc)
      add(selectSNPs_agg, selectIndels_agg, snpRecalibrator_agg, snpApplyVQSR_agg, indelRecalibrator_agg, indelApplyVQSR_agg, combineSNPsIndels_agg, roc_agg)

      return recal
    }

    /****************************************************************************************
      *               5) Combine Snps and Indels for UG if mode == BOTH                       *
      *****************************************************************************************/

    class CombineSNPsIndels(snpVCF:File, indelVCF:File) extends CombineVariants with BaseCommandArguments {
      this.variant :+= TaggedFile(new File(snpVCF), "snps")
      this.variant :+= TaggedFile(new File(indelVCF), "indels")
      this.filteredrecordsmergetype = FilteredRecordMergeType.KEEP_IF_ANY_UNFILTERED
      this.assumeIdenticalSamples = true
      this.setKey = "null"
      this.analysisName = "VQSR"
    }
}