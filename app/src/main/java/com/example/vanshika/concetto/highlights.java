package com.example.vanshika.concetto;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Shridhar on 12-Oct-18.
 */

public class highlights extends MainActivity {
    CardView c1,c4,c3;
    TextView t1,t2,t3;
    TextView d1,d2,d3;
    TextView s1,s2,s3;
    DatabaseReference highlight;
    private   AlertDialog.Builder about_builder,c,r;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.highlights, R.id.content_main_linear_layout);
        getSupportActionBar().hide();
        init();
        highlight = FirebaseDatabase.getInstance().getReference("testing");
        highlight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChildren()){
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                     cards c2 = snapshot.getValue(cards.class);
                     Log.e(MainActivity.class.getSimpleName(),c2.getCard().toString());
                     if(c2.getCard().equals("yes1")){
                         String p = c2.getCardtitle();
                         Log.e(MainActivity.class.getSimpleName(),p);
                         t1.setText(p);
                         String q = c2.getCarddate();
                         d1.setText(q);
                         String e = c2.getCardtime();
                         s1.setText(e);
                       final  String u = c2.getCardabout();
                       c1.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               about_builder = new AlertDialog.Builder(highlights.this);
                               about_builder.setMessage(u);
                               AlertDialog alert_about = about_builder.create();
                               alert_about.setTitle("About");
                               // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
                               alert_about.show();
                           }
                       });

                     }
                        if(c2.getCard().equals("yes2")){
                            c4.setVisibility(View.VISIBLE);
                            String p = c2.getCardtitle();
                            t2.setText(p);
                            String q = c2.getCarddate();
                            d2.setText(q);
                            String e = c2.getCardtime();
                            s2.setText(e);
                           final String y = c2.getCardabout();
                           c4.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View v) {
                                   c = new AlertDialog.Builder(highlights.this);
                                   c.setMessage(y);
                                   AlertDialog alert_about = c.create();
                                   alert_about.setTitle("About");
                                   // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
                                   alert_about.show();
                               }
                           });

                        }
                        if(c2.getCard().equals("yes3")){
                            c3.setVisibility(View.VISIBLE);
                            String p = c2.getCardtitle();
                            t3.setText(p);
                            String q = c2.getCarddate();
                            d3.setText(q);
                            String e = c2.getCardtime();
                            s3.setText(e);
                           final String i = c2.getCardabout();
                            c3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    r = new AlertDialog.Builder(highlights.this);
                                    r.setMessage(i);
                                    AlertDialog alert_about = r.create();
                                    alert_about.setTitle("About");
                                    // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
                                    alert_about.show();
                                }
                            });

                        }


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    public void init(){
        c1 = (CardView)findViewById(R.id.card1);
        c4 = (CardView)findViewById(R.id.card2);
        c3 = (CardView)findViewById(R.id.card3);
        t1 = (TextView)findViewById(R.id.textViewTitle);
        t2 = (TextView)findViewById(R.id.textViewTitle2);
        t3 = (TextView)findViewById(R.id.textViewTitle3);
        d1 = (TextView)findViewById(R.id.textViewDate);
        d2 = (TextView)findViewById(R.id.textViewDate2);
        d3 = (TextView)findViewById(R.id.textViewDate3);
        s1 = (TextView)findViewById(R.id.textViewTime);
        s2 = (TextView)findViewById(R.id.textViewTime2);
        s3 = (TextView)findViewById(R.id.textViewTime3);
    }

}
