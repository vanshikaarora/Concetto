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
 * Created by lenovo on 10/4/2018.
 */

public class thebafflingplanet extends MainActivity {
    TextView tl,t2;
    Button ab,ru,pr,co,reg;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.bafflingplanet, R.id.content_main_linear_layout);

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
                about = new AlertDialog.Builder(thebafflingplanet.this);
                about.setMessage(R.string.bafabout);
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(thebafflingplanet.this);
                rules.setMessage(R.string.bafrules);
                AlertDialog ru = rules.create();
                ru.setTitle("RULES");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prizes = new AlertDialog.Builder(thebafflingplanet.this);
                prizes.setMessage(R.string.bafflingPrize);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(thebafflingplanet.this);
                contacts.setMessage(R.string.bafcon);
                AlertDialog co = contacts.create();
                co.setTitle("CONTACTS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(thebafflingplanet.this,bafflingplanet_reg.class));

            }
        });

    }
}
