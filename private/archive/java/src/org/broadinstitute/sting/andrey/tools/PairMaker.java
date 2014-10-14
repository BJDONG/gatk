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

package org.broadinstitute.sting.gatk.walkers.andrey.tools;

import net.sf.picard.cmdline.CommandLineProgram;
import net.sf.picard.cmdline.Option;
import net.sf.picard.cmdline.Usage;
import net.sf.samtools.*;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.sam.AlignmentUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: asivache
 * Date: Aug 27, 2009
 * Time: 3:53:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PairMaker extends CommandLineProgram {
    @Usage(programVersion="1.0") public String USAGE = "Reconstitutes mate pairs from alignments"+
                " for individual fragment ends. Individual end alignment files are expected to be sorted by"+
            " read name. Multiple alignments are allowed and in this case the single best pairing will be selected.";
    @Option(shortName="I1",
            doc="Input file (bam or sam) with alignments for end 1 (first mate in a pair).",
            optional=false)
    public File IN1 = null;
    @Option(shortName="I2",
            doc="Input file (bam or sam) with alignments for end 2 (second mate in a pair).",
            optional=false)
    public File IN2 = null;
    @Option(shortName="O",optional=false, doc="Output file to write found/selected pairs into.")
        public File OUTPUT = null;
    @Option(shortName="F",doc="Turns on a 'filter' mode: only records/pairs passing the filter will be written "+
                "into the output file. Filter condition is a logical combination (using parentheses for grouping, "+
                "& for AND, | for OR, = for specifying values) of the primitives listed below. Primitives that end with "+
                " 1 or 2 apply specifically to pair end 1 or 2, respectively; when, in addition to primitives <P>1 and <P>2, " +
                " a primitive <P> is also defined, it is always interpreted as <P>1 & <P>2. Primitives: PAIRSONLY "+
                "(print only pairs=both ends mapped), MINQ1=<N>, MINQ2=<N>, MINQ=<N> (minimum alignment quality if read is mapped) "+
                " for MINQ1=<N> & MINQ2=<N>), ERRDIFF1=<N>, ERRDIFF2=<N> " +
                "(when next-best alignment(s) are available",
            optional = true)
        public String FILTER = null;
    @Option(shortName="Q", optional=true, doc="Minimum mapping quality required on both ends in order to accept the pair.")
        public Integer MINQ = -1;

    public static final int INFINITY = 1000000000;

    // we will collect some stats along the way:
    private int fragments_seen = 0;
    private int end1_missing = 0;
    private int end2_missing = 0;
    private int end1_unmapped = 0;
    private int end2_unmapped = 0;
    private int end1_unpaired_unmapped = 0;
    private int end2_unpaired_unmapped = 0;
    private int both_unmapped = 0;
    private int both_mapped = 0;
    private int both_unique = 0;
    private int proper_pair = 0;
    private int proper_unique_pair = 0;
    private int outer_pair = 0;
    private int side_pair = 0;
    private int inter_chrom = 0;

    /** Required main method implementation. */
    public static void main(final String[] argv) {
        System.exit(new PairMaker().instanceMain(argv));
    }

    protected int doWork() {

        SAMFileReader end1Reader = new SAMFileReader(IN1);
        SAMFileReader end2Reader = new SAMFileReader(IN2);

        SAMFileHeader h = checkHeaders(end1Reader.getFileHeader(), end2Reader.getFileHeader() );

        SAMFileWriter outWriter = new SAMFileWriterFactory().makeSAMOrBAMWriter(h, true, OUTPUT);

        ParallelSAMIterator pi = new ParallelSAMIterator(end1Reader, end2Reader);

        List<SAMRecord> end1 ;
        List<SAMRecord> end2 ;

        SAMRecord r1 = null, r2 = null; // alignments selected for ends 1 and 2, respectively, out of (possibly) multiple alternative placements

        while ( pi.hasNext() ) {

            fragments_seen++;

            Pair< List<SAMRecord>, List<SAMRecord> > ends = pi.next();

            end1 = ends.getFirst();
            end2 = ends.getSecond();

            if ( end1.size() == 0 ) {
                // nothing at all for end1, choose best from end2 and save
                end1_missing++;
                r1 = null;
                r2 = selectBestSingleEnd(end2);
                if ( AlignmentUtils.isReadUnmapped(r2) ) end2_unpaired_unmapped++;
                setPairingInformation(r1,r2);
                outWriter.addAlignment(r2);
                continue;
            }
            if ( end2.size() == 0 ) {
                // nothing at all for end2, choose best from end1 and save
                end2_missing++;
                r1 = selectBestSingleEnd(end1);
                r2 = null;
                if ( AlignmentUtils.isReadUnmapped(r1) ) end1_unpaired_unmapped++;
                setPairingInformation(r1,r2);
                outWriter.addAlignment(r1);
                continue;
            }

            // we got reads on both sides

            if ( end1.size() == 1 && end2.size() == 1 ) {
                // unique alignments on both ends: not much to do, just save as a pair
                r1 = end1.get(0);
                r2 = end2.get(0);
                if ( AlignmentUtils.isReadUnmapped(r1) ) {
                    end1_unmapped++;
                    if ( AlignmentUtils.isReadUnmapped(r2) ) { end2_unmapped++; both_unmapped++; }
                } else {
                    if ( AlignmentUtils.isReadUnmapped(r2)) end2_unmapped++;
                    else {
                        // both mapped
                        both_mapped++;

                        boolean unique = false;
                        if ( r1.getMappingQuality() > 0 &&
                              r2.getMappingQuality() > 0  ) { unique = true; both_unique++; }

                        if ( !r1.getReferenceIndex().equals(r2.getReferenceIndex()) ) {
                             inter_chrom++;
                        } else {
                             switch ( orientation(r1,r2) ) {
                                case INNER :  proper_pair++; if ( unique ) proper_unique_pair++;  break;
                                case OUTER: outer_pair++; break;
                                case LEFT:
                                case RIGHT: side_pair++; break;
                                default:
                             }
                        }
                    }
                }

                setPairingInformation(r1,r2);
                outWriter.addAlignment(r1);
                outWriter.addAlignment(r2);
                continue;
            }

            if ( end1.size() == 1 && AlignmentUtils.isReadUnmapped(end1.get(0)) ) {
                // special case: multiple alignments for end2 but end1 is unmapped: just select best for end2
                r1 = end1.get(0);
                r2 = selectBestSingleEnd(end2);
                end1_unmapped++;
                if ( AlignmentUtils.isReadUnmapped(r2) ) { end2_unmapped++; both_unmapped++; }
                setPairingInformation(r1,r2);
                outWriter.addAlignment(r1);
                outWriter.addAlignment(r2);
                continue;
            }

            if ( end2.size() == 1 && AlignmentUtils.isReadUnmapped(end2.get(0)) ) {
                // special case: multiple alignments for end1 but end2 is unmapped: just select best for end1
                r1 = selectBestSingleEnd(end1);
                r2 = end2.get(0);
                end2_unmapped++;
                if ( AlignmentUtils.isReadUnmapped(r1) ) { end1_unmapped++; both_unmapped++; }
                setPairingInformation(r1,r2);
                outWriter.addAlignment(r1);
                outWriter.addAlignment(r2);
                continue;
            }

            // ok, if we are here then we got both ends mapped and multiple alignments in at least one end.
            // Let's loop through candidates and choose the best pair:
/*
            List<Pairing> good = new ArrayList<Pairing>();
            List<Pairing> bad = new ArrayList<Pairing>();
            double best_good = INFINITY;

            for ( SAMRecord candidate1 : end1 ) {
                for ( SAMRecord candidate2 : end2 ) {
                    if ( candidate1.getReferenceIndex() == candidate2.getReferenceIndex()
                         && orientation(candidate1,candidate2)==PairOrientation.INNER ) {
                        double score = pairingScore(candidate1, candidate2);
                    }
                }
            }
*/
            Pair<SAMRecord, SAMRecord> bestPair = selectBestPair(end1,end2);

//            r1 = selectUniqueSingleEnd(end1,MINQ.intValue());
//            r2 = selectUniqueSingleEnd(end2,MINQ.intValue());

            r1 = bestPair.first;
            r2 = bestPair.second;

            both_mapped++;
            if ( r1.getMappingQuality() > 0 && r2.getMappingQuality() > 0 ) both_unique++;
            if ( r1.getReferenceIndex() == r2.getReferenceIndex() &&
                 orientation(r1,r2) == PairOrientation.INNER ) {
                      proper_pair++;
            }
            if ( r1.getMappingQuality() > 0 && r2.getMappingQuality() > 0 &&
                r1.getReferenceIndex() == r2.getReferenceIndex() &&
                 orientation(r1,r2) == PairOrientation.INNER ) {
                      proper_unique_pair++;
            }
            setPairingInformation(r1,r2);
            outWriter.addAlignment(r1);
            outWriter.addAlignment(r2);


        }

        pi.close();
        outWriter.close();

        System.out.println();
        System.out.println("Total fragments (read pairs): "+fragments_seen);

        System.out.println("Unpaired end1 reads (end2 missing): "+end2_missing);
        System.out.println("Unpaired end1 reads (end2 missing), unmapped: "+end1_unpaired_unmapped);
        System.out.println("Unpaired end2 reads (end1 missing): "+end1_missing);
        System.out.println("Unpaired end2 reads (end1 missing), unmapped: "+end2_unpaired_unmapped);
        System.out.println("Pairs with end1 unmapped (regardless of end2 status): "+end1_unmapped);
        System.out.println("Pairs with end2 unmapped (regardless of end1 status): "+end2_unmapped);
        System.out.println("Pairs with both ends unmapped: "+both_unmapped);
        System.out.println("Pairs with both ends mapped: "+both_mapped);
        System.out.println("Pairs with both ends mapped uniquely (MQ>0): "+both_unique);
        System.out.println("Pairs with both ends mapped properly: "+proper_pair);
        System.out.println("Pairs with both ends mapped uniquely and properly: "+proper_unique_pair);
        System.out.println();
        return 0;
    }

    private Query<Pair<SAMRecord,SAMRecord> > parseConditions(String filter) {

        filter = filter.trim();
        Query<Pair<SAMRecord,SAMRecord>> result1, result2;

        int level = 0; // parentheses level

        for ( int i = 0 ; i < filter.length() ; i++ ) {
            switch ( filter.charAt(i) ) {
            case '(': level++; break;
            case ')': level--;
                      if ( level < 0 ) throw new RuntimeException("Too many closing parentheses in the expression.");
                      break;
            case '&': if ( level > 0 ) break; // parenthised expression - not now!
                        // we are at level 0: parse expressions to the left and to the right of '&' operator
                      return new CompositeQuery<Pair<SAMRecord,SAMRecord> >(parseConditions(filter.substring(0,i)),
                                                                        parseConditions(filter.substring(i+1)),
                                                                        Query.Operator.AND);
            case '|': if ( level > 0 ) break; // inside parenthised expression - keep scanning, we'll process the whole expression later
                          // we are at level 0: parse expressions to the left and to the right of '|' operator
                      return new CompositeQuery<Pair<SAMRecord,SAMRecord> >(parseConditions(filter.substring(0,i)),
                                                                            parseConditions(filter.substring(i+1)),
                                                                            Query.Operator.OR);
            default: break;
            }
        }

        if ( level > 0 ) throw new RuntimeException("Too many opening parentheses in the expression.");

        // if we ended up here, this is either a single parenthized expression or a primitive.
        // filter was trimmed; if it is a parenthized expression, ( and ) should be first/last symbols:
        if ( filter.charAt(0) == '(' && filter.charAt(filter.length()-1) == ')')
            return parseConditions(filter.substring(1,filter.length()-1));

        // ok, it's a primitive:
        int equal_pos = filter.indexOf('=');
        if ( equal_pos < 0  ) { // it's not a <tag>=<value> expression, but a logical primitive
            if ( "PAIRSONLY".equals(filter) ) return new BothEndsMappedQuery();
        }

        return null;
    }

    /**
     * Utility method: checks if the two headers are the same. Returns the first one if they are,
     * a non-NULL one if the other one is NULL, or NULL if both headers are NULL. If headers are
     * both not NULL and are not the same, a RuntimeException is thrown. 
     * @param h1
     * @param h2
     * @return true if the headers are the same
     */
    private SAMFileHeader checkHeaders(SAMFileHeader h1, SAMFileHeader h2) {

        if ( h1 == null ) return h2;
        if ( h2 == null ) return h1;

//        if ( ! h1.getReadGroups().equals(h2.getReadGroups())) throw new RuntimeException("Read groups in the two input files do not match");
//        if ( ! h1.getSequenceDictionary().equals(h2.getSequenceDictionary()) ) throw new RuntimeException("Sequence dictionaries in the two input files do not match");
//        if ( ! h1.getProgramRecords().equals(h2.getProgramRecords()) ) throw new RuntimeException("Program records in the two input files do not match");
        if ( ! h1.equals(h2) ) throw new RuntimeException("Headers in the two input files do not match");
        return h1;
    }

    /** Given a list of alignments, returns the one with the best mapping quality score.
     *  If there is more than one alignment with the same score (got to be 0), one of
     *  these best-scoring alignments will be returned at random.
     * @param l
     * @return
     */
    private SAMRecord selectBestSingleEnd(List<SAMRecord> l) {
        if ( l.size() == 0 ) return null; // should not happen; just don not want to crash here, but somewhere else
        if ( l.size() == 1 ) return l.get(0); // not much choice...
        int best_qual = -1;
        int n_unmapped = 0;
        List<SAMRecord> best = new ArrayList<SAMRecord>();

        for ( SAMRecord r : l ) {
            if ( r.getReadUnmappedFlag() ) {
                // paranoid; if there are ANY alignments available, there should not be any "unmapped" records among them;
                // and if the read is "unmapped" indeed, then there should be no other alignments reported
                n_unmapped++;
                continue;
            }
            if ( r.getMappingQuality() > best_qual) {
                best_qual = r.getMappingQuality();
                best.clear();
                best.add(r);
                continue;
            }
            if ( r.getMappingQuality() == best_qual ) best.add(r);
        }
        if ( best.size() == 0 ) throw new RuntimeException("Currently Unsupported: SAM file might be not fully compliant. "+
                                                                        "Multiple 'unmapped' records found for read "+l.get(0).getReadName());
        if ( best.size() == 1 ) return best.get(0);
        if ( best_qual != 0 ) throw new RuntimeException("Multiple alignments for the same read found with non-zero score. "+
                                            "Read: "+l.get(0).getReadName()+" best score: "+best_qual);
        return best.get((int)(Math.random()*best.size()));
    }

    private Pair<SAMRecord,SAMRecord> selectBestPair(List<SAMRecord> end1, List<SAMRecord> end2) {
        SAMRecord r1 = selectBestSingleEnd(end1);
        SAMRecord r2 = selectBestSingleEnd(end2);

        if ( AlignmentUtils.isReadUnmapped(r1) || AlignmentUtils.isReadUnmapped(r2) ) {
            throw new RuntimeException("Unmapped read in selectBestPair: should never happen. read1="+r1.toString()+"; read2="+r2.toString());
        }

        if ( r1.getMappingQuality() > 0 && r2.getMappingQuality() > 0 ) {
            // we got best placements for the reads
            return new Pair<SAMRecord,SAMRecord>(r1,r2);
        }

        // at least one alignment is non-unique

        List<SAMRecord> toChooseFrom = new ArrayList<SAMRecord>();

        if ( r1.getMappingQuality() > 0 ) {
            // r2 is non unique
            for ( SAMRecord r : end2 ) {
                if ( r.getReferenceIndex().intValue() == r1.getReferenceIndex().intValue() ) {
                    toChooseFrom.add(r);
                }
            }
            if ( toChooseFrom.size() == 1 ) {
                return new Pair<SAMRecord,SAMRecord>(r1,toChooseFrom.get(0));
            } else {
                if ( toChooseFrom.size() > 1 ) {
                    return new Pair<SAMRecord,SAMRecord>(r1,toChooseFrom.get((int)(Math.random()*toChooseFrom.size())));
                } else {
                    return new Pair<SAMRecord,SAMRecord>(r1,end2.get((int)(Math.random()*end2.size())));
                }
            }
        }

        if ( r2.getMappingQuality() > 0 ) {
            // r1 is non unique
            for ( SAMRecord r : end1 ) {
                if ( r.getReferenceIndex().intValue() == r2.getReferenceIndex().intValue() ) {
                    toChooseFrom.add(r);
                }
            }
            if ( toChooseFrom.size() == 1 ) {
                return new Pair<SAMRecord,SAMRecord>(toChooseFrom.get(0),r2);
            } else {
                if ( toChooseFrom.size() > 1 ) {
                    return new Pair<SAMRecord,SAMRecord>(toChooseFrom.get((int)(Math.random()*toChooseFrom.size())),r2);
                } else {
                    return new Pair<SAMRecord,SAMRecord>(end2.get((int)(Math.random()*end2.size())),r2);
                }
            }
        }

        // both are non-unique
        List<Pair<SAMRecord,SAMRecord>> toChooseFromP = new ArrayList<Pair<SAMRecord,SAMRecord>>();
        for ( SAMRecord rr1 : end1 ) {
            for ( SAMRecord rr2 : end2 ) {
                if ( rr1.getReferenceIndex().intValue() == rr2.getReferenceIndex().intValue() ) {
                    toChooseFromP.add ( new Pair<SAMRecord,SAMRecord>(rr1,rr2) );
                }
            }
        }
        if ( toChooseFrom.size() == 1 ) {
            return toChooseFromP.get(0);
        } else {
            if ( toChooseFrom.size() > 1 ) {
                return toChooseFromP.get((int)(Math.random()*toChooseFromP.size()));
            } else {
                return new Pair<SAMRecord,SAMRecord>(end1.get((int)(Math.random()*end1.size())),
                        end2.get((int)(Math.random()*end2.size())));
            }
        }

    }

    private SAMRecord selectUniqueSingleEnd(List<SAMRecord> l, int minq) {
        if ( l.size() == 0 ) return null; // should not happen; just don not want to crash here, but somewhere else
        if ( l.size() == 1 ) {
            if ( l.get(0).getMappingQuality() >= minq ) return l.get(0);
            else return null; // not unique enough
        }

        int n_unmapped = 0;
        List<SAMRecord> best = new ArrayList<SAMRecord>();

        for ( SAMRecord r : l ) {
            if ( AlignmentUtils.isReadUnmapped(r) ) {
                // paranoid; if there are ANY alignments available, there should not be any "unmapped" records among them;
                // and if the read is "unmapped" indeed, then there should be no other alignments reported
                n_unmapped++;
                continue;
            }
            if ( r.getMappingQuality() >= minq ) {
                best.add(r);
                continue;
            }
        }
        if ( best.size() == 0 ) return null; // no unique alignment
        if ( best.size() > 1 ) {
            for ( SAMRecord r : best ) {
                System.out.println("READ "+r.getReadName()+" mapQ="+r.getMappingQuality()+" at="+r.getReferenceName()+
                        ":"+r.getAlignmentStart()+"("+(r.getReadNegativeStrandFlag()?"-":"+")+") cig="+r.getCigarString());
            }
            throw new RuntimeException("Multiple alignments for read "+l.get(0).getReadName()+", all with Q>="+minq);
        }

        return best.get(0);
    }

    /**
     * Assumes that alignments r1 and r2 are the two ends of a selected mate pair, and sets pairing flags and reciprocal mate
     * mapping values for each of them (so that e.g. r2.getMateAlignmentStart() is properly set to
     * r1.getAlignmentStart(), etc). Any one of the two alignments can be null, in which case it is assumed
     * that the corresponding end is unmapped, and the flags/values in the other end will be set accordingly.
     * If both r1 and r2 are null, an exception will be thrown.
     * @param r1 first end in a mate pair
     * @param r2 second end in a mate pair
     */
    private void setPairingInformation(SAMRecord r1, SAMRecord r2) {
        // set mate information (note that r1 and r2 can not be 'null' simultaneously):

        if ( r1 == null && r2 == null ) throw new RuntimeException("Both ends of the mate pair are passed as 'null'");

        // take care of unpaired reads:
        if ( r2 == null ) {
            r1.setReadPairedFlag(false);
            r1.setMateReferenceIndex( SAMRecord.NO_ALIGNMENT_REFERENCE_INDEX );
            r1.setMateNegativeStrandFlag( false );
            r1.setMateAlignmentStart( SAMRecord.NO_ALIGNMENT_START );
            return;
        }

        if ( r1 == null ) {
            r2.setReadPairedFlag(false);
            r2.setMateReferenceIndex( SAMRecord.NO_ALIGNMENT_REFERENCE_INDEX );
            r2.setMateNegativeStrandFlag( false );
            r2.setMateAlignmentStart( SAMRecord.NO_ALIGNMENT_START );
            return;
        }

        // we got both reads

        r1.setReadPairedFlag(true);
        r2.setReadPairedFlag(true);

        boolean r1unmapped = AlignmentUtils.isReadUnmapped(r1);
        boolean r2unmapped = AlignmentUtils.isReadUnmapped(r2);

        r1.setMateUnmappedFlag( r2unmapped );
        r1.setMateReferenceIndex( r2unmapped ? SAMRecord.NO_ALIGNMENT_REFERENCE_INDEX : r2.getReferenceIndex() );
        r1.setMateNegativeStrandFlag(r2unmapped ? false : r2.getReadNegativeStrandFlag() );
        r1.setMateAlignmentStart( r2unmapped ? SAMRecord.NO_ALIGNMENT_START : r2.getAlignmentStart());

        r1.setFirstOfPairFlag(true);
        r1.setSecondOfPairFlag(false);

        r2.setMateUnmappedFlag( r1unmapped );
        r2.setMateReferenceIndex( r1unmapped ? SAMRecord.NO_ALIGNMENT_REFERENCE_INDEX : r1.getReferenceIndex() );
        r2.setMateNegativeStrandFlag(r1unmapped ? false : r1.getReadNegativeStrandFlag() );
        r2.setMateAlignmentStart( r1unmapped ? SAMRecord.NO_ALIGNMENT_START : r1.getAlignmentStart());
        r2.setFirstOfPairFlag(false);
        r2.setSecondOfPairFlag(true);
    }

    /**
     * Returns fragment length inferred from the two alignments, or 1,000,000,000 if reads align
     * on different chromosomes or are not mapped at all. NOTE: the returned fragment length is
     * start+read length of the rightmost alignment minus start of the leftmost one; it makes
     * sense only for "proper" pairs (leftmost forward, rightmost reverse); for all other pairs
     * the returned number does not allow for any meaningful interpretation. 
     * @param r1
     * @param r2
     * @return
     */
    private int fragmentSize(final SAMRecord r1, final SAMRecord r2) {
        if ( r1 == null || AlignmentUtils.isReadUnmapped(r1) ||
             r2 == null || AlignmentUtils.isReadUnmapped(r2) ||
                !r1.getReferenceIndex().equals(r2.getReferenceIndex()) ) return INFINITY;
        if ( r1.getAlignmentStart() <= r2.getAlignmentStart() )
             return ( r2.getAlignmentStart() + r2.getReadLength() - r1.getAlignmentStart());
        else return ( r1.getAlignmentStart() + r1.getReadLength() - r2.getAlignmentStart());
    }

    enum PairOrientation {
        INNER, OUTER, LEFT, RIGHT, NONE
    }

    /**
     * Returns orientation of the pair: INNER for "-->   <--", OUTER for "<--  -->",
     * LEFT for "<--   <--" and RIGHT for "-->    -->" (regardless of which read in a pair, 1 or 2,
     * actually maps to the left and which to the right). If any of the reads is null or unmapped, returns NONE.
     * If reads are on different contigs, they are still ordered according to the underlying contig order (by reference
     * index), and the returned value reflects their relative orientation as described above (however it does not seem
     * to be very useful in that case).
     * @param r1
     * @param r2
     * @return
     */
    private PairOrientation orientation(SAMRecord r1, SAMRecord r2) {

        if ( r1 == null || r2 == null || AlignmentUtils.isReadUnmapped(r1) || AlignmentUtils.isReadUnmapped(r2))
            return PairOrientation.NONE;

        SAMRecord left, right;

        if ( !r1.getReferenceIndex().equals(r2.getReferenceIndex()) ) {
            if ( r1.getAlignmentStart() <= r2.getAlignmentStart() ) {
                left = r1;
                right = r2;
            } else {
                left = r2;
                right = r1;
            }
        } else {
            if ( r1.getReferenceIndex() < r2.getReferenceIndex() ) {
                left = r1;
                right = r2;
            } else {
                left = r2;
                right = r1;
            }
        }

        if ( !  left.getReadNegativeStrandFlag() ) { // left is forward
            if ( right.getReadNegativeStrandFlag() ) return PairOrientation.INNER; // left is forward, right is reverse
            else return PairOrientation.RIGHT;  // left is forward, right is forward
        }  else {  // left is reverse
            if ( right.getReadNegativeStrandFlag() ) return PairOrientation.LEFT; // left is reverse, right is reverse
            else return PairOrientation.OUTER;  // left is reverse, right is forward
        }
    }

    class Pairing {
        SAMRecord r1;
        SAMRecord r2;
        double score;

        Pairing() {
            this(null,null,INFINITY);
        }

        Pairing(SAMRecord r1, SAMRecord r2) {
            this(r1,r2,INFINITY);
        }
        Pairing(SAMRecord r1, SAMRecord r2, double score) {
            this.r1 = r1;
            this.r2 = r2;
            this.score = score;
        }

        SAMRecord getFirst() { return r1; }
        SAMRecord getSecond() { return r2; }
        double getScore() { return score; }

        void setFirst(SAMRecord r) { r1 = r; }
        void setSecond(SAMRecord r) { r2 = r; }
        void setScore(double score) { this.score = score; }
    }

    private double pairingScore(final SAMRecord r1, final SAMRecord r2) {
        
        return ( ( r1.getMappingQuality() + r2.getMappingQuality() ) * Math.exp(1))  ;
    }

    interface Query<T> {
        boolean isSatisfied(T record) ;
        enum Operator { OR, AND };
    }

    class CompositeQuery<T> implements Query<T> {
        private Query<T> q1;
        private Query<T> q2;
        private Query.Operator type ; // 1 for 'and', 0 for 'or'

        CompositeQuery(Query<T> q1, Query<T> q2, Query.Operator type) {
            this.q1 = q1;
            this.q2 = q2;
            this.type = type;
        }

        public boolean isSatisfied(T record) {
            switch ( type ) {
            case AND: return q1.isSatisfied(record) && q2.isSatisfied(record);
            case OR:  return q1.isSatisfied(record) || q2.isSatisfied(record);
            default: throw new IllegalStateException("Unknown composite query operator");
            }
        }
    }

    class BothEndsMappedQuery implements Query< Pair<SAMRecord,SAMRecord> > {
        public boolean isSatisfied(Pair<SAMRecord,SAMRecord> p) {
            return ( ! AlignmentUtils.isReadUnmapped(p.getFirst()) && ! AlignmentUtils.isReadUnmapped(p.getSecond())) ;
        }
    }

}
