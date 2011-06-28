/*
 * Copyright (c) 2010, The Broad Institute
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

package org.broadinstitute.sting.gatk.walkers.validation;

import org.broadinstitute.sting.utils.variantcontext.VariantContext;
import org.broadinstitute.sting.utils.codecs.vcf.*;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.utils.variantcontext.VariantContextUtils;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.*;
import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.utils.exceptions.UserException;
import org.broadinstitute.sting.utils.codecs.vcf.VCFUtils;

import java.util.*;


/**
 * Declares the validity of variants in a vcf as either true or false. For use with the IGV crowd-sourcing bed generation
 */

@Requires(value={},referenceMetaData=@RMD(name="validated", type=VariantContext.class))
public class DeclareValidityWalker   extends RodWalker<Integer, Integer>{

    @Output(doc="File to which variants should be written",required=true)
    protected VCFWriter vcfWriter = null;

    @Argument(fullName = "validity", shortName = "V",
            doc = "Rank of variant validity on a 0-4 scale where 0 is definitely false positive; 4 is definitely true positive.")
    int validity;

    @Argument(fullName = "Note", shortName = "N", doc = "Annotation to be included in FP/TP field", required = false)
    String note =".";

    @Argument(fullName = "Source", shortName = "s", doc = "Institutional source of annotation", required = false)
    String source = ".";

    @Argument(fullName = "Build", shortName = "bld", doc = "Genome build", required = false)
    String build = ".";



    public Integer reduceInit() {

        for(char a : note.toCharArray()){
            if(Character.isWhitespace(a)) throw new UserException("White space is not allowed in VCF Info fields, please omit it from your build, note, and source arguments.");
        }

        for(char b : source.toCharArray()){
            if(Character.isWhitespace(b)) throw new UserException("White space is not allowed in VCF Info fields, please omit it from your build, note, and source arguments.");
        }

        Set<VCFHeaderLine> old = VCFUtils.getHeaderFields(getToolkit());
        Set<VCFHeaderLine> newlines = new HashSet<VCFHeaderLine>();
        for(VCFHeaderLine each : old){
            if(each.getKey().equals("fileformat")) newlines.add(each);
        }

        if (build.equals(".")) build=getBuild();
        VCFHeaderLine ref = new VCFHeaderLine("reference", build);
        newlines.add(ref);
        vcfWriter.writeHeader(new VCFHeader(newlines));

        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }







    public Map<String, Object> addValidation(int Validity, String Note, String Source){



         HashMap<String, Object> validityAnnots = new HashMap<String, Object>();
         validityAnnots.put("validity", Validity);
         validityAnnots.put("user", System.getenv("USER"));
         validityAnnots.put("note", Note);
         validityAnnots.put("Source", Source);

        return validityAnnots;
    }

    public String getBuild(){
        String refPath = getToolkit().getArguments().referenceFile.getPath();
        if (refPath.contains("19")) {return "hg19";}
        else if (refPath.contains("18")) {return "hg18";}
        else if (refPath.contains("36")) {return "b36";}
        else if (refPath.contains("37")) {return "b37";}
        else {return "unknown";}
    }
 /**
     *
     * @param tracker  the meta-data tracker
     * @param ref      the reference base
     * @param context  the context for the given locus
     * @return 1 if the locus was successfully processed, 0 if otherwise
     */
     public Integer map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context){
         if ( tracker == null )
            return 0;


         VariantContext current = tracker.getVariantContext(ref, "validated", context.getLocation());
         if (current == null) {
             return 0;}

         VariantContext declared = VariantContext.modifyAttributes( current, addValidation(validity, note, source));
         vcfWriter.add(declared, ref.getBase());
         return 1;
     }

    public Integer reduce(Integer counter, Integer sum) {
        return counter+sum;
    }

}
