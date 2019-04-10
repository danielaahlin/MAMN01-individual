package com.example.compass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private TextView xvalue, yvalue, zvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);

        xvalue = (TextView) findViewById(R.id.X_value);
        yvalue = (TextView) findViewById(R.id.Y_value);
        zvalue = (TextView) findViewById(R.id.Z_value);

    }

    private float round(float f){
        float a = f*100;
        a = Math.round(a);
        a = a/100;
        return a;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        float x,y,z;
        x = round(event.values[0]);
        y = round(event.values[1]);
        z = round(event.values[2]);

        if(x > 10 || y > 10 || z > 10){
            vib.vibrate(10);
        }

        xvalue.setText(Float.toString(x));
        yvalue.setText(Float.toString(y));
        zvalue.setText(Float.toString(z));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
