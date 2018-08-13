package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by cvanderhaar on 2018/08/09.
 */

public class ChooseContractor extends AppCompatActivity {

    private ImageView english;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_contractor);

        english = (ImageView) findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cont = new Intent(ChooseContractor.this, TabMainActivity.class);
                startActivity(cont);
            }
        });
    }
}
