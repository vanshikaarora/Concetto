package com.example.vanshika.concetto;

import android.content.Intent;
import android.net.Uri;
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
 * Created by lenovo on 10/2/2018.
 */

public class flash extends MainActivity {
    TextView tl;
    Button ab,ta,pr,ar,reg,ru,bot;
    AlertDialog.Builder about;
    AlertDialog.Builder rules;
    AlertDialog.Builder prizes;
    AlertDialog.Builder contacts;
    AlertDialog.Builder judging;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.flash, R.id.content_main_linear_layout);

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

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about = new AlertDialog.Builder(flash.this);
                about.setMessage(R.string.flashabout);
                AlertDialog ab = about.create();
                ab.setTitle("ABOUT");
                ab.show();


            }
        });
        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judging = new AlertDialog.Builder(flash.this);
                judging.setMessage(R.string.flashrules);
                AlertDialog jd = judging.create();
                jd.setTitle("RULES");
                jd.show();
            }
        });
        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules = new AlertDialog.Builder(flash.this);
                rules.setMessage(R.string.flashtasks);
                AlertDialog ru = rules.create();
                ru.setTitle("TASKS");
                ru.show();

            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prizes = new AlertDialog.Builder(flash.this);
                prizes.setMessage(R.string.flashPrize);
                AlertDialog pb = prizes.create();
                pb.setTitle("PRIZES");
                pb.show();

            }
        });
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts = new AlertDialog.Builder(flash.this);
                contacts.setMessage(R.string.flashbot);
                AlertDialog co = contacts.create();
                co.setTitle("BOT SPECIFICATIONS");
                co.show();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(flash.this,flash_reg.class));


            }
        });
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://l.facebook.com/l.php?u=https%3A%2F%2Fgoo.gl%2FosyhcT&h=AT0vgqJL4QsVTO0X3ICDwh-r2z2IXADzeAQ2BqPh7RjEvcapAU2ojbQWr74MpE2XG8FIxpXKgb_C-nNGhyC3VGHQWaseQIjJAOEA2vvaGWTBWzMh7MYLTAROWzaLKCoinBHRN_7cZXoWzEWcTtDO34TQKHoTVrEB5vi4l6VZbXi3KIjl3UR-8I28cvJqMPwnMeramk8Pi4FtA0fSvBnqm2J-lDjRulpqHrwA7kg01T2xBtWtBynWo28tY2IJIoXI22cWIOvETnYGDbfLfUmYOhPMf7hLnNSwzyaRpaUHP-RPhzz3GDNn_EYtQK67tqULO4e1PPdSFXdAuWhnfLYBA0aDdyBiN_M4qMzzwwh7R79PgZ4Jl_-yjjmRBDs6amxJKMkdJ2t4VW2jXV0OCEDhOUW6ZybMTKeDiw";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });
    }
}
