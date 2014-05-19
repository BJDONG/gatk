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

package org.broadinstitute.gatk.tools.walkers.na12878kb.core;

import com.mongodb.*;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.broadinstitute.gatk.tools.walkers.na12878kb.core.errors.InvalidRecordsRemove;
import org.broadinstitute.gatk.utils.GenomeLocParser;
import htsjdk.variant.vcf.VCFConstants;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.variant.vcf.VCFHeaderLine;
import htsjdk.variant.vcf.VCFStandardHeaderLines;
import htsjdk.variant.variantcontext.writer.VariantContextWriter;

import java.util.*;

public class NA12878KnowledgeBase {
    private final static Logger logger = Logger.getLogger(NA12878KnowledgeBase.class);

    // standard confidences to use for various types of input callsets
    public enum InputCallsetConfidence {
        REVIEW (0.99),
        TRUSTED_CALLSET (0.95),
        UNTRUSTED_CALLSET (0.75),
        UNKNOWN (0.0);

        public double confidence;

        private InputCallsetConfidence(final double confidence) {
            this.confidence = confidence;
        }
    }

    protected DBCollection sites;
    protected DBCollection callSets;
    protected DBCollection consensusSites;
    protected GenomeLocParser parser;

    private final MongoDBManager.Locator dblocator;

    public NA12878KnowledgeBase(final GenomeLocParser parser, final NA12878DBArgumentCollection args) {
        this.parser = parser;
        this.dblocator = args.getLocator();

        MongoDBManager.DBWrapper dbWrapper = MongoDBManager.getDB(this.dblocator);

        sites = dbWrapper.getSites();
        sites.setObjectClass(MongoVariantContext.class);
        sites.ensureIndex(sitesOrder());
        sites.ensureIndex(essentialIndex());

        callSets = dbWrapper.getCallsets();
        callSets.setObjectClass(CallSet.class);

        consensusSites = dbWrapper.getConsensus();
        consensusSites.setObjectClass(MongoVariantContext.class);
        consensusSites.ensureIndex(sitesOrder());
        consensusSites.ensureIndex(essentialIndex());

        dbWrapper.getMongo().setWriteConcern(WriteConcern.SAFE);

        if ( args.resetDB ) reset();
    }

    /**
     * Close down the connections for this KnowledgeBase
     */
    public void close() {
        MongoDBManager.getDB(dblocator).close();
    }

    public void delete() {
        MongoDBManager.getDB(dblocator).delete();
    }

    protected void printStatus() {
        printCollectionStatus("sites", sites);
        printCollectionStatus("callsets", callSets);
        printCollectionStatus("consensus", consensusSites);
    }

    private void printCollectionStatus(final String name, final DBCollection collection) {
        logger.info("Number of " + name + ":" + collection.getCount());

        for ( final DBObject object : collection.find() ) {
            logger.info("        " + object);
        }
    }

    public void reset() {
        logger.warn("Resetting all documents in " + this);
        sites.drop();
        callSets.drop();
        clearConsensus();
    }

    public void clearConsensus() {
        consensusSites.drop();
    }

    // ---------------------------------------------------------------------
    // working with CallSets
    // ---------------------------------------------------------------------

    public WriteResult addCallset(final CallSet callSet) {
        return callSets.insert(callSet);
    }

    public List<CallSet> getCallSets() {
        final List<CallSet> callsets = new LinkedList<>();

        for ( final DBObject obj : callSets.find() ) {
            callsets.add((CallSet)obj);
        }

        return callsets;
    }

    public CallSet getCallSet(final String name) {
        final BasicDBObject query = new BasicDBObject("Name", name);
        return (CallSet)callSets.findOne(query);
    }

    // ---------------------------------------------------------------------
    // Working with sites
    // ---------------------------------------------------------------------

    public WriteResult addCall(final MongoVariantContext mvc) {
        return sites.insert(mvc);
    }

    public List<WriteResult> removeCall(final MongoVariantContext mvc){
        final Set<String> matchKeys = new HashSet<>(mvc.keySet());
        matchKeys.remove("Date");
        matchKeys.remove("_id");
        final DBObject matchObject = new BasicDBObject();
        for(final String key: matchKeys){
            matchObject.put(key, mvc.get(key));
        }
        final DBCursor cursor = sites.find(matchObject);
        final List<WriteResult> results = new ArrayList<>(cursor.size());
        for(final DBObject next: cursor){
            results.add(sites.remove(next));
        }
        return results;
    }

    public void addCalls(final Collection<MongoVariantContext> mvcs) {
        for ( final MongoVariantContext mvc : mvcs )
            addCall(mvc);
    }

    private DBObject essentialIndex() {
        final DBObject sortOrder = new BasicDBObject();
        sortOrder.put("Chr", 1);
        sortOrder.put("Start", 1);
        return sortOrder;
    }

    protected DBCollection getSitesCollection() {
        return sites;
    }

    public DBObject sitesOrder() {
        final DBObject sortOrder = new BasicDBObject();
        sortOrder.put("Chr", 1);
        sortOrder.put("Start", 1);
        sortOrder.put("Stop", 1);
        sortOrder.put("Ref", 1);
        sortOrder.put("Alt", 1);
        return sortOrder;
    }

