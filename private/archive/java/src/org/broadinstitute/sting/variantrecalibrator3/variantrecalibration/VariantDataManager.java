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

package org.broadinstitute.sting.gatk.walkers.variantrecalibrator3.variantrecalibration;

import org.apache.log4j.Logger;
import org.broadinstitute.sting.gatk.GenomeAnalysisEngine;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.variantrecalibration.VariantRecalibrator;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.variant.vcf.VCFConstants;
import org.broadinstitute.sting.utils.collections.ExpandingArrayList;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.variant.variantcontext.Allele;
import org.broadinstitute.variant.variantcontext.VariantContext;
import org.broadinstitute.variant.variantcontext.VariantContextBuilder;
import org.broadinstitute.variant.variantcontext.writer.VariantContextWriter;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: rpoplin
 * Date: Mar 4, 2011
 */

public class VariantDataManager {
    private ExpandingArrayList<VariantDatum> data;
    private final double[] meanVector;
    private final double[] varianceVector;
    public final List<String> initialKeys;
    private final VariantRecalibratorArgumentCollection VRAC;
    protected final static Logger logger = Logger.getLogger(VariantDataManager.class);
    protected final List<String> finalKeys;
    protected final List<String> allKeys;
    protected final List<TrainingSet> trainingSets;
    protected final boolean[] finalTraining;
    protected final boolean[] initialTraining;
    protected int[] obsCounts;
    private VariantDataManager snpSubManager = null;
    private VariantDataManager indelSubManager = null;

    public VariantDataManager( final List<String> initialKeys, final List<String> finalKeys, final VariantRecalibratorArgumentCollection VRAC) {
        this(initialKeys,finalKeys,VRAC,true);
    }

    private VariantDataManager( final List<String> initialKeys, final List<String> finalKeys, final VariantRecalibratorArgumentCollection VRAC, boolean isParent ) {
        this.data = null;
        this.initialKeys = new ArrayList<String>( initialKeys );
        this.finalKeys = new ArrayList<String>(finalKeys);
        List<String> allKeys = new ArrayList<String>(initialKeys);
        for ( String key : finalKeys ) {
            if ( ! allKeys.contains(key) ) {
                allKeys.add(key);
            }
        }
        this.allKeys = allKeys;
        boolean[] ft = new boolean[allKeys.size()];
        boolean[] it = new boolean[allKeys.size()];
        int idx = 0;
        for ( String k : allKeys ) {
            it[idx] = initialKeys.contains(k);
            ft[idx] = finalKeys.contains(k);
            ++idx;
        }
        this.finalTraining = ft;
        this.initialTraining = it;
        this.VRAC = VRAC;
        obsCounts = new int[this.allKeys.size()];
        meanVector = new double[this.allKeys.size()];
        varianceVector = new double[this.allKeys.size()];
        trainingSets = new ArrayList<TrainingSet>();
        if ( VRAC.MODE == VariantRecalibratorArgumentCollection.Mode.BOTH && isParent ) {
            snpSubManager = new VariantDataManager(initialKeys,finalKeys,VRAC,false);
            indelSubManager = new VariantDataManager(initialKeys,finalKeys,VRAC,false);
        }
    }

    public void setData( final ExpandingArrayList<VariantDatum> data ) {
        if ( snpSubManager == null )
            this.data = data;
        else {
            ExpandingArrayList<VariantDatum> snps = new ExpandingArrayList<VariantDatum>();
            ExpandingArrayList<VariantDatum> nonSnps = new ExpandingArrayList<VariantDatum>();
            for ( VariantDatum d : data ) {
                if ( d.isSNP )
                    snps.add(d);
                else
                    nonSnps.add(d);
            }
            snpSubManager.setData(snps);
            indelSubManager.setData(nonSnps);
            this.data = data;
        }
    }

    public ExpandingArrayList<VariantDatum> getData() {
        return data;
    }

