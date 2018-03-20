package e.android.dramaalert;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {

    private EditText userName, userEmail, userPassword;
    private Button btnReg;
    private FirebaseAuth firebaseAuth;


    public Registration() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setUIViews();

        firebaseAuth= firebaseAuth.getInstance();


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    //Add info to database
                    final String user_email = userEmail.getText().toString().trim();
                    String user_name = userName.getText().toString().trim();
                    final String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.e("Data", user_password);
                            if(task.isSuccessful()) {
                                Toast.makeText(Registration.this, "REGISTRATION SUCCESSFUL!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registration.this, MainActivity.class));

                            }
                            else{
                            Toast.makeText(Registration.this, "REGISTRATION FAILED!", Toast.LENGTH_SHORT).show();
                        }
                    }});


                }
            }});}



    //update version
    private void setUIViews(){
        userName = findViewById(R.id.regUsername);
        userEmail = findViewById(R.id.regEmail);
        userPassword = findViewById(R.id.regPassword);
        btnReg = findViewById(R.id.btnReg);


    }

    //Makes sure registration is valid
    private Boolean validate()
    {
        Boolean result = false;
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Please enter all details!", Toast.LENGTH_SHORT).show();

        }
        else{
            result = true;
        }

        return result;


    }
}
