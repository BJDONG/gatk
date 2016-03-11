/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 ("BROAD") and the LICENSEE and is effective at the date the downloading is completed ("EFFECTIVE DATE").
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
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system ("PHONE-HOME") which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE'S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2016 Broad Institute, Inc.
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

package org.broadinstitute.gatk.tools.walkers.annotator;

import htsjdk.variant.variantcontext.Allele;
import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.GenotypeBuilder;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.vcf.VCFFormatHeaderLine;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.AnnotatorCompatible;
import org.broadinstitute.gatk.tools.walkers.annotator.interfaces.GenotypeAnnotation;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.genotyper.MostLikelyAllele;
import org.broadinstitute.gatk.utils.genotyper.PerReadAlleleLikelihoodMap;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.utils.sam.GATKSAMRecord;
import org.broadinstitute.gatk.utils.variant.GATKVCFConstants;
import org.broadinstitute.gatk.utils.variant.GATKVCFHeaderLines;

import java.util.*;

/**
 * Number of forward and reverse reads that support each allele
 *
 * <p>The StrandAlleleCountsBySample annotation produces read counts per allele (including (REF) and per strand.  Note that, as with the <a href="https://www.broadinstitute.org/gatk/guide/tooldocs/org_broadinstitute_gatk_tools_walkers_annotator_DepthPerAlleleBySample.php">AD</a> annotation, the allele counts here should not be used to make assumptions about the called genotype.</p>
 *
 * <p>This annotation produces 2 values per allele at each site, corresponding to the number of reads that support the following (in that order):</p>
 * <ul>
 *     <li>the reference allele on the forward strand</li>
 *     <li>the reference allele on the reverse strand</li>
 *     <li>the first alternate allele on the forward strand</li>
 *     <li>the first alternate allele on the reverse strand</li>
 *     <li>the second alternate allele on the forward strand</li>
 *     <li><i>...etc</i></li>
 * </ul>
 *
 * <h3>Example</h3>
 * <pre>GT:AD:GQ:PL:SB:SAC       1/2:1,18,12:99:1022,326,382,537,0,487:1,0,4,8:1,0,3,15,4,8</pre>
 * <p>In this example, the reference allele is supported by 1 read on the forward strand, the first alternate allele is supported by 3 forward and 15 reverse reads, and the second alternate allele is supported by 4 forward and 8 reverse reads.</p>
 *
 * <h3>Caveats</h3>
 * <ul>
 *     <li>This annotation can only be generated by HaplotypeCaller (it will not work when called from VariantAnnotator).</li>
 * </ul>
 *
 * <h3>Related annotations</h3>
 * <ul>
 *     <li><b><a href="https://www.broadinstitute.org/gatk/guide/tooldocs/org_broadinstitute_gatk_tools_walkers_annotator_DepthPerAlleleBySample.php">DepthPerAlleleBySample</a></b> displays the number of reads supporting each allele, without stratifying by strand.</li>
 * </ul>
 */


public class StrandAlleleCountsBySample extends GenotypeAnnotation {
    private final static Logger logger = Logger.getLogger(StrandAlleleCountsBySample.class);
    private final boolean[] warningsLogged = new boolean[AnnotationUtils.WARNINGS_LOGGED_SIZE];

    @Override
    public void annotate(final RefMetaDataTracker tracker,
                         final AnnotatorCompatible walker,
                         final ReferenceContext ref,
                         final AlignmentContext stratifiedContext,
                         final VariantContext vc,
                         final Genotype g,
                         final GenotypeBuilder gb,
                         final PerReadAlleleLikelihoodMap alleleLikelihoodMap) {

        if ( !AnnotationUtils.isAppropriateInput(GATKVCFConstants.STRAND_COUNT_BY_SAMPLE_KEY, walker, alleleLikelihoodMap, g, warningsLogged, logger) ) {
            return;
        }

        gb.attribute(GATKVCFConstants.STRAND_COUNT_BY_SAMPLE_KEY, getStrandCounts(Collections.singletonMap(g.getSampleName(), alleleLikelihoodMap), vc));
    }

    @Override
    public List<String> getKeyNames() { return Collections.singletonList(GATKVCFConstants.STRAND_COUNT_BY_SAMPLE_KEY); }

    @Override
    public List<VCFFormatHeaderLine> getDescriptions() {
        return Collections.singletonList(GATKVCFHeaderLines.getFormatLine(getKeyNames().get(0)));
    }

    /**
     * This method was inspired by (copied from) StrandBiasTest.getContingencyTable().  Unlike getContingencyTable, it
     * returns values for all alleles rather than only reference and the most likely allele.  Since this is not useful
     * for StrandBias calculations, it's here and it skips the Nx2 table format used in that method
     */
    private int[] getStrandCounts( final Map<String, PerReadAlleleLikelihoodMap> stratifiedPerReadAlleleLikelihoodMap, final VariantContext vc) {
        if( stratifiedPerReadAlleleLikelihoodMap == null ) { throw new IllegalArgumentException("stratifiedPerReadAlleleLikelihoodMap cannot be null"); }
        if( vc == null ) { throw new IllegalArgumentException("input vc cannot be null"); }

        final Set<Allele> alleles = new HashSet<>(vc.getAlleles());

        final int[] table = new int[vc.getNAlleles()*2];

        for (final PerReadAlleleLikelihoodMap maps : stratifiedPerReadAlleleLikelihoodMap.values() ) {
            // make sure that there's a meaningful relationship between the alleles in the perReadAlleleLikelihoodMap and our VariantContext
            if ( ! maps.getAllelesSet().isEmpty() && ! maps.getAllelesSet().containsAll(alleles) )
                throw new IllegalStateException("VC alleles " + alleles + " not a strict subset of per read allele map alleles " + maps.getAllelesSet());
            for (final Map.Entry<GATKSAMRecord,Map<Allele,Double>> el : maps.getLikelihoodReadMap().entrySet()) {
                final MostLikelyAllele mostLikelyAllele = PerReadAlleleLikelihoodMap.getMostLikelyAllele(el.getValue(), alleles);
                final GATKSAMRecord read = el.getKey();
                if (mostLikelyAllele.isInformative())
                    updateTable(table, vc.getAlleleIndex(mostLikelyAllele.getAlleleIfInformative()), read);
            }
        }

        return table;
    }

    private void updateTable(final int[] table, final int alleleIndex, final GATKSAMRecord read) {
        if (alleleIndex < 0 || (alleleIndex+1)*2 > table.length) return;
        final int offset = alleleIndex * 2;

        //Unstranded reads are not meaningful for this annotation, they can be found in the AD annotation
        if (!read.isStrandless()) {
            final boolean isFW = !read.getReadNegativeStrandFlag();
            table[offset + (isFW ? 0 : 1)]++;
        }
    }

}
