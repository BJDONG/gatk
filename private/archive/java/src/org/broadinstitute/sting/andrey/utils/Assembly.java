/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 (“BROAD”) and the LICENSEE and is effective at the date the downloading is completed (“EFFECTIVE DATE”).
* 
* WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
* WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
* NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
* 
* 1. DEFINITIONS
* 1.1 PROGRAM shall mean copyright in the object code and source code known as GATK3 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute.org/gatk on the EFFECTIVE DATE.
* 
* 2. LICENSE
* 2.1 Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. LICENSEE hereby automatically grants to BROAD a non-exclusive, royalty-free, irrevocable license to any LICENSEE bug fixes or modifications to the PROGRAM with unlimited rights to sublicense and/or distribute.  LICENSEE agrees to provide any such modifications and bug fixes to BROAD promptly upon their creation.
* The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only. For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
* 2.2 No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD. LICENSEE shall ensure that all of its users agree to the terms of this Agreement. LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
* 2.3 License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.
* 
* 3. PHONE-HOME FEATURE
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system (“PHONE-HOME”) which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2014 Broad Institute, Inc.
* Notice of attribution: The GATK3 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
* LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
* 
* 5. INDEMNIFICATION
* LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
* 
* 6. NO REPRESENTATIONS OR WARRANTIES
* THE PROGRAM IS DELIVERED AS IS. BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
* IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
* 
* 7. ASSIGNMENT
* This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
* 
* 8. MISCELLANEOUS
* 8.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
* 8.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
* 8.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
* 8.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested. All notices under this Agreement shall be deemed effective upon receipt.
* 8.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter.
* 8.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
* 8.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.sting.gatk.walkers.andrey.utils;

import org.broadinstitute.sting.utils.Utils;
import org.broadinstitute.sting.utils.collections.PrimitivePair;
import org.broadinstitute.sting.utils.exceptions.StingException;
import org.broadinstitute.variant.utils.BaseUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asivache
 * Date: Aug 3, 2010
 * Time: 2:20:22 PM
 * To change this template use File | Settings | File Templates.
 */
class Assembly {
        private byte[] consensus;
        private short[] coverage;
        private short[] mismatches;
        private short [][] base_counts;

        private boolean debug = false;
        private List<String> seq_ids;
        private List<byte []> seqs;
        private List<Integer> seq_offsets;

        private KmerIndex lookup; // assembled consensus sequence is indexed here

        private int hookedAt = -1; // if set, specifies start on the ref of the assembled consensus sequence

        private static List<PrimitivePair.Int> EMPTY_KMER_LIST = new ArrayList<PrimitivePair.Int>(0);

        private int K = 15;

        private AlignmentStrategy strategy = null;
    
    /** Creates new assembly seeded with the specified sequence; default key length (15) is used.
     *
     * @param seq
     * @param id
     */
        public Assembly(final byte[] seq, String id) {
            this(15,seq,id);
        }

    /** Creates new assembly seeded with the specified sequence and sets kmer (key) length K for the internally maintained
     * lookup index tables.
     * @param K
     * @param seq
     * @param id
     */
        public Assembly(int K, final byte[] seq, String id) {
            this.K = K;
            seq_ids = new ArrayList<String>();
            seq_offsets = new ArrayList<Integer>();
            seqs = new ArrayList<byte[]>();
            seq_ids.add(id);
            seq_offsets.add(0);
            seqs.add(seq);
            consensus = Arrays.copyOf(seq,seq.length);
            coverage = new short[seq.length];
            Arrays.fill(coverage,(short)1);
            mismatches = new short[seq.length]; // filled with 0's
            base_counts = new short[4][seq.length];
            for ( int i = 0 ; i < seq.length ; i++ ) {
                int j = BaseUtils.simpleBaseToBaseIndex(seq[i]);
                if ( j != -1) base_counts[j][i] = 1;
            }
            lookup = new KmerIndex(K,seq);
            strategy = new DefaultAlignmentStrategy();
        }

    /** Creates new assembly seeded with the specified sequence; default key length (15) is used and the position on the
     * reference of the entire assembly is set (as assemblly grows, position on the ref will be updated properly).
     *
     * @param seq
     * @param id
     */
        public Assembly(final byte[] seq, String id, int posOnRef) {
            this(seq,id);
            hookedAt = posOnRef;
        }

