/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 ("BROAD") and the LICENSEE and is effective at the date the downloading is completed ("EFFECTIVE DATE").
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
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system ("PHONE-HOME") which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2016 Broad Institute, Inc.
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


import org.broadinstitute.gatk.utils.commandline.Hidden
import org.broadinstitute.gatk.queue.extensions.gatk._
import org.broadinstitute.gatk.queue.QScript
import org.broadinstitute.gatk.tools.phonehome.GATKRunReport


  // ToDos:
  // reduce the scope of the datasets so the script is more nimble
  // create gold standard BAQ'd bam files, no reason to always do it on the fly

  // Analysis to add at the end of the script:
  // auto generation of the cluster plots
  // spike in NA12878 to the exomes and to the lowpass, analysis of how much of her variants are being recovered compared to single sample exome or HiSeq calls
  // produce Kiran's Venn plots based on comparison between new VCF and gold standard produced VCF


class VQSR_exome_sample_size_experiment extends QScript {
  qscript =>

  @Argument(shortName="gatk", doc="gatk jar file", required=true)
  var gatkJarFile: File = _
  

  val hg19 = new File("/seq/references/Homo_sapiens_assembly19/v1/Homo_sapiens_assembly19.fasta")  
  val hg18 = new File("/seq/references/Homo_sapiens_assembly18/v0/Homo_sapiens_assembly18.fasta")
  val b36 = new File("/humgen/1kg/reference/human_b36_both.fasta")
  val b37 = new File("/humgen/1kg/reference/human_g1k_v37.fasta")
  val dbSNP_hg18_129 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/dbSNP/dbsnp_129_hg18.rod"            // Special case for NA12878 collections that can't use 132 because they are part of it.
  val dbSNP_b36 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/dbSNP/dbsnp_129_b36.rod"
  val dbSNP_b37 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/dbSNP/dbsnp_132_b37.leftAligned.vcf"
  val dbSNP_b37_129 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/dbSNP/dbsnp_129_b37.leftAligned.vcf"              // Special case for NA12878 collections that can't use 132 because they are part of it.
  val hapmap_hg18 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/HapMap/3.3/sites_r27_nr.hg18_fwd.vcf"
  val hapmap_b36 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/HapMap/3.3/sites_r27_nr.b36_fwd.vcf"
  val hapmap_b37 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/HapMap/3.3/sites_r27_nr.b37_fwd.vcf"
  val training_hapmap_b37 = "/humgen/1kg/processing/pipeline_test_bams/hapmap3.3_training_chr20.vcf"
  val omni_b36 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/Omni2.5_chip/Omni25_sites_1525_samples.b36.vcf"
  val omni_b37 = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Validated/Omni2.5_chip/Omni25_sites_1525_samples.b37.vcf"
  val indelMask_b36 = "/humgen/1kg/processing/pipeline_test_bams/pilot1.dindel.mask.b36.bed"
  val indelMask_b37 = "/humgen/1kg/processing/pipeline_test_bams/pilot1.dindel.mask.b37.bed"
  val exome_targets = "/seq/references/HybSelOligos/whole_exome_agilent_1.1_refseq_plus_3_boosters/whole_exome_agilent_1.1_refseq_plus_3_boosters.Homo_sapiens_assembly19.targets.interval_list"
  val training_1kg_high_quality = "/humgen/1kg/processing/official_release/phase1/projectConsensus/phase1.wgs.projectConsensus.v2b.recal.highQuality.vcf"
  val training_1kg_terrible = "/humgen/1kg/processing/production_wgs_phase1/consensus_wgs/v2b/recal/phase1.wgs.projectConsensus.v2b.recal.terrible.vcf"

  val queueLogDir = ".qlog/"

  def script = {

    for (n <- List(1,5,10,20,30,40,50,60,70,80,96)) {
        var t = new File(n + ".tranches")
        var r = new File(n + ".recal")
        add(new VQSR(n, t, r))
        add(new applyVQSR(n, t, r))
  }
}

  trait UNIVERSAL_GATK_ARGS extends CommandLineGATK {
    jarFile = gatkJarFile;
    memoryLimit = 4;
  }

  // 3.) Variant Quality Score Recalibration - Generate Recalibration table
  class VQSR(n: Int, t: File, r: File) extends VariantRecalibrator with UNIVERSAL_GATK_ARGS {
    this.memoryLimit = 4
    this.reference_sequence = hg19
    this.intervalsString ++= List(exome_targets)
    this.rodBind :+= RodBind("input", "VCF", new File("/broad/shptmp/ebanks/WEx1000G_forRyan/Barcoded_1000G_WEx_Plate_1.cleaned.annotated.snps." + n + "sample" + (if(n>1) {"s"} else {""}) +".vcf") )
    this.rodBind :+= RodBind("hapmap", "VCF", hapmap_b37, "known=false,training=true,truth=true,prior=15.0")
    this.rodBind :+= RodBind("omni", "VCF", omni_b37, "known=false,training=true,truth=false,prior=12.0")
    this.rodBind :+= RodBind("1kg", "VCF", training_1kg_high_quality, "known=false,training=true,truth=false,prior=12.0")
    this.rodBind :+= RodBind("badSites", "VCF", training_1kg_terrible, "known=false,training=false,truth=false,prior=2.0,bad=true")
    this.rodBind :+= RodBind("dbsnp", "VCF", dbSNP_b37, "known=true,training=false,truth=false,prior=4.0")
    this.use_annotation ++= List("QD", "HaplotypeScore", "MQRankSum", "ReadPosRankSum", "MQ", "FS")
    if(n >= 10) {
      this.use_annotation ++= List("InbreedingCoeff")
    }
    this.tranches_file = t
    this.recal_file = r
    this.allPoly = true
    this.tranche ++= List("100.0", "99.9", "99.5", "99.3", "99.0", "98.9", "98.8", "98.5", "98.4", "98.3", "98.2", "98.1", "98.0", "97.9", "97.8", "97.5", "97.0", "95.0", "90.0")
    this.analysisName = n + "_VQSR"
    this.jobName =  queueLogDir + n + ".VQSR"
    this.mG = 5
    this.std = 14
    this.percentBad = 0.04
    this.nt = 5
}

  // 4.) Apply the recalibration table to the appropriate tranches
  class applyVQSR (n: Int, t: File, r: File) extends ApplyRecalibration with UNIVERSAL_GATK_ARGS {
    this.memoryLimit = 4
    this.reference_sequence = hg19
    this.intervalsString ++= List(exome_targets)
    this.rodBind :+= RodBind("input", "VCF", new File("/broad/shptmp/ebanks/WEx1000G_forRyan/Barcoded_1000G_WEx_Plate_1.cleaned.annotated.snps." + n + "sample" + (if(n>1) {"s"} else {""}) +".vcf") )
    this.tranches_file = t
    this.recal_file = r
    this.ts_filter_level = 99.0
    this.out = new File("snps." + n + "sample" + (if(n>1) {"s"} else {""}) +".vcf")
    this.analysisName = n + "_AVQSR"
    this.jobName =  queueLogDir + n + ".applyVQSR"
  }

}
