/*
 * Copyright (c) 2011 The Broad Institute
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

package org.broadinstitute.sting.gatk.walkers.haplotypecaller;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import net.sf.samtools.Cigar;
import net.sf.samtools.CigarElement;
import org.apache.commons.lang.ArrayUtils;
import org.broadinstitute.sting.gatk.walkers.genotyper.UnifiedGenotyperEngine;
import org.broadinstitute.sting.utils.*;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.variantcontext.*;

import java.util.*;

public class GenotypingEngine {

    private final boolean DEBUG;
    private final boolean OUTPUT_FULL_HAPLOTYPE_SEQUENCE;
    private final static List<Allele> noCall = new ArrayList<Allele>(); // used to noCall all genotypes until the exact model is applied
    private final static Allele SYMBOLIC_UNASSEMBLED_EVENT_ALLELE = Allele.create("<UNASSEMBLED_EVENT>", false);

    public GenotypingEngine( final boolean DEBUG, final boolean OUTPUT_FULL_HAPLOTYPE_SEQUENCE ) {
        this.DEBUG = DEBUG;
        this.OUTPUT_FULL_HAPLOTYPE_SEQUENCE = OUTPUT_FULL_HAPLOTYPE_SEQUENCE;
        noCall.add(Allele.NO_CALL);
    }

    // BUGBUG: Create a class to hold this complicated return type
    @Requires({"refLoc.containsP(activeRegionWindow)", "haplotypes.size() > 0"})
    public List<Pair<VariantContext, Map<Allele, List<Haplotype>>>> assignGenotypeLikelihoodsAndCallIndependentEvents( final UnifiedGenotyperEngine UG_engine,
                                                                                                                       final List<Haplotype> haplotypes,
                                                                                                                       final byte[] ref,
                                                                                                                       final GenomeLoc refLoc,
                                                                                                                       final GenomeLoc activeRegionWindow,
                                                                                                                       final GenomeLocParser genomeLocParser,
                                                                                                                       final List<VariantContext> activeAllelesToGenotype ) {

        final ArrayList<Pair<VariantContext, Map<Allele, List<Haplotype>>>> returnCalls = new ArrayList<Pair<VariantContext, Map<Allele, List<Haplotype>>>>();

        // Using the cigar from each called haplotype figure out what events need to be written out in a VCF file
        final TreeSet<Integer> startPosKeySet = new TreeSet<Integer>();
        int count = 0;
        if( DEBUG ) { System.out.println("=== Best Haplotypes ==="); }
        for( final Haplotype h : haplotypes ) {
            // Walk along the alignment and turn any difference from the reference into an event
            h.setEventMap( generateVCsFromAlignment( h, h.getAlignmentStartHapwrtRef(), h.getCigar(), ref, h.getBases(), refLoc, "HC" + count++ ) );
            if( activeAllelesToGenotype.isEmpty() ) { startPosKeySet.addAll(h.getEventMap().keySet()); }
            if( DEBUG ) {
                System.out.println( h.toString() );
                System.out.println( "> Cigar = " + h.getCigar() );
                System.out.println( "> Left and right breaks = (" + h.leftBreakPoint + " , " + h.rightBreakPoint + ")");
                System.out.println( ">> Events = " + h.getEventMap());
            }
        }

        cleanUpSymbolicUnassembledEvents( haplotypes );
        if( activeAllelesToGenotype.isEmpty() && haplotypes.get(0).getSampleKeySet().size() >= 10 ) { // if not in GGA mode and have at least 10 samples try to create MNP and complex events by looking at LD structure
            mergeConsecutiveEventsBasedOnLD( haplotypes, startPosKeySet, ref, refLoc );
        }
        if( !activeAllelesToGenotype.isEmpty() ) { // we are in GGA mode!
            for( final VariantContext compVC : activeAllelesToGenotype ) {
                startPosKeySet.add( compVC.getStart() );
            }
        }

        // Walk along each position in the key set and create each event to be outputted
        for( final int loc : startPosKeySet ) {
            if( loc >= activeRegionWindow.getStart() && loc <= activeRegionWindow.getStop() ) {
                final ArrayList<VariantContext> eventsAtThisLoc = new ArrayList<VariantContext>(); // the overlapping events to merge into a common reference view
                final ArrayList<String> priorityList = new ArrayList<String>(); // used to merge overlapping events into common reference view

                if( activeAllelesToGenotype.isEmpty() ) {
                    for( final Haplotype h : haplotypes ) {
                        final HashMap<Integer,VariantContext> eventMap = h.getEventMap();
                        final VariantContext vc = eventMap.get(loc);
                        if( vc != null && !containsVCWithMatchingAlleles(eventsAtThisLoc, vc) ) {
                            eventsAtThisLoc.add(vc);
                            priorityList.add(vc.getSource());
                        }
                    }
                } else { // we are in GGA mode!
                    for( final VariantContext compVC : activeAllelesToGenotype ) {
                        if( compVC.getStart() == loc ) {
                            priorityList.clear();
                            int alleleCount = 0;
                            for( final Allele compAltAllele : compVC.getAlternateAlleles() ) {
                                HashSet<Allele> alleleSet = new HashSet<Allele>(2);
                                alleleSet.add(compVC.getReference());
                                alleleSet.add(compAltAllele);
                                priorityList.add("Allele" + alleleCount);
                                eventsAtThisLoc.add(new VariantContextBuilder(compVC).alleles(alleleSet).source("Allele"+alleleCount).make());
                                alleleCount++;
                            }
                        }
                    }
                }

                if( eventsAtThisLoc.isEmpty() ) { continue; }

                // Create the allele mapping object which maps the original haplotype alleles to the alleles present in just this event
                Map<Allele, List<Haplotype>> alleleMapper = createAlleleMapper( loc, eventsAtThisLoc, haplotypes );

                final Allele refAllele = eventsAtThisLoc.get(0).getReference();
                final ArrayList<Allele> alleleOrdering = new ArrayList<Allele>(alleleMapper.size());
                alleleOrdering.add(refAllele);
                for ( final Allele allele : alleleMapper.keySet() ) {
                    if ( !refAllele.equals(allele) )
                        alleleOrdering.add(allele);
                }

                // Sanity check the priority list
                for( final VariantContext vc : eventsAtThisLoc ) {
                    if( !priorityList.contains(vc.getSource()) ) {
                        throw new ReviewedStingException("Event found on haplotype that wasn't added to priority list. Something went wrong in the merging of alleles.");
                    }
                }
                for( final String name : priorityList ) {
                    boolean found = false;
                    for( final VariantContext vc : eventsAtThisLoc ) {
                        if(vc.getSource().equals(name)) { found = true; break; }
                    }
                    if( !found ) {
                        throw new ReviewedStingException("Event added to priority list but wasn't found on any haplotype. Something went wrong in the merging of alleles.");
                    }
                }

                // Merge the event to find a common reference representation
                final VariantContext mergedVC = VariantContextUtils.simpleMerge(genomeLocParser, eventsAtThisLoc, priorityList, VariantContextUtils.FilteredRecordMergeType.KEEP_IF_ANY_UNFILTERED, VariantContextUtils.GenotypeMergeType.PRIORITIZE, false, false, null, false, false);
                if( mergedVC == null ) { continue; }

                if( DEBUG ) {
                    System.out.println("Genotyping event at " + loc + " with alleles = " + mergedVC.getAlleles());
                    //System.out.println("Event/haplotype allele mapping = " + alleleMapper);
                }

                // Grab the genotype likelihoods from the appropriate places in the haplotype likelihood matrix -- calculation performed independently per sample
                final GenotypesContext genotypes = GenotypesContext.create(haplotypes.get(0).getSampleKeySet().size());
                for( final String sample : haplotypes.get(0).getSampleKeySet() ) { // BUGBUG: assume all haplotypes saw the same samples
                    final int numHaplotypes = alleleMapper.size();
                    final double[] genotypeLikelihoods = new double[numHaplotypes * (numHaplotypes+1) / 2];
                    final double[][] haplotypeLikelihoodMatrix = LikelihoodCalculationEngine.computeDiploidHaplotypeLikelihoods(sample, alleleMapper, alleleOrdering);
                    int glIndex = 0;
                    for( int iii = 0; iii < numHaplotypes; iii++ ) {
                        for( int jjj = 0; jjj <= iii; jjj++ ) {
                            genotypeLikelihoods[glIndex++] = haplotypeLikelihoodMatrix[iii][jjj]; // for example: AA,AB,BB,AC,BC,CC
                        }
                    }
                    genotypes.add( new GenotypeBuilder(sample).alleles(noCall).PL(genotypeLikelihoods).make() );
                }
                VariantContext call = UG_engine.calculateGenotypes(new VariantContextBuilder(mergedVC).genotypes(genotypes).make(), UG_engine.getUAC().GLmodel);
                if( call != null ) {
                    if( call.getAlleles().size() != mergedVC.getAlleles().size() ) { // some alleles were removed so reverseTrimming might be necessary!
                        final VariantContext vcCallTrim = VariantContextUtils.reverseTrimAlleles(call);
                        // also, need to update the allele -> haplotype mapping
                        final HashMap<Allele, List<Haplotype>> alleleHashMapTrim = new HashMap<Allele, List<Haplotype>>();
                        for( int iii = 0; iii < vcCallTrim.getAlleles().size(); iii++ ) { // BUGBUG: this is assuming that the original and trimmed alleles maintain the same ordering in the VC
                            alleleHashMapTrim.put(vcCallTrim.getAlleles().get(iii), alleleMapper.get(call.getAlleles().get(iii)));
                        }

                        call = vcCallTrim;
                        alleleMapper = alleleHashMapTrim;
                    }

                    returnCalls.add( new Pair<VariantContext, Map<Allele,List<Haplotype>>>(call, alleleMapper) );
                }
            }
        }
        return returnCalls;
    }

    protected static void cleanUpSymbolicUnassembledEvents( final List<Haplotype> haplotypes ) {
        final ArrayList<Haplotype> haplotypesToRemove = new ArrayList<Haplotype>();
        for( final Haplotype h : haplotypes ) {
            for( final VariantContext vc : h.getEventMap().values() ) {
                if( vc.isSymbolic() ) {
                    for( final Haplotype h2 : haplotypes ) {
                        for( final VariantContext vc2 : h2.getEventMap().values() ) {
                            if( vc.getStart() == vc2.getStart() && vc2.isIndel() ) {
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

    protected void mergeConsecutiveEventsBasedOnLD( final List<Haplotype> haplotypes, final TreeSet<Integer> startPosKeySet, final byte[] ref, final GenomeLoc refLoc ) {
        final int MAX_SIZE_TO_COMBINE = 15;
        final double MERGE_EVENTS_R2_THRESHOLD = 0.95;
        if( startPosKeySet.size() <= 1 ) { return; }

        boolean mapWasUpdated = true;
        while( mapWasUpdated ) {
            mapWasUpdated = false;

            // loop over the set of start locations and consider pairs that start near each other
            final Iterator<Integer> iter = startPosKeySet.iterator();
            int thisStart = iter.next();
            while( iter.hasNext() ) {
                final int nextStart = iter.next();
                if( nextStart - thisStart < MAX_SIZE_TO_COMBINE) {
                    boolean isBiallelic = true;
                    VariantContext thisVC = null;
                    VariantContext nextVC = null;
                    double x11 = Double.NEGATIVE_INFINITY;
                    double x12 = Double.NEGATIVE_INFINITY;
                    double x21 = Double.NEGATIVE_INFINITY;
                    double x22 = Double.NEGATIVE_INFINITY;

                    for( final Haplotype h : haplotypes ) {
                        // only make complex substitutions out of consecutive biallelic sites
                        final VariantContext thisHapVC = h.getEventMap().get(thisStart);
                        if( thisHapVC != null && !thisHapVC.isSymbolic() ) { // something was found at this location on this haplotype
                            if( thisVC == null ) {
                                thisVC = thisHapVC;
                            } else if( !thisHapVC.hasSameAllelesAs( thisVC ) ) {
                                isBiallelic = false;
                                break;
                            }
                        }
                        final VariantContext nextHapVC = h.getEventMap().get(nextStart);
                        if( nextHapVC != null && !nextHapVC.isSymbolic() ) { // something was found at the next location on this haplotype
                            if( nextVC == null ) {
                                nextVC = nextHapVC;
                            } else if( !nextHapVC.hasSameAllelesAs( nextVC ) ) {
                                isBiallelic = false;
                                break;
                            }
                        }
                        // count up the co-occurrences of the events for the R^2 calculation
                        final ArrayList<Haplotype> haplotypeList = new ArrayList<Haplotype>();
                        haplotypeList.add(h);
                        for( final String sample : haplotypes.get(0).getSampleKeySet() ) {
                            final HashSet<String> sampleSet = new HashSet<String>(1);
                            sampleSet.add(sample);
                            final double haplotypeLikelihood = LikelihoodCalculationEngine.computeDiploidHaplotypeLikelihoods( sampleSet,  haplotypeList )[0][0];
                            if( thisHapVC == null ) {
                                if( nextHapVC == null ) { x11 = MathUtils.approximateLog10SumLog10(x11, haplotypeLikelihood); }
                                else { x12 = MathUtils.approximateLog10SumLog10(x12, haplotypeLikelihood); }
                            } else {
                                if( nextHapVC == null ) { x21 = MathUtils.approximateLog10SumLog10(x21, haplotypeLikelihood); }
                                else { x22 = MathUtils.approximateLog10SumLog10(x22, haplotypeLikelihood); }
                            }
                        }
                    }
                    if( thisVC == null || nextVC == null ) {
                        continue;
                    }
                    if( isBiallelic ) {
                        final double R2 = calculateR2LD( Math.pow(10.0, x11), Math.pow(10.0, x12), Math.pow(10.0, x21), Math.pow(10.0, x22) );
                        if( DEBUG ) {
                            System.out.println("Found consecutive biallelic events with R^2 = " + String.format("%.4f", R2));
                            System.out.println("-- " + thisVC);
                            System.out.println("-- " + nextVC);
                        }
                        if( R2 > MERGE_EVENTS_R2_THRESHOLD ) {

                            final VariantContext mergedVC = createMergedVariantContext(thisVC, nextVC, ref, refLoc);

                            // remove the old event from the eventMap on every haplotype and the start pos key set, replace with merged event
                            for( final Haplotype h : haplotypes ) {
                                final HashMap<Integer, VariantContext> eventMap = h.getEventMap();
                                if( eventMap.containsKey(thisStart) && eventMap.containsKey(nextStart) ) {
                                    eventMap.remove(thisStart);
                                    eventMap.remove(nextStart);
                                    eventMap.put(mergedVC.getStart(), mergedVC);
                                }
                            }
                            startPosKeySet.add(mergedVC.getStart());
                            boolean containsStart = false;
                            boolean containsNext = false;
                            for( final Haplotype h : haplotypes ) {
                                final HashMap<Integer, VariantContext> eventMap = h.getEventMap();
                                if( eventMap.containsKey(thisStart) ) { containsStart = true; }
                                if( eventMap.containsKey(nextStart) ) { containsNext = true; }
                            }
                            if(!containsStart) { startPosKeySet.remove(thisStart); }
                            if(!containsNext) { startPosKeySet.remove(nextStart); }

                            if( DEBUG ) { System.out.println("====> " + mergedVC); }
                            mapWasUpdated = true;
                            break; // break out of tree set iteration since it was just updated, start over from the beginning and keep merging events
                        }
                    }
                }
                thisStart = nextStart;
            }
        }
    }

    // BUGBUG: make this merge function more general
    protected static VariantContext createMergedVariantContext( final VariantContext thisVC, final VariantContext nextVC, final byte[] ref, final GenomeLoc refLoc ) {
        final int thisStart = thisVC.getStart();
        final int nextStart = nextVC.getStart();
        byte[] refBases = new byte[]{};
        byte[] altBases = new byte[]{};
        refBases = ArrayUtils.addAll(refBases, thisVC.getReference().getBases());
        altBases = ArrayUtils.addAll(altBases, thisVC.getAlternateAllele(0).getBases());
        int locus;
        for( locus = thisStart + refBases.length; locus < nextStart; locus++ ) {
            final byte refByte = ref[locus - refLoc.getStart()];
            refBases = ArrayUtils.add(refBases, refByte);
            altBases = ArrayUtils.add(altBases, refByte);
        }
        refBases = ArrayUtils.addAll(refBases, ArrayUtils.subarray(nextVC.getReference().getBases(), locus > nextStart ? 1 : 0, nextVC.getReference().getBases().length)); // special case of deletion including the padding base of consecutive indel
        altBases = ArrayUtils.addAll(altBases, nextVC.getAlternateAllele(0).getBases());

        int iii = 0;
        if( refBases.length == altBases.length ) { // insertion + deletion of same length creates an MNP --> trim common prefix bases off the beginning of the allele
            while( iii < refBases.length && refBases[iii] == altBases[iii] ) { iii++; }
        }
        final ArrayList<Allele> mergedAlleles = new ArrayList<Allele>();
        mergedAlleles.add( Allele.create( ArrayUtils.subarray(refBases, iii, refBases.length), true ) );
        mergedAlleles.add( Allele.create( ArrayUtils.subarray(altBases, iii, altBases.length), false ) );
        return new VariantContextBuilder("merged", thisVC.getChr(), thisVC.getStart() + iii, nextVC.getEnd(), mergedAlleles).make();
    }

    protected static double calculateR2LD( final double x11, final double x12, final double x21, final double x22 ) {
        final double total = x11 + x12 + x21 + x22;
        final double pa1b1 = x11 / total;
        final double pa1b2 = x12 / total;
        final double pa2b1 = x21 / total;
        final double pa1 = pa1b1 + pa1b2;
        final double pb1 = pa1b1 + pa2b1;
        return ((pa1b1 - pa1*pb1) * (pa1b1 - pa1*pb1)) / ( pa1 * (1.0 - pa1) * pb1 * (1.0 - pb1) );
    }

    @Requires({"haplotypes.size() >= eventsAtThisLoc.size() + 1"})
    @Ensures({"result.size() == eventsAtThisLoc.size() + 1"})
    protected static Map<Allele, List<Haplotype>> createAlleleMapper( final int loc, final List<VariantContext> eventsAtThisLoc, final List<Haplotype> haplotypes ) {

        final Allele refAllele = eventsAtThisLoc.get(0).getReference();

        final Map<Allele, List<Haplotype>> alleleMapper = new HashMap<Allele, List<Haplotype>>(eventsAtThisLoc.size()+1);
        for( final Haplotype h : haplotypes ) {
            if( h.getEventMap().get(loc) == null ) { // no event at this location so this is a reference-supporting haplotype
                if ( !alleleMapper.containsKey(refAllele) )
                    alleleMapper.put(refAllele, new ArrayList<Haplotype>());
                alleleMapper.get(refAllele).add(h);
            } else if ( h.isArtificialHaplotype() ) {
                if ( !alleleMapper.containsKey(h.getArtificialAllele()) )
                    alleleMapper.put(h.getArtificialAllele(), new ArrayList<Haplotype>());
                alleleMapper.get(h.getArtificialAllele()).add(h);
            } else {
                for( final VariantContext vcAtThisLoc : eventsAtThisLoc ) {
                    if( h.getEventMap().get(loc).hasSameAllelesAs(vcAtThisLoc) ) {
                        final Allele altAllele = vcAtThisLoc.getAlternateAllele(0);
                        if ( !alleleMapper.containsKey(altAllele) )
                            alleleMapper.put(altAllele, new ArrayList<Haplotype>());
                        alleleMapper.get(altAllele).add(h);
                        break;
                    }
                }
            }
        }

        for( final Haplotype h : haplotypes ) {
            if ( h.getEventMap().get(loc) == null || h.isArtificialHaplotype() )
                continue;

            Allele matchingAllele = null;
            for ( final Map.Entry<Allele, List<Haplotype>> alleleToTest : alleleMapper.entrySet() ) {
                if ( alleleToTest.getKey().equals(refAllele) )
                    continue;

                final Haplotype artificialHaplotype = alleleToTest.getValue().get(0);
                if ( isSubSetOf(artificialHaplotype.getEventMap(), h.getEventMap()) ) {
                    matchingAllele = alleleToTest.getKey();
                    break;
                }
            }

            if ( matchingAllele == null )
                matchingAllele = refAllele;
            alleleMapper.get(matchingAllele).add(h);
        }

        return alleleMapper;
    }

    protected static boolean isSubSetOf(final Map<Integer, VariantContext> subset, final Map<Integer, VariantContext> superset) {

        for ( final Map.Entry<Integer, VariantContext> fromSubset : subset.entrySet() ) {
            final VariantContext fromSuperset = superset.get(fromSubset.getKey());
            if ( fromSuperset == null )
                return false;

            if ( !fromSuperset.hasAlternateAllele(fromSubset.getValue().getAlternateAllele(0)) )
                return false;
        }

        return true;
    }

    @Ensures({"result.size() == haplotypeAllelesForSample.size()"})
    protected static List<Allele> findEventAllelesInSample( final List<Allele> eventAlleles, final List<Allele> haplotypeAlleles, final List<Allele> haplotypeAllelesForSample, final ArrayList<ArrayList<Haplotype>> alleleMapper, final ArrayList<Haplotype> haplotypes ) {
        if( haplotypeAllelesForSample.contains(Allele.NO_CALL) ) { return noCall; }
        final ArrayList<Allele> eventAllelesForSample = new ArrayList<Allele>();
        for( final Allele a : haplotypeAllelesForSample ) {
            final Haplotype haplotype = haplotypes.get(haplotypeAlleles.indexOf(a));
            for( int iii = 0; iii < alleleMapper.size(); iii++ ) {
                final ArrayList<Haplotype> mappedHaplotypes = alleleMapper.get(iii);
                if( mappedHaplotypes.contains(haplotype) ) {
                    eventAllelesForSample.add(eventAlleles.get(iii));
                    break;
                }
            }
        }
        return eventAllelesForSample;
    }

    protected static boolean containsVCWithMatchingAlleles( final List<VariantContext> list, final VariantContext vcToTest ) {
        for( final VariantContext vc : list ) {
            if( vc.hasSameAllelesAs(vcToTest) ) {
                return true;
            }
        }
        return false;
    }

    protected static HashMap<Integer,VariantContext> generateVCsFromAlignment( final Haplotype haplotype, final int alignmentStartHapwrtRef, final Cigar cigar, final byte[] ref, final byte[] alignment, final GenomeLoc refLoc, final String sourceNameToAdd ) {
        final HashMap<Integer,VariantContext> vcs = new HashMap<Integer,VariantContext>();

        int refPos = alignmentStartHapwrtRef;
        if( refPos < 0 ) { return null; } // Protection against SW failures
        int alignmentPos = 0;

        for( final CigarElement ce : cigar.getCigarElements() ) {
            final int elementLength = ce.getLength();
            switch( ce.getOperator() ) {
                case I:
                {
                    final ArrayList<Allele> insertionAlleles = new ArrayList<Allele>();
                    final int insertionStart = refLoc.getStart() + refPos - 1;
                    final byte refByte = ref[refPos-1];
                    if( BaseUtils.isRegularBase(refByte) ) {
                        insertionAlleles.add( Allele.create(refByte, true) );
                    }
                    if( (haplotype.leftBreakPoint != 0 || haplotype.rightBreakPoint != 0) && (haplotype.leftBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() - 1 == insertionStart + elementLength + 1 || haplotype.rightBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() - 1 == insertionStart + elementLength + 1) ) {
                        insertionAlleles.add( SYMBOLIC_UNASSEMBLED_EVENT_ALLELE );
                    } else {
                        byte[] insertionBases = new byte[]{};
                        insertionBases = ArrayUtils.add(insertionBases, ref[refPos-1]); // add the padding base
                        insertionBases = ArrayUtils.addAll(insertionBases, Arrays.copyOfRange( alignment, alignmentPos, alignmentPos + elementLength ));
                        if( BaseUtils.isAllRegularBases(insertionBases) ) {
                            insertionAlleles.add( Allele.create(insertionBases, false) );
                        }
                    }
                    if( insertionAlleles.size() == 2 ) { // found a proper ref and alt allele
                        vcs.put(insertionStart, new VariantContextBuilder(sourceNameToAdd, refLoc.getContig(), insertionStart, insertionStart, insertionAlleles).make());
                    }
                    alignmentPos += elementLength;
                    break;
                }
                case S:
                {
                    alignmentPos += elementLength;
                    break;
                }
                case D:
                {
                    final byte[] deletionBases = Arrays.copyOfRange( ref, refPos - 1, refPos + elementLength );  // add padding base
                    final ArrayList<Allele> deletionAlleles = new ArrayList<Allele>();
                    final int deletionStart = refLoc.getStart() + refPos - 1;
                    // BUGBUG: how often does this symbolic deletion allele case happen?
                    //if( haplotype != null && ( (haplotype.leftBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() + elementLength - 1 >= deletionStart && haplotype.leftBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() + elementLength - 1 < deletionStart + elementLength)
                    //        || (haplotype.rightBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() + elementLength - 1 >= deletionStart && haplotype.rightBreakPoint + alignmentStartHapwrtRef + refLoc.getStart() + elementLength - 1 < deletionStart + elementLength) ) ) {
                    //    deletionAlleles.add( Allele.create(ref[refPos-1], true) );
                    //    deletionAlleles.add( SYMBOLIC_UNASSEMBLED_EVENT_ALLELE );
                    //    vcs.put(deletionStart, new VariantContextBuilder(sourceNameToAdd, refLoc.getContig(), deletionStart, deletionStart, deletionAlleles).make());
                    //} else {
                    final byte refByte = ref[refPos-1];
                    if( BaseUtils.isRegularBase(refByte) && BaseUtils.isAllRegularBases(deletionBases) ) {
                        deletionAlleles.add( Allele.create(deletionBases, true) );
                        deletionAlleles.add( Allele.create(refByte, false) );
                        vcs.put(deletionStart, new VariantContextBuilder(sourceNameToAdd, refLoc.getContig(), deletionStart, deletionStart + elementLength, deletionAlleles).make());
                    }
                    //}
                    refPos += elementLength;
                    break;
                }
                case M:
                case EQ:
                case X:
                {
                    for( int iii = 0; iii < elementLength; iii++ ) {
                        final byte refByte = ref[refPos];
                        final byte altByte = alignment[alignmentPos];
                        if( refByte != altByte ) { // SNP!
                            if( BaseUtils.isRegularBase(refByte) && BaseUtils.isRegularBase(altByte) ) {
                                final ArrayList<Allele> snpAlleles = new ArrayList<Allele>();
                                snpAlleles.add( Allele.create( refByte, true ) );
                                snpAlleles.add( Allele.create( altByte, false ) );
                                vcs.put(refLoc.getStart() + refPos, new VariantContextBuilder(sourceNameToAdd, refLoc.getContig(), refLoc.getStart() + refPos, refLoc.getStart() + refPos, snpAlleles).make());
                            }
                        }
                        refPos++;
                        alignmentPos++;
                    }
                    break;
                }
                case N:
                case H:
                case P:
                default:
                    throw new ReviewedStingException( "Unsupported cigar operator created during SW alignment: " + ce.getOperator() );
            }
        }
        return vcs;
    }
}