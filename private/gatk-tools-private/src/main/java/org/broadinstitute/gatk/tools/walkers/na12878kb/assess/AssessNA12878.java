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

package org.broadinstitute.gatk.tools.walkers.na12878kb.assess;

import htsjdk.samtools.SAMFileReader;
import htsjdk.variant.variantcontext.GenotypeType;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.variantcontext.writer.VariantContextWriter;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.utils.report.GATKReport;
import org.broadinstitute.gatk.tools.walkers.na12878kb.NA12878DBWalker;
import org.broadinstitute.gatk.tools.walkers.na12878kb.core.MongoVariantContext;
import org.broadinstitute.gatk.tools.walkers.na12878kb.core.NA12878DBArgumentCollection;
import org.broadinstitute.gatk.tools.walkers.na12878kb.core.SiteIterator;
import org.broadinstitute.gatk.utils.commandline.*;
import org.broadinstitute.gatk.utils.exceptions.UserException;
import org.broadinstitute.gatk.engine.GATKVCFUtils;
import org.broadinstitute.gatk.utils.variant.HomoSapiensConstants;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

/**
 * Assess the quality of an NA12878 callset against the NA12878 knowledge base
 *
 * <p>
 *     This walker takes a single VCF file contains calls of any type (SNPs, Indels)
 *     using at least the sample NA12878 (i.e., the VCF must contain the sample NA12878)
 *     and provides an itemized summary of the different types of true positives, false positives
 *     and false negatives in the input callset relative to the NA12878 knowledge base.
 * </p>Additionally, writes out a bad sites VCF that contains the following data by default: calls at known
 *     false positives, calls in NA12878 known to be monomorphic, sites that are TP but are
 *     either called but filtered out or not called at all, and finally calls in the input
 *     VCF not in the DB at all or in the DB with unknown status.  This VCF contains INFO field
 *     key/value pairs describing why the site was included (i.e., it is a false negative).
 * </p>
 *
 * See http://gatkforums.broadinstitute.org/discussion/1848/using-the-na12878-knowledge-base for more information.
 *
 * @author depristo
 * @since 11/2012
 * @version 0.1
 */
public class AssessNA12878 extends NA12878DBWalker {
    /**
     * Variants from these VCF files are used by this tool as input.
     * The files must at least contain the standard VCF header lines, but
     * can be empty (i.e., no variants are contained in the file).
     */
    @Input(fullName="variant", shortName = "V", doc="Input VCF file", required=true)
    public List<RodBinding<VariantContext>> variants;

    @Input(fullName="BAM", shortName = "BAM", doc="Input BAM file.  If provided, we will differentiate false negative sites into those truly missed and those without coverage", required=false)
    public File BAM = null;

    @Output(doc="Summary GATKReport will be written here", required=false)
    public PrintStream out;

    @Argument(fullName="excludeCallset", shortName = "excludeCallset", doc="Don't count calls that come from only these excluded callsets", required=false)
    public Set<String> excludeCallset = Collections.emptySet();

    @Argument(fullName="inputPloidy", shortName = "ploidy", doc="Indicates the ploidy used to make the input calls; this is useful when evaluating Omniploidy call-sets. When provided, it must be 1 or greater", required=false, minValue = 1.0)
    public int inputPloidy = HomoSapiensConstants.DEFAULT_PLOIDY;

    @Argument(fullName="genotypeTypesToInclude", shortName="gtType", doc="Genotype types to report on (HET, HOM_VAR, HOM_REF, NO_CALL or MIXED). By default all GT types are considered", required = false)
    final List<GenotypeType> genotypeTypesToInclude = new ArrayList<>();

    /**
     * An output VCF file containing the bad sites (FN/FP) that were found in the input callset w.r.t. the current NA12878 knowledge base
     */
    @Output(fullName = "badSites", shortName = "badSites", doc="VCF file containing information on FP/FNs in the input callset", required=false, defaultToStdout=false)
    public VariantContextWriter badSites = null;

    @Argument(fullName="writeAllSites", shortName = "allSites", doc="Emit all interesting (everything but not relevant) sites to the badSites output VCF, not just those that are considered bad", required=false)
    public boolean captureAllSites = false;

    @Argument(fullName="maxToWrite", shortName = "maxToWrite", doc="Max. number of bad sites to write out", required=false)
    public int maxToWrite = 100_000_000;

    @Argument(fullName="minDepthForLowCoverage", shortName = "minDepthForLowCoverage", doc="A false negative will be flagged as due to low coverage if the (optional) BAM is provided and the coverage overlapping the site is less than this value", required=false)
    public int minDepthForLowCoverage = 5;

