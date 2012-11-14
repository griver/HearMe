package ru.spbau.hm.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Yarik
 * Date: 13.11.12
 * Time: 22:11
 * To change this template use File | Settings | File Templates.
 */

public class PlaceViewerActivity extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        Intent intent = getIntent();

        String[] values = intent.getStringArrayExtra("places");

        /*
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }



    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " chosen", Toast.LENGTH_LONG).show();

        Intent intent = new Intent();
        intent.putExtra("place", item);
        setResult(RESULT_OK, intent);
        finish();
    }
}