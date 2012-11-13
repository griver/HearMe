package hearme.impl;

import hearme.ISettingsResolver;
import hearme.environment.Location;
import hearme.environment.Time;
import hearme.providers.ILocationProvider;
import hearme.providers.IRingSettingsProvider;
import hearme.providers.ITimeProvider;
import hearme.rules.IRule;
import hearme.rules.IRulesManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class RingSettingsResolver implements ISettingsResolver {
    ILocationProvider myLocationProvider;
    ITimeProvider myTimeProvider;
    IRulesManager manager;
    IRingSettingsProvider myRingProvider;

    public RingSettingsResolver(ILocationProvider locationProvider, ITimeProvider timeProvider, IRulesManager manager) {
        if(locationProvider == null || timeProvider == null || manager == null)
            throw new NullPointerException();

        myTimeProvider = timeProvider;
        myLocationProvider = locationProvider;

    }

    void setRingSettingsProvider(IRingSettingsProvider ringSettingsProvider){
        myRingProvider = ringSettingsProvider;
    }

    @Override
    public void resolve() {
        Location location = myLocationProvider.getCurrentLocation();
        Time time = myTimeProvider.getCurrentTime();
        List<IRule> rules = manager.getApplicableRules(location, time);
        if(rules.isEmpty())
            myRingProvider.setDefault();
        else
            myRingProvider.setNew(rules.get(0).getRingSettings());

    }
}
