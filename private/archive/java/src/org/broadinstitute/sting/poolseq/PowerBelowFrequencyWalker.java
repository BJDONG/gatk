/*
 * Copyright (c) 2010 The Broad Institute
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

package org.broadinstitute.sting.gatk.walkers.poolseq;

import org.broadinstitute.sting.gatk.walkers.LocusWalker;
import org.broadinstitute.sting.gatk.walkers.DataSource;
import org.broadinstitute.sting.gatk.walkers.By;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.QualityUtils;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.StingException;
import org.broadinstitute.sting.utils.PoolUtils;
import net.sf.samtools.SAMRecord;

import java.util.List;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: chartl
 * Date: Oct 8, 2009
 * Time: 9:44:35 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Given an input N, this walker calculates the power to detect a polymorphism with N, N-1, N-2, ..., 1 variant alleles in a pooled setting
 */
@By(DataSource.REFERENCE)
public class PowerBelowFrequencyWalker extends LocusWalker<Integer,Integer> {
    @Output
    PrintStream out;

    @Argument(fullName="lodThreshold", shortName="lod", doc="Threshold for log likelihood ratio to be called a SNP. Defaults to 3.0", required = false)
    public double lodThresh = 3.0;

    @Argument(fullName="minimumQScore", shortName="qm", doc="Use bases whose phred (Q) score meets or exceeds this number. Defaults to 0", required = false)
    public byte minQ = 0;

    @Argument(fullName="poolSize", shortName="ps", doc="Number of individuals in the pool", required = true)
    public int numIndividuals = 0;

    @Argument(fullName="alleleFrequency", shortName="af", doc="Calculate power for all allele frequencies below this. Defaults to 4", required=false)
    public int alleleFreq = 4;

    @Argument(fullName="useMeanProb", doc="Use the mean probability as the \"average quality\" rather than median Q-score")
    boolean useMean = false;

    @Argument(fullName="minimumMappingQuality", shortName="mmq", doc="Only use reads above this mapping quality in the power calculation", required=false)
    int minMappingQuality = -1;

    @Argument(fullName="ignoreForwardReads",doc="Ignore the forward reads at a site. Defaults to false.", required = false)
    boolean ignoreForwardReads = false;

    @Argument(fullName="ignoreReverseReads",doc="Ignore the reverse reads at a site. Defaults to false.", required = false)
    boolean ignoreReverseReads = false;

    private boolean calledByAnotherWalker = false;

    public void initialize() {
        if ( alleleFreq < 1 ) {
            String err = "Allele frequency (-af) must be greater than or equal to one.";
            throw new StingException(err);
        }

        if ( numIndividuals == 0 ) {
            calledByAnotherWalker = true;
        }
    }

    public Integer reduceInit() {
        out.print(makeHeader());
        return 0;
    }

    public Integer reduce(Integer mapint, Integer prevint) {
        return 0;
    }

    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        String output = String.format("%s", context.getLocation().toString());

        // threshold reads if necessary
        if ( ignoreForwardReads && ignoreReverseReads) {
            throw new StingException("User has elected to ignore both forward and reverse reads. Power is zero.");
        }
        else if ( ! ignoreForwardReads && ignoreReverseReads ) {
            org.broadinstitute.sting.playground.gatk.walkers.poolseq.ReadOffsetQuad rq = PoolUtils.splitReadsByReadDirection(context.getReads(),context.getOffsets());
            context = new AlignmentContext(context.getLocation(),rq.getFirstReads(),rq.getFirstOffsets());
        } else if ( ignoreForwardReads && ! ignoreReverseReads ) {
            org.broadinstitute.sting.playground.gatk.walkers.poolseq.ReadOffsetQuad rq = PoolUtils.splitReadsByReadDirection(context.getReads(),context.getOffsets());
            context = new AlignmentContext(context.getLocation(),rq.getSecondReads(),rq.getSecondOffsets());
        }

