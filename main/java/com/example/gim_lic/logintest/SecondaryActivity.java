package com.example.gim_lic.logintest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.CameraProfile;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.VideoProfile;
import android.text.GetChars;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

public class SecondaryActivity extends AppCompatActivity {
    android.hardware.Camera cam = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        Button btnSms = findViewById(R.id.btnSms);
        Button btnMail = findViewById(R.id.btnMail);
        Button btnSettings = findViewById(R.id.btnSettings);
        Switch sw = findViewById(R.id.flashlight);


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Sorter(isChecked);
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
                startActivity(intent);
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



    private void Sorter(boolean isOn ){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M    ){
            CameraManager cm = (CameraManager) getApplicationContext().getSystemService(Context.CAMERA_SERVICE);
            try{
                cm.setTorchMode(cm.getCameraIdList()[0],isOn);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        }
        else {OldDevices(isOn);}
    }
    private void OldDevices(boolean isOn) {
        if (cam == null) cam = android.hardware.Camera.open();
        android.hardware.Camera.Parameters p = cam.getParameters();
        p.setFlashMode(android.hardware.Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        if (isOn) {
            cam.startPreview();
        } else {
            cam.stopPreview();
            cam.release();
            cam = null;
        }
    }
}
