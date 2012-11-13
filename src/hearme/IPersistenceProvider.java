package hearme;

import hearme.rules.IRule;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:45
 * To change this template use File | Settings | File Templates.
 */
public interface IPersistenceProvider {
    boolean saveRules(Collection<IRule> rules, String filename);

    Collection<IRule> loadRules(String filename);
}
