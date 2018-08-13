package talad.co.taladv7.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import talad.co.taladv7.FarmerBuyServices;
import talad.co.taladv7.R;

/**
 * Created by cvanderhaar on 2018/07/03.
 */

public class OngoingFragment extends AppCompatDialogFragment {

    private ImageButton btnCall;
    private Button btnReq;

    public OngoingFragment() {
    }

    public static OngoingFragment newInstance(String param1, String param2) {
        OngoingFragment fragment = new OngoingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Dialog onCreateDialog (Bundle savedInstanceState){
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_call, null);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 Log.i("TAG", "U clicked my button");
            }
        };
        //Build alert dialog
        return new AlertDialog.Builder(getActivity())
                //.setTitle("Call")
                .setView(v)
//                .setPositiveButton(android.R.string.ok, listener)
//                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ongoing, container, false);
        ImageButton btnCall = (ImageButton) v.findViewById(R.id.imageButton2);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext())
                        //.setTitle("Call")
                        .setMessage("123 - 456 - 7890");
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
            }
        });
        btnReq = (Button) v.findViewById(R.id.btnReq);
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent req = new Intent(getActivity(), FarmerBuyServices.class);
                startActivity(req);
            }
        });

        return v;
    }
}
