package com.example.gim_lic.logintest;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button btnLogin = findViewById(R.id.btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }
    private void Login(){
        EditText  txtLogin = findViewById(R.id.txtE_Login);
        EditText txtPass = findViewById(R.id.txtE_Pass);

        String login = txtLogin.getText().toString();
        String pass = txtPass.getText().toString();
        if ((login.equals("admin") && pass.equals("admin"))||(login.equals("a")&&pass.equals("a"))||(login.equals("")&&pass.equals(""))) {
            Intent intent = new Intent(getApplicationContext(),SecondaryActivity.class);
             startActivity(intent);
        }else
        {
            Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_LONG).show();
        }
    }
}
