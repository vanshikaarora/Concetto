package com.example.vanshika.concetto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by lenovo on 10/13/2018.
 */

public class testing extends AppCompatActivity {
 Button test;
 EditText t,t2,t3,t4;
 DatabaseReference testing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testing);
        t = (EditText)findViewById(R.id.editText);
        t2 = (EditText)findViewById(R.id.editText2);
        t3 = (EditText)findViewById(R.id.editText3);
        t4 = (EditText)findViewById(R.id.editText4);
        testing = FirebaseDatabase.getInstance().getReference("testing");
        test = (Button)findViewById(R.id.button);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = testing.push().getKey();
                cards c1 = new cards(t.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString(),"perul");
                testing.child(id).setValue(c1);
                Toast.makeText(testing.this, "Registration done For obstacle course racing ",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
