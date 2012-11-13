package hearme.rules;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 8:29
 * To change this template use File | Settings | File Templates.
 */
public interface IRulesLoader {
    Collection<IRule> load(String filename);
}
