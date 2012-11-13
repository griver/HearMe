package hearme.rules;

import hearme.environment.RingSettings;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 8:31
 * To change this template use File | Settings | File Templates.
 */
public interface IRule extends Comparable<IRule> {
    RingSettings getRingSettings();
    ICondition getCondition();
    boolean isTimeGlobal();
    boolean isLocationGlobal();
}
