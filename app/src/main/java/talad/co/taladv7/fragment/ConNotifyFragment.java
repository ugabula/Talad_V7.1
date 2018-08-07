package talad.co.taladv7.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import talad.co.taladv7.R;

/**
 * Created by cvanderhaar on 2018/08/06.
 */

public class ConNotifyFragment extends Fragment {

    public ConNotifyFragment() {
    }

    public static ConNotifyFragment newInstance (String param1, String param2) {
        ConNotifyFragment fragment = new ConNotifyFragment();
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
        return inflater.inflate(R.layout.con_fragment_notifications, container, false);
    }
}
