package ru.spbau.hm.environment;

import ru.spbau.hm.locator.place.Place;
import ru.spbau.hm.locator.place.PlacesList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 *
 */
public class Location implements Comparable<Location> {
    private double latitude;
    private double longitude;
    private PlacesList placesList;

    public Location(double latitude, double longitude, PlacesList placesList) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.placesList = placesList;
    }


    public List<Place> getAllPlaces() {
        return placesList.results;
    }

    public PlacesList getPlacesList() {
        return placesList;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public String getLocationName(){
        //ToDo: Somebody must either delete or implements me!
        return "Default Location";
    }

    @Override
    public int compareTo(Location location) {
        return 0;
    }
}
