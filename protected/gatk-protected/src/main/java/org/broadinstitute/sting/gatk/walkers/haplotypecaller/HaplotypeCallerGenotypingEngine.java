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

package org.broadinstitute.sting.gatk.walkers.haplotypecaller;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import org.broadinstitute.sting.gatk.GenomeAnalysisEngine;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.genotyper.GenotypeLikelihoodsCalculationModel;
import org.broadinstitute.sting.gatk.walkers.genotyper.GenotypingEngine;
import org.broadinstitute.sting.gatk.walkers.genotyper.GenotypingOutputMode;
import org.broadinstitute.sting.gatk.walkers.genotyper.OutputMode;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.GenomeLocParser;
import org.broadinstitute.sting.utils.Utils;
import org.broadinstitute.sting.utils.collections.DefaultHashMap;
import org.broadinstitute.sting.utils.genotyper.PerReadAlleleLikelihoodMap;
import org.broadinstitute.sting.utils.haplotype.EventMap;
import org.broadinstitute.sting.utils.haplotype.Haplotype;
import org.broadinstitute.sting.utils.haplotype.MergeVariantsAcrossHaplotypes;
import org.broadinstitute.sting.utils.sam.GATKSAMRecord;
import org.broadinstitute.sting.utils.variant.GATKVariantContextUtils;
import org.broadinstitute.variant.variantcontext.*;

import java.util.*;

/**
 * {@link HaplotypeCaller}'s genotyping strategy implementation.
 */
public class HaplotypeCallerGenotypingEngine extends GenotypingEngine<HaplotypeCallerArgumentCollection> {

    private final static List<Allele> NO_CALL = Collections.singletonList(Allele.NO_CALL);

    private MergeVariantsAcrossHaplotypes crossHaplotypeEventMerger;

    /**
     * {@inheritDoc}
     * @param toolkit {@inheritDoc}
     * @param configuration {@inheritDoc}
     */
    public HaplotypeCallerGenotypingEngine(final GenomeAnalysisEngine toolkit, final HaplotypeCallerArgumentCollection configuration) {
        super(toolkit,configuration);
    }

    /**
     * {@inheritDoc}
     * @param toolkit {@inheritDoc}
     * @param configuration {@inheritDoc}
     * @param sampleNames {@inheritDoc}
     */
    public HaplotypeCallerGenotypingEngine(final GenomeAnalysisEngine toolkit, final HaplotypeCallerArgumentCollection configuration, final Set<String> sampleNames) {
        super(toolkit,configuration,sampleNames);
    }


    /**
     * Change the merge variant across haplotypes for this engine.
     *
     * @param crossHaplotypeEventMerger new merger, can be {@code null}.
     */
    public void setCrossHaplotypeEventMerger(final MergeVariantsAcrossHaplotypes crossHaplotypeEventMerger) {
        this.crossHaplotypeEventMerger = crossHaplotypeEventMerger;
    }

    @Override
    protected String callSourceString() {
        return "HC_call";
    }

    @Override
    protected boolean forceKeepAllele(final Allele allele) {
        return allele == GATKVariantContextUtils.NON_REF_SYMBOLIC_ALLELE ||
                configuration.genotypingOutputMode == GenotypingOutputMode.GENOTYPE_GIVEN_ALLELES ||
                configuration.emitReferenceConfidence != ReferenceConfidenceMode.NONE;
    }

    @Override
    protected boolean forceSiteEmission() {
        return configuration.outputMode == OutputMode.EMIT_ALL_SITES || configuration.genotypingOutputMode == GenotypingOutputMode.GENOTYPE_GIVEN_ALLELES;
    }

    /**
     * Carries the result of a call to #assignGenotypeLikelihoods
     */
    public static class CalledHaplotypes {
        private final List<VariantContext> calls;
        private final Set<Haplotype> calledHaplotypes;

        protected CalledHaplotypes(final List<VariantContext> calls, final Set<Haplotype> calledHaplotypes) {
            if ( calls == null ) throw new IllegalArgumentException("calls cannot be null");
            if ( calledHaplotypes == null ) throw new IllegalArgumentException("calledHaplotypes cannot be null");
            if ( Utils.xor(calls.isEmpty(), calledHaplotypes.isEmpty()) )
                throw new IllegalArgumentException("Calls and calledHaplotypes should both be empty or both not but got calls=" + calls + " calledHaplotypes=" + calledHaplotypes);
            this.calls = calls;
            this.calledHaplotypes = calledHaplotypes;
        }

