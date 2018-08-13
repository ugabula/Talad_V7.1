package talad.co.taladv7;

/**
 * Created by cvanderhaar on 2018/08/09.
 */

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BuyDialog extends AppCompatDialogFragment {

    private ImageView imageView58, imageView59;
    private TextView textView21, textView22, textView23, textView24;
    private Button btnReq;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.corn_layout, null);

        builder.setView(view)
                //.setTitle("BUY")
                .setNegativeButton("\n", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("\n", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        imageView58 = view.findViewById(R.id.imageView58);
        imageView59 = view.findViewById(R.id.imageView59);
        textView21 = view.findViewById(R.id.textView21);
        textView22 = view.findViewById(R.id.textView22);
        textView23 = view.findViewById(R.id.textView23);
        textView24 = view.findViewById(R.id.textView24);
        btnReq = view.findViewById(R.id.btnReq);
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent book = new Intent(getActivity(), PrimaryPloughing.class);
                startActivity(book);
            }
        });


        return builder.create();
    }
}
