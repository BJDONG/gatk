package org.broadinstitute.sting.gatk.walkers;


import org.apache.log4j.Logger;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.refdata.Genotype;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.refdata.ReferenceOrderedDatum;
import org.broadinstitute.sting.gatk.walkers.RefWalker;
import org.broadinstitute.sting.utils.GenotypingCallStats;
import org.broadinstitute.sting.utils.TrioConcordanceRecord;
import org.broadinstitute.sting.utils.GenotypeUtils;
import org.broadinstitute.sting.utils.cmdLine.Argument;

import java.util.List;

//@Requires(value=DataSource.REFERENCE,referenceMetaData={@RMD(name="mother",type=rodSAMPileup.class),
//                                                        @RMD(name="father",type=rodSAMPileup.class),
//                                                        @RMD(name="daughter",type=rodSAMPileup.class)})
public class MendelianInheritanceWalker  extends RefWalker<TrioConcordanceRecord, TrioConcordanceRecord> {

	@Argument(fullName="point_consensus_cutoff", shortName="XPC", doc="confidence cutoff for consensus in point genotype", required=true ) public Double POINT_CONS_CUTOFF;
	@Argument(fullName="point_variant_cutoff", shortName="XPV", doc="confidence cutoff for variant (snp) in point genotype", required=true ) public Double POINT_VAR_CUTOFF;
	@Argument(fullName="indel_consensus_cutoff", shortName="XIC", doc="confidence cutoff for consensus in indel genotype", required=true ) public Double INDEL_CONS_CUTOFF;
	@Argument(fullName="indel_variant_cutoff", shortName="XIV", doc="confidence cutoff for variant (snp) in indel genotype", required=true ) public Double INDEL_VAR_CUTOFF;
	@Argument(fullName="log_concordant", shortName="LC",doc="If set, all trio-concordant sites will be logged at level INFO") public boolean LOG_CONCORDANT; 
	@Argument(fullName="log_discordant", shortName="LD",doc="If set, all trio-discordant sites will be logged at level INFO") public boolean LOG_DISCORDANT; 
	@Argument(fullName="default_reference_calls",shortName="DRC",
			doc="If set,  any position where the specified genotype is NOT explicitly specified, while the other is provided, is considered to be an implicit confident 'reference' (no-indel or no-snp) call") 
			public boolean defCalls;
	@Argument(fullName="variant_type",
					      shortName="VT",
					      doc="Assess concordance for the variants of the specified type, INDEL or POINT. If genotype track(s) provide both types, the requested one will be selected",
					      required=true) 
					      public String VTYPE_STR; 
	
	private static Logger logger = Logger.getLogger(MendelianInheritanceWalker.class);	
	private final static String star = new String("*");
	private GenotypeUtils.VariantType VARIANT_TYPE;
	
	@Override
	public TrioConcordanceRecord map(RefMetaDataTracker rodData, ReferenceContext ref, AlignmentContext context) {
				
//		String outLine = new String(context.getLocation() + " REF: "+ref + " RODS:" + rodData.getAllRods().size());
		
		ReferenceOrderedDatum rodMom = rodData.lookup("mother", null);
		ReferenceOrderedDatum rodDad = rodData.lookup("father", null);
		ReferenceOrderedDatum rodKid = rodData.lookup("daughter", null);
		
		Genotype mom = GenotypeUtils.extractGenotype(rodMom,VARIANT_TYPE,defCalls);
		Genotype dad = GenotypeUtils.extractGenotype(rodDad,VARIANT_TYPE,defCalls);
		Genotype kid = GenotypeUtils.extractGenotype(rodKid,VARIANT_TYPE,defCalls);

		return assessGenotypesInTrio(mom, dad, kid);
	}
	

/**	
 * 	@Override
 * @see org.broadinstitute.sting.gatk.walkers.Walker#initialize()
 */
	public void initialize() {
		super.initialize();
		VARIANT_TYPE = GenotypeUtils.VariantType.valueOf(VTYPE_STR.toUpperCase());
	};


	/** Takes a single genotype object and returns properly filled new assessment object (covered/assessed/ref/variant set to 0/1 
	 * according to what the genotype says)  
	 * @param g
	 * @return
	 */
	protected GenotypingCallStats assessGenotype(Genotype g, GenotypingCallStats stats) {
		
		if ( g != null ) stats.covered = 1;
		
		if ( hasCall(g)) {
			stats.assessed = 1;
			if ( g.isReference() ) stats.ref = 1;
			else {
				stats.variant = 1;
				if ( ! g.isBiallelic() ) stats.non_biallelic_variant = 1;
			}
		}
		return stats;
	}
	
