package com.example.lab11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView log;
    Button startNewB,callB,cameraB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = findViewById(R.id.log);
        log.append("create ");

        startNewB = findViewById(R.id.startNewB);
        startNewB.setOnClickListener((view)->{
            startActivity(new Intent(this, NewActivity.class) );
        });

        callB = findViewById(R.id.callB);
        callB.setOnClickListener((view)->{
            if (checkSelfPermission("android.permission.CALL_PHONE") == PackageManager.PERMISSION_GRANTED) {
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "123456789")));
            } else {
                requestPermissions(new String[]{ "android.permission.CALL_PHONE" }, 100);
            }
        });


        cameraB = findViewById(R.id.cameraB);
        cameraB.setOnClickListener((view)->{
            if (checkSelfPermission("android.permission.CAMERA") == PackageManager.PERMISSION_GRANTED) {
                startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
            } else {
                requestPermissions(new String[]{ "android.permission.CAMERA" }, 100);
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        log.append(String.valueOf(grantResults[0])+" ");
        if (grantResults[0] == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this,"Unable to run the task without permission", Toast.LENGTH_SHORT).show();
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStart() {
        super.onStart();
        log.append("start ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log.append("pause ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log.append("resume ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        log.append("stop ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log.append("restart ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log.append("destroy ");
    }
}