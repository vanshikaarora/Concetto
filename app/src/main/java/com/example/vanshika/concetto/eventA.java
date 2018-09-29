package com.example.vanshika.concetto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.vanshika.concetto.R;

/**
 * Created by lenovo on 9/28/2018.
 */

public class eventA extends AppCompatActivity {
    //ImageView a;
    Button ab,ru,pr;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.eventa);

       ab = (Button)findViewById(R.id.button);
        ru = (Button)findViewById(R.id.button2);
        pr = (Button)findViewById(R.id.button3);
        getSupportActionBar().hide();

    }

    public void prizes(View view) {
        prizes = new AlertDialog.Builder(eventA.this);
        prizes.setMessage("Rs 2000");
        AlertDialog pb = prizes.create();
        pb.setTitle("PRIZES");
        pb.show();


    }

    public void about(View view) {
        about = new AlertDialog.Builder(eventA.this);
        about.setMessage("perul jain");
        AlertDialog ab = about.create();
        ab.setTitle("ABOUT");
        ab.show();

    }

    public void rules(View view) {
        rules = new AlertDialog.Builder(eventA.this);
        rules.setMessage("rules are");
        AlertDialog ru = rules.create();
        ru.setTitle("RULES");
        ru.show();
    }
}
