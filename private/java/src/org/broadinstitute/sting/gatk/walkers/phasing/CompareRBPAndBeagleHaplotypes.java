package org.broadinstitute.sting.gatk.walkers.phasing;

import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Input;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.commandline.RodBinding;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.RodWalker;
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.variantcontext.Genotype;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;
import org.broadinstitute.sting.utils.variantcontext.VariantContextUtils;

import java.io.PrintStream;
import java.util.ArrayList;

public class CompareRBPAndBeagleHaplotypes extends RodWalker<Integer, Integer> {
    @Output
    public PrintStream out;

    @Argument(fullName="sample", shortName="sn", doc="Sample to compare", required=false)
    public String sample;

    @Input(fullName="rbp", doc="RBP VCF file", required=true)
    public RodBinding<VariantContext> rbpVCF;

    @Input(fullName="beagle", doc="Beagle VCF file", required=true)
    public RodBinding<VariantContext> beagleVCF;

    private ArrayList<VariantContext> rbpHaplotype = new ArrayList<VariantContext>();
    private ArrayList<VariantContext> beagleHaplotype = new ArrayList<VariantContext>();

    public void printHaplotypes(ArrayList<VariantContext> rbpHaplotype, ArrayList<VariantContext> beagleHaplotype, String sample) {
        if (rbpHaplotype.size() > 0) {
            out.print("\n   rbp:");
            for (int i = 0; i < rbpHaplotype.size(); i++) {
                Genotype rbpg = rbpHaplotype.get(i).getGenotype(sample);
                String allele1 = rbpg.getAllele(0).getDisplayString();
                out.print(" " + allele1 + " ");
            }

            out.print("\n   rbp:");
            for (int i = 0; i < rbpHaplotype.size(); i++) {
                Genotype rbpg = rbpHaplotype.get(i).getGenotype(sample);
                String allele2 = rbpg.getAlleles().size() == 1 ? rbpg.getAllele(0).getDisplayString() : rbpg.getAllele(1).getDisplayString();
                out.print(" " + allele2 + " ");
            }
            out.println();

            out.print("\nbeagle:");
            for (int i = 0; i < beagleHaplotype.size(); i++) {
                Genotype beagleg = beagleHaplotype.get(i).getGenotype(sample);
                String allele1 = beagleg.getAllele(0).getDisplayString();
                out.print(" " + allele1 + " ");
            }

            out.print("\nbeagle:");
            for (int i = 0; i < beagleHaplotype.size(); i++) {
                Genotype beagleg = beagleHaplotype.get(i).getGenotype(sample);
                String allele2 = beagleg.getAlleles().size() == 1 ? beagleg.getAllele(0).getDisplayString() : beagleg.getAllele(1).getDisplayString();
                out.print(" " + allele2 + " ");
            }
            out.println();
            out.println();
        }
    }

    public void printHaplotypeMetrics(ArrayList<VariantContext> rbpHaplotype, ArrayList<VariantContext> beagleHaplotype, String sample) {
        if (rbpHaplotype.size() > 0) {
            int haplotypeLength = rbpHaplotype.size();
            int genotypeMatches = 0;
            int genotypesWithPQ = 0;
            double minPQ = 10000.0;
            double maxPQ = -10000.0;
            double sumPQ = 0.0;
            double meanPQ = 0.0;
            double pctHaplotypeIdentity = 0.0;
            GenomeLoc start = null;

            for (VariantContext vc : rbpHaplotype) {
                if (vc.getGenotype(sample).hasExtendedAttribute("PQ")) {
                    if (start == null) {
                        start = VariantContextUtils.getLocation(this.getToolkit().getGenomeLocParser(), vc);

                    }
                    double PQ = vc.getGenotype(sample).getAttributeAsDouble("PQ", -1);

                    if (PQ < minPQ) { minPQ = PQ; }
                    if (PQ > maxPQ) { maxPQ = PQ; }
                    sumPQ += PQ;

                    genotypesWithPQ++;
                }
            }

            for (int i = 0; i < rbpHaplotype.size(); i++) {
                Genotype rbpg = rbpHaplotype.get(i).getGenotype(sample);
                Genotype beagleg = beagleHaplotype.get(i).getGenotype(sample);

                if (rbpg.sameGenotype(beagleg, false)) {
                    genotypeMatches++;
                }
            }

            meanPQ = sumPQ / (double) haplotypeLength;
            pctHaplotypeIdentity = 100.0 * ((double) genotypeMatches) / ((double) haplotypeLength);

            out.printf("loc= %s minPQ= %.2f maxPQ= %.2f meanPQ= %.2f genotypesWithPQ= %d haplotypeLength= %d genotypeMatches= %d haplotypeIdentity= %.2f%n",
                    start,
                    minPQ,
                    maxPQ,
                    meanPQ,
                    genotypesWithPQ,
                    haplotypeLength,
                    genotypeMatches,
                    pctHaplotypeIdentity
            );
        }
    }

    @Override
    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        if (tracker != null) {
            VariantContext rbp = tracker.getFirstValue(rbpVCF, ref.getLocus());
            VariantContext beagle = tracker.getFirstValue(beagleVCF, ref.getLocus());

            if (rbp != null && beagle != null) {
                Genotype rbpg = rbp.getGenotype(sample);
                Genotype beagleg = beagle.getGenotype(sample);

                if (!rbpg.isPhased()) {
                    printHaplotypes(rbpHaplotype, beagleHaplotype, sample);
                    printHaplotypeMetrics(rbpHaplotype, beagleHaplotype, sample);

                    rbpHaplotype.clear();
                    beagleHaplotype.clear();
                }

                if (!(rbpg.isHom() && beagleg.isHom() && rbpg.sameGenotype(beagleg)) && rbpg.hasExtendedAttribute("PQ") && rbpg.sameGenotype(beagleg)) {
                    rbpHaplotype.add(rbp);
                    beagleHaplotype.add(beagle);
                }
            }
        }

        return null;
    }

    @Override
    public Integer reduceInit() {
        return null;
    }

    @Override
    public Integer reduce(Integer value, Integer sum) {
        return null;
    }
}