        /**
         * Get the list of calls made at this location
         * @return a non-null (but potentially empty) list of calls
         */
        public List<VariantContext> getCalls() {
            return calls;
        }

        /**
         * Get the set of haplotypes that we actually called (i.e., underlying one of the VCs in getCalls().
         * @return a non-null set of haplotypes
         */
        public Set<Haplotype> getCalledHaplotypes() {
            return calledHaplotypes;
        }
    }

    /**
     * Main entry point of class - given a particular set of haplotypes, samples and reference context, compute
     * genotype likelihoods and assemble into a list of variant contexts and genomic events ready for calling
     *
     * The list of samples we're working with is obtained from the haplotypeReadMap
     *
     * @param haplotypes                             Haplotypes to assign likelihoods to
     * @param haplotypeReadMap                       Map from reads->(haplotypes,likelihoods)
     * @param perSampleFilteredReadList              Map from sample to reads that were filtered after assembly and before calculating per-read likelihoods.
     * @param ref                                    Reference bytes at active region
     * @param refLoc                                 Corresponding active region genome location
     * @param activeRegionWindow                     Active window
     * @param genomeLocParser                        GenomeLocParser
     * @param activeAllelesToGenotype                Alleles to genotype
     * @param emitReferenceConfidence whether we should add a &lt;NON_REF&gt; alternative allele to the result variation contexts.
     *
     * @return                                       A CalledHaplotypes object containing a list of VC's with genotyped events and called haplotypes
     *
     */
    @Requires({"refLoc.containsP(activeRegionWindow)", "haplotypes.size() > 0"})
    @Ensures("result != null")
    // TODO - can this be refactored? this is hard to follow!
    public CalledHaplotypes assignGenotypeLikelihoods( final List<Haplotype> haplotypes,
                                                       final Map<String, PerReadAlleleLikelihoodMap> haplotypeReadMap,
                                                       final Map<String, List<GATKSAMRecord>> perSampleFilteredReadList,
                                                       final byte[] ref,
                                                       final GenomeLoc refLoc,
                                                       final GenomeLoc activeRegionWindow,
                                                       final GenomeLocParser genomeLocParser,
                                                       final RefMetaDataTracker tracker,
                                                       final List<VariantContext> activeAllelesToGenotype,
                                                       final boolean emitReferenceConfidence) {
        // sanity check input arguments
        if (haplotypes == null || haplotypes.isEmpty()) throw new IllegalArgumentException("haplotypes input should be non-empty and non-null, got "+haplotypes);
        if (haplotypeReadMap == null || haplotypeReadMap.isEmpty()) throw new IllegalArgumentException("haplotypeReadMap input should be non-empty and non-null, got "+haplotypeReadMap);
        if (ref == null || ref.length == 0 ) throw new IllegalArgumentException("ref bytes input should be non-empty and non-null, got " + Arrays.toString(ref));
        if (refLoc == null || refLoc.size() != ref.length) throw new IllegalArgumentException(" refLoc must be non-null and length must match ref bytes, got "+refLoc);
        if (activeRegionWindow == null ) throw new IllegalArgumentException("activeRegionWindow must be non-null, got "+activeRegionWindow);
        if (activeAllelesToGenotype == null ) throw new IllegalArgumentException("activeAllelesToGenotype must be non-null, got "+activeAllelesToGenotype);
        if (genomeLocParser == null ) throw new IllegalArgumentException("genomeLocParser must be non-null, got "+genomeLocParser);

        // update the haplotypes so we're ready to call, getting the ordered list of positions on the reference
        // that carry events among the haplotypes
        final TreeSet<Integer> startPosKeySet = decomposeHaplotypesIntoVariantContexts(haplotypes, haplotypeReadMap, ref, refLoc, activeAllelesToGenotype);

        // Walk along each position in the key set and create each event to be outputted
        final Set<Haplotype> calledHaplotypes = new HashSet<>();
        final List<VariantContext> returnCalls = new ArrayList<>();
        final Map<String, Double> emptyDownSamplingMap = new DefaultHashMap<>(0.0);

        for( final int loc : startPosKeySet ) {
            if( loc >= activeRegionWindow.getStart() && loc <= activeRegionWindow.getStop() ) { // genotyping an event inside this active region
                final List<VariantContext> eventsAtThisLoc = getVCsAtThisLocation(haplotypes, loc, activeAllelesToGenotype);

                if( eventsAtThisLoc.isEmpty() ) { continue; }

                // Create the event mapping object which maps the original haplotype events to the events present at just this locus
                final Map<Event, List<Haplotype>> eventMapper = createEventMapper(loc, eventsAtThisLoc, haplotypes);

                // Sanity check the priority list for mistakes
                final List<String> priorityList = makePriorityList(eventsAtThisLoc);

                // Merge the event to find a common reference representation

                VariantContext mergedVC = GATKVariantContextUtils.simpleMerge(eventsAtThisLoc, priorityList, GATKVariantContextUtils.FilteredRecordMergeType.KEEP_IF_ANY_UNFILTERED, GATKVariantContextUtils.GenotypeMergeType.PRIORITIZE, false, false, null, false, false);

                final VariantContextBuilder vcb = new VariantContextBuilder(mergedVC);

                if( mergedVC == null ) { continue; }

                final GenotypeLikelihoodsCalculationModel.Model calculationModel = mergedVC.isSNP()
                        ? GenotypeLikelihoodsCalculationModel.Model.SNP : GenotypeLikelihoodsCalculationModel.Model.INDEL;

                if (emitReferenceConfidence) {
                    final List<Allele> alleleList = new ArrayList<>();
                    alleleList.addAll(mergedVC.getAlleles());
                    alleleList.add(GATKVariantContextUtils.NON_REF_SYMBOLIC_ALLELE);
                    vcb.alleles(alleleList);
                    mergedVC = vcb.make();
                }

                final Map<VariantContext, Allele> mergeMap = new LinkedHashMap<>();
                mergeMap.put(null, mergedVC.getReference()); // the reference event (null) --> the reference allele
                for(int iii = 0; iii < eventsAtThisLoc.size(); iii++) {
                    mergeMap.put(eventsAtThisLoc.get(iii), mergedVC.getAlternateAllele(iii)); // BUGBUG: This is assuming that the order of alleles is the same as the priority list given to simpleMerge function
                }

                final Map<Allele, List<Haplotype>> alleleMapper = createAlleleMapper(mergeMap, eventMapper);

                if( configuration.DEBUG && logger != null ) {
                    if (logger != null) logger.info("Genotyping event at " + loc + " with alleles = " + mergedVC.getAlleles());
                }

                final Map<String, PerReadAlleleLikelihoodMap> alleleReadMap = convertHaplotypeReadMapToAlleleReadMap(haplotypeReadMap, alleleMapper, configuration.getSampleContamination());

                if (emitReferenceConfidence) addMiscellaneousAllele(alleleReadMap);

                final GenotypesContext genotypes = calculateGLsForThisEvent( alleleReadMap, mergedVC );
                final VariantContext call = calculateGenotypes(null,null,null,null,new VariantContextBuilder(mergedVC).genotypes(genotypes).make(), calculationModel, false,null);
                if( call != null ) {
                    final Map<String, PerReadAlleleLikelihoodMap> alleleReadMap_annotations = ( configuration.USE_FILTERED_READ_MAP_FOR_ANNOTATIONS ? alleleReadMap :
                            convertHaplotypeReadMapToAlleleReadMap( haplotypeReadMap, alleleMapper, emptyDownSamplingMap ) );
                    if (emitReferenceConfidence) addMiscellaneousAllele(alleleReadMap_annotations);
                    final Map<String, PerReadAlleleLikelihoodMap> stratifiedReadMap = filterToOnlyOverlappingReads( genomeLocParser, alleleReadMap_annotations, perSampleFilteredReadList, call );

                    VariantContext annotatedCall = annotationEngine.annotateContextForActiveRegion(tracker, stratifiedReadMap, call);

                    if( call.getAlleles().size() != mergedVC.getAlleles().size() )
                        annotatedCall = GATKVariantContextUtils.reverseTrimAlleles(annotatedCall);

                    // maintain the set of all called haplotypes
                    for ( final Allele calledAllele : call.getAlleles() ) {
                        final List<Haplotype> haplotypeList = alleleMapper.get(calledAllele);
                        if (haplotypeList == null) continue;
                        calledHaplotypes.addAll(haplotypeList);
                    }

                    returnCalls.add( annotatedCall );
                }
            }
        }

        return new CalledHaplotypes(returnCalls, calledHaplotypes);
    }

