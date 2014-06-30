/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.gatk.tools.walkers.genotyper;

import htsjdk.samtools.util.BlockCompressedInputStream;
import htsjdk.tribble.readers.AsciiLineReader;
import org.broadinstitute.gatk.engine.walkers.WalkerTest;
import org.broadinstitute.gatk.engine.GenomeAnalysisEngine;
import org.broadinstitute.gatk.utils.exceptions.UserException;
import org.broadinstitute.gatk.utils.variant.GATKVCFUtils;
import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.VariantContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// ********************************************************************************** //
// Note that this class also serves as an integration test for the VariantAnnotator!  //
// ********************************************************************************** //

public class UnifiedGenotyperIntegrationTest extends WalkerTest {

    private final static String baseCommand = "-T UnifiedGenotyper --contamination_fraction_to_filter 0.05 --disableDithering -R " + b36KGReference + " --no_cmdline_in_header -glm BOTH -minIndelFrac 0.0 --dbsnp " + b36dbSNP129;
    private final static String baseCommandNoCmdLineHeaderStdout = "-T UnifiedGenotyper --contamination_fraction_to_filter 0.05 --disableDithering -R " + b37KGReference + " --no_cmdline_in_header -I " + privateTestDir + "bamExample.ReducedRead.ADAnnotation.bam";

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing parameters
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test
    public void testMinBaseQualityScore() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 --min_base_quality_score 26", 1,
                Arrays.asList("30be17df00acc8a92223f51fe7c1bdf7"));
        executeTest("test min_base_quality_score 26", spec);
    }

    @Test
    public void testSLOD() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                "-T UnifiedGenotyper --disableDithering -R " + b36KGReference + " --computeSLOD --no_cmdline_in_header -glm BOTH --dbsnp " + b36dbSNP129 + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000", 1,
                Arrays.asList("bc8a4e4ceb46776169b47146805c882a"));
        executeTest("test SLOD", spec);
    }

    @Test
    public void testNDA() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " --annotateNDA -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000", 1,
                Arrays.asList("17f65eca1e6c1f06919a58f230b6d8d3"));
        executeTest("test NDA", spec);
    }

    @Test
    public void testCompTrack() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                "-T UnifiedGenotyper --disableDithering -R " + b36KGReference + " --no_cmdline_in_header -glm BOTH -comp:FOO " + b36dbSNP129 + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000", 1,
                Arrays.asList("21185d9a7519356ba672757f5a522971"));
        executeTest("test using comp track", spec);
    }

    @Test(enabled = false) // EB: for some reason this test crashes whenever I run it on my local machine
    public void testNoCmdLineHeaderStdout() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommandNoCmdLineHeaderStdout + " -glm INDEL -L 1:67,225,396-67,288,518", 0,
                Collections.<String>emptyList());
        executeTest("testNoCmdLineHeaderStdout", spec);
    }

    @Test
    public void testOutputParameterSitesOnly() {
        testOutputParameters("-sites_only", "48cd40d3994911a6f2609bfd375e1d2d");
    }

    @Test
    public void testOutputParameterAllConfident() {
        testOutputParameters("--output_mode EMIT_ALL_CONFIDENT_SITES", "28f40ce47651f504158fc4e5bb58df4b");
    }

    @Test
    public void testOutputParameterAllSites() {
        testOutputParameters("--output_mode EMIT_ALL_SITES", "5259dafaa1b57d9489003b16a48e35f8");
    }

    private void testOutputParameters(final String args, final String md5) {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 " + args, 1,
                Arrays.asList(md5));
        executeTest(String.format("testParameter[%s]", args), spec);
    }

    @Test
    public void testConfidence() {
        WalkerTest.WalkerTestSpec spec1 = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 -stand_call_conf 10 ", 1,
                Arrays.asList("918109938ef355d759dafc3ebb47d8a5"));
        executeTest("test confidence 1", spec1);
    }

    @Test
    public void testNoPrior() {
        WalkerTest.WalkerTestSpec spec1 = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 -stand_call_conf 10 -inputPrior 0.33333 -inputPrior 0.33333", 1,
                Arrays.asList("7ac60bdc355d97c0939e644b58de47d7"));
        executeTest("test no prior 1", spec1);

    }

    @Test
    public void testUserPrior() {
        WalkerTest.WalkerTestSpec spec1 = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 -stand_call_conf 10 -inputPrior 0.001 -inputPrior 0.495", 1,
                Arrays.asList("04d05900849d5a3f6f3f98bd0f262369"));
        executeTest("test user prior 1", spec1);

    }

    @Test
    public void emitPLsAtAllSites() {
        WalkerTest.WalkerTestSpec spec1 = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,010,000 --output_mode EMIT_ALL_SITES -allSitePLs", 1,
                Arrays.asList("552aced1b1ef7e4a554223f4719f9560"));
        // GDA: TODO: BCF encoder/decoder doesn't seem to support non-standard values in genotype fields. IE even if there is a field defined in FORMAT and in the header the BCF2 encoder will still fail
        spec1.disableShadowBCF();

        executeTest("test all site PLs 1", spec1);

    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing heterozygosity
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test
    public void testHeterozyosity1() {
        testHeterozosity( 0.01, "6053106407e09a6aefb78395a0e22ec4" );
    }

    @Test
    public void testHeterozyosity2() {
        testHeterozosity( 1.0 / 1850, "37666375278259c4d7dc800a0f73c1ca" );
    }

    private void testHeterozosity(final double arg, final String md5) {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,100,000 --heterozygosity " + arg, 1,
                Arrays.asList(md5));
        executeTest(String.format("test heterozyosity[%s]", arg), spec);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing compressed output
    //
    // --------------------------------------------------------------------------------------------------------------

    private final static String COMPRESSED_OUTPUT_MD5 = "c5c6af421cffa12fe6bdaced6cd41dd2";

    @Test
    public void testCompressedOutput() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,100,000", 1,
                Arrays.asList("gz"), Arrays.asList(COMPRESSED_OUTPUT_MD5));
        executeTest("test compressed output", spec);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing parallelization
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test
    public void testParallelization() {

        // Note that we need to turn off any randomization for this to work, so no downsampling and no annotations

        String md5 = "1f3fad09a63269c36e871e7ee04ebfaa";
        final String myCommand = "-T UnifiedGenotyper --disableDithering -R " + b36KGReference + " --no_cmdline_in_header -glm BOTH -minIndelFrac 0.0 --dbsnp " + b36dbSNP129;

        WalkerTest.WalkerTestSpec spec1 = new WalkerTest.WalkerTestSpec(
                myCommand + " -dt NONE -G none --contamination_fraction_to_filter 0.0 -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,075,000", 1,
                Arrays.asList(md5));
        executeTest("test parallelization (single thread)", spec1);

        GenomeAnalysisEngine.resetRandomGenerator();

        WalkerTest.WalkerTestSpec spec2 = new WalkerTest.WalkerTestSpec(
                myCommand + " -dt NONE -G none --contamination_fraction_to_filter 0.0 -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,075,000 -nt 2", 1,
                Arrays.asList(md5));
        executeTest("test parallelization (2 threads)", spec2);

        GenomeAnalysisEngine.resetRandomGenerator();

        WalkerTest.WalkerTestSpec spec3 = new WalkerTest.WalkerTestSpec(
                myCommand + " -dt NONE -G none --contamination_fraction_to_filter 0.0 -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.SLX.bam -o %s -L 1:10,000,000-10,075,000 -nt 4", 1,
                Arrays.asList(md5));
        executeTest("test parallelization (4 threads)", spec3);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing calls with SLX, 454, and SOLID data
    //
    // --------------------------------------------------------------------------------------------------------------
    @Test
    public void testMultiTechnologies() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand +
                        " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.allTechs.bam" +
                        " -o %s" +
                        " -L 1:10,000,000-10,100,000",
                1,
                Arrays.asList("630d1dcfb7650a9287d6723c38b0746a"));

        executeTest(String.format("test multiple technologies"), spec);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing calls with BAQ
    //
    // --------------------------------------------------------------------------------------------------------------
    @Test
    public void testCallingWithBAQ() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand +
                        " -I " + validationDataLocation + "NA12878.1kg.p2.chr1_10mb_11_mb.allTechs.bam" +
                        " -o %s" +
                        " -L 1:10,000,000-10,100,000" +
                        " -baq CALCULATE_AS_NECESSARY",
                1,
                Arrays.asList("976e88e4accb4436ad9ac97df9477648"));

        executeTest(String.format("test calling with BAQ"), spec);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing SnpEff
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test
    public void testSnpEffAnnotationRequestedWithoutRodBinding() {
        WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                baseCommand + " -I " + validationDataLocation + "low_coverage_CEU.chr1.10k-11k.bam -o %s -L 1:10,022,000-10,025,000 " +
                "-A SnpEff",
                1,
                UserException.class);
        executeTest("testSnpEffAnnotationRequestedWithoutRodBinding", spec);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing Ns in CIGAR
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test
    public void testNsInCigar() {
        final WalkerTest.WalkerTestSpec spec = new WalkerTest.WalkerTestSpec(
                "-T UnifiedGenotyper --disableDithering -R " + b37KGReference + " --no_cmdline_in_header -I " + privateTestDir + "testWithNs.bam -o %s -L 8:141813600-141813700 -out_mode EMIT_ALL_SITES", 1,
                UserException.UnsupportedCigarOperatorException.class);

        executeTest("test calling on reads with Ns in CIGAR", spec);
    }

    @Test(enabled = true)
    public void testCompressedVCFOutputWithNT() throws Exception {
        WalkerTestSpec spec = new WalkerTestSpec("-T UnifiedGenotyper -R " + b37KGReference + " -I "
                + privateTestDir + "PCRFree.2x250.Illumina.20_10_11.bam"
                + " -o %s -L 20:10,000,000-10,100,000 -nt 4",
                1, Arrays.asList("vcf.gz"), Arrays.asList(""));
        final File vcf = executeTest("testCompressedVCFOutputWithNT", spec).first.get(0);
        final AsciiLineReader reader = new AsciiLineReader(new BlockCompressedInputStream(vcf));
        int nLines = 0;
        while ( reader.readLine() != null )
            nLines++;
        Assert.assertTrue(nLines > 0);
    }

    // --------------------------------------------------------------------------------------------------------------
    //
    // testing only emit samples
    //
    // --------------------------------------------------------------------------------------------------------------

    @Test(enabled = true)
    public void testOnlyEmitSample() throws Exception {
        final String base = "-T UnifiedGenotyper -R " + b37KGReference + " -I "
                + privateTestDir + "AFR.complex.variants.bam --disableDithering"
                + " -o %s -L 20:10,000,000-10,100,000";
        final WalkerTestSpec specAllSamples = new WalkerTestSpec(base, 1, Arrays.asList(""));
        specAllSamples.disableShadowBCF();
        final File allSamplesVCF = executeTest("testOnlyEmitSampleAllSamples", specAllSamples).first.get(0);
        final List<VariantContext> allSampleVCs = GATKVCFUtils.readVCF(allSamplesVCF).getSecond();

        final WalkerTestSpec onlyHG01879 = new WalkerTestSpec(base + " -onlyEmitSamples HG01879", 1, Arrays.asList(""));
        onlyHG01879.disableShadowBCF();
        final File onlyHG01879VCF = executeTest("testOnlyEmitSample", onlyHG01879).first.get(0);
        final List<VariantContext> onlyHG01879VCs = GATKVCFUtils.readVCF(onlyHG01879VCF).getSecond();

        Assert.assertEquals(allSampleVCs.size(), onlyHG01879VCs.size());
        for ( int i = 0; i < allSampleVCs.size(); i++ ) {
            final VariantContext allSampleVC = allSampleVCs.get(i);
            final VariantContext onlyHG01879VC = onlyHG01879VCs.get(i);

            if ( allSampleVC == null ) {
                Assert.assertNull(onlyHG01879VC);
            } else {
                Assert.assertNotNull(onlyHG01879VC);

                Assert.assertTrue(allSampleVC.getGenotypes().size() > 1, "All samples should have had more than 1 genotype, but didn't");
                Assert.assertEquals(onlyHG01879VC.getGenotypes().size(), 1, "Should have found a single sample genotype, but didn't");
                Assert.assertEquals(onlyHG01879VC.hasGenotype("HG01879"), true);

                Assert.assertEquals(allSampleVC.getStart(), onlyHG01879VC.getStart());
                Assert.assertEquals(allSampleVC.getChr(), onlyHG01879VC.getChr());
                Assert.assertEquals(allSampleVC.getEnd(), onlyHG01879VC.getEnd());
                Assert.assertEquals(allSampleVC.getFilters(), onlyHG01879VC.getFilters());
                Assert.assertEquals(allSampleVC.getAlleles(), onlyHG01879VC.getAlleles());
                Assert.assertEquals(allSampleVC.getAttributes(), onlyHG01879VC.getAttributes());
                Assert.assertEquals(allSampleVC.getPhredScaledQual(), onlyHG01879VC.getPhredScaledQual());

                final Genotype allG = allSampleVC.getGenotype("HG01879");
                final Genotype onlyG = onlyHG01879VC.getGenotype("HG01879");
                Assert.assertEquals(allG.getAD(), onlyG.getAD());
                Assert.assertEquals(allG.getDP(), onlyG.getDP());
                Assert.assertEquals(allG.getAlleles(), onlyG.getAlleles());
                Assert.assertEquals(allG.getPL(), onlyG.getPL());
                Assert.assertEquals(allG.toString(), onlyG.toString());
            }
        }
    }
}
