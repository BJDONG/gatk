/*
 * Copyright (c) 2011, The Broad Institute
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.gatk.walkers.cancer;

import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.ArgumentCollection;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.arguments.StandardVariantContextInputArgumentCollection;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.RodWalker;
import org.broadinstitute.sting.gatk.walkers.TreeReducible;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.SampleUtils;
import org.broadinstitute.sting.utils.variant.GATKVCFUtils;
import org.broadinstitute.variant.vcf.*;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.variant.variantcontext.writer.VariantContextWriter;
import org.broadinstitute.variant.variantcontext.*;

import java.util.*;

/**
 * Assigns somatic status to a set of calls
 */
public class AssignSomaticStatus extends RodWalker<Integer, Integer> implements TreeReducible<Integer> {
    @ArgumentCollection
    protected StandardVariantContextInputArgumentCollection variantCollection = new StandardVariantContextInputArgumentCollection();

    @Argument(shortName="n", fullName="normalSample", required=true, doc="The normal sample")
    public String normalSample;

    @Argument(shortName="t", fullName="tumorSample", required=true, doc="The tumor sample")
    public String tumorSample;

    @Argument(shortName="somaticPriorQ", fullName="somaticPriorQ", required=false, doc="Phred-scaled probability that a site is a somatic mutation")
    public byte somaticPriorQ = 60;

    @Argument(shortName="somaticMinLOD", fullName="somaticMinLOD", required=false, doc="Phred-scaled min probability that a site should be called somatic mutation")
    public byte somaticMinLOD = 1;

    @Argument(shortName="minimalVCF", fullName="minimalVCF", required=false, doc="If provided, the attributes of the output VCF will only contain the somatic status fields")
    public boolean minimalVCF = false;

    @Output
    protected VariantContextWriter vcfWriter = null;

    private final String SOMATIC_LOD_TAG_NAME = "SOMATIC_LOD";
    private final String SOMATIC_AC_TAG_NAME = "SOMATIC_AC";
    private final String SOMATIC_NONREF_TAG_NAME = "SOMATIC_NNR";

    private final Set<String> samples = new HashSet<String>(2);

    /**
     * Parse the familial relationship specification, and initialize VCF writer
     */
    public void initialize() {
        List<String> rodNames = new ArrayList<String>();
        rodNames.add(variantCollection.variants.getName());

        Map<String, VCFHeader> vcfRods = GATKVCFUtils.getVCFHeadersFromRods(getToolkit(), rodNames);
        Set<String> vcfSamples = SampleUtils.getSampleList(vcfRods, VariantContextUtils.GenotypeMergeType.REQUIRE_UNIQUE);

        // set up tumor and normal samples
        if ( !vcfSamples.contains(normalSample) )
            throw new UserException.BadArgumentValue("--normalSample", "the normal sample " + normalSample + " doesn't match any sample from the input VCF");
        if ( !vcfSamples.contains(tumorSample) )
            throw new UserException.BadArgumentValue("--tumorSample", "the tumor sample " + tumorSample + " doesn't match any sample from the input VCF");

        logger.info("Normal sample: " + normalSample);
        logger.info("Tumor  sample: " + tumorSample);

        Set<VCFHeaderLine> headerLines = new HashSet<VCFHeaderLine>();
        headerLines.addAll(GATKVCFUtils.getHeaderFields(this.getToolkit()));
        headerLines.add(new VCFInfoHeaderLine(VCFConstants.SOMATIC_KEY, 0, VCFHeaderLineType.Flag, "Is this a confidently called somatic mutation"));
        headerLines.add(new VCFInfoHeaderLine(SOMATIC_LOD_TAG_NAME, 1, VCFHeaderLineType.Float, "log10 probability that the site is a somatic mutation"));
        headerLines.add(new VCFInfoHeaderLine(SOMATIC_AC_TAG_NAME, 1, VCFHeaderLineType.Integer, "Allele count of samples with somatic event"));
        headerLines.add(new VCFInfoHeaderLine(SOMATIC_NONREF_TAG_NAME, 1, VCFHeaderLineType.Integer, "Number of samples with somatic event"));

        samples.add(normalSample);
        samples.add(tumorSample);
        vcfWriter.writeHeader(new VCFHeader(headerLines, samples));
    }

    private double log10pNonRefInSamples(final VariantContext vc, final String sample) {
        return log10PLFromSamples(vc, sample, false);
     }

    private double log10pRefInSamples(final VariantContext vc, final String sample) {
        return log10PLFromSamples(vc, sample, true);
    }

    private double log10PLFromSamples(final VariantContext vc, final String sample, boolean calcRefP) {

        Genotype g = vc.getGenotype(sample);
        double log10pSample = -1000;
        if ( ! g.isNoCall() ) {
            final double[] gLikelihoods = MathUtils.normalizeFromLog10(g.getLikelihoods().getAsVector());
            log10pSample = Math.log10(calcRefP ? gLikelihoods[0] : 1 - gLikelihoods[0]);
            log10pSample = Double.isInfinite(log10pSample) ? -10000 : log10pSample;
        }
        return log10pSample;
    }

