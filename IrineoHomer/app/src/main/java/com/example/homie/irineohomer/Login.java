package com.example.homie.irineohomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPass = (EditText) findViewById(R.id.txtPass);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(txtUsername.getText().toString().equals("admin") && txtPass.getText().toString().equals("test"))
                {

                    Intent intent = new Intent(Login.this,Touch.class );
                    startActivity(intent);
                }
                else
                {
                    txtUsername.setError("Invalid Username or Password");
                    txtPass.setError("Invalid Username or Password");
                }
            }

        });

    }
}