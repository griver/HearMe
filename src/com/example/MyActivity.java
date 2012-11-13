package com.example;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private AudioManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.changeVolume);
        btn.setOnClickListener(new View.OnClickListener() {
            private boolean  muteOn = false;
            @Override
            public void onClick(View view) {
                muteOn = !muteOn;
                manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
                //int maxRing = manager.getStreamMaxVolume(AudioManager.STREAM_RING);
                //int maxVoice = manager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL);
                //manager.setStreamMute(AudioManager.STREAM_RING, muteOn);
                //manager.setStreamMute(AudioManager.STREAM_VOICE_CALL, muteOn);
                //manager.setStreamVolume(AudioManager.STREAM_RING,0, 0);
                //manager.setStreamVolume(AudioManager.STREAM_RING,0, 0);
                manager.adjustVolume(AudioManager.ADJUST_LOWER, 0);
            }
        });


    }


}
