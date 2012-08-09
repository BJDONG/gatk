
package org.broadinstitute.sting.gatk.walkers;

import net.sf.samtools.SAMRecord;
import net.sf.samtools.SAMFileHeader;
import net.sf.samtools.SAMReadGroupRecord;
import org.broadinstitute.sting.gatk.GenomeAnalysisEngine;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;

import java.util.List;

public class ListSampleIds extends LocusWalker<Boolean, Boolean>
{
    public void initialize() 
    { 
        GenomeAnalysisEngine toolkit = this.getToolkit();
        SAMFileHeader header = toolkit.getSAMFileHeader();
        List<SAMReadGroupRecord> read_groups = header.getReadGroups();

        for (int i = 0; i < read_groups.size(); i++)
        {
            String sample_name = read_groups.get(i).getSample();
            out.println(sample_name);
        } 
    }

    public Boolean map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) 
    {
        List<SAMRecord> reads = context.getReads();
        StringBuilder readNames = new StringBuilder();

        for ( int i = 0; i < reads.size(); i++ )
        {
            SAMRecord read = reads.get(i);
            SAMReadGroupRecord readGroup = read.getReadGroup();
            if (readGroup == null) { System.out.printf("."); return false; }
            String sample = readGroup.getSample();
            System.out.printf("FROM_MAP %s\n", sample);
        }

        return true;
    }

    public void onTraversalDone() 
    {
        return;
    }

    public Boolean reduceInit() 
    { 
        return true;
    }

    public Boolean reduce(Boolean mapresult, Boolean sum) 
    {
        out.flush();
        return true;
    }
}
