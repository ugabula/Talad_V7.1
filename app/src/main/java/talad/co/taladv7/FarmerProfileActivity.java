package talad.co.taladv7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cvanderhaar on 2018/07/09.
 */

public class FarmerProfileActivity extends AppCompatActivity{

    private Button btnSave;
    private ImageView imagechange;
    private ImageButton change;
    private TextView mChange, mName, mAddress, mEmail, mPhone, mPassword, mConfirmPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_mode);

        imagechange = (ImageView) findViewById(R.id.imagechange);
        
    }
}
