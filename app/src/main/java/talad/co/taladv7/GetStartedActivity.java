package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

public class GetStartedActivity extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button getStarted, createAccount, forgotPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_login);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(GetStartedActivity.this, FarmerChooseServiceActivity.class));
            finish();
        }

        //Init variables
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        getStarted = (Button) findViewById(R.id.login);
        createAccount = (Button) findViewById(R.id.create);
        forgotPassword = (Button) findViewById(R.id.forgotPassword);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getstart = new Intent(GetStartedActivity.this, FarmerChooseServiceActivity.class);
                startActivity(getstart);
                finish();
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(GetStartedActivity.this, ConCreateAccountActivity.class);
                startActivity(create);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(GetStartedActivity.this, FarmerForgotPasswordActivity.class);
                startActivity(forgot);
            }
        });
    }
}
