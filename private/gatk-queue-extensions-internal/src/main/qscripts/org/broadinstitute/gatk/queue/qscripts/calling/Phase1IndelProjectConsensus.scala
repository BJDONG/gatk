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

package org.broadinstitute.gatk.queue.qscripts.calling

import org.broadinstitute.gatk.queue.extensions.gatk._
import org.broadinstitute.gatk.queue.extensions.gatk.TaggedFile._
import org.broadinstitute.gatk.queue.{QException, QScript}

class Phase1IndelProjectConsensus extends QScript {
  qscript =>

  @Input(doc="path to GATK jar", shortName="gatk", required=true)
  var gatkJar: File = _

  @Input(doc="output path", shortName="outputDir", required=true)
  var outputDir: String = _

  @Input(doc="queue", shortName="queue", required=true)
  var jobQueue: String = _

  @Input(doc="the chromosome to process", shortName="onlyOneChr", required=false)
  var onlyOneChr: Boolean = false

  @Input(doc="the chromosome to process", shortName="chrToProcess", required=false)
  var chrToProcess: Int = 20

  @Input(doc="the chromosome to process", shortName="indelsOnly", required=false)
  var indelsOnly: Boolean = false

  @Input(doc="path to tmp space for storing intermediate bam files", shortName="outputTmpDir", required=true)
  var outputTmpDir: String = "/broad/shptmp/delangel"

  @Input(doc="Generate bam files", shortName="generateBAMs", required=false)
  var generateBAMs: Boolean = false
  @Input(doc="Generate bam files", shortName="createTargets", required=false)
  var createTargets: Boolean = false

  @Input(doc="indel alleles", shortName="indelAlleles", required=false)
  var indelAlleles: String = "/humgen/1kg/processing/production_wgs_phase1/consensus/ALL.indels.combined.chr20.vcf"

  @Input(doc="nt", shortName="nt", required=false)
  var nt: Int = 1


  private val reference: File = new File("/humgen/1kg/reference/human_g1k_v37.fasta")
  private val dbSNP: File = new File("/humgen/gsa-hpprojects/GATK/data/dbsnp_132_b37.leftAligned.vcf")
  private val dindelCalls: String = "/humgen/gsa-hpprojects/GATK/data/Comparisons/Unvalidated/AFR+EUR+ASN+1KG.dindel_august_release_merged_pilot1.20110126.sites.vcf"
  val chromosomeLength = List(249250621,243199373,198022430,191154276,180915260,171115067,159138663,146364022,141213431,135534747,135006516,133851895,115169878,107349540,102531392,90354753,81195210,78077248,59128983,63025520,48129895,51304566,155270560)
  //  val chromosomeLength = List(249250621,243199373,198022430,191154276,180915260,171115067,159138663,146364022,141213431,135534747,135006516,133851895,115169878,107349540,102531392,90354753,81195210,78077248,59128983,3000000,48129895,51304566,155270560)
  val populations = List("ASW","CEU","CHB","CHS","CLM","FIN","GBR","IBS","JPT","LWK","MXL","PUR","TSI","YRI")
  private val snpAlleles: String = "/humgen/1kg/processing/production_wgs_phase1/consensus/ALL.phase1.wgs.union.pass.sites.vcf"

  private val subJobsPerJob:Int = 1


  trait CommandLineGATKArgs extends CommandLineGATK {
    this.jarFile = qscript.gatkJar
    this.reference_sequence = qscript.reference
    this.memoryLimit = Some(2)
    this.jobQueue = qscript.jobQueue

  }

  class AnalysisPanel(val baseName: String, val pops: List[String], val jobNumber: Int, val subJobNumber: Int, val chr: String) {
    val rawVCFindels = new File(qscript.outputDir + "/calls/chr" + chr + "/" + baseName + "/" + baseName + ".phase1.chr" + chr + "." + subJobNumber + ".raw.indels.vcf")

    val callIndels = new UnifiedGenotyper with CommandLineGATKArgs
    callIndels.out = rawVCFindels
    callIndels.dcov = 50
    callIndels.stand_call_conf = 4.0
    callIndels.stand_emit_conf = 4.0
    callIndels.baq = org.broadinstitute.gatk.utils.baq.BAQ.CalculationMode.OFF
    callIndels.jobName = qscript.outputTmpDir + "/calls/chr" + chr + "/" +baseName + ".phase1.chr" + chr + "." + subJobNumber + ".raw.indels"
    callIndels.glm = org.broadinstitute.gatk.tools.walkers.genotyper.GenotypeLikelihoodsCalculationModel.Model.INDEL
    callIndels.genotyping_mode = org.broadinstitute.gatk.tools.walkers.genotyper.GenotypeLikelihoodsCalculationModel.GENOTYPING_MODE.GENOTYPE_GIVEN_ALLELES
    callIndels.out_mode = org.broadinstitute.gatk.tools.walkers.genotyper.UnifiedGenotypingEngine.OUTPUT_MODE.EMIT_ALL_SITES
    callIndels.alleles = qscript.indelAlleles
    callIndels.dbsnp = qscript.dbSNP
    //callIndels.A ++= List("TechnologyComposition")
    callIndels.sites_only = false

    //    callIndels.BTI = "alleles"
    callIndels.ignoreSNPAlleles = true
    callIndels.nt=Some(qscript.nt)
  }

  class Chromosome(val inputChr: Int) {
    var chr: String = inputChr.toString
    if(inputChr == 23) { chr = "X" }

    val indelCombine = new CombineVariants with CommandLineGATKArgs
    val indelChrVCF = new File(qscript.outputDir + "/calls/" + "combined.phase1.chr" + chr + ".raw.indels.vcf")
    indelCombine.out = indelChrVCF
    indelCombine.intervalsString :+= chr
    indelCombine.jobName = qscript.outputDir + "/calls/" + "combined.phase1.chr" + chr + ".raw.indels"
    indelCombine.memoryLimit = Some(4)
  }

