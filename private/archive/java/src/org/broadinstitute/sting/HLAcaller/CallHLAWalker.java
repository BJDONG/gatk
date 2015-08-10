/*
* By downloading the PROGRAM you agree to the following terms of use:
* 
* BROAD INSTITUTE
* SOFTWARE LICENSE AGREEMENT
* FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
* 
* This Agreement is made between the Broad Institute, Inc. with a principal address at 415 Main Street, Cambridge, MA 02142 (“BROAD”) and the LICENSEE and is effective at the date the downloading is completed (“EFFECTIVE DATE”).
* 
* WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
* WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
* NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
* 
* 1. DEFINITIONS
* 1.1 PROGRAM shall mean copyright in the object code and source code known as GATK3 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute.org/gatk on the EFFECTIVE DATE.
* 
* 2. LICENSE
* 2.1 Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. LICENSEE hereby automatically grants to BROAD a non-exclusive, royalty-free, irrevocable license to any LICENSEE bug fixes or modifications to the PROGRAM with unlimited rights to sublicense and/or distribute.  LICENSEE agrees to provide any such modifications and bug fixes to BROAD promptly upon their creation.
* The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only. For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
* 2.2 No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD. LICENSEE shall ensure that all of its users agree to the terms of this Agreement. LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
* 2.3 License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.
* 
* 3. PHONE-HOME FEATURE
* LICENSEE expressly acknowledges that the PROGRAM contains an embedded automatic reporting system (“PHONE-HOME”) which is enabled by default upon download. Unless LICENSEE requests disablement of PHONE-HOME, LICENSEE agrees that BROAD may collect limited information transmitted by PHONE-HOME regarding LICENSEE and its use of the PROGRAM.  Such information shall include LICENSEE’S user identification, version number of the PROGRAM and tools being run, mode of analysis employed, and any error reports generated during run-time.  Collection of such information is used by BROAD solely to monitor usage rates, fulfill reporting requirements to BROAD funding agencies, drive improvements to the PROGRAM, and facilitate adjustments to PROGRAM-related documentation.
* 
* 4. OWNERSHIP OF INTELLECTUAL PROPERTY
* LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies. LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
* Copyright 2012-2015 Broad Institute, Inc.
* Notice of attribution: The GATK3 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
* LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
* 
* 5. INDEMNIFICATION
* LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
* 
* 6. NO REPRESENTATIONS OR WARRANTIES
* THE PROGRAM IS DELIVERED AS IS. BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
* IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
* 
* 7. ASSIGNMENT
* This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
* 
* 8. MISCELLANEOUS
* 8.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
* 8.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
* 8.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
* 8.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested. All notices under this Agreement shall be deemed effective upon receipt.
* 8.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter.
* 8.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
* 8.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
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
import org.broadinstitute.sting.utils.GenomeLoc;
import org.broadinstitute.sting.utils.collections.Pair;
import org.broadinstitute.sting.utils.genotype.DiploidGenotype;
import org.broadinstitute.sting.utils.pileup.PileupElement;
import org.broadinstitute.sting.utils.pileup.ReadBackedPileup;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Original Call HLA walker (older). Look here for inspiration, but not for the most recent tools
 * @author shermanjia
 */
public class CallHLAWalker extends LocusWalker<Integer, Pair<Long, Long>> {
    @Output
    public PrintStream out;

    @Argument(fullName="suppressLocusPrinting",doc="Suppress printing",required=false)
    public boolean suppressPrinting = false;

    @Argument(fullName = "debugHLA", shortName = "debugHLA", doc = "Print debug", required = false)
    public boolean DEBUG = false;

    @Argument(fullName = "debugAlleles", shortName = "debugAlleles", doc = "Print likelihood scores for these alleles", required = false)
    public String inputAlleles = "";

    @Argument(fullName = "ethnicity", shortName = "ethnicity", doc = "Use allele frequencies for this ethnic group", required = false)
    public String ethnicity = "Caucasian";

    @Argument(fullName = "filter", shortName = "filter", doc = "file containing reads to exclude", required = false)
    public String filterFile = "";

    String al1 = "", al2 = "", al3 = "", al4 = "";


    //String HLAdatabaseFile = "/Users/shermanjia/Work/HLA.sam";
    //String HLAdatabaseFile ="/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA.4digitUnique.sam";
    String HLAdatabaseFile ="/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA.nuc.imputed.4digit.sam";

    //String HLAdatabaseFile ="/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA.nuc.sam";
    //String HLAdatabaseFile ="/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA.nuc.4digitUnique.sam";
    //String CaucasianAlleleFrequencyFile = "/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/CEU_Founders_HLA.freq";

    String CaucasianAlleleFrequencyFile = "/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA_CaucasiansUSA.freq";
    String BlackAlleleFrequencyFile = "/humgen/gsa-scr1/GSA/sjia/454_HLA/HLA/HLA_BlackUSA.freq";
    String AlleleFrequencyFile;


    ArrayList<String> HLAreads = new ArrayList<String>();
    ArrayList<String> HLAcigars = new ArrayList<String>();
    ArrayList<String> HLAnames = new ArrayList<String>();
    ArrayList<String> HLApositions = new ArrayList<String>();
    ArrayList<String> ReadsToFilter = new ArrayList<String>();
    
    ArrayList<SAMRecord> AllReads = new ArrayList<SAMRecord>();
    ArrayList<String> AllReadNames = new ArrayList<String>();

    int[] HLAstartpos;
    int[] HLAstoppos;
    int numHLAlleles = 0;
    int numInterval = 1;
    double[] SingleAlleleFrequencies;
    double[][] LOD; String[][] Alleles;
    double[][] LikelihoodScores;
    double[][] PhasingScores;
    double[][]PhasingProbabilities;
    double[][] CombinedAlleleFrequencies;
    int j1, k1, j2, k2;
    int iAstart = -1, iAstop = -1, iBstart = -1, iBstop = -1, iCstart = -1, iCstop = -1;
    double likelihoodsumA = 0.0, likelihoodsumB = 0.0, likelihoodsumC = 0.0;
    double inverseMaxProbA = 0.0, inverseMaxProbB = 0.0, inverseMaxProbC = 0.0;

    Hashtable AlleleFrequencies = new Hashtable();

