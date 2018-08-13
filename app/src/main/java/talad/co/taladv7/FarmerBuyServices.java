package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * Created by cvanderhaar on 2018/07/10.
 */

public class FarmerBuyServices extends AppCompatActivity {

    private ImageButton backarrow;
    private Button btnCont;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    ImageView corn, cass, sugar, rice, pine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_service);

        backarrow = (ImageButton) findViewById(R.id.backarrow);
        btnCont = (Button) findViewById(R.id.btnCont);

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(FarmerBuyServices.this, FarmerChooseServiceActivity.class);
                startActivity(back);
            }
        });

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        corn = (ImageView) findViewById(R.id.corn);
        corn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        BuyDialog buyDialog = new BuyDialog();
        buyDialog.show(getSupportFragmentManager(), "BUY");
    }
}
