package org.broadinstitute.sting.walkers;

import org.broadinstitute.sting.utils.variantcontext.VariantContext;
import org.broadinstitute.sting.utils.codecs.vcf.StandardVCFWriter;
import org.broadinstitute.sting.utils.codecs.vcf.VCFHeader;
import org.broadinstitute.sting.utils.codecs.vcf.VCFHeaderLine;
import org.broadinstitute.sting.utils.codecs.vcf.VCFWriter;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.utils.variantcontext.VariantContextUtils;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.refdata.VariantContextAdaptors;
import org.broadinstitute.sting.gatk.walkers.Reference;
import org.broadinstitute.sting.gatk.walkers.RodWalker;
import org.broadinstitute.sting.gatk.walkers.Window;
import org.broadinstitute.sting.utils.GenomeLocParser;
import org.broadinstitute.sting.utils.SampleUtils;
import org.broadinstitute.sting.utils.collections.ExpandingArrayList;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.codecs.vcf.VCFUtils;

import java.io.PrintStream;
import java.util.*;

/**
 * IF THERE IS NO JAVADOC RIGHT HERE, YELL AT chartl
 *
 * @Author chartl
 * @Date Apr 21, 2010
 */
@Reference(window=@Window(start=-40,stop=40))
public class IndelDBRateWalker extends RodWalker<OverlapTable,OverlapTabulator> {
    @Output
    PrintStream out;
    @Argument(fullName="indelWindow",doc="size of the window in which to look for indels; max 40",required=false)
    int indelWindow = 10;
    @Argument(fullName="writeVCF",doc="Writes \"overlapping\" variants to this vcf",required=false)
    PrintStream outVCF;

    VCFWriter vcfWriter;

    private List<VariantContext> compContexts = new ArrayList<VariantContext>(50); // not going to be more than 50 contexts in a size-40 window
    private List<VariantContext> evalContexts = new ArrayList<VariantContext>(50);

    public void initialize() {
        if ( indelWindow > 40 ) {
            throw new UserException.CommandLineException("Indel windows have a maximum size of 40");
        }

        if ( outVCF != null ) {
            vcfWriter = new StandardVCFWriter(outVCF);
            Set<VCFHeaderLine> header = new HashSet<VCFHeaderLine>();
            header.addAll(VCFUtils.getHeaderFields(getToolkit()));
            VCFHeader vcfHeader = new VCFHeader(header, SampleUtils.getUniqueSamplesFromRods(getToolkit()));
            vcfWriter.writeHeader(vcfHeader);
        }
    }

    public OverlapTabulator reduceInit() {
        return new OverlapTabulator();
    }

    public OverlapTabulator reduce(OverlapTable oTable, OverlapTabulator tabulator) {
        if ( oTable != null ) {
            tabulator.update(oTable);
        }

        return tabulator;
    }

    private void finalUpdate(OverlapTabulator tab) {
        while ( ! evalContexts.isEmpty() ) {
            tab.update(emptyOverlapTable(getToolkit().getGenomeLocParser()));
        }
    }

    public void onTraversalDone(OverlapTabulator tabulation) {
        finalUpdate(tabulation);
        out.printf("%s\t%s\t%s\t%s\t%s%n","Num_eval_sites","Num_comp_within_2bp","Num_comp_within_4bp","Num_comp_within_window","Total_comp_%");
        out.printf("%s",tabulation.tabulateString());
    }

    public OverlapTable map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        // step 1: get the eval and compare contexts
        if ( tracker == null ) {
            return null;
        }
        Object eval = tracker.getReferenceMetaData("eval") != null &&
                      tracker.getReferenceMetaData("eval").size() != 0 ? tracker.getReferenceMetaData("eval").get(0) : null ;
        VariantContext evalContext;
        if ( eval != null ) {
            evalContext = VariantContextAdaptors.toVariantContext("eval",eval,ref);
        } else {
            evalContext = null;
        }

