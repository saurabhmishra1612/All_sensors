package com.example.saurabh.all_sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class accelerometer extends AppCompatActivity implements SensorEventListener {
    TextView xvalue,yvalue,zvalue;
    private static final String TAG = "accelerometer";
    private SensorManager sensorManager;

    private Sensor acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        xvalue = findViewById(R.id.xvalue);
        yvalue = findViewById(R.id.yvalue);
        zvalue = findViewById(R.id.zvalue);

        Log.d(TAG,"onCreate: initializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (acc != null) {
            sensorManager.registerListener((SensorEventListener) accelerometer.this, acc, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered accelerometer listener");
        }else {
            xvalue.setText("ACCELEROMETER NOT SUPPORTED!!");
        }
    }

    public void onAccuracyChanged(Sensor sensor,int i){

    }

    public void onSensorChanged(SensorEvent sensorEvent){
        Log.d(TAG,"onSensorChanged:X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2] );
        xvalue.setText("xvalue: " + sensorEvent.values[0]);
        yvalue.setText("yvalue: " + sensorEvent.values[1]);
        zvalue.setText("zvalue: " + sensorEvent.values[2]);

    }
}
