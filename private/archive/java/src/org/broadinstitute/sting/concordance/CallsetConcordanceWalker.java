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
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 * THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.gatk.walkers.concordance;

import org.broad.tribble.vcf.VCFGenotypeRecord;
import org.broad.tribble.vcf.VCFHeader;
import org.broad.tribble.vcf.VCFHeaderLine;
import org.broad.tribble.vcf.VCFRecord;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.refdata.utils.GATKFeature;
import org.broadinstitute.sting.gatk.walkers.*;
import org.broadinstitute.sting.utils.classloader.PackageUtils;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.SampleUtils;
import org.broadinstitute.sting.utils.StingException;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.utils.genotype.vcf.*;

import java.io.File;
import java.util.*;


/**
 * Determines the concordance between multiple VCF call sets at each position.
 * Users can specify which concordance tests should be run.
 */
@Requires(value={DataSource.REFERENCE})
@Reference(window=@Window(start=-20,stop=20))
public class CallsetConcordanceWalker extends RodWalker<Integer, Integer> {
    @Argument(fullName="concordance_output", shortName="CO", doc="VCF file to which output should be written", required=true)
    private File OUTPUT = null;
    @Argument(fullName="concordanceType", shortName="CT", doc="Concordance subset types to apply to given callsets.   Syntax: 'type[:key1=arg1,key2=arg2,...]'", required=false)
    private String[] TYPES = null;
    @Argument(fullName="list", shortName="ls", doc="List the available concordance types and exit", required=false)
    private Boolean LIST_ONLY = false;


    // the concordance tests to run
    private ArrayList<ConcordanceType> requestedTypes;

    // VCF writer for the output of the concordance tests
    private VCFWriter vcfWriter;

    // a map of rod name to uniquified sample name
    private HashMap<Pair<String, String>, String> rodNamesToSampleNames = new HashMap<Pair<String, String>, String>();


    /**
     * Prepare the output file and the list of available features.
     */
    public void initialize() {

        // get the possible concordance types
        List<Class<? extends ConcordanceType>> classes = PackageUtils.getClassesImplementingInterface(ConcordanceType.class);

        // print and exit if that's what was requested
        if ( LIST_ONLY ) {
            out.println("\nAvailable concordance types:");
            for (int i = 0; i < classes.size(); i++)
                out.println("\t" + classes.get(i).getSimpleName());
            out.println();
            System.exit(0);
        }

        // get the list of all sample names from the various input rods (they need to be uniquified in case there's overlap)
        HashSet<String> samples = new HashSet<String>();
        SampleUtils.getUniquifiedSamplesFromRods(getToolkit(), samples, rodNamesToSampleNames);

        for ( java.util.Map.Entry<Pair<String, String>, String> entry : rodNamesToSampleNames.entrySet() ) {
            logger.debug("Uniquified sample mapping: " + entry.getKey().first + "/" + entry.getKey().second + " -> " + entry.getValue());
        }

        // initialize requested concordance types
        requestedTypes = new ArrayList<ConcordanceType>();
        if (TYPES != null) {
            for ( String requestedTypeString : TYPES ) {
                String[] requestedPieces = requestedTypeString.split(":");
                String requestedType = requestedPieces[0];

                boolean foundClass = false;
                for ( Class type : classes ) {

                    if (requestedType.equalsIgnoreCase(type.getSimpleName())) {
                        foundClass = true;
                        try {
                            ConcordanceType concordance = (ConcordanceType)type.newInstance();
                            HashMap<String,String> requestedArgs = new HashMap<String,String>();
                            if ( requestedPieces.length == 2 ) {
                                String[] argStrings = requestedPieces[1].split(",");
                                for (int i = 0; i < argStrings.length; i++ ) {
                                    String[] arg = argStrings[i].split("=");
                                    if ( arg.length == 2 )
                                        requestedArgs.put(arg[0], arg[1]);
                                }
                            }

                            concordance.initialize(requestedArgs, samples);
                            requestedTypes.add(concordance);
                            break;
                        } catch (InstantiationException e) {
                            throw new StingException(String.format("Cannot instantiate concordance class '%s': must be concrete class", type.getSimpleName()));
                        } catch (IllegalAccessException e) {
                            throw new StingException(String.format("Cannot instantiate concordance class '%s': must have no-arg constructor", type.getSimpleName()));
                        }
                    }
                }

                if ( !foundClass )
                    throw new StingException("The requested concordance type (" + requestedType + ") isn't a valid concordance option");
            }
        }

        // set up the header fields
        Set<VCFHeaderLine> hInfo = new HashSet<VCFHeaderLine>();
        hInfo.addAll(VCFUtils.getHeaderFields(getToolkit()));
        hInfo.add(new VCFHeaderLine("source", "CallsetConcordance"));
        hInfo.add(new VCFHeaderLine("note", "\"This file represents a concordance test of various call sets - NOT the output from a multi-sample caller\""));
        hInfo.addAll(getVCFAnnotationDescriptions(requestedTypes));

        vcfWriter = new VCFWriter(OUTPUT);
        vcfWriter.writeHeader(new VCFHeader(hInfo, samples));
    }

