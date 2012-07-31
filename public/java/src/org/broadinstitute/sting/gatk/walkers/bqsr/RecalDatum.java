package org.broadinstitute.sting.gatk.walkers.bqsr;

/*
 * Copyright (c) 2009 The Broad Institute
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
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.QualityUtils;

import java.util.Random;

/**
 * An individual piece of recalibration data. Each bin counts up the number of observations and the number
 * of reference mismatches seen for that combination of covariates.
 *
 * Created by IntelliJ IDEA.
 * User: rpoplin
 * Date: Nov 3, 2009
 */
public class RecalDatum {
    private static final double UNINITIALIZED = -1.0;

    /**
     * estimated reported quality score based on combined data's individual q-reporteds and number of observations
     */
    private double estimatedQReported;

    /**
     * the empirical quality for datums that have been collapsed together (by read group and reported quality, for example)
     */
    private double empiricalQuality;

    /**
     * number of bases seen in total
     */
    long numObservations;

    /**
     * number of bases seen that didn't match the reference
     */
    long numMismatches;

    /**
     * used when calculating empirical qualities to avoid division by zero
     */
    private static final int SMOOTHING_CONSTANT = 1;

    //---------------------------------------------------------------------------------------------------------------
    //
    // constructors
    //
    //---------------------------------------------------------------------------------------------------------------

    public RecalDatum(final long _numObservations, final long _numMismatches, final byte reportedQuality) {
        numObservations = _numObservations;
        numMismatches = _numMismatches;
        estimatedQReported = reportedQuality;
        empiricalQuality = UNINITIALIZED;
    }

    public RecalDatum(final RecalDatum copy) {
        this.numObservations = copy.numObservations;
        this.numMismatches = copy.numMismatches;
        this.estimatedQReported = copy.estimatedQReported;
        this.empiricalQuality = copy.empiricalQuality;
    }

    public synchronized void combine(final RecalDatum other) {
        final double sumErrors = this.calcExpectedErrors() + other.calcExpectedErrors();
        increment(other.numObservations, other.numMismatches);
        estimatedQReported = -10 * Math.log10(sumErrors / this.numObservations);
        empiricalQuality = UNINITIALIZED;
    }

    @Requires("empiricalQuality == UNINITIALIZED")
    @Ensures("empiricalQuality != UNINITIALIZED")
    private synchronized final void calcEmpiricalQuality() {
        // cache the value so we don't call log over and over again
        final double doubleMismatches = (double) (numMismatches + SMOOTHING_CONSTANT);
        final double doubleObservations = (double) (numObservations + SMOOTHING_CONSTANT);
        final double empiricalQual = -10 * Math.log10(doubleMismatches / doubleObservations);
        empiricalQuality = Math.min(empiricalQual, (double) QualityUtils.MAX_RECALIBRATED_Q_SCORE);
    }

    public synchronized void setEstimatedQReported(final double estimatedQReported) {
        this.estimatedQReported = estimatedQReported;
    }

    public final double getEstimatedQReported() {
        return estimatedQReported;
    }

    public synchronized void setEmpiricalQuality(final double empiricalQuality) {
        this.empiricalQuality = empiricalQuality;
    }

    public final double getEmpiricalQuality() {
        if (empiricalQuality == UNINITIALIZED)
            calcEmpiricalQuality();
        return empiricalQuality;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d", numObservations, numMismatches, (byte) Math.floor(getEmpiricalQuality()));
    }

    public String stringForCSV() {
        return String.format("%s,%d,%.2f", toString(), (byte) Math.floor(getEstimatedQReported()), getEmpiricalQuality() - getEstimatedQReported());
    }

    private double calcExpectedErrors() {
        return (double) this.numObservations * qualToErrorProb(estimatedQReported);
    }

    private double qualToErrorProb(final double qual) {
        return Math.pow(10.0, qual / -10.0);
    }

    public static RecalDatum createRandomRecalDatum(int maxObservations, int maxErrors) {
        final Random random = new Random();
        final int nObservations = random.nextInt(maxObservations);
        final int nErrors = random.nextInt(maxErrors);
        final int qual = random.nextInt(QualityUtils.MAX_QUAL_SCORE);
        return new RecalDatum(nObservations, nErrors, (byte)qual);
    }

    /**
     * We don't compare the estimated quality reported because it may be different when read from
     * report tables.
     *
     * @param o the other recal datum
     * @return true if the two recal datums have the same number of observations, errors and empirical quality.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RecalDatum))
            return false;
        RecalDatum other = (RecalDatum) o;
        return super.equals(o) &&
               MathUtils.compareDoubles(this.empiricalQuality, other.empiricalQuality, 0.001) == 0;
    }

    //---------------------------------------------------------------------------------------------------------------
    //
    // increment methods
    //
    //---------------------------------------------------------------------------------------------------------------

    synchronized void increment(final long incObservations, final long incMismatches) {
        numObservations += incObservations;
        numMismatches += incMismatches;
        empiricalQuality = UNINITIALIZED;
    }

    synchronized void increment(final boolean isError) {
        numObservations++;
        numMismatches += isError ? 1:0;
        empiricalQuality = UNINITIALIZED;
    }
}
