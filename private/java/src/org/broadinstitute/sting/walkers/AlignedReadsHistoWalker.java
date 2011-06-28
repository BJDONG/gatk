package org.broadinstitute.sting.walkers;

import net.sf.samtools.SAMRecord;
import org.broadinstitute.sting.gatk.refdata.ReadMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.ReadWalker;
import org.broadinstitute.sting.gatk.walkers.WalkerName;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.commandline.Output;

import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 * User: mdepristo
 * Date: Feb 22, 2009
 * Time: 3:22:14 PM
 * To change this template use File | Settings | File Templates.
 */
@WalkerName("Aligned_Reads_Histogram")
public class AlignedReadsHistoWalker extends ReadWalker<Integer, Integer> {
    @Output
    PrintStream out;

    long[] alignCounts = new long[51];

    public void initialize() {
        for ( int i = 0; i < alignCounts.length; i++ ) {
            alignCounts[i] = 0;
        }
    }

    // Do we actually want to operate on the context?
    public boolean filter(byte[] ref, SAMRecord read) {
	    // we only want aligned reads
	    return !read.getReadUnmappedFlag();
    }

    public Integer map(ReferenceContext ref, SAMRecord read, ReadMetaDataTracker metaDataTracker) {
        //System.out.println(read.getAttribute("NM"));
        int editDist = Integer.parseInt(read.getAttribute("NM").toString());
        if (editDist <= 50)
            alignCounts[editDist]++;
        return 1;
    }

    // Given result of map function
    public Integer reduceInit() { return 0; }
    public Integer reduce(Integer value, Integer sum) {
        return value + sum;
    }

    public void onTraversalDone(Integer result) {
        int curTotal = 0;
        for ( int i = 0; i < alignCounts.length; i++ ) {
            curTotal += alignCounts[i];
            out.printf("%3d %10d%n", i, curTotal);
        }
    }
}
