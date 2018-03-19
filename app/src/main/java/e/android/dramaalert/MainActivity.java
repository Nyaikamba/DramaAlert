package e.android.dramaalert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
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

        Username = findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        Login = findViewById(R.id.btnLogin);
        LearnMore = findViewById(R.id.btnLearnMore);
        Register = findViewById(R.id.btnRegister);
        IncorrectAttempt = findViewById(R.id.IncorrectAttempt);

        IncorrectAttempt.setText("No of attempts remaining: 3 ");

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


        //Login Button & Validation of administrator - To update
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());

            }
        });




    }

    private void validate(String UserName, String UserPassword) {
        if ((UserPassword.equals("12345")) && (UserName.equals("Administrator")))
        {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);}
        else
            {
                counter--;

                IncorrectAttempt.setText("No of attempts remaining: " + String.valueOf(counter));

                if (counter == 0) {
                    Login.setEnabled(false);
                }
        }

        }



    }

