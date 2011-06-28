package org.broadinstitute.sting.gatk.walkers.HLAcaller;

import net.sf.samtools.SAMRecord;
import org.broadinstitute.sting.gatk.refdata.ReadMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.*;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.commandline.Output;

import java.util.Hashtable;
import java.io.PrintStream;

/**
 * Creates a haplotype file given reads (for SNP analysis, imputation, etc)
 * @author shermanjia
 */
@Requires({DataSource.READS, DataSource.REFERENCE})
public class CreateHaplotypesWalker extends ReadWalker<Integer, Integer> {
    @Output
    PrintStream out;

    CigarParser formatter = new CigarParser();
    char c;
    boolean DEBUG = false;
    int HLA_A_start = 30018310;
    int HLA_A_end = 30021211;
    String[] SNPnames;
    String SNPname;
    int start, end;

    Hashtable indexer = new Hashtable();

    public Integer reduceInit() {
        SNPnames = new String[HLA_A_end-HLA_A_start+1];
        start = HLA_A_start;
        end = HLA_A_end;
        
        indexer.put('A', (Integer) 1);
        indexer.put('C', (Integer) 2);
        indexer.put('G', (Integer) 3);
        indexer.put('T', (Integer) 4);
        indexer.put('D', (Integer) 5); // D for deletion
        out.print("Reads:\n");
        return 0;
    }


    
    public Integer map(ReferenceContext ref, SAMRecord read, ReadMetaDataTracker metaDataTracker) {

        int readstart = read.getAlignmentStart();
        int readstop = read.getAlignmentEnd();

        if(readstart <= HLA_A_end && readstop >= HLA_A_start){
            String s = formatter.FormatRead(read.getCigarString(),read.getReadString());
            String name = read.getReadName();

            out.printf("%s->%s HAPLO01 ",name,name);

            for (int i = start; i <= end; i++){
                
                if (i - readstart < s.length()){
                    c = s.charAt(i-readstart);
                    out.printf("%s",indexer.get(c));
                }else{
                    out.print("5");
                }
            }
            out.printf("\n");
        }
        return 1;
    }



    public Integer reduce(Integer value, Integer sum) {

        return value + sum;
    }

    public void onTraversalDone(Integer value) {
        out.print("\nSNP names:\n");
        for (int pos = start; pos <= end; pos++){
            SNPname = "CHR6_POS" + String.valueOf(pos);
            SNPnames[pos-start]=SNPname;
            out.printf("%s\n",SNPname);
        }
    }
}
