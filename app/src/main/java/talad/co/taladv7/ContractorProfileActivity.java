package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by cvanderhaar on 2018/07/09.
 */

public class ContractorProfileActivity extends AppCompatActivity {

    private Button mBuy, mProvide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_mode);

        mBuy = (Button) findViewById(R.id.buy);
        mProvide = (Button) findViewById(R.id.provide);

        mBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(ContractorProfileActivity.this, FarmerLoginActivity.class);
                startActivity(login);
                finish();
            }
        });

        mProvide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(ContractorProfileActivity.this, ContractorLoginActivity.class);
                startActivity(login);
                finish();
            }
        });
    }
}
