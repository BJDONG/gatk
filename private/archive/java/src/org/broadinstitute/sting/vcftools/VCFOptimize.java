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
import org.broad.tribble.vcf.VCFHeader;
import org.broad.tribble.vcf.VCFRecord;
import org.broadinstitute.sting.commandline.CommandLineProgram;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.utils.genotype.vcf.VCFReader;


import java.io.*;
import java.util.*;

//import org.apache.commons.math.optimization.*;
//import org.apache.commons.math.optimization.direct.*;
//import org.apache.commons.math.analysis.MultivariateRealFunction;

// Program for frequency-specific  VCF-files.


/**
 * @author jmaguire
 */


class VCFOptimize extends CommandLineProgram 
{
		@Argument(fullName = "vcf", shortName = "vcf", doc = "file to open", required = true) public String filename;
		@Argument(fullName = "auto_correct", shortName = "auto_correct", doc = "auto-correct the VCF file if it's off-spec", required = false) public Boolean autocorrect = false;
		@Argument(fullName = "target_TsTv", shortName = "target_TsTv", doc = "Minimum acceptable TsTv", required=false) public double target_TsTv = 2.07;
		@Argument(fullName = "output", shortName = "output", doc = "file to write cuts to", required = true) public String output_filename;
		@Argument(fullName = "min_calls", shortName = "min_calls", doc = "Minimum signifigant number of calls", required=false) public int min_calls = 100;
		@Argument(fullName = "num_breaks", shortName = "num_breaks", doc = "Number of breaks to search over", required=false) public int num_breaks = 100;

		// Debugging arguments:
		@Argument(fullName = "n_records", shortName = "n_records", doc = "Number of records to load (debugging)", required=false) public int n_records_to_process = Integer.MAX_VALUE;
		@Argument(fullName = "verbose", shortName = "verbose", doc = "print detailed debugging info.", required=false) public boolean verbose = false;

		class OptimizationRecord
		{
			public boolean transition;
			public int freq;
			public double[] features;
			
			public OptimizationRecord(boolean transition, int freq, double[] features)
			{
				this.transition = transition;
				this.freq       = freq;
				this.features   = features.clone();
			}

			public OptimizationRecord clone()
			{
				return new OptimizationRecord(transition, freq, features.clone());
			}
		}

		private OptimizationRecord pack(VCFHeader header, VCFRecord input)
		{
			Map<String,String> info = input.getInfoValues();
			
			if (! info.containsKey("AC")) 
			{ 
				throw new RuntimeException("AC not present in record: \n" + input.toStringEncoding(header));
			}
			if (! info.containsKey("DP")) 
			{ 
				throw new RuntimeException("DP not present in record: \n" + input.toStringEncoding(header));
			}
			if (! info.containsKey("SB")) 
			{ 
				throw new RuntimeException("SB not present in record: \n" + input.toStringEncoding(header));
			}

			boolean transition = VCFTool.isTransition(input);
			int freq           = Integer.parseInt(input.getInfoValues().get("AC"));
			double LOD         = input.getQual();
			double depth       = Double.parseDouble(input.getInfoValues().get("DP"));
			double SLOD        = Double.parseDouble(input.getInfoValues().get("SB"));

			double[] features = new double[2];
			features[0] = LOD;
			features[1] = -1*SLOD;
	
			return new OptimizationRecord(transition, freq, features);
		}

			// This is the objective function we're searching in.
			// if (tstv>=min) { return #snps; } else { return -inf; }
			public double tstv(double[] point, OptimizationRecord[] records)
			{
				double transitions   = 0;
				double transversions = 0;
				double total         = 0;
				for (int i = 0; i < records.length; i++)
				{
					int j = 0;
					for (j = 0; j < point.length; j++)
					{
//						if (records == null) { System.out.printf("records==null\n"); }
//						if (records[i] == null) { System.out.printf("records[%d]==null\n", i); }
//						if (records[i].features == null) { System.out.printf("records[%d].features==null\n", i); }

						if (records[i].features[j] < point[j]) { break; }
					}
					if (j == point.length)
					{
						if (records[i].transition == true) { transitions += 1; }
						else { transversions += 1; }
						total += 1;
					}
				}

				double tstv = transitions / transversions;
				return tstv;
			}


			// This is the objective function we're searching in.
			// if (tstv>=min) { return #snps; } else { return -inf; }
			public double num_calls(double[] point, OptimizationRecord[] records)
			{
				double total = 0;
				for (int i = 0; i < records.length; i++)
				{
					int j = 0;
					for (j = 0; j < point.length; j++)
					{
//						if (records == null) { System.out.printf("records==null\n"); }
//						if (records[i] == null) { System.out.printf("records[%d]==null\n", i); }
//						if (records[i].features == null) { System.out.printf("records[%d].features==null\n", i); }

						if (records[i].features[j] < point[j]) { break; }
					}
					if (j == point.length)
					{
						total += 1;
					}
				}

				return total;
			}


			public class Cut
			{
				public double lod;
				public double slod;
				public int freq;

				public Cut(double lod, double slod)
				{
					this.lod = lod;
					this.slod = slod;
					this.freq = -1;
				}

				public Cut(double lod, double slod, int freq)
				{
					this.lod = lod;
					this.slod = slod;
					this.freq = freq;
				}

				public Cut(String record)
				{
					String[] tokens = record.split("\\s+");
					this.freq = Integer.parseInt(tokens[0]);					
					this.lod  = Double.parseDouble(tokens[1]);					
					this.slod = Double.parseDouble(tokens[2]);					
				}