    /**
     * Add the <NON_REF> allele
     * @param stratifiedReadMap target per-read-allele-likelihood-map.
     */
    public static Map<String, PerReadAlleleLikelihoodMap>  addMiscellaneousAllele(final Map<String, PerReadAlleleLikelihoodMap> stratifiedReadMap) {
        final Allele miscellanoeusAllele = GATKVariantContextUtils.NON_REF_SYMBOLIC_ALLELE;
        for (Map.Entry<String, PerReadAlleleLikelihoodMap> perSample : stratifiedReadMap.entrySet()) {
            for (Map.Entry<GATKSAMRecord, Map<Allele, Double>> perRead : perSample.getValue().getLikelihoodReadMap().entrySet()) {
                double bestLikelihood = Double.NEGATIVE_INFINITY;
                double secondBestLikelihood = Double.NEGATIVE_INFINITY;
                for (Map.Entry<Allele,Double> perAllele : perRead.getValue().entrySet()) {
                    final double value = perAllele.getValue();
                    if (value > bestLikelihood) {
                        secondBestLikelihood = bestLikelihood;
                        bestLikelihood = value;
                    } else if (value < bestLikelihood && value > secondBestLikelihood) {
                        secondBestLikelihood = value;
                    }
                }
                final double miscellanousLikelihood = Double.isInfinite(secondBestLikelihood) ? bestLikelihood : secondBestLikelihood;
                perSample.getValue().add(perRead.getKey(),miscellanoeusAllele,miscellanousLikelihood);
            }
        }
        return stratifiedReadMap;
    }