    /**
     * Get all of the calls in the db in any order
     * @return iterator over MVCs
     */
    protected SiteIterator<MongoVariantContext> getCalls() {
        return getCalls(new SiteManager(parser));
    }

    /**
     * Get the sites, if any, that overlap the interval specified as the loc
     *
     * @param manager the site manager
     * @return iterator over MVCs
     */
    public SiteIterator<MongoVariantContext> getCalls(final SiteManager manager) {
        final DBObject sortOrder = sitesOrder();
        final SiteIterator<MongoVariantContext> it = manager.getIterator(sites, sortOrder);
        it.setErrorHandler(new InvalidRecordsRemove<>(sites));
        return it;
    }

    /**
     * Get the consensus sites, if any, that overlap the interval specified as the loc
     *
     * @param manager the site manager
     * @return non-null iterator
     */
    public SiteIterator<MongoVariantContext> getConsensusSites(final SiteManager manager) {
        return manager.getIterator(consensusSites, sitesOrder());
    }

    public ConsensusSummarizer updateConsensus(final SiteManager manager, final boolean tryToRemove) {
        return updateConsensus(manager, Priority.DEBUG, tryToRemove);
    }

    public ConsensusSummarizer updateConsensus(final SiteManager manager, final Priority logPriority, final boolean tryToRemove) {
        final ConsensusSummarizer summary = new ConsensusSummarizer();

        final SiteIterator<MongoVariantContext> siteIterator = getCalls(manager);
        while ( siteIterator.hasNext() ) {
            final Collection<MongoVariantContext> callsAtSite = siteIterator.getNextEquivalents();
            final MongoVariantContext consensus = new ConsensusMaker().makeConsensus(callsAtSite);
            updateConsensusInDB(consensus, tryToRemove);
            logger.log(logPriority, "Updating consensus at site " + consensus);
            summary.add(consensus);
        }

        return summary;
    }

    /**
     * Updates consensus DB collection to include (or update) site
     *
     * If site already exists in the consensus, it's old entry and site is updated.  If it's not
     * present, then site is simply inserted
     *
     * @param site a non-null site to update in the consensus
     * @param tryToRemove if true, we will first try to remove the site from the consensus (possibly an expensive oepration)
     * @return the result of the insert operation on the DB
     */
    private WriteResult updateConsensusInDB(final MongoVariantContext site, final boolean tryToRemove) {
        // remove existing entry, if one exists
        if ( tryToRemove )
            consensusSites.remove(consensusSiteQuery(site));
        // add the site to the consensus
        return consensusSites.insert(site);
    }

    private static DBObject consensusSiteQuery(final MongoVariantContext site) {
        final List<DBObject> conditions = new LinkedList<>();
        conditions.add(new BasicDBObject("Chr", site.getChr()));
        conditions.add(new BasicDBObject("Start", site.getStart()));
        conditions.add(new BasicDBObject("Stop", site.getStop()));
        conditions.add(new BasicDBObject("Ref", site.getRef()));
        conditions.add(new BasicDBObject("Alt", site.getAlt()));
        final DBObject query = new BasicDBObject("$and", conditions);
        if ( logger.isDebugEnabled() ) logger.debug("Query " + query);
        return query;
    }

    /**
     * Convenience function to write all reviewed MongoVariantContexts as VariantContext
     * from the sites collection to the VariantContextWriter outputStream
     *
     * @param writer where the VariantContexts should be written
     * @param manager the root SiteManager that lets us know where we should be getting our records from
     * @return the number of reviews written to disk
     */
    public int writeReviews(final VariantContextWriter writer, final SiteManager manager) {
        return writeSelectedSites(writer, manager.onlyReviewed());
    }

    /**
     * Write all selected sites from the knowledge base to the writer
     *
     * @param writer     the VCF writer
     * @param manager    the site manager
     * @return number of records that were written
     */
    public int writeSelectedSites(final VariantContextWriter writer, final SiteManager manager) {
        writer.writeHeader(makeStandardVCFHeader());

        int counter = 0;
        for ( final MongoVariantContext vc : getCalls(manager)) {
            writer.add(vc.getVariantContext());
            counter++;
        }

        return counter;
    }

    /**
     * @return a VCF header containing all of the standard NA12878 knowledge base metadata (INFO and FORMAT) fields
     */
    public VCFHeader makeStandardVCFHeader() {
        final Set<VCFHeaderLine> metadata = new HashSet<>();

        for ( final VCFHeaderLine line : MongoVariantContext.reviewHeaderLines() )
            metadata.add(line);

        VCFStandardHeaderLines.addStandardFormatLines(metadata, true,
                VCFConstants.GENOTYPE_KEY, VCFConstants.DEPTH_KEY, VCFConstants.GENOTYPE_QUALITY_KEY);

        return new VCFHeader(metadata, Collections.singleton("NA12878"));
    }

    @Override
    public String toString() {
        return String.format("NA12878KnowledgeBase{%s}", dblocator);
    }
}
