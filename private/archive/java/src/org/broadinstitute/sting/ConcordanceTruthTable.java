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

package org.broadinstitute.sting.walkers;


import org.broadinstitute.sting.utils.genotype.Genotype;
import org.broadinstitute.sting.utils.genotype.Variation;
import org.broadinstitute.sting.utils.Pair;
import org.broadinstitute.sting.utils.Utils;

import java.util.*;

/**
 * The Broad Institute
 * SOFTWARE COPYRIGHT NOTICE AGREEMENT
 * This software and its documentation are copyright 2009 by the
 * Broad Institute/Massachusetts Institute of Technology. All rights are reserved.
 * <p/>
 * This software is supplied without any warranty or guaranteed support whatsoever. Neither
 * the Broad Institute nor MIT can be responsible for its use, misuse, or functionality.
 */
public class ConcordanceTruthTable {
    public static final int TRUE_POSITIVE = 0;
    public static final int TRUE_NEGATIVE = 1;
    public static final int FALSE_POSITIVE = 2;
    public static final int FALSE_NEGATIVE = 3;
    public static final int VARIANT = 1;
    private static final String[] POOL_HEADERS = {"TP","TN","FP","FN"};

    public static final int REF = 0;
    public static final int VAR_HET = 1;
    public static final int VAR_HOM = 2;
    public static final int UNKNOWN = 3;
    public static final int NO_CALL = 3;   // synonym
    private static final String[] TRUTH_NAMES = {"IS_REF", "IS_VAR_HET", "IS_VAR_HOM", "UNKNOWN"};
    private static final String[] CALL_NAMES = {"CALLED_REF", "CALLED_VAR_HET", "CALLED_VAR_HOM", "NO_CALL"};

    private String name = null;
    private boolean singleSampleMode;

    private int[][] table;
    private int[] truth_totals;
    private int[] calls_totals;


    public ConcordanceTruthTable(String name) {
        // there's a specific sample associated with this truth table
        this.name = name;
        singleSampleMode = true;

        table = new int[4][4];
        truth_totals = new int[4];
        calls_totals = new int[4];
        for (int i = 0; i < 4; i++) {
            truth_totals[i] = 0;
            calls_totals[i] = 0;
            for (int j = 0; j < 4; j++)
                table[i][j] = 0;
        }
    }

    public ConcordanceTruthTable(int nSamples) {
        // there's no specific sample associated with this truth table
        singleSampleMode = false;
        name = "pooled_concordance";
        truth_totals = new int[4];
        calls_totals = new int[4];
        for (int i = 0; i < 4; i++) {
            truth_totals[i] = 0;
            calls_totals[i] = 0;
        }

        initializeFrequencyTable(nSamples);
    }

    private void initializeFrequencyTable( int numChips ) {
        // System.out.println("Frequency Table for Pooled Concordance initialized with number of chips = "+numChips);
        table = new int[numChips*2][4];
        for (int i = 0; i < 4; i++) {
            for ( int freq = 0; freq < 2*numChips; freq ++ ) {
                table[freq][i] = 0;
            }
        }

        // System.out.println("Table Size: "+table.length+" by "+table[1].length);
    }

    public String addEntry(List<Pair<Genotype, Genotype>> chipEvals, Variation eval, char ref) {
        String violation = null;

        // if the table represents a single sample, then we can calculate genotype stats
        if ( singleSampleMode ) {
            for ( Pair<Genotype, Genotype> chipEval : chipEvals ) {

                Genotype chipG = chipEval.first;
                Genotype evalG = chipEval.second;

                if (chipG == null && evalG == null)
                    continue;

                int truthType = getGenotype(chipG, ref);
                int callType = getGenotype(evalG, ref);

                //System.out.printf("TEST: %d/%d %s vs. %s%n", truthIndex, callIndex, chip, eval);
                if ( truthType == VARIANT && callType != VARIANT ) {
                    violation = String.format("False negative: ref=%c chip=%s call=%s", ref, chipG, evalG);
                } else if ( truthType == REF && callType == VARIANT ) {
                    violation = String.format("False positive: chip=%s call=%s", chipG, evalG);
                }

                addGenotypeEntry(truthType, callType);
            }
        } else { // if we cannot associate tables with individuals, then we are working in a pooled context
            // first we need to expand our tables to include frequency information
            Pair<Integer, Pair<Integer,Integer> > poolVariant = getPooledAlleleFrequency(chipEvals, ref);

            int truthType = poolVariant.getFirst(); // convenience method; now to interpret
            int callType = getCallIndex(eval,ref);

            int numTrueSupportingAlleles = poolVariant.getSecond().getFirst();
            if ( numTrueSupportingAlleles > 0 && truthType == VARIANT && callType != VARIANT ) {
                violation = String.format("False negative: %s with %d alt alleles", chipEvals.get(0).getFirst(), numTrueSupportingAlleles);
            } else if ( truthType == REF && callType == VARIANT ) {
                violation = String.format("False positive: %s at hom-ref site", eval);
            }

            addFrequencyEntry( truthType, callType, poolVariant.getSecond().getFirst() );

        }

        // TODO -- implement me for pooled mode with frequency stats
        // TODO -- You'll want to use eval and the chips from chipEvals (these are the first members of the pair)
        // TODO -- You'll also need to declare (and initialize) the relevant data arrays for the data
        // TODO -- Indexes like TRUE_POSITIVE are defined above for you
        return violation;
    }

