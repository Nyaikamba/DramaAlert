package e.android.dramaalert;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    //Authentication

    private EditText UserEmail;
    private EditText Password;
    private Button Login;
    private int counter = 3;
    private Button LearnMore;
    private Button Register;
    private TextView IncorrectAttempt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserEmail= findViewById(R.id.etUserEmail);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        LearnMore = findViewById(R.id.btnLearnMore);
        Register = findViewById(R.id.btnRegister);
        IncorrectAttempt = findViewById(R.id.IncorrectAttempt);

        IncorrectAttempt.setText(R.string.incorrectattempts);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        //if user logged in direct to test login page
        if (user != null)
        {
            finish();
            startActivity( new Intent(MainActivity.this, SecondActivity.class));
        }





        //Register Button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Registration.class));
            }
        });

        //Learn More Button
        LearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, LearnMore.class));

            }
        });


        //Login Button & Validation of administrator - Updated
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(UserEmail.getText().toString(), Password.getText().toString());

            }
        });




    }
    //Login Validation

    private void validate(String UserEmail, String UserPassword) {
        firebaseAuth.signInWithEmailAndPassword(UserEmail, UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL!", Toast.LENGTH_SHORT).show();
                    startActivity( new Intent(MainActivity.this, SecondActivity.class));
                }
                else
                    Toast.makeText(MainActivity.this,"LOGIN FAILED!"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    counter --;
                    IncorrectAttempt.setText("No. of attempts remaining: " + counter);
                    if (counter ==0)
                    {













                        Login.setEnabled(false);
                    }


            }
        });

        }





    }