    /**
     * Go through the haplotypes we assembled, and decompose them into their constituent variant contexts
     *
     * @param haplotypes the list of haplotypes we're working with
     * @param haplotypeReadMap map from samples -> the per read allele likelihoods
     * @param ref the reference bases (over the same interval as the haplotypes)
     * @param refLoc the span of the reference bases
     * @param activeAllelesToGenotype alleles we want to ensure are scheduled for genotyping (GGA mode)
     * @return never {@code null} but perhaps an empty list if there is no variants to report.
     */
    private TreeSet<Integer> decomposeHaplotypesIntoVariantContexts(final List<Haplotype> haplotypes,
                                                                    final Map<String, PerReadAlleleLikelihoodMap> haplotypeReadMap,
                                                                    final byte[] ref,
                                                                    final GenomeLoc refLoc,
                                                                    final List<VariantContext> activeAllelesToGenotype) {
        final boolean in_GGA_mode = !activeAllelesToGenotype.isEmpty();

        // Using the cigar from each called haplotype figure out what events need to be written out in a VCF file
        final TreeSet<Integer> startPosKeySet = EventMap.buildEventMapsForHaplotypes(haplotypes, ref, refLoc, configuration.DEBUG);

        if ( in_GGA_mode ) startPosKeySet.clear();

        //cleanUpSymbolicUnassembledEvents( haplotypes ); // We don't make symbolic alleles so this isn't needed currently
        if ( !in_GGA_mode ) {
            // run the event merger if we're not in GGA mode
            if (crossHaplotypeEventMerger == null)
                throw new IllegalStateException(" no variant merger was provided at set-up when needed in GGA mode");
            final boolean mergedAnything = crossHaplotypeEventMerger.merge(haplotypes, haplotypeReadMap, startPosKeySet, ref, refLoc);
            if ( mergedAnything )
                cleanUpSymbolicUnassembledEvents( haplotypes ); // the newly created merged events could be overlapping the unassembled events
        }

        if ( in_GGA_mode ) {
            for( final VariantContext compVC : activeAllelesToGenotype ) {
                startPosKeySet.add( compVC.getStart() );
            }
        }

        return startPosKeySet;
    }

    /**
     * Get the priority list (just the list of sources for these variant context) used to merge overlapping events into common reference view
     * @param vcs a list of variant contexts
     * @return the list of the sources of vcs in the same order
     */
    private List<String> makePriorityList(final List<VariantContext> vcs) {
        final List<String> priorityList = new LinkedList<>();
        for ( final VariantContext vc : vcs ) priorityList.add(vc.getSource());
        return priorityList;
    }

