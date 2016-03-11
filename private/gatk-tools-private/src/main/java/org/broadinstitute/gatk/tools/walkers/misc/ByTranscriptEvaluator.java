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
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system ("PHONE-HOME") which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
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

package org.broadinstitute.gatk.tools.walkers.misc;

import org.apache.commons.lang.ArrayUtils;
import org.broadinstitute.gatk.utils.commandline.*;
import org.broadinstitute.gatk.utils.contexts.AlignmentContext;
import org.broadinstitute.gatk.utils.contexts.ReferenceContext;
import org.broadinstitute.gatk.utils.refdata.RefMetaDataTracker;
import org.broadinstitute.gatk.utils.report.GATKReport;
import org.broadinstitute.gatk.engine.walkers.RodWalker;
import org.broadinstitute.gatk.engine.walkers.TreeReducible;
import org.broadinstitute.gatk.utils.Utils;
import org.broadinstitute.gatk.engine.GATKVCFUtils;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.variant.vcf.VCFInfoHeaderLine;
import org.broadinstitute.gatk.utils.exceptions.GATKException;
import org.broadinstitute.gatk.utils.exceptions.UserException;
import org.broadinstitute.gatk.utils.text.XReadLines;
import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.variantcontext.VariantContextBuilder;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: chartl
 * Date: 6/1/12
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ByTranscriptEvaluator extends RodWalker<VariantContext,ByTranscriptEvaluator.EvalContext>  implements TreeReducible<ByTranscriptEvaluator.EvalContext> {
    // todo -- some way to specify how to properly parse String annotations from the header that aren't really strings (but instead float/integer)
    @Input(doc="eval file",shortName="eval",fullName="eval",required=true)
    RodBinding<VariantContext> eval;

    @Input(doc="bootstrap file",shortName="boot",fullName = "boot",required=false)
    RodBinding<VariantContext> bootBinding = null;

    @Argument(doc="bootSample",shortName="bs",fullName="bootSample",required=false)
    String bootSam = null;

    @Argument(doc="Additional keys added to the info field by the annotation engine. Must have a corresponding info header line.",required=false,fullName="keys",shortName="k")
    List<String> additionalKeys = new ArrayList<String>();

    @Argument(doc="Ignore transcripts which are flagged as non-coding for a SNP",required=false,shortName="inc",fullName="ignoreNonCoding")
    boolean ignoreNonCoding = false;

    @Argument(doc="Only use CCDS transcripts",required=false,shortName="ccds",fullName="ccdsOnly")
    boolean ccdsOnly = false;

    @Argument(doc="Only use Refseq transcripts",required=false,shortName="refseq",fullName="refseqOnly")
    boolean refseqOnly = false;

    @Argument(doc="Only use ENSEMBL transcripts",required=false,shortName="ensembl",fullName="ensemblOnly")
    boolean ensemblOnly = false;

    @Argument(doc="Minimum allele frequency",required=false,shortName="minAAF",fullName="minAAF")
    double minAAF = 0.0;

    @Argument(doc="Maximum allele frequency",required=false,shortName="maxAAF",fullName="maxAAF")
    double maxAAF = 1.0;

    @Argument(doc="Ignore these transcripts (e.g. for being spurious/noncoding)",required=false,shortName="xt",fullName="excludeTranscripts")
    File ignoreTranscriptFile = null;

    @Hidden
    @Argument(doc="Allele frequency key",required=false,fullName="afKey")
    List<String> afkey = Arrays.asList(new String[]{"AF"});

    @Output
    PrintStream out;

    TranscriptInfoParser transcriptInfoParser;

    private static final String TRANSCRIPT_INFO_KEY = "TranscriptInfo";
    private static final String TRANSCRIPT_NAME_KEY = "Feature";
    private static final String GENE_NAME_KEY = "Gene";
    private static final String CONSEQ_NAME_KEY = "Consequence";
    private static final String SIFT_KEY = "SIFT";
    private static final String POLYPHEN_KEY = "PolyPhen";
    private static final String CCDS_KEY = "CCDS";

    private final List<String> REQUESTED_FIELDS = Arrays.asList(new String[]{TRANSCRIPT_NAME_KEY,GENE_NAME_KEY,CONSEQ_NAME_KEY,SIFT_KEY,POLYPHEN_KEY,CCDS_KEY});

    private long nSeen = 0l;
    private long nProcessed = 0l;
    public void initialize() {
        assertCodeIsWorking();
        assertInputsAreGood();
        transcriptInfoParser = initializeTranscriptParser();
    }

    public VariantContext map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext alignment) {
        if ( tracker != null && tracker.hasValues(eval) ) {
            VariantContext myEval = tracker.getFirstValue(eval);
            // todo -- update the filtering clause here to take command line values
            if ( ! bootBinding.isBound() ) {
                if ( ! myEval.isFiltered() && myEval.isSNP() ) {
                    nSeen++;
                    return transcriptInfoParser.addTranscriptInformationToVC(myEval);
                }
            } else {
                if ( getBootstrapAC(tracker,bootBinding,bootSam) > 0 ) {
                    nSeen++;
                    return transcriptInfoParser.addTranscriptInformationToVC(myEval);
                } else {
                    return null;
                }
            }
        }

        return null;
    }

    public EvalContext reduce(VariantContext map, EvalContext prevReduce) {
        if ( map == null ) {
            return prevReduce;
        }
        Map<String,Set<VariantTranscriptContext>> contextsByGene = (Map<String,Set<VariantTranscriptContext>>) map.getAttribute(TRANSCRIPT_INFO_KEY);
        if ( contextsByGene.size() > 0 ) {
            prevReduce.addContext(contextsByGene);
            nProcessed++;
        }

        return prevReduce;
    }

    public EvalContext treeReduce(EvalContext left, EvalContext right) {
        left.merge(right);

        return left;
    }

    public EvalContext reduceInit() {
        return new EvalContext();
    }

    public void onTraversalDone(EvalContext context) {
        List<String> colNames = new ArrayList<String>(25);
        colNames.addAll(Arrays.asList(new String[]{"Gene","Transcript","nVariants","nCoding"}));
        // todo -- logic to dynamically determine what requested statistics to output
        colNames.addAll(Arrays.asList(new String[]{"SYN","NONSYN","STOP","SPLICE","PolyphenDamaging","SiftDeleterious"}));
        GATKReport transcriptReport = GATKReport.newSimpleReport("TranscriptReport",colNames);
        for ( GeneInfo geneInfo : context.getGenes() ) {

            for ( TranscriptInfo transcriptInfo : geneInfo.getTranscripts() ) {
                // todo -- logic to hook up user-requested statistics to access pattern
                ArrayList<Object> transValues = getTranscriptOutputValues(geneInfo,transcriptInfo,colNames);
                transcriptReport.addRowList(transValues);
            }

            if ( geneInfo.hasMultipleTranscripts() ) {
                ArrayList<Object> mostDamagingValues = getTranscriptOutputValues(geneInfo,geneInfo.mostDeleteriousAnnotationTranscript,colNames);
                ArrayList<Object> leastDamagingValues = getTranscriptOutputValues(geneInfo,geneInfo.leastDeleteriousAnnotationTranscript,colNames);
                transcriptReport.addRowList(mostDamagingValues);
                transcriptReport.addRowList(leastDamagingValues);
            }
        }
        transcriptReport.print(out);
        out.printf("%n");
        GATKReport variantReport = GATKReport.newSimpleReport("VariantReport",Arrays.asList(new String[]{"NumberOfTranscripts","NumCodingVariants"}));
        Map<Integer,Integer> variantCountsByNTranscript = countVariantsByNTranscript(context);
        for (Map.Entry<Integer,Integer> countByNTranscript : variantCountsByNTranscript.entrySet() ) {
            variantReport.addRow(countByNTranscript.getKey(),countByNTranscript.getValue());
        }
        variantReport.print(out);

        logger.info(String.format("Traversal Result: Num_Seen=%d and Num_Processed=%d",nSeen,nProcessed));
    }

    private void assertInputsAreGood() {
        if ( refseqOnly && ccdsOnly || refseqOnly && ensemblOnly || ensemblOnly && ccdsOnly) {
            throw new UserException("Cannot exclusively use multiple of specific transcripts (ensembl,refseq,ccds). Choose exactly one and not multiple.");
        }

        if ( bootSam == null && bootBinding.isBound() ) {
            throw new UserException("Please provide a specific bootstrap sample");
        }
    }

    public int getBootstrapAC(RefMetaDataTracker tracker, RodBinding<VariantContext> binding, String sample) {
        if ( ! tracker.hasValues(bootBinding) ) {
            return -1;
        }
        VariantContext bootstrap = tracker.getFirstValue(binding);
        Genotype bootGeno = bootstrap.getGenotype(sample);
        Object bac = bootGeno.getAnyAttribute("BAC");
        return parseBAC(bac);
    }

    private int parseBAC(Object bac) {
        String[] sp = bac.toString().split(",");
        int b = 0;
        for ( String s : sp ) {
            int t = Integer.parseInt(s);
            if ( t > b ) {
                b = t;
            }
        }

        return b;
    }

    private Map<Integer,Integer> countVariantsByNTranscript(EvalContext evalContext) {
        Map<Integer,Integer> countsByNTranscript = new HashMap<Integer,Integer>(16);
        for ( String genesOverlappingVariantStr : evalContext.variantGeneList ) {
            logger.debug(genesOverlappingVariantStr);
            String[] genesOverlappingVariant = genesOverlappingVariantStr.split(",");
            int maxNTranscript = 0;
            for ( String gene : genesOverlappingVariant ) {
                int nTranscript = evalContext.geneInfoMap.get(gene).getTranscripts().size();
                if ( nTranscript > maxNTranscript )
                    maxNTranscript = nTranscript;
            }

            // cutoff at 10+ transcripts
            if ( maxNTranscript > 10 )
                maxNTranscript = 10;

            if (!  countsByNTranscript.containsKey(maxNTranscript) ) {
                countsByNTranscript.put(maxNTranscript,0);
            }

            int counts = countsByNTranscript.get(maxNTranscript);
            countsByNTranscript.put(maxNTranscript,1+counts);
        }

        return countsByNTranscript;
    }

    private TranscriptInfoParser initializeTranscriptParser() {
        VCFHeader header = GATKVCFUtils.getVCFHeadersFromRods(getToolkit(), Arrays.asList(eval)).get(eval.getName());
        VCFInfoHeaderLine csqFormat = header.getInfoHeaderLine("CSQ");
        Map<String,VCFInfoHeaderLine> additionalFormats = new HashMap<String,VCFInfoHeaderLine>(additionalKeys.size());
        for ( String k : additionalKeys ) {
            additionalFormats.put(k,header.getInfoHeaderLine(k));
        }

        Set<String> ignoreTranscripts = readTranscriptsToIgnore(ignoreTranscriptFile);

        return new TranscriptInfoParser(csqFormat,additionalFormats,REQUESTED_FIELDS,ignoreTranscripts);
    }

    private Set<String> readTranscriptsToIgnore(File ignoreFile) {
        if ( ignoreFile == null )
            return new HashSet<String>(0);

        Set<String> badTranscripts = new HashSet<String>(100000);

        try {
            for ( String transcript : new XReadLines(ignoreFile) ) {
                badTranscripts.add(transcript);
            }
        } catch (IOException ioException ) {
            throw new UserException("Error opening file for reading: "+ignoreFile.getAbsolutePath());
        }

        return badTranscripts;
    }

    private ArrayList<Object> getTranscriptOutputValues(GeneInfo geneInfo, TranscriptInfo transcriptInfo, List<String> columnNames) {
        ArrayList<Object> values = new ArrayList<Object>(columnNames.size());
        values.add(geneInfo.geneName);
        values.add(transcriptInfo.transcriptName);
        values.add(transcriptInfo.numVariants);
        values.add(getNumCodingVariants(transcriptInfo));
        values.add(transcriptInfo.getCounts(ConsequenceType.SYNONYMOUS_CODING));
        values.add(transcriptInfo.getCounts(ConsequenceType.NONSYNONYMOUS_CODING));
        values.add(transcriptInfo.getCounts(ConsequenceType.STOP_GAIN)+transcriptInfo.getCounts(ConsequenceType.STOP_LOSS));
        values.add(transcriptInfo.getCounts(ConsequenceType.SPLICE_SITE)+transcriptInfo.getCounts(ConsequenceType.ESSENTIAL_SPLICE));
        values.add(transcriptInfo.getPolyphenAbove(0.75));
        values.add(transcriptInfo.getSiftBelow(0.10));
        return values;
    }

    private int getNumCodingVariants(TranscriptInfo transcriptInfo) {
        int nCoding = 0;
        for ( Map.Entry<ConsequenceType,Integer> consequenceCounts : transcriptInfo.consequenceCounts.entrySet() ) {
            if ( ConsequenceType.isCoding(consequenceCounts.getKey()) ) {
                nCoding += consequenceCounts.getValue();
            }
        }
        return nCoding;
    }

    private void assertCodeIsWorking() {
        if ( ConsequenceType.isCoding(ConsequenceType.GENE_NOT_CODING) )
            throw new GATKException("The ConsequenceType Enum is busted. GENE_NOT_CODING should not be coding.");

        if ( ! ConsequenceType.isCoding(ConsequenceType.SYNONYMOUS_CODING) )
            throw new GATKException("The ConsequenceType Enum is busted! Syn_Coding should be coding.");
    }