        Object comp = tracker.getReferenceMetaData("comp") != null &&
                      tracker.getReferenceMetaData("comp").size() != 0 ? tracker.getReferenceMetaData("comp").get(0) : null;
        VariantContext compContext;
        if ( comp != null ) {
            compContext = VariantContextAdaptors.toVariantContext("comp",comp, ref);
        } else {
            compContext = null;
        }
        // step 2: add indel contexts to the queue
        addToQueue(compContexts,compContext);
        addToQueue(evalContexts,evalContext);
        // step 3: check to see if we have exceeded the window size for the top eval contexts of the queue
        // and do the work
        return getOverlapTable(ref);
    }

    public void addToQueue(List<VariantContext> queue, VariantContext con) {
        if ( con != null && con.isIndel() ) {
            queue.add(con);
        }
    }

    public OverlapTable getOverlapTable(ReferenceContext ref) {
        // step 1: check that the eval queue is non-empty and that we are outside the window
        if ( evalContexts.isEmpty() || VariantContextUtils.getLocation(ref.getGenomeLocParser(),evalContexts.get(0)).distance(ref.getLocus()) <= indelWindow ) {
            return null;
        }
        // step 2: discard all comp variations which come before the window
        while ( ! compContexts.isEmpty() && VariantContextUtils.getLocation(ref.getGenomeLocParser(),compContexts.get(0)).isBefore(ref.getLocus()) &&
                VariantContextUtils.getLocation(ref.getGenomeLocParser(),compContexts.get(0)).distance(ref.getLocus()) > indelWindow) {
            compContexts.remove(0);
        }
        // step 3: see if there are any contexts left; if so then they must be within the window
        if ( ! compContexts.isEmpty() ) {
            return nonEmptyOverlapTable(ref);
        } else {
            return emptyOverlapTable(ref.getGenomeLocParser());
        }
    }

    public OverlapTable emptyOverlapTable(GenomeLocParser genomeLocParser) {
        // only eval, no comp
        OverlapTable ot = new OverlapTable(genomeLocParser);
        ot.setEvalSizeAndType(evalContexts.get(0));
        return ot;
    }

    public OverlapTable nonEmptyOverlapTable(ReferenceContext ref) {
        if ( vcfWriter != null ) {
            int i = 0;
            while ( i < compContexts.size() && VariantContextUtils.getLocation(ref.getGenomeLocParser(),compContexts.get(i)).isBefore(VariantContextUtils.getLocation(ref.getGenomeLocParser(),evalContexts.get(0)))) {
                vcfWriter.add(compContexts.get(i),compContexts.get(i).getReference().getBases()[0]);
                i++;
            }
            vcfWriter.add(evalContexts.get(0), ref.getBase());
            while ( i < compContexts.size() && VariantContextUtils.getLocation(ref.getGenomeLocParser(),compContexts.get(i)).distance(VariantContextUtils.getLocation(ref.getGenomeLocParser(),evalContexts.get(0))) <= indelWindow) {
                vcfWriter.add(compContexts.get(i), compContexts.get(i).getReference().getBases()[0]);
                i++;
            }
        }
        OverlapTable ot = new OverlapTable(ref.getGenomeLocParser());
        ot.setCompOverlaps(compContexts.size());
        ot.setDistances(compContexts,evalContexts.get(0), indelWindow);
        return ot;
    }


}
class OverlapTable {
    private GenomeLocParser genomeLocParser;

    private int numOverlaps;
    private ExpandingArrayList<Integer> distances; // currently unused
    private int evalSize;
    private boolean isDeletion;

    public OverlapTable(GenomeLocParser genomeLocParser) {
        this.genomeLocParser = genomeLocParser;
        numOverlaps = 0;
    }

    public void setEvalSizeAndType(VariantContext context) {
        int size = context.getAlternateAllele(0).length();
        evalSize = size;
        isDeletion = context.isDeletion();
    }

    public void setCompOverlaps(int overlaps) {
        numOverlaps = overlaps;
    }

    public void setDistances(List<VariantContext> comps, VariantContext eval, int winsize) {
        distances = new ExpandingArrayList<Integer>();
        for ( VariantContext comp : comps ) {
            if ( VariantContextUtils.getLocation(genomeLocParser,comp).distance(VariantContextUtils.getLocation(genomeLocParser,eval)) <= winsize ) {
                distances.add(VariantContextUtils.getLocation(genomeLocParser,comp).distance(VariantContextUtils.getLocation(genomeLocParser,eval)));
            }
        }
    }

    public int getNumOverlaps() {
        return numOverlaps;
    }

    public int getSize() {
        return evalSize;
    }

    public boolean isDeletion() {
        return isDeletion;
    }

    public ExpandingArrayList<Integer> getDistances() {
        return distances;
    }
}

class OverlapTabulator {
    HashMap<Integer,Long> hitsToCounts;
    int totalEvalVariants;

    public OverlapTabulator() {
        hitsToCounts = new HashMap<Integer,Long>();
        totalEvalVariants = 0;
    }

    public void update(OverlapTable table) {
        totalEvalVariants++;
        if ( table.getNumOverlaps() != 0 ) {
            if ( hitsToCounts.containsKey(table.getNumOverlaps()) ) {
                hitsToCounts.put(table.getNumOverlaps(),hitsToCounts.get(table.getNumOverlaps())+1);
            } else {
                hitsToCounts.put(table.getNumOverlaps(),1l);
            }
        }
    }

    public String tabulateString() {
        StringBuffer sb = new StringBuffer();
        sb.append(totalEvalVariants);
        sb.append("\t");
        long lt2counts = 0l;
        long lt4counts = 0l;
        long totalCounts = 0l;
        for ( int i = 0; i < 40; i ++ ) {
            long counts = 0;
            if ( hitsToCounts.containsKey(i) ) {
                counts = hitsToCounts.get(i);
            }
            if ( i <= 2 ) {
                lt2counts += counts;
            }
            if ( i <= 4 ) {
                lt4counts += counts;
            }
            totalCounts += counts;
        }
        sb.append(lt2counts);
        sb.append("\t");
        sb.append(lt4counts);
        sb.append("\t");
        sb.append(totalCounts);
        sb.append("\t");
        sb.append(String.format("%.2f", 100*( (double) totalCounts)/( (double) totalEvalVariants)));
        return sb.toString();
    }
}
