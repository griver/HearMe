package ru.spbau.hm.impl;

import ru.spbau.hm.IPersistenceProvider;
import ru.spbau.hm.rules.IRule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 */
public class FooPersistenceProvider implements IPersistenceProvider {
    @Override
    public boolean saveRules(Collection<IRule> rules) {
        return true;
    }

    @Override
    public List<IRule> loadRules() {
        return new ArrayList<IRule>();
    }

}
