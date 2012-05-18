/*
 * Copyright (c) 2011, The Broad Institute
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.broadinstitute.sting.gatk.walkers.phasing;

import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Input;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.commandline.RodBinding;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.report.GATKReport;
import org.broadinstitute.sting.gatk.report.GATKReportTable;
import org.broadinstitute.sting.gatk.walkers.RodWalker;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.variantcontext.Genotype;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;

import java.io.PrintStream;
import java.util.Collection;

public class DumpRBPAnalysisTable extends RodWalker<Integer, Integer> {

    @Input(fullName="truth", shortName = "truth", doc="", required=false)
    public RodBinding<VariantContext> truth_bind;
    @Input(fullName="rbp00s", shortName = "rbp00s", doc="", required=false)
    public RodBinding<VariantContext> rbp00s_bind;
    @Input(fullName="rbp01s", shortName = "rbp01s", doc="", required=false)
    public RodBinding<VariantContext> rbp01s_bind;
    @Input(fullName="rbp10s", shortName = "rbp10s", doc="", required=false)
    public RodBinding<VariantContext> rbp10s_bind;
    @Input(fullName="rbp11s", shortName = "rbp11s", doc="", required=false)
    public RodBinding<VariantContext> rbp11s_bind;
    @Input(fullName="beagle00s", shortName = "beagle00s", doc="", required=false)
    public RodBinding<VariantContext> beagle00s_bind;
    @Input(fullName="beagle01s", shortName = "beagle01s", doc="", required=false)
    public RodBinding<VariantContext> beagle01s_bind;
    @Input(fullName="beagle10s", shortName = "beagle10s", doc="", required=false)
    public RodBinding<VariantContext> beagle10s_bind;
    @Input(fullName="beagle11s", shortName = "beagle11s", doc="", required=false)
    public RodBinding<VariantContext> beagle11s_bind;

    @Output
    public PrintStream out;

    @Argument(fullName="sample", shortName="sn", doc="Sample name to extract", required=true)
    public String SAMPLE;

    private String tableName;
    private GATKReport report;

    public void initialize() {
        tableName = "RBPResults." + SAMPLE;

        report = new GATKReport();
        report.addTable(tableName, "RBP results for " + SAMPLE, 61);

        GATKReportTable rbpTable = report.getTable(tableName);
        rbpTable.addColumn("sample");
        rbpTable.addColumn("chr");
        rbpTable.addColumn("start");
        rbpTable.addColumn("id");
        rbpTable.addColumn("ref");
        rbpTable.addColumn("alt");

        rbpTable.addColumn("truth.GT");
        rbpTable.addColumn("truth.AC");
        rbpTable.addColumn("truth.AN");
        rbpTable.addColumn("truth.AF");
        rbpTable.addColumn("truth.GQ");
        rbpTable.addColumn("truth.DP");
        rbpTable.addColumn("truth.TP");

        rbpTable.addColumn("rbp00.GT");
        rbpTable.addColumn("rbp00.AC");
        rbpTable.addColumn("rbp00.AN");
        rbpTable.addColumn("rbp00.AF");
        rbpTable.addColumn("rbp00.GQ");
        rbpTable.addColumn("rbp00.DP");
        rbpTable.addColumn("rbp00.PQ");

        rbpTable.addColumn("rbp01.GT");
        rbpTable.addColumn("rbp01.AC");
        rbpTable.addColumn("rbp01.AN");
        rbpTable.addColumn("rbp01.AF");
        rbpTable.addColumn("rbp01.GQ");
        rbpTable.addColumn("rbp01.DP");
        rbpTable.addColumn("rbp01.PQ");

        rbpTable.addColumn("rbp10.GT");
        rbpTable.addColumn("rbp10.AC");
        rbpTable.addColumn("rbp10.AN");
        rbpTable.addColumn("rbp10.AF");
        rbpTable.addColumn("rbp10.GQ");
        rbpTable.addColumn("rbp10.DP");
        rbpTable.addColumn("rbp10.PQ");

        rbpTable.addColumn("rbp11.GT");
        rbpTable.addColumn("rbp11.AC");
        rbpTable.addColumn("rbp11.AN");
        rbpTable.addColumn("rbp11.AF");
        rbpTable.addColumn("rbp11.GQ");
        rbpTable.addColumn("rbp11.DP");
        rbpTable.addColumn("rbp11.PQ");

        rbpTable.addColumn("beagle00.GT");
        rbpTable.addColumn("beagle00.AF");
        rbpTable.addColumn("beagle00.GA");
        rbpTable.addColumn("beagle00.AR2");
        rbpTable.addColumn("beagle00.DR2");

        rbpTable.addColumn("beagle01.GT");
        rbpTable.addColumn("beagle01.AF");
        rbpTable.addColumn("beagle01.GA");
        rbpTable.addColumn("beagle01.AR2");
        rbpTable.addColumn("beagle01.DR2");

        rbpTable.addColumn("beagle10.GT");
        rbpTable.addColumn("beagle10.AF");
        rbpTable.addColumn("beagle10.GA");
        rbpTable.addColumn("beagle10.AR2");
        rbpTable.addColumn("beagle10.DR2");

        rbpTable.addColumn("beagle11.GT");
        rbpTable.addColumn("beagle11.AF");
        rbpTable.addColumn("beagle11.GA");
        rbpTable.addColumn("beagle11.AR2");
        rbpTable.addColumn("beagle11.DR2");
    }

    @Override
    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if (tracker != null) {
            Collection<VariantContext> truths = tracker.getValues(truth_bind, ref.getLocus());
            VariantContext truth = truths.iterator().hasNext() ? truths.iterator().next() : null;
            Genotype truthG = truth == null ? null : truth.getGenotype(SAMPLE);

            Collection<VariantContext> rbp00s = tracker.getValues(rbp00s_bind, ref.getLocus());
            VariantContext rbp00 = rbp00s.iterator().hasNext() ? rbp00s.iterator().next() : null;
            Genotype rbp00G = rbp00 == null ? null : rbp00.getGenotype(SAMPLE);

            Collection<VariantContext> rbp01s = tracker.getValues(rbp01s_bind, ref.getLocus());
            VariantContext rbp01 = rbp01s.iterator().hasNext() ? rbp01s.iterator().next() : null;
            Genotype rbp01G = rbp01 == null ? null : rbp01.getGenotype(SAMPLE);

            Collection<VariantContext> rbp10s = tracker.getValues(rbp10s_bind, ref.getLocus());
            VariantContext rbp10 = rbp10s.iterator().hasNext() ? rbp10s.iterator().next() : null;
            Genotype rbp10G = rbp10 == null ? null : rbp10.getGenotype(SAMPLE);

            Collection<VariantContext> rbp11s = tracker.getValues(rbp11s_bind, ref.getLocus());
            VariantContext rbp11 = rbp11s.iterator().hasNext() ? rbp11s.iterator().next() : null;
            Genotype rbp11G = rbp11 == null ? null : rbp11.getGenotype(SAMPLE);

            Collection<VariantContext> beagle00s = tracker.getValues(beagle00s_bind, ref.getLocus());
            VariantContext beagle00 = beagle00s.iterator().hasNext() ? beagle00s.iterator().next() : null;
            Genotype beagle00G = beagle00 == null ? null : beagle00.getGenotype(SAMPLE);

            Collection<VariantContext> beagle01s = tracker.getValues(beagle01s_bind, ref.getLocus());
            VariantContext beagle01 = beagle01s.iterator().hasNext() ? beagle01s.iterator().next() : null;
            Genotype beagle01G = beagle01 == null ? null : beagle01.getGenotype(SAMPLE);

            Collection<VariantContext> beagle10s = tracker.getValues(beagle10s_bind, ref.getLocus());
            VariantContext beagle10 = beagle10s.iterator().hasNext() ? beagle10s.iterator().next() : null;
            Genotype beagle10G = beagle10 == null ? null : beagle10.getGenotype(SAMPLE);

            Collection<VariantContext> beagle11s = tracker.getValues(beagle11s_bind, ref.getLocus());
            VariantContext beagle11 = beagle11s.iterator().hasNext() ? beagle11s.iterator().next() : null;
            Genotype beagle11G = beagle11 == null ? null : beagle11.getGenotype(SAMPLE);

            if (!(truthG.isHomRef() && rbp00G.isHomRef() && rbp01G.isHomRef() && rbp10G.isHomRef() && rbp11G.isHomRef() && beagle00G.isHomRef() && beagle01G.isHomRef() && beagle10G.isHomRef() && beagle11G.isHomRef())) {
                GATKReportTable rbpTable = report.getTable(tableName);
                GenomeLoc pk = ref.getLocus();
                rbpTable.set(pk, "chr", ref.getLocus().getContig());
                rbpTable.set(pk, "start", ref.getLocus().getStart());
                rbpTable.set(pk, "id", truth.getID());
                rbpTable.set(pk, "ref", truth.getReference().getBaseString());
                rbpTable.set(pk, "alt", truth.getAltAlleleWithHighestAlleleCount().getBaseString());

                rbpTable.set(pk, "truth.GT", truthG.isNoCall() ? "./." : truthG.getGenotypeString());
                rbpTable.set(pk, "truth.AC", truth.getAttribute("AC", 0));
                rbpTable.set(pk, "truth.AN", truth.getAttribute("AN", 0));
                rbpTable.set(pk, "truth.AF", truth.getAttribute("AF", 0));
                rbpTable.set(pk, "truth.GQ", truthG.getAttribute("GQ", 0.0));
                rbpTable.set(pk, "truth.DP", truthG.getAttribute("DP", 0));
                rbpTable.set(pk, "truth.TP", truthG.getAttribute("TP", 0.0));

                rbpTable.set(pk, "rbp00.GT", rbp00G.isNoCall() ? "./." : rbp00G.getGenotypeString());
                rbpTable.set(pk, "rbp00.AC", rbp00.getAttribute("AC", 0));
                rbpTable.set(pk, "rbp00.AN", rbp00.getAttribute("AN", 0));
                rbpTable.set(pk, "rbp00.AF", rbp00.getAttribute("AF", 0));
                rbpTable.set(pk, "rbp00.GQ", rbp00G.getAttribute("GQ", 0.0));
                rbpTable.set(pk, "rbp00.DP", rbp00G.getAttribute("DP", 0));
                rbpTable.set(pk, "rbp00.PQ", rbp00G.getAttribute("PQ", 0.0));

                rbpTable.set(pk, "rbp01.GT", rbp01G.isNoCall() ? "./." : rbp01G.getGenotypeString());
                rbpTable.set(pk, "rbp01.AC", rbp01.getAttribute("AC", 0));
                rbpTable.set(pk, "rbp01.AN", rbp01.getAttribute("AN", 0));
                rbpTable.set(pk, "rbp01.AF", rbp01.getAttribute("AF", 0));
                rbpTable.set(pk, "rbp01.GQ", rbp01G.getAttribute("GQ", 0.0));
                rbpTable.set(pk, "rbp01.DP", rbp01G.getAttribute("DP", 0));
                rbpTable.set(pk, "rbp01.PQ", rbp01G.getAttribute("PQ", 0.0));

                rbpTable.set(pk, "rbp10.GT", rbp10G.isNoCall() ? "./." : rbp10G.getGenotypeString());
                rbpTable.set(pk, "rbp10.AC", rbp10.getAttribute("AC", 0));
                rbpTable.set(pk, "rbp10.AN", rbp10.getAttribute("AN", 0));
                rbpTable.set(pk, "rbp10.AF", rbp10.getAttribute("AF", 0));
                rbpTable.set(pk, "rbp10.GQ", rbp10G.getAttribute("GQ", 0.0));
                rbpTable.set(pk, "rbp10.DP", rbp10G.getAttribute("DP", 0));
                rbpTable.set(pk, "rbp10.PQ", rbp10G.getAttribute("PQ", 0.0));

                rbpTable.set(pk, "rbp11.GT", rbp11G.isNoCall() ? "./." : rbp11G.getGenotypeString());
                rbpTable.set(pk, "rbp11.AC", rbp11.getAttribute("AC", 0));
                rbpTable.set(pk, "rbp11.AN", rbp11.getAttribute("AN", 0));
                rbpTable.set(pk, "rbp11.AF", rbp11.getAttribute("AF", 0));
                rbpTable.set(pk, "rbp11.GQ", rbp11G.getAttribute("GQ", 0.0));
                rbpTable.set(pk, "rbp11.DP", rbp11G.getAttribute("DP", 0));
                rbpTable.set(pk, "rbp11.PQ", rbp11G.getAttribute("PQ", 0.0));

                rbpTable.set(pk, "beagle00.GT", beagle00G.isNoCall() ? "./." : beagle00G.getGenotypeString());
                rbpTable.set(pk, "beagle00.AF", beagle00.getAttribute("AF", 0));
                rbpTable.set(pk, "beagle00.GA", beagle00.getAttribute("GA", 0.0));
                rbpTable.set(pk, "beagle00.AR2", beagle00.getAttribute("AR2", 0));
                rbpTable.set(pk, "beagle00.DR2", beagle00.getAttribute("DR2", 0.0));

                rbpTable.set(pk, "beagle01.GT", beagle01G.isNoCall() ? "./." : beagle01G.getGenotypeString());
                rbpTable.set(pk, "beagle01.AF", beagle01.getAttribute("AF", 0));
                rbpTable.set(pk, "beagle01.GA", beagle01.getAttribute("GA", 0.0));
                rbpTable.set(pk, "beagle01.AR2", beagle01.getAttribute("AR2", 0));
                rbpTable.set(pk, "beagle01.DR2", beagle01.getAttribute("DR2", 0.0));

                rbpTable.set(pk, "beagle10.GT", beagle10G.isNoCall() ? "./." : beagle10G.getGenotypeString());
                rbpTable.set(pk, "beagle10.AF", beagle10.getAttribute("AF", 0));
                rbpTable.set(pk, "beagle10.GA", beagle10.getAttribute("GA", 0.0));
                rbpTable.set(pk, "beagle10.AR2", beagle10.getAttribute("AR2", 0));
                rbpTable.set(pk, "beagle10.DR2", beagle10.getAttribute("DR2", 0.0));

                rbpTable.set(pk, "beagle11.GT", beagle11G.isNoCall() ? "./." : beagle11G.getGenotypeString());
                rbpTable.set(pk, "beagle11.AF", beagle11.getAttribute("AF", 0));
                rbpTable.set(pk, "beagle11.GA", beagle11.getAttribute("GA", 0.0));
                rbpTable.set(pk, "beagle11.AR2", beagle11.getAttribute("AR2", 0));
                rbpTable.set(pk, "beagle11.DR2", beagle11.getAttribute("DR2", 0.0));
            }
        }

        return null;
    }

    /**
     * Provide an initial value for reduce computations.
     *
     * @return Initial value of reduce.
     */
    @Override
    public Integer reduceInit() {
        return null;
    }

    /**
     * Reduces a single map with the accumulator provided as the ReduceType.
     *
     * @param value result of the map.
     * @param sum   accumulator for the reduce.
     * @return accumulator with result of the map taken into account.
     */
    @Override
    public Integer reduce(Integer value, Integer sum) {
        return null;
    }

    public void onTraversalDone(Integer sum) {
        report.print(out);
    }
}
