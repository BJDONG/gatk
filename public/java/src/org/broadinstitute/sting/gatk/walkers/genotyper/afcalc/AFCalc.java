/*
 * Copyright (c) 2010.
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

package org.broadinstitute.sting.gatk.walkers.genotyper.afcalc;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import org.apache.log4j.Logger;
import org.broadinstitute.sting.utils.SimpleTimer;
import org.broadinstitute.sting.utils.Utils;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.variantcontext.Allele;
import org.broadinstitute.sting.utils.variantcontext.Genotype;
import org.broadinstitute.sting.utils.variantcontext.GenotypesContext;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


/**
 * Generic interface for calculating the probability of alleles segregating given priors and genotype likelihoods
 *
 */
public abstract class AFCalc implements Cloneable {
    private final static Logger defaultLogger = Logger.getLogger(AFCalc.class);

    protected final int nSamples;
    protected final int maxAlternateAllelesToGenotype;
    protected final int maxAlternateAllelesForIndels;

    protected Logger logger = defaultLogger;

    private SimpleTimer callTimer = new SimpleTimer();
    private PrintStream callReport = null;
    private final AFCalcResultTracker resultTracker;

    protected AFCalc(final int nSamples, final int maxAltAlleles, final int maxAltAllelesForIndels, final int ploidy) {
        if ( nSamples < 0 ) throw new IllegalArgumentException("nSamples must be greater than zero " + nSamples);
        if ( maxAltAlleles < 1 ) throw new IllegalArgumentException("maxAltAlleles must be greater than zero " + maxAltAlleles);
        if ( maxAltAllelesForIndels < 1 ) throw new IllegalArgumentException("maxAltAllelesForIndels must be greater than zero " + maxAltAllelesForIndels);
        if ( ploidy < 1 ) throw new IllegalArgumentException("ploidy must be > 0 but got " + ploidy);

        this.nSamples = nSamples;
        this.maxAlternateAllelesToGenotype = maxAltAlleles;
        this.maxAlternateAllelesForIndels = maxAltAllelesForIndels;
        this.resultTracker = new AFCalcResultTracker(Math.max(maxAltAlleles, maxAltAllelesForIndels));
    }

    public void enableProcessLog(final File exactCallsLog) {
        initializeOutputFile(exactCallsLog);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * Compute the probability of the alleles segregating given the genotype likelihoods of the samples in vc
     *
     * @param vc the VariantContext holding the alleles and sample information
     * @param log10AlleleFrequencyPriors a prior vector nSamples x 2 in length indicating the Pr(AF = i)
     * @return result (for programming convenience)
     */
    public AFCalcResult getLog10PNonRef(final VariantContext vc, final double[] log10AlleleFrequencyPriors) {
        if ( vc == null ) throw new IllegalArgumentException("VariantContext cannot be null");
        if ( log10AlleleFrequencyPriors == null ) throw new IllegalArgumentException("priors vector cannot be null");
        if ( resultTracker == null ) throw new IllegalArgumentException("Results object cannot be null");

        // reset the result, so we can store our new result there
        resultTracker.reset();

        final VariantContext vcWorking = reduceScope(vc);

        callTimer.start();
        final AFCalcResult result = computeLog10PNonRef(vcWorking, log10AlleleFrequencyPriors);
        final long nanoTime = callTimer.getElapsedTimeNano();

        if ( callReport != null )
            printCallInfo(vcWorking, log10AlleleFrequencyPriors, nanoTime, resultTracker.getLog10PosteriorOfAFzero());

        return result;
    }

    @Deprecated
    protected AFCalcResult resultFromTracker(final VariantContext vcWorking, final double[] log10AlleleFrequencyPriors) {
        resultTracker.setAllelesUsedInGenotyping(vcWorking.getAlleles());
        return resultTracker.toAFCalcResult(log10AlleleFrequencyPriors);
    }

    // ---------------------------------------------------------------------------
    //
    // Abstract methods that should be implemented by concrete implementations
    // to actually calculate the AF
    //
    // ---------------------------------------------------------------------------

    /**
     * Look at VC and perhaps return a new one of reduced complexity, if that's necessary
     *
     * Used before the call to computeLog10PNonRef to simply the calculation job at hand,
     * if vc exceeds bounds.  For example, if VC has 100 alt alleles this function
     * may decide to only genotype the best 2 of them.
     *
     * @param vc the initial VC provided by the caller to this AFcalculation
     * @return a potentially simpler VC that's more tractable to genotype
     */
    @Requires("vc != null")
    @Ensures("result != null")
    protected abstract VariantContext reduceScope(final VariantContext vc);

    /**
     * Actually carry out the log10PNonRef calculation on vc, storing results in results
     *
     * @param vc                                variant context with alleles and genotype likelihoods
     * @param log10AlleleFrequencyPriors        priors
     * @return a AFCalcResult object describing the results of this calculation
     */
    // TODO -- add consistent requires among args
    protected abstract AFCalcResult computeLog10PNonRef(final VariantContext vc,
                                                        final double[] log10AlleleFrequencyPriors);

    /**
     * Must be overridden by concrete subclasses
     *
     * @param vc                                variant context with alleles and genotype likelihoods
     * @param allelesToUse                      alleles to subset
     * @param assignGenotypes
     * @param ploidy
     * @return GenotypesContext object
     */
    public abstract GenotypesContext subsetAlleles(final VariantContext vc,
                                                   final List<Allele> allelesToUse,
                                                   final boolean assignGenotypes,
                                                   final int ploidy);

    // ---------------------------------------------------------------------------
    //
    // accessors
    //
    // ---------------------------------------------------------------------------

    public int getMaxAltAlleles() {
        return Math.max(maxAlternateAllelesToGenotype, maxAlternateAllelesForIndels);
    }


    // ---------------------------------------------------------------------------
    //
    // Print information about the call to the calls log
    //
    // ---------------------------------------------------------------------------

    private void initializeOutputFile(final File outputFile) {
        try {
            if (outputFile != null) {
                callReport = new PrintStream( new FileOutputStream(outputFile) );
                callReport.println(Utils.join("\t", Arrays.asList("loc", "variable", "key", "value")));
            }
        } catch ( FileNotFoundException e ) {
            throw new UserException.CouldNotCreateOutputFile(outputFile, e);
        }
    }

    private void printCallInfo(final VariantContext vc,
                               final double[] log10AlleleFrequencyPriors,
                               final long runtimeNano,
                               final double log10PosteriorOfAFzero) {
        printCallElement(vc, "type", "ignore", vc.getType());

        int allelei = 0;
        for ( final Allele a : vc.getAlleles() )
            printCallElement(vc, "allele", allelei++, a.getDisplayString());

        for ( final Genotype g : vc.getGenotypes() )
            printCallElement(vc, "PL", g.getSampleName(), g.getLikelihoodsString());

        for ( int priorI = 0; priorI < log10AlleleFrequencyPriors.length; priorI++ )
            printCallElement(vc, "priorI", priorI, log10AlleleFrequencyPriors[priorI]);

        printCallElement(vc, "runtime.nano", "ignore", runtimeNano);
        printCallElement(vc, "log10PosteriorOfAFzero", "ignore", log10PosteriorOfAFzero);

        callReport.flush();
    }

    private void printCallElement(final VariantContext vc,
                                  final Object variable,
                                  final Object key,
                                  final Object value) {
        final String loc = String.format("%s:%d", vc.getChr(), vc.getStart());
        callReport.println(Utils.join("\t", Arrays.asList(loc, variable, key, value)));
    }

    public AFCalcResultTracker getResultTracker() {
        return resultTracker;
    }
}