package com.example.vanshika.concetto;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by lenovo on 9/27/2018.
 */


public class Developers extends MainActivity {
    ImageView vsg,vsl,peg,pel,ssg,sl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.developers, R.id.content_main_linear_layout);

        getSupportActionBar().hide();
        vsg = (ImageView)findViewById(R.id.vanshigit);
        vsl = (ImageView)findViewById(R.id.vanshilinked);
        peg = (ImageView)findViewById(R.id.perugit);
        pel = (ImageView)findViewById(R.id.perulinked);
        ssg = (ImageView)findViewById(R.id.shridhargit);
        sl = (ImageView)findViewById(R.id.shridharlinked);
        vsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://github.com/vanshikaarora";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        vsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.linkedin.com/in/vanshika-arora-6396b4143/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });
        peg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://github.com/peruljain";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        pel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.linkedin.com/in/perul-jain";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        ssg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://github.com/ShridharGoel";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);

            }
        });
        sl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.linkedin.com/in/shridhar-goel/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(Developers.this, MainActivity.class));

    }
}
