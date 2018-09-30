package com.example.vanshika.concetto;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by lenovo on 9/30/2018.
 */

public class obstacle_registration extends AppCompatActivity {
    EditText nm,m1,m2,m3,m4,em;
    Button b;
    FirebaseDatabase obst;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regtest);
        b = (Button)findViewById(R.id.button4);
        nm = (EditText)findViewById(R.id.tnm);
        m1 = (EditText)findViewById(R.id.mem1);
        m2 = (EditText)findViewById(R.id.mem2);
        m3 = (EditText)findViewById(R.id.mem3);
        m4 = (EditText)findViewById(R.id.mem4);
        em = (EditText)findViewById(R.id.em);
        obst = FirebaseDatabase.getInstance();
        final DatabaseReference obs = obst.getReference("obstacle");


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nm.getText().toString();
                String mem1 = m1.getText().toString();
                String mem2 = m2.getText().toString();
                String mem3 = m3.getText().toString();
                String mem4 = m4.getText().toString();
                String email = em.getText().toString();
                boolean   connected = false;
                View focusView = null;
                //check internet connection
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                }
                else
                    connected = false;

                if(connected){
                    if(TextUtils.isEmpty(name)){
                        nm.setError("field is required");
                        focusView = nm;

                    }
                    if(TextUtils.isEmpty(mem1)){
                        m1.setError("field is required");
                        focusView = m1;

                    }
                    if(TextUtils.isEmpty(mem2)){
                        m2.setError("field is required");
                        focusView = m2;

                    }
                    if(TextUtils.isEmpty(mem3)){
                        m3.setError("field is required");
                        focusView = m3;

                    }
                    if(TextUtils.isEmpty(mem4)){
                        m4.setError("field is required");
                        focusView = m4;

                    }
                    if(TextUtils.isEmpty(email)){
                        nm.setError("field is required");
                        focusView = em;

                    }
                    if(name.isEmpty()==true||mem1.isEmpty()==true||mem2.isEmpty()==true||mem3.isEmpty()==true||mem4.isEmpty()==true||email.isEmpty()==true){

                    }else {
                        String id = obs.push().getKey();
                        registration_team reg = new registration_team(name,mem1,mem2,mem3,mem4,email);
                        obs.child("obstacle course").child(id).setValue(reg);
                        FirebaseMessaging.getInstance().subscribeToTopic("obstaclecourseracing");
                        Toast.makeText(obstacle_registration.this, "Registration done For obstacle course racing ",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(obstacle_registration.this, MainActivity.class));


                    }


                }
                else {
                    Toast.makeText(obstacle_registration.this,"INTERNET CONNECTION IS NOT AVAILABLE",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
