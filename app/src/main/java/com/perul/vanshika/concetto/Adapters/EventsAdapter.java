package com.perul.vanshika.concetto.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.perul.vanshika.concetto.EventsActivity;
import com.perul.vanshika.concetto.Models.Event;
import com.perul.vanshika.concetto.R;
import com.perul.vanshika.concetto.aquarise;
import com.perul.vanshika.concetto.blinddate;
import com.perul.vanshika.concetto.buffetmoney;
import com.perul.vanshika.concetto.buildabit;
import com.perul.vanshika.concetto.chemcarnival;
import com.perul.vanshika.concetto.chemecar;
import com.perul.vanshika.concetto.csgo;
import com.perul.vanshika.concetto.earth;
import com.perul.vanshika.concetto.electrabuzz;
import com.perul.vanshika.concetto.electrocharades;
import com.perul.vanshika.concetto.fifa;
import com.perul.vanshika.concetto.flash;
import com.perul.vanshika.concetto.frothfloatation;
import com.perul.vanshika.concetto.googleminer;
import com.perul.vanshika.concetto.industrialdesignproblem;
import com.perul.vanshika.concetto.lasertag;
import com.perul.vanshika.concetto.leverthehuge;
import com.perul.vanshika.concetto.maglocart;
import com.perul.vanshika.concetto.memewar;
import com.perul.vanshika.concetto.modelthecaravel;
import com.perul.vanshika.concetto.mun;
import com.perul.vanshika.concetto.obstaclecourseracing;
import com.perul.vanshika.concetto.paper_dance;
import com.perul.vanshika.concetto.pubg;
import com.perul.vanshika.concetto.quiz;
import com.perul.vanshika.concetto.robowar;
import com.perul.vanshika.concetto.route;
import com.perul.vanshika.concetto.sinwin;
import com.perul.vanshika.concetto.spardhatechbizz;
import com.perul.vanshika.concetto.surveytopographia;
import com.perul.vanshika.concetto.symposium;
import com.perul.vanshika.concetto.techtriathlon;
import com.perul.vanshika.concetto.tesla;
import com.perul.vanshika.concetto.thebafflingplanet;
import com.perul.vanshika.concetto.thrillofdrill;
import com.perul.vanshika.concetto.trusstheframe;
import com.perul.vanshika.concetto.unravelthewhizz;
import com.perul.vanshika.concetto.vitricity;
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
            AlertDialog.Builder about_builder;

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
                            Intent intent=new Intent(mCtx, electrabuzz.class); //Change it to electrabuzz after the class is created
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
                            Intent intent=new Intent(mCtx, thrillofdrill.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Google Miner"))
                        {
                            Intent intent=new Intent(mCtx, googleminer.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("TechPro"))
                        {
                            Intent intent=new Intent(mCtx,frothfloatation.class);
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

                        else if(event.getName().equals("Chem-e-carnival"))
                        {
                            Intent intent=new Intent(mCtx, chemcarnival.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Paper Dance"))
                        {
                            Intent intent=new Intent(mCtx, paper_dance.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Blind Date"))
                        {
                            Intent intent=new Intent(mCtx, blinddate.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Meme War"))
                        {
                            Intent intent=new Intent(mCtx, memewar.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Laser Tag"))
                        {
                            Intent intent=new Intent(mCtx, lasertag.class);
                            mCtx.startActivity(intent);
                        }

                        else if(event.getName().equals("Sin and Win"))
                        {
                            Intent intent=new Intent(mCtx, sinwin.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("EArTh"))
                        {
                            Intent intent=new Intent(mCtx, earth.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("Magl-o-cart"))
                        {
                            Intent intent=new Intent(mCtx, maglocart.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("Aqua Rise"))
                        {
                            Intent intent=new Intent(mCtx, aquarise.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("Route The Truck"))
                        {
                            Intent intent=new Intent(mCtx, route.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("Model United Nations"))
                        {
                            Intent intent=new Intent(mCtx, mun.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("BUILD A BIT"))
                        {
                            Intent intent=new Intent(mCtx, buildabit.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("PUBG"))
                        {
                            Intent intent=new Intent(mCtx, pubg.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("CS Go"))
                        {
                            Intent intent=new Intent(mCtx, csgo.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("FIFA"))
                        {
                            Intent intent=new Intent(mCtx, fifa.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("CONTRIVANCE"))
                        {
                            about_builder = new AlertDialog.Builder(mCtx);
                            about_builder.setMessage(R.string.contrivance);
                            AlertDialog alert_about = about_builder.create();
                            alert_about.setTitle("About");
                            // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
                            alert_about.show();
                        }
                        else if(event.getName().equals("BIZATHON"))
                        {
                            about_builder = new AlertDialog.Builder(mCtx);
                            about_builder.setMessage(R.string.shark);
                            AlertDialog alert_about = about_builder.create();
                            alert_about.setTitle("About");
                            // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
                            alert_about.show();
                        }
                        else if(event.getName().equals("BIG BANG QUIZ"))
                        {
                            Intent intent=new Intent(mCtx, quiz.class);
                            mCtx.startActivity(intent);
                        }
                        else if(event.getName().equals("SURVEY TOPOGRAPHIA"))
                        {
                            Intent intent=new Intent(mCtx, surveytopographia.class);
                            mCtx.startActivity(intent);
                        }
                    }
                });
            }
        }

    }

