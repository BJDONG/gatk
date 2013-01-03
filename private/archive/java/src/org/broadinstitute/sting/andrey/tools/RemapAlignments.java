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

package org.broadinstitute.sting.gatk.walkers.andrey.tools;

import net.sf.picard.cmdline.CommandLineProgram;
import net.sf.picard.cmdline.Option;
import net.sf.picard.cmdline.Usage;
import net.sf.picard.reference.ReferenceSequenceFileWalker;
import net.sf.samtools.*;
import net.sf.samtools.SAMFileHeader.SortOrder;
import net.sf.samtools.SAMFileReader.ValidationStringency;
import org.broadinstitute.sting.utils.GenomeLocParser;
import org.broadinstitute.sting.utils.sam.AlignmentUtils;

import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


public class RemapAlignments extends CommandLineProgram {

    // Usage and parameters
    @Usage(programVersion="1.0") public String USAGE = "Remaps custom-reference (e.g. transcriptome) alignments onto the genomic reference\n";
	@Option(shortName="M", 
			doc="Map file: from the reference the reads were aligned to, to the master reference the alignments should be remapped to. "+
            "In other words, for each custom-reference contig C this map must provide a (possibly disjoint) list of intervals "+
            "on the target reference, onto which C maps base-by-base. ",
			optional=false)
	public File MAP_FILE = null;
	@Option(shortName="I", 
			doc="Input file (bam or sam) with alignments to be remapped",
			optional=false)
	public File IN = null;
	@Option(shortName="O", 
			doc="File to write remapped reads to.", 
			optional=false)
	public File OUT = null;
	@Option(shortName="R", 
			doc="Target reference to remap alignments onto.",
			optional=false)
	public File REFERENCE = null;
	@Option(
			doc="If a read has multiple alignments that are exactly the same after remapping, "+
			"then keep only one copy of such alignment in output file. Multiple alignments that are "+
			"not equivalent after remapping are not affected by this flag. "+
			"Multiple alignments for the same query must be grouped on adjacent lines of the input file to be detected "+
            "(i.e. input file must be sorted by read name), " +
			"otherwise REDUCE will have no effect.", 
			optional=true)
	public boolean REDUCE = false;


	private GenomicMap map = null;
	private String lastReadName = null;
	private int totalReads = 0;
	private int totalRecords = 0;
	private int badRecords = 0;
	private int totalUnmappedReads = 0;
	private int writtenRecords = 0;

	private Set<SAMRecord> remappedReads = null;
	private SAMFileWriter writer = null;
	private SAMFileReader reader = null;
	
	private static int [] g_log_n; // copied from bwa
	
	
    /** Required main method implementation. */
    public static void main(final String[] argv) {
        System.exit(new RemapAlignments().instanceMain(argv));
    }
    