    public void normalizeData() {
        boolean foundZeroVarianceAnnotation = false;
        for( int iii = 0; iii < meanVector.length; iii++ ) {
            final double theMean = meanVector[iii];
            final double theSTD = Math.sqrt(varianceVector[iii]/(obsCounts[iii]-1));
            logger.info( allKeys.get(iii) + String.format(": \t mean = %.8f\t standard deviation = %.8f", theMean, theSTD) );
            if( obsCounts[iii] == 0 ) {
                throw new UserException.BadInput("Values for " + allKeys.get(iii) + " annotation not detected for ANY training variant in the input callset. VariantAnnotator may be used to add these annotations. See http://www.broadinstitute.org/gsa/wiki/index.php/VariantAnnotator");
            }

            foundZeroVarianceAnnotation |= (theSTD < 1E-6);
            int initIdx = -1;
            int finIdx = -1;
            if ( initialTraining[iii] )
                initIdx = initialKeys.lastIndexOf(allKeys.get(iii));
            if ( finalTraining[iii] )
                finIdx = finalKeys.lastIndexOf(allKeys.get(iii));
            for( final VariantDatum datum : data ) {
                // Transform each data point via: (x - mean) / standard deviation
                normalizeDatum(datum,theMean,theSTD,initIdx,finIdx);
            }
        }
        if( foundZeroVarianceAnnotation ) {
            throw new UserException.BadInput( "Found annotations with zero variance. They must be excluded before proceeding." );
        }

        // trim data by standard deviation threshold and mark failing data for exclusion later
        for( final VariantDatum datum : data ) {
            boolean remove = false;
            for( final double val : datum.initialAnnotations ) {
                remove = remove || (Math.abs(val) > VRAC.STD_THRESHOLD);
            }
            /**
             * todo -- i'm pretty sure we don't want to threshold on the final annotations
             *
            for ( final double val : datum.finalAnnotations ) {
                remove = remove || (Math.abs(val) > VRAC.STD_THRESHOLD);
            }
             */
            datum.failingSTDThreshold = remove;
        }
    }

    private void normalizeDatum(VariantDatum datum, double mean, double std, int initIdx, int finalIdx) {
        if ( initIdx > -1 ) {
            datum.initialAnnotations[initIdx] = datum.isNullInitial[initIdx] ? GenomeAnalysisEngine.getRandomGenerator().nextGaussian() : (datum.initialAnnotations[initIdx] - mean)/std;
        }

        /*if ( finalIdx > -1 ) {
            datum.finalAnnotations[finalIdx] = datum.isNullFinal[finalIdx] ? GenomeAnalysisEngine.getRandomGenerator().nextGaussian() : (datum.finalAnnotations[finalIdx] - mean)/std;
        }*/ // don't actually want to normalize the final data
    }

     public void addTrainingSet( final TrainingSet trainingSet ) {
         trainingSets.add( trainingSet );
     }

     public boolean checkHasTrainingSet() {
         for( final TrainingSet trainingSet : trainingSets ) {
             if( trainingSet.isTraining ) { return true; }
         }
         return false;
     }

     public boolean checkHasTruthSet() {
         for( final TrainingSet trainingSet : trainingSets ) {
             if( trainingSet.isTruth ) { return true; }
         }
         return false;
     }

     public boolean checkHasKnownSet() {
         for( final TrainingSet trainingSet : trainingSets ) {
             if( trainingSet.isKnown ) { return true; }
         }
         return false;
     }

    public ExpandingArrayList<VariantDatum> getTrainingData() {
        final ExpandingArrayList<VariantDatum> trainingData = new ExpandingArrayList<VariantDatum>();
        for( final VariantDatum datum : data ) {
            if( (datum.atPositiveTrainingSite || datum.atNegativeTrainingSite) && !datum.failingSTDThreshold && datum.originalQual > VRAC.QUAL_THRESHOLD ) {
                trainingData.add( datum );
            }
        }
        logger.info( "Training with " + trainingData.size() + " variants after standard deviation thresholding." );
        if( trainingData.size() < VRAC.MIN_NUM_BAD_VARIANTS ) {
            logger.warn( "WARNING: Training with very few variant sites! Please check the model reporting PDF to ensure the quality of the model is reliable." );
        }
        return trainingData;
    }

