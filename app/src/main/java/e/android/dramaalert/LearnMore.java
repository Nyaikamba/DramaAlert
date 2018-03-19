package e.android.dramaalert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearnMore extends AppCompatActivity {
    private Button Register;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);

        Register =findViewById(R.id.infoReg);
        Login = findViewById(R.id.infoLogin);

        //Register button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LearnMore.this, Registration.class));
            }
        });

        //Login Button

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(LearnMore.this, MainActivity.class));
            }
        });
    }


}
