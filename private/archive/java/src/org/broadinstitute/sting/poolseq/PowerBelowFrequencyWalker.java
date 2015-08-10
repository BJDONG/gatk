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
* Copyright 2012-2015 Broad Institute, Inc.
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

package org.broadinstitute.sting.gatk.walkers.poolseq;

import org.broadinstitute.sting.gatk.walkers.LocusWalker;
import org.broadinstitute.sting.gatk.walkers.DataSource;
import org.broadinstitute.sting.gatk.walkers.By;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.QualityUtils;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.StingException;
import org.broadinstitute.sting.utils.PoolUtils;
import net.sf.samtools.SAMRecord;

import java.util.List;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: chartl
 * Date: Oct 8, 2009
 * Time: 9:44:35 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Given an input N, this walker calculates the power to detect a polymorphism with N, N-1, N-2, ..., 1 variant alleles in a pooled setting
 */
@By(DataSource.REFERENCE)
public class PowerBelowFrequencyWalker extends LocusWalker<Integer,Integer> {
    @Output
    PrintStream out;

    @Argument(fullName="lodThreshold", shortName="lod", doc="Threshold for log likelihood ratio to be called a SNP. Defaults to 3.0", required = false)
    public double lodThresh = 3.0;

    @Argument(fullName="minimumQScore", shortName="qm", doc="Use bases whose phred (Q) score meets or exceeds this number. Defaults to 0", required = false)
    public byte minQ = 0;

    @Argument(fullName="poolSize", shortName="ps", doc="Number of individuals in the pool", required = true)
    public int numIndividuals = 0;

    @Argument(fullName="alleleFrequency", shortName="af", doc="Calculate power for all allele frequencies below this. Defaults to 4", required=false)
    public int alleleFreq = 4;

    @Argument(fullName="useMeanProb", doc="Use the mean probability as the \"average quality\" rather than median Q-score")
    boolean useMean = false;

    @Argument(fullName="minimumMappingQuality", shortName="mmq", doc="Only use reads above this mapping quality in the power calculation", required=false)
    int minMappingQuality = -1;

    @Argument(fullName="ignoreForwardReads",doc="Ignore the forward reads at a site. Defaults to false.", required = false)
    boolean ignoreForwardReads = false;

    @Argument(fullName="ignoreReverseReads",doc="Ignore the reverse reads at a site. Defaults to false.", required = false)
    boolean ignoreReverseReads = false;

    private boolean calledByAnotherWalker = false;

    public void initialize() {
        if ( alleleFreq < 1 ) {
            String err = "Allele frequency (-af) must be greater than or equal to one.";
            throw new StingException(err);
        }

        if ( numIndividuals == 0 ) {
            calledByAnotherWalker = true;
        }
    }

    public Integer reduceInit() {
        out.print(makeHeader());
        return 0;
    }

    public Integer reduce(Integer mapint, Integer prevint) {
        return 0;
    }

    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        String output = String.format("%s", context.getLocation().toString());

        // threshold reads if necessary
        if ( ignoreForwardReads && ignoreReverseReads) {
            throw new StingException("User has elected to ignore both forward and reverse reads. Power is zero.");
        }
        else if ( ! ignoreForwardReads && ignoreReverseReads ) {
            org.broadinstitute.sting.playground.gatk.walkers.poolseq.ReadOffsetQuad rq = PoolUtils.splitReadsByReadDirection(context.getReads(),context.getOffsets());
            context = new AlignmentContext(context.getLocation(),rq.getFirstReads(),rq.getFirstOffsets());
        } else if ( ignoreForwardReads && ! ignoreReverseReads ) {
            org.broadinstitute.sting.playground.gatk.walkers.poolseq.ReadOffsetQuad rq = PoolUtils.splitReadsByReadDirection(context.getReads(),context.getOffsets());
            context = new AlignmentContext(context.getLocation(),rq.getSecondReads(),rq.getSecondOffsets());
        }

