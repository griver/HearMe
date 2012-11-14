package ru.spbau.hm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class ProfileRemovalConfirmationDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.profiles_list_removal_action_prompt)
                .setPositiveButton(
                        R.string.profiles_list_removal_action_prompt_confirmation,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                /* ACTUAL PROFILE REMOVAL PROCEDURE */
                            }
                        }
                )
                .setNegativeButton(
                        R.string.profiles_list_removal_action_prompt_cancelation,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                /* NOP, DO NOTHING */
                            }
                        }
                );

        return builder.create();

    }

}