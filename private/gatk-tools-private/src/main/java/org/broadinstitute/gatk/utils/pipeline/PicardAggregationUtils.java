/*
*  By downloading the PROGRAM you agree to the following terms of use:
*  
*  BROAD INSTITUTE - SOFTWARE LICENSE AGREEMENT - FOR ACADEMIC NON-COMMERCIAL RESEARCH PURPOSES ONLY
*  
*  This Agreement is made between the Broad Institute, Inc. with a principal address at 7 Cambridge Center, Cambridge, MA 02142 (BROAD) and the LICENSEE and is effective at the date the downloading is completed (EFFECTIVE DATE).
*  
*  WHEREAS, LICENSEE desires to license the PROGRAM, as defined hereinafter, and BROAD wishes to have this PROGRAM utilized in the public interest, subject only to the royalty-free, nonexclusive, nontransferable license rights of the United States Government pursuant to 48 CFR 52.227-14; and
*  WHEREAS, LICENSEE desires to license the PROGRAM and BROAD desires to grant a license on the following terms and conditions.
*  NOW, THEREFORE, in consideration of the promises and covenants made herein, the parties hereto agree as follows:
*  
*  1. DEFINITIONS
*  1.1 PROGRAM shall mean copyright in the object code and source code known as GATK2 and related documentation, if any, as they exist on the EFFECTIVE DATE and can be downloaded from http://www.broadinstitute/GATK on the EFFECTIVE DATE.
*  
*  2. LICENSE
*  2.1   Grant. Subject to the terms of this Agreement, BROAD hereby grants to LICENSEE, solely for academic non-commercial research purposes, a non-exclusive, non-transferable license to: (a) download, execute and display the PROGRAM and (b) create bug fixes and modify the PROGRAM. 
*  The LICENSEE may apply the PROGRAM in a pipeline to data owned by users other than the LICENSEE and provide these users the results of the PROGRAM provided LICENSEE does so for academic non-commercial purposes only.  For clarification purposes, academic sponsored research is not a commercial use under the terms of this Agreement.
*  2.2  No Sublicensing or Additional Rights. LICENSEE shall not sublicense or distribute the PROGRAM, in whole or in part, without prior written permission from BROAD.  LICENSEE shall ensure that all of its users agree to the terms of this Agreement.  LICENSEE further agrees that it shall not put the PROGRAM on a network, server, or other similar technology that may be accessed by anyone other than the LICENSEE and its employees and users who have agreed to the terms of this agreement.
*  2.3  License Limitations. Nothing in this Agreement shall be construed to confer any rights upon LICENSEE by implication, estoppel, or otherwise to any computer software, trademark, intellectual property, or patent rights of BROAD, or of any other entity, except as expressly granted herein. LICENSEE agrees that the PROGRAM, in whole or part, shall not be used for any commercial purpose, including without limitation, as the basis of a commercial software or hardware product or to provide services. LICENSEE further agrees that the PROGRAM shall not be copied or otherwise adapted in order to circumvent the need for obtaining a license for use of the PROGRAM.  
*  
*  3. OWNERSHIP OF INTELLECTUAL PROPERTY 
*  LICENSEE acknowledges that title to the PROGRAM shall remain with BROAD. The PROGRAM is marked with the following BROAD copyright notice and notice of attribution to contributors. LICENSEE shall retain such notice on all copies.  LICENSEE agrees to include appropriate attribution if any results obtained from use of the PROGRAM are included in any publication.
*  Copyright 2012 Broad Institute, Inc.
*  Notice of attribution:  The GATK2 program was made available through the generosity of Medical and Population Genetics program at the Broad Institute, Inc.
*  LICENSEE shall not use any trademark or trade name of BROAD, or any variation, adaptation, or abbreviation, of such marks or trade names, or any names of officers, faculty, students, employees, or agents of BROAD except as states above for attribution purposes.
*  
*  4. INDEMNIFICATION
*  LICENSEE shall indemnify, defend, and hold harmless BROAD, and their respective officers, faculty, students, employees, associated investigators and agents, and their respective successors, heirs and assigns, (Indemnitees), against any liability, damage, loss, or expense (including reasonable attorneys fees and expenses) incurred by or imposed upon any of the Indemnitees in connection with any claims, suits, actions, demands or judgments arising out of any theory of liability (including, without limitation, actions in the form of tort, warranty, or strict liability and regardless of whether such action has any factual basis) pursuant to any right or license granted under this Agreement.
*  
*  5. NO REPRESENTATIONS OR WARRANTIES
*  THE PROGRAM IS DELIVERED AS IS.  BROAD MAKES NO REPRESENTATIONS OR WARRANTIES OF ANY KIND CONCERNING THE PROGRAM OR THE COPYRIGHT, EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NONINFRINGEMENT, OR THE ABSENCE OF LATENT OR OTHER DEFECTS, WHETHER OR NOT DISCOVERABLE. BROAD EXTENDS NO WARRANTIES OF ANY KIND AS TO PROGRAM CONFORMITY WITH WHATEVER USER MANUALS OR OTHER LITERATURE MAY BE ISSUED FROM TIME TO TIME.
*  IN NO EVENT SHALL BROAD OR ITS RESPECTIVE DIRECTORS, OFFICERS, EMPLOYEES, AFFILIATED INVESTIGATORS AND AFFILIATES BE LIABLE FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES OF ANY KIND, INCLUDING, WITHOUT LIMITATION, ECONOMIC DAMAGES OR INJURY TO PROPERTY AND LOST PROFITS, REGARDLESS OF WHETHER BROAD SHALL BE ADVISED, SHALL HAVE OTHER REASON TO KNOW, OR IN FACT SHALL KNOW OF THE POSSIBILITY OF THE FOREGOING.
*  
*  6. ASSIGNMENT
*  This Agreement is personal to LICENSEE and any rights or obligations assigned by LICENSEE without the prior written consent of BROAD shall be null and void.
*  
*  7. MISCELLANEOUS
*  7.1 Export Control. LICENSEE gives assurance that it will comply with all United States export control laws and regulations controlling the export of the PROGRAM, including, without limitation, all Export Administration Regulations of the United States Department of Commerce. Among other things, these laws and regulations prohibit, or require a license for, the export of certain types of software to specified countries.
*  7.2 Termination. LICENSEE shall have the right to terminate this Agreement for any reason upon prior written notice to BROAD. If LICENSEE breaches any provision hereunder, and fails to cure such breach within thirty (30) days, BROAD may terminate this Agreement immediately. Upon termination, LICENSEE shall provide BROAD with written assurance that the original and all copies of the PROGRAM have been destroyed, except that, upon prior written authorization from BROAD, LICENSEE may retain a copy for archive purposes.
*  7.3 Survival. The following provisions shall survive the expiration or termination of this Agreement: Articles 1, 3, 4, 5 and Sections 2.2, 2.3, 7.3, and 7.4.
*  7.4 Notice. Any notices under this Agreement shall be in writing, shall specifically refer to this Agreement, and shall be sent by hand, recognized national overnight courier, confirmed facsimile transmission, confirmed electronic mail, or registered or certified mail, postage prepaid, return receipt requested.  All notices under this Agreement shall be deemed effective upon receipt. 
*  7.5 Amendment and Waiver; Entire Agreement. This Agreement may be amended, supplemented, or otherwise modified only by means of a written instrument signed by all parties. Any waiver of any rights or failure to act in a specific instance shall relate only to such instance and shall not be construed as an agreement to waive any rights or fail to act in any other instance, whether or not similar. This Agreement constitutes the entire agreement among the parties with respect to its subject matter and supersedes prior agreements or understandings between the parties relating to its subject matter. 
*  7.6 Binding Effect; Headings. This Agreement shall be binding upon and inure to the benefit of the parties and their respective permitted successors and assigns. All headings are for convenience only and shall not affect the meaning of any provision of this Agreement.
*  7.7 Governing Law. This Agreement shall be construed, governed, interpreted and applied in accordance with the internal laws of the Commonwealth of Massachusetts, U.S.A., without regard to conflict of laws principles.
*/