    private int calculateTumorAC(final VariantContext vc) {
        int ac = 0;
        switch ( vc.getGenotype(tumorSample).getType() ) {
            case HET:       ac += 1; break;
            case HOM_VAR:   ac += 2; break;
            case NO_CALL: case UNAVAILABLE: case HOM_REF: break;
        }
        return ac;
    }

    private int calculateTumorNNR(final VariantContext vc) {
        int nnr = 0;
        switch ( vc.getGenotype(tumorSample).getType() ) {
            case HET: case HOM_VAR: nnr += 1; break;
            case NO_CALL: case UNAVAILABLE: case HOM_REF: break;
        }
        return nnr;
    }

    /**
     * P(somatic | D)
     *   = P(somatic) * P(D | somatic)
     *   = P(somatic) * P(D | normals are ref) * P(D | tumors are non-ref)
     *
     * P(! somatic | D)
     *   = P(! somatic) * P(D | ! somatic)
     *   = P(! somatic) *
     *      * (  P(D | normals are non-ref) * P(D | tumors are non-ref) [germline]
     *         + P(D | normals are ref) * P(D | tumors are ref)) [no-variant at all]
     *
     * @param vc
     * @return
     */
    private double calcLog10pSomatic(final VariantContext vc) {
        // walk over tumors
        double log10pNonRefInTumors = log10pNonRefInSamples(vc, tumorSample);
        double log10pRefInTumors = log10pRefInSamples(vc, tumorSample);

        // walk over normals
        double log10pNonRefInNormals = log10pNonRefInSamples(vc, normalSample);
        double log10pRefInNormals = log10pRefInSamples(vc, normalSample);

        // priors
        double log10pSomaticPrior = MathUtils.phredScaleToLog10Probability(somaticPriorQ);
        double log10pNotSomaticPrior = Math.log10(1 - MathUtils.phredScaleToProbability(somaticPriorQ));

        double log10pNotSomaticGermline = log10pNonRefInNormals + log10pNonRefInTumors;
        double log10pNotSomaticNoVariant = log10pRefInNormals + log10pRefInTumors;

        double log10pNotSomatic = log10pNotSomaticPrior + MathUtils.log10sumLog10(new double[]{log10pNotSomaticGermline, log10pNotSomaticNoVariant});
        double log10pSomatic = log10pSomaticPrior + log10pNonRefInTumors + log10pRefInNormals;
        double lod = log10pSomatic - log10pNotSomatic;

        return Double.isInfinite(lod) ? -10000 : lod;
    }

    /**
     * For each variant in the file, determine the phasing for the child and replace the child's genotype with the trio's genotype
     *
     * @param tracker  the reference meta-data tracker
     * @param ref      the reference context
     * @param context  the alignment context
     * @return null
     */
    @Override
    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if (tracker != null) {
            for ( VariantContext vc : tracker.getValues(variantCollection.variants, context.getLocation()) ) {
                vc = vc.subContextFromSamples(samples);
                if ( !vc.isPolymorphicInSamples() )
                    continue;

                double log10pSomatic = calcLog10pSomatic(vc);

                // write in the somatic status probability
                Map<String, Object> attrs = new HashMap<String, Object>(); // vc.getAttributes());
                if ( ! minimalVCF ) attrs.putAll(vc.getAttributes());
                attrs.put(SOMATIC_LOD_TAG_NAME, log10pSomatic);
                if ( log10pSomatic > somaticMinLOD ) {
                    attrs.put(VCFConstants.SOMATIC_KEY, true);
                    attrs.put(SOMATIC_NONREF_TAG_NAME, calculateTumorNNR(vc));
                    attrs.put(SOMATIC_AC_TAG_NAME, calculateTumorAC(vc));

                }
                final VariantContextBuilder builder = new VariantContextBuilder(vc).attributes(attrs);
                VariantContextUtils.calculateChromosomeCounts(builder, false);
                VariantContext newvc = builder.make();

                vcfWriter.add(newvc);
            }

            return null;
        }

        return null;
    }

    /**
     * Provide an initial value for reduce computations.
     *
     * @return Initial value of reduce.
     */
    @Override
    public Integer reduceInit() {
        return null;
    }

    /**
     * Reduces a single map with the accumulator provided as the ReduceType.
     *
     * @param value result of the map.
     * @param sum   accumulator for the reduce.
     * @return accumulator with result of the map taken into account.
     */
    @Override
    public Integer reduce(Integer value, Integer sum) {
        return null;
    }

    @Override
    public Integer treeReduce(Integer sum1, Integer sum2) {
        return reduce(sum1, sum2);
    }
}