    public static Set<VCFHeaderLine> getVCFAnnotationDescriptions(Collection<ConcordanceType> types) {

        TreeSet<VCFHeaderLine> descriptions = new TreeSet<VCFHeaderLine>();
        for ( ConcordanceType type : types )
            descriptions.add(type.getInfoDescription());

        return descriptions;
    }

    public Integer map(RefMetaDataTracker rodData, ReferenceContext ref, AlignmentContext context) {
        if ( rodData == null ) // RodWalkers can make funky map calls
            return 0;

        // get all of the vcf rods at this locus
        Map<VCFRecord,String> vcfRods = new LinkedHashMap<VCFRecord,String>();
        Iterator<GATKFeature> rods = rodData.getAllRods().iterator();
        while (rods.hasNext()) {
            GATKFeature rod = rods.next();
            if ( rod.getUnderlyingObject() instanceof VCFRecord ) {
                if (vcfRods.containsKey(rod)) throw new StingException("Duplicate VCF's found");
                vcfRods.put((VCFRecord)rod.getUnderlyingObject(),rod.getName());
            }
        }

        if ( vcfRods.size() == 0 )
            return 0;

        // pull out all of the individual calls from the rods and insert into a map based on the
        // mapping from rod/sample to uniquified name
        HashMap<String, VCFGenotypeRecord> samplesToRecords = new HashMap<String, VCFGenotypeRecord>();
        for ( VCFRecord rod : vcfRods.keySet() ) {
            List<VCFGenotypeRecord> records = rod.getVCFGenotypeRecords();
            for ( VCFGenotypeRecord vcfRec : records ) {
                String uniquifiedSample = rodNamesToSampleNames.get(new Pair<String, String>(vcfRods.get(rod), vcfRec.getSampleName()));
                if ( uniquifiedSample == null )
                    throw new StingException("Unexpected sample encountered: " + vcfRec.getSampleName() + " in rod " + vcfRods.get(rod));

                samplesToRecords.put(uniquifiedSample, vcfRec);
            }
        }

        // create a merged record from all input VCFs
        VCFRecord record = VCFUtils.mergeRecords(vcfRods, rodNamesToSampleNames);

        // add in the info fields to the new record based on the results of each of the relevant concordance tests
        for ( ConcordanceType type : requestedTypes ) {
            String result = type.computeConcordance(samplesToRecords, ref);
            if ( result != null ) {
                record.addInfoField(type.getInfoName(), result);
            }
        }

        // emit the new record
        vcfWriter.addRecord(record);

        return 1;
    }

    public Integer reduceInit() { return 0; }

    public Integer reduce(Integer value, Integer sum) {
        return sum + value;
    }

    public void onTraversalDone(Integer result) {
        vcfWriter.close();
        out.printf("Processed %d loci.\n", result);
    }
}
