package ru.spbau.hm.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class LocalPlacesSelectionDialog extends DialogFragment {

    public LocalPlacesSelectionDialog(TextView target) {
        this.target = target;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setSingleChoiceItems(
                STUBBED_CHOICES,
                -1,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        chosen = which;
                    }
                }
        );


        return builder.create();

    }

    @Override
    public void onDismiss(DialogInterface dialog) {

        super.onDismiss(dialog);

        if (chosen >= 0) {
            target.setText(STUBBED_CHOICES[chosen]);
        }

    }


    final String[] STUBBED_CHOICES = { "Nicaragua", "Cuba", "Caribbean" };


    private TextView target;

    private int chosen = -1;

}
