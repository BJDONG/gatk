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

package org.broadinstitute.sting.gatk.samples;

import org.apache.log4j.Logger;
import org.broadinstitute.sting.utils.MathUtils;
import org.broadinstitute.sting.utils.exceptions.ReviewedStingException;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.text.XReadLines;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.*;

/**
 * Reads PED file-formatted tabular text files
 *
 * See http://www.broadinstitute.org/mpg/tagger/faq.html
 * See http://pngu.mgh.harvard.edu/~purcell/plink/data.shtml#ped
 *
 * The "ped" file format refers to the widely-used format for linkage pedigree data.
 * Each line describes a single (diploid) individual in the following format:
 *
 *      family_ID individual_ID father_ID mother_ID gender phenotype genotype_1 genotype_2 ...
 *
 * If your data lacks pedigree information (for example, unrelated case/control individuals),
 * set the father_ID and mother_ID to 0. sex denotes the individual's gender with 1=male and 2=female.
 * phenotype refers to the affected status (for association studies) where 0=unknown, 1=unaffected, 2=affected.
 * Finally, each genotype is written as two (=diploid) integer numbers (separated by whitespace),
 * where 1=A, 2=C, 3=G, 4=T. No header lines are allowed and all columns must be separated by whitespace.
 * Check out the information at the PLINK website on the "ped" file format.
 *
 * The PED file is a white-space (space or tab) delimited file: the first six columns are mandatory:
 *  Family ID
 *  Individual ID
 *  Paternal ID
 *  Maternal ID
 *  Sex (1=male; 2=female; other=unknown)
 *  Phenotype
 *
 *  The IDs are alphanumeric: the combination of family and individual ID should uniquely identify a person.
 *  A PED file must have 1 and only 1 phenotype in the sixth column. The phenotype can be either a
 *  quantitative trait or an affection status column: PLINK will automatically detect which type
 *  (i.e. based on whether a value other than 0, 1, 2 or the missing genotype code is observed).
 *
 *  NOTE Quantitative traits with decimal points must be coded with a period/full-stop character and
 *  not a comma, i.e. 2.394 not 2,394
 *
 *  If an individual's sex is unknown, then any character other than 1 or 2 can be used.
 *  When new files are created (PED, FAM, or other which contain sex) then the original coding will be
 *  preserved. However, these individuals will be dropped from any analyses (i.e. phenotype set to missing also)
 *  and an error message will arise if an analysis that uses family information is requested and an
 *  individual of 'unknown' sex is specified as a father or mother.
 *
 *
 *  HINT You can add a comment to a PED or MAP file by starting the line with a # character. The rest of that
 *  line will be ignored. Do not start any family IDs with this character therefore.
 *
 *  Affection status, by default, should be coded:
 *  -9 missing
 *   0 missing
 *   1 unaffected
 *   2 affected
 *
 * If your file is coded 0/1 to represent unaffected/affected, then use the --1 flag:
 * plink --file mydata --1 which will specify a disease phenotype coded:
 *
 *  -9 missing
 *  0 unaffected
 *  1 affected
 *
 * The missing phenotype value for quantitative traits is, by default, -9 (this can also be used for
 * disease traits as well as 0). It can be reset by including the --missing-phenotype option:
 *
 * Genotypes (column 7 onwards) should also be white-space delimited; they can be any character
 * (e.g. 1,2,3,4 or A,C,G,T or anything else) except 0 which is, by default, the missing genotype
 * character. All markers should be biallelic. All SNPs (whether haploid or not) must have two
 * alleles specified. Either Both alleles should be missing (i.e. 0) or neither.
 *
 * No header row should be given. For example, here are two individuals typed for 3 SNPs (one row = one person):
 *
 *   FAM001  1  0 0  1  2  A A  G G  A C
 *   FAM001  2  0 0  1  2  A A  A G  0 0
 *   ...
 *
 * Note that the GATK does not support genotypes in a PED file.
 *
 * @author Mark DePristo
 * @since 2011
 */
public class PedReader {
    private static Logger logger = Logger.getLogger(PedReader.class);
    final static private Set<String> CATAGORICAL_TRAIT_VALUES = new HashSet<String>(Arrays.asList("-9", "0", "1", "2"));
    final static private String commentMarker = "#";

    public enum MissingPedFields {
        NO_FAMILY_ID,
        NO_PARENTS,
        NO_SEX,
        NO_PHENOTYPE
    }

    // phenotype
    private final static String MISSING_VALUE1 = "-9";
    private final static String MISSING_VALUE2 = "0";
    private final static String PHENOTYPE_UNAFFECTED = "1";
    private final static String PHENOTYPE_AFFECTED = "2";

