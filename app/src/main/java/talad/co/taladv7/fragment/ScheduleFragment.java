package talad.co.taladv7.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import talad.co.taladv7.FarmerBuyServices;
import talad.co.taladv7.R;

/**
 * Created by cvanderhaar on 2018/07/03.
 */

public class ScheduleFragment extends Fragment {

    private Button btnReq;

    public ScheduleFragment() {
    }

    public static ScheduleFragment newInstance(String param1, String param2) {
        ScheduleFragment fragment = new ScheduleFragment();
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
        View v = inflater.inflate(R.layout.fragment_schedule, container, false);
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