    private List<VariantContext> getVCsAtThisLocation(final List<Haplotype> haplotypes,
                                                      final int loc,
                                                      final List<VariantContext> activeAllelesToGenotype) {
        // the overlapping events to merge into a common reference view
        final List<VariantContext> eventsAtThisLoc = new ArrayList<>();

        if( activeAllelesToGenotype.isEmpty() ) {
            for( final Haplotype h : haplotypes ) {
                final EventMap eventMap = h.getEventMap();
                final VariantContext vc = eventMap.get(loc);
                if( vc != null && !containsVCWithMatchingAlleles(eventsAtThisLoc, vc) ) {
                    eventsAtThisLoc.add(vc);
                }
            }
        } else { // we are in GGA mode!
            int compCount = 0;
            for( final VariantContext compVC : activeAllelesToGenotype ) {
                if( compVC.getStart() == loc ) {
                    int alleleCount = 0;
                    for( final Allele compAltAllele : compVC.getAlternateAlleles() ) {
                        List<Allele> alleleSet = new ArrayList<>(2);
                        alleleSet.add(compVC.getReference());
                        alleleSet.add(compAltAllele);
                        final String vcSourceName = "Comp" + compCount + "Allele" + alleleCount;
                        // check if this event is already in the list of events due to a repeat in the input alleles track
                        final VariantContext candidateEventToAdd = new VariantContextBuilder(compVC).alleles(alleleSet).source(vcSourceName).make();
                        boolean alreadyExists = false;
                        for( final VariantContext eventToTest : eventsAtThisLoc ) {
                            if( eventToTest.hasSameAllelesAs(candidateEventToAdd) ) {
                                alreadyExists = true;
                            }
                        }
                        if( !alreadyExists ) {
                            eventsAtThisLoc.add(candidateEventToAdd);
                        }
                        alleleCount++;
                    }
                }
                compCount++;
            }
        }

        return eventsAtThisLoc;
    }

    /**
     * For a particular event described in inputVC, form PL vector for each sample by looking into allele read map and filling likelihood matrix for each allele
     * @param alleleReadMap          Allele map describing mapping from reads to alleles and corresponding likelihoods
     * @param mergedVC               Input VC with event to genotype
     * @return                       GenotypesContext object wrapping genotype objects with PLs
     */
    @Requires({"alleleReadMap!= null", "mergedVC != null"})
    @Ensures("result != null")
    private GenotypesContext calculateGLsForThisEvent( final Map<String, PerReadAlleleLikelihoodMap> alleleReadMap, final VariantContext mergedVC ) {
        final GenotypesContext genotypes = GenotypesContext.create(alleleReadMap.size());
        // Grab the genotype likelihoods from the appropriate places in the haplotype likelihood matrix -- calculation performed independently per sample
        for( final String sample : alleleReadMap.keySet() ) {
            final int numHaplotypes = mergedVC.getAlleles().size();
            final double[] genotypeLikelihoods = new double[numHaplotypes * (numHaplotypes+1) / 2];
            final double[][] haplotypeLikelihoodMatrix = PairHMMLikelihoodCalculationEngine.computeDiploidHaplotypeLikelihoods(sample, alleleReadMap, mergedVC.getAlleles(), true);
            int glIndex = 0;
            for( int iii = 0; iii < numHaplotypes; iii++ ) {
                for( int jjj = 0; jjj <= iii; jjj++ ) {
                    genotypeLikelihoods[glIndex++] = haplotypeLikelihoodMatrix[iii][jjj]; // for example: AA,AB,BB,AC,BC,CC
                }
            }
            genotypes.add(new GenotypeBuilder(sample).alleles(NO_CALL).PL(genotypeLikelihoods).make());
        }
        return genotypes;
    }

