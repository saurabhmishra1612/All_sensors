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

public class light extends AppCompatActivity implements SensorEventListener {
    TextView lig,pre;
    private static final String TAG = "accelerometer";
    private SensorManager sensorManager;

    private Sensor mlig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        lig = findViewById(R.id.lig);
        pre = findViewById(R.id.pre);

        Log.d(TAG,"onCreate: initializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mlig = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mlig != null) {
            sensorManager.registerListener((SensorEventListener) light.this, mlig, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered light listener");
        }else {
            lig.setText("LIGHT NOT SUPPORTED!!");
        }

        mlig = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if (mlig != null) {
            sensorManager.registerListener((SensorEventListener) light.this, mlig, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered Pressure listener");
        }else {
            pre.setText("PRESSURE NOT SUPPORTED!!");
        }
    }

    public void onAccuracyChanged(Sensor sensor,int i){

    }

    public void onSensorChanged(SensorEvent sensorEvent){
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_LIGHT) {
            lig.setText("Light: " + sensorEvent.values[0]);
        }else {
            pre.setText("Pressure: " + sensorEvent.values[0]);
        }

    }
}
