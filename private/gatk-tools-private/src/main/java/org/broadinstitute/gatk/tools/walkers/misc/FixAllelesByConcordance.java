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

package org.broadinstitute.gatk.tools.walkers.misc;

import org.broadinstitute.gatk.utils.commandline.Input;
import org.broadinstitute.gatk.utils.commandline.Output;
import org.broadinstitute.gatk.utils.commandline.RodBinding;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.engine.walkers.By;
import org.broadinstitute.gatk.engine.walkers.DataSource;
import org.broadinstitute.gatk.engine.walkers.RodWalker;
import org.broadinstitute.gatk.engine.GATKVCFUtils;
import org.broadinstitute.gatk.utils.BaseUtils;
import org.broadinstitute.gatk.utils.variant.GATKVariantContextUtils;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.variant.vcf.VCFHeaderLine;
import htsjdk.variant.variantcontext.writer.VariantContextWriter;
import htsjdk.variant.variantcontext.*;
import htsjdk.variant.vcf.VCFUtils;

import java.util.*;

/**
 * A walker for reassigning ref and alt alleles for an improperly-created VCF by using concordance metrics to some
 * orthogonal data (sequencing). If you feel the need to use this walker, contact the creator of your VCF and berate
 * him or her until he or she makes it correctly. Do not use this walker. In fact, the walker will try to stop you
 * if you are not me.
 */
@By(DataSource.REFERENCE)
public class FixAllelesByConcordance extends RodWalker<Integer,Integer> {

    @Input(fullName="chip",doc="You shouldn't be using this walker.",required=true)
    public RodBinding<VariantContext> chip = null;

    @Input(fullName="seq",doc="You shoulnd't be using this walker.",required=true)
    public RodBinding<VariantContext> seq = null;

    @Output
    public VariantContextWriter out;

    Set<String> samples;

    public void initialize() {
        /*if ( ! System.getProperty("user.name").equals("chartl") ) {
            class UserShouldNotIgnoreRepeatedWarningsException extends UserException {
                public UserShouldNotIgnoreRepeatedWarningsException(String msg) {
                    super(msg);
                }
            }

            throw new UserShouldNotIgnoreRepeatedWarningsException("You shouldn't be using this walker.");
        }*/

        Map<String, VCFHeader> vcfRods = GATKVCFUtils.getVCFHeadersFromRods(getToolkit());
        Map<String,VCFHeader> onlyChip = new HashMap<String,VCFHeader>();
        onlyChip.put("chip",vcfRods.get("chip"));
        samples = new HashSet<String>();
        boolean init = false;
        for ( Map.Entry<String,VCFHeader> header : vcfRods.entrySet() ) {
            if ( ! init ) {
                samples.addAll(header.getValue().getGenotypeSamples());
                init = true;
            } else {
                samples.retainAll(new HashSet<String>((header.getValue().getGenotypeSamples())));
            }
        }
        Set<VCFHeaderLine> headerLines = VCFUtils.smartMergeHeaders(vcfRods.values(), true);
        out.writeHeader(new VCFHeader(headerLines,samples));
    }

    public Integer reduceInit() { return 0; }
    public Integer reduce(Integer a, Integer b) { return b + a;}

    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if ( tracker == null ) {
            return 0;
        }

        if ( ! tracker.hasValues(chip) ) {
            return 0;
        }

        Allele.create(ref.getBase(),true);

        VariantContext chipContext = tracker.getFirstValue(chip);
        if ( BaseUtils.basesAreEqual(chipContext.getReference().getBases()[0], ref.getBase()) ) {
            if ( GATKVariantContextUtils.isTransversion(chipContext) ) {
                out.add(chipContext);
            } else {
                VariantContext revC = possiblyReverseComplement(chipContext, ref, tracker);
                if ( revC == null ) {
                    VariantContextBuilder b = new VariantContextBuilder(chipContext);
                    Set<String> filts = new HashSet<String>(chipContext.getFilters());
                    filts.add("NoComparisonForStrandCheck");
                    b.filters(filts);
                    out.add(b.make());
                    return 0;
                }
                out.add(revC);
            }
        } else {
            VariantContext chipFlip = flipRefAndAlt(chipContext,ref);
            if ( GATKVariantContextUtils.isTransversion(chipFlip) ) {
                out.add(chipFlip);
            } else {
                VariantContext revC = possiblyReverseComplement(chipFlip, ref, tracker);
                if ( revC == null ) {
                    VariantContextBuilder b = new VariantContextBuilder(chipFlip);
                    Set<String> filts = new HashSet<String>(chipFlip.getFilters());
                    filts.add("NoComparisonForStrandCheck");
                    b.filters(filts);
                    out.add(b.make());
                    return 0;
                }
                out.add(revC);
            }
        }

