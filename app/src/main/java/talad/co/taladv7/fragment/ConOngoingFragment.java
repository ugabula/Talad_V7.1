package talad.co.taladv7.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ng.max.slideview.SlideView;
import talad.co.taladv7.R;

/**
 * Created by cvanderhaar on 2018/08/06.
 */

public class ConOngoingFragment extends Fragment {

    //SwipeButton swipeButton;

    public ConOngoingFragment() {
    }

    public static ConOngoingFragment newInstance (String param1, String param2) {
        ConOngoingFragment fragment = new ConOngoingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.con_fragment_ongoing, container, false);

        SlideView slideView = (SlideView) v.findViewById(R.id.slideView);
        slideView.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Are you sure you want to Cancel? \n A cancellation fee may apply!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Continue", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
                // vibrate the device
//                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//                vibrator.vibrate(100);

                // go to a new activity
                //startActivity(new Intent(getContext(), CallDialog.class));
            }
        });
        return v;
    }
}
