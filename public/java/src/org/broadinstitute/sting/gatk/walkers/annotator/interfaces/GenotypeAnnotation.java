package org.broadinstitute.sting.gatk.walkers.annotator.interfaces;

import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.utils.codecs.vcf.VCFFormatHeaderLine;
import org.broadinstitute.sting.utils.variantcontext.Genotype;
import org.broadinstitute.sting.utils.variantcontext.GenotypeBuilder;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;

import java.util.List;

public abstract class GenotypeAnnotation extends VariantAnnotatorAnnotation {

    // return annotations for the given contexts/genotype split by sample
    public abstract void annotate(RefMetaDataTracker tracker, AnnotatorCompatible walker,
                                  ReferenceContext ref, AlignmentContext stratifiedContext,
                                  VariantContext vc, Genotype g, GenotypeBuilder gb );

    // return the descriptions used for the VCF FORMAT meta field
    public abstract List<VCFFormatHeaderLine> getDescriptions();

}