    Hashtable Scores = new Hashtable();
    Hashtable SNPs = new Hashtable();
    ArrayList<String> SNPchars = new ArrayList<String>();
    ArrayList<Integer> SNPlocations = new ArrayList<Integer>();
    Integer SNPcount = 0;
    int[][] SNPcorrelation;
    double[][] SNPcorrelationProb;
    String[][] SNPhaplotypes;

    boolean DatabaseLoaded = false;
    boolean PrintedOutput = false;

    public Pair<Long, Long> reduceInit() {

        if (!DatabaseLoaded){
            try{
                //Load sequences corresponding to HLA alleles from sam file
                if (!inputAlleles.equals("")){
                    String[] str = inputAlleles.split(",");
                    al1 = str[0];
                    al2 = str[1];
                    al3 = str[2];
                    al4 = str[3];
                }

                //set ethnic group to look up allele frequencies
                if (ethnicity.equals("Black")){
                    AlleleFrequencyFile = BlackAlleleFrequencyFile;
                }else{
                    AlleleFrequencyFile = CaucasianAlleleFrequencyFile;
                }

                out.printf("Reading HLA database ...");
                FileInputStream fstream = new FileInputStream(HLAdatabaseFile);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine; String [] s = null;
                //Read File Line By Line
                int i = 0;
                while ((strLine = br.readLine()) != null)   {
                    s = strLine.split("\\t");
                    if (s.length>=10){
                        //Parse the reads with cigar parser
                        HLAreads.add(CigarFormatted(s[5],s[9]));
                        HLAcigars.add(s[5]);
                        HLAnames.add(s[0]);
                        HLApositions.add(s[3]);
                        if (s[0].indexOf("HLA_A") > -1){
                            if (iAstart < 0){iAstart=i;}
                            iAstop = i; i++;
                        }else if (s[0].indexOf("HLA_B") > -1){
                            if (iBstart < 0){iBstart=i;}
                            iBstop = i; i++;
                        }else if (s[0].indexOf("HLA_C") > -1){
                            if (iCstart < 0){iCstart=i;}
                            iCstop = i; i++;
                        }
                    }
                }
                in.close();
                int n = HLApositions.size(); numHLAlleles = n;
                HLAstartpos = new int[n]; HLAstoppos = new int[n];
                SingleAlleleFrequencies = new double[n];
                LOD = new double[n][n];
                LikelihoodScores = new double[n][n];
                PhasingScores = new double[n][n];
                PhasingProbabilities = new double[n][n];
                CombinedAlleleFrequencies = new double[n][n];

                for (i = 0; i < n; i++){
                    //Find start and stop positions for each allele
                    HLAstartpos[i]=Integer.parseInt(HLApositions.get(i));
                    HLAstoppos[i]=HLAstartpos[i]+HLAreads.get(i).length()-1;
                    SingleAlleleFrequencies[i]=0.0;
                    //Initialize matrix of probabilities / likelihoods
                    for (int j = 0; j <n; j++){
                        LOD[i][j]=0;
                        LikelihoodScores[i][j]=0;
                        PhasingScores[i][j]=0.0;
                        PhasingProbabilities[i][j]=0;
                        CombinedAlleleFrequencies[i][j]=0.0;
                    }
                    //For debugging: get index for specific alleles
                    if (HLAnames.get(i).equals("HLA_" + al1))
                        j1 = i;
                    if (HLAnames.get(i).equals("HLA_" + al2))
                        k1 = i;
                    if (HLAnames.get(i).equals("HLA_" + al3))
                        j2 = i;
                    if (HLAnames.get(i).equals("HLA_" + al4))
                        k2 = i;
                }
                out.printf("DONE! Read %s alleles\n",HLAreads.size());
            }catch (Exception e){//Catch exception if any
              System.err.println("CallHLAWalker Error: " + e.getMessage());
            }

            try{
                out.printf("Reading allele frequences ...");
                FileInputStream fstream = new FileInputStream(AlleleFrequencyFile);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine; String [] s = null;
                //Read File Line By Line
                int count = 0;
                while ((strLine = br.readLine()) != null)   {
                    s = strLine.split("\\t");
                    AlleleFrequencies.put(s[0], s[1]);
                    count++;
                }
                in.close();
                out.printf("Done! Read %s alleles\n",count);
            }catch (Exception e){//Catch exception if any
              System.err.println("CallHLAWalker Error: " + e.getMessage());
            }

            if (!filterFile.equals("")){
                try{
                    out.printf("Reading reads to filter ...");
                    FileInputStream fstream = new FileInputStream(filterFile);
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine; String [] s = null;
                    //Read File Line By Line
                    int count = 0;
                    while ((strLine = br.readLine()) != null){
                        s = strLine.split("\\t");
                        if (Integer.valueOf(s[6]) > 10){
                            ReadsToFilter.add(s[0]);
                        }
                        count++;
                    }
                    in.close();
                    out.printf("Done! %s reads to exclude\n",count);
                }catch (Exception e){//Catch exception if any
                  System.err.println("CallHLAWalker Error: " + e.getMessage());
                }
            }
            DatabaseLoaded = true;
            out.printf("Comparing reads to database ...\n");

            //For debugging: prints which HLA alleles were indexed before
            if (j1 > k1){int tmp = k1; k1 = j1; j1 = tmp;}
            if (j2 > k2){int tmp = k2; k2 = j2; j2 = tmp;}

            if (DEBUG){
                out.printf("Astart[%s]\tAstop[%s]\tBstart[%s]\tBstop[%s]\tCstart[%s]\tCstop[%s]\tnumAlleles[%s]\n",iAstart,iAstop,iBstart,iBstop,iCstart,iCstop,numHLAlleles);
                out.printf("%s,%s\t%s,%s\n",HLAnames.get(j1),HLAnames.get(k1),HLAnames.get(j2),HLAnames.get(k2));
            }
        }
        out.printf("Computing for interval %s...\n",numInterval);
        numInterval++;
        return new Pair<Long,Long>(0l,0l);
    }