  def script = {

//    var chrList =  List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23)
    var chrList =  List(1,2)
    if (qscript.onlyOneChr) {
      chrList = List(qscript.chrToProcess)
    }
    for(chr <- chrList) {
      val chrObject = new Chromosome(chr)
      var basesPerSubJob: Int = 3000000/qscript.subJobsPerJob

      val lastBase: Int = qscript.chromosomeLength(chr - 1)
      var start: Int = 1
      var stop: Int = start - 1 + basesPerSubJob
      if( stop > lastBase ) { stop = lastBase }
      var subJobNumber: Int = 1
      while( subJobNumber < (lastBase.toFloat / basesPerSubJob.toFloat) + 1.0) {
        if( chr != 23 ) {
          callThisChunk("%d:%d-%d".format(chr, start, stop), subJobNumber, chr, chrObject)

        }
        else {
          callThisChunk("X:%d-%d".format(start, stop), subJobNumber, chr, chrObject)
        }
        start += basesPerSubJob
        stop += basesPerSubJob
        if( stop > lastBase ) { stop = lastBase }
        subJobNumber += 1
      }

      add(chrObject.indelCombine)

    }
  }

   def callThisChunk(interval: String, subJobNumber: Int, inputChr: Int, chrObject: Chromosome) = {

    var chr: String = inputChr.toString
    if(inputChr == 23) { chr = "X" }



    var jobNumber = ( ( subJobNumber -1)  / qscript.subJobsPerJob  ) + 1

    val AFRadmix = new AnalysisPanel("AFR.admix", List("LWK","YRI","ASW","CLM","PUR"), jobNumber, subJobNumber, chr)
    val AMRadmix = new AnalysisPanel("AMR.admix", List("MXL","CLM","PUR","ASW"), jobNumber, subJobNumber, chr)
    val EURadmix = new AnalysisPanel("EUR.admix", List("CEU","FIN","GBR","TSI","IBS","MXL","CLM","PUR","ASW"), jobNumber, subJobNumber, chr)
    val ASNadmix = new AnalysisPanel("ASN.admix", List("CHB","CHS","JPT","MXL","CLM","PUR"), jobNumber, subJobNumber, chr)
    val AFR = new AnalysisPanel("AFR", List("LWK","YRI","ASW"), jobNumber, subJobNumber, chr)
    val AMR = new AnalysisPanel("AMR", List("MXL","CLM","PUR"), jobNumber, subJobNumber, chr)
    val EUR = new AnalysisPanel("EUR", List("CEU","FIN","GBR","TSI","IBS"), jobNumber, subJobNumber, chr)
    val ASN = new AnalysisPanel("ASN", List("CHB","CHS","JPT"), jobNumber, subJobNumber, chr)
    val ALL = new AnalysisPanel("ALL", List("LWK","YRI","ASW","MXL","CLM","PUR","CEU","FIN","GBR","TSI","IBS","CHB","CHS","JPT"), jobNumber, subJobNumber, chr)

    //val analysisPanels = List(AFR, ASN, AMR, EUR, AFRadmix, ASNadmix, AMRadmix, EURadmix) //ALL
    val analysisPanels = List(AFR, ASN, AMR, EUR) //ALL

    val indelCombine = new CombineVariants with CommandLineGATKArgs
    val combinedIndelChunk = new File(qscript.outputDir + "/calls/chr" + chr + "/" + "combined.phase1.chr" + chr + "." + subJobNumber + ".raw.indels.vcf")

    indelCombine.out = combinedIndelChunk
    indelCombine.jobName = qscript.outputTmpDir + "/calls/chr" + chr + "/" + "combined.phase1.chr" + chr + "." + subJobNumber + ".raw.indels"
    indelCombine.intervalsString :+= interval
    indelCombine.mergeInfoWithMaxAC = true
    //indelCombine.priority = "AFR.admix,AMR.admix,EUR.admix,ASN.admix,AFR,AMR,EUR,ASN" //ALL,
    indelCombine.sites_only = false

    indelCombine.priority = "AFR,AMR,EUR,ASN" //ALL,


    for( population <- qscript.populations ) {
      val baseTmpName: String = qscript.outputTmpDir + "/calls/chr" + chr + "/" + population + ".phase1.chr" + chr + "." + jobNumber.toString + "."
      //     val cleanedBam = new File(baseTmpName + "cleaned.bam")
      var cleanedBam = new File("/humgen/1kg/phase1_cleaned_bams/bams/chr" + chr + "/" + population + ".phase1.chr"+chr + "." +jobNumber.toString+".cleaned.bam")
      if (chr.equals("1") || chr.equals("2")) {
        cleanedBam = new File("/broad/shptmp/temporary_1000G_bams/chr" + chr + "/" + population + ".phase1.chr"+chr + "." +jobNumber.toString+".cleaned.bam")
      }
      for( a <- analysisPanels ) {
        for( p <- a.pops) {
          if( p == population ) {
            a.callIndels.input_file :+= cleanedBam
          }
        }
      }
    }

    for( a <- analysisPanels ) {
      // use BTI with indels
      a.callIndels.intervalsString :+= interval

      if(a.baseName == "ALL") {
        a.callIndels.memoryLimit = 4
      }

      add(a.callIndels)

      indelCombine.variant :+= TaggedFile(a.callIndels.out, a.baseName)
    }

    add(indelCombine)

    chrObject.indelCombine.variant :+= TaggedFile( indelCombine.out,"ALL" + subJobNumber.toString)
  }
}