package org.broadinstitute.gatk.utils.pipeline;

import htsjdk.samtools.util.IOUtil;
import htsjdk.samtools.util.RuntimeIOException;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;
import org.broadinstitute.gatk.utils.exceptions.UserException;
import org.broadinstitute.gatk.utils.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Devils bargain: re-implement PicardAggregationDirectories, or add dependencies on picard's private code base?
//
// TODO: Perhaps will introduce dependency if/when picard private gets a proper artifact?

/**
 * Implements utilities for looking up the latest versions of directories, similar to PicardAggregationDirectories.
 */
public class PicardAggregationUtils {
    private static final Logger log = Logger.getLogger(PicardAggregationUtils.class);

    public static final String PICARD_AGGREGATION_DIR = "/seq/picard_aggregation/";
    private static final String FINISHED_FILE = "finished.txt";
    private static final String FINISHED_SUCCEEDED = "SUCCEEDED";

    public static List<PicardSample> parseSamples(File tsv) {
        return parseSamples(tsv, true);
    }

    public static List<PicardSample> parseSamples(File tsv, boolean throwErrors) {
        List<PicardSample> picardSamples = new ArrayList<PicardSample>();
        int errors = 0;

        LineIterator it = IOUtils.lineIterator(tsv);
        try {
            for (int lineNum = 1; it.hasNext(); lineNum++) {
                String line = it.nextLine();
                String[] tokens = line.split("\t");

                if (tokens.length != 2) {
                    log.error(String.format("Line %d: Does not contain two tab separated values a project/sample: %s", lineNum, line));
                    errors++;
                    continue;
                }

                String project = tokens[0];
                String sample = tokens[1];
                int version = PicardAggregationUtils.getLatestVersion(project, sample);

                if (version == 0) {
                    log.error(String.format("Line %d: Unable to find a latest version: %s", lineNum, line));
                    errors++;
                    continue;
                }

                picardSamples.add(new PicardSample(project, sample, version));
            }
        } finally {
            it.close();
        }

        if (throwErrors && errors > 0)
            throw new UserException.CouldNotReadInputFile(tsv, String.format("See logger errors for problematic lines."));

        return picardSamples;
    }