    protected int doWork() {
    			
    	g_log_n = new int[256];
    	for (int i = 1; i < 256; ++i) g_log_n[i] = (int)(4.343 * Math.log(i) + 0.5);
    	
    	reader = new SAMFileReader(IN);
    	reader.setValidationStringency(ValidationStringency.SILENT);
		SAMFileHeader oldHeader = reader.getFileHeader();
		if ( oldHeader == null ) throw new RuntimeException("Failed to retrieve SAM file header from the input bam file");
		
		if ( REDUCE && oldHeader.getSortOrder() != SortOrder.queryname ) 
			System.out.println("WARNING: Input file is not sorted by query name, REDUCE may have no effect. Sort order: "
					+oldHeader.getSortOrder());
		
		remappedReads = new TreeSet<SAMRecord>(new AlignmentComparator());
		
		SAMFileHeader h = new SAMFileHeader();
		
		for ( Entry<String, String> attr : oldHeader.getAttributes() ) h.setAttribute(attr.getKey(), attr.getValue());
		h.setGroupOrder(oldHeader.getGroupOrder());
		h.setProgramRecords(oldHeader.getProgramRecords());
		h.setReadGroups(oldHeader.getReadGroups());
		
		if ( oldHeader.getSortOrder() == SortOrder.queryname ) {
			h.setSortOrder(SortOrder.queryname);
		} else {
			h.setSortOrder(SortOrder.unsorted);
		}
		
		ReferenceSequenceFileWalker reference = new ReferenceSequenceFileWalker(REFERENCE);

        if ( reference.getSequenceDictionary() == null ) {
        	System.out.println("No reference sequence dictionary found. Aborting.");
        	reader.close();
        	System.exit(1);
        }
		
		h.setSequenceDictionary(reference.getSequenceDictionary());
        GenomeLocParser genomeLocParser = new GenomeLocParser(reference.getSequenceDictionary());

		map = new GenomicMap(10000);
		map.read(genomeLocParser,MAP_FILE);
		System.out.println("Map loaded successfully: "+map.size()+" contigs");
				
		
		writer = new SAMFileWriterFactory().makeSAMOrBAMWriter(h, true, OUT);
		
		for ( SAMRecord read : reader ) {
			
			
			if ( map.remapToMasterReference(read,h,true) == null ) {
				badRecords++;
				continue;
			}
			if ( AlignmentUtils.isReadUnmapped(read) ) totalUnmappedReads++;

            // destroy mate pair mapping information, if any (we will need to reconstitute pairs after remapping both ends):
            read.setMateReferenceIndex(SAMRecord.NO_ALIGNMENT_REFERENCE_INDEX);
            read.setMateAlignmentStart(SAMRecord.NO_ALIGNMENT_START);
//				if ( read.getReadPairedFlag() ) System.out.println("PAIRED READ!!");

			totalRecords++;
			
			if ( totalRecords % 1000000 == 0 ) System.out.println(totalRecords + " valid records processed");
			

			if ( ! read.getReadName().equals(lastReadName) ) {
				totalReads++;
				lastReadName = read.getReadName();
			
						
				if ( REDUCE ) {
					
					updateCountsAndQuals(remappedReads);
					
					for ( SAMRecord r : remappedReads ) {
						writer.addAlignment(r); // emit non-redundant alignments for previous query
						writtenRecords++;
					}
					remappedReads.clear(); 
				}
			} 
			if ( REDUCE ) remappedReads.add(read); 
			else {
				writer.addAlignment(read);
				writtenRecords++;
			}
		}

		// write remaining bunch of reads:
		if ( REDUCE ) {
			updateCountsAndQuals(remappedReads);
			for ( SAMRecord r : remappedReads ) {
				writer.addAlignment(r); // emit non-redundant alignments for previous query
				writtenRecords++;
			}
		}
		
		System.out.println("Total valid records processed: "+totalRecords);
		System.out.println("Incorrect records (alignments across contig boundary) detected: "+badRecords + 
				" (discarded and excluded from any other stats)");
		System.out.println("Total reads processed: "+totalReads);
		System.out.println("Total mapped reads: "+(totalReads-totalUnmappedReads));
		System.out.println("Average hits per mapped read: "+((double)(totalRecords-totalUnmappedReads))/(totalReads-totalUnmappedReads));
		System.out.println("Records written: "+writtenRecords);
		System.out.println("Average hits per mapped read written (after reduction): "
				+((double)(writtenRecords-totalUnmappedReads))/(totalReads-totalUnmappedReads));
		reader.close();
		writer.close();
		return 0;
	}
	
    class AlignmentComparator implements Comparator<SAMRecord> {

    	public int compare(SAMRecord r1, SAMRecord r2) {
    		if ( r1.getReferenceIndex() < r2.getReferenceIndex() ) return -1; 
    		if ( r1.getReferenceIndex() > r2.getReferenceIndex() ) return  1;
    		if ( r1.getAlignmentStart() < r2.getAlignmentStart() ) return -1;
    		if ( r1.getAlignmentStart() > r2.getAlignmentStart() ) return 1;
    		return r1.getCigarString().compareTo(r2.getCigarString());
    	}
    	
    }