        if ( minQ > 0 ) {
            Pair<List<SAMRecord>, List<Integer>> thresh = PoolUtils.thresholdReadsByQuality(context.getReads(),context.getOffsets(),minQ);
            context = new AlignmentContext(context.getLocation(), thresh.getFirst(), thresh.getSecond());
        }

        if ( minMappingQuality > -1 ) {
            Pair<List<SAMRecord>,List<Integer>> goodMaps = PoolUtils.thresholdReadsByMappingQuality(context.getReads(),context.getOffsets(),minMappingQuality);
            context = new AlignmentContext(context.getLocation(), goodMaps.getFirst(), goodMaps.getSecond());
        }

        // calculate powers and put into output string

        for ( int i = 1; i <= alleleFreq; i ++ ) {
            output = String.format("%s\t%f",output,calculatePowerAtFrequency(context,i));
        }

        // print the output string

        out.printf("%s%n",output);

        return 0;
    }

    public double calculatePowerAtFrequency( AlignmentContext context, int alleles ) {
        return theoreticalPower( context.size(), getMeanQ(context), alleles, lodThresh );
    }

    public byte getMeanQ( AlignmentContext context ) {
        byte meanQ;
        if ( useMean ) {
            meanQ = QualityUtils.probToQual(expectedMatchRate(context));
        } else {
            meanQ = MathUtils.getQScoreMedian(context.getReads(),context.getOffsets());
        }

        return meanQ;
    }

    public double expectedMatchRate(AlignmentContext context) {
        int nReads = context.size();
        double matches = 0.0;
        for ( int r = 0; r < nReads; r ++ ) {
            matches += QualityUtils.qualToProb(context.getReads().get(r).getBaseQualities()[context.getOffsets().get(r)]);
        }

        return matches/nReads;
    }

    public String makeHeader() {
        // create the header
        String header = "chrm:pos";
        for ( int i = 1; i <= alleleFreq; i ++ ) {
            header = header + "\tPower_at_"+Integer.toString(i);
        }

        return String.format("%s%n", header);
    }

    public double theoreticalPower( int depth, byte q, int alleles, double lodThreshold ) {
        double power;
        if( depth <= 0 ) {
            power = 0.0;
        } else {
            double p_error = QualityUtils.qualToErrorProb(q);
            double snpProp = getSNPProportion(alleles);
            double kterm_num = Math.log10( snpProp * (1 - p_error) + (1 - snpProp) * (p_error/3) );
            double kterm_denom = Math.log10( p_error/3 );
            double dkterm_num = Math.log10( snpProp * (p_error/3) + (1 - snpProp) * (1 - p_error) );
            double dkterm_denom = Math.log10( 1 - p_error);

            int kaccept = (int) Math.ceil( ( lodThreshold - ( (double) depth ) * ( dkterm_num - dkterm_denom ) ) /
                    ( kterm_num - kterm_denom- dkterm_num + dkterm_denom ) );
            System.out.println("Error="+p_error+" snpProp="+snpProp+" alleles="+alleles+" lodThreshold="+lodThreshold+" kaccept="+kaccept);

            if (kaccept <= 0) {
                power = 0.0;
            } else {
                // we will reject the null hypothesis if we see kaccept or more SNPs, the power is the probability that this occurs
                // we can optimize this by checking to see which sum is smaller
                if ( depth - kaccept < kaccept ) {// kaccept > depth/2 - calculate power as P[hits between kaccept and depth]
                    power = MathUtils.binomialCumulativeProbability(kaccept, depth, depth, snpProp);
                } else { // kaccept < depth/2 - calculate power as 1-P[hits between 0 and kaccept]
                    power = 1-MathUtils.binomialCumulativeProbability(0, kaccept, depth, snpProp);
                }
            }
        }
        return power;
    }

    private double getSNPProportion(int alleles) {
        return ((double)alleles)/(2*numIndividuals);
    }

    public void setPoolSize(int poolSize) {
        if ( calledByAnotherWalker ) {
            numIndividuals = poolSize;
        } else {
            throw new StingException("This method should only be accessible by calling it from another walker.");
        }
    }
}