    public static PicardIntervals readAnalysisIntervals(List<PicardSample> picardSamples) {
        Set<PicardIntervals> seenIntervals = new LinkedHashSet<PicardIntervals>();

        for (PicardSample picardSample: picardSamples) {
            PicardAnalysisFiles analysis = new PicardAnalysisFiles(picardSample.getProject(), picardSample.getSample(), picardSample.getVersion());
            PicardIntervals picardIntervals = new PicardIntervals(analysis.getReferenceSequence(), analysis.getTargetIntervals());
            seenIntervals.add(picardIntervals);
        }

        if (seenIntervals.isEmpty())
            return null;

        if (seenIntervals.size() == 1)
            return seenIntervals.iterator().next();

        throw new UserException.BadArgumentValue("picardSamples", String.format("%d intervals found: %s", seenIntervals.size(), seenIntervals));
    }

    public static List<String> getSampleBams(List<PicardSample> picardSamples) {
        List<String> bams = new ArrayList<String>();
        for (PicardSample picardSample: picardSamples) {
            bams.add(PicardAggregationUtils.getSampleBam(picardSample.getProject(), picardSample.getSample(), picardSample.getVersion()));
        }
        return bams;
    }

    /**
     * Returns the path to the sample BAM.
     * @param project Project
     * @param sample Sample
     * @param version Version
     * @return The path to the sample BAM.
     */
    public static String getSampleBam(String project, String sample, int version) {
        return getSampleFile(project, sample, version, "bam");
    }

    /**
     * Returns the path to the sample file.
     * @param project Project
     * @param sample Sample
     * @param version Version
     * @param extension Extension
     * @return The path to the sample file.
     */
    public static String getSampleFile(String project, String sample, int version, String extension) {
        return getSampleDir(project, sample, version) + IOUtil.makeFileNameSafe(sample) + "." + extension;
    }

    /**
     * Returns the path to the latest BAM.
     * @param project Project
     * @param sample Sample
     * @return The path to the latest BAM.
     */
    public static String getSampleBam(String project, String sample) {
        return getSampleFile(project, sample, "bam");
    }

    /**
     * Returns the path to the latest file.
     * @param project Project
     * @param sample Sample
     * @param extension Extension
     * @return The path to the latest file.
     */
    public static String getSampleFile(String project, String sample, String extension) {
        return getSampleDir(project, sample) + IOUtil.makeFileNameSafe(sample) + "." + extension;
    }

    /**
     * Returns the sample directory.
     * @param project Project
     * @param sample Sample
     * @param version Version
     * @return the sample directory.
     */
    public static String getSampleDir(String project, String sample, int version) {
        return PICARD_AGGREGATION_DIR + String.format("%s/%s/v%d/", IOUtil.makeFileNameSafe(project), IOUtil.makeFileNameSafe(sample), version);
    }

