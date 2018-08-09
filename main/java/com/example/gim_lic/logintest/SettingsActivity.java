package com.example.gim_lic.logintest;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.service.autofill.SaveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class SettingsActivity extends AppCompatActivity {

    EditText etMail;
    EditText etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        etPhone = findViewById(R.id.etPhone);
        etMail = findViewById(R.id.etMail);

        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
                SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                finish();
            }
        });
    }
    private void Save(){
        String mail = etMail.getText().toString();
        String phone = etPhone.getText().toString();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        sp.edit().putString("mail",mail).apply();
        sp.edit().putString("phone",phone).apply();
    }
}
