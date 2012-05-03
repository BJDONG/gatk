package org.broadinstitute.sting.utils.codecs;

import org.broad.tribble.*;
import org.broad.tribble.exception.CodecLineParsingException;
import org.broad.tribble.readers.LineReader;
import org.broadinstitute.sting.utils.codecs.vcf.VCFConstants;
import org.broadinstitute.sting.utils.variantcontext.Allele;
import org.broadinstitute.sting.utils.variantcontext.Genotype;
import org.broadinstitute.sting.utils.variantcontext.VariantContext;
import org.broadinstitute.sting.utils.variantcontext.VariantContextBuilder;

import java.util.*;

/**
 * A codec for parsing soapsnp files
 *
 * <p>
 * A simple text file format with the following whitespace separated fields of 17 columns:
 * <ol>
 *     <li>Chromosome ID</li>
 *     <li>Coordinate on chromosome, start from 1</li>
 *     <li>Reference genotype</li>
 *     <li>Consensus genotype</li>
 *     <li>Quality score of consensus genotype</li>
 *     <li>Best base</li>
 *     <li>Average quality score of best base</li>
 *     <li>Count of uniquely mapped best base</li>
 *     <li>Count of all mapped best base</li>
 *     <li>Second best bases</li>
 *     <li>Average quality score of second best base</li>
 *     <li>Count of uniquely mapped second best base</li>
 *     <li>Count of all mapped second best base</li>
 *     <li>Sequencing depth of the site</li>
 *     <li>Rank sum test p_value</li>
 *     <li>Average copy number of nearby region</li>
 *     <li>Whether the site is a dbSNP</li>
 * </ol>
 * Note this codec is for internal use only, and is not supported outside of GSA.
 * </p>
 *
 * <p>
 * See also: @see <a href="http://soap.genomics.org.cn/soapsnp.html#usage2">SOAPSNP usage page</a><br>
 * </p>

 * </p>
 *
 * <h2>File format example</h2>
 * <pre>
 *     chr1    205     A       C       2       C       18      2       2       A       0       0       0       2       2       1.00000 1.00000 0
 *     chr1    492     C       Y       19      T       34      2       2       C       34      1       1       3       3       0.666667        1.00000 1
 *     chr1    1540    G       C       3       C       34      2       2       G       0       0       1       3       3       1.00000 1.33333 0
 *     chr1    1555    A       C       3       C       33      2       2       A       0       0       0       2       2       1.00000 1.00000 0
 *     chr1    4770    A       G       14      G       33      6       8       A       0       0       3       11      11      1.00000 1.54545 0
 *     chr1    4793    A       G       17      G       33      7       8       A       0       0       3       11      11      1.00000 1.45455 0
 *     chr1    126137  C       S       0       G       34      1       1       C       0       0       1       2       2       0.00000 1.50000 0
 *     chr1    218136  G       R       36      G       34      32      378     A       34      7       58      436     436     0.507135        1.91055 0
 *     chr1    218178  G       R       54      G       33      44      655     A       34      9       185     841     841     0.504643        1.93698 0
 *     chr1    218326  G       S       20      G       33      100     1665    C       33      7       60      1727    1727    0.462359        1.93804 0
 * </pre>
 *
 * @author Mark DePristo
 * @since 2010
 */
public class SoapSNPCodec extends AsciiFeatureCodec<VariantContext> implements NameAwareCodec {
    private String[] parts;

    // we store a name to give to each of the variant contexts we emit
    private String name = "Unknown";

    public SoapSNPCodec() {
        super(VariantContext.class);
    }

