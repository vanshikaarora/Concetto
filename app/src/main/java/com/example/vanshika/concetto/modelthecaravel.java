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
 * Created by lenovo on 10/1/2018.
 */

public class modelthecaravel extends MainActivity {
    TextView tl;
    Button ab,ru,pr,co,reg,jud;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;
    AlertDialog.Builder judging;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.modelthecaravel, R.id.content_main_linear_layout);

        getSupportActionBar().hide();

        //// img = (ImageView)findViewById(R.id.titleImage);
        tl = (TextView)findViewById(R.id.title);

        ab = (Button)findViewById(R.id.bt1);
        ru = (Button)findViewById(R.id.bt2);
        pr = (Button)findViewById(R.id.bt3);
        co = (Button)findViewById(R.id.bt4);
        reg = (Button)findViewById(R.id.bt5);
        jud = (Button)findViewById(R.id.bt6);

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(modelthecaravel.this);
                about.setMessage(R.string.modelthecaravel_desc);
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(modelthecaravel.this);
                rules.setMessage(R.string.modelthecaravel_rules);
                AlertDialog ru = rules.create();
                ru.setTitle("RULES");
                ru.show();

            }
        });
        jud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judging = new AlertDialog.Builder(modelthecaravel.this);
                judging.setMessage(R.string.modelthecaravel_winning_criteria);
                AlertDialog jd = judging.create();
                jd.setTitle("JUDGING");
                jd.show();
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prizes = new AlertDialog.Builder(modelthecaravel.this);
                prizes.setMessage(R.string.modelthecaravel_prizes);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(modelthecaravel.this);
                contacts.setMessage(R.string.modelthecaravel_contact);
                AlertDialog co = contacts.create();
                co.setTitle("CONTACTS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(modelthecaravel.this,model_reg.class));


            }
        });
    }
}
