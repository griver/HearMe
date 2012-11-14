package ru.spbau.hm.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import ru.spbau.hm.R;

public class MainActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_layout);
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

    private boolean enabled = false;

}
