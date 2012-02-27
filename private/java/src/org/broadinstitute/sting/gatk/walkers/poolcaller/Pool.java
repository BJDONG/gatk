package org.broadinstitute.sting.gatk.walkers.poolcaller;

import org.broadinstitute.sting.utils.BaseUtils;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.pileup.ReadBackedPileup;
import org.broadinstitute.sting.utils.variantcontext.Allele;
import org.broadinstitute.sting.utils.variantcontext.Genotype;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: carneiro
 * Date: 7/21/11
 * Time: 1:29 PM
 *
 * This is a site based implementation of a pool.
 * A pool object will contain all the information pertinent to a pool in one given site
 */

public class Pool {
    private String name;
    private ReadBackedPileup pileup;
    private AlleleCountModel alleleCountModel;
    private int matches;
    private int mismatches;
    private byte referenceSequenceBase;
    //private Set<Filters> filters;
    private Integer calledAC;
    private byte calledAllele;
   // private double log10LikelihoodCall;

    public Pool(String name, ReadBackedPileup pileup, ErrorModel errorModel, byte referenceSequenceBase, int maxAlleleCount, double minCallQual, 
                int minRefDepth, boolean doAlleleDiscovery, List<Allele> allelesToTest) {
        this.name = name;
        this.pileup = pileup;
//        this.maxAlleleCount = maxAlleleCount;
        this.referenceSequenceBase = referenceSequenceBase;

        byte [] data = pileup.getBases();
        int coverage = data.length;

        int idx = 0;
        Integer[] numSeenBases = new Integer[BaseUtils.BASES.length];
        for (byte base:BaseUtils.BASES)
            numSeenBases[idx++] = MathUtils.countOccurrences(base, data);

        // todo - generalize for indels
     //   System.out.format("A:%d C:%d G:%d T:%t\n",numSeenBases[0],numSeenBases[1],numSeenBases[2],numSeenBases[3]);
        alleleCountModel = new AlleleCountModel(maxAlleleCount, errorModel, numSeenBases, minCallQual, referenceSequenceBase, doAlleleDiscovery, allelesToTest);

       // isConfidentlyCalled = alleleCountModel.isConfidentlyCalled();
        calledAC = alleleCountModel.getMaximumLikelihoodIndex();
        calledAllele = (calledAC == 0) ?  referenceSequenceBase : alleleCountModel.getAltBase();


  //      log10LikelihoodCall = alleleCountModel.getMaximumLikelihood();
    }

    /**
     * @return the name of the pool (sample name of the pool in the bam file)
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name of the pool (sample name of the pool in the bam file)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The pileup for the pool in its location
     */
    public ReadBackedPileup getPileup() {
        return pileup;
    }

    /**
     * @return the number of bases in the pool pileup
     */
    public int size() {
        return pileup.getNumberOfElements();
    }

    /**
     * @return the allele count model
     */
    public AlleleCountModel getAlleleCountModel() {
        return alleleCountModel;
    }

    /**
     * @return Whether or not the site is filtered
     */
    public boolean isFiltered() {
        return !isCalled();
    }

    /**
     * @return whether or not the site is called
     */
    public boolean isCalled() {
        return calledAC != null;
    }

    /**
     *
     */
    public boolean isRef() {
        return alleleCountModel.getAltBase() == referenceSequenceBase;
    }

    public boolean isVariant() {
        return alleleCountModel.isVariant();
    }
    /**
     * Returns a list of the filters applied to this call. Empty list if nothing was filtered.
     */
 /*   public Set<String> getFilters() {
        Set<String> result = new HashSet<String>(filters.size());
        for (Filters f : filters) {
            result.add(f.toString());    // maybe have a place to get the string definition of each filter in the future?
        }
        return result;
    }
   */

    /**
     * Builds the Genotype object for the pool. It takes the most frequent alternate allele if the
     * pool is variant or the ref allele if it isn't.
     *
     * @return the Genotype object of the pool.
     */
    public Map<String, Genotype> getGenotypes() {
        Map<String, Genotype> poolGenotype = new HashMap<String, Genotype>(1);
        byte base;

        // I don't need the reference base to be counted as we are looking for the most common alternate allele.
        if (isRef()) {
            base = referenceSequenceBase;
        }
        else {
            base = getAlleleCountModel().getAltBase();
        }

        List<Allele> alleleList = new LinkedList<Allele>();
        alleleList.add(Allele.create(base, isRef()));
        Genotype g = new Genotype(name, alleleList, -getAlleleCountModel().getNegLog10PError());
        poolGenotype.put(name, g);
        return poolGenotype;
    }

}
