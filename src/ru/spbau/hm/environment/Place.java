package ru.spbau.hm.environment;

import ru.spbau.hm.locator.place.PlacesList;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 *
 */
public class Place implements Comparable<Place> {
    private double latitude;
    private double longitude;
    private PlacesList placesList;

    public Place(double latitude, double longitude, PlacesList placesList) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.placesList = placesList;
    }


    public List<ru.spbau.hm.locator.place.Place> getAllPlaces() {
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
        return "Somewhere near: " + longitude + "; " + latitude;
    }

    @Override
    public int compareTo(Place location) {
        return 0;
    }
}