    public Pair<Integer, Pair<Integer,Integer>> getPooledAlleleFrequency( List<Pair<Genotype,Genotype>> chips, char ref) {
        // this is actually just a note that I wanted to appear in blue. This method explicitly uses
        // the assumption that tri-allelic sites do not really exist, and that if they do the
        // site will be marked as such by an 'N' in the reference, so we will not get to this point.

        int frequency = 0;
        int nChips = 0;
        if ( chips != null ) {
            for ( Pair<Genotype,Genotype> chip : chips ) {
                Genotype c = chip.getFirst();
                if ( c != null ) {                    
                    nChips++;
                    if ( c.isVariant(ref) ) {
                        if ( c.isHet() ) {
                            frequency++;
                        } else { // c is hom
                            frequency += 2;
                        }
                    }
                    //System.out.printf("  Genotype %s at %c => %d%n", c, ref, frequency);
                }
            }
            //System.out.printf("*** %d%n", frequency);
        }

        int truthType = nChips > 0 ? ( frequency > 0 ? VARIANT : REF ) : NO_CALL;
        return new Pair<Integer, Pair<Integer,Integer> >(truthType, new Pair<Integer,Integer>(frequency,nChips));
    }

    private void addFrequencyEntry( int truthIndex, int callIndex, int numTrueSupportingAlleles ) {
        //System.out.printf(" %s %s %d%n", CALL_NAMES[truthIndex], CALL_NAMES[callIndex], numTrueSupportingAlleles);
        calls_totals[callIndex]++;
        truth_totals[truthIndex]++;

        if ( truthIndex == REF && ( callIndex == REF || callIndex == NO_CALL ) ) {
            // true negative
            table[numTrueSupportingAlleles][TRUE_NEGATIVE]++;
            // sanity check - there should never be an entry in
            // [*][TRUE_NEGATIVE] for * > 0
        } else if ( truthIndex == REF && callIndex == VARIANT ) {
            // false positive
            table[numTrueSupportingAlleles][FALSE_POSITIVE]++;
        } else if ( truthIndex == VARIANT && (callIndex == NO_CALL || callIndex == REF) ) {
            // false negative
            table[numTrueSupportingAlleles][FALSE_NEGATIVE]++;
        } else if ( truthIndex == VARIANT && callIndex == VARIANT ) {
            // true positive
            table[numTrueSupportingAlleles][TRUE_POSITIVE]++;
        } else {
            // something else is going on; wonky site or something. Don't do anything to the table.
        }
    }

    private static int getCallIndex(Variation eval, char ref) {
        int index;

        if ( eval == null ) {
            index = NO_CALL;
        } else if ( ! eval.isSNP() ) {
            index = REF;
        } else {
            index = VARIANT;
        }

        return index;
    }

    private static int getGenotype(Genotype g, char ref) {
        int type;

        if ( g == null )
            type = NO_CALL;
        else if ( !g.isVariant(ref) )
            type = REF;
        else if ( g.isHet() )
            type = VAR_HET;
        else
            type = VAR_HOM;

        return type;
    }

    private void addGenotypeEntry(int truthIndex, int callIndex) {
        table[truthIndex][callIndex]++;
        truth_totals[truthIndex]++;
        calls_totals[callIndex]++;
    }

    public void addAllStats(List<String> s) {
        if ( singleSampleMode )
            addGenotypeStats(s);
        else
            addFrequencyStats(s);
    }

//    private void addFrequencyStats(List<String> s) {
//
//        // TODO -- implement me for pooled mode with frequency stats
//        s.add(String.format("name                 %s",name));
//        s.add(String.format("TRUTH_ALLELE_FREQUENCY\tERROR_OR_TRUTH_TYPE\tTOTAL\tAS_PRCT_OF_TOTAL_CALLS\tAS_PRCT_OF_CALLS_AT_FREQUENCY"));
//
//        for ( int af = 0; af < table.length; af ++ ) {
//            for ( int errorIndex = 0; errorIndex < 4; errorIndex ++ ) {
//                StringBuffer sb = new StringBuffer();
//                sb.append(String.format("%f ", ((double) af)/ table.length));
//                sb.append(String.format("%s ",POOL_HEADERS[errorIndex]));
//                sb.append(String.format("%d ", table[af][errorIndex]));
//                sb.append(String.format("%s ", percentOfTotal(table,af,errorIndex)));
//                sb.append(String.format("%s ", marginalPercent(table[af],errorIndex)));
//                s.add(sb.toString());
//            }
//        }
//
//    }

