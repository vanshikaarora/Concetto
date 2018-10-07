package com.example.vanshika.concetto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by lenovo on 10/7/2018.
 */

public class lasertag extends MainActivity {
    TextView tl,t2;
    Button ab,ru,pr,co,reg;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;
    DatabaseReference obsta;
    String p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.laser, R.id.content_main_linear_layout);

        getSupportActionBar().hide();
        tl = (TextView)findViewById(R.id.title);
        t2 = (TextView)findViewById(R.id.title1);


        ab = (Button)findViewById(R.id.bt1);
        ru = (Button)findViewById(R.id.bt2);
        pr = (Button)findViewById(R.id.bt3);
        co = (Button)findViewById(R.id.bt4);
        reg = (Button)findViewById(R.id.bt5);
        obsta = FirebaseDatabase.getInstance().getReference();
        obsta.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataSnapshot = dataSnapshot.child("laser").child("prize");
                p = dataSnapshot.getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(lasertag.this);
                about.setMessage(R.string.laserabt);
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(lasertag.this);
                rules.setMessage(R.string.laserrules);
                AlertDialog ru = rules.create();
                ru.setTitle("RULES");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prizes = new AlertDialog.Builder(lasertag.this);
                prizes.setMessage(p);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(lasertag.this);
                contacts.setMessage(R.string.bafcon);
                AlertDialog co = contacts.create();
                co.setTitle("CONTACTS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(lasertag.this,laser_reg.class));


            }
        });

    }
}
