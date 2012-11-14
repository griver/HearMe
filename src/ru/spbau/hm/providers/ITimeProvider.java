package ru.spbau.hm.providers;

import ru.spbau.hm.environment.Time;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 8:49
 * To change this template use File | Settings | File Templates.
 */
public interface ITimeProvider {
    Time getCurrentTime();
}
