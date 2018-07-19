package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by cvanderhaar on 2018/07/10.
 */

public class FarmerPayActivity extends AppCompatActivity {

    private ImageButton backarrow;
    private ImageView nine, ten, six, five;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pay_farmer);

        backarrow = (ImageButton) findViewById(R.id.backarrow);
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(FarmerPayActivity.this, FarmerChooseServiceActivity.class);
                startActivity(back);
            }
        });

        nine = (ImageView) findViewById(R.id.imageView9);//bank
        ten = (ImageView) findViewById(R.id.imageView10);//card
        six = (ImageView) findViewById(R.id.imageView6);//cash
        five = (ImageView) findViewById(R.id.imageView5);//paypal

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bank = new Intent(FarmerPayActivity.this, FarmerAddBank.class);
                startActivity(bank);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bank = new Intent(FarmerPayActivity.this, FarmerAddCard.class);
                startActivity(bank);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paypal = new Intent(FarmerPayActivity.this, PayPalActivity.class);
                startActivity(paypal);
            }
        });
    }
}
