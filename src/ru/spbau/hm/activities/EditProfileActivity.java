package ru.spbau.hm.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import ru.spbau.hm.R;

public class EditProfileActivity extends Activity {


    public EditProfileActivity() {
        selectPlaceFragment = new SelectPlaceFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor);
    }

    public void extractLocalPlaces(View item) {
        getFragmentManager().beginTransaction().add(android.R.id.content, selectPlaceFragment, "Local.Places.Selection.Dialog").commit();
    }

    Fragment selectPlaceFragment;

}