/*    // note: from previous incarnation that did not use bootstraps
    @Deprecated
    private boolean matchesFrequency(VariantContext vc) {
        String afk = null;
        for ( String k : afkey ) {
            if ( vc.hasAttribute(k) ) {
                afk = k;
                break;
            }
        }
        if ( afk == null  )
            return false;

        if ( ! vc.isBiallelic() ) {
            Object afObject = vc.getAttribute(afk);
            double  af = 0.0;
            if ( afObject instanceof  String) {
                String[] afstring = ((String) afObject).split(",");
                for ( String s : afstring ) {
                    af += Double.parseDouble(s);
                }
            } else {
                List<Object> afList = (List<Object>) afObject;
                for ( Object o : afList ) {
                    if (o instanceof  String ) {
                        af += Double.parseDouble((String) o );
                    } else {
                        af += (Double) o;
                    }
                }

            }

            return (af > minAAF && af < maxAAF);
        }
        double af = Double.parseDouble(vc.getAttribute(afk).toString());
        return (af > minAAF && af < maxAAF);
    }*/

    class TranscriptInfoParser {

        Map<String,Integer> fieldOffset;
        final Set<String> ignoreTranscripts;

        public TranscriptInfoParser(VCFInfoHeaderLine csqFormat, Map<String,VCFInfoHeaderLine> extraFields, List<String> requestedFields, Set<String> ignoreTrans) {
            String fieldStr = csqFormat.getDescription().replaceFirst("Consequence type as predicted by VEP. Format: ","");
            // fieldStr should be of the format KEY1|KEY2|KEY3|KEY4|...
            String[] fields = fieldStr.split("\\|");
            fieldOffset = new HashMap<String,Integer>(requestedFields.size());
            for ( String rf : requestedFields ) {
                fieldOffset.put(rf,ArrayUtils.indexOf(fields,rf));
            }

            ignoreTranscripts = ignoreTrans;
        }

        private String getGeneName(String[] transcriptFields) {
            return transcriptFields[fieldOffset.get(GENE_NAME_KEY)];
        }

        private String getTranscriptName(String[] transcriptFields) {
            return transcriptFields[fieldOffset.get(TRANSCRIPT_NAME_KEY)];
        }

        private String getCCDS_ID(String[] transcriptFields) {
            if ( fieldOffset.get(CCDS_KEY) >= transcriptFields.length ) {
                return null;
            }

            String ccdsID = transcriptFields[fieldOffset.get(CCDS_KEY)];

            if ( ccdsID.equals("") )
                return null;

            return ccdsID;
        }

        private Set<ConsequenceType> decodeConsequences(String[] transcriptFields) {
            return ConsequenceType.decode(transcriptFields[fieldOffset.get(CONSEQ_NAME_KEY)]);
        }

        private boolean isRefseqTranscript(VariantTranscriptContext context) {
            return context.getTranscriptName().startsWith("NM_");
        }

        private boolean isEnsemblTranscript(VariantTranscriptContext context) {
            return context.getTranscriptName().startsWith("ENS");
        }

        private boolean isCCDSTranscript(VariantTranscriptContext context) {
            return context.getCCDS_ID() != null;
        }

        private VariantTranscriptContext setTranscriptIDs(String[] transcriptFields,VariantTranscriptContext context) {
            context.setGeneName(getGeneName(transcriptFields));
            context.setTranscriptName(getTranscriptName(transcriptFields));
            context.setCCDS_ID(getCCDS_ID(transcriptFields));
            return context;
        }

        private VariantTranscriptContext setSIFTscore(String[] transFields, VariantTranscriptContext context) {
            if ( transFields.length > fieldOffset.get(SIFT_KEY) ) {
                String siftStr = transFields[fieldOffset.get(SIFT_KEY)];
                if ( ! siftStr.equals("") ) {
                    double sift = parseSiftOrPolyphen(siftStr);
                    context.setSiftScore(sift);
                }
            }

            return context;
        }

        private VariantTranscriptContext setPolyphenScore(String[] transFields, VariantTranscriptContext context) {
            if ( transFields.length > fieldOffset.get(POLYPHEN_KEY) ) {
                String polyStr = transFields[fieldOffset.get(POLYPHEN_KEY)];
                if ( ! polyStr.equals("") ) {
                    double polyphen = parseSiftOrPolyphen(polyStr);
                    context.setPolyphenScore(polyphen);
                }
            }

            return context;
        }

        private boolean isInSpecifiedDB(VariantTranscriptContext context) {
            return  ! ( context.geneName == null || context.geneName.equals("") ||
                    ( refseqOnly && ! isRefseqTranscript(context) ) ||
                    ( ensemblOnly && ! isEnsemblTranscript(context) ) ||
                    ( ccdsOnly && ! isCCDSTranscript(context) ) );
        }

        private VariantTranscriptContext setConsequences(String[] transcriptFields, VariantTranscriptContext context) {
            Set<ConsequenceType> consequences = decodeConsequences(transcriptFields);
            context.setConsequences(consequences);
            return context;
        }

        private VariantTranscriptContext setConservationScores(String[] transcriptFields, VariantTranscriptContext context) {
            VariantTranscriptContext vtc = setSIFTscore(transcriptFields,context);
            vtc = setPolyphenScore(transcriptFields,vtc);
            return vtc;
        }

        private boolean transcriptOrGeneNotCoding(VariantTranscriptContext context) {
            return context.getConsequences().contains(ConsequenceType.GENE_NOT_CODING);
        }

        private boolean ignoreTranscript(VariantTranscriptContext context) {
            return ignoreTranscripts.contains(context.getTranscriptName());
        }

        public Map<String,Set<VariantTranscriptContext>> parse(String CSQvalue) {
            String[] transInfoByTranscript = CSQvalue.split(",");
            Map<String,Set<VariantTranscriptContext>> contextsByTranscriptName = new HashMap<String,Set<VariantTranscriptContext>>(transInfoByTranscript.length);
            for ( String tval : transInfoByTranscript ) {
                String[] fields = tval.split("\\|");
                VariantTranscriptContext vtc = new VariantTranscriptContext();
                vtc = setTranscriptIDs(fields,vtc);

                if ( ! isInSpecifiedDB(vtc) )
                    continue;

                if ( ignoreTranscript(vtc) )
                    continue;

                vtc = setConsequences(fields,vtc);

                if ( transcriptOrGeneNotCoding(vtc) && ignoreNonCoding )
                    continue;

                vtc = setConservationScores(fields,vtc);

                if ( ! contextsByTranscriptName.containsKey(vtc.getGeneName()) ) {
                    contextsByTranscriptName.put(vtc.getGeneName(),new HashSet<VariantTranscriptContext>(12));
                }
                contextsByTranscriptName.get(vtc.getGeneName()).add(vtc);
            }

            return contextsByTranscriptName;
        }

        public VariantContext addTranscriptInformationToVC(VariantContext context) {
            VariantContextBuilder builder = new VariantContextBuilder(context);
            builder.attribute(TRANSCRIPT_INFO_KEY,this.parse(context.getAttribute("CSQ").toString()));
            return builder.make();
        }

        private double parseSiftOrPolyphen(String sift) {
            // string of form EFFECT(number)
            return Double.parseDouble(sift.split("\\(")[1].replace(")",""));
        }
    }

    class VariantTranscriptContext {

        private String transcriptName;
        private String geneName;
        private Set<ConsequenceType> consequences;
        private Double siftScore;
        private Double polyphenScore;
        private String CCDSid;

        public String getTranscriptName() {
            return transcriptName;
        }

        public String getGeneName() {
            return geneName;
        }

        public void setTranscriptName(String name) {
            transcriptName = name;
        }

        public void setGeneName(String name) {
            geneName = name;
        }

        public void setCCDS_ID(String id) {
            CCDSid = id;
        }

        public void setConsequences(Set<ConsequenceType> types) {
            consequences = types;
        }

        public Set<ConsequenceType> getConsequences() {
            return consequences;
        }

        public void setSiftScore(double sift) {
            siftScore = sift;
        }

        public void setPolyphenScore(double polyphen) {
            polyphenScore = polyphen;
        }

        public boolean hasSiftScore() {
            return siftScore != null;
        }

        public boolean hasPolyphenScore() {
            return polyphenScore != null;
        }

        public double getSiftScore() {
            return siftScore;
        }

        public double getPolyphenScore() {
            return polyphenScore;
        }

        public String getCCDS_ID() {
            return CCDSid;
        }
    }

    class GeneInfo {
        private String geneName;
        private Map<String,TranscriptInfo> transcripts;
        private TranscriptInfo mostDeleteriousAnnotationTranscript;
        private TranscriptInfo leastDeleteriousAnnotationTranscript;
        private long numVariants;

        public GeneInfo(String name) {
            geneName = name;
            numVariants = 0l;
            transcripts = new HashMap<String,TranscriptInfo>(16);
            mostDeleteriousAnnotationTranscript = new TranscriptInfo(geneName+"_mostDeleterious");
            leastDeleteriousAnnotationTranscript = new TranscriptInfo(geneName+"_leastDeleterious");
        }

        public void addContexts(Set<VariantTranscriptContext> contexts) {
            ConsequenceType mostDeleterious = null;
            ConsequenceType leastDeleterious = null;
            double polyPhen = Double.MIN_VALUE;
            double sift = Double.MAX_VALUE;

            for ( VariantTranscriptContext context : contexts ) {
                if ( ! transcripts.containsKey(context.getTranscriptName()) ) {
                    addTranscript(context.getTranscriptName());
                }

                transcripts.get(context.getTranscriptName()).addContext(context);

                for ( ConsequenceType type : context.getConsequences() ) {

                    if ( ConsequenceType.inCodingRegion(type) && ( mostDeleterious == null || type.compareTo(mostDeleterious) < 0 )) {
                        mostDeleterious = type;
                    }

                    if ( ConsequenceType.inCodingRegion(type) && (leastDeleterious == null || type.compareTo(leastDeleterious) > 0)) {
                        leastDeleterious = type;
                    }
                }

                if ( context.hasPolyphenScore() && context.getPolyphenScore() > polyPhen ) {
                    polyPhen = context.getPolyphenScore();
                }

                if ( context.hasSiftScore() && context.getSiftScore() < sift ) {
                    sift = context.getSiftScore();
                }
            }

            updateConsensusTranscripts(mostDeleterious,leastDeleterious,polyPhen,sift);

            numVariants++;
        }

        private void updateConsensusTranscripts(ConsequenceType mostDeleterious, ConsequenceType leastDeleterious, Double polyPhen, Double sift) {
            if ( mostDeleterious != null && ConsequenceType.inCodingRegion(mostDeleterious) )
                updateConsensus(mostDeleteriousAnnotationTranscript, mostDeleterious, polyPhen,sift);
            if ( leastDeleterious != null && ConsequenceType.inCodingRegion(leastDeleterious) )
                updateConsensus(leastDeleteriousAnnotationTranscript,leastDeleterious,polyPhen,sift);
        }

        private void updateConsensus(TranscriptInfo consensus,ConsequenceType consequence, Double polyPhen, Double sift) {
            consensus.numVariants++;
            consensus.addConsequence(consequence);
            if ( polyPhen > -1.0 && sift > -1.0 ) {
                consensus.polyphenScores.add(polyPhen);
                consensus.siftScores.add(sift);
            }
        }

        private void addTranscript(String tName) {
            transcripts.put(tName,new TranscriptInfo(tName));
        }

        public void merge(GeneInfo other) {
            if ( ! other.geneName.equals(this.geneName) ) {
                throw new IllegalStateException("Gene info objects referencing different genes can not be merged");
            }

            for ( Map.Entry<String,TranscriptInfo> info : other.transcripts.entrySet() ) {
                if ( transcripts.containsKey(info.getKey()) ) {
                    transcripts.get(info.getKey()).merge(info.getValue());
                } else {
                    transcripts.put(info.getKey(),info.getValue());
                }
            }

            mostDeleteriousAnnotationTranscript.merge(other.mostDeleteriousAnnotationTranscript);
            leastDeleteriousAnnotationTranscript.merge(other.leastDeleteriousAnnotationTranscript);
            numVariants += other.numVariants;
        }

        public Collection<TranscriptInfo> getTranscripts() {
            return transcripts.values();
        }

        public boolean hasMultipleTranscripts() {
            return getTranscripts().size() > 1;
        }
    }

    class TranscriptInfo {

        private String transcriptName;
        private long numVariants;
        private Map<ConsequenceType,Integer> consequenceCounts;
        private List<Double> polyphenScores;
        private List<Double> siftScores;

        public TranscriptInfo(String name) {
            transcriptName = name;
            numVariants = 0;
            consequenceCounts = new HashMap<ConsequenceType,Integer>(ConsequenceType.values().length);
            polyphenScores = new ArrayList<Double>(16);
            siftScores = new ArrayList<Double>(16);
        }

        public void merge(TranscriptInfo other) {
            this.numVariants += other.numVariants;
            this.polyphenScores.addAll(other.polyphenScores);
            this.siftScores.addAll(other.siftScores);

            for ( Map.Entry<ConsequenceType,Integer> otherEtry : other.consequenceCounts.entrySet() ) {
                if ( this.consequenceCounts.containsKey(otherEtry.getKey()) ) {
                    this.consequenceCounts.put(otherEtry.getKey(),this.consequenceCounts.get(otherEtry.getKey())+otherEtry.getValue());
                } else {
                    this.consequenceCounts.put(otherEtry.getKey(),otherEtry.getValue());
                }
            }

        }

        public void addContext(VariantTranscriptContext context) {
            numVariants++;
            for ( ConsequenceType type : context.getConsequences() ) {
                if ( ! type.describesTranscript )
                    addConsequence(type);
            }

            if ( context.hasPolyphenScore() ) {
                polyphenScores.add(context.getPolyphenScore());
            }

            if (context.hasSiftScore()) {
                siftScores.add(context.getSiftScore());
            }
        }

        private void addConsequence(ConsequenceType type) {
            if ( ! consequenceCounts.containsKey(type) ) {
                consequenceCounts.put(type,0);
            }
            consequenceCounts.put(type,consequenceCounts.get(type)+1);
        }

        public Integer getPolyphenAbove(double score) {
            int ct = 0;
            for ( double d : polyphenScores ) {
                ct += d >= score ? 1 : 0;
            }

            return ct;
        }

        public Integer getSiftBelow(double score) {
            int ct = 0;
            for ( double d : siftScores ) {
                ct += d <= score ? 1 : 0;
            }

            return ct;
        }

        public Integer getCounts(ConsequenceType type) {
            return consequenceCounts.containsKey(type) ? consequenceCounts.get(type) : 0;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(transcriptName);
            builder.append("\t");
            builder.append("numVar:");
            builder.append(numVariants);
            for ( ConsequenceType type : ConsequenceType.values() ) {
                if ( type.describesTranscript )
                    continue;
                builder.append("\t");
                builder.append(type.ensembleTerm);
                builder.append(":");
                Integer num = consequenceCounts.get(type);
                if ( num == null ) {
                    num = 0;
                }
                builder.append(num);
            }
            builder.append("\t");
            builder.append("polyphen: ");
            builder.append(Utils.join(",",polyphenScores));
            builder.append("\tsift: ");
            builder.append(Utils.join(",",siftScores));
            return builder.toString();
        }
    }

    class EvalContext {
        private Map<String,GeneInfo> geneInfoMap;
        private ArrayList<String> variantGeneList;

        public EvalContext() {
            geneInfoMap = new HashMap<String,GeneInfo>(4096);
            variantGeneList = new ArrayList<String>(4194304);
        }

        public boolean hasGene(String name) {
            return geneInfoMap.keySet().contains(name);
        }

        public void addContext(Map<String,Set<VariantTranscriptContext>> contextByGene) {
            Set<String> genesVariantIsCodingIn = new HashSet<String>(8);
            for ( Map.Entry<String,Set<VariantTranscriptContext>> geneVTC : contextByGene.entrySet() ) {
                if ( ! geneInfoMap.containsKey(geneVTC.getKey()) ) {
                    geneInfoMap.put(geneVTC.getKey(),new GeneInfo(geneVTC.getKey()));
                }
                geneInfoMap.get(geneVTC.getKey()).addContexts(geneVTC.getValue());
                if ( isCodingInSomeTranscript(geneVTC.getValue()) )
                    genesVariantIsCodingIn.add(geneVTC.getKey());
            }
            if ( genesVariantIsCodingIn.size() > 0 )
                variantGeneList.add(Utils.join(",",genesVariantIsCodingIn));
        }

        private boolean isCodingInSomeTranscript(Set<VariantTranscriptContext> vtContexts) {
            for ( VariantTranscriptContext vtContext : vtContexts ) {
                for ( ConsequenceType consequence : vtContext.getConsequences() ) {
                    if ( ConsequenceType.isCoding(consequence) )
                        return true;
                }
            }

            return false;
        }

        public void merge(EvalContext other) {
            for ( Map.Entry<String,GeneInfo> infoEntry : other.geneInfoMap.entrySet() ) {
                if ( geneInfoMap.containsKey(infoEntry.getKey()) ) {
                    geneInfoMap.get(infoEntry.getKey()).merge(infoEntry.getValue());
                } else {
                    geneInfoMap.put(infoEntry.getKey(),infoEntry.getValue());
                }
            }
            variantGeneList.addAll(other.variantGeneList);
        }

        public Collection<GeneInfo> getGenes() {
            return geneInfoMap.values();
        }
    }

    enum ConsequenceType {


        STOP_GAIN("Stop gained","STOP_GAINED"),
        STOP_LOSS("Stop lost","STOP_LOST"),
        FRAMESHIFT("Frameshift coding","FRAMESHIFT_CODING"),
        ESSENTIAL_SPLICE("Essential splice site - both donor and acceptor","ESSENTIAL_SPLICE_SITE"),
        SPLICE_SITE("1-3 bps into an exon or 3-8 bps into an intron","SPLICE_SITE"),
        NONSYNONYMOUS_CODING("Nonsynonymous coding. Includes codon change, codon loss, and codon gain.","NON_SYNONYMOUS_CODING"),
        SYNONYMOUS_CODING("Synonymous coding - includes both stop and other codons","SYNONYMOUS_CODING"),
        INTRON("Intronic","INTRONIC"),
        TF_BINDING("Transcription factor binding motif","TRANSCRIPTION_FACTOR_BINDING_MOTIF"),
        PRIME_5("5 prime UTR","5PRIME_UTR"),
        PRIME_3("3 prime UTR","3PRIME_UTR"),
        REGULATORY("Regulatory region","REGULATORY_REGION"),
        UPSTREAM("upstream - within 5KB","UPSTREAM"),
        DOWNSTREAM("downstream - within 5KB","DOWNSTREAM"),
        COMPLEX("Complex in/del","COMPLEX_INDEL"),
        PARTIAL_CODON("Partial codon","PARTIAL_CODON"),
        CODING_UNKNOWN("Coding unknown","CODING_UNKNOWN"),
        MIRNA("Within mature miRNA","WITHIN_MATURE_miRNA"),
        NMD("NMD transcript","NMD_TRANSCRIPT",true),
        GENE_NOT_CODING("Within non-coding gene","WITHIN_NON_CODING_GENE",true),
        INTERGENIC("Intergenic","INTERGENIC");


        static Map<String,ConsequenceType> parsingMap = new HashMap<String,ConsequenceType>(ConsequenceType.values().length);
        // i know this is dumb, and you should use this.valueOf, but you can't have an enum named "5PRIME_UTR" as it starts with a number.
        // so this is the only way. Annoying.

        private String description;
        private String ensembleTerm;
        private boolean describesTranscript;

        ConsequenceType(String desc, String term, boolean describesT) {
            description = desc;
            ensembleTerm = term;
            describesTranscript = describesT;
        }

        ConsequenceType(String desc, String term) {
            this(desc,term,false);
        }

        public static Set<ConsequenceType> decode(String fromVC) {
            if ( parsingMap.size() == 0 ) {
                for ( ConsequenceType type : ConsequenceType.values() ) {
                    parsingMap.put(type.ensembleTerm,type);
                }
            }
            String[] consequenceTypes = fromVC.split("\\&");
            Set<ConsequenceType> matching = new HashSet<ConsequenceType>(consequenceTypes.length);
            for ( String ct : consequenceTypes ) {
                matching.add(parsingMap.get(ct));
            }
            return matching;
        }

        public static boolean isCoding(ConsequenceType type) {
            return type.compareTo(INTRON) < 0;
        }

        public static boolean inCodingRegion(ConsequenceType type) {
            return type.compareTo(INTERGENIC) < 0;
        }

    }

}
