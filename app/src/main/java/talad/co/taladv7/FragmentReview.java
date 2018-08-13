package talad.co.taladv7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cvanderhaar on 2018/06/29.
 */

public class FragmentReview extends Fragment {

    View view;

    public FragmentReview() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.review_fragment, container, false);
        return view;
    }
}
