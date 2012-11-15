package ru.spbau.hm.activities;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import ru.spbau.hm.R;
import ru.spbau.hm.loader.PlacesListLoader;
import ru.spbau.hm.locator.place.Place;

import java.util.List;

public class MainActivity extends Activity  {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_screen);

        progressBar     = findViewById(R.id.ms_places_loading_progress_bar);
        nearShorePlace  = (TextView) findViewById(R.id.nearshore_place);

        progressBar.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        progressBar.setVisibility(View.VISIBLE);

        nearShorePlace.setVisibility(View.GONE);

        getLoaderManager().initLoader(0, null, new PlacesListLoaderFrontend()).forceLoad();

    }

    /**
     * Called to deploy options-menu upon pressing menu item for the first time
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.options_add_place : {
                startActivity(new Intent(MainActivity.this, ListProfileActivity.class)); break;
            }

            default: {
                return super.onOptionsItemSelected(item);
            }

        }

        return true;

    }

    public void applicationStateCheckboxClicked(View view) {
        enabled = view.isEnabled();
    }


    // LOADING FACILITIES

    protected class PlacesListLoaderFrontend implements LoaderManager.LoaderCallbacks<List<Place>> {

        @Override
        public Loader<List<Place>> onCreateLoader(int id, Bundle args) {
            return new PlacesListLoader(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<List<Place>> loader, List<Place> data) {

            nearShorePlace.setText(data.get(0).toString());

            progressBar.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_out));
            nearShorePlace.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));

            progressBar.setVisibility(View.GONE);
            nearShorePlace.setVisibility(View.VISIBLE);

        }

        @Override
        public void onLoaderReset(Loader<List<Place>> loader) {
            /* STUB */
        }

    }

    private boolean enabled = false;

    private View progressBar;

    private TextView nearShorePlace;

}
