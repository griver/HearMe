package ru.spbau.hm.rules;

import ru.spbau.hm.environment.Place;
import ru.spbau.hm.environment.TimeInterval;

/**
 * Created with IntelliJ IDEA.
 * User: griver

 * To change this template use File | Settings | File Templates.
 */
public interface ICondition {

    TimeInterval getTimeInterval();

    Place getLocation();
}
