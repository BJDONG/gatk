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

package org.broadinstitute.sting.gatk.walkers.HLAcaller;

import net.sf.samtools.SAMRecord;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.LocusWalker;
import org.broadinstitute.sting.gatk.walkers.genotyper.DiploidSNPGenotypeLikelihoods;
import org.broadinstitute.variant.utils.BaseUtils;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.genotype.DiploidGenotype;
import org.broadinstitute.sting.utils.pileup.PileupElement;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Calculates the probability of observing data for each genotype at every position. NOTE: run FindClosestAllele first to create .filter file. Usage: java -jar GenomeAnalysisTK.jar -T CalculateBaseLikelihoods -I INPUT.bam -R /broad/1KG/reference/human_b36_both.fasta -L /humgen/gsa-scr1/GSA/sjia/454_HLA/HAPMAP270/HLA_exons.interval [-filter INPUT.filter -minAllowedMismatches 7] | grep -v "INFO" | grep -v "MISALIGNED" > OUTPUT.baselikelihoods
 * @author shermanjia
 */
public class CalculateBaseLikelihoodsWalker extends LocusWalker<Integer, Pair<Long, Long>> {
    @Output
    public PrintStream out;

    @Argument(fullName = "debugHLA", shortName = "debugHLA", doc = "Print debug", required = false)
    public boolean DEBUG = false;
    @Argument(fullName = "debugAlleles", shortName = "debugAlleles", doc = "Print likelihood scores for these alleles", required = false)
    public String inputAlleles = "";
    @Argument(fullName = "filter", shortName = "filter", doc = "file containing reads to exclude", required = false)
    public String filterFile = "";
    @Argument(fullName = "maxAllowedMismatches", shortName = "maxAllowedMismatches", doc = "Max number of mismatches tolerated per read (default 7)", required = false)
    public int MAXALLOWEDMISMATCHES = 6;
    @Argument(fullName = "minRequiredMatches", shortName = "minRequiredMatches", doc = "Min number of matches required per read (default 7)", required = false)
    public int MINREQUIREDMATCHES = 0;

    int[][] LOD, LikelihoodScores;
    ArrayList<String> ReadsToDiscard = new ArrayList<String>();

    ArrayList<SAMRecord> AllReads = new ArrayList<SAMRecord>();
    ArrayList<String> AllReadNames = new ArrayList<String>();

    boolean dataLoaded = false;


    //Loads reads to filter
    public Pair<Long, Long> reduceInit() {
        if (!dataLoaded){
            dataLoaded = true;
            
            if (!filterFile.equals("")){
                out.printf("INFO  Reading properties file ... ");
                SimilarityFileReader similarityReader = new SimilarityFileReader();
                similarityReader.ReadFile(filterFile,MAXALLOWEDMISMATCHES,MINREQUIREDMATCHES);
                ReadsToDiscard = similarityReader.GetReadsToDiscard();
                out.printf("Done! Found %s misaligned reads to discard.\n",ReadsToDiscard.size());
                for (int i = 0; i < ReadsToDiscard.size(); i++){
                    out.printf("MISALIGNED %s\n", ReadsToDiscard.get(i).toString());
                }
            }
        }
        return new Pair<Long,Long>(0l,0l);
    }



    private void InitializeVariables(int n){
        LOD = new int[n][n];
        LikelihoodScores = new int[n][n];
        for (int i = 0; i < n; i++){

            for (int j = 0; j <n; j++){
                LOD[i][j]=0;
                LikelihoodScores[i][j]=0;
            }
        }
    }

    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {

        if(context.size() > 0 ) {

            int numAs = 0, numCs = 0, numGs = 0, numTs = 0;
            //if (DEBUG){
                out.printf("%s\t%s\t", context.getLocation(),(char)ref.getBase());
            //}

            //Calculate posterior probabilities
            DiploidSNPGenotypeLikelihoods G = new DiploidSNPGenotypeLikelihoods();


            for ( PileupElement p : context.getBasePileup() ) {
                byte base = p.getBase();
                if (!ReadsToDiscard.contains(p.getRead().getReadName()) && BaseUtils.simpleBaseToBaseIndex(base) != -1) {
                    G.add(p, true, false, 0);
                    //if (DEBUG){
                        if (base == 'A'){numAs++;}
                        else if (base == 'C'){numCs++;}
                        else if (base == 'T'){numTs++;}
                        else if (base == 'G'){numGs++;}
                    //}

                }
            }
            //if (DEBUG) {
                out.printf("A[%s]C[%s]T[%s]G[%s]",numAs,numCs,numTs,numGs);
                for ( DiploidGenotype g : DiploidGenotype.values() ) {
                    out.printf("\t%.2f",G.getLikelihood(g));
                }
                out.printf("\n");
            //}
            
        }
        return context.size();
    }

    public Pair<Long, Long> reduce(Integer value, Pair<Long, Long> sum) {
        long left = value.longValue() + sum.getFirst();
        long right = sum.getSecond() + 1l;
        return new Pair<Long,Long>(left, right);
    }

    public void onTraversalDone(Pair<Long, Long> result) {
        
    }
}
