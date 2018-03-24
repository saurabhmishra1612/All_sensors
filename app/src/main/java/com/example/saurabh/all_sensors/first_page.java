package com.example.saurabh.all_sensors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class first_page extends AppCompatActivity {
    Button m,t,l,a,g;
    Animation uptodown,downtoup;
    LinearLayout la,lb;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        m = findViewById(R.id.m);
        l = findViewById(R.id.l1);
        t = findViewById(R.id.t);
        a = findViewById(R.id.a);
        g = findViewById(R.id.g);

        la = findViewById(R.id.la);
        lb = findViewById(R.id.lb);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        la.setAnimation(uptodown);
        lb.setAnimation(downtoup);


        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(first_page.this,magnetometer.class);
                startActivity(i);
            }
        });

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(first_page.this,light.class);
                startActivity(i);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(first_page.this,accelerometer.class);
                startActivity(i);
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(first_page.this,gyroscope.class);
                startActivity(i);
            }
        });

       t.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(first_page.this,temperature.class);
               startActivity(i);
           }
       });

    }
}
