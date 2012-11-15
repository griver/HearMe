package ru.spbau.hm.providers;

import ru.spbau.hm.environment.Place;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:34
 * To change this template use File | Settings | File Templates.
 */
public interface ILocationProvider {
    Place getCurrentLocation();
}
