package com.example;

import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private AudioManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_test);

        //Intent intent = new Intent(this, GPSActivity.this);
        //startActivity(intent);


        /*

        setContentView(R.layout.volume_test);
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

        */
    }


}