    public ExpandingArrayList<VariantDatum> selectWorstVariants( double bottomPercentage, final int minimumNumber ) {
        // The return value is the list of training variants
        final ExpandingArrayList<VariantDatum> trainingData = new ExpandingArrayList<VariantDatum>();

        // First add to the training list all sites overlapping any bad sites training tracks
        for( final VariantDatum datum : data ) {
            if( datum.atNegativeTrainingSite && !datum.failingSTDThreshold && !Double.isInfinite(datum.getLod()) ) {
                trainingData.add( datum );
            }
        }
        final int numBadSitesAdded = trainingData.size();
        logger.info( "Found " + numBadSitesAdded + " variants overlapping bad sites training tracks." );

        // Next sort the variants by the LOD coming from the positive model and add to the list the bottom X percent of variants
        Collections.sort( data );
        final int numToAdd = Math.max( minimumNumber - trainingData.size(), Math.round((float)bottomPercentage * data.size()) );
        if( numToAdd > data.size() ) {
            throw new UserException.BadInput( "Error during negative model training. Minimum number of variants to use in training is larger than the whole call set. One can attempt to lower the --minNumBadVariants arugment but this is unsafe." );
        } else if( numToAdd == minimumNumber - trainingData.size() ) {
            logger.warn( "WARNING: Training with very few variant sites! Please check the model reporting PDF to ensure the quality of the model is reliable." );
            bottomPercentage = ((float) numToAdd) / ((float) data.size());
        }
        int index = 0, numAdded = 0;
        while( numAdded < numToAdd ) {
            final VariantDatum datum = data.get(index++);
            if( !datum.atNegativeTrainingSite && !datum.failingSTDThreshold && !Double.isInfinite(datum.getLod()) ) {
                datum.atNegativeTrainingSite = true;
                trainingData.add( datum );
                numAdded++;
            }
        }
        logger.info( "Additionally training with worst " + String.format("%.3f", (float) bottomPercentage * 100.0f) + "% of passing data --> " + (trainingData.size() - numBadSitesAdded) + " variants with LOD <= " + String.format("%.4f", data.get(index).getLod()) + "." );
        return trainingData;
    }

    public ExpandingArrayList<VariantDatum> getRandomDataForPlotting( int numToAdd ) {
        numToAdd = Math.min(numToAdd, data.size());
        final ExpandingArrayList<VariantDatum> returnData = new ExpandingArrayList<VariantDatum>();
        for( int iii = 0; iii < numToAdd; iii++) {
            final VariantDatum datum = data.get(GenomeAnalysisEngine.getRandomGenerator().nextInt(data.size()));
            if( !datum.failingSTDThreshold ) {
                returnData.add(datum);
            }
        }

        // Add an extra 5% of points from bad training set, since that set is small but interesting
        for( int iii = 0; iii < Math.floor(0.05*numToAdd); iii++) {
            final VariantDatum datum = data.get(GenomeAnalysisEngine.getRandomGenerator().nextInt(data.size()));
            if( datum.atNegativeTrainingSite && !datum.failingSTDThreshold ) { returnData.add(datum); }
            else { iii--; }
        }

        return returnData;
    }

    public void decodeAnnotations(final VariantDatum datum, final VariantContext vc, final boolean jitter) {
        if ( VRAC.MODE == VariantRecalibratorArgumentCollection.Mode.BOTH ) {
            if ( datum.isSNP )
                snpSubManager.reallyDecodeAnnotations(datum,vc,jitter);
            else
                indelSubManager.reallyDecodeAnnotations(datum,vc,jitter);
        } else {
            reallyDecodeAnnotations(datum,vc,jitter);
        }
    }

    private void reallyDecodeAnnotations( final VariantDatum datum, final VariantContext vc, final boolean jitter ) {
        final double[] annotations = new double[allKeys.size()];
        final double[] rawAnnotations = new double[allKeys.size()];
        final boolean[] isNull = new boolean[allKeys.size()];
        int iii = 0;
        for( final String key : allKeys ) {
            isNull[iii] = false;
            annotations[iii] = decodeAnnotation( key, vc, jitter,true ); // jitters and does special hard-coded stuff
            rawAnnotations[iii] = decodeAnnotation(key,vc,false,false); // no jitter, no hard-coded stuff
            if( Double.isNaN(annotations[iii]) ) { isNull[iii] = true; }
            iii++;
        }
        if ( datum.atPositiveTrainingSite ) {
            updateStatistics(annotations,isNull);
        }
        segregateInitialFinalAnnotations(annotations,rawAnnotations,isNull,datum);
    }

    private void updateStatistics(double[] vector, boolean[] isNull) {
        for ( int idx = 0; idx < vector.length; idx++ ) {
            if ( isNull[idx] ) {
                continue;
            }
            obsCounts[idx]++;
            double oldMean = meanVector[idx];
            meanVector[idx] += (vector[idx] - meanVector[idx])/obsCounts[idx];
            varianceVector[idx] += (vector[idx] - oldMean)*(vector[idx]-meanVector[idx]);
        }
    }

    public void removeWorstPositiveTrainingSites(double ignorePercentage) {
        ExpandingArrayList<VariantDatum> trainingData = new ExpandingArrayList<VariantDatum>();
        for ( VariantDatum datum : data ) {
            if ( datum.atPositiveTrainingSite ) {
                trainingData.add(datum);
            }
        }

        Collections.sort(trainingData);
        int stop = (int) Math.round(ignorePercentage*trainingData.size());
        logger.info(String.format("Un-classifying the worst %.2f percent of positive training data with LOD<=%.2f",100*ignorePercentage,trainingData.get(stop).getLod()));
        for ( int idx = 0; idx < stop; idx++ ) {
            trainingData.get(idx).atPositiveTrainingSite=false;
        }
    }