    /** Creates new assembly seeded the specified sequence and sets kmer (key) length K for the internally maintained
     * lookup index tables. Parameter <code>posOnRef</code> specifies the (initial) position of the entire assembly on the
     * ref; as the assembly grows, the position on ref will be updated properly.
     * @param K
     * @param seq
     * @param id
     */
        public Assembly(int K, final byte[] seq, String id, int posOnRef) {
            this(K,seq,id);
            hookedAt = posOnRef;
        }

    /** Returns total number of sequences currently held by this assembly.
     * 
     * @return
     */
        public int getNumSeqs() { return seqs.size() ; }

        /** Attempts to align <code>seq</code> to this assembly's consensus. Does NOT add
         * the sequence to the consensus even if it aligns! This methods returns a list of alternative
         * best alignments found (according to the strategy used) in a newly allocated AlignmentList object.
         * @param seq sequence to align to this consensus
         * @param tryRC if true, will try aligning both seq and its reverse complement; otherwise
         * only forward alignment will be attempted (i.e. best placement of the seq, as it is provided,
         * along the assembled consensus sequence)
         * @return a newly allocated alignment list; returned list can be empty if no alignments are found
         */
        public AlignmentList align(final byte[] seq, boolean tryRC) {
            return align(seq,tryRC,null);
        }

        /** Attempts to align <code>seq</code> to this assembly's consensus. Does NOT add
         * the sequence to the consensus even if it aligns! This method uses existing list of alignments
         * (which can contain alignments to a different assembly) and updates it as necessary if a better alignment
         * (or multiple better alignments) than the one(s) already held in the list is found. Reference to the
         * <i>same</i> alignment list object is returned: this method modifies it's argument. If alignment list argument
         * is <code>null</code>, new alignment list object will be allocated and returned by this method.
         *
         * @param seq sequence to align to this consensus
         * @param tryRC if true, will try aligning both seq and its reverse complement; otherwise
         * only forward alignment will be attempted (i.e. best placement of the seq, as it is provided,
         * along the assembled consensus sequence)
         * @return a newly allocated alignment list; returned list can be empty if no alignments are found
       */
        public AlignmentList align(final byte[] seq, boolean tryRC, AlignmentList a) {
            if ( debug ) System.out.println("Assembly:: aligning sequence of length "+seq.length+"; tryRC="+tryRC+"; K="+K);

            List<PrimitivePair.Int> fw_kmers = KmerIndex.toKeyOffsetList(K,seq);

            if ( debug ) {
                for( PrimitivePair.Int kmer: fw_kmers) {
                    System.out.println("id="+kmer.getFirst()+" seq="+new String(KmerIndex.idToSeq(K,kmer.getFirst()))+" offset on seq="+kmer.getSecond());
                }
            }

            byte [] rc_seq = (tryRC ? BaseUtils.simpleReverseComplement(seq) : null );
            List<PrimitivePair.Int> rc_kmers = (tryRC ? KmerIndex.toKeyOffsetList(K,rc_seq) : EMPTY_KMER_LIST );

            if ( a == null ) a = new AlignmentList(strategy);

            // i is the position on the sequence seq or on its reverse complement
            for(PrimitivePair.Int kmer : fw_kmers ) {

                List<Integer> offsets = lookup.getOffsets(kmer.first);
                if ( offsets != null ) {
                    // kmer present in consensus sequence
                    for ( int s : offsets ) {      // s=offset of the current kmer on the assembled consensus
                        int trial_offset = s - kmer.second; // offset of the seq on the assembled consensus suggested by current kmer/offset
                        int trial_mm = countMismatches(seq,trial_offset,a.getNextBestMMCount());
                        a.tryAdd(new AlignmentInfo(trial_mm,trial_offset,false,overlap(trial_offset,seq.length),this));
                    }
                }
            }

            for ( PrimitivePair.Int kmer : rc_kmers ) {

                List<Integer> offsets = lookup.getOffsets(kmer.first);
                if ( offsets != null ) {
                    // kmer present in consensus sequence
                    for ( int s : offsets ) {
                        int trial_offset = s - kmer.second;
                        int trial_mm = countMismatches(rc_seq,trial_offset,a.getNextBestMMCount());
                        a.tryAdd(new AlignmentInfo(trial_mm,trial_offset,true,overlap(trial_offset,seq.length),this));
                    }
                }
            }
            return a;
        }

        public void setDebug(boolean d) { this.debug = d; lookup.setDebug(d);}

        public int numSequences() { return seq_ids.size(); }

        private int overlap(int offset, int seq_length ) {
            return Math.min(consensus.length,offset+seq_length)-Math.max(0,offset);
        }

