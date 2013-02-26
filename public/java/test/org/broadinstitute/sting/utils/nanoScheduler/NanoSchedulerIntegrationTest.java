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

package org.broadinstitute.sting.utils.nanoScheduler;

import org.broadinstitute.sting.WalkerTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ********************************************************************************** //
// Note that this class also serves as an integration test for the VariantAnnotator!  //
// ********************************************************************************** //

public class NanoSchedulerIntegrationTest extends WalkerTest {
    @DataProvider(name = "NanoSchedulerUGTest")
    public Object[][] createNanoSchedulerUGTest() {
        List<Object[]> tests = new ArrayList<Object[]>();

        for ( final int nt : Arrays.asList(1, 2) )
            for ( final int nct : Arrays.asList(1, 2) ) {
//                tests.add(new Object[]{ "SNP",   "a1c7546f32a8919a3f3a70a04b2e8322", nt, nct });
////                tests.add(new Object[]{ "INDEL", "0a6d2be79f4f8a4b0eb788cc4751b31b", nt, nct });
                tests.add(new Object[]{ "BOTH",  "85fc5d6dfeb60ed89763470f4b4c981e", nt, nct });
            }

        return tests.toArray(new Object[][]{});
    }

    @Test(enabled = true, dataProvider = "NanoSchedulerUGTest")
    private void testNanoSchedulerUGTest(final String glm, final String md5, final int nt, final int nct ) {
        WalkerTestSpec spec = new WalkerTestSpec(
                buildCommandLine(
                        "-T UnifiedGenotyper -R " + b37KGReference,
                        "--no_cmdline_in_header -G",
                        //"--dbsnp " + b37dbSNP132,
                        "-I " + privateTestDir + "NA12878.HiSeq.b37.chr20.10_11mb.bam",
                        "-L 20:10,000,000-10,100,000",
                        "-glm " + glm,
                        "--contamination_fraction_to_filter 0.0",
                        "-nt " + nt,
                        "-nct " + nct,
                        "-o %s"
                ),
                1,
                Arrays.asList(md5)
        );
        executeTest(String.format("testUG-glm:%s-nt%d-nct%d", glm, nt, nct), spec);
    }



}
