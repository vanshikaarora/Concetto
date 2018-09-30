package com.example.vanshika.concetto;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.vanshika.concetto.Adapters.EventsAdapter;
import com.example.vanshika.concetto.Models.Event;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class EventsActivity extends MainActivity {

    RecyclerView recyclerView;
    List<Event> eventsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_events, R.id.content_main_linear_layout);

        getSupportActionBar().hide();

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        eventsList = new ArrayList<>();

        String position = getIntent().getStringExtra("Position");

        //adding some items to our list

        if(position.equals("0")) {
            eventsList.add(
                    new Event("Event A",
                            "26th October",
                            "10 AM to 12 PM"));

            eventsList.add(
                    new Event("Event B",
                            "27th October",
                            "6 PM to 7 PM"));
        }

        else if(position.equals("1")) {
            eventsList.add(
                    new Event("Event C",
                            "28th October",
                            "11 AM"));
        }

        else if(position.equals("2")) {
            eventsList.add(
                    new Event("Event D",
                            "28th October",
                            "5 PM to 6 PM"));
        }

        //creating recyclerview adapter
        EventsAdapter adapter = new EventsAdapter(this, eventsList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
    }

