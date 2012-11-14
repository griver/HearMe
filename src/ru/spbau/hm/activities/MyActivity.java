package ru.spbau.hm.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ru.spbau.hm.R;
import ru.spbau.hm.impl.MyAlert;
import ru.spbau.hm.impl.SimpleTimer;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private AudioManager manager;
    private MyAlert alert;
    private SimpleTimer timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        alert = new MyAlert();
        timer = new SimpleTimer(alert, 5000);
        timer.startInBackground();

        setContentView(R.layout.volume_test);


        Button btn = (Button)findViewById(R.id.changeVolume);
        btn.setOnClickListener(new View.OnClickListener() {

            private boolean  muteOn = true;
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
                builder.setTitle(Integer.toString(alert.getValue()));
                builder.create().show();
                // muteOn = !muteOn;
                // manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                // manager.adjustVolume(AudioManager.ADJUST_LOWER, 0);
            }
        });


    }


}