    /**
     * Decode a line as a Feature.
     *
     * @param line
     *
     * @return Return the Feature encoded by the line,  or null if the line does not represent a feature (e.g. is
     *         a comment)
     */
    public VariantContext decode(String line) {
        try {
            // parse into lines
            parts = line.trim().split("\\s+");

            // check that we got the correct number of tokens in the split
            if (parts.length != 18)
                throw new CodecLineParsingException("Invalid SoapSNP row found -- incorrect element count.  Expected 18, got " + parts.length + " line = " + line);

            String contig = parts[0];
            long start = Long.valueOf(parts[1]);
            AlleleAndGenotype allelesAndGenotype = parseAlleles(parts[2], parts[3], line);

            double log10PError = Integer.valueOf(parts[4]) / -10.0;

            Map<String, Object> attributes = new HashMap<String, Object>();
            attributes.put("BestBaseQ", parts[6]);
            attributes.put("SecondBestBaseQ", parts[10]);
            attributes.put("RankSumP", parts[15]);
            // add info to keys

            //System.out.printf("Alleles  = " + allelesAndGenotype.alleles);
            //System.out.printf("genotype = " + allelesAndGenotype.genotype);
            
            VariantContext vc = new VariantContextBuilder(name, contig, start, start, allelesAndGenotype.alleles).genotypes(allelesAndGenotype.genotype).log10PError(log10PError).passFilters().attributes(attributes).make();

            //System.out.printf("line  = %s%n", line);
            //System.out.printf("vc    = %s%n", vc);

            return vc;
        } catch (CodecLineParsingException e) {
            throw new TribbleException("Unable to parse line " + line,e);
        } catch (NumberFormatException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            throw new TribbleException("Unable to parse line " + line,e);
        }
    }

    private static class AlleleAndGenotype {
        Collection<Allele> alleles;
        Collection<Genotype> genotype;

        public AlleleAndGenotype(Collection<Allele> alleles, Genotype genotype) {
            this.alleles = alleles;
            this.genotype = new HashSet<Genotype>();
            this.genotype.add(genotype);
        }
    }

    private AlleleAndGenotype parseAlleles(String ref, String consensusGenotype, String line) {
        /* A	Adenine
    C	Cytosine
    G	Guanine
    T (or U)	Thymine (or Uracil)
    R	A or G
    Y	C or T
    S	G or C
    W	A or T
    K	G or T
    M	A or C
    B	C or G or T
    D	A or G or T
    H	A or C or T
    V	A or C or G
    N	any base
    . or -	gap
    */
        if ( ref.equals(consensusGenotype) )
            throw new TribbleException.InternalCodecException("Ref base and consensus genotype are the same " + ref);

        Allele refAllele = Allele.create(ref, true);
        List<Allele> genotypeAlleles = null;

        char base = consensusGenotype.charAt(0);

        switch ( base ) {
            case 'A': case 'C': case 'G': case 'T':
                Allele a = Allele.create(consensusGenotype);
                genotypeAlleles = Arrays.asList(a, a);
                break;
            case 'R': case 'Y': case 'S': case 'W': case 'K': case 'M':
                genotypeAlleles = determineAlt(refAllele, ref.charAt(0), base);
                break;
            default:
                throw new TribbleException("Unexpected consensus genotype " + consensusGenotype + " at line = " + line);
        }


        Collection<Allele> alleles = new HashSet<Allele>(genotypeAlleles);
        alleles.add(refAllele);
        Genotype genotype = new Genotype("unknown", genotypeAlleles); // todo -- probably should include genotype quality

        return new AlleleAndGenotype( alleles, genotype );
    }

    private static final Map<Character, String> IUPAC_SNPS = new HashMap<Character, String>();
    static {
        IUPAC_SNPS.put('R', "AG");
        IUPAC_SNPS.put('Y', "CT");
        IUPAC_SNPS.put('S', "GC");
        IUPAC_SNPS.put('W', "AT");
        IUPAC_SNPS.put('K', "GT");
        IUPAC_SNPS.put('M', "AC");
    }

    private List<Allele> determineAlt(Allele ref, char refbase, char alt) {
        String alts = IUPAC_SNPS.get(alt);
        if ( alts == null )
            throw new IllegalStateException("BUG: unexpected consensus genotype " + alt);
            
        Allele a1 = alts.charAt(0) == refbase ? ref : Allele.create((byte)alts.charAt(0));
        Allele a2 = alts.charAt(1) == refbase ? ref : Allele.create((byte)alts.charAt(1));

        //if ( a1 != ref && a2 != ref )
        //    throw new IllegalStateException("BUG: unexpected consensus genotype " + alt + " does not contain the reference base " + ref);

        return Arrays.asList(a1, a2);
    }

    /**
     * get the name of this codec
     * @return our set name
     */
    public String getName() {
        return name;
    }

    /**
     * set the name of this codec
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.printf("Testing " + args[0]);
    }
}