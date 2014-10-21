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

package org.broadinstitute.gatk.tools.walkers.variantutils;

import org.broadinstitute.gatk.utils.commandline.Argument;
import org.broadinstitute.gatk.utils.commandline.ArgumentCollection;
import org.broadinstitute.gatk.utils.commandline.Output;
import org.broadinstitute.gatk.engine.arguments.StandardVariantContextInputArgumentCollection;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.engine.walkers.Reference;
import org.broadinstitute.gatk.engine.walkers.RodWalker;
import org.broadinstitute.gatk.engine.walkers.Window;
import org.broadinstitute.gatk.utils.Utils;
import org.broadinstitute.gatk.utils.collections.Pair;
import org.broadinstitute.gatk.utils.exceptions.UserException;
import htsjdk.variant.variantcontext.VariantContext;

import java.io.PrintStream;
import java.util.*;

/**
 * Code to explore http://arxiv.org/abs/1112.1528
 *
 * @author Mark DePristo
 * @since 2011
 */
@Reference(window=@Window(start=-Yamagishi.WINDOW_SIZE,stop=Yamagishi.WINDOW_SIZE))
public class Yamagishi extends RodWalker<Pair<String, String>, Map<String, Yamagishi.KMerCounter>> {
    public final static int WINDOW_SIZE = 50;

    @ArgumentCollection
    protected StandardVariantContextInputArgumentCollection variantCollection = new StandardVariantContextInputArgumentCollection();

    @Argument(shortName = "k", fullName = "kmerSize", doc="KMer size", required=true)
    protected int kmerSize;

    @Argument(shortName = "debug", fullName = "debug", doc="If true print out a lot of info", required=true)
    protected boolean DEBUG;

    @Output(doc="File to which results should be written")
    protected PrintStream out;

    @Argument(fullName="selectTypeToInclude", shortName="selectType", doc="Select only a certain type of variants from the input file. Valid types are INDEL, SNP, MIXED, MNP, SYMBOLIC, NO_VARIATION. Can be specified multiple times", required=false)
    private List<VariantContext.Type> TYPES_TO_INCLUDE = Collections.emptyList();

    EnumSet<VariantContext.Type> includedTypes;

    @Override
    public void initialize() {
        if ( kmerSize != 3 )
            throw new UserException.BadArgumentValue("kmerSize", "Only k=3 is currently implemented");

        // if user specified types to include, add these, otherwise, add all possible variant context types to list of vc types to include
        includedTypes = TYPES_TO_INCLUDE.isEmpty() ? EnumSet.allOf(VariantContext.Type.class) : EnumSet.copyOf(TYPES_TO_INCLUDE);
    }

    private final List<String> ALL_NAMES = Arrays.asList("ref", "alt"); // , "snp", "indel");

    public class KMerCounter {
        final int k;
        final Map<String, Integer> counts = new HashMap<String, Integer>();
        final String name;

        public KMerCounter(final int k, final String name) {
            this.k = k;
            this.name = name;
        }

        public void inc(final String bases) {
            for ( int i = 0; i < bases.length() - k; i++ ) {
                final String kmer = bases.substring(i, i+k);
                final int prev = counts.containsKey(kmer) ? counts.get(kmer) : 0;
                counts.put(kmer, prev + 1);
            }
        }

        public void add(final KMerCounter o) {
            for ( Map.Entry<String, Integer> entry : o.counts.entrySet() ) {
                final String key = entry.getKey();
                final int by = entry.getValue();
                final int prev = counts.containsKey(key) ? counts.get(key) : 0;
                counts.put(key, prev + by);
            }
        }

        public Iterable<Map.Entry<String, Integer>> countsInOrder() {
            return new TreeMap<String, Integer>(counts).entrySet();
        }
    }

    @Override
    public Pair<String, String> map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if ( tracker == null ) // RodWalkers can make funky map calls
            return null;

        // snp or indel if possible
        final VariantContext vc = tracker.getFirstValue(variantCollection.variants, ref.getLocus());

        if ( vc == null || ! vc.isBiallelic() || ! includedTypes.contains(vc.getType())) {
            return null;
        }

        final String refBases = new String(ref.getBases());
        final String leftRef = refBases.substring(0, WINDOW_SIZE);
        String vcBases = "";
        String rightRef = refBases.substring(WINDOW_SIZE+1, 2*WINDOW_SIZE+1);

        if ( vc.isSNP() ) {
            vcBases = vc.getAlternateAllele(0).getBaseString();
        } else if (vc.isIndel()) {
            if ( vc.isSimpleInsertion() ) {
                vcBases = vc.getAlternateAllele(0).getBaseString();
            } else if ( vc.isSimpleDeletion() ) {
                final int delSize = Math.abs(vc.getIndelLengths().get(0));
                if ( delSize > WINDOW_SIZE )
                    return null;
                rightRef = refBases.substring(WINDOW_SIZE+delSize+1, 2*WINDOW_SIZE+1);
            } else {
                return null;
                //throw new ReviewedGATKException("What the hell is this VCF: " + vc);
            }
        } else {
            return null;
        }

        final String altBases = leftRef + vcBases + rightRef;

        if ( DEBUG ) {
            final String offset = Utils.dupString(' ', leftRef.length());
            logger.info("vc.ref  : " + vc.getReference());
            logger.info("vc.alt  : " + vc.getAlternateAllele(0));
            logger.info("left    : " + leftRef);
            logger.info("vc      : " + offset + vcBases);
            logger.info("right   : " + offset + rightRef);
            logger.info("refBases: " + refBases);
            logger.info("alt     : " + altBases);
        }

        return new Pair<String, String>(refBases, altBases);
    }

    @Override
    public Map<String, KMerCounter> reduceInit() {
        Map<String, KMerCounter> tables = new HashMap<String, KMerCounter>();
        for ( String name : ALL_NAMES )
            tables.put(name, new KMerCounter(kmerSize, name));
        return tables;
    }

    @Override
    public Map<String, KMerCounter> reduce(Pair<String, String> refAndAlt, Map<String, KMerCounter> sum) {
        if ( refAndAlt != null ) {
            sum.get("ref").inc(refAndAlt.getFirst());
            sum.get("alt").inc(refAndAlt.getSecond());
        }
        return sum;
    }

    @Override
    public void onTraversalDone(Map<String, KMerCounter> sum) {
        out.printf("name\tkmer\tcount%n");
        for ( KMerCounter table : new TreeMap<String, KMerCounter>(sum).values() ) {
            for ( Map.Entry<String, Integer> entry : table.countsInOrder() ) {
                out.printf("%s\t%s\t%d%n", table.name, entry.getKey(), entry.getValue());
            }
        }
    }
}