        private int countMismatches(final byte seq[], int offset, int cutoff) {
            int mm = 0;

            int i ;
            if ( offset >= 0 ) i = 0;
            else { i = (-offset); offset = 0; }
            for ( ; i < seq.length && offset < consensus.length ; i++ , offset++ ) {
                if ( seq[i] != consensus[offset] ) {
                    mm++;
                    if ( mm > cutoff ) break;
                }
            }

            return mm;
        }

        public byte[] getConsensus() { return consensus; }

        public int getPosOnRef() { return hookedAt; }

        public int getConsensusLength() { return consensus.length; }

        public List<Integer> getOffsets() { return seq_offsets; }
        public int getOffset(int i) { return seq_offsets.get(i); }

        public List<String> getSeqIds() { return Collections.unmodifiableList(seq_ids); }

    /** Adds specified sequence to this assembly according to the provided
     * alignment information. Will properly update consensus sequence of this assembly
     * and all associated information (mismatches, base counts etc)
     * @param seq
     * @param id
     * @param a
     */
        public void add(final byte[] seq, String id, AlignmentInfo a) {

            if ( ! a.isAligned() ) throw new StingException("Can not add sequence to the assembly: provided alignment is empty");

            seq_ids.add(id);

            int offset = a.getOffset();
            int oldConsensusLength = consensus.length;

            byte [] seq_to_add = ( a.isNegativeStrand() ? BaseUtils.simpleReverseComplement(seq) : seq);

            seqs.add(seq_to_add);

            int pos_on_seq = 0;
            int pos_on_cons = 0;

            int leftExtension = 0; // how many bases we added to the consensus on the left
            int rightExtension = 0; // how many bases we added to the consensus on the right

            if ( offset < 0 ) {
                // if sequence sticks out to the left of the current consensus:

                leftExtension = -offset;
                for(int i = 0 ; i < seq_offsets.size() ; i++ ) {
                    // we are going to extend consensus to the left, so we need to update all current offsets:
                    seq_offsets.set(i,seq_offsets.get(i)+leftExtension);
                }

                if ( hookedAt > 0 ) hookedAt -= leftExtension;
                // extend consensus and associated arrays to the left :

                consensus = Utils.extend(consensus, offset, (byte) 0); // remember, offset is negative here, extending to the left
                coverage = Utils.extend(coverage,offset,(short)1) ;
                mismatches = Utils.extend(mismatches,offset,(short)0);
                for ( int i = 0 ; i < 4 ; i++ ) base_counts[i] = Utils.extend(base_counts[i],offset,(short)0);

                for ( int j = 0 ; j < -offset ; j++ ) {
                    consensus[j] = seq_to_add[j];
                    int b = BaseUtils.simpleBaseToBaseIndex(seq_to_add[j]);
                    if ( b != -1 ) base_counts[b][j]=1;
                }

                pos_on_seq = pos_on_cons = -offset;

                offset = 0;
            }
            if ( offset > 0 ) pos_on_cons = offset;

            seq_offsets.add(offset);

            boolean consensus_changed = false;

            for ( ; pos_on_seq < seq_to_add.length && pos_on_cons < consensus.length ; pos_on_seq++, pos_on_cons++ ) {
                coverage[pos_on_cons]++;
                final byte base = seq_to_add[pos_on_seq];
                final int b = BaseUtils.simpleBaseToBaseIndex(base);
                if ( b != -1 ) {
                    // if base on seq is not a regular base, there is nothing to do;
                    // otherwise count mismatches and optionally update consensus if current base tips the balance
                    base_counts[b][pos_on_cons]++;
                    int maxcount = 0;
                    int maxb = -1;
                    for ( int j = 0 ; j < 4 ; j++ ) {
                        if ( base_counts[j][pos_on_cons] > maxcount ) {
                            maxcount = base_counts[j][pos_on_cons];
                            maxb = j;
                        }
                    }
                    // we are guaranteed here that maxb != -1 since we just added one regular base (the current one)
                    // few lines above...
                    byte newbase = BaseUtils.baseIndexToSimpleBase(maxb);
                    if ( newbase != consensus[pos_on_cons] ) { // need to change the consensus base (will recompute mismatches)
                        consensus[pos_on_cons] = newbase;
                        consensus_changed = true;
                        mismatches[pos_on_cons] = 0;
                        for ( int i = 0 ; i < 4 ; i++ ) {
                             if ( i == maxb ) continue;
                             mismatches[pos_on_cons] += base_counts[i][pos_on_cons];
                        }
                    } else { // consensus base did not change; just increment mismatches if current sequence's base differs from consensus
                        if ( base != consensus[pos_on_cons]) mismatches[pos_on_cons]++;
                    }
                }

            }

            // Last step: if sequence sticks out of current consensus on the right, we need to extend the latter:

            if ( pos_on_seq < seq_to_add.length ) {
                // sequence sticks out of consensus to the right
                rightExtension = seq_to_add.length - pos_on_seq;
                consensus = Utils.extend(consensus,rightExtension,(byte)0);
                coverage = Utils.extend(coverage,rightExtension,(short)1);
                mismatches = Utils.extend(mismatches,rightExtension,(short)0);
                for ( int i = 0 ; i < 4 ; i++ ) base_counts[i] = Utils.extend(base_counts[i],rightExtension,(short)0);
                for ( ; pos_on_seq < seq_to_add.length ; pos_on_seq++, pos_on_cons++ ) {
                    byte base = seq_to_add[pos_on_seq];
                    consensus[pos_on_cons] = base;
                    int b = BaseUtils.simpleBaseToBaseIndex(base);
                    if ( b != -1 ) base_counts[b][pos_on_cons] = base;
                }
            }

            // finally, the new sequence we just added could have mismatches that tip some consensus bases into new values;
            // let's catch those cases:


            for ( int i = 0 ; i < consensus.length ; i++ ) {
                byte cons_base = consensus[i];
                int b = BaseUtils.simpleBaseToBaseIndex(cons_base);
            }

            // there is probably a better way, but for now we just recompute the whole lookup table when consensus
            // changes somewhere in the middle (if we want to be samrt we need to identify just the kmers that changed
            // and find/change them in the lookup table).
            if ( consensus_changed ) {
                lookup.clear();
                lookup.index(consensus);
            } else {
                if ( leftExtension > 0 || rightExtension > 0 ) lookup.updateIndex(consensus,leftExtension,oldConsensusLength);
            }


        }

