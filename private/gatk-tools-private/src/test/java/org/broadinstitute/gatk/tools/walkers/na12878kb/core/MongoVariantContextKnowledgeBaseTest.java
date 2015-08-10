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

package org.broadinstitute.gatk.tools.walkers.na12878kb.core;

import org.broadinstitute.gatk.tools.walkers.na12878kb.core.errors.MongoVariantContextException;
import org.broadinstitute.gatk.utils.exceptions.ReviewedGATKException;
import htsjdk.variant.variantcontext.Genotype;
import htsjdk.variant.variantcontext.VariantContext;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class MongoVariantContextKnowledgeBaseTest extends NA12878KnowledgeBaseTestBase {
    @DataProvider(name = "MVCBasicTest")
    public Object[][] makeMVCBasicTest() {
        List<Object[]> tests = new ArrayList<Object[]>();

        for ( final VariantContext vc : testVCs ) {
            final Genotype NO_CALL = MongoGenotype.NO_CALL;
            final Genotype HOMREF = MongoGenotype.create(vc, 0, 0);
            final Genotype HET = MongoGenotype.create(vc, 0, 1);
            final Genotype HOMVAR = MongoGenotype.create(vc, 1, 1);

            // date is passively tested before we get different dates each time
            for ( final String name : Arrays.asList("x", "y", "z") )
                tests.add(new Object[]{vc, new MongoVariantContext(name, vc, TruthStatus.TRUE_POSITIVE, new Date(), HET, 0.99, true, false)});

            for ( final TruthStatus status : TruthStatus.values() )
                tests.add(new Object[]{vc, new MongoVariantContext("x", vc, status, new Date(), HET, 0.99, true, false)});

            for ( final Genotype genotype : Arrays.asList(NO_CALL, HOMREF, HET, HOMVAR) )
                tests.add(new Object[]{vc, new MongoVariantContext("x", vc, TruthStatus.TRUE_POSITIVE, new Date(), genotype, 0.99, true, false)});

            for ( final boolean reviewed : Arrays.asList(true, false) )
                tests.add(new Object[]{vc, new MongoVariantContext("x", vc, TruthStatus.TRUE_POSITIVE, new Date(), HET, 0.9, reviewed, false)});

            for ( final boolean complex : Arrays.asList(true, false) )
                tests.add(new Object[]{vc, new MongoVariantContext("x", vc, TruthStatus.TRUE_POSITIVE, new Date(), HET, 0.99, true, complex)});

            for ( final double confidence : Arrays.asList(0.8, 0.9, 0.99) )
                tests.add(new Object[]{vc, new MongoVariantContext("x", vc, TruthStatus.TRUE_POSITIVE, new Date(), HET, confidence, true, false)});
        }

        return tests.toArray(new Object[][]{});
    }

    @DataProvider(name = "TestVCProvider")
    public Object[][] testVCProvider() {
        List<Object[]> tests = new ArrayList<Object[]>();
        for ( final VariantContext vc : testVCs )
            tests.add(new Object[]{vc});
        return tests.toArray(new Object[][]{});
    }

    @Test(enabled = true, dataProvider = "TestVCProvider")
    public void testVCToMVC(final VariantContext vc) {
        final MongoVariantContext mvc = MongoVariantContext.create("x", vc, TruthStatus.UNKNOWN, MongoGenotype.NO_CALL);
        Assert.assertTrue(mvc.isSingleCallset());
        Assert.assertEquals(mvc.getCallSetName(), "x");
        Assert.assertEquals(mvc.getSupportingCallSets().size(), 1);
        Assert.assertEquals(mvc.getChr(), vc.getChr());
        Assert.assertEquals(mvc.getStart(), vc.getStart());
        Assert.assertEquals(mvc.getStop(), vc.getEnd());
        Assert.assertEquals(mvc.getRefAllele(), vc.getReference());
        Assert.assertEquals(mvc.getAltAllele(), vc.getAlternateAllele(0));
    }

    @Test(enabled = true, dataProvider = "TestVCProvider")
    public void testMVCMatching(final VariantContext vc) {
        final MongoVariantContext mvc = MongoVariantContext.create("x", vc, TruthStatus.UNKNOWN, MongoGenotype.NO_CALL);
        for ( final VariantContext vc2 : testVCs ) {
            final boolean expectedEquals = vc == vc2;
            Assert.assertEquals(mvc.matches(vc2), expectedEquals, "MVC match returned unexpected value for mvc=" + mvc + " vs vc2=" + vc2);
        }
    }

    @Test(enabled = true, dataProvider = "MVCBasicTest")
    public void testMVCBasic(final VariantContext originalVC, final MongoVariantContext mvc) {
        try {
            setupBeforeMethod();
            db.addCall(mvc);
            final MongoVariantContext fromDB = readOneMVCFromDB();

            Assert.assertEquals(fromDB, mvc, "Input MongoVariantContext not the same as the one read from DB");
            assertVariantContextsAreEqual(fromDB.getVariantContext(), mvc.getVariantContext());
        }
        finally {
            teardownMethod();
        }
    }

    final MongoVariantContext readOneMVCFromDB() {
        final SiteIterator<MongoVariantContext> it = db.getCalls();
        Assert.assertTrue(it.hasNext(), "Expected at least 1 call in the db");
        final MongoVariantContext mvc = it.next();
        Assert.assertFalse(it.hasNext(), "Only expected 1 call in the db but saw > 1");
        it.close();
        return mvc;
    }

    final static MongoVariantContext good = new MongoVariantContext(Arrays.asList("x"), "20", 1, 1, "A", "C", TruthStatus.TRUE_POSITIVE, new MongoGenotype(0, 0), new Date(), 0.5, false, false);
    private static MongoVariantContext makeBad(final List<MongoVariantContext> bads) throws CloneNotSupportedException {
        final MongoVariantContext mvc = good.clone();
        bads.add(mvc);
        return mvc;
    }

    public static List<MongoVariantContext> makeBadMVCs() {
        try {
            final List<MongoVariantContext> bads = new LinkedList<MongoVariantContext>();
            makeBad(bads).setSupportingCallSets(new ArrayList<String>());
            final ArrayList<String> l = new ArrayList<String>();
            makeBad(bads).setSupportingCallSets(l);
            final ArrayList<String> l2 = new ArrayList<String>();
            l2.add(null);
            makeBad(bads).setSupportingCallSets(l2);
            makeBad(bads).setChr("chr20");
            makeBad(bads).setChr("-1");
            makeBad(bads).setChr(null);
            makeBad(bads).setStart(-1);
            makeBad(bads).setStop(-1);
            makeBad(bads).setRef(null);
            makeBad(bads).setRef("");
            makeBad(bads).setRef("X");
            makeBad(bads).setRef("a");
            makeBad(bads).setAlt(null);
            makeBad(bads).setAlt("");
            makeBad(bads).setAlt("X");
            makeBad(bads).setAlt("a");
            makeBad(bads).setGt(new MongoGenotype(-1, -2));
            makeBad(bads).setGt(new MongoGenotype(-2, -1));
            makeBad(bads).setGt(new MongoGenotype(0, -1));
            makeBad(bads).setGt(new MongoGenotype(-1, 0));
            makeBad(bads).setGt(new MongoGenotype(2, 0));
            makeBad(bads).setGt(new MongoGenotype(0, 2));
            makeBad(bads).setGt(new MongoGenotype(0, 0, -1, -2));
            makeBad(bads).setGt(new MongoGenotype(0, 0, -2, -1));
            return bads;
        } catch ( CloneNotSupportedException e ) {
            throw new ReviewedGATKException("Failed to make BADMVCs", e);
        }
    }

    @DataProvider(name = "BadMVCs")
    public Object[][] makeBadMVCsProvider() throws CloneNotSupportedException {
        List<Object[]> tests = new ArrayList<Object[]>();

        for ( final MongoVariantContext bad : makeBadMVCs() )
            tests.add(new Object[]{bad});

        return tests.toArray(new Object[][]{});
    }

    @Test(dataProvider = "BadMVCs", expectedExceptions = MongoVariantContextException.class)
    public void testMVCValidate(final MongoVariantContext mvc) {
        mvc.validate(parser);
    }

    final static MongoVariantContext DUP = new MongoVariantContext(Arrays.asList("x"), "20", 1, 1, "A", "C", TruthStatus.TRUE_POSITIVE, new MongoGenotype(0, 1), new Date(), 0.5, false, false);
    private static MongoVariantContext makeNoDup(final List<MongoVariantContext> nonDups) throws CloneNotSupportedException {
        final MongoVariantContext mvc = DUP.clone();
        nonDups.add(mvc);
        return mvc;
    }

    @DataProvider(name = "Duplicates")
    public Object[][] makeDuplicates() throws CloneNotSupportedException {
        List<Object[]> tests = new ArrayList<Object[]>();

        final List<MongoVariantContext> nonDups = new LinkedList<MongoVariantContext>();
        makeNoDup(nonDups).setSupportingCallSets(Arrays.asList("x", "y"));
        makeNoDup(nonDups).setSupportingCallSets(Arrays.asList("y"));
        makeNoDup(nonDups).setChr("21");
        makeNoDup(nonDups).setStart(2);
        makeNoDup(nonDups).setStop(2);
        makeNoDup(nonDups).setAlt("G");
        makeNoDup(nonDups).setTruth(TruthStatus.FALSE_POSITIVE);
        makeNoDup(nonDups).setReviewed(true);
        makeNoDup(nonDups).setIsComplexEvent(true);
        makeNoDup(nonDups).setConfidence(0.99);
        makeNoDup(nonDups).setGt(new MongoGenotype(0, 0));
        makeNoDup(nonDups).setGt(new MongoGenotype(1, 0));
        makeNoDup(nonDups).setGt(new MongoGenotype(1, 1));
        makeNoDup(nonDups).setGt(new MongoGenotype(-1, -1));
        makeNoDup(nonDups).setGt(new MongoGenotype(0, 0, 1, -1));
        makeNoDup(nonDups).setGt(new MongoGenotype(0, 0, -1, 1));

        tests.add(new Object[]{DUP, DUP, true});

        final MongoVariantContext mvc1 = DUP.clone();
        tests.add(new Object[]{DUP, mvc1, true});

        final MongoVariantContext mvc2 = DUP.clone();
        Calendar cal = Calendar.getInstance();
        cal.setTime(mvc2.getDate());
        mvc2.setDate(cal.getTime());
        tests.add(new Object[]{DUP, mvc2, true});

        final MongoVariantContext mvc3 = DUP.clone();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(mvc3.getDate());
        cal2.add(Calendar.HOUR, 1);
        mvc3.setDate(cal2.getTime());
        tests.add(new Object[]{DUP, mvc3, true});

        for ( final MongoVariantContext nondup : nonDups )
            tests.add(new Object[]{DUP, nondup, false});


        return tests.toArray(new Object[][]{});
    }

    @Test(dataProvider = "Duplicates")
    public void testDuplicates(final MongoVariantContext mvc1, final MongoVariantContext mvc2, final boolean isDup) {
        Assert.assertEquals(mvc1.isDuplicate(mvc2), isDup, "MVCs " + mvc1 + " is dup of " + mvc2 + " returned expected value");
    }
}