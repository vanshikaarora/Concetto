package com.example.vanshika.concetto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactUsActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_contact_us, R.id.content_main_linear_layout);

        getSupportActionBar().hide();
    }
}
