package ru.spbau.hm.activities;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import ru.spbau.hm.R;
import ru.spbau.hm.dialogs.ProfileRemovalConfirmationDialog;

public class ListProfileActivity extends ListActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    static final Cursor DEFAULT_CURSOR = null;

    static final String[] PROJECTION = new String[] {
        ContactsContract.Data._ID,
        ContactsContract.Data.DISPLAY_NAME,
        ContactsContract.Data.DATA1
    };

    static final String SELECTION = "((" +  ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND (" +
                                            ContactsContract.Data.DISPLAY_NAME + " != '' ))";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.profiles_list_layout);


        // Register context-menu

        registerForContextMenu(getListView());

        // And initialize cursor-loader

        String[]    fromColumns = { ContactsContract.Data.DISPLAY_NAME, ContactsContract.Data.DATA1 /* PHONE NUMBER */ };
        int[]       toViews     = { android.R.id.text1, android.R.id.text2 };


        cursorAdapter = new SimpleCursorAdapter(this,
                                                android.R.layout.two_line_list_item,
                                                null,
                                                fromColumns,
                                                toViews,
                                                0x0 /* EMPTY FLAGS */);

        setListAdapter(cursorAdapter);

        getLoaderManager().initLoader(  /* LOADER ID */         0,
                                        /* LOADER ARGS */       null,
                                        /* CALLBACKS HOLDER */  this);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, ContactsContract.Data.CONTENT_URI, PROJECTION, SELECTION, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(DEFAULT_CURSOR);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        /* STUBBED */
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.profiles_list_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.profile_list_context_menu_edit : {

                /* EDITING PROCEDURE INVOKATION */

                startActivity(new Intent(this, EditProfileActivity.class));
                break;

            }

            case R.id.profile_list_context_menu_remove : {

                new ProfileRemovalConfirmationDialog().show(getFragmentManager(), "Removal.Confirmation.Dialog");
                break;

            }

            default: {
                return super.onContextItemSelected(item);
            }

        }

        return true;

    }


    SimpleCursorAdapter cursorAdapter;

}
