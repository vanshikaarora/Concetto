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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by lenovo on 10/6/2018.
 */

public class electrocharades_reg extends AppCompatActivity {
    String TAG = obstacle_registration.class.getSimpleName();

    EditText nm,m1,m2,m3,m4,em,mo,clgg;
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
        mo = (EditText)findViewById(R.id.mo);
        clgg = (EditText)findViewById(R.id.clg);
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
                final String mem4 = m4.getText().toString();
                final String email = em.getText().toString();
                final String mob = mo.getText().toString();
                final String clgn = clgg.getText().toString();
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

                if(connected){
                    if(TextUtils.isEmpty(name)){
                        nm.setError("field is required");
                        focusView[0] = nm;

                    }
                    if(TextUtils.isEmpty(mem1)){
                        m1.setError("field is required");
                        focusView[0] = m1;

                    }
                    if(TextUtils.isEmpty(mem2)){
                        m2.setError("field is required");
                        focusView[0] = m2;

                    }
                    if(TextUtils.isEmpty(mem3)){
                        m3.setError("field is required");
                        focusView[0] = m3;

                    }
                   /* if(TextUtils.isEmpty(mem4)){
                        m4.setError("field is required");
                        focusView[0] = m4;

                    }*/
                    if(TextUtils.isEmpty(email)){
                        em.setError("field is required");
                        focusView[0] = em;

                    }
                    if(TextUtils.isEmpty(clgn)){
                        clgg.setError("field is required");
                        focusView[0] = clgg;

                    }
                    if(name.isEmpty()==true||mem1.isEmpty()==true||mem2.isEmpty()==true||mem3.isEmpty()==true||email.isEmpty()==true||clgn.isEmpty()==true){

                    }else {
                        obs.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                dataSnapshot = dataSnapshot.child("electrocharades");
                                boolean flag = true;
                                if(dataSnapshot.hasChildren()){
                                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                        Log.e(obstacle_registration.class.getSimpleName(),"check1");
                                        //registration_team regss = snapshot.getValue(registration_team.class);
                                        String p = snapshot.child("teamname").getValue().toString();

                                        Log.e(obstacle_registration.class.getSimpleName(),p);
                                        if(p.equals(name)){
                                            Log.e(obstacle_registration.class.getSimpleName(),"check");
                                            nm.setError("THIS TEAM NAME ALREADY EXISTS ,CHOOSE ANOTHER TEAM NAME");
                                            Toast.makeText(electrocharades_reg.this, "Registration not done",
                                                    Toast.LENGTH_LONG).show();
                                            focusView[0] = nm;

                                            flag = false;
                                            break;
                                        }
                                    }
                                }
                                if(flag){
                                    Log.e(obstacle_registration.class.getSimpleName(),"enter");
                                    String id = obs.push().getKey();
                                    // registration_team reg = new registration_team(name,mem1,mem2,mem3,mem4,email);
                                    // obs.child(id).setValue(reg);
                                    obs.child("electrocharades").child(id).child("teamname").setValue(name);
                                    obs.child("electrocharades").child(id).child("member1").setValue(mem1);
                                    obs.child("electrocharades").child(id).child("member2").setValue(mem2);
                                    obs.child("electrocharades").child(id).child("member3").setValue(mem3);
                                    obs.child("electrocharades").child(id).child("member4").setValue(mem4);
                                    obs.child("electrocharades").child(id).child("email").setValue(email);
                                    obs.child("electrocharades").child(id).child("mobile").setValue(mob);
                                    obs.child("electrocharades").child(id).child("college").setValue(clgn);

                                    FirebaseMessaging.getInstance().subscribeToTopic("electrocharades");
                                    Toast.makeText(electrocharades_reg.this, "Registration done For ELECTROCHARADES ",
                                            Toast.LENGTH_LONG).show();
                                    finish();
                                    startActivity(new Intent(electrocharades_reg.this, MainActivity.class));

                                }


                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });




                    }


                }
                else {
                    Toast.makeText(electrocharades_reg.this,"INTERNET CONNECTION IS NOT AVAILABLE",
                            Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
