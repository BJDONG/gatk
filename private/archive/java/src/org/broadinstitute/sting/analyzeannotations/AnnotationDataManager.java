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

package org.broadinstitute.sting.gatk.walkers.analyzeannotations;

import org.broadinstitute.variant.variantcontext.VariantContext;
import org.broadinstitute.variant.variantcontext.VariantContextUtils;
import org.broadinstitute.variant.utils.BaseUtils;
import org.broadinstitute.sting.utils.exceptions.UserException;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileNotFoundException;

/*
 * Copyright (c) 2010 The Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * Created by IntelliJ IDEA.
 * User: rpoplin
 * Date: Jan 18, 2010
 */

public class AnnotationDataManager {

    private final HashMap<String, TreeSet<AnnotationDatum>> data;
    private final HashMap<String,String> nameMap;
    private final boolean INDICATE_MEAN_NUM_VARS;

    public AnnotationDataManager( HashMap<String,String> _nameMap, boolean _INDICATE_MEAN_NUM_VARS ) {
        data = new HashMap<String, TreeSet<AnnotationDatum>>();
        nameMap = _nameMap;
        INDICATE_MEAN_NUM_VARS = _INDICATE_MEAN_NUM_VARS;
    }

    public void addAnnotations( final VariantContext vc, final String sampleName, final boolean isInTruthSet, final boolean isTrueVariant ) {

        if( sampleName != null ) { // Only process variants that are found in the sample with this sampleName
            if( vc.getGenotype(sampleName).isNoCall() ) { // This variant isn't found in this sample so break out
                return;
            }
        } // else, process all samples

        // Loop over each annotation in the vcf record
        final Map<String,Object> infoField = new HashMap<String, Object>(vc.getAttributes());
        infoField.put("QUAL", ((Double)vc.getPhredScaledQual()).toString() ); // add QUAL field to annotations
        for( Map.Entry<String, Object> annotation : infoField.entrySet() ) {

            float value;
            try {
                value = Float.parseFloat( annotation.getValue().toString() );
            } catch( NumberFormatException e ) {
                continue; // Skip over annotations that aren't floats, like "DB"
            }

            TreeSet<AnnotationDatum> treeSet = data.get( annotation.getKey() );
            if( treeSet == null ) { // This annotation hasn't been seen before
                treeSet = new TreeSet<AnnotationDatum>( new AnnotationDatum() ); // AnnotationDatum is a Comparator that orders variants by the value of the Annotation
                data.put( annotation.getKey(), treeSet );
            }
            AnnotationDatum datum = new AnnotationDatum( value );
            if( treeSet.contains(datum) ) { // contains() uses AnnotationDatum's equals function, so it only checks if the value field is already present
                datum = treeSet.tailSet(datum).first();
            } else {
                treeSet.add(datum);
            }

            final boolean isNovelVariant = !vc.hasID() || !vc.getID().contains("rs");

            // Decide if the variant is a transition or transversion
            if( VariantContextUtils.getSNPSubstitutionType(vc).compareTo(BaseUtils.BaseSubstitutionType.TRANSITION) == 0 ) {
                datum.incrementTi( isNovelVariant, isInTruthSet, isTrueVariant );
            } else {
                datum.incrementTv( isNovelVariant, isInTruthSet, isTrueVariant );
            }
        }
    }

    public void plotCumulativeTables( final String PATH_TO_RSCRIPT, final String PATH_TO_RESOURCES, final String OUTPUT_PREFIX,
                                      final int MIN_VARIANTS_PER_BIN, final int MAX_VARIANTS_PER_BIN ) {

        final AnnotationDatum thisAnnotationBin = new AnnotationDatum();
        System.out.println( "\nFinished reading variants into memory. Executing RScript commands:" );

        // For each annotation we've seen
        for( final String annotationKey : data.keySet() ) {

            String filename = OUTPUT_PREFIX + annotationKey + ".dat";
            PrintStream output;
            try {
                output = new PrintStream(filename); // Create the intermediate data file for this annotation
            } catch ( FileNotFoundException e ) {
                throw new UserException.CouldNotCreateOutputFile(new File(filename), "Can't create intermediate output annotation data file. Does the output directory exist?", e);
            }

            // Output a header line
            output.println("value\ttitv\tdbsnp\ttruePositive\tnumVariants\tcategory");

            // Bin SNPs and calculate truth metrics for each bin
            thisAnnotationBin.clearBin();
            for( final AnnotationDatum datum : data.get( annotationKey ) ) {
                thisAnnotationBin.combine( datum );
                if( thisAnnotationBin.numVariants( AnnotationDatum.FULL_SET ) >= MAX_VARIANTS_PER_BIN ) { // This annotation bin is full
                    output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.FULL_SET ) + "\t" + thisAnnotationBin.calcDBsnpRate() + "\t" + thisAnnotationBin.calcTPrate() +
                            "\t" + thisAnnotationBin.numVariants( AnnotationDatum.FULL_SET ) + "\tall");
                    output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.NOVEL_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.NOVEL_SET ) + "\tnovel");
                    output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.DBSNP_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.DBSNP_SET ) + "\tdbsnp");
                    output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.TRUTH_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.TRUTH_SET ) + "\ttruth");
                    thisAnnotationBin.clearBin();
                }
                // else, continue accumulating variants because this bin isn't full yet
            }

            // One final bin that may not have been dumped out
            if( thisAnnotationBin.numVariants( AnnotationDatum.FULL_SET ) != 0 ) {
                output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.FULL_SET ) + "\t" + thisAnnotationBin.calcDBsnpRate() + "\t" + thisAnnotationBin.calcTPrate() +
                            "\t" + thisAnnotationBin.numVariants( AnnotationDatum.FULL_SET ) + "\tall");
                output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.NOVEL_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.NOVEL_SET ) + "\tnovel");
                output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.DBSNP_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.DBSNP_SET ) + "\tdbsnp");
                output.println( thisAnnotationBin.value + "\t" + thisAnnotationBin.calcTiTv( AnnotationDatum.TRUTH_SET ) + "\t-1\t-1\t" + thisAnnotationBin.numVariants( AnnotationDatum.TRUTH_SET ) + "\ttruth");
                thisAnnotationBin.clearBin();
            }

            // Close the PrintStream
            output.close();

            String annotationName = null;
            if( nameMap != null ) {
                annotationName = nameMap.get(annotationKey);
            }
            if( annotationName == null ) { // This annotation is not in the name map so use the key instead
                annotationName = annotationKey;
            }

            // Print out the command line to make it clear to the user what is being executed and how one might modify it
            final String rScriptCommandLine = PATH_TO_RSCRIPT + " " + PATH_TO_RESOURCES + "plot_Annotations_BinnedTruthMetrics.R" + " " +
                                   OUTPUT_PREFIX + annotationKey + ".dat" + " " + annotationName + " " + MIN_VARIANTS_PER_BIN + " " + INDICATE_MEAN_NUM_VARS;
            System.out.println( rScriptCommandLine );

            // Execute the RScript command to plot the table of truth values
            try {
                Runtime.getRuntime().exec( rScriptCommandLine );
            } catch ( IOException e ) {
                throw new UserException.CannotExecuteRScript( rScriptCommandLine, e );
            }
        }
    }
}
