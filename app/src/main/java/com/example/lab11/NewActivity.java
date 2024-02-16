package com.example.lab11;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    Button finishB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        finishB = findViewById(R.id.finishNew);
        finishB.setOnClickListener((v)->{
            this.finish();
        });
    }
}
