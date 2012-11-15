package ru.spbau.hm.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import ru.spbau.hm.locator.place.ConnectionDetector;
import ru.spbau.hm.locator.place.Place;
import ru.spbau.hm.locator.place.PlacesList;
import ru.spbau.hm.locator.place.PlacesProvider;

import java.util.Collections;
import java.util.List;

public class PlacesListLoader extends AsyncTaskLoader<List<Place>> {

    private static final Integer RADIUS = 1000;

    public PlacesListLoader(Context context) {

        super(context);
        this.context = context;
        this.locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

    }


    @Override
    public List<Place> loadInBackground() {

        //Location target = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        PlacesProvider placesProvider = new PlacesProvider(RADIUS, null, new ConnectionDetector(context.getApplicationContext()));

        /*
        PlacesList list = placesProvider.getPlacesList( target.getLatitude(),
                                                        target.getLongitude()).getPlacesList();
                                                        */

        PlacesList list = placesProvider.getPlacesList(60.0000, 30.0000).getPlacesList();

        return list == null ? Collections.EMPTY_LIST : list.results;

    }

    @Override
    public void onReset() {
        /* STUB, HAS NOTHING TO DO */
    }


    private Context context;

    private LocationManager locationManager;

    private List<Place> nearbyPlaces;

}