	public TrioConcordanceRecord assessGenotypesInTrio(Genotype gMom, Genotype gDad, Genotype gKid) {		

		TrioConcordanceRecord t = new TrioConcordanceRecord();
		
//		String outLine = new String(context.getLocation() + " REF: "+ref + " RODS:" + rodData.getAllRods().size());

		// first get separate stats on each individual
		assessGenotype(gMom,t.mom);
		assessGenotype(gDad,t.dad);
		assessGenotype(gKid,t.kid);
		
		//		if ( hasCall(mom) && mom.isIndel() ) System.out.println("GOT INDEL: "+mom.toString());
		
		if ( t.mom.covered == 0 || t.dad.covered == 0 || t.kid.covered== 0 ) return t; // current position is not covered in at least one individual, there's nothing else to do
		t.trio.covered = 1; // ok, base covered in a trio (e.g. in all individuals)
		
		if ( t.mom.assessed != 0 &&  t.dad.assessed != 0 && t.kid.assessed != 0 ) {
			t.trio.assessed = 1; // assessed in trio = assessed in each individual
		} else return t; // at least one individual is not assessed, nothing left to do
			
		// we are here only if everyone is assessed
						
		// NOTE: "consistent_ref" in individuals is counted only when all 3 are assessed AND all 3 are ref (i.e. ref call in a trio)
		if( gMom.isReference() && gDad.isReference() && gKid.isReference() ) { // everyone is a ref
			t.trio.ref = t.trio.consistent_ref = 1;
			t.mom.consistent_ref = 1;
			t.dad.consistent_ref = 1;
			t.kid.consistent_ref = 1;
			return t; // done
		}

		// by now we know that there's a variant in at least one of the individuals

		t.trio.variant = 1;

		if ( t.mom.non_biallelic_variant == 1 || t.dad.non_biallelic_variant == 1 || t.kid.non_biallelic_variant == 1 ) {
			t.trio.non_biallelic_variant = 1;
			return t;
		}

		String kid_allele_1 = gKid.getFWDAlleles().get(0);
		String kid_allele_2 = gKid.getFWDAlleles().get(1);
		List<String> mom_alleles = gMom.getFWDAlleles();
		List<String> dad_alleles = gDad.getFWDAlleles();
		
		// warning: no special processing for X/Y chromosomes yet; not an issue for daughter

			
			
		if ( mom_alleles.contains(kid_allele_1) && dad_alleles.contains(kid_allele_2) ||
					mom_alleles.contains(kid_allele_2) && dad_alleles.contains(kid_allele_1) ) {
				t.trio.consistent_variant = 1;
				if ( ! gMom.isReference() ) { 
					t.mom.consistent_variant = 1 ;
					if ( ! gKid.isReference()  ) t.mom_passed_variant = 1;
				}
				if ( ! gDad.isReference() ) {
					t.dad.consistent_variant = 1 ;
					if ( ! gKid.isReference()  ) t.dad_passed_variant = 1;
				}
				if ( ! gKid.isReference() ) t.kid.consistent_variant = 1 ; 
				
				if ( LOG_CONCORDANT ) {
					logger.info("consistent variant at "+gMom.getLocation() + 
							"("+gMom.getFWDRefBases()+")  mom: " + genotypeString(gMom) + " dad: " +
							genotypeString(gDad) + " kid: " + genotypeString(gKid)
							);
				}
		} else {	
				// we are inconsistent. let's see what happened:
				
			   t.trio.inconsistent_variant = 1;

			   if ( ! gMom.isReference() ) t.mom.inconsistent_variant = 1 ;
			   if ( ! gDad.isReference() ) 	t.dad.inconsistent_variant = 1 ;
			   if ( ! gKid.isReference()  ) t.kid.inconsistent_variant = 1;

			   if ( gKid.isReference() && ( ! gMom.isReference() && gMom.isHom() || ! gDad.isReference() && gDad.isHom() ) ) t.missing_variant_in_kid = 1;
			   if ( ! gKid.isReference() && gMom.isReference() && gDad.isReference()  ) t.missing_variant_in_parents = 1;
			   if ( ! gKid.isReference() && ( ! gMom.isReference() || ! gDad.isReference() )  ) t.nonmatching_variant_in_kid = 1;
				
				if ( LOG_DISCORDANT ) {
					logger.info("inconsistent variant at "+gMom.getLocation() + 
							"("+gMom.getFWDRefBases()+")  mom: " + genotypeString(gMom) + " dad: " +
							genotypeString(gDad) + " kid: " + genotypeString(gKid)
							);
				}

		}
				
		return t;
		
	}
	
	
	protected String alleleString(Genotype g, int n) {
		if ( g.getFWDAlleles().get(n).length() == 0 ) return star;
		return g.getFWDAlleles().get(n);
	}
	
	protected String genotypeString(Genotype g) {
		return alleleString(g, 0) +"/"+alleleString(g, 1);
	}

	@Override
	public TrioConcordanceRecord reduce(TrioConcordanceRecord value, TrioConcordanceRecord sum) {
		return sum.add(value);
	}

	@Override
	public TrioConcordanceRecord reduceInit() {
		
		return new TrioConcordanceRecord();
	}

	boolean hasCall(Genotype g) {
		if ( g == null ) return false; // there's no call if there's no rod data available, duh!

		if ( g.isReference() ) {
			if ( g.isPointGenotype() ) return g.getConsensusConfidence() >= POINT_CONS_CUTOFF ;
			else return g.getConsensusConfidence() >= INDEL_CONS_CUTOFF ;
		}
		else { // it's a variant
			if ( g.isPointGenotype() ) return g.getVariantConfidence() >= POINT_VAR_CUTOFF ;
			else return g.getVariantConfidence() >= INDEL_VAR_CUTOFF ;
		}
		
	}
	
	
	/*
	protected String shortLine(Genotype av) {
		
		if ( av == null )  return new String( "<NULL>");
		
		if ( av.isReference() ) return new String ("*");
		
		List<String> alleles = av.getFWDAlleles();
		
		if ( av.isSNP() ) {
            if  ( alleles.get(0).charAt(0) == av.getRef() ) return alleles.get(1);
            else return alleles.get(0);
		}
		if ( av.isInsertion() ) {
            if ( alleles.get(0).length() == 0 ) return new String('+'+alleles.get(1));
            else return new String('+'+alleles.get(0));
		}
		if ( av.isDeletion() ) {
            if ( alleles.get(0).length() == 0 ) return new String ('-'+alleles.get(0));
            else return new String('-'+alleles.get(1));
		}
		if ( av.isIndel() ) {
			return new String('?'+alleles.get(0));
		}
		return new String("<missing data!!!>");
	}
	*/
}
