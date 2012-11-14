package ru.spbau.hm.impl;

import ru.spbau.hm.IPersistenceProvider;
import ru.spbau.hm.environment.Location;
import ru.spbau.hm.environment.Time;
import ru.spbau.hm.rules.IRule;
import ru.spbau.hm.rules.IRulesManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 14.11.12
 * Time: 12:14
 * To change this template use File | Settings | File Templates.
 */
public class RulesManager implements IRulesManager {
    private IPersistenceProvider provider;
    private List<IRule> myRules;
    public RulesManager(IPersistenceProvider persistenceProvider) {
        if(persistenceProvider == null) throw  new NullPointerException();
        provider = persistenceProvider;
        myRules = provider.loadRules();
    }

    @Override
    public void setPersistenceProvider(IPersistenceProvider persistenceProvider) {
        if(persistenceProvider == null) throw  new NullPointerException();
        provider = persistenceProvider;
    }

    @Override
    public List<IRule> getApplicableRules(Location location, Time time) {
        ArrayList<IRule> appRules = new ArrayList<IRule>();
        for(IRule rule : myRules) {
            if(rule.getCondition().getLocation().compareTo(location) == 0){
                if(rule.getCondition().getTimeInterval().isInclude(time))
                    appRules.add(rule);
            }
        }
        return appRules;
    }

    @Override
    public List<IRule> GetConflictingRules(IRule rule) {
        ArrayList<IRule> confRules = new ArrayList<IRule>();
        for(IRule elem : myRules) {
            if(elem.getCondition().isConflicts(rule.getCondition()))
                confRules.add(rule);

        }
        return confRules;

    }


    @Override
    public List<IRule> GetAllRules() {
        return Collections.unmodifiableList(myRules);
    }

    @Override
    public boolean AddRule(IRule rule) {
        if(GetConflictingRules(rule).size() > 0) return false;
        myRules.add(rule);
        return true;
    }

    @Override
    public void RemoveRule(IRule rule) {
        myRules.remove(rule);
    }

    @Override
    public void close() {
        provider.saveRules(myRules);
    }
}
