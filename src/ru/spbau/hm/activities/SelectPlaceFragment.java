package ru.spbau.hm.activities;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import ru.spbau.hm.R;
import ru.spbau.hm.activities.interfaces.Fadeable;
import ru.spbau.hm.loader.PlacesListLoader;
import ru.spbau.hm.locator.place.Place;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Yarik
 */

public class SelectPlaceFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<List<ru.spbau.hm.locator.place.Place>> {

    public SelectPlaceFragment(Activity parent, TextView target) {
        this.parent = parent;
        this.target = target;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (parent instanceof Fadeable)
            ((Fadeable) parent).fadeOut();

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<Place>(getActivity(), R.layout.places_list, android.R.id.text1);

        setListAdapter(adapter);

        getLoaderManager().initLoader(0, null, this).forceLoad();

    }

    @Override
    public Loader<List<Place>> onCreateLoader(int id, Bundle args) {
        return new PlacesListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Place>> loader, List<Place> data) {
        adapter.addAll(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Place>> loader) {
        adapter.clear();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        Place chosen = adapter.getItem(position);

        target.setText(chosen.toString());

        getFragmentManager().beginTransaction().remove(this).commit();

        if (parent instanceof Fadeable)
            ((Fadeable) parent).fadeIn();

    }


    private Activity parent;

    private TextView target;

    private ArrayAdapter<Place> adapter;

}