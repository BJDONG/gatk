#Before executing this file, save squid files as csv, then as tab deliminated files with only the column values as the header, change the format of all cells to numbers. Assign the path to these files to "samples" and "lanes" respectively. 
#testcomment
args<-commandArgs(TRUE)
lanes<-args[1]
samples<-args[2]
sample_sets<-args[3]
eval<-args[4]
noveltitv<-args[5]
knowntitv<-args[6]
DOC<-args[7]

if(is.na(sample_sets)){
	print("Please specify sample set for file naming and press enter.")
	scan("stdin", what="character",n=1)->sample_sets
	print("Thanks!")
	}

	if(is.na(lanes) == FALSE && is.na(samples)==FALSE){
		#this makes a table & graphs using Picard data
		read.delim(file=lanes, header= TRUE)->bylane; 
    	read.delim(file=samples, header= TRUE)->bysample; 

		#Calc by lane metrics
	   	attach(bylane);
	   	callable.target<-HS_TARGET_TERRITORY[1]; 
   		singlelanes<-length(which(Lane.Type=="Single"));
   		pairedlanes<-length(which(Lane.Type=="Paired"));
   	    mean.read.lane<-signif(mean(AL_TOTAL_READS, na.rm=TRUE));
	    sd.read.lane<-signif(sd(AL_TOTAL_READS, na.rm=TRUE));
	    mean.ub.lane<-signif(mean(HS_ON_TARGET_BASES, na.rm=TRUE));
	    sd.ub.lane<-signif(sd(HS_ON_TARGET_BASES, na.rm=TRUE));
	    mean.cov.lane<-round(mean(HS_MEAN_TARGET_COVERAGE, na.rm=TRUE));
    	sd.cov.lane<-round(sd(HS_MEAN_TARGET_COVERAGE, na.rm=TRUE));
    	mean.10x.lane<-round(mean(HS_PCT_TARGET_BASES_10X, na.rm=TRUE));
    	mean.20x.lane<-round(mean(HS_PCT_TARGET_BASES_20X, na.rm=TRUE));
    	mean.30x.lane<-round(mean(HS_PCT_TARGET_BASES_30X, na.rm=TRUE));
    	sd.10x.lane<-round(sd(HS_PCT_TARGET_BASES_10X, na.rm=TRUE));
    	sd.20x.lane<-round(sd(HS_PCT_TARGET_BASES_20X, na.rm=TRUE));
    	sd.30x.lane<-round(sd(HS_PCT_TARGET_BASES_30X, na.rm=TRUE));
	   		
	   		
	   	names<-paste(Project, " ", External.ID, "-", Lane, sep="")
       
   		 #makes a plot of the number of SNPS called per lane
		library(graphics)
			
	    pdf(file=paste(sample_sets, "_SNPS.pdf", sep=""), width=0.2*length(SNP_TOTAL_SNPS), height=0.1*length(SNP_TOTAL_SNPS))        
  
		layout(matrix(c(1,1 , 2), 1, 3, byrow=FALSE), respect=TRUE)
    	plot(1:length(SNP_TOTAL_SNPS), main="SNPs Called in Each Lane", SNP_TOTAL_SNPS, xlab="", ylab="SNPs Called in Lane", xaxt="n", pch=16, col="blue")
		axis(side=1, at=(1:length(SNP_TOTAL_SNPS)), labels=names, cex.axis=0.75, las=2)
        
     	boxplot(SNP_TOTAL_SNPS, main="SNPs Called in Lane", ylab="SNPs Called")


		if(length(boxplot.stats(SNP_TOTAL_SNPS)$out)==0){
        	mtext("No outliers",  side=1, line=4)
    		}else{
	            mtext(paste("Outlier SNP call counts in  ", length(boxplot.stats(SNP_TOTAL_SNPS)$out), "lanes"), side=1, line=4)
    			}
        
        
    		dev.off()
    
		    #makes SNP plot in log scale
    
   			pdf(file=paste(sample_sets, "_SNPS_log.pdf", sep=""), width=0.2*length(SNP_TOTAL_SNPS), height=0.1*length(SNP_TOTAL_SNPS))       
  	
			layout(matrix(c(1,1 , 2), 1, 3, byrow=FALSE), respect=TRUE)
    		plot(1:length(SNP_TOTAL_SNPS), log(SNP_TOTAL_SNPS), main="SNPs Called in Each Lane",  xlab="", ylab="Log(SNPs Called in Lane)", xaxt="n", pch=16, col="blue")
    		par(ylog=TRUE)
			axis(side=1, at=(1:length(SNP_TOTAL_SNPS)), labels=names, cex.axis=0.75, las=2)
        
     		boxplot(SNP_TOTAL_SNPS, main="SNPs Called in Lane", ylab="SNPs Called")


    		if(length(boxplot.stats(SNP_TOTAL_SNPS)$out)==0){
            	mtext("No outliers",  side=1, line=4)
    			}else{
            		mtext(paste("Outlier SNP call counts in  ", length(boxplot.stats(SNP_TOTAL_SNPS)$out), "lanes"), side=1, line=4)
   					}
        
    		dev.off()
    
   			 #makes a plot of snp calls ordered by lane
    		pdf(file=paste(sample_sets, "_SNPS_lane.pdf", sep=""), width=0.2*length(SNP_TOTAL_SNPS), height=0.1*length(SNP_TOTAL_SNPS))       
  
			layout(matrix(c(1,1 , 2), 1, 3, byrow=FALSE), respect=TRUE)
    		plot(1:length(SNP_TOTAL_SNPS), SNP_TOTAL_SNPS[order(Lane)], main="SNPs Called in Each Lane",  xlab="", ylab="Log(SNPs Called in Lane)", xaxt="n", pch=16, col="blue")
    		par(ylog=TRUE)
			axis(side=1, at=(1:length(SNP_TOTAL_SNPS)), labels=names[order(Lane)], cex.axis=0.75, las=2)
        
     		boxplot(SNP_TOTAL_SNPS, main="SNPs Called in Lane", ylab="SNPs Called")


		    if(length(boxplot.stats(SNP_TOTAL_SNPS)$out)==0){
        	    mtext("No outliers",  side=1, line=4)
    			}else{
            		mtext(paste("Outlier SNP call counts in  ", length(boxplot.stats(SNP_TOTAL_SNPS)$out), "lanes"), side=1, line=4)
    			}
    
		    dev.off()    
        
    		#makes a plot of fingerprint calls and labels them good or bad
        	badsnps<-union(which(FP_CONFIDENT_MATCHING_SNPS<15), which(FP_CONFIDENT_MATCHING_SNPS<15))

		    colors<-c(rep("Blue", length(FP_CONFIDENT_CALLS)))
    		colors[badsnps]<-"Red"
        
    		pdf(file=paste(sample_sets, "_Fingerprints.pdf", sep=""), width=.2*length(FP_CONFIDENT_CALLS), height=.1*length(FP_CONFIDENT_CALLS))
    		par(mar=c(6, 4, 5, 4))
    		plot(1:length(FP_CONFIDENT_MATCHING_SNPS), FP_CONFIDENT_MATCHING_SNPS, pch=16, ylim=c(0,24), ylab="Fingerprint calls", xlab="", xaxt="n", col=colors, main="Fingerprint Calling and Matching") 
    		points(1:length(FP_CONFIDENT_MATCHING_SNPS), FP_CONFIDENT_CALLS, col=colors)
    		axis(side=1, at=(1:length(FP_CONFIDENT_CALLS)), labels=names, cex.axis=0.75, las=2)

		    if(length(badsnps)>0){
        		legend("bottomright", legend=c("Confident calls at fingerprint sites by lane", "Confident matching calls at fingerprint sites by lane", "Confident calls in bad lanes", "Confident matching calls in bad lanes"), pch=c(1, 16, 1, 16), col=c("Blue", "Blue", "Red", "Red"))
       			 mtext("Some problematic fingerprint sites", side=3)
  				  }else{
  	      			legend("bottomright", legend=c("Confident calls at fingerprint sites by lane", "Confident matching calls at fingerprint sites by lane"), pch=c(1, 16), col="Blue")
  	      			}

   			dev.off()
 
	   		detach(bylane) 
	   		
			#Calc by sample metrics   	
		   	attach(bysample);
			mean.lanes.samp<-signif(mean(X..Lanes.included.in.aggregation, na.rm = TRUE));
			sd.lanes.samp<-signif(sd(X..Lanes.included.in.aggregation, na.rm=TRUE));
			mean.mrl.samp<-signif(mean(Mean.Read.Length, na.rm=TRUE));
			sd.mrl.samp<-signif(sd(Mean.Read.Length, na.rm=TRUE));
			mean.read.samp<-signif(mean(Total.Reads, na.rm=TRUE));
			sd.read.samp<-signif(sd(Total.Reads, na.rm=TRUE));
			mean.ub.samp<-signif(mean(On.Target.Bases..HS., na.rm=TRUE));
			sd.ub.samp<-signif(sd(On.Target.Bases..HS., na.rm=TRUE));
			mean.cov.samp<-round(mean(Mean.Target.Coverage..HS., na.rm=TRUE));
			sd.cov.samp<-round(sd(Mean.Target.Coverage..HS., na.rm=TRUE));
			mean.10x.samp<-round(mean(PCT.Target.Bases.10x..HS., na.rm=TRUE));
			mean.20x.samp<-round(mean(PCT.Target.Bases.20x..HS., na.rm=TRUE));
			mean.30x.samp<-round(mean(PCT.Target.Bases.30x..HS., na.rm=TRUE));
			sd.10x.samp<-round(sd(PCT.Target.Bases.10x..HS., na.rm=TRUE));
			sd.20x.samp<-round(sd(PCT.Target.Bases.20x..HS., na.rm=TRUE));
			sd.30x.samp<-round(sd(PCT.Target.Bases.30x..HS., na.rm=TRUE));

			detach(bysample);

			#print all of this stuff out in R. 
			print(paste("Callable Target: ", callable.target, " bases", sep=""), quote = FALSE);
			print(paste("Used Lanes per Sample: ", mean.lanes.samp, " +/- ", sd.lanes.samp, sep=""), quote=FALSE);
			print(paste("Parities: ", singlelanes, " single lanes, ", pairedlanes, " paired lanes", sep=""), quote=FALSE);
			print(paste("Read Legnths: ", mean.mrl.samp, " +/- ", sd.mrl.samp, sep=""), quote = FALSE);
			print(paste("Reads per lane: ", mean.read.lane, " +/- ", sd.read.lane, sep=""), quote = FALSE);
			print(paste("Reads per sample: ", mean.read.samp, " +/- ", sd.read.samp, sep=""), quote = FALSE);
			print(paste("Used bases per lane: ", mean.ub.lane, " +/- ", sd.ub.lane, sep=""), quote = FALSE);
			print(paste("Used bases per sample: ", mean.ub.samp, " +/- ", sd.ub.samp, sep=""), quote = FALSE)
			print(paste("Average target coverage per lane: ", mean.cov.lane, " +/- ", sd.cov.lane, sep=""), quote = FALSE);
			print(paste("Average target coverage per sample: ", mean.cov.samp, " +/- ", sd.cov.samp, sep=""), quote = FALSE);
			print(paste("% loci covered to 10x per lane: ", mean.10x.lane, "% +/- ", sd.10x.lane, "%", sep=""), quote = FALSE)
			print(paste("% loci covered to 10x per sample: ", mean.10x.samp, " +/- ", sd.10x.samp, "%", sep=""), quote = FALSE)
			print(paste("% loci covered to 20x per lane: ", mean.20x.lane, "% +/- ", sd.20x.lane, "%", sep=""), quote = FALSE)
			print(paste("% loci covered to 20x per sample: ", mean.20x.samp, "% +/- ", sd.20x.samp, "%", sep=""), quote = FALSE)
			print(paste("% loci covered to 30x per lane: ", mean.30x.lane, "% +/- ", sd.30x.lane, "%", sep=""), quote = FALSE)
			print(paste("% loci covered to 30x per sample: ", mean.30x.samp, "% +/- ", sd.30x.samp, "%", sep=""), quote = FALSE)
	   		         
	   	}else{
	   		print("Lane and Sample metrics file paths not provided")
	   		}	 
	   		 
	
	
	#Makes Error Rate percycle graph   		 
    if(is.na(eval)==FALSE){
    	read.delim(eval, header=TRUE)[2:ncol(read.delim(eval, header=TRUE))]->errpercycle
	
		pdf(paste(sample_sets, "_errorrate_per_cycle.pdf", sep=""), width=6, height=5)
	
		crazies<-which(errpercycle[75,]>0.3) #this can be changed to any kind of filter for particular lanes
	
		colors<-rainbow(ncol(errpercycle), s=0.5, v=0.5)
		colors[crazies]<-rainbow(length(crazies))
		weights<-rep(1, ncol(errpercycle))
		weights[crazies]<-2
	
		matplot(errpercycle, type="l", lty="solid", col=colors, lwd=weights,  main="Error Rate per Cycle", ylab="Error Rate", xlab="Cycle", ylim=c(0, 0.7))
	
		if(length(crazies)>0){
			legend("topleft", title="Unusual Lanes", legend=colnames(errpercycle)[crazies], lty="solid", lwd=2, col=colors[crazies], xjust=0.5)
			}else{
			legend("topleft", legend="No unusual lanes.", bty="n")
			}
		
		dev.off()
    	
    	}else{
    		print("Error Rate Per Cycle file paths not provided")
    		}
	
	#Makes TI/TV known v novel graph
	if(is.na(noveltitv)==FALSE && is.na(knowntitv) == FALSE){
		pdf(paste(sample_set, "_TiTv.pdf", sep=""), width=6, height=5)

		read.table(file=noveltitv, header=FALSE)->novels
		read.table(file=knowntitv, header=FALSE)->knowns

		plot(novels[,2], col="red", ylim=c(0, 3.5), main="Ti/Tv for 		Novel and Known SNP calls", ylab="Ti/Tv", xlab="", xaxt="n")
		points(knowns[,2], col="blue")

 		axis(side=1, at=(1:length(novels[,2])), labels=novels[,1], 		cex.axis=1, las=2)

		legend("bottomright", legend=c("Known Variants", "Novel 		Variants"), col=c("blue", "red"), pch=1, xjust=0.5)
		mtext("Lower Ti/Tv ratios indicated more false positive SNP calls.", side=1)
		dev.off()
		}else{
			print("Transition/transversion ratio file paths not provided")
			
			}
			
	#Make DOC graph
	if(is.na(DOC)==FALSE){
		pdf(paste(sample_set, "_DOC.pdf", sep=""), width=6, height=5)
	
	as.matrix(as.vector(read.delim(DOC, header=TRUE)[,2:502]))->DOCdata
	DOCdata<-matrix(DOCdata*100/sum(DOCdata[1,]), nrow=501, ncol=29, byrow=TRUE)
	colnames(DOCdata)<-read.delim(DOC, header=TRUE)[,1]
	oddies<-which(apply(DOCdata, 2, max)>10) #can be assigned any particular heuristic
	ncolors<-rainbow(ncol(DOCdata), s=0.5, v=0.5)
	ncolors[oddies]<-rainbow(length(oddies))
	nweights<-rep(1, ncol(DOCdata))
	nweights[oddies]<-2
	matplot(DOCdata, type="l", main="Depth of Coverage by Sample", ylab="Percent bases covered to a given depth", xlab="log(Depth)", log="x", col=ncolors,  lty="solid", lwd=nweights)
	
	if(length(oddies)>0){
		legend("topright", title="Unusual Cases", legend=colnames(DOCdata)[oddies], lty="solid", lwd=2, col=ncolors[oddies], xjust=0.5)
		}else{
			legend("topright", legend="No unusual cases.", bty="n")
			}
	
	dev.off()
	
		}else{
			print("Depth of Coverage filepath not provided")
			}		
	

