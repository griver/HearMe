package hearme.impl;

import hearme.environment.Location;
import hearme.environment.Time;
import hearme.providers.ILocationProvider;
import hearme.providers.IRingSettingsProvider;
import hearme.providers.ITimeProvider;
import hearme.rules.IRule;
import hearme.rules.IRulesManager;

import java.util.List;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 */
public class RingSettingsUpdate extends TimerTask {
    ILocationProvider myLocationProvider;
    ITimeProvider myTimeProvider;
    IRulesManager manager;
    IRingSettingsProvider myRingProvider;

    public RingSettingsUpdate(ILocationProvider locationProvider, ITimeProvider timeProvider, IRulesManager manager) {
        if(locationProvider == null || timeProvider == null || manager == null)
            throw new NullPointerException();

        myTimeProvider = timeProvider;
        myLocationProvider = locationProvider;

    }


    void setRingSettingsProvider(IRingSettingsProvider ringSettingsProvider){
        myRingProvider = ringSettingsProvider;
    }

    @Override
    public void run() {
        Location location = myLocationProvider.getCurrentLocation();
        Time time = myTimeProvider.getCurrentTime();
        List<IRule> rules = manager.getApplicableRules(location, time);
        if(rules.isEmpty())
            myRingProvider.setDefault();
        else
            myRingProvider.setNew(rules.get(0).getRingSettings());

    }
}
