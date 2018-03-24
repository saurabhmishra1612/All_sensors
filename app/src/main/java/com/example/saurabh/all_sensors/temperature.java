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

public class temperature extends AppCompatActivity implements SensorEventListener {
    TextView tem,hum;
    private static final String TAG = "accelerometer";
    private SensorManager sensorManager;

    private Sensor temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        tem = findViewById(R.id.tem);
        hum = findViewById(R.id.hum);


        Log.d(TAG,"onCreate: initializing sensor services");
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        temp = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if (temp != null) {
            sensorManager.registerListener((SensorEventListener) temperature.this,temp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered temperature listener");
        }else {
            tem.setText("TEMPERATURE NOT SUPPORTED!!");
        }

        temp = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if (temp != null) {
            sensorManager.registerListener((SensorEventListener) temperature.this,temp, SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG, "Registered humidity listener");
        }else {
            hum.setText("HUMIDITY NOT SUPPORTED!!");
        }
    }

    public void onAccuracyChanged(Sensor sensor,int i){

    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            tem.setText("TEMPERATURE: " + sensorEvent.values[0]);
        }else {
            hum.setText("HUMIDITY: " + sensorEvent.values[0]);
        }

    }
}
