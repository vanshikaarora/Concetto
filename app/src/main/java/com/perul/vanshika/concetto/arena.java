package com.perul.vanshika.concetto;

import android.os.Bundle;

/**
 * Created by lenovo on 10/2/2018.
 */

public class arena extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.arena, R.id.content_main_linear_layout);
    }
}
