package ru.spbau.hm.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import ru.spbau.hm.R;
import ru.spbau.hm.dialogs.LocalPlacesSelectionDialog;

public class EditProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor_layout);
    }

    public void extractLocalPlaces(View item) {
        new LocalPlacesSelectionDialog((TextView) item).show(getFragmentManager(), "Local.Places.Selection.Dialog");
    }

}