				public String toString()
				{
					return String.format("%d %f %f", freq, lod, slod);
				}
			}


		// Just a simple grid search.
		private Cut optimize(OptimizationRecord[] records, double min_TsTv, int freq)
		{


			double[] lods  = new double[records.length];
			double[] slods = new double[records.length];
			for (int i = 0; i < lods.length; i++)
			{
				lods[i]  = records[i].features[0];
				slods[i] = records[i].features[1];
			}

			Arrays.sort(lods);
			Arrays.sort(slods);

			double[] lod_breaks  = new double[num_breaks];
			double[] slod_breaks = new double[num_breaks];
			int bin_size = 1 + (records.length / num_breaks);

			//System.out.printf("BREAKS i j lod slod\n");
			int j = 0;
			for (int i = 0; i < records.length; i += bin_size)
			{
				lod_breaks[j] = lods[i];
				slod_breaks[j] = slods[i];
				j += 1;
				//System.out.printf("BREAKS %d %d %f %f\n", i, j, lods[i], slods[i]);
			}
			//System.out.printf("\n");

			double best_lod       = lod_breaks[0];
			double best_slod      = slod_breaks[0];

			int best_lod_idx       = 0;
			int best_slod_idx      = 0;

			double[] point = new double[2];
			point[0] = best_lod;
			point[1] = best_slod;

			double best_tstv      = tstv(point, records);
			double best_num_calls = num_calls(point, records);
			boolean flag = false;

			//for (double lod = 0; lod < 8000; lod += 10)
			for (int lod_idx = 0; lod_idx < num_breaks; lod_idx += 1)
			{
				double lod = lod_breaks[lod_idx];
				//for (double slod = -4000; slod < 1000; slod += 10)
				for (int slod_idx = 0; slod_idx < num_breaks; slod_idx += 1)
				{
					double slod = slod_breaks[slod_idx];

					point = new double[2];
					point[0] = lod;
					point[1] = slod;
					double tstv      = tstv(point, records);
					double num_calls = num_calls(point, records);
					
					if (num_calls < min_calls) { continue; }

					if ((tstv >= min_TsTv) && (num_calls > best_num_calls)) 
					{ 
						best_lod=lod; 
						best_slod=slod; 
						best_tstv=tstv; 
						best_num_calls=num_calls; 
						best_lod_idx = lod_idx;
						best_slod_idx = slod_idx;
						flag=true;
					}
					else if ((tstv >= best_tstv) && (!flag)) 
					{ 
						best_lod=lod; 
						best_slod=slod; 
						best_tstv=tstv; 
						best_num_calls=num_calls;
						best_lod_idx = lod_idx;
						best_slod_idx = slod_idx;
					}


					if (verbose)
					{
						System.out.printf("DEBUG: %d | %d %d | %f %f %f %f | %f %f %f %f\n", 
									freq, 
									lod_idx, slod_idx,
									lod, slod, num_calls, tstv,
									best_lod, best_slod, best_num_calls, best_tstv);
					}
				}
			}
			
			//System.out.printf("Found optimum: lod=%f slod=%f num_calls=%f tstv=%f\n", best_lod, best_slod, best_num_calls, best_tstv);
			System.out.printf("%d %d %d %f %f %f %f\n", freq, best_lod_idx, best_slod_idx, best_lod, best_slod, best_num_calls, best_tstv);

			return new Cut(best_lod, best_slod);
		}

		@Override
		protected int execute() 
		{
			System.out.println("Loading " + filename + "...");
		
			VCFReader reader = null;

			if (autocorrect) { reader = new VCFReader(new File(filename),new VCFHomogenizer()); }
			else { reader = new VCFReader(new File(filename)); }

			PrintWriter output = null;
			try
			{
				output = new PrintWriter(new FileWriter(output_filename));
			}
			catch (Exception e)
			{
				throw new RuntimeException(e); 
			}

			VCFHeader header = reader.getHeader();

			HashMap<Integer,ArrayList<OptimizationRecord>> records = new HashMap<Integer,ArrayList<OptimizationRecord>>();

			Date start_time = new Date();
			int n_records_processed = 0;
			int max_freq = 0;
			while(reader.hasNext())
			{
				VCFRecord record = reader.next();
		
				OptimizationRecord optimization_record = pack(header, record);

				if (optimization_record.freq > max_freq) { max_freq = optimization_record.freq; }

				if (! records.containsKey(optimization_record.freq)) { records.put(optimization_record.freq, new ArrayList<OptimizationRecord>()); }
				records.get(optimization_record.freq).add(optimization_record.clone());

				n_records_processed += 1;

				if (n_records_processed == n_records_to_process) { break; }
			}
			System.out.printf("Loaded %d records\n", n_records_processed);

			//for (int freq = 1; freq <= 5; freq += 1)
			for (int freq = 1; freq <= max_freq; freq += 1)
			{
				if (records.get(freq) == null) { System.out.printf("Skipping AAF %d (no calls)\n", freq); continue; }
				System.out.printf("\nOptimizing AAF %d...\n", freq);

				OptimizationRecord[] fnord = new OptimizationRecord[records.get(freq).size()];
				Cut cut = optimize(records.get(freq).toArray(fnord), target_TsTv, freq);
				cut.freq = freq;

				output.println(cut);
			}
			output.flush();
			output.close();
			
			return 0;
		}
}
