package ru.spbau.hm.rules;

import ru.spbau.hm.IPersistenceProvider;
import ru.spbau.hm.environment.Place;
import ru.spbau.hm.environment.Time;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 8:28
 * To change this template use File | Settings | File Templates.
 */
public interface IRulesManager {
    void setPersistenceProvider(IPersistenceProvider persistenceProvider);

    List<IRule> getApplicableRules(Place location, Time time);

    List<IRule> GetAllRules();

    List<IRule> GetConflictingRules(IRule rule);

    boolean AddRule(IRule rule);

    void RemoveRule(IRule rule);

    void close();
}
