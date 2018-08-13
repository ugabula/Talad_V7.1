package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by cvanderhaar on 2018/06/29.
 */

public class FragmentInfo extends Fragment {

    View view;
    private Button btnReq;

    public FragmentInfo() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.info_fragment, container, false);
        btnReq = (Button) view.findViewById(R.id.btnReq);
        btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), FarmerChooseServiceActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
