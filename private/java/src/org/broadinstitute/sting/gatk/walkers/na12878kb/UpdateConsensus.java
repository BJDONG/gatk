package org.broadinstitute.sting.gatk.walkers.na12878kb;

import org.broadinstitute.sting.commandline.Argument;

import java.util.Collections;
import java.util.Set;

public class UpdateConsensus extends NA12878DBWalker {
    @Argument(required=false)
    public Set<String> selectCallSets = Collections.emptySet();

    @Argument(required=false)
    public Set<TruthStatus> selectTypes = Collections.emptySet();

    public void initialize() {
        super.initialize();
        db.clearConsensus();
    }

    @Override public boolean isDone() { return true; }

    public void onTraversalDone(Integer result) {
        db.updateConsensus(makeSiteSelector());

        super.onTraversalDone(result);
    }

    @Override
    public SiteSelector makeSiteSelector() {
        final SiteSelector select = super.makeSiteSelector();

        for ( final String callSetName : selectCallSets ) {
            final CallSet selectedCallSet = db.getCallSet(callSetName);
            select.addSetToInclude(selectedCallSet);
        }

        for ( final TruthStatus type : selectTypes ) {
            select.addTypeToInclude(type);
        }

        return select;
    }
}