    private void updateCountsAndQuals(Set<SAMRecord> reads) {
    	if ( reads.size() == 1 ) {
    		SAMRecord r = reads.iterator().next();
 
        	// technically, if edit distance of the read is equal to max_diff used in alignments, 
        	// we should have set 25... 
                if ( AlignmentUtils.isReadUnmapped(r) ) {
                    r.setMappingQuality(0);
                } else {
                    r.setMappingQuality(37);
                    r.setAttribute("X0", Integer.valueOf(1));
                    r.setAttribute("X1", Integer.valueOf(0));
                }
    		r.setNotPrimaryAlignmentFlag(false);
    		
    	} else {
    		
    		// we have multiple alignments for the read
    		// need to figure out how many best vs inferior alignments are there:
    		int minNM = 1000000;
    		int cnt = 0; // count of best alignments
            Iterator<SAMRecord> it = reads.iterator();
            int n = reads.size(); // total number of (alternative) alignments for the given read.
            boolean canComputeMapQ = true;
    		while ( it.hasNext() ) {
                SAMRecord r = it.next();
                if ( AlignmentUtils.isReadUnmapped(r) && n > 1) {
                    // we do not want to keep unmapped records in the set unless it's the last and only record!
                    it.remove();
                    n--; // one less alignment left in the current group of alignments
                    continue;
                }
                if ( ! canComputeMapQ ) continue; // some reads were missing NM attribute, so do not bother - we can not compute MapQ
                Object attr = r.getAttribute("NM");
                if ( attr == null ) {
                    canComputeMapQ = false; // can not recompute qualities!
                    continue;
                } else {
    			    int nm;
                    if ( attr instanceof Short ) nm = ((Short)attr).intValue();
                    else if ( attr instanceof Integer ) nm = ((Integer)attr).intValue();
                    else throw new RuntimeException("NM attribute is neither Short nor Integer, don't know what to do.");
    			    if ( nm < minNM  ) {
    				    minNM = nm;
    				    cnt = 1;
    			    } else if ( nm == minNM ) cnt++;
                }
    		}

            if ( n == 1 ) {
                SAMRecord r = reads.iterator().next() ;
                if (AlignmentUtils.isReadUnmapped(r) ) {
                // special case: we are left with a single unmapped alignment
                    r.setAttribute("X0", new Integer(0));
                    r.setAttribute("X1", new Integer(0));
                    return;
                }
            }

    		// now reset counts of available alignments and mapping quals (if we can) in every alignment record:
    		for ( SAMRecord r : reads ) {
    			
    			int cnt2 = reads.size() - cnt; // count of inferior alignments
    			
    	   		r.setAttribute("X0", new Integer(cnt));   
        		r.setAttribute("X1", new Integer(cnt2));

                if ( ! canComputeMapQ ) continue; // not all reads had NM field, so we can not recompute MapQ

        		if ( cnt2 > 255 ) cnt2 = 255; // otherwise we will be out of bounds in g_log_n

                int nm_attr;
                Object attr =  r.getAttribute("NM");
                if ( attr instanceof Short ) nm_attr = ((Short)attr).intValue();
                else if ( attr instanceof Integer ) nm_attr = ((Integer)attr).intValue();
                else throw new RuntimeException("NM attribute is neither Short nor Integer, don't know what to do.");
    			if ( nm_attr == minNM ) { 
    				
    				// one of the best alignments:

    				r.setNotPrimaryAlignmentFlag(false);
    				if ( cnt == 1 ) {    					
    					// single best alignment; additional inferior alignments will only affect mapping qual
    					r.setMappingQuality( 23 < g_log_n[cnt2] ? 0 : 23 - g_log_n[cnt2] ); // this recipe for Q is copied from bwa
    				} else {
    					r.setMappingQuality(0); // multiple best alignments - mapping quality is 0
    				}
    			} else {
    				
    				// secondary alignment ( we know we hold a better one)
    				r.setNotPrimaryAlignmentFlag(true);
    				r.setMappingQuality(0); // ??? should we set 0 for secondary??
    			}
    		}
    	}
    	
    }
    
/*    
    private int bwa_approx_mapQ(SAMRecord r, int max_diff) {
    	int c1 = (Integer)r.getExtendedAttribute("X0");
    	int c2 = (Integer)r.getExtendedAttribute("X1");
    	int mm = (Integer)r.getExtendedAttribute("NM");
    	if ( c1 > 0 ) return 0;
    	if ( c1 == 0 ) return 23;
    	if ( mm == max_diff ) return 25;
    	return 0;
    }
*/
}


