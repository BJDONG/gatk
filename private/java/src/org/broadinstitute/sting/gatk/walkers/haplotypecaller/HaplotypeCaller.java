/*
 * Copyright (c) 2011 The Broad Institute
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

package org.broadinstitute.sting.gatk.walkers.haplotypecaller;

import net.sf.picard.reference.IndexedFastaSequenceFile;
import net.sf.samtools.SAMRecord;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Hidden;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.filters.*;
import org.broadinstitute.sting.gatk.refdata.ReadMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.ReadFilters;
import org.broadinstitute.sting.gatk.walkers.ReadWalker;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.GenomeLocSortedSet;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.fasta.CachingIndexedFastaSequenceFile;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ReadFilters( {MappingQualityUnavailableFilter.class, NotPrimaryAlignmentFilter.class, DuplicateReadFilter.class, FailsVendorQualityCheckFilter.class} )
public class HaplotypeCaller extends ReadWalker<SAMRecord, Integer> {

    @Output(doc="Base-space graph output", required=true)
    protected PrintStream graphWriter = null;

    @Argument(fullName = "assembler", shortName = "assembler", doc = "Assembler to use; currently only SIMPLE_DE_BRUIJN is available.", required = false)
    protected LocalAssemblyEngine.ASSEMBLER ASSEMBLER_TO_USE = LocalAssemblyEngine.ASSEMBLER.SIMPLE_DE_BRUIJN;

    @Hidden
    @Argument(fullName = "readsToUse", shortName = "readsToUse", doc = "For debugging: how many reads to use", required = false)
    protected int numReadsToUse = -1;

    // the assembly engine
    LocalAssemblyEngine assemblyEngine = null;

    // the likelihoods engine
    LikelihoodCalculationEngine likelihoodCalculationEngine = new LikelihoodCalculationEngine(45.0, 10.0, false, true, false);

    // the intervals input by the user
    private Iterator<GenomeLoc> intervals = null;

    // the current interval in the list
    private GenomeLoc currentInterval = null;

    // the reads that fall into the current interval
    private final ArrayList<SAMRecord> readsToAssemble = new ArrayList<SAMRecord>();


    public void initialize() {

        IndexedFastaSequenceFile referenceReader;
        try {
            // fasta reference reader to supplement the edges of the reference sequence
            referenceReader = new CachingIndexedFastaSequenceFile(getToolkit().getArguments().referenceFile);
        }
        catch(FileNotFoundException ex) {
            throw new UserException.CouldNotReadInputFile(getToolkit().getArguments().referenceFile,ex);
        }

        assemblyEngine = makeAssembler(ASSEMBLER_TO_USE, referenceReader);

        GenomeLocSortedSet intervalsToAssemble = getToolkit().getIntervals();
        if ( intervalsToAssemble == null || intervalsToAssemble.isEmpty() )
            throw new UserException.BadInput("Intervals must be provided with -L or -BTI (preferably not larger than several hundred bp)");

        intervals = intervalsToAssemble.clone().iterator();
        currentInterval = intervals.hasNext() ? intervals.next() : null;
    }

    private LocalAssemblyEngine makeAssembler(LocalAssemblyEngine.ASSEMBLER type, IndexedFastaSequenceFile referenceReader) {
        switch ( type ) {
            case SIMPLE_DE_BRUIJN:
                return new SimpleDeBruijnAssembler(graphWriter, referenceReader, numReadsToUse);
            default:
                throw new UserException.BadInput("Assembler type " + type + " is not valid/supported");
        }
    }

    public SAMRecord map(ReferenceContext ref, SAMRecord read, ReadMetaDataTracker metaDataTracker) {
        return currentInterval == null ? null : read;
    }

    public Integer reduceInit() {
        return 0;
    }

    public Integer reduce(SAMRecord read, Integer sum) {
        if ( read == null )
            return sum;

        GenomeLoc readLoc = getToolkit().getGenomeLocParser().createGenomeLoc(read);
        // hack to get around unmapped reads having screwy locations
        if ( readLoc.getStop() == 0 )
            readLoc = getToolkit().getGenomeLocParser().createGenomeLoc(readLoc.getContig(), readLoc.getStart(), readLoc.getStart());

        if ( readLoc.overlapsP(currentInterval) ) {
            readsToAssemble.add(read);
        } else {
            List<Haplotype> haplotypes = assemblyEngine.runLocalAssembly( readsToAssemble );
            double[] likelihoods = likelihoodCalculationEngine.computeLikelihoods( haplotypes, readsToAssemble );

            readsToAssemble.clear();
            sum++;

            do {
                currentInterval = intervals.hasNext() ? intervals.next() : null;
            } while ( currentInterval != null && currentInterval.isBefore(readLoc) );
        }

        return sum;
    }

    public void onTraversalDone(Integer result) {
        if ( readsToAssemble.size() > 0 ) {
            List<Haplotype> haplotypes = assemblyEngine.runLocalAssembly( readsToAssemble );
            double[] likelihoods = likelihoodCalculationEngine.computeLikelihoods( haplotypes, readsToAssemble );
            for( double l : likelihoods ) {
                System.out.println(l);
            }
            System.out.println("-------------------------------------");
            result++;
        }
        logger.info("Ran local assembly on " + result + " intervals");
    }
}