    private String CigarFormatted(String cigar, String read){
        // returns a cigar-formatted sequence (removes insertions, inserts 'D' to where deletions occur
        String formattedRead = ""; char c; String count;
        int cigarPlaceholder = 0; int subcigarLength = 0;
        int readPlaceholder = 0; int subreadLength = 0;
        
        //reads cigar string
        for (int i = 0; i < cigar.length(); i++){
            c = cigar.charAt(i);
            if (c == 'M'){
                //If reach M for match/mismatch, get number immediately preceeding 'M' and tack on that many characters to sequence
                subcigarLength = i-cigarPlaceholder;
                count = cigar.substring(cigarPlaceholder, i);
                
                subreadLength = Integer.parseInt(count);
                formattedRead = formattedRead + read.substring(readPlaceholder, readPlaceholder+subreadLength);

                //increment placeholders
                cigarPlaceholder = i+1;
                readPlaceholder = readPlaceholder + subreadLength;                
            } else if (c == 'I'){
                //***NOTE: To be modified later if needed (insertions removed here)***

                //If reaches I for insertion, get number before 'I' and skip that many characters in sequence
                count = cigar.substring(cigarPlaceholder, i);
                subreadLength = Integer.parseInt(count);

                //increment placeholders without adding inserted bases to sequence (effectively removes insertion).
                cigarPlaceholder = i+1;
                readPlaceholder = readPlaceholder + subreadLength;
            } else if (c == 'H' || c == 'S'){
                //(H = Headers or S = Soft clipped removed here)***

                //If reaches H for insertion, get number before 'H' and skip that many characters in sequence
                count = cigar.substring(cigarPlaceholder, i);
                subreadLength = Integer.parseInt(count);

                //increment cigar placeholder without adding inserted bases to sequence (effectively removes insertion).
                cigarPlaceholder = i+1;
            } else if (c == 'D'){
                //If reaches D for deletion, insert 'D' into sequence as placeholder
                count = cigar.substring(cigarPlaceholder, i);
                subreadLength = Integer.parseInt(count);

                //Add one 'D' for each deleted base
                String deletion = "";
                for (int j = 1; j <= subreadLength; j++){
                    deletion = deletion + "D";
                }

                //update placeholders
                formattedRead = formattedRead + deletion;
                cigarPlaceholder = i+1;
            }

        }
        return formattedRead;
    }

    private static int unsignedByteToInt(byte b) {
        //converts base quality from byte to int (not really needed)
        return (int) b & 0xFF;
    }

    public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        
        List<SAMRecord> reads = context.getReads();
        List<Integer> offsets = context.getOffsets();
        GenomeLoc Gloc = context.getLocation();

        //Create pileup of reads at this locus
        ReadBackedPileup pileup = context.getPileup();

