package talad.co.taladv7.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import talad.co.taladv7.NotifyDialog;
import talad.co.taladv7.R;

/**
 * Created by cvanderhaar on 2018/08/06.
 */

public class ConNotifyFragment extends Fragment {

    private ImageView imageView56;

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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.con_fragment_notifications, container, false);
        imageView56 = (ImageView) v.findViewById(R.id.imageView56);
        imageView56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        return v;
    }

    private void openDialog() {
        NotifyDialog notifyDialog = new NotifyDialog();
        notifyDialog.show(getFragmentManager(), "Furrow");
    }
}
