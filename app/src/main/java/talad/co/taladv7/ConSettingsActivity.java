package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import talad.co.taladv7.map.NiboMainActivity;

/**
 * Created by cvanderhaar on 2018/08/10.
 */

public class ConSettingsActivity extends AppCompatActivity {

    private ImageView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_radius);

        mapView = (ImageView) findViewById(R.id.mapView);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(ConSettingsActivity.this, NiboMainActivity.class);
                startActivity(map);
            }
        });
    }
}
