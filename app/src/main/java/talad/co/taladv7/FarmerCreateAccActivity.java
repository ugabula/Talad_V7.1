package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by cvanderhaar on 2018/07/10.
 */

public class FarmerCreateAccActivity extends AppCompatActivity {

    private ImageButton btnBackArrow, btnUploadImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_create_acc);

        btnBackArrow = (ImageButton) findViewById(R.id.backarrow);
        btnUploadImage = (ImageButton) findViewById(R.id.uploadphoto);

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        btnBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(FarmerCreateAccActivity.this, FarmerChooseServiceActivity.class);
                startActivity(back);
            }
        });
    }

    private void openDialog() {
        UploadDialog uploadDialog = new UploadDialog();
        uploadDialog.show(getSupportFragmentManager(), "Upload");
    }
}
