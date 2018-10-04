package com.example.vanshika.concetto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class About extends AppCompatActivity {
Animation openScale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        openScale= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.activity_open_scale);
        overridePendingTransition(R.anim.activity_open_scale,R.anim.activity_close_scale);
    }
}