    private static Map<String, PerReadAlleleLikelihoodMap> filterToOnlyOverlappingReads( final GenomeLocParser parser,
                                                                                         final Map<String, PerReadAlleleLikelihoodMap> perSampleReadMap,
                                                                                         final Map<String, List<GATKSAMRecord>> perSampleFilteredReadList,
                                                                                         final VariantContext call ) {

        final Map<String, PerReadAlleleLikelihoodMap> returnMap = new LinkedHashMap<>();
        final GenomeLoc callLoc = parser.createGenomeLoc(call);
        for( final Map.Entry<String, PerReadAlleleLikelihoodMap> sample : perSampleReadMap.entrySet() ) {
            final PerReadAlleleLikelihoodMap likelihoodMap = new PerReadAlleleLikelihoodMap();

            for( final Map.Entry<GATKSAMRecord,Map<Allele,Double>> mapEntry : sample.getValue().getLikelihoodReadMap().entrySet() ) {
                // only count the read if it overlaps the event, otherwise it is not added to the output read list at all
                if( callLoc.overlapsP(parser.createGenomeLoc(mapEntry.getKey())) ) { // BUGBUG: This uses alignment start and stop, NOT soft start and soft end...
                    for( final Map.Entry<Allele,Double> alleleDoubleEntry : mapEntry.getValue().entrySet() ) {
                        likelihoodMap.add(mapEntry.getKey(), alleleDoubleEntry.getKey(), alleleDoubleEntry.getValue());
                    }
                }
            }

            // add all filtered reads to the NO_CALL list because they weren't given any likelihoods
            for( final GATKSAMRecord read : perSampleFilteredReadList.get(sample.getKey()) ) {
                // only count the read if it overlaps the event, otherwise it is not added to the output read list at all
                if( callLoc.overlapsP(parser.createGenomeLoc(read)) ) {
                    for( final Allele allele : call.getAlleles() ) {
                        likelihoodMap.add(read, allele, 0.0);
                    }
                }
            }

            returnMap.put(sample.getKey(), likelihoodMap);
        }
        return returnMap;
    }

    /**
     * Removes symbolic events from list of haplotypes
     * @param haplotypes       Input/output list of haplotypes, before/after removal
     */
    // TODO - split into input haplotypes and output haplotypes as not to share I/O arguments
    @Requires("haplotypes != null")
    protected static void cleanUpSymbolicUnassembledEvents( final List<Haplotype> haplotypes ) {
        final List<Haplotype> haplotypesToRemove = new ArrayList<>();
        for( final Haplotype h : haplotypes ) {
            for( final VariantContext vc : h.getEventMap().getVariantContexts() ) {
                if( vc.isSymbolic() ) {
                    for( final Haplotype h2 : haplotypes ) {
                        for( final VariantContext vc2 : h2.getEventMap().getVariantContexts() ) {
                            if( vc.getStart() == vc2.getStart() && (vc2.isIndel() || vc2.isMNP()) ) { // unfortunately symbolic alleles can't currently be combined with non-point events
                                haplotypesToRemove.add(h);
                                break;
                            }
                        }
                    }
                }
            }
        }
        haplotypes.removeAll(haplotypesToRemove);
    }

    // BUGBUG: ugh, too complicated
    protected Map<String, PerReadAlleleLikelihoodMap> convertHaplotypeReadMapToAlleleReadMap( final Map<String, PerReadAlleleLikelihoodMap> haplotypeReadMap,
                                                                                              final Map<Allele, List<Haplotype>> alleleMapper,
                                                                                              final Map<String,Double> perSampleDownsamplingFraction ) {

        final Map<String, PerReadAlleleLikelihoodMap> alleleReadMap = new LinkedHashMap<>();
        for( final Map.Entry<String, PerReadAlleleLikelihoodMap> haplotypeReadMapEntry : haplotypeReadMap.entrySet() ) { // for each sample
            final PerReadAlleleLikelihoodMap perReadAlleleLikelihoodMap = new PerReadAlleleLikelihoodMap();
            for( final Map.Entry<Allele, List<Haplotype>> alleleMapperEntry : alleleMapper.entrySet() ) { // for each output allele
                final List<Haplotype> mappedHaplotypes = alleleMapperEntry.getValue();
                for( final Map.Entry<GATKSAMRecord, Map<Allele,Double>> readEntry : haplotypeReadMapEntry.getValue().getLikelihoodReadMap().entrySet() ) { // for each read
                    double maxLikelihood = Double.NEGATIVE_INFINITY;
                    for( final Map.Entry<Allele,Double> alleleDoubleEntry : readEntry.getValue().entrySet() ) { // for each input allele
                        if( mappedHaplotypes.contains( new Haplotype(alleleDoubleEntry.getKey())) ) { // exact match of haplotype base string
                            maxLikelihood = Math.max( maxLikelihood, alleleDoubleEntry.getValue() );
                        }
                    }
                    perReadAlleleLikelihoodMap.add(readEntry.getKey(), alleleMapperEntry.getKey(), maxLikelihood);
                }
            }
            perReadAlleleLikelihoodMap.performPerAlleleDownsampling(perSampleDownsamplingFraction.get(haplotypeReadMapEntry.getKey())); // perform contamination downsampling
            alleleReadMap.put(haplotypeReadMapEntry.getKey(), perReadAlleleLikelihoodMap);
        }

        return alleleReadMap;
    }