        if ( minQ > 0 ) {
            Pair<List<SAMRecord>, List<Integer>> thresh = PoolUtils.thresholdReadsByQuality(context.getReads(),context.getOffsets(),minQ);
            context = new AlignmentContext(context.getLocation(), thresh.getFirst(), thresh.getSecond());
        }

        if ( minMappingQuality > -1 ) {
            Pair<List<SAMRecord>,List<Integer>> goodMaps = PoolUtils.thresholdReadsByMappingQuality(context.getReads(),context.getOffsets(),minMappingQuality);
            context = new AlignmentContext(context.getLocation(), goodMaps.getFirst(), goodMaps.getSecond());
        }

        // calculate powers and put into output string

        for ( int i = 1; i <= alleleFreq; i ++ ) {
            output = String.format("%s\t%f",output,calculatePowerAtFrequency(context,i));
        }

        // print the output string

        out.printf("%s%n",output);

        return 0;
    }

    public double calculatePowerAtFrequency( AlignmentContext context, int alleles ) {
        return theoreticalPower( context.size(), getMeanQ(context), alleles, lodThresh );
    }

    public byte getMeanQ( AlignmentContext context ) {
        byte meanQ;
        if ( useMean ) {
            meanQ = QualityUtils.probToQual(expectedMatchRate(context));
        } else {
            meanQ = MathUtils.getQScoreMedian(context.getReads(),context.getOffsets());
        }

        return meanQ;
    }

    public double expectedMatchRate(AlignmentContext context) {
        int nReads = context.size();
        double matches = 0.0;
        for ( int r = 0; r < nReads; r ++ ) {
            matches += QualityUtils.qualToProb(context.getReads().get(r).getBaseQualities()[context.getOffsets().get(r)]);
        }

        return matches/nReads;
    }

    public String makeHeader() {
        // create the header
        String header = "chrm:pos";
        for ( int i = 1; i <= alleleFreq; i ++ ) {
            header = header + "\tPower_at_"+Integer.toString(i);
        }

        return String.format("%s%n", header);
    }

    public double theoreticalPower( int depth, byte q, int alleles, double lodThreshold ) {
        double power;
        if( depth <= 0 ) {
            power = 0.0;
        } else {
            double p_error = QualityUtils.qualToErrorProb(q);
            double snpProp = getSNPProportion(alleles);
            double kterm_num = Math.log10( snpProp * (1 - p_error) + (1 - snpProp) * (p_error/3) );
            double kterm_denom = Math.log10( p_error/3 );
            double dkterm_num = Math.log10( snpProp * (p_error/3) + (1 - snpProp) * (1 - p_error) );
            double dkterm_denom = Math.log10( 1 - p_error);

            int kaccept = (int) Math.ceil( ( lodThreshold - ( (double) depth ) * ( dkterm_num - dkterm_denom ) ) /
                    ( kterm_num - kterm_denom- dkterm_num + dkterm_denom ) );
            System.out.println("Error="+p_error+" snpProp="+snpProp+" alleles="+alleles+" lodThreshold="+lodThreshold+" kaccept="+kaccept);

            if (kaccept <= 0) {
                power = 0.0;
            } else {
                // we will reject the null hypothesis if we see kaccept or more SNPs, the power is the probability that this occurs
                // we can optimize this by checking to see which sum is smaller
                if ( depth - kaccept < kaccept ) {// kaccept > depth/2 - calculate power as P[hits between kaccept and depth]
                    power = MathUtils.binomialCumulativeProbability(kaccept, depth, depth, snpProp);
                } else { // kaccept < depth/2 - calculate power as 1-P[hits between 0 and kaccept]
                    power = 1-MathUtils.binomialCumulativeProbability(0, kaccept, depth, snpProp);
                }
            }
        }
        return power;
    }

    private double getSNPProportion(int alleles) {
        return ((double)alleles)/(2*numIndividuals);
    }

    public void setPoolSize(int poolSize) {
        if ( calledByAnotherWalker ) {
            numIndividuals = poolSize;
        } else {
            throw new StingException("This method should only be accessible by calling it from another walker.");
        }
    }
}
