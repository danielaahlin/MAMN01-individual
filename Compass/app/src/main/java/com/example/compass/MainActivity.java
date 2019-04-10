package com.example.compass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeToCompass(View view){
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void changeToAccelerometer(View view){
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }
}
