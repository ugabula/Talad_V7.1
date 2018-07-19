package talad.co.taladv7;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by cvanderhaar on 2018/06/22.
 */

public class ConCreateAccountActivity extends AppCompatActivity {

    private EditText inputName, inputPassword, inputPhone, confirmPassword;
    private Button btnCreate;
    private TextView signIn;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_create_acc);


    }
}
