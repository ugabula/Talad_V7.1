package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by cvanderhaar on 2018/08/09.
 */

public class PrimaryPlough extends AppCompatActivity {

    private Button btnChoose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_plough);

        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent choose = new Intent(PrimaryPlough.this, ChooseContractor.class);
                startActivity(choose);
            }
        });
    }
}
