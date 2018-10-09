package com.example.vanshika.concetto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by lenovo on 9/29/2018.
 */

public class robowar extends MainActivity {
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
        super.replaceContentLayout(R.layout.event_layout, R.id.content_main_linear_layout);

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
                dataSnapshot = dataSnapshot.child("robo").child("prize");
                p = dataSnapshot.getValue().toString();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(robowar.this);
                about.setMessage(R.string.roboelig);
                AlertDialog ab = about.create();
                ab.setTitle("Eligibility");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judging = new AlertDialog.Builder(robowar.this);
                judging.setMessage(R.string.roborules);
                AlertDialog jd = judging.create();
                jd.setTitle("RULES");
                jd.show();
            }
        });
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(robowar.this);
                rules.setMessage(R.string.robojudging);
                AlertDialog ru = rules.create();
                ru.setTitle("JUDGING");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prizes = new AlertDialog.Builder(robowar.this);
                prizes.setMessage(p);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(robowar.this);
                contacts.setMessage(R.string.robospecs);
                AlertDialog co = contacts.create();
                co.setTitle("BOT SPECIFICATIONS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(robowar.this,robowar_registration.class));


            }
        });
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://l.facebook.com/l.php?u=https%3A%2F%2Fgoo.gl%2FcwzioE&h=AT0RXzwby5rYeSUxZI6vi-5rKghRiPl4S5D_4ItWwPwAZKy5N_hd2fsqx2vGShj60OVQLIlm-Cg2DrU1Gp2L_oCflmyEqCdq9GQcr8PwR6ypdxpPlRFWNG1T_PQ67oGffsc4vjxpBmIzVQAJ0ETIz-8EcKX51sKbO08VHn0MZEhhuYmWkKyWe7h8OW1t0XcSsLxhyPZXdmj-89lSB_hqCu63FS7VZlW5ymXRhzp6eh1pCsA9yv86z3-xm9gxBRUFR6TG0PZmJYaEMkYKbASc7knHFXptgxu3ZHYX15wJRYN-GBwdmuXGIDYPRyWDtKPGPHHasFCOCJ2uILI6zrVko5Nmd2nq5fSdzrIYM4-pMhsQYRof9hAsQ5shhk0GOp0FS8UEmPbmUE1-DrV4mgvsdD7FupVIGniJjQ";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });
    }

}
