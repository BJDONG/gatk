package org.broadinstitute.sting.oneoffprojects.walkers.association;

import org.broadinstitute.sting.commandline.Argument;
import org.broadinstitute.sting.commandline.Output;
import org.broadinstitute.sting.gatk.contexts.AlignmentContext;
import org.broadinstitute.sting.gatk.contexts.ReferenceContext;
import org.broadinstitute.sting.gatk.datasources.sample.Sample;
import org.broadinstitute.sting.gatk.refdata.RefMetaDataTracker;
import org.broadinstitute.sting.gatk.walkers.LocusWalker;
import org.broadinstitute.sting.gatk.walkers.TreeReducible;
import org.broadinstitute.sting.utils.SampleUtils;
import org.broadinstitute.sting.utils.classloader.PluginManager;
import org.broadinstitute.sting.utils.exceptions.StingException;
import org.broadinstitute.sting.utils.exceptions.UserException;

import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * @Author chartl
 * @Date 2011-02-23
 * Generalized framework for regional (windowed) associations
 */
public class RegionalAssociationWalker extends LocusWalker<MapHolder, RegionalAssociationHandler> implements TreeReducible<RegionalAssociationHandler> {
    @Argument(doc="Association type(s) to use. Supports multiple arguments (-AT thing1 -AT thing2).",shortName="AT",fullName="associationType",required=false)
    public String[] associationsToUse = null;

    @Output
    PrintStream out;

    public RegionalAssociationHandler reduceInit() {
        Set<AssociationContext> validAssociations = getAssociations();
        RegionalAssociationHandler wac = new RegionalAssociationHandler(validAssociations);

        return wac;
    }

    public MapHolder map(RefMetaDataTracker tracker, ReferenceContext ref, AlignmentContext context) {
        return new MapHolder(tracker,ref,context);
    }

    public RegionalAssociationHandler reduce(MapHolder map, RegionalAssociationHandler rac) {
        rac.updateExtender(map);
        try {
            rac.runMapReduce();
        } catch (Exception e) {
            throw new StingException("Error in map reduce",e);
        }
        List<String> testsHere = rac.runTests();
        // todo -- really awful shitty formatting
        if ( testsHere.size() > 0 ) {
            out.printf("%s%n",rac.getLocation().toString());
            for ( String s : testsHere ) {
                out.printf("%s%n",s);
            }
        }
        return rac;
    }
    private Set<AssociationContext> getAssociations() {
        List<Class<? extends AssociationContext>> contexts = new PluginManager<AssociationContext>(AssociationContext.class).getPlugins();
        Map<String,Class<? extends AssociationContext>> classNameToClass = new HashMap<String,Class<? extends AssociationContext>>(contexts.size());
        for ( Class<? extends AssociationContext> clazz : contexts ) {
            classNameToClass.put(clazz.getSimpleName(),clazz);
        }

        Set<AssociationContext> validAssociations = new HashSet<AssociationContext>();
        for ( String s : associationsToUse ) {
            AssociationContext context;
            try {
                context = classNameToClass.get(s).newInstance();
            } catch ( Exception e ) {
                throw new StingException("The class "+s+" could not be instantiated.",e);
            }
            context.init(this);
            validAssociations.add(context);
        }
        return validAssociations;
    }

    public RegionalAssociationHandler treeReduce(RegionalAssociationHandler left, RegionalAssociationHandler right) {
        // for now be dumb; in future fix the fact that left-most intervals of a 16kb shard won't see the context from
        // the right-most locus of the previous shard
        return right;
    }

    public void onTraversalDone(RegionalAssociationHandler rac) {
        // do nothing
    }

    public Set<Sample> getSamples() {
        return getToolkit().getSAMFileSamples();
    }
}