    // Sex
    private final static String SEX_MALE = "1";
    private final static String SEX_FEMALE = "2";
    // other=unknown

    public PedReader() { }

    public final List<Sample> parse(File source, EnumSet<MissingPedFields> missingFields, SampleDataSource sampleDB) throws FileNotFoundException  {
        logger.info("Reading PED file " + source + " with missing fields: " + missingFields);
        return parse(new FileReader(source), missingFields, sampleDB);
    }

    public final List<Sample> parse(Reader reader, EnumSet<MissingPedFields> missingFields, SampleDataSource sampleDB) {
        final List<String> lines = new XReadLines(reader).readLines();

        // What are the record offsets?
        final int familyPos = missingFields.contains(MissingPedFields.NO_FAMILY_ID) ? -1 : 0;
        final int samplePos = familyPos + 1;
        final int paternalPos = missingFields.contains(MissingPedFields.NO_PARENTS) ? -1 : samplePos + 1;
        final int maternalPos = missingFields.contains(MissingPedFields.NO_PARENTS) ? -1 : paternalPos + 1;
        final int sexPos = missingFields.contains(MissingPedFields.NO_SEX) ? -1 : Math.max(maternalPos, samplePos) + 1;
        final int phenotypePos = missingFields.contains(MissingPedFields.NO_PHENOTYPE) ? -1 : Math.max(sexPos, Math.max(maternalPos, samplePos)) + 1;
        final int nExpectedFields = MathUtils.arrayMaxInt(Arrays.asList(samplePos, paternalPos, maternalPos, sexPos, phenotypePos)) + 1;

        // go through once and determine properties
        int lineNo = 1;
        boolean isQT = false;
        final List<String[]> splits = new ArrayList<String[]>(lines.size());
        for ( final String line : lines ) {
            if ( line.startsWith(commentMarker)) continue;
            String[] parts = line.split("\\W+");

            if ( parts.length != nExpectedFields )
                throw new UserException.MalformedFile(reader.toString(), "Bad PED line " + lineNo + ": wrong number of fields");

            if ( phenotypePos != -1 ) {
                isQT = isQT || CATAGORICAL_TRAIT_VALUES.contains(parts[phenotypePos]);
            }

            splits.add(parts);
            lineNo++;
        }
        logger.info("Trait is quantitative? " + isQT);

        // now go through and parse each record
        lineNo = 1;
        final List<Sample> samples = new ArrayList<Sample>(splits.size());
        for ( final String[] parts : splits ) {
            String familyID = null, individualID, paternalID = null, maternalID = null;
            Gender sex = Gender.UNKNOWN;
            double quantitativePhenotype = Sample.UNSET_QT;
            Affection affection = Affection.UNKNOWN;

            if ( familyPos != -1 ) familyID = maybeMissing(parts[familyPos]);
            individualID = parts[samplePos];
            if ( paternalPos != -1 ) paternalID = maybeMissing(parts[paternalPos]);
            if ( maternalPos != -1 ) maternalID = maybeMissing(parts[maternalPos]);

            if ( sexPos != -1 ) {
                if ( parts[sexPos].equals(SEX_MALE) ) sex = Gender.MALE;
                else if ( parts[sexPos].equals(SEX_FEMALE) ) sex = Gender.FEMALE;
                else sex = Gender.UNKNOWN;
            }

            if ( phenotypePos != -1 ) {
                if ( isQT ) {
                    if ( parts[phenotypePos].equals(MISSING_VALUE1) )
                        affection = Affection.UNKNOWN;
                    else {
                        affection = Affection.QUANTITATIVE;
                        quantitativePhenotype = Double.valueOf(parts[phenotypePos]);
                    }
                } else {
                    if ( parts[phenotypePos].equals(MISSING_VALUE1) ) affection = Affection.UNKNOWN;
                    else if ( parts[phenotypePos].equals(MISSING_VALUE2) ) affection = Affection.UNKNOWN;
                    else if ( parts[phenotypePos].equals(PHENOTYPE_UNAFFECTED) ) affection = Affection.UNAFFECTED;
                    else if ( parts[phenotypePos].equals(PHENOTYPE_AFFECTED) ) affection = Affection.AFFECTED;
                    else throw new ReviewedStingException("Unexpected phenotype type " + parts[phenotypePos] + " at line " + lineNo);
                }
            }

            final Sample s = new Sample(familyID, sampleDB, individualID, paternalID, maternalID, sex, affection, quantitativePhenotype);
            samples.add(s);
            sampleDB.addSample(s);
            lineNo++;
        }

        sampleDB.validate(samples);
        return samples;
    }

    private final static String maybeMissing(final String string) {
        if ( string.equals(MISSING_VALUE1) || string.equals(MISSING_VALUE2) )
            return null;
        else
            return string;
    }
}