    private void addFrequencyStats(List<String> s) {
        s.add(String.format("name                 %s",name));
        s.add("TRUTH_ALLELE_COUNT\tTRUTH_ALLELE_FREQ\tTOTAL\t" + Utils.join(" ", POOL_HEADERS));

        for ( int af = 0; af < table.length; af ++ ) {
            int sum = 0;
            String counts = "";
            for ( int errorIndex = 0; errorIndex < 4; errorIndex ++ ) {
                int count = table[af][errorIndex];
                sum += count;
                counts += String.format(" %6d", count);
            }
            s.add(String.format("%6d %.3f %6d%s", af, ((double)af)/ table.length, sum, counts));
        }

    }

    private void addGenotypeStats(List<String> s) {
        s.add(String.format("name                 %s", name));
        s.add(String.format("TRUTH_STATE\tCALLED_REF\tCALLED_VAR_HET\tCALLED_VAR_HOM\tNO_CALL\t\tTOTALS\tTRUE_GENOTYPE_CONCORDANCE\tGENOTYPE_SENSITIVITY"));
        for (int i = 0; i < 4; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.format("%15s ", TRUTH_NAMES[i]));
            for (int j = 0; j < 4; j++)
                sb.append(String.format("%9d ", table[i][j]));
            sb.append(String.format("%9d ", truth_totals[i]));
            if (i == VAR_HET || i == VAR_HOM) {
                sb.append(String.format("\t%s\t\t", cellPercent(table[i][i], table[i][REF] + table[i][VAR_HET] + table[i][VAR_HOM])));
                sb.append(String.format("%s", cellPercent(truth_totals[i] - table[i][NO_CALL], truth_totals[i])));
            } else {
                sb.append("\tN/A\t\t\tN/A");
            }
            s.add(sb.toString());
        }

        addCalledGenotypeConcordance(s);
        addOverallStats(s);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                s.add(String.format("%s_%s_%s %d", TRUTH_NAMES[i], CALL_NAMES[j], "NO_SITES", table[i][j]));
                s.add(String.format("%s_%s_%s %s", TRUTH_NAMES[i], CALL_NAMES[j], "PERCENT_OF_TRUTH", cellPercent(table[i][j], truth_totals[i])));
                s.add(String.format("%s_%s_%s %s", TRUTH_NAMES[i], CALL_NAMES[j], "PERCENT_OF_CALLS", cellPercent(table[i][j], calls_totals[j])));
            }
            if (i == VAR_HET || i == VAR_HOM) {
                s.add(String.format("%s_%s %s", TRUTH_NAMES[i], "TRUE_GENOTYPE_CONCORDANCE", cellPercent(table[i][i], table[i][REF] + table[i][VAR_HET] + table[i][VAR_HOM])));
                s.add(String.format("%s_%s %s", TRUTH_NAMES[i], "GENOTYPE_SENSITIVITY", cellPercent(truth_totals[i] - table[i][NO_CALL], truth_totals[i])));
            }
        }
    }

    private void addCalledGenotypeConcordance(List<String> s) {
        StringBuilder sb = new StringBuilder();
        sb.append("CALLED_GENOTYPE_CONCORDANCE\t");
        for (int i = 0; i < 4; i++) {
            int nConcordantCallsI = table[i][i];
            String value = "N/A";
            if (i != UNKNOWN)
                value = String.format("%s\t", cellPercent(nConcordantCallsI, calls_totals[i] - table[UNKNOWN][i]));
            sb.append(value);
        }
        s.add(sb.toString());
    }

    // How many overall calls where made that aren't NO_CALLS or UNKNOWNS?
    private int getNCalled() {
        int n = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (i != NO_CALL && j != NO_CALL) n += table[i][j];
        return n;
    }

    private void addOverallStats(List<String> s) {
        int nConcordantRefCalls = table[REF][REF];
        int nConcordantHetCalls = table[VAR_HET][VAR_HET];
        int nConcordantVarHomCalls = table[VAR_HOM][VAR_HOM];
        int nVarCalls = table[VAR_HOM][VAR_HET] + table[VAR_HOM][VAR_HOM] + table[VAR_HET][VAR_HET] + table[VAR_HET][VAR_HOM];
        int nConcordantVarCalls = nConcordantHetCalls + nConcordantVarHomCalls;
        int nConcordantCalls = nConcordantRefCalls + nConcordantVarCalls;
        int nTrueVar = truth_totals[VAR_HET] + truth_totals[VAR_HOM];
        int nCalled = getNCalled();
        s.add(String.format("VARIANT_SENSITIVITY %s", cellPercent(nVarCalls, nTrueVar)));
        s.add(String.format("VARIANT_CONCORDANCE %s", cellPercent(nConcordantVarCalls, nVarCalls)));
        s.add(String.format("OVERALL_CONCORDANCE %s", cellPercent(nConcordantCalls, nCalled)));
    }

    private static String cellPercent(int count, int total) {
        StringBuffer sb = new StringBuffer();
        total = Math.max(total, 0);
        sb.append(String.format("%.2f", (100.0 * count) / total));
        sb.append("%");
        return sb.toString();
    }
}