        long loc = context.getPosition();
        if( context.size() > 0 ) {
            //out.printf("RG for first read: %s%n",context.getReads().get(0).getReadName());
            int numAs = 0, numCs = 0, numGs = 0, numTs = 0,depth = 0;
            String c1 = "", c2 = "";
            long pos_k = 0, pos_j = 0;
            
            //Debugging purposes: print location, reference base, pileup, and count (before quality filtering)
            if (DEBUG){
                out.printf("%s\t", context.getLocation());
                out.printf("ref=%s\t", ref.getBase());
            }

            //Calculate posterior probabilities
            DiploidSNPGenotypeLikelihoods G = new DiploidSNPGenotypeLikelihoods();

            for ( PileupElement p : context.getBasePileup() ) {
                byte base = p.getBase();
                int mapquality = p.getMappingQual();
                if (mapquality >= 5 && BaseUtils.simpleBaseToBaseIndex(base) != -1) {
                    String readname = p.getRead().getReadName();
                    if (ReadsToFilter.contains(readname)){
                        if (DEBUG){
                            out.printf("\n%s %s %s %s\n",readname,p.getRead().getAlignmentStart(),p.getRead().getAlignmentEnd(),base);
                        }
                    }else{
                        //consider base in likelihood calculations if it looks good and has high mapping score
                        G.add(p, true, false, 0);
                        if (!AllReadNames.contains(readname)){AllReadNames.add(readname); AllReads.add(p.getRead());}
                        if (base == 'A'){numAs++; depth++;}
                        else if (base == 'C'){numCs++; depth++;}
                        else if (base == 'T'){numTs++; depth++;}
                        else if (base == 'G'){numGs++; depth++;}
                    }
                }
            }

            //Debugging purposes
            if (DEBUG) {out.printf("A[%s]C[%s]T[%s]G[%s]\t",numAs,numCs,numTs,numGs);}

            if (depth > 0){
                //Store confidence scores - this is a local hash that we use to get likelihood given a particular genotype
                Scores = new Hashtable();
                Double likelihood = 0.0; double maxlikelihood = 0.0;
                for ( DiploidGenotype g : DiploidGenotype.values() ) {
                    likelihood = G.getLikelihood(g);
                    if (maxlikelihood == 0.0 || likelihood > maxlikelihood){maxlikelihood = likelihood;}
                    Scores.put(g.toString(), likelihood);
                    //also hash other combination not stored by DiploidGenotype
                    if (g.toString().equals("AC")) {
                        Scores.put("CA", likelihood);
                    } else if (g.toString().equals("AG")){
                        Scores.put("GA", likelihood);
                    } else if (g.toString().equals("AT")){
                        Scores.put("TA", likelihood);
                    } else if (g.toString().equals("CG")){
                        Scores.put("GC", likelihood);
                    } else if (g.toString().equals("CT")){
                        Scores.put("TC", likelihood);
                    } else if (g.toString().equals("GT")){
                        Scores.put("TG", likelihood);
                    }
                }

                //Get likelihood score for homozygous ref: used to normalize likelihoood scores at 0.
                String homref = String.valueOf(ref.getBaseAsChar())+String.valueOf(ref.getBaseAsChar());
                Double homreflikelihood = Double.parseDouble((String) Scores.get(homref).toString());

                //Add SNP if it is a SNP and hasn't been added before
                for ( DiploidGenotype g : DiploidGenotype.values() ) {
                    likelihood = G.getLikelihood(g);
                    if ((likelihood > homreflikelihood) && (likelihood == maxlikelihood) && (!SNPs.containsKey(Long.toString(loc)))){
                        SNPcount++;
                        SNPs.put(Long.toString(loc),SNPcount);
                        SNPlocations.add(Integer.valueOf(Long.toString(loc)));
                        SNPchars.add(g.toString());
                    }
                }

                //Update likelihood for each combinations of alleles
                String r1 = "", r2 = "", s1 = "", s2 = "";
                for (int j = 0; j < numHLAlleles; j++){
                    //check if allele 1 overlaps current position
                    if (loc >= HLAstartpos[j] && loc <= HLAstoppos[j]){
                        pos_j = loc - HLAstartpos[j];
                        c1 = Character.toString(Character.toUpperCase(HLAreads.get(j).charAt((int) pos_j)));

                        //Extract bases for HLA alleles indicated in reduceInit (for debugging)
                        if (j == j1) r1 = c1;
                        if (j == k1) r2 = c1;
                        if (j == j2) s1 = c1;
                        if (j == k2) s2 = c1;

                        //Only check HLA A-A, B-B, C-C combinations
                        int kStart = 0, kStop = 0;
                        if (j >= iAstart && j <= iAstop){
                            kStart = iAstart; kStop = iAstop;
                        } else if (j >= iBstart && j <= iBstop){
                            kStart = iBstart; kStop = iBstop;
                        } else if (j >= iCstart && j <= iCstop){
                            kStart = iCstart; kStop = iCstop;
                        }

                        //Fill half-matrix only to speed up process
                        if (j > kStart){kStart = j;}

                        if (DEBUG){
                            //out.printf("j[%s],k[%s,%s]\t",j,kStart,kStop);
                        }

                        //Update likelihoods
                        for (int k = kStart; k <= kStop; k++){

                            //check if allele 2 overlaps current position
                            if (loc >= HLAstartpos[k] && loc <= HLAstoppos[k]){
                                pos_k = loc - HLAstartpos[k];
                                c2 = Character.toString(Character.toUpperCase(HLAreads.get(k).charAt((int) pos_k)));
                                
                                //updates likelihoods for both permutations of the alleles, normalized to the likelihood for homozygous reference
                                if (Scores.containsKey(c1 + c2)){
                                    //out.printf("j[%s],k[%s],g[%s],s[%.0f]\t",j,k,c1+c2,Scores.get(c1 + c2));
                                    if (!homref.equals(c1+c2) || Double.parseDouble((String) Scores.get(homref).toString()) != 0){
                                        likelihood = Double.parseDouble((String) Scores.get(c1 + c2).toString());
                                        LikelihoodScores[j][k] = LikelihoodScores[j][k] + likelihood;
                                        LOD[j][k]= LOD[j][k] + likelihood - homreflikelihood;
                                    }
                                } else{
                                    if (DEBUG){
                                    //out.printf("\nCharacters [%s] not found,j[%s],k[%s],%s,%s\n",c1+c2,j,k,HLAnames.get(j),HLAnames.get(k));
                                    }
                                }
                                
                            }
                        }
                    }
                }
                if ( DEBUG ){
                    //Debugging: print updated likelihoods for 2 sets of HLA alleles, as well as normalized likelihoods for all 10 genotypes
                    out.printf("Likelihoods %s%s[%5.1f] %s%s[%5.1f]\t",r1,r2,LikelihoodScores[j1][k1],s1,s2,LikelihoodScores[j2][k2]);
                    for ( DiploidGenotype g : DiploidGenotype.values() ) {
                        out.printf("%s[%5.1f] ",g.toString(),Scores.get(g.toString()));
                    }
                    out.printf("\n");
                }
            }
        }
        return context.getReads().size();
    }


    private void UpdateCorrelation(SAMRecord read, boolean PRINT){
        //Updates correlation table with SNPs from specific read (for phasing)
        String s = CigarFormatted(read.getCigarString(), read.getReadString());
        ArrayList<Integer> SNPsInRead = new ArrayList<Integer>();
        ArrayList<Integer> readindex = new ArrayList<Integer>();
        Hashtable indexer = new Hashtable();

        indexer.put('A', (Integer) 0);
        indexer.put('C', (Integer) 1);
        indexer.put('G', (Integer) 2);
        indexer.put('T', (Integer) 3);
        indexer.put('D', (Integer) 4); // D for deletion


        int readstart = read.getAlignmentStart();

        //Find all SNPs in read
        for (int i = read.getAlignmentStart(); i <= read.getAlignmentEnd(); i++){
            if (SNPs.containsKey(String.valueOf(i))){
                //Stores matrix index
                SNPsInRead.add((Integer) SNPs.get(String.valueOf(i)));

                //stores position along read
                readindex.add((Integer) i - readstart);
            }
        }

        //Update correlation table; for each combination of SNP positions
        for (int i = 0; i < SNPsInRead.size(); i++){
            for (int j = i+1; j < SNPsInRead.size(); j ++){
                char c1 = s.charAt((int) readindex.get(i));
                char c2 = s.charAt((int) readindex.get(j));

                if (indexer.get(c1) != null && indexer.get(c2) != null){

                    int a = (SNPsInRead.get(i)-1)*5 + (Integer) indexer.get(c1);
                    int b = (SNPsInRead.get(j)-1)*5 + (Integer) indexer.get(c2);
                    if (PRINT){
                        out.printf("ReadIndex[%s,%s] of %s\t", readindex.get(i),readindex.get(j),read.getAlignmentEnd()-readstart);
                        out.printf("SNP#[%s,%s] of %s\tPOS:%s[%s]\t%s[%s]\t", SNPsInRead.get(i),SNPsInRead.get(j), SNPs.size(), readindex.get(i)+readstart,c1, readindex.get(j)+readstart,c2);
                        out.printf("MatrixIndex[%s,%s] of %s",a,b,SNPcorrelation.length);
                        out.printf("\tc1=%s,c2=%s",c1,c2);
                        out.printf("\ta=%s,b=%s",a,b);
                        out.printf("\tSNPcorrelation[a][b]=%s\n",SNPcorrelation[a][b]);
                    }
                    SNPcorrelation[a][b]+=1;
                }
            }
        }
    }


    private int GetPhaseScore(int alleleindex){
        int score = 0;
        ArrayList<Integer> SNPsInRead = new ArrayList<Integer>();
        ArrayList<Integer> readindex = new ArrayList<Integer>();
        Hashtable indexer = new Hashtable();
        indexer.put('A', (Integer) 0);
        indexer.put('C', (Integer) 1);
        indexer.put('G', (Integer) 2);
        indexer.put('T', (Integer) 3);
        indexer.put('D', (Integer) 4); // D for deletion

        //Get HLA allele sequence and position given index
        String allele = HLAreads.get(alleleindex);
        int allelestart = HLAstartpos[alleleindex], allelestop = HLAstoppos[alleleindex];

        //Finds SNPs in allele
        for (int i = allelestart; i <= allelestop; i++){
            if (SNPs.containsKey(String.valueOf(i))){
                //Stores matrix index
                SNPsInRead.add((Integer) SNPs.get(String.valueOf(i)));
                //stores position along read
                readindex.add((Integer) i - allelestart);
            }
        }

        //sum score for every pair of SNPs in the allele
        for (int i = 0; i < SNPsInRead.size(); i++){
            for (int j = i+1; j < SNPsInRead.size(); j ++){
                char c1 = allele.charAt((int) readindex.get(i));
                char c2 = allele.charAt((int) readindex.get(j));
                if (indexer.get(c1) != null && indexer.get(c2) != null){
                    int a = (SNPsInRead.get(i)-1)*5 + (Integer) indexer.get(c1);
                    int b = (SNPsInRead.get(j)-1)*5 + (Integer) indexer.get(c2);
                    score += SNPcorrelation[a][b];
                }
            }
        }
        return score;
    }

    private double GetPhaseProbability(int alleleindex){
        double prob = 1;
        ArrayList<Integer> SNPsInRead = new ArrayList<Integer>();
        ArrayList<Integer> readindex = new ArrayList<Integer>();
        ArrayList<String> Genotypes = new ArrayList<String>();
        Hashtable indexer = new Hashtable();
        indexer.put('A', (Integer) 0);
        indexer.put('C', (Integer) 1);
        indexer.put('G', (Integer) 2);
        indexer.put('T', (Integer) 3);
        //indexer.put('D', (Integer) 4); // D for deletion

        //Get HLA allele sequence and position given index
        String allele = HLAreads.get(alleleindex);
        int allelestart = HLAstartpos[alleleindex], allelestop = HLAstoppos[alleleindex];

        //Finds SNPs in allele
        for (int i = allelestart; i <= allelestop; i++){
            if (SNPs.containsKey(String.valueOf(i))){
                //Stores matrix index
                SNPsInRead.add((Integer) SNPs.get(String.valueOf(i)));
                //stores position along read
                readindex.add((Integer) i - allelestart);
                //stores genotypes at SNPs
                Genotypes.add(SNPchars.get((Integer) SNPs.get(String.valueOf(i))-1));
            }
        }

        char c1, c2, gi1, gi2, gj1, gj2;
        int a, b, a1, a2, b1, b2;
        double numerator, denominator;
        //sum score for every pair of SNPs in the allele
        for (int i = 0; i < SNPsInRead.size()-1; i++){
            int j = i + 1;
            c1 = allele.charAt((int) readindex.get(i));
            c2 = allele.charAt((int) readindex.get(j));

            gi1 = Genotypes.get(i).toCharArray()[0];
            gi2 = Genotypes.get(i).toCharArray()[1];
            gj1 = Genotypes.get(j).toCharArray()[0];
            gj2 = Genotypes.get(j).toCharArray()[1];

            numerator = 0; denominator = 0;
            if (indexer.get(c1) != null && indexer.get(c2) != null){
                a = (SNPsInRead.get(i)-1)*5;
                b = (SNPsInRead.get(j)-1)*5;
                for (int k = 0; k < 5; k++){
                    for (int l = 0; l < 5; l++){
                        if (DEBUG){}//out.printf("[%s,%s]=%s, sum=%s\n",a+k,b+l,SNPcorrelation[a+k][b+l],denominator);}
                        denominator = denominator + SNPcorrelation[a+k][b+l];
                    }
                }
                if (denominator > 0){
                    //indicies for genotypes at the 2 SNPs
                    a1 = (SNPsInRead.get(i)-1)*5 + (Integer) indexer.get(gi1);
                    b1 = (SNPsInRead.get(j)-1)*5 + (Integer) indexer.get(gj1);
                    a2 = (SNPsInRead.get(i)-1)*5 + (Integer) indexer.get(gi2);
                    b2 = (SNPsInRead.get(j)-1)*5 + (Integer) indexer.get(gj2);

                    if (gi1 == gi2 && gj1 == gj2){
                        if (c1 == gi1 && c2 == gj1){
                            numerator = SNPcorrelation[a1][b1];
                        }
                    } else if ((c1 == gi1 && c2 == gj1) || (c1 == gi2 && c2 == gj2)){
                        numerator = SNPcorrelation[a1][b1] + SNPcorrelation[a2][b2];
                    } else if((c1 == gi2 && c2 == gj1) || (c1 == gi1 && c2 == gj2)){
                        numerator = SNPcorrelation[a2][b1] + SNPcorrelation[a1][b2];
                    } else {
                        if ((SNPcorrelation[a1][b1] + SNPcorrelation[a2][b2]) > (SNPcorrelation[a2][b1] + SNPcorrelation[a1][b2])){
                            numerator = denominator - (SNPcorrelation[a1][b1] + SNPcorrelation[a2][b2]);
                        }else{
                            numerator = denominator - (SNPcorrelation[a2][b1] + SNPcorrelation[a1][b2]);
                        }
                    }

                    if (numerator == 0){
                        prob = 0.01;
                    }else{
                        prob = prob * numerator/denominator;
                    }
                    
                    if (DEBUG){
                        out.printf("%s: %s,%s\tC1,C2=[%s,%s]\t[%s%s]=%s\t[%s%s]=%s\t[%s%s]=%s\t[%s%s]=%s\t%s/%s=%.3f\tprob=%.3f\n",readindex.get(i)+allelestart,readindex.get(j)+allelestart,alleleindex,c1,c2,gi1,gj1,SNPcorrelation[a1][b1],gi1,gj2,SNPcorrelation[a1][b2],gi2,gj1,SNPcorrelation[a2][b1],gi2,gj2,SNPcorrelation[a2][b2],numerator,denominator,numerator/denominator,prob);
                    }
                }
            }
        }
        return prob;
    }

    public Pair<Long, Long> reduce(Integer value, Pair<Long, Long> sum) {
        long left = value.longValue() + sum.getFirst();
        long right = sum.getSecond() + 1l;
        return new Pair<Long,Long>(left, right);
    }

    public void onTraversalDone(Pair<Long, Long> result) {
        //Print HLA allele combinations with highest likelihood sums
        if (!PrintedOutput){
            out.print("\nDone calculating likelihoods\n");

            ArrayList<Integer> TopAlleles = new ArrayList<Integer>();

            double maxA = 0;  int i_maxA =0;   int j_maxA = 0; double maxAphase = 0.0; double maxAfreq = 0.0; double maxlikelihoodA = 0.0; double maxProbA = 0.0;
            double maxA2 = 0; int i_maxA_2 =0; int j_maxA_2 = 0;

            double maxB = 0;  int i_maxB =0;   int j_maxB = 0; double maxBphase = 0.0; double maxBfreq = 0.0; double maxlikelihoodB = 0.0; double maxProbB = 0.0;
            double maxB2 = 0; int i_maxB_2 =0; int j_maxB_2 = 0;

            double maxC = 0;  int i_maxC =0;   int j_maxC = 0; double maxCphase = 0.0; double maxCfreq = 0.0; double maxlikelihoodC = 0.0; double maxProbC = 0.0;
            double maxC2 = 0; int i_maxC_2 =0; int j_maxC_2 = 0;

            
            out.print("Finding allele pair with highest likelihood\n");
            //Find the maximum likelihood scores for each HLA gene,
            for (int i = 0; i < numHLAlleles; i++){
                for (int j = i; j < numHLAlleles; j++){
                    //Print likelihoods for all alleles
                    if (DEBUG){}//out.printf("%s\t%s\t%5.0f\n",HLAnames.get(i),HLAnames.get(j),LOD[i][j]);}
                    if (HLAnames.get(i).indexOf("HLA_A") > -1 && HLAnames.get(j).indexOf("HLA_A") > -1){
                        if (LOD[i][j] > maxA){
                            maxA2 = maxA; i_maxA_2 = i_maxA; j_maxA_2 = j_maxA;
                            maxA = LOD[i][j]; i_maxA = i; j_maxA = j; maxlikelihoodA = LikelihoodScores[i][j];
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_B") > -1 && HLAnames.get(j).indexOf("HLA_B") > -1){
                        if (LOD[i][j] > maxB){
                            maxB2 = maxB; i_maxB_2 = i_maxB; j_maxB_2 = j_maxB;
                            maxB = LOD[i][j]; i_maxB = i; j_maxB = j; maxlikelihoodB = LikelihoodScores[i][j];
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_C") > -1 && HLAnames.get(j).indexOf("HLA_C") > -1){
                        if (LOD[i][j] > maxC){
                            maxC2 = maxC; i_maxC_2 = i_maxC; j_maxC_2 = j_maxC;
                            maxC = LOD[i][j]; i_maxC = i; j_maxC = j; maxlikelihoodC = LikelihoodScores[i][j];
                        }
                    }
		}
            }


            //Record alleles with the highest likelihood combinations, sum likelihoods (within 5 orders of magnitide of best score) to calculate posterior probabilities for each allele combination
            for (Integer i = 0; i < numHLAlleles; i++){
                for (Integer j = i; j < numHLAlleles; j++){
                    if (HLAnames.get(i).indexOf("HLA_A") > -1 && HLAnames.get(j).indexOf("HLA_A") > -1 && maxA > 0){
                        if (maxA - LOD[i][j] <= 10 && maxA >= LOD[i][j]){
                            inverseMaxProbA = inverseMaxProbA + java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodA);
                            if (!TopAlleles.contains(i)){TopAlleles.add(i);}
                            if (!TopAlleles.contains(j)){TopAlleles.add(j);}
                            if (DEBUG){
                                out.printf("HLA-A: %s, %s \tlikelihood=%.2f\tmax=%.2f\tLOD=%.2f\tmaxLOD=%.2f\tdelta_likelihood=%.2f\tinvP=%.2f\n",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],maxlikelihoodA,LOD[i][j],maxA,LikelihoodScores[i][j]-maxlikelihoodA,inverseMaxProbA);
                            }
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_B") > -1 && HLAnames.get(j).indexOf("HLA_B") > -1 && maxB > 0){
                        if (maxB - LOD[i][j] <= 10 && maxB - LOD[i][j] >= 0){
                            inverseMaxProbB = inverseMaxProbB + java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodB);
                            if (!TopAlleles.contains(i)){TopAlleles.add(i);}
                            if (!TopAlleles.contains(j)){TopAlleles.add(j);}
                            if (DEBUG){
                                out.printf("HLA-B: %s, %s \tlikelihood=%.2f\tmax=%.2f\tLOD=%.2f\tmaxLOD=%.2f\tdelta_likelihood=%.2f\tinvP=%.2f\n",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],maxlikelihoodB,LOD[i][j],maxB,LikelihoodScores[i][j]-maxlikelihoodB,inverseMaxProbB);
                            }
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_C") > -1 && HLAnames.get(j).indexOf("HLA_C") > -1 && maxC > 0){
                        if (maxC - LOD[i][j] <= 10 && maxC - LOD[i][j] >= 0){
                            inverseMaxProbC = inverseMaxProbC + java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodC);
                            if (!TopAlleles.contains(i)){TopAlleles.add(i);}
                            if (!TopAlleles.contains(j)){TopAlleles.add(j);}
                            if (DEBUG){
                                out.printf("HLA-C: %s, %s \tlikelihood=%.2f\tmax=%.2f\tLOD=%.2f\tmaxLOD=%.2f\tdelta_likelihood=%.2f\tinvP=%.2f\n",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],maxlikelihoodC,LOD[i][j],maxC,LikelihoodScores[i][j]-maxlikelihoodC,inverseMaxProbC);
                            }
                        }
                       
                    }
                }
            }

            out.printf("\nCalculating SNP correlation matrix for %s SNPs\n",SNPcount);
            SNPcorrelation = new int[SNPs.size()*5][SNPs.size()*5]; //keep track of counts of each pair of SNPs
            SNPcorrelationProb = new double[SNPs.size()][3]; // keep track of probabilities for specific haplotype at 2 SNPs.


            
            //Create correlation matrix and update correlation scores for all reads
            for (int i = 0; i < AllReads.size(); i++){
                if (i == 2045){
                    UpdateCorrelation(AllReads.get(i), false);
                }else{
                    UpdateCorrelation(AllReads.get(i), false);
                }
                //out.printf("[%s,%s]\n", ((Integer) SNPs.get("31431982")) * 4,((Integer) SNPs.get("31432003")) * 4 );
                //out.printf("%s\t[%s,%s]\t31431982[A] 31432003[A]\t%s\n",i,((Integer) SNPs.get("31431982")) * 4,((Integer) SNPs.get("31432003")) * 4 , SNPcorrelation[((Integer) SNPs.get("31431982")) * 4][((Integer) SNPs.get("31432003")) * 4]);
            }

            Hashtable indexer = new Hashtable();
            indexer.put('A', (Integer) 0);
            indexer.put('C', (Integer) 1);
            indexer.put('G', (Integer) 2);
            indexer.put('T', (Integer) 3);
            indexer.put('D', (Integer) 4); // D for deletion
            char[] bases = {'A','C','G','T','D'};

            if ( false ){
                //prints entries in the correlation matrix that are > 0
                out.print("\n");
                for (int i = 0; i < SNPs.size(); i++){
                    int loc1 = SNPlocations.get(i);
                    for (int j = i ; j < SNPs.size(); j++){
                        int loc2 = SNPlocations.get(j);
                        for (char c1 : bases){
                            for (char c2 : bases){
                                int a = i*5 + (Integer) indexer.get(c1);
                                int b = j*5 + (Integer) indexer.get(c2);
                                if (SNPcorrelation[a][b] > 0){
                                    out.printf("[i,j]=[%s,%s]\t[a,b]=[%s,%s]\tPOS:%s[%s],%s[%s]\tCorr=%s\n",i,j,a,b,loc1,c1,loc2,c2,SNPcorrelation[a][b]);
                                }
                            }
                        }
                    }
                }
            }


            int k, readstart, readstop, allelestart, allelestop, pos_k;
            out.printf("Calculating phase scores for %s top alleles\n",TopAlleles.size());

            //Calculate Phase score for each allele
            double[] SinglePhaseScores = new double[TopAlleles.size()];
            for (int i = 0; i < TopAlleles.size(); i++){
                //SinglePhaseScores[i] = GetPhaseScore(TopAlleles.get(i));
                SinglePhaseScores[i] = GetPhaseProbability(TopAlleles.get(i));

                if ( DEBUG ){
                    //Debugging: print list of alleles to be checked for phasing
                    out.printf("index=%s\t%s\tscore=%.3f\n",TopAlleles.get(i),HLAnames.get(TopAlleles.get(i)),SinglePhaseScores[i]);
                }
            }

            out.print("Calculating phasing score for pairs of alleles\n");
            //Calculate phasing score and population frequencies for pairs of alleles, and find pairs with the highest scores, and sum combined probabilities
            String alleleA, alleleB;
            Double freq1 = 0.0, freq2 = 0.0;
            Double ProbSumA = 0.0, ProbSumB = 0.0, ProbSumC = 0.0, likelihoodPrior;
            Double PhaseSumA = 0.0, PhaseSumB = 0.0, PhaseSumC = 0.0;
            for (Integer i = 0; i < numHLAlleles; i++){
                for (Integer j = i; j < numHLAlleles; j++){
                    if (HLAnames.get(i).indexOf("HLA_A") > -1 && HLAnames.get(j).indexOf("HLA_A") > -1){
                        if ((LOD[i][j] >= maxA - 10) && LOD[i][j] > 0){
                            PhasingScores[i][j]= SinglePhaseScores[TopAlleles.indexOf(i)] * SinglePhaseScores[TopAlleles.indexOf(j)];
                            if (PhasingScores[i][j] > maxAphase){maxAphase = PhasingScores[i][j];}
                            alleleA=HLAnames.get(i).substring(4); if (AlleleFrequencies.containsKey(alleleA)){freq1 = Double.parseDouble((String) AlleleFrequencies.get(alleleA).toString());}else{freq1=0.00001;}
                            alleleB=HLAnames.get(j).substring(4); if (AlleleFrequencies.containsKey(alleleB)){freq2 = Double.parseDouble((String) AlleleFrequencies.get(alleleB).toString());}else{freq2=0.00001;}
                            SingleAlleleFrequencies[i]=freq1; SingleAlleleFrequencies[j]=freq2; CombinedAlleleFrequencies[i][j]=freq1*freq2;
                            if (CombinedAlleleFrequencies[i][j] > maxAfreq){maxAfreq = CombinedAlleleFrequencies[i][j];}
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodA)/inverseMaxProbA;
                            ProbSumA = ProbSumA + likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];
                            PhaseSumA = PhaseSumA + PhasingScores[i][j];
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] > maxProbA){maxProbA = likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];}
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_B") > -1 && HLAnames.get(j).indexOf("HLA_B") > -1){
                        if ((LOD[i][j] >= maxB - 10) && LOD[i][j] > 0){
                            PhasingScores[i][j]= SinglePhaseScores[TopAlleles.indexOf(i)] * SinglePhaseScores[TopAlleles.indexOf(j)];
                            if (PhasingScores[i][j] > maxBphase){maxBphase = PhasingScores[i][j];}
                            alleleA=HLAnames.get(i).substring(4); if (AlleleFrequencies.containsKey(alleleA)){freq1 = Double.parseDouble((String) AlleleFrequencies.get(alleleA).toString());}else{freq1=0.00001;}
                            alleleB=HLAnames.get(j).substring(4); if (AlleleFrequencies.containsKey(alleleB)){freq2 = Double.parseDouble((String) AlleleFrequencies.get(alleleB).toString());}else{freq2=0.00001;}
                            SingleAlleleFrequencies[i]=freq1; SingleAlleleFrequencies[j]=freq2; CombinedAlleleFrequencies[i][j]=freq1*freq2;
                            if (freq1*freq2 > maxBfreq){maxBfreq = freq1*freq2;}
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodB)/inverseMaxProbB;
                            ProbSumB = ProbSumB + likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];
                            PhaseSumB = PhaseSumB + PhasingScores[i][j];
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] > maxProbB){maxProbB = likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];}
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_C") > -1 && HLAnames.get(j).indexOf("HLA_C") > -1){
                        if ((LOD[i][j] >= maxC - 10)&& LOD[i][j] > 0){
                            PhasingScores[i][j]= SinglePhaseScores[TopAlleles.indexOf(i)] * SinglePhaseScores[TopAlleles.indexOf(j)];
                            if (PhasingScores[i][j] > maxCphase){maxCphase = PhasingScores[i][j];}
                            alleleA=HLAnames.get(i).substring(4); if (AlleleFrequencies.containsKey(alleleA)){freq1 = Double.parseDouble((String) AlleleFrequencies.get(alleleA).toString());}else{freq1=0.00001;}
                            alleleB=HLAnames.get(j).substring(4); if (AlleleFrequencies.containsKey(alleleB)){freq2 = Double.parseDouble((String) AlleleFrequencies.get(alleleB).toString());}else{freq2=0.00001;}
                            SingleAlleleFrequencies[i]=freq1; SingleAlleleFrequencies[j]=freq2; CombinedAlleleFrequencies[i][j]=freq1*freq2;
                            if (freq1*freq2 > maxCfreq){maxCfreq = freq1*freq2;}
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodC)/inverseMaxProbC;
                            ProbSumC = ProbSumC + likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];
                            PhaseSumC = PhaseSumC + PhasingScores[i][j];
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] > maxProbC){maxProbC = likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j];}
                            if (DEBUG){
                                out.printf("DEBUG: %s\t%s\tPhaseScore[%.3f]\t%.3f\n",alleleA,alleleB,PhasingScores[i][j],PhaseSumC);
                            }
                        }
                    }
                }
            }

            if (DEBUG){
                out.printf("DEBUG: Phase sum for HLA-C: %.3f\n",PhaseSumC);
            }
            out.print("Printing results ...\n");
            //Print allele pairs with highest likelihood score and highest phasing score
            for (Integer i = 0; i < numHLAlleles; i++){
                for (Integer j = i; j < numHLAlleles; j++){
                    if (HLAnames.get(i).indexOf("HLA_A") > -1 && HLAnames.get(j).indexOf("HLA_A") > -1){
                        if((LOD[i][j] >= maxA - 10) && LOD[i][j] > 0){ // && PhasingScores[i][j] == maxAphase
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodA)/inverseMaxProbA;
                            //out.printf("%s\t%s\tloglikelihood=%5.0f\tmax=%5.0f\tinvP=%.2f\tPrior=%.3f\tPhase=%.3f\tfreq1=%s\tfreq2=%s\tf1*f2=%.8f\tProb=%.3f",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],maxlikelihoodA,inverseMaxProbA,likelihoodPrior,PhasingScores[i][j],SingleAlleleFrequencies[i],SingleAlleleFrequencies[j],CombinedAlleleFrequencies[i][j],likelihoodPrior*CombinedAlleleFrequencies[i][j]/ProbSumA);
                            out.printf("%s\t%s\tloglikelihood=%5.0f\tP(SSG)=%.3f\tP(Phase)=%.3f\tF1=%s\tF2=%s\tF1*F2=%.8f\tProb=%.3f",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],likelihoodPrior,PhasingScores[i][j]/PhaseSumA,SingleAlleleFrequencies[i],SingleAlleleFrequencies[j],CombinedAlleleFrequencies[i][j],likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j]/ProbSumA);
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] == maxProbA){out.printf("\tBEST");}
                            out.printf("\n");
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_B") > -1 && HLAnames.get(j).indexOf("HLA_B") > -1){
                        if((LOD[i][j] >= maxB - 10) && LOD[i][j] > 0){ // && PhasingScores[i][j] == maxBphase
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodB)/inverseMaxProbB;
                            out.printf("%s\t%s\tloglikelihood=%5.0f\tP(SSG)=%.3f\tP(Phase)=%.3f\tF1=%s\tF2=%s\tF1*F2=%.8f\tProb=%.3f",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],likelihoodPrior,PhasingScores[i][j]/PhaseSumB,SingleAlleleFrequencies[i],SingleAlleleFrequencies[j],CombinedAlleleFrequencies[i][j],likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j]/ProbSumB);
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] == maxProbB){out.printf("\tBEST");}
                            out.printf("\n");
                        }
                    } else if (HLAnames.get(i).indexOf("HLA_C") > -1 && HLAnames.get(j).indexOf("HLA_C") > -1){
                        if((LOD[i][j] >= maxC - 10) && LOD[i][j] > 0){ // && PhasingScores[i][j] == maxCphase
                            likelihoodPrior = java.lang.Math.pow(10,LikelihoodScores[i][j]-maxlikelihoodC)/inverseMaxProbC;
                            out.printf("%s\t%s\tloglikelihood=%5.0f\tP(SSG)=%.3f\tP(Phase)=%.3f\tF1=%s\tF2=%s\tF1*F2=%.8f\tProb=%.3f",HLAnames.get(i),HLAnames.get(j),LikelihoodScores[i][j],likelihoodPrior,PhasingScores[i][j]/PhaseSumC,SingleAlleleFrequencies[i],SingleAlleleFrequencies[j],CombinedAlleleFrequencies[i][j],likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j]/ProbSumC);
                            if (likelihoodPrior*CombinedAlleleFrequencies[i][j]*PhasingScores[i][j] == maxProbC){out.printf("\tBEST");}
                            out.printf("\n");
                        }
                    }
                }
            }

            //2nd Highest likelihoods
            for (int i = 0; i < numHLAlleles; i++){
                for (int j = i; j < numHLAlleles; j++){
                    if (LOD[i][j] == maxA2){
                        //out.printf("2nd Highest likelihood: %5.0f in %s and %s; i=%s, j=%s\n",maxA2,HLAnames.get(i),HLAnames.get(j),i,j);
                    }
                }
            }

            PrintedOutput = true;
            //out.printf("Average depth of coverage is: %.2f in %d total coverage over %d sites\n",((double)result.getFirst() / (double)result.getSecond()), result.getFirst(), result.getSecond());
        }
    }
}