    @Argument(fullName="detailedAssessment", shortName = "detailed", doc="If true, we will emit a very detailed report of the types of variants, otherwise we'll use a simplified version", required=false)
    public boolean detailedAssessment = false;

    /**
     * Note that this argument is mutually exclusive with the --ignoreSpecificFilter argument.
     */
    @Argument(fullName="ignoreAllFilters", shortName = "ignoreAllFilters", exclusiveOf = "ignoreSpecificFilter", doc="If true, we will completely ignore the filter status of calls", required=false)
    public boolean ignoreAllFilters = false;

    @Advanced
    @Argument(fullName="ignoreSpecificFilter", shortName="ignoreFilter", doc="If specified, the assessment will also use variants marked as filtered by the specified filter name in the input VCF file", required=false)
    private Set<String> filtersToIgnore = Collections.emptySet();

    @Argument(fullName="minPNonRef", shortName = "minPNonRef", doc="Min. PL against 0/0 for a site to be considered called in NA12878; set to -1 to allow all sites", required=false)
    public int minPNonRef = -1;

    @Argument(fullName="minGQ", shortName = "minGQ", doc="Min. Genotype Quality for a genotype to be considered confidently called in NA12878; set to -1 to allow all genotypes", required=false)
    public int minGQ = 20;

    @Argument(fullName="requireReviewed", shortName = "requireReviewed", doc="If true, we will only use reviewed sites for the analysis", required=false)
    public boolean onlyReviewed = false;

    @Argument(fullName="typesToInclude", shortName = "typesToInclude", doc="Should we analyze SNPs, INDELs, or both?", required=false)
    public TypesToInclude typesToInclude = TypesToInclude.BOTH;

    public enum TypesToInclude {
        SNPS,
        INDELS,
        BOTH
    }

    /**
     * Useful when some state isn't interesting as a bad site but is extremely prevalent in the input callset
     */
    @Argument(fullName="AssessmentsToExclude", shortName = "AssessmentsToExclude", doc="If provided, we will prevent any of these states from being written out to the badSites VCF.", required=false)
    public Set<AssessmentType> AssessmentsToExclude = EnumSet.noneOf(AssessmentType.class);

    /**
     * True positive sites in the knowledge base that are present in this optional VCF file will not be counted as
     * false negatives in the assessment if missed.
     * This is particularly useful when you have a list of sites that you have reviewed against your input BAM and
     * have noted that the alternate allele is not present (even though there is sufficient coverage).  Intended to
     * be used mainly with the automated Jenkins assessments.
     */
    @Input(fullName="okayToMiss", shortName = "okayToMiss", doc="VCF file with sites that should not get penalized as FNs", required=false)
    public RodBinding<VariantContext> okayToMiss;

    @Hidden
    @Argument(shortName = "debug", required=false)
    protected boolean debug = false;

    private SiteIterator<MongoVariantContext> consensusSiteIterator;

    private final Map<String,Assessor> assessors = new HashMap<>();
    private SAMFileReader bamReader = null;
    private SitesWriter sitesWriter;

    @Override
    public NA12878DBArgumentCollection.DBType getDefaultDB() {
        return NA12878DBArgumentCollection.DBType.PRODUCTION;
    }

    @Override
    public void initialize() {
        super.initialize();
        consensusSiteIterator = db.getConsensusSites(makeSiteManager(false));

        if ( BAM != null ) {
            bamReader = Assessor.makeSAMFileReaderForDoCInBAM(BAM);
        }

        if ( badSites == null )
            sitesWriter = SitesWriter.NOOP_WRITER;
        else if ( captureAllSites )
            sitesWriter = new AllSitesWriter(maxToWrite, AssessmentsToExclude, badSites);
        else
            sitesWriter = new BadSitesWriter(maxToWrite, AssessmentsToExclude, badSites);
        sitesWriter.initialize(GATKVCFUtils.getHeaderFields(getToolkit()));

        if ( ignoreAllFilters )
            filtersToIgnore.add(Assessor.WILDCARD_FILTER_NAME);

        if (inputPloidy < 1)
            throw new UserException.BadArgumentValue("ploidy","it must be greater than 0: " + inputPloidy);

        // set up assessors for each rod binding
        for ( final RodBinding<VariantContext> rod : variants ) {
            final String rodName = rod.getName();
            final Assessor assessor = new Assessor(rodName, typesToInclude, excludeCallset, sitesWriter, bamReader,
                    minDepthForLowCoverage, minPNonRef, minGQ, filtersToIgnore);
            assessor.setInputPloidy(inputPloidy);
            assessor.setGenotypeTypesToConsider(genotypeTypesToInclude);
            assessors.put(rodName, assessor);
        }
    }

