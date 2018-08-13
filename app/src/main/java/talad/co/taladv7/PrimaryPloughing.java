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

public class PrimaryPloughing extends AppCompatActivity {

    private Button btnRai;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_ploughing);

        btnRai = (Button) findViewById(R.id.btnRai);
        btnRai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rai = new Intent(PrimaryPloughing.this, PrimaryPlough.class);
                startActivity(rai);
            }
        });
    }
}
