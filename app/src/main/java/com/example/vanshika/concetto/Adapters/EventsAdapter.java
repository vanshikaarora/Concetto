package com.example.vanshika.concetto.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.EventsActivity;
import com.example.vanshika.concetto.Models.Event;
import com.example.vanshika.concetto.R;
import com.example.vanshika.concetto.buffetmoney;
import com.example.vanshika.concetto.chemecar;
import com.example.vanshika.concetto.electrocharades;
import com.example.vanshika.concetto.flash;
import com.example.vanshika.concetto.googleminer;
import com.example.vanshika.concetto.industrialdesignproblem;
import com.example.vanshika.concetto.leverthehuge;
import com.example.vanshika.concetto.modelthecaravel;
import com.example.vanshika.concetto.obstaclecourseracing;
import com.example.vanshika.concetto.robowar;
import com.example.vanshika.concetto.spardhatechbizz;
import com.example.vanshika.concetto.symposium;
import com.example.vanshika.concetto.techtriathlon;
import com.example.vanshika.concetto.tesla;
import com.example.vanshika.concetto.thebafflingplanet;
import com.example.vanshika.concetto.trusstheframe;
import com.example.vanshika.concetto.unravelthewhizz;
import com.example.vanshika.concetto.vitricity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * Created by shridhar on 27-Sep-18.
 */

    public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventsViewHolder> {


        //this context we will use to inflate the layout
        private Context mCtx;

        //we are storing all the products in a list
        private List<Event> eventsList;

        //getting the context and product list with constructor
        public EventsAdapter(Context mCtx, List<Event> eventsList) {
            this.mCtx = mCtx;
            this.eventsList = eventsList;
        }

        @Override
        public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflating and returning our view holder
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.events_recycler_view_item, null);
            return new EventsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final EventsViewHolder holder, int position) {
            //getting the product of the specified position
            final Event event = eventsList.get(position);

            //binding the data with the viewholder views
            holder.textViewTitle.setText(event.getName());
            holder.imageView.setImageURI(Uri.parse(event.getImage()));

            final DatabaseReference ref= FirebaseDatabase.getInstance().getReference("EventTimings");

            final String[] date = new String[1];
            final String[] timing = new String[1];

            ref.child(event.getName()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        date[0] = dataSnapshot.child("Date").getValue().toString();
                        holder.textViewDate.setText(date[0]);
                    }

                    Log.d("EventsActivity", "onDataChange: " + date[0]);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });

            ref.child(event.getName()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()) {
                        timing[0] = dataSnapshot.child("Timing").getValue().toString();
                        holder.textViewTime.setText(timing[0]);
                    }

                    Log.d("EventsActivity", "onDataChange: " + timing[0]);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }

            });
        }


        @Override
        public int getItemCount() {
            return eventsList.size();
        }


        class EventsViewHolder extends RecyclerView.ViewHolder {

            TextView textViewTitle, textViewDate, textViewTime, textViewPrice;
            ImageView imageView;

            public EventsViewHolder(View itemView) {
                super(itemView);

                imageView=itemView.findViewById(R.id.events_image);
                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewDate = itemView.findViewById(R.id.textViewDate);
                textViewTime = itemView.findViewById(R.id.textViewTime);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Event event = eventsList.get(getAdapterPosition());

                        if(event.getName().equals("Robo Wars"))
                        {
                            Intent intent=new Intent(mCtx, robowar.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Model The Caravel"))
                        {
                            Intent intent=new Intent(mCtx, modelthecaravel.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Lever The Huge"))
                        {
                            Intent intent=new Intent(mCtx, leverthehuge.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Obstacle Course Racing"))
                        {
                            Intent intent=new Intent(mCtx, obstaclecourseracing.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Spardha Tech Bizz"))
                        {
                            Intent intent=new Intent(mCtx, spardhatechbizz.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Tech Triathlon"))
                        {
                            Intent intent=new Intent(mCtx, techtriathlon.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Truss The Frame"))
                        {
                            Intent intent=new Intent(mCtx, trusstheframe.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Vitricity"))
                        {
                            Intent intent=new Intent(mCtx, vitricity.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Flash"))
                        {
                            Intent intent=new Intent(mCtx, flash.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Buffet Money"))
                        {
                            Intent intent=new Intent(mCtx, buffetmoney.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Unravel The Whizz"))
                        {
                            Intent intent=new Intent(mCtx, unravelthewhizz.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Electrabuzz"))
                        {
                            Intent intent=new Intent(mCtx, vitricity.class); //Change it to electrabuzz after the class is created
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Electrocharades"))
                        {
                            Intent intent=new Intent(mCtx, electrocharades.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Tesla"))
                        {
                            Intent intent=new Intent(mCtx, tesla.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Tech Triathlon"))
                        {
                            Intent intent=new Intent(mCtx, techtriathlon.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Truss The Frame"))
                        {
                            Intent intent=new Intent(mCtx, trusstheframe.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Industrial Design Problem"))
                        {
                            Intent intent=new Intent(mCtx, industrialdesignproblem.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Thrill of Drill"))
                        {
                            Intent intent=new Intent(mCtx, tesla.class); //Change it
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Google Miner"))
                        {
                            Intent intent=new Intent(mCtx, googleminer.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Techpro"))
                        {
                            Intent intent=new Intent(mCtx,flash.class); //Change it
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("The Baffling Planet"))
                        {
                            Intent intent=new Intent(mCtx, thebafflingplanet.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Symposium"))
                        {
                            Intent intent=new Intent(mCtx, symposium.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Chem-e-car"))
                        {
                            Intent intent=new Intent(mCtx, chemecar.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Spardha Tech Bizz"))
                        {
                            Intent intent=new Intent(mCtx, spardhatechbizz.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Symposium"))
                        {
                            Intent intent=new Intent(mCtx, symposium.class);
                            mCtx.startActivity(intent);
                        }
                    }
                });
            }
        }

    }