    @Override
    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if ( tracker == null ) return 0;

        if ( debug ) logger.info("Processing " + context.getLocation());
        includeMissingCalls(consensusSiteIterator.getSitesBefore(context.getLocation()));
        final List<MongoVariantContext> consensusSites = consensusSiteIterator.getSitesAtLocation(context.getLocation());

        // TODO -- maybe it's worth implementing exact allele checking here?
        final boolean siteIsOkayToMiss = okayToMiss.isBound() && ! tracker.getValues(okayToMiss, ref.getLocus()).isEmpty();

        for ( final RodBinding<VariantContext> rod : variants ) {
            final List<VariantContext> vcs = tracker.getValues(rod, ref.getLocus());
            final Assessor assessor = getAssessor(rod.getName());
            assessor.assessSite(vcs, consensusSites, onlyReviewed, siteIsOkayToMiss);
        }

        return 1;
    }

    private void includeMissingCalls(final List<MongoVariantContext> missedSites) {
        final List<VariantContext> noCalls = Collections.emptyList();

        for ( final RodBinding<VariantContext> rod : variants ) {
            getAssessor(rod.getName()).assessSite(noCalls, missedSites, onlyReviewed);
        }
    }

    private Assessor getAssessor(final String rodName) {
        return assessors.get(rodName);
    }

    private Assessment getAssessment(final String rodName, final TypesToInclude type) {
        switch ( type ) {
            case SNPS: return getAssessor(rodName).getSNPAssessment();
            case INDELS: return getAssessor(rodName).getIndelAssessment();
            default: throw new IllegalArgumentException("Unexpected type " + type);
        }
    }

    /**
     * Replace all of the current detailed assessors with their simplified versions
     */
    private void simplifyAssessments() {
        for ( final Assessor assessor : assessors.values() ) {
            assessor.simplifyAssessments();
        }
    }

    /**
     * Get an assessment that's representative of the structure of all of the assessment
     *
     * Useful for getting things like the ActiveTypes for all assessments
     *
     * @return non-null assessment
     */
    private Assessment getRepresentativeAssessment() {
        return assessors.values().iterator().next().getSNPAssessment();
    }

    @Override
    public void onTraversalDone(Integer result) {
        includeMissingCalls(consensusSiteIterator.toList());
        super.onTraversalDone(result);

        if ( ! detailedAssessment ) simplifyAssessments();

        if ( variants.size() == 1 ) {
            final GATKReport report = GATKReport.newSimpleReportWithDescription("NA12878Assessment", "Evaluation of input variant callsets",
                    "Name", "VariantType", "AssessmentType", "Count");
            for( final RodBinding rod : variants ) {
                for ( final TypesToInclude variantType : Arrays.asList(TypesToInclude.SNPS, TypesToInclude.INDELS) ) {
                    final Assessment assessment = getAssessment(rod.getName(), variantType);
                    for ( final AssessmentType type : assessment.getActiveTypes() ) {
                        report.addRow(rod.getName(), variantType.toString(), type, assessment.get(type));
                    }
                    for ( final Assessment.GenotypeAssessment gt : assessment.getGenotypeAssessments() ) {
                        report.addRow(rod.getName(), variantType.toString(), gt.getName(), gt.getGenotypingAccuracy());
                    }
                }
            }
            report.print(out);
        } else {
            final List<String> columns = new ArrayList<>();
            columns.add("Name");
            columns.add("VariantType");
            for( final AssessmentType type : getRepresentativeAssessment().getActiveTypes() ) {
                columns.add(type.toString());
            }
            for ( final Assessment.GenotypeAssessment gt : getRepresentativeAssessment().getGenotypeAssessments() ) {
                columns.add(gt.getName());
            }

            final GATKReport report = GATKReport.newSimpleReport("NA12878Assessment", columns);

            for( final RodBinding rod : variants ) {
                for ( final TypesToInclude variantType : Arrays.asList(TypesToInclude.SNPS, TypesToInclude.INDELS) ) {
                    final List<Object> row = new ArrayList<>();
                    row.add(rod.getName());
                    row.add(variantType.toString());
                    row.addAll(getAssessment(rod.getName(), variantType).getCounts());
                    for ( final Assessment.GenotypeAssessment gt : getAssessment(rod.getName(), variantType).getGenotypeAssessments() ) {
                        row.add(gt.getGenotypingAccuracy());
                    }
                    report.addRowList(row);
                }
            }

            report.print(out);
        }
    }
}