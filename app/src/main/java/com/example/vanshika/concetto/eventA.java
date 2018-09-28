package com.example.vanshika.concetto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vanshika.concetto.R;

/**
 * Created by lenovo on 9/28/2018.
 */

public class eventA extends AppCompatActivity {
    ImageView a;
    Button ab,ru,pr;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.eventa);
       a = (ImageView)findViewById(R.id.imageView2);
       ab = (Button)findViewById(R.id.button);
        ru = (Button)findViewById(R.id.button2);
        pr = (Button)findViewById(R.id.button3);
    }
}