        return 1;
    }

    private VariantContext flipRefAndAlt(VariantContext vc, ReferenceContext ref) {
        VariantContextBuilder vcb = new VariantContextBuilder(vc);
        List<Allele> newAlleles = new ArrayList<Allele>(2);
        Allele newRef = Allele.create(ref.getBase(),true);
        Allele newAlt = Allele.create(vc.getReference().getBases()[0],false);
        newAlleles.add(newRef);
        newAlleles.add(newAlt);
        List<Allele> HOM_REF = Arrays.asList(newRef,newRef);
        List<Allele> HOM_VAR = Arrays.asList(newAlt,newAlt);
        List<Allele> HET = Arrays.asList(newRef,newAlt);
        vcb.alleles(newAlleles);
        ArrayList<Genotype> newGenotypes = new ArrayList<Genotype>(vc.getNSamples());
        for ( Genotype g : vc.getGenotypes() ) {
            final GenotypeBuilder gb = new GenotypeBuilder(g);

            if ( g.isHomRef() ) {
                gb.alleles(HOM_VAR);
            } else if ( g.isHomVar() ) {
                gb.alleles(HOM_REF);
            } else if ( g.isHet() ) {
                gb.alleles(HET);
            } else {
                ;
            }

            newGenotypes.add(gb.make());
        }

        vcb.genotypes(newGenotypes);

        return vcb.make();
    }

    private VariantContext possiblyReverseComplement(VariantContext vc, ReferenceContext ref, RefMetaDataTracker tracker) {
        if ( ! tracker.hasValues(seq) ) {
            return null;
        }
        VariantContext seqContext = tracker.getFirstValue(seq);
        double initConc = getHomConcordance(vc,seqContext);
        if ( initConc > 0.95 ) {
            return vc;
        }
        VariantContext revComp = reverseComplement(vc);
        double revConc = getHomConcordance(revComp,seqContext);
        if ( revConc > 0.95 ) {
            return revComp;
        }

        VariantContextBuilder b = new VariantContextBuilder(vc);
        Set<String> filt = new HashSet<String>(vc.getFilters());
        filt.add("PotentialStrandIssue(Bias)");
        b.filters(filt);
        return b.make();
    }

    private VariantContext reverseComplement(VariantContext vc) {
        // swap hom ref and hom var
        List<Allele> HOM_REF = Arrays.asList(vc.getReference(),vc.getReference());
        List<Allele> HOM_VAR = Arrays.asList(vc.getAlternateAllele(0),vc.getAlternateAllele(0));
        ArrayList<Genotype> newGenotypes = new ArrayList<Genotype>();
        for ( Genotype g : vc.getGenotypes() ) {
            final GenotypeBuilder gb = new GenotypeBuilder(g);

            if ( g.isHomRef() ) {
                gb.alleles(HOM_VAR);
            } else if ( g.isHomVar() ) {
                gb.alleles(HOM_REF);
            } else {
                ;
            }

            newGenotypes.add(gb.make());
        }
        VariantContextBuilder vcb = new VariantContextBuilder(vc);
        vcb.genotypes(newGenotypes);
        return vcb.make();
    }

    private double getHomConcordance(VariantContext v1, VariantContext v2) {
        int same = 0;
        int tot = 0;
        for ( String s : samples ) {
            Genotype g1 = v1.getGenotype(s);
            Genotype g2 = v2.getGenotype(s);
            if ( g1 != null && g2 != null && g1.isHom() && g2.isHom() ) {
                ++tot;
                same = same + (g1.getAllele(0).equals(g2.getAllele(0)) ? 1 : 0);
            }
        }
        return ( (double) same )/tot;
    }
}
