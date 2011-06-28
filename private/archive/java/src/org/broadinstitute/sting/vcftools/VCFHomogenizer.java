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

import org.broad.tribble.vcf.VCFCodec;

import java.io.*;
import java.util.zip.*;

// Edit a VCF on the fly to be on-spec.

/** 
 * @author jmaguire
 */

class VCFHomogenizer implements VCFCodec.LineTransform {

	//my ($chr, $off, $id, $ref, $alt, $qual, $filter, $info, $format, @genotypes) = @tokens;
	public String lineTransform(String input)
	{
		if (input == null) { return null; }

		//System.out.println("input : " + input);

		// Make it tab-delimited
		input = input.replaceAll(" +", "\t");
		
		/////////
		// Header corrections
		if (input.startsWith("##format=VCFv3.2")) { return "##format=VCRv3.2\n"; }
		if (input.startsWith("#CHROM")) { return input.replaceAll("PROB", "QUAL"); }
		if (input.startsWith("#")) { return input; }

		/////////
		// Line-level corrections
		
		// make "nan" into "NaN"
		input = input.replaceAll("nan", "NaN");
		input = input.replaceAll("DB(\\;|\\s)", "DB=1$1");
		input = input.replaceAll("HM2(\\;|\\s)", "HM2=1$1");
		input = input.replaceAll("HM3(\\;|\\s)", "HM3=1$1");

		String[] tokens = input.split("\\s+");

		/////////
		// Token-level corrections

		// if alt is "N", make it "."
		if (tokens[4].equals("N")) { tokens[4] = "."; }
		if (tokens[5].equals(".")) { tokens[5] = "-1"; }

		String ref = tokens[3];
		String alt = tokens[4];
		String[] alts = alt.split(",");

		for (int i = 9; i < tokens.length; i++)
		{
			if (tokens[i].equals(".")) { tokens[i] = "./.:0"; }

			tokens[i] = tokens[i].replaceAll(ref, "0");
			if (! alt.equals(".")) 
			{ 
				if (alts.length == 1)
				{
					tokens[i] = tokens[i].replaceAll(alt, "1"); 
				}
				else
				{
					for (int j = 0; j < alts.length; j++)
					{
						tokens[i] = tokens[i].replaceAll(alts[j], "1"); 
					}
				}
			}
		}

		/////////
		// Info-level corrections

		String info = tokens[7];
		String new_info = "";
		String[] info_tokens = info.split(";");				
		for (int i = 0; i < info_tokens.length; i++)
		{
			if (info_tokens[i].startsWith("R2="))
			{
				// Fix NaN's in RNaN's in R2.
				String new_token = info_tokens[i].replace("NaN", "0.0");
				info_tokens[i] = new_token;
			}
			else if (info_tokens[i].startsWith("AC="))
			{
				// Fix the case where AC includes the ref count first.
				String[] ACs  = info_tokens[i].replaceAll("^AC=", "").split(",");
				if (ACs.length == alts.length+1)
				{
					String new_ACs = "";
					for (int j = 1; j < ACs.length; j++)
					{
						new_ACs += ACs[j];
						if (j != (ACs.length-1)) { new_ACs += ","; }
					}	
					info_tokens[i] = "AC=" + new_ACs;
					continue;
				}
			}

			new_info += info_tokens[i];
			if (i != (info_tokens.length-1)) { new_info += ";"; }
		}
		tokens[7] = new_info;


		/////////
		// Now put it back together and emit.
		String output = tokens[0];
		for (int i = 1; i < tokens.length; i++)
		{
			output = output + "\t" + tokens[i];
		}
		output = output + "\n";

		//System.out.println("output: " + output);

		return output;
	}
}



