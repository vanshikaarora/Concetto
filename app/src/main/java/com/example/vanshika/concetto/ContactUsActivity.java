package com.example.vanshika.concetto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.example.vanshika.concetto.R.drawable.amrit;
import static com.example.vanshika.concetto.R.drawable.pubgic;

public class ContactUsActivity extends AppCompatActivity {
    ImageView a, b, c, d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        a = (ImageView) findViewById(R.id.aj);
        b = (ImageView) findViewById(R.id.pj);
        c = (ImageView) findViewById(R.id.sj);
        d = (ImageView) findViewById(R.id.anuuj);


        Glide.with(ContactUsActivity.this).load(R.drawable.amrit).into(a);
        Glide.with(ContactUsActivity.this).load(R.drawable.pranjal).into(b);
        Glide.with(ContactUsActivity.this).load(R.drawable.singhal).into(c);
        Glide.with(ContactUsActivity.this).load(R.drawable.anuroop).into(d);





    }
}