    protected static Map<Allele, List<Haplotype>> createAlleleMapper( final Map<VariantContext, Allele> mergeMap, final Map<Event, List<Haplotype>> eventMap ) {
        final Map<Allele, List<Haplotype>> alleleMapper = new LinkedHashMap<>();
        for( final Map.Entry<VariantContext, Allele> entry : mergeMap.entrySet() ) {
            alleleMapper.put(entry.getValue(), eventMap.get(new Event(entry.getKey())));
        }
        return alleleMapper;
    }

    @Requires({"haplotypes.size() >= eventsAtThisLoc.size() + 1"})
    @Ensures({"result.size() == eventsAtThisLoc.size() + 1"})
    protected static Map<Event, List<Haplotype>> createEventMapper( final int loc, final List<VariantContext> eventsAtThisLoc, final List<Haplotype> haplotypes ) {

        final Map<Event, List<Haplotype>> eventMapper = new LinkedHashMap<>(eventsAtThisLoc.size()+1);
        final Event refEvent = new Event(null);
        eventMapper.put(refEvent, new ArrayList<Haplotype>());
        for( final VariantContext vc : eventsAtThisLoc ) {
            eventMapper.put(new Event(vc), new ArrayList<Haplotype>());
        }

        for( final Haplotype h : haplotypes ) {
            if( h.getEventMap().get(loc) == null ) {
                eventMapper.get(refEvent).add(h);
            } else {
                for( final VariantContext vcAtThisLoc : eventsAtThisLoc ) {
                    if( h.getEventMap().get(loc).hasSameAllelesAs(vcAtThisLoc) ) {
                        eventMapper.get(new Event(vcAtThisLoc)).add(h);
                        break;
                    }
                }
            }
        }

        return eventMapper;
    }

    @Ensures({"result.size() == haplotypeAllelesForSample.size()"})
    protected static List<Allele> findEventAllelesInSample( final List<Allele> eventAlleles, final List<Allele> haplotypeAlleles, final List<Allele> haplotypeAllelesForSample, final List<List<Haplotype>> alleleMapper, final List<Haplotype> haplotypes ) {
        if( haplotypeAllelesForSample.contains(Allele.NO_CALL) ) { return NO_CALL; }
        final List<Allele> eventAllelesForSample = new ArrayList<>();
        for( final Allele a : haplotypeAllelesForSample ) {
            final Haplotype haplotype = haplotypes.get(haplotypeAlleles.indexOf(a));
            for( int iii = 0; iii < alleleMapper.size(); iii++ ) {
                final List<Haplotype> mappedHaplotypes = alleleMapper.get(iii);
                if( mappedHaplotypes.contains(haplotype) ) {
                    eventAllelesForSample.add(eventAlleles.get(iii));
                    break;
                }
            }
        }
        return eventAllelesForSample;
    }

    @Deprecated
    protected static Map<Integer,VariantContext> generateVCsFromAlignment( final Haplotype haplotype, final byte[] ref, final GenomeLoc refLoc, final String sourceNameToAdd ) {
        return new EventMap(haplotype, ref, refLoc, sourceNameToAdd);
    }

    protected static boolean containsVCWithMatchingAlleles( final List<VariantContext> list, final VariantContext vcToTest ) {
        for( final VariantContext vc : list ) {
            if( vc.hasSameAllelesAs(vcToTest) ) {
                return true;
            }
        }
        return false;
    }

    protected static class Event {
        public VariantContext vc;

        public Event( final VariantContext vc ) {
            this.vc = vc;
        }

        @Override
        public boolean equals( final Object obj ) {
            return obj instanceof Event && ((((Event) obj).vc == null && vc == null) || (((Event) obj).vc != null && vc != null && ((Event) obj).vc.hasSameAllelesAs(vc))) ;
        }

        @Override
        public int hashCode() {
            return (vc == null ? -1 : vc.getAlleles().hashCode());
        }
    }
}