    /**
     * Returns the sample directory using the current symbolic link.
     * @param project Project
     * @param sample Sample
     * @return the sample directory.
     */
    public static String getCurrentSampleDir(String project, String sample) {
        return PICARD_AGGREGATION_DIR + String.format("%s/%s/current/", IOUtil.makeFileNameSafe(project), IOUtil.makeFileNameSafe(sample));
    }

    /**
     * Returns the sample bam using the current symbolic link.
     * @param project Project
     * @param sample Sample
     * @return the sample directory.
     */
    public static String getCurrentSampleBam(String project, String sample) {
        return getCurrentSampleFile(project, sample, "bam");
    }

    /**
     * Returns the sample file using the current symbolic link.
     * @param project Project
     * @param sample Sample
     * @param extension Extension.
     * @return the sample directory.
     */
    public static String getCurrentSampleFile(String project, String sample, String extension) {
        return PICARD_AGGREGATION_DIR + String.format("%1$s/%2$s/current/%2$s.%3$s", IOUtil.makeFileNameSafe(project), IOUtil.makeFileNameSafe(sample), extension);
    }

    /**
     * Returns the latest finished directory for this project sample.
     * @param project Project
     * @param sample Sample
     * @return The path to the latest finished directory.
     */
    public static String getSampleDir(String project, String sample) {
        int latestVersion = getLatestVersion(project, sample);
        if (latestVersion == 0)
            throw new UserException.BadArgumentValue("project/sample", "Unable to find a finished directory for project sample " + project + "/" + sample);
        return getSampleDir(project, sample, latestVersion);
    }

    /**
     * Returns the latest finished version directory
     * @param project Project
     * @param sample Sample
     * @return The highest finished version directory after startVersion
     */
    public static int getLatestVersion(String project, String sample) {
        File sampleDirectory = new File(PICARD_AGGREGATION_DIR + project + "/" + IOUtil.makeFileNameSafe(sample));

        if (!sampleDirectory.exists())
            return 0;

        final File[] versions = sampleDirectory.listFiles(new FileFilter() {
            @Override public boolean accept(final File file) {
                return file.getName().startsWith("v") && file.isDirectory();
            }
        });

        int latestVersion = 0;
        File latest = null;

        for (final File f : versions) {
            if (!isFinished(f, sample)) continue;

            final int v = Integer.parseInt(f.getName().substring(1));
            if (latest == null || v > latestVersion) {
                latestVersion = v;
                latest = f;
            }
        }

        return latestVersion;
    }

    /**
     * Returns true if the project sample directory contains a finished.txt
     * @param project Project
     * @param sample Sample
     * @param version Version
     * @return true if the project sample directory contains a finished.txt
     */
    public static boolean isFinished(String project, String sample, int version) {
        return isFinished(new File(getSampleDir(project, sample, version)), sample);
    }

    /**
     * Returns true if the project sample directory contains a finished.txt
     * This is a hybrid of PicardAggregationDirectories's isFinished and isSuccessfullyFinished
     *
     * @param versionDirectory Version directory
     * @param sampleName Sample name
     * @return true if the project sample directory contains a finished.txt
     */
    private static boolean isFinished(File versionDirectory, String sampleName) {
        if (getBam(versionDirectory, sampleName) == null) return false;
        final File finishedFile = new File(versionDirectory, FINISHED_FILE);
        if ( ! finishedFile.exists()) return false;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(finishedFile));
            final String firstLine = reader.readLine();
            // Allow null, for an old empty file finished.txt
            return firstLine == null || FINISHED_SUCCEEDED.equals(firstLine);
        } catch (final Exception e) {
            throw new RuntimeIOException("Could not read the finished file at " + finishedFile.getAbsolutePath() + ": " + e.getMessage(), e);
        } finally {
            if (reader != null) org.apache.commons.io.IOUtils.closeQuietly(reader);
        }
    }

    /**
     * Returns the bam file from the sample directory.
     *
     * @param versionDirectory Version directory
     * @param sampleName Sample name
     * @return the bam file from the sample directory
     */
    private static File getBam(File versionDirectory, String sampleName) {
        final File bam = new File(versionDirectory, IOUtil.makeFileNameSafe(sampleName) + ".bam");
        return bam.exists() ? bam : null;
    }
}
