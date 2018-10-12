package com.example.vanshika.concetto;

import android.os.Bundle;

/**
 * Created by Shridhar on 12-Oct-18.
 */

public class highlights extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.highlights, R.id.content_main_linear_layout);

        getSupportActionBar().hide();
    }

}
