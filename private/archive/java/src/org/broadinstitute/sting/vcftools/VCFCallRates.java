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

package org.broadinstitute.sting.tools.vcf;
import org.broad.tribble.vcf.VCFGenotypeEncoding;
import org.broad.tribble.vcf.VCFGenotypeRecord;
import org.broad.tribble.vcf.VCFHeader;
import org.broad.tribble.vcf.VCFRecord;
import org.broadinstitute.sting.commandline.CommandLineProgram;
import org.broadinstitute.sting.commandline.Argument;

import java.io.*;
import java.util.*;

import net.sf.picard.util.Interval;
import org.broadinstitute.sting.utils.genotype.vcf.VCFReader;


class VCFCallRates extends CommandLineProgram
{
		@Argument(fullName = "vcf", shortName = "vcf", doc = "file to open", required = true) public String filename;
		@Argument(fullName = "out", shortName = "out", doc = "file to write results to", required = true) public String output_filename;
		@Argument(fullName = "auto_correct", shortName = "auto_correct", doc = "auto-correct the VCF file if it's off-spec", required = false) public Boolean autocorrect = false;
		@Argument(fullName = "verbose", shortName = "verbose", doc = "print extremely detailed stats", required = false) public Boolean verbose = false;
		@Argument(fullName = "min_call_rate", shortName = "min_call_rate", doc = "what fraction of samples must have a call", required = false) public double min_call_rate = 0.9;

		@Override
		protected int execute() 
		{
			//System.out.println("Loading " + filename + "...");
		
			PrintStream output = null;
			try
			{
				output = new PrintStream(new FileOutputStream(output_filename));
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}

			VCFReader reader;

			if (autocorrect) 
			{ 
				reader = new VCFReader(new File(filename),new VCFHomogenizer());
			}
			else 
			{ 
				reader = new VCFReader(new File(filename)); 
			}
		
			VCFHeader header = reader.getHeader();
			VCFRecord record = reader.next();

			String[] sample_names = record.getSampleNames();
			int[] individual_counts = new int[sample_names.length];
			int[] individual_drops  = new int[sample_names.length];

			while(true)
			{
				if (record == null) { break; }

				Interval interval = VCFTool.getIntervalFromRecord(record);
					
					// (unless it is "filtered")
					if (record.isFiltered())
					{
						record = reader.next();
					}
					
					char ref = record.getReference().charAt(0);
					
					String[] new_sample_names = record.getSampleNames();
					if (new_sample_names.length != sample_names.length) { throw new RuntimeException(); }
					for (int i = 0; i < new_sample_names.length; i++) { if (! sample_names[i].equals(new_sample_names[i])) { throw new RuntimeException(); } }

					List<VCFGenotypeRecord> genotypes = record.getVCFGenotypeRecords();

					long n_ref = 0;
					long n_alt = 0;
					long n_total = 0;
					long n_calls = 0;
					long n_dropped = 0;

					for (int i = 0; i < sample_names.length; i++)
					{
						VCFGenotypeRecord rec = genotypes.get(i);

						Long gq;

						if (rec.getFields().get("GQ") != null)
						{
							Double gq_double = Double.parseDouble(rec.getFields().get("GQ"));
							gq = gq_double.longValue();
						}
						else
						{
							gq = 0L;
						}

						List<VCFGenotypeEncoding> alleles = rec.getAlleles();

						String g = "";
						for (int j = 0; j < alleles.size(); j++) { g += alleles.get(j).getBases(); }
						char[] c = g.toCharArray();
						Arrays.sort(c);
						g = new String(c);
						n_total += 1;

						individual_counts[i] += 1;
						if (g.equals(".."))
						{
							n_dropped += 1;
							individual_drops[i] += 1;
							continue;
						}
						n_calls += 1;
						if (g.charAt(0) == ref) { n_ref += 1; } else { n_alt += 1; }
						if (g.charAt(1) == ref) { n_ref += 1; } else { n_alt += 1; }
					}

					output.printf("SNP %s %d %d %f\n", interval, n_total, n_dropped, (double)n_dropped / (double)n_total);

					record = reader.next();
			}


			// Now output the statistics.

			for (int i = 0; i < sample_names.length; i++)
			{
				int n_total = individual_counts[i];
				int n_dropped = individual_drops[i];
				output.printf("INDIVIDUAL %s %d %d %f\n", sample_names[i], n_total, n_dropped, (double)n_dropped / (double)n_total);
			}

			output.flush();
			output.close();


			return 0;
		}
}
