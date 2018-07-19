package talad.co.taladv7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by cvanderhaar on 2018/07/10.
 */

public class UploadDialog extends AppCompatDialogFragment {

    private ImageView camera, upload;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.upload_photo_dialog, null);

        builder.setView(view)
                .setTitle("Upload")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        camera = view.findViewById(R.id.camera);
        upload = view.findViewById(R.id.upload);

        return builder.create();
    }
}
