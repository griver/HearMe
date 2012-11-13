package hearme.rules;

import hearme.environment.Location;
import hearme.environment.TimeInterval;

/**
 * Created with IntelliJ IDEA.
 * User: griver

 * To change this template use File | Settings | File Templates.
 */
public interface ICondition {

    TimeInterval getTimeInterval();

    Location getLocation();
}
