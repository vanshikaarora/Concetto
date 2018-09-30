package com.example.vanshika.concetto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lenovo on 9/29/2018.
 */

public class obstaclecourseracing extends AppCompatActivity {
    TextView tl,t2;
    Button ab,ru,pr,co,reg;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obstaclecourseracing);
        getSupportActionBar().hide();
        tl = (TextView)findViewById(R.id.title);
        t2 = (TextView)findViewById(R.id.title1);

        ab = (Button)findViewById(R.id.bt1);
        ru = (Button)findViewById(R.id.bt2);
        pr = (Button)findViewById(R.id.bt3);
        co = (Button)findViewById(R.id.bt4);
        reg = (Button)findViewById(R.id.bt5);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(obstaclecourseracing.this);
                about.setMessage("sujal jain");
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(obstaclecourseracing.this);
                rules.setMessage("rules are found");
                AlertDialog ru = rules.create();
                ru.setTitle("RULES");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prizes = new AlertDialog.Builder(obstaclecourseracing.this);
                prizes.setMessage("Rs 2000");
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(obstaclecourseracing.this);
                contacts.setMessage("Rs 20000");
                AlertDialog co = contacts.create();
                co.setTitle("CONTACTS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(obstaclecourseracing.this,obstacle_registration.class));

            }
        });

    }
}
