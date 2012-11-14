package ru.spbau.hm.locator.place;

import android.util.Log;
import ru.spbau.hm.environment.Location;

/**
 * Created with IntelliJ IDEA.
 * User: Yarik
 * Date: 13.11.12
 * Time: 21:35
 * To change this template use File | Settings | File Templates.
 */
public class PlaceProvider {
    private double radius;
    private String types;
    private ConnectionDetector connectionDetector;

    /**
     *
     * @param radius meters from to find places
     * @param types type of places - null if we want all
     * @param connectionDetector - creates from activity by:  = new ConnectionDetector(getApplicationContext())
     */
    public PlaceProvider(double radius, String types, ConnectionDetector connectionDetector) {
        this.radius = radius;
        this.types = types;
        this.connectionDetector = connectionDetector;
    }

    /**
     *
     * @param latitude gps coord1
     * @param longitude gps coord2
     * @return Location with null PlacesList if network error occupied, else Location with list of places nearby
     */
    public Location getPlacesList(double latitude, double longitude) {
        boolean isInternetPresent = connectionDetector.isConnectingToInternet();
        if (!isInternetPresent) {
            Log.d("Error:", "bad internet");
            return new Location(latitude, longitude, null);
        }
        GooglePlaces googlePlaces = new GooglePlaces();
        try {
            PlacesList list = googlePlaces.search(latitude, longitude, radius, types);
            Log.d("Places: ", "found");
            return new Location(latitude, longitude, list);
        } catch (Exception e) {
            Log.d("Exception: ", e.toString());
            return new Location(latitude, longitude, null);
        }
    }

}