    public void reclassifyBestPositiveSites(double topPercentage) {
        int stopIdx = data.size()-1-((int) (topPercentage*data.size()));
        Collections.sort(data);
        logger.info(String.format("Classifying the best %.2f percent of classified sites with LOD >= %.2f",100*topPercentage,data.get(stopIdx).getLod()));
        for ( int ctr = 0; ctr < (int) (topPercentage*data.size()); ctr++ ) {
            int idx = data.size()-1-ctr;
            data.get(idx).atPositiveTrainingSite = true;
        }
    }

    public ExpandingArrayList<VariantDatum> selectWorstVariantsNoThresholding( double bottomPercentage, final int minimumNumber ) {
        // The return value is the list of training variants
        final ExpandingArrayList<VariantDatum> trainingData = new ExpandingArrayList<VariantDatum>();

        // First add to the training list all sites overlapping any bad sites training tracks
        for( final VariantDatum datum : data ) {
            if( datum.atNegativeTrainingSite && !datum.failingSTDThreshold && !Double.isInfinite(datum.getLod()) ) {
                trainingData.add( datum );
            }
        }
        final int numBadSitesAdded = trainingData.size();
        logger.info( "Found " + numBadSitesAdded + " variants overlapping bad sites training tracks." );

        // Next sort the variants by the LOD coming from the positive model and add to the list the bottom X percent of variants
        Collections.sort( data );
        final int numToAdd = Math.max( minimumNumber - trainingData.size(), Math.round((float)bottomPercentage * data.size()) );
        if( numToAdd > data.size() ) {
            throw new UserException.BadInput( "Error during negative model training. Minimum number of variants to use in training is larger than the whole call set. One can attempt to lower the --minNumBadVariants arugment but this is unsafe." );
        } else if( numToAdd == minimumNumber - trainingData.size() ) {
            logger.warn( "WARNING: Training with very few variant sites! Please check the model reporting PDF to ensure the quality of the model is reliable." );
            bottomPercentage = ((float) numToAdd) / ((float) data.size());
        }
        int index = 0, numAdded = 0;
        while( numAdded < numToAdd ) {
            final VariantDatum datum = data.get(index++);
            if( !datum.atNegativeTrainingSite ) {
                datum.atNegativeTrainingSite = true;
                trainingData.add( datum );
                numAdded++;
          }
        }
        logger.info( "Additionally training with worst " + String.format("%.3f", (float) bottomPercentage * 100.0f) + "% of passing data --> " + (trainingData.size() - numBadSitesAdded) + " variants with LOD <= " + String.format("%.4f", data.get(index).getLod()) + "." );
        return trainingData;
    }

    private void segregateInitialFinalAnnotations(double[] annotations, double[] rawAnnotations, boolean[] isNull, VariantDatum datum) {
        double[] init = new double[initialKeys.size()];
        double[] finT = new double[finalKeys.size()];
        boolean[] nullInit = new boolean[initialKeys.size()];
        boolean[] nullFinal = new boolean[finalKeys.size()];
        int initIdx = 0;
        int finIdx = 0;
        for ( int idx = 0; idx < annotations.length; idx++) {
            if ( initialTraining[idx] ) {
                init[initIdx] = annotations[idx];
                nullInit[initIdx] = isNull[idx];
                initIdx++;
            }
            if ( finalTraining[idx] ) {
                finT[finIdx] = rawAnnotations[idx];
                nullFinal[finIdx] = isNull[idx];
                finIdx++;
            }
        }
        datum.initialAnnotations = init;
        datum.isNullInitial = nullInit;
        datum.finalAnnotations = finT;
        datum.isNullFinal = nullFinal;
    }

