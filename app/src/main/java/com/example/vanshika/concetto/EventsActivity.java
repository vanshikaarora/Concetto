package com.example.vanshika.concetto;

import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.vanshika.concetto.Adapters.EventsAdapter;
import com.example.vanshika.concetto.Models.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class EventsActivity extends MainActivity {

    RecyclerView recyclerView;
    List<Event> eventsList;
    DatabaseReference ref;
    TextView placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_events, R.id.content_main_linear_layout);

        getSupportActionBar().hide();

        placeholder=(TextView)findViewById(R.id.placeholder_text);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        eventsList = new ArrayList<>();

        String position = getIntent().getStringExtra("Position");

        //adding some items to our list

        ref=FirebaseDatabase.getInstance().getReference("EventTimings");

        if(position.equals("0")) {
            eventsList.add(
                    new Event("Event A"));

            eventsList.add(
                    new Event("Event B"));
        }

        else if(position.equals("1")) {

            eventsList.add(
                    new Event("Robowar"));

            eventsList.add(
                    new Event("Obstacle Course Racing"));

            eventsList.add(
                    new Event("Flash"));
        }

        else if(position.equals("2")) {
            eventsList.add(
                    new Event("Buffet Money"));

            eventsList.add(
                    new Event("Unravel"));
        }



        //creating recyclerview adapter
        EventsAdapter adapter = new EventsAdapter(this, eventsList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}

