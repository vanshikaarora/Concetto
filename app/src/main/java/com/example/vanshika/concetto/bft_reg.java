package com.example.vanshika.concetto;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
 * Created by lenovo on 10/8/2018.
 */

public class bft_reg extends AppCompatActivity {
    String TAG = obstacle_registration.class.getSimpleName();

    EditText nm,m1,m2,m3;
    Button b;
    FirebaseDatabase obst;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singlereg);
        b = (Button)findViewById(R.id.button4);
        nm = (EditText)findViewById(R.id.tnm);
        m1 = (EditText)findViewById(R.id.mem1);
        m2 = (EditText)findViewById(R.id.mem2);
        m3 = (EditText)findViewById(R.id.mem3);
        //m4 = (EditText)findViewById(R.id.mem4);
        //em = (EditText)findViewById(R.id.em);
        //mo = (EditText)findViewById(R.id.mo);
        obst = FirebaseDatabase.getInstance();
        final DatabaseReference obs = obst.getReference("registration");


        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                final String name = nm.getText().toString();
                final String mem1 = m1.getText().toString();
                final String mem2 = m2.getText().toString();
                final String mem3 = m3.getText().toString();
                //final String mem4 = m4.getText().toString();
                // final String email = em.getText().toString();
                // final String mob = mo.getText().toString();
                boolean   connected = false;
                final View[] focusView = {null};
                //check internet connection
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;
                }
                else
                    connected = false;

                if(connected) {
                    if (TextUtils.isEmpty(name)) {
                        nm.setError("field is required");
                        focusView[0] = nm;

                    }
                    if (TextUtils.isEmpty(mem1)) {
                        m1.setError("field is required");
                        focusView[0] = m1;

                    }
                    if (TextUtils.isEmpty(mem2)) {
                        m2.setError("field is required");
                        focusView[0] = m2;

                    }
                    if (TextUtils.isEmpty(mem3)) {
                        m3.setError("field is required");
                        focusView[0] = m3;

                    }
                  /*  if(TextUtils.isEmpty(mem4)){
                        m4.setError("field is required");
                        focusView[0] = m4;

                    }
                    if(TextUtils.isEmpty(email)){
                        em.setError("field is required");
                        focusView[0] = em;

                    }*/
                    if (name.isEmpty() == true || mem1.isEmpty() == true || mem2.isEmpty() == true || mem3.isEmpty() == true) {

                    } else {
                        String id = obs.push().getKey();
                        obs.child("symposium").child(id).child("name").setValue(name);
                        obs.child("symposium").child(id).child("email").setValue(mem1);
                        obs.child("symposium").child(id).child("mobile").setValue(mem2);
                        obs.child("symposium").child(id).child("college").setValue(mem3);
                        FirebaseMessaging.getInstance().subscribeToTopic("buffetmoney");
                        Toast.makeText(bft_reg.this, "Registration done For BUFFETMONEY ",
                                Toast.LENGTH_LONG).show();
                        finish();
                        startActivity(new Intent(bft_reg.this, MainActivity.class));


                    }
                }
                else{
                    Toast.makeText(bft_reg.this, "INTERNET CONNECTION IS NOT AVAILABLE",
                            Toast.LENGTH_LONG).show();

                }



            }
        });
    }
}