        public String toAlignmentString(boolean mismatchesOnly, boolean printNames) {

            int maxNameLength = 0;
            int spacing=3;

            if ( printNames ) {
                for ( String n : seq_ids ) if ( n.length() > maxNameLength ) maxNameLength++;
            }

            StringBuilder b = new StringBuilder();
            if ( printNames ) b.append(Utils.dupString(' ',maxNameLength+spacing));
            b.append(new String(consensus));
            b.append('\n');

            for ( int j = 0; j < seqs.size() ; j++ ) {
                int offset = seq_offsets.get(j);
                byte [] seq = seqs.get(j);

                if ( printNames ) {
                    b.append(seq_ids.get(j));
                    b.append(Utils.dupString(' ',maxNameLength-seq_ids.get(j).length()+spacing));
                }

                for ( int i = 0 ; i < offset ; i++ ) b.append(' ');

                for ( int i = 0 ; i < seq.length ; i++ ) {

                    byte base = seq[i];
                    if ( mismatchesOnly && base == consensus[i+offset] ) {
                        b.append('.');
                    } else b.append((char)base);
                }
                b.append('\n');
            }
            return b.toString();
        }


        public static void testMe(String [] argv ) {
            byte [] seq1 =      "ACGTTGCGTGGTTCACTGCAGTAACTGACTGATGCA".getBytes();
            byte [] seq2 =           "GCGTGGTTTACTGCAGTAACTGACTGATGCAACGTGTTTG".getBytes();
            byte [] seq3 = "GGNTGACGTTGCGTGGTTTACTGCAGTAACTGACT".getBytes();
            byte [] seq4 =      "NNNTTNCGTGGTTTACTGCAGTAACTGACTGATGCA".getBytes();

            Assembly a = new Assembly(seq1,"1");

            AlignmentList al = a.align(seq2,false);
            if ( al.isAligned() ) System.out.println("seq 2 aligned");
            else System.out.println("seq 2 did NOT align");

            if ( al.size() == 1 ) a.add(seq2,"2",al.getAlignments().get(0));
            else System.out.println("Multiple alignments found for seq 2");

            al = a.align(seq3,false);
            if ( al.isAligned() ) System.out.println("seq 3 aligned");
            else System.out.println("seq 3 did NOT align");

            if ( al.size() == 1 ) a.add(seq3,"3",al.getAlignments().get(0));
            else System.out.println("Multiple alignments found for seq 3");

            al = a.align(seq4,false);
            if ( al.isAligned() ) System.out.println("seq 4 aligned");
            else System.out.println("seq 4 did NOT align");

            if ( al.size() == 1 ) a.add(seq4,"4",al.getAlignments().get(0));
            else System.out.println("Multiple alignments found for seq 4");

            System.out.println(a.toAlignmentString(true, true));

        }

}
