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

public class magnetometer extends AppCompatActivity implements SensorEventListener {
    TextView xmvalue,ymvalue,zmvalue;
    private static final String TAG = "accelerometer";
    private SensorManager sensorManager;

    private Sensor mag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetometer);
        xmvalue = findViewById(R.id.xmvalue);
        ymvalue = findViewById(R.id.ymvalue);
        zmvalue = findViewById(R.id.zmvalue);

        Log.d(TAG,"onCreate: initializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mag != null) {
            sensorManager.registerListener((SensorEventListener) magnetometer.this, mag, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered magnometer listener");
        }else {
            xmvalue.setText("MAGNETOMETER NOT SUPPORTED!!");
            ymvalue.setText("MAGNETOMETER NOT SUPPORTED!!");
            zmvalue.setText("MAGNETOMETER NOT SUPPORTED!!");
        }
    }

    public void onAccuracyChanged(Sensor sensor,int i){

    }

    public void onSensorChanged(SensorEvent sensorEvent){
        Log.d(TAG,"onSensorChanged:X: " + sensorEvent.values[0] + "Y: " + sensorEvent.values[1] + "Z: " + sensorEvent.values[2] );
        xmvalue.setText("xmvalue: " + sensorEvent.values[0]);
        ymvalue.setText("ymvalue: " + sensorEvent.values[1]);
        zmvalue.setText("zmvalue: " + sensorEvent.values[2]);

    }
}
