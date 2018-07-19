package talad.co.taladv7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cvanderhaar on 2018/06/29.
 */

public class FragmentInfo extends android.support.v4.app.Fragment {

    View view;

    public FragmentInfo() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.info_fragment, container, false);
        return view;
    }
}
