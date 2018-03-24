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

public class gyroscope extends AppCompatActivity implements SensorEventListener {
    TextView xgvalue,ygvalue,zgvalue;
    private static final String TAG = "accelerometer";
    private SensorManager sensorManager;

    private Sensor mgyro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);
        xgvalue = findViewById(R.id.xgvalue);
        ygvalue = findViewById(R.id.ygvalue);
        zgvalue = findViewById(R.id.zgvalue);

        Log.d(TAG,"onCreate: initializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mgyro = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mgyro != null) {
            sensorManager.registerListener((SensorEventListener) gyroscope.this, mgyro, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered accelerometer listener");
        }else {
            xgvalue.setText("GYROMETER NOT SUPPORTED!!");
        }
    }

    public void onAccuracyChanged(Sensor sensor,int i){

    }

    public void onSensorChanged(SensorEvent sensorEvent){
        Log.d(TAG,"onSensorChanged:X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2] );
        xgvalue.setText("xgvalue: " + sensorEvent.values[0]);
        ygvalue.setText("ygvalue: " + sensorEvent.values[1]);
        zgvalue.setText("zgvalue: " + sensorEvent.values[2]);

    }
}
