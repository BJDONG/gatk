/*
* Copyright (c) 2012 The Broad Institute
* 
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
* THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package org.broadinstitute.sting.gatk;

import org.broad.tribble.readers.AsciiLineReader;
import org.broadinstitute.sting.WalkerTest;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.filters.MappingQualityUnavailableFilter;
import org.broadinstitute.sting.gatk.io.stubs.VariantContextWriterStub;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.ReadFilters;
import org.broadinstitute.sting.gatk.walkers.ReadWalker;
import org.broadinstitute.sting.gatk.walkers.qc.ErrorThrowing;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.sam.GATKSAMRecord;
import org.broadinstitute.variant.vcf.VCFCodec;
import org.broadinstitute.variant.vcf.VCFHeader;
import org.broadinstitute.variant.vcf.VCFHeaderLine;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 */
public class EngineFeaturesIntegrationTest extends WalkerTest {
    private void testBadRODBindingInput(String type, String name, Class c) {
        WalkerTestSpec spec = new WalkerTestSpec("-T SelectVariants -L 1:1 --variant:variant," + type + " "
                + b37dbSNP132 + " -R " + b37KGReference + " -o %s",
                1, c);
        executeTest(name, spec);
    }

    @Test() private void testBadRODBindingInputType1() {
        testBadRODBindingInput("beagle", "BEAGLE input to VCF expecting walker", UserException.BadArgumentValue.class);
    }

    @Test() private void testBadRODBindingInputType3() {
        testBadRODBindingInput("bed", "Bed input to VCF expecting walker", UserException.BadArgumentValue.class);
    }

    @Test() private void testBadRODBindingInputTypeUnknownType() {
        testBadRODBindingInput("bedXXX", "Unknown input to VCF expecting walker", UserException.UnknownTribbleType.class);
    }

    private void testMissingFile(String name, String missingBinding) {
        WalkerTestSpec spec = new WalkerTestSpec(missingBinding + " -R " + b37KGReference + " -o %s",
                1, UserException.CouldNotReadInputFile.class);
        executeTest(name, spec);
    }

    @Test() private void testMissingBAMnt1() {
        testMissingFile("missing BAM", "-T PrintReads -I missing.bam -nt 1");
    }
    @Test() private void testMissingBAMnt4() {
        testMissingFile("missing BAM", "-T PrintReads -I missing.bam -nt 4");
    }
    @Test() private void testMissingVCF() {
        testMissingFile("missing VCF", "-T SelectVariants -V missing.vcf");
    }
    @Test() private void testMissingInterval() {
        testMissingFile("missing interval", "-T PrintReads -L missing.interval_list -I " + b37GoodBAM);
    }


    // --------------------------------------------------------------------------------
    //
    // Test that our exceptions are coming back as we expect
    //
    // --------------------------------------------------------------------------------

    private class EngineErrorHandlingTestProvider extends TestDataProvider {
        final Class expectedException;
        final String args;
        final int iterationsToTest;

        public EngineErrorHandlingTestProvider(Class exceptedException, final String args) {
            super(EngineErrorHandlingTestProvider.class);
            this.expectedException = exceptedException;
            this.args = args;
            this.iterationsToTest = args.equals("") ? 1 : 10;
            setName(String.format("Engine error handling: expected %s with args %s", exceptedException, args));
        }
    }

    @DataProvider(name = "EngineErrorHandlingTestProvider")
    public Object[][] makeEngineErrorHandlingTestProvider() {
        for ( final ErrorThrowing.FailMethod failMethod : ErrorThrowing.FailMethod.values() ) {
            if ( failMethod == ErrorThrowing.FailMethod.TREE_REDUCE )
                continue; // cannot reliably throw errors in TREE_REDUCE

            final String failArg = " -fail " + failMethod.name();
            for ( final String args : Arrays.asList("", " -nt 2", " -nct 2") ) {
                new EngineErrorHandlingTestProvider(NullPointerException.class, failArg + args);
                new EngineErrorHandlingTestProvider(UserException.class, failArg + args);
                new EngineErrorHandlingTestProvider(ReviewedStingException.class, failArg + args);
            }
        }

        return EngineErrorHandlingTestProvider.getTests(EngineErrorHandlingTestProvider.class);
    }

    //
    // Loop over errors to throw, make sure they are the errors we get back from the engine, regardless of NT type
    //
    @Test(enabled = true, dataProvider = "EngineErrorHandlingTestProvider", timeOut = 60 * 1000 )
    public void testEngineErrorHandlingTestProvider(final EngineErrorHandlingTestProvider cfg) {
        for ( int i = 0; i < cfg.iterationsToTest; i++ ) {
            final String root = "-T ErrorThrowing -R " + exampleFASTA;
            final String args = root + cfg.args + " -E " + cfg.expectedException.getSimpleName();
            WalkerTestSpec spec = new WalkerTestSpec(args, 0, cfg.expectedException);

            executeTest(cfg.toString(), spec);
        }
    }

    // --------------------------------------------------------------------------------
    //
    // Test that read filters are being applied in the order we expect
    //
    // --------------------------------------------------------------------------------

    @ReadFilters({MappingQualityUnavailableFilter.class})
    public static class DummyReadWalkerWithMapqUnavailableFilter extends ReadWalker<Integer, Integer> {
        @Output
        PrintStream out;

        @Override
        public Integer map(ReferenceContext ref, GATKSAMRecord read, RefMetaDataTracker metaDataTracker) {
            return 1;
        }

        @Override
        public Integer reduceInit() {
            return 0;
        }

        @Override
        public Integer reduce(Integer value, Integer sum) {
            return value + sum;
        }

        @Override
        public void onTraversalDone(Integer result) {
            out.println(result);
        }
    }

    @Test(enabled = true)
    public void testUserReadFilterAppliedBeforeWalker() {
        WalkerTestSpec spec = new WalkerTestSpec("-R " + b37KGReference + " -I " + privateTestDir + "allMAPQ255.bam"
                + " -T DummyReadWalkerWithMapqUnavailableFilter -o %s -L MT -rf ReassignMappingQuality",
                1, Arrays.asList("ecf27a776cdfc771defab1c5d19de9ab"));
        executeTest("testUserReadFilterAppliedBeforeWalker", spec);
    }

    @Test
    public void testNegativeCompress() {
        testBadCompressArgument(-1);
    }

    @Test
    public void testTooBigCompress() {
        testBadCompressArgument(100);
    }

    private void testBadCompressArgument(final int compress) {
        WalkerTestSpec spec = new WalkerTestSpec("-T PrintReads -R " + b37KGReference + " -I private/testdata/NA12878.1_10mb_2_10mb.bam -o %s -compress " + compress,
                1, UserException.class);
        executeTest("badCompress " + compress, spec);
    }

    @Test(enabled = true)
    public void testGATKVersionInVCF() throws Exception {
        WalkerTestSpec spec = new WalkerTestSpec("-T UnifiedGenotyper -R " + b37KGReference + " -I "
                + privateTestDir + "PCRFree.2x250.Illumina.20_10_11.bam"
                + " -o %s -L 20:10,000,000",
                1, Arrays.asList(""));
        final File vcf = executeTest("testGATKVersionInVCF", spec).first.get(0);
        final VCFHeader header = (VCFHeader)new VCFCodec().readHeader(new AsciiLineReader(new FileInputStream(vcf)));
        final VCFHeaderLine versionLine = header.getMetaDataLine(VariantContextWriterStub.GATK_VERSION_KEY);
        Assert.assertNotNull(versionLine);
        Assert.assertEquals(versionLine.getValue(), CommandLineGATK.getVersionNumber());
    }
}