package org.broadinstitute.sting.gatk.walkers.varianteval.stratifications;

import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.varianteval.evaluators.VariantEvaluator;
import org.broadinstitute.sting.gatk.walkers.varianteval.evaluators.VariantSummary;
import org.broadinstitute.sting.utils.codecs.vcf.VCFConstants;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.variantcontext.Allele;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;

import java.util.*;

/**
 * Stratifies the eval RODs by the allele count of the alternate allele
 *
 * Looks first at the MLEAC value in the INFO field, and uses that value if present.
 * If not present, it then looks for the AC value in the INFO field.  If both are absent,
 * it computes the AC from the genotypes themselves.  If no AC can be computed, 0 is used.
 */
public class AlleleCount extends VariantStratifier {
    int nchrom;

    @Override
    public void initialize() {
        // we can only work with a single eval VCF, and it must have genotypes
        if ( getVariantEvalWalker().getEvals().size() != 1 && !getVariantEvalWalker().mergeEvals )
            throw new UserException.BadArgumentValue("AlleleCount", "AlleleCount stratification only works with a single eval vcf");

        // There are 2 x n sample chromosomes for diploids
        // TODO -- generalize to handle multiple ploidy
        nchrom = getVariantEvalWalker().getSampleNamesForEvaluation().size() * 2;
        if ( nchrom < 2 )
            throw new UserException.BadArgumentValue("AlleleCount", "AlleleCount stratification requires an eval vcf with at least one sample");

        // create an array containing each of the allele counts
        for( int ac = 0; ac <= nchrom; ac++ ) {
            states.add(ac);
        }

        getVariantEvalWalker().getLogger().info("AlleleCount using " + nchrom + " chromosomes");
    }

    public List<Object> getRelevantStates(ReferenceContext ref, RefMetaDataTracker tracker, VariantContext comp, String compName, VariantContext eval, String evalName, String sampleName) {
        if (eval != null) {
            int AC = 0; // by default, the site is considered monomorphic

            try {
                if ( eval.isBiallelic() ) {
                    if ( eval.hasAttribute(VCFConstants.MLE_ALLELE_COUNT_KEY) ) {
                        // the MLEAC is allowed to be larger than the AN (e.g. in the case of all PLs being 0, the GT is ./. but the exact model may arbitrarily choose an AC>1)
                        AC = Math.min(eval.getAttributeAsInt(VCFConstants.MLE_ALLELE_COUNT_KEY, 0), nchrom);
                    } else if ( eval.hasAttribute(VCFConstants.ALLELE_COUNT_KEY) ) {
                        AC = eval.getAttributeAsInt(VCFConstants.ALLELE_COUNT_KEY, 0);
                    }
                }
            } catch ( ClassCastException e ) {
                // protect ourselves from bad inputs
                // TODO -- fully decode VC
            }

            if ( AC == 0 && eval.isVariant() ) {
                // fall back to the direct calculation
                for (Allele allele : eval.getAlternateAlleles())
                    AC = Math.max(AC, eval.getCalledChrCount(allele));
            }

            // make sure that the AC isn't invalid
            if ( AC > nchrom )
                throw new UserException.MalformedVCF(String.format("The AC value (%d) at position %s:%d " +
                        "is larger than the number of chromosomes over all samples (%d)", AC,
                        eval.getChr(), eval.getStart(), nchrom));

            return Collections.singletonList((Object) AC);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Set<Class<? extends VariantEvaluator>> getIncompatibleEvaluators() {
        return new HashSet<Class<? extends VariantEvaluator>>(Arrays.asList(VariantSummary.class));
    }

    @Override
    public String getFormat() {
        return "%d";
    }
}
