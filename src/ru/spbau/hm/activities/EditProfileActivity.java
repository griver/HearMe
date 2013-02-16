package ru.spbau.hm.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import ru.spbau.hm.R;
import ru.spbau.hm.activities.interfaces.Fadeable;

public class EditProfileActivity extends Activity implements Fadeable {

    public EditProfileActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor);

        this.profileEditor  = (EditText) findViewById(R.id.profile_editor_label_ti);
        this.profileLabel   = (TextView) findViewById(R.id.profile_editor_selected_location_label);

        this.selectPlaceFragment = new SelectPlaceFragment(this, profileLabel);
    }

    public void extractLocalPlaces(View item) {
        getFragmentManager().beginTransaction().add(android.R.id.content, selectPlaceFragment, "Local.Places.Selection.Dialog").commit();
    }

    @Override
    public final void fadeOut() {
        profileEditor.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        profileEditor.setVisibility(View.GONE);

        profileLabel.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        profileLabel.setVisibility(View.GONE);
    }

    @Override
    public final void fadeIn() {
        profileEditor.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        profileEditor.setVisibility(View.VISIBLE);

        profileLabel.setAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        profileLabel.setVisibility(View.VISIBLE);
    }

    Fragment selectPlaceFragment;

    EditText profileEditor;
    TextView profileLabel;

}
