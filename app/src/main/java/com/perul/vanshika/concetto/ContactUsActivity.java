package com.perul.vanshika.concetto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ContactUsActivity extends MainActivity {
    ImageView a, b, c, d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_contact_us, R.id.content_main_linear_layout);
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
