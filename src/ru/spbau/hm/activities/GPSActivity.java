package ru.spbau.hm.activities;

/**
 * Created with IntelliJ IDEA.
 * User: Yarik
 * Date: 13.11.12
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import ru.spbau.hm.R;
import ru.spbau.hm.locator.place.ConnectionDetector;
import ru.spbau.hm.locator.place.Place;
import ru.spbau.hm.locator.place.PlaceProvider;
import ru.spbau.hm.locator.place.PlacesList;
import ru.spbau.hm.activities.PlaceViewerActivity;


public class GPSActivity extends Activity {

    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    protected LocationManager locationManager;
    protected Button retrieveLocationButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        retrieveLocationButton = (Button) findViewById(R.id.retrieve_location_button);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );

        retrieveLocationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });
    }


    protected void find() {
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            String message = String.format("Current Location \n Longitude: %1$s \n Latitude: %2$s", location.getLongitude(), location.getLatitude());
            Toast.makeText(GPSActivity.this, message, Toast.LENGTH_LONG).show();


            ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
            PlaceProvider placeProvider = new PlaceProvider(1000, null, cd);

            ru.spbau.hm.environment.Location locationInfo = placeProvider.getPlacesList(location.getLatitude(), location.getLongitude());
            PlacesList list = locationInfo.getPlacesList();

            Intent intent = new Intent(this, PlaceViewerActivity.class);

            int size = list.results.size();
            String[] places = new String[size];
            int x = 0;
            for (Place place: list.results)
                places[x++] = place.name;
            Log.d("Places size:", Integer.toString(size));

            String res = "";
            for (String s: places) {
                res += s + "\n";
            }
            Log.d("place: ",res);

            intent.putExtra("places", places);
            startActivityForResult(intent, 1);


        } else {
            Toast.makeText(GPSActivity.this, "Location not found yet", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        String name = data.getStringExtra("place");
        Toast.makeText(this, name, Toast.LENGTH_LONG).show();
    }




    private class MyLocationListener implements LocationListener {
        public void onLocationChanged(Location location) {
            String message = String.format(
                    "New Location \n Longitude: %1$s \n Latitude: %2$s",
                    location.getLongitude(), location.getLatitude()
            );
            Toast.makeText(GPSActivity.this, message, Toast.LENGTH_LONG).show();
        }

        public void onStatusChanged(String s, int i, Bundle b) {
            Toast.makeText(GPSActivity.this, "Provider status changed", Toast.LENGTH_LONG).show();
        }

        public void onProviderDisabled(String s) {
            Toast.makeText(GPSActivity.this, "Provider disabled by the user. GPS turned off", Toast.LENGTH_LONG).show();
        }

        public void onProviderEnabled(String s) {
            Toast.makeText(GPSActivity.this, "Provider enabled by the user. GPS turned on", Toast.LENGTH_LONG).show();
        }
    }

}