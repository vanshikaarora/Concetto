package com.example.vanshika.concetto;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by lenovo on 9/29/2018.
 */

public class obstaclecourseracing extends MainActivity {
    TextView tl;
    Button ab,ta,pr,ar,reg,ru,bot;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;
    AlertDialog.Builder judging;
    DatabaseReference tru;
    String p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.obstaclecourseracing, R.id.content_main_linear_layout);

        getSupportActionBar().hide();

        //// img = (ImageView)findViewById(R.id.titleImage);
        tl = (TextView)findViewById(R.id.title);

        ab = (Button)findViewById(R.id.bt1);
        ta = (Button)findViewById(R.id.bt2);
        pr = (Button)findViewById(R.id.bt3);
        bot = (Button)findViewById(R.id.bt4);
        reg = (Button)findViewById(R.id.bt5);
        ru = (Button)findViewById(R.id.bt6);
        ar = (Button)findViewById(R.id.bt7);
        tru = FirebaseDatabase.getInstance().getReference();
        tru.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot = dataSnapshot.child("obsta").child("prize");
                p = dataSnapshot.getValue().toString();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(obstaclecourseracing.this);
                about.setMessage(R.string.obstacleabout);
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judging = new AlertDialog.Builder(obstaclecourseracing.this);
                judging.setMessage(R.string.obstarules);
                AlertDialog jd = judging.create();
                jd.setTitle("RULES");
                jd.show();
            }
        });
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(obstaclecourseracing.this);
                rules.setMessage(R.string.obstajudging);
                AlertDialog ru = rules.create();
                ru.setTitle("TASKS");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prizes = new AlertDialog.Builder(obstaclecourseracing.this);
                prizes.setMessage(p);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(obstaclecourseracing.this);
                contacts.setMessage(R.string.obstaclespecs);
                AlertDialog co = contacts.create();
                co.setTitle("BOT SPECIFICATIONS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(obstaclecourseracing.this,obstacle_registration.class));


            }
        });
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

