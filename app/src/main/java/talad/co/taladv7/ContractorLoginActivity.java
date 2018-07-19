package talad.co.taladv7;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by cvanderhaar on 2018/07/09.
 */

public class ContractorLoginActivity extends AppCompatActivity {

    private EditText mName, mAddress, mEmail, mPhone, mPass, mConfirmPass;
    private Button btnLogin, btnForgot, btnCreate;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_login);

        mAuth = FirebaseAuth.getInstance();

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    Intent choose = new Intent(ContractorLoginActivity.this, ConChooseServiceActivity.class);
                    startActivity(choose);
                    finish();
                }
            }
        };

        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
        mEmail = (EditText) findViewById(R.id.email);
        mPhone = (EditText) findViewById(R.id.phonenum);
        mPass = (EditText) findViewById(R.id.password);
        mConfirmPass = (EditText) findViewById(R.id.confirmpass);
        btnLogin = (Button) findViewById(R.id.btnCont);
        btnForgot = (Button) findViewById(R.id.forgotPassword);
        btnCreate = (Button) findViewById(R.id.create);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final String name = mName.getText().toString();
                //final String address = mAddress.getText().toString();
                final String email = mEmail.getText().toString();
                //final String phone = mPhone.getText().toString();
                final String pass = mPass.getText().toString();
               //final String conpass = mConfirmPass.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(ContractorLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(ContractorLoginActivity.this, "create account error", Toast.LENGTH_SHORT).show();
                        }else{
                            String user_id = mAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Contractors").child(user_id);
                            current_user_db.setValue(true);
                        }
                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString();
                final String password = mPass.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(ContractorLoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(ContractorLoginActivity.this, "create account error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgot = new Intent(ContractorLoginActivity.this, FarmerForgotPasswordActivity.class);
                startActivity(forgot);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthListener);
    }
}