    private static double decodeAnnotation( final String annotationKey, final VariantContext vc, final boolean jitter, final boolean specialSauce ) {
        double value;

        try {

            if ( annotationKey.equalsIgnoreCase("QUAL") ) {
                value = vc.getPhredScaledQual();
            } else {
                value = Double.parseDouble( (String)vc.getAttribute( annotationKey ) );
            }

            if( Double.isInfinite(value) ) { value = Double.NaN; }
            if( jitter && annotationKey.equalsIgnoreCase("HRUN") ) { // Integer valued annotations must be jittered a bit to work in this GMM
                if ( specialSauce ) {
                    value += -0.25 + 0.5 * GenomeAnalysisEngine.getRandomGenerator().nextDouble();
                }
            }

            if (vc.isIndel() && annotationKey.equalsIgnoreCase("QD")) {
            // normalize QD by event length for indel case
                int eventLength = Math.abs(vc.getAlternateAllele(0).getBaseString().length() - vc.getReference().getBaseString().length()); // ignore multi-allelic complication here for now
                if (eventLength > 0 && specialSauce ) { // sanity check
                    value /= (double)eventLength;
                }
            }

            if( specialSauce && jitter && annotationKey.equalsIgnoreCase("HaplotypeScore") && MathUtils.compareDoubles(value, 0.0, 0.0001) == 0 ) { value = -0.2 + 0.4*GenomeAnalysisEngine.getRandomGenerator().nextDouble(); }
            if( specialSauce && jitter && annotationKey.equalsIgnoreCase("FS") && MathUtils.compareDoubles(value, 0.0, 0.001) == 0 ) { value = -0.2 + 0.4*GenomeAnalysisEngine.getRandomGenerator().nextDouble(); }
        } catch( Exception e ) {
            value = Double.NaN; // The VQSR works with missing data by marginalizing over the missing dimension when evaluating the Gaussian mixture model
        }

        return value;
    }

    public void parseTrainingSets( final RefMetaDataTracker tracker, final GenomeLoc genomeLoc, final VariantContext evalVC, final VariantDatum datum, final boolean TRUST_ALL_POLYMORPHIC ) {
        datum.isKnown = false;
        datum.atTruthSite = false;
        datum.atPositiveTrainingSite = false;
        datum.atNegativeTrainingSite = false;
        datum.prior = 2.0;

        for( final TrainingSet trainingSet : trainingSets ) {
            for( final VariantContext trainVC : tracker.getValues(trainingSet.rodBinding, genomeLoc) ) {
                if( isValidVariant( evalVC, trainVC, TRUST_ALL_POLYMORPHIC ) ) {
                    datum.isKnown = datum.isKnown || trainingSet.isKnown;
                    datum.atTruthSite = datum.atTruthSite || trainingSet.isTruth;
                    datum.atPositiveTrainingSite = datum.atPositiveTrainingSite || trainingSet.isTraining;
                    datum.prior = Math.max( datum.prior, trainingSet.prior );
                    datum.consensusCount += ( trainingSet.isConsensus ? 1 : 0 );
                    datum.atNegativeTrainingSite = datum.atNegativeTrainingSite || trainingSet.isAntiTraining;
                    datum.atMonomorphicSite = datum.atMonomorphicSite || trainingSet.isMonomorphic;
                }
            }
        }
    }

    private boolean isValidVariant( final VariantContext evalVC, final VariantContext trainVC, final boolean TRUST_ALL_POLYMORPHIC) {
        return trainVC != null && trainVC.isNotFiltered() && trainVC.isVariant() &&
                        ((evalVC.isSNP() && trainVC.isSNP()) || ((evalVC.isIndel()||evalVC.isMixed()) && (trainVC.isIndel()||trainVC.isMixed()))) &&
                        (TRUST_ALL_POLYMORPHIC || !trainVC.hasGenotypes() || trainVC.isPolymorphicInSamples());
    }

    public void writeOutRecalibrationTable( final VariantContextWriter recalWriter ) {
        // we need to sort in coordinate order in order to produce a valid VCF
        Collections.sort( data, new Comparator<VariantDatum>() {
            public int compare(VariantDatum vd1, VariantDatum vd2) {
                return vd1.loc.compareTo(vd2.loc);
            }} );

        // create dummy alleles to be used
        final List<Allele> alleles = new ArrayList<Allele>(2);
        alleles.add(Allele.create("N", true));
        alleles.add(Allele.create("<VQSR>", false));

        // to be used for the important INFO tags
        final HashMap<String, Object> attributes = new HashMap<String, Object>(3);

        for( final VariantDatum datum : data ) {
            attributes.put(VCFConstants.END_KEY, datum.loc.getStop());
            attributes.put(VariantRecalibrator.VQS_LOD_KEY, String.format("%.4f", datum.getLod()));
            attributes.put(VariantRecalibrator.CULPRIT_KEY, (datum.worstAnnotation != -1 ? allKeys.get(datum.worstAnnotation) : "NULL"));

            VariantContextBuilder builder = new VariantContextBuilder("VQSR", datum.loc.getContig(), datum.loc.getStart(), datum.loc.getStart(), alleles).attributes(attributes);
            recalWriter.add(builder.make());
        }
    }

    public VariantDataManager getSNPManager() {
        return snpSubManager;
    }

    public VariantDataManager getIndelManager() {
        return indelSubManager;
    }
}
