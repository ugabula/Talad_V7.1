package talad.co.taladv7;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cvanderhaar on 2018/08/10.
 */

public class NotifyDialog extends AppCompatDialogFragment {

    private ImageView imageView56;
    private TextView textView1, textView2, textView3, textView4, textView5, textView34, textView35, textView36, textView37, textView38, textView39, textView40, textView41, textView42, textView43;
    private ImageButton imageButton2;
    private Button button5, button6;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.notification_dialog, null);

        builder.setView(view)
                .setTitle("")
                .setNegativeButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        imageView56 = view.findViewById(R.id.imageView56);
        imageButton2 = view.findViewById(R.id.imageButton2);
        textView1 = view.findViewById(R.id.textView1);
        textView2 = view.findViewById(R.id.textView2);
        textView3 = view.findViewById(R.id.textView3);
        textView4 = view.findViewById(R.id.textView4);
        textView5 = view.findViewById(R.id.textView5);
        textView34 = view.findViewById(R.id.textView34);
        textView35 = view.findViewById(R.id.textView35);
        textView36 = view.findViewById(R.id.textView36);
        textView37 = view.findViewById(R.id.textView37);
        textView38 = view.findViewById(R.id.textView38);
        textView39 = view.findViewById(R.id.textView39);
        textView40 = view.findViewById(R.id.textView40);
        textView41 = view.findViewById(R.id.textView41);
        textView42 = view.findViewById(R.id.textView42);
        textView43 = view.findViewById(R.id.textView43);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);

        return builder.create();
    }
}
