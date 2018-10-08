package com.example.vanshika.concetto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.Adapters.EventsAdapter;
import com.example.vanshika.concetto.Adapters.GuestLectureAdapter;
import com.example.vanshika.concetto.Models.Event;
import com.example.vanshika.concetto.Models.GuestLecture;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.vanshika.concetto.R.drawable.concetto_white;

import com.firebase.ui.database.FirebaseRecyclerAdapter;

public class EventsActivity extends MainActivity {

    RecyclerView recyclerView;
    ArrayList<Event> eventsList;
    ArrayList<GuestLecture> guestLectures;
    DatabaseReference ref;
    TextView placeholder;
    RecyclerView.LayoutManager mLayoutManager;
    GuestLectureAdapter adapter;
    int childCount;
    FirebaseRecyclerOptions<GuestLecture> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_events, R.id.content_main_linear_layout);
        Animation openScale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_open_scale);
        overridePendingTransition(R.anim.popup_in,R.anim.activity_open_translate);
        getSupportActionBar().hide();

        placeholder = (TextView) findViewById(R.id.placeholder_text);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String whichClass = getIntent().getStringExtra("activity");

        if (whichClass.equals("events")) {
            //initializing the productlist
            eventsList = new ArrayList<>();

            String position = getIntent().getStringExtra("Position");

            //adding some items to our list

            ref = FirebaseDatabase.getInstance().getReference("EventTimings");

            if (position.equals("0")) {
                eventsList.add(
                        new Event("Paper Dance", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Blind Date", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Meme War", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Laser Tag", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Sin and Win", "android.resource://com.example.vanshika.concetto/" + concetto_white));

            } else if (position.equals("1")) {

                eventsList.add(
                        new Event("Robo Wars", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Obstacle Course Racing", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Flash", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("2")) {
                eventsList.add(
                        new Event("Buffet Money", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Unravel The Whizz", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("3")) {
                eventsList.add(
                        new Event("CSE", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("CSE", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("4")) {
                eventsList.add(
                        new Event("Electrabuzz", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("5")) {
                eventsList.add(
                        new Event("Electrocharades", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Tesla", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("6")) {
                eventsList.add(
                        new Event("Lever The Huge", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Model The Caravel", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("7")) {
                eventsList.add(
                        new Event("Tech Triathlon", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Truss The Frame", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("8")) {
                eventsList.add(
                        new Event("Industrial Design Problem", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("9")) {
                eventsList.add(

                        new Event("Thrill of Drill", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("10")) {
                eventsList.add(
                        new Event("Google Miner", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Techpro", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("11")) {
                eventsList.add(
                        new Event("The Baffling Planet", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("12")) {
eventsList.add(
                        new Event("Aqua Rise", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("10")) {
                eventsList.add(
                        new Event("Thrill of Drill", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("11")) {
                eventsList.add(
                        new Event("Google Miner", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));

                eventsList.add(
                        new Event("Techpro", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("12")) {
                eventsList.add(
                        new Event("The Baffling Planet", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("13")) {

                eventsList.add(
                        new Event("Symposium", "android.resource://com.example.vanshika.concetto/" + concetto_white));

            } else if (position.equals("13")) {

                //else if(position.equals("14")) {

                eventsList.add(
                        new Event("Chem-e-car", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(

                        new Event("Chem-e-carnival", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("14")) {
                eventsList.add(
                        new Event("Spardha Tech Bizz", "android.resource://com.example.vanshika.concetto/" + concetto_white));
            } else if (position.equals("14")) {
                eventsList.add(
                        new Event("Management", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(new Event("Chem-e-carnival", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("15")) {
                eventsList.add(
                        new Event("Magl-o-cart", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));
            }

            else if(position.equals("16")) {
                eventsList.add(
                        new Event("Spardha Tech Bizz", "android.resource://com.example.vanshika.concetto/" + R.drawable.concetto_white));

            }

//creating recyclerview adapter
            EventsAdapter adapter = new EventsAdapter(this, eventsList);

            //setting adapter to recyclerview
            recyclerView.setAdapter(adapter);


        } else if (whichClass.equals("guest_lectures")) {
            guestLectures = new ArrayList<>();
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference();//HAve you made this reference already in the database?
            DatabaseReference dRef = ref.child("GuestLectures");


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            Query query = reference.child("GuestLectures");

            //GuestLectureAdapter adapter=new GuestLectureAdapter(getApplicationContext(),)

            //DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
            Query query1 = reference.child("GuestLectures");
            query1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                        if (singleSnapshot != null) {
                            Log.v("mainactivity", singleSnapshot.getValue().toString());

                                GuestLecture newOrder = singleSnapshot.getValue(GuestLecture.class);//singleSshot he or neeche isi line pe datasnapshot use ki ho
                                if (newOrder != null) {// sir maine code run kiya hua h aur adapter main screen par bhi data aa rha h and notification bhi
                                        /*newOrder.setOrderid(singleSnapshot.getKey());
                                        setId = singleSnapshot.getKey();
                                        orderId = singleSnapshot.getKey();*/
                                        Log.v("ondatachange",newOrder.getDate()+" "+newOrder.getTime()+" "+newOrder.getGuest_name()+" "+newOrder.getLecture_name());
                                    adapter.notifyDataSetChanged();
                                }


                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            query.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if (dataSnapshot.getKey().equals("guest_lecture_1")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_1"));

                        //adapter.notifyDataSetChanged();
                    }
                    else if (dataSnapshot.getKey().equals("guest_lecture_2")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_2"));

                        //adapter.notifyDataSetChanged();
                    }
                    else if (dataSnapshot.getKey().equals("guest_lecture_3")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_3"));

                        //adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_4")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_4"));

                        //adapter.notifyDataSetChanged();
                    }
                }


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            list = new FirebaseRecyclerOptions.Builder<GuestLecture>()
                    .setQuery(query, GuestLecture.class)
                    .build();
adapter=new GuestLectureAdapter(EventsActivity.this,guestLectures);
recyclerView.setAdapter(adapter);

            /*mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            adapter = new FirebaseRecyclerAdapter<GuestLecture, listViewHolder>(list) {
                @Override
                protected void onBindViewHolder(@NonNull final listViewHolder holder, int position,
                                                @NonNull final GuestLecture model) {
                    holder.textViewDate.setText(model.getDate());
                    holder.textViewTime.setText(model.getTime());
                    holder.textViewTitle.setText(model.getLecture_name());

                }


                @NonNull
                @Override
                public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                         int viewType) {
                    listViewHolder holder =
                            new listViewHolder(LayoutInflater.from(EventsActivity.this).inflate(R.layout.card_view, parent, false));
                    return holder;
                }

                @Override
                public int getItemCount() {
                    //return super.getItemCount();
                    return childCount;
                }
            }

            ;
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(mLayoutManager);


        }
        ;

    }

    public class listViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewDate, textViewTime;
        ImageView imageView;

        public listViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.events_image);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);

            *//*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(EventsActivity.this)
                            .setTitle("About")
                            .setMessage("Note that nuking planet Jupiter will destroy everything in there.")
                            .setPositiveButton("Nuke", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.d("MainActivity", "Sending atomic bombs to Jupiter");
                                }
                            }).show();
                }
            });*//*
        */}
    }
}

/*DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
                Query query=reference.child("GuestLectures");
                Log.v("queryanswers",query.getRef().child("guest_lecture_1").toString());
                list=new FirebaseRecyclerOptions.Builder<GuestLecture>()
                        .setQuery(query,GuestLecture.class)
                        .build();
Log.v("listanswer",list.toString());

query.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
         childCount = (int) dataSnapshot.getChildrenCount();
        for(DataSnapshot singleSnapshot:dataSnapshot.getChildren()){
            Log.v("datasnap1",dataSnapshot.getValue().toString());
            Log.v("mainsnapshot",singleSnapshot.getValue()+" "+singleSnapshot.getKey()+" "+singleSnapshot.getChildren().toString());
            if (singleSnapshot!=null){
                GuestLecture lectureDetail=singleSnapshot.getValue(GuestLecture.class);
                if (lectureDetail!=null){
                    Log.v("wuery parameter",lectureDetail.getDate()+" "+lectureDetail.getGuest_name()+" "+lectureDetail.getLecture_name()+" "+lectureDetail.getTime());
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});





                query.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        childCount = (int) dataSnapshot.getChildrenCount();
                        for(DataSnapshot singleSnapshot:dataSnapshot.getChildren()){
                            Log.v("datasnap1",dataSnapshot.getValue().toString());
                            Log.v("mainsnapshot",singleSnapshot.getValue()+" "+singleSnapshot.getKey()+" "+singleSnapshot.getChildren().toString());
                            if (singleSnapshot!=null){
                                GuestLecture lectureDetail=singleSnapshot.getValue(GuestLecture.class);
                                if (lectureDetail!=null){
                                    Log.v("wuery parameter",lectureDetail.getDate()+" "+lectureDetail.getGuest_name()+" "+lectureDetail.getLecture_name()+" "+lectureDetail.getTime());
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



                adapter=new FirebaseRecyclerAdapter<GuestLecture,listViewHolder>(list) {
                    @Override
                    protected void onBindViewHolder(@NonNull listViewHolder holder, int position, @NonNull GuestLecture model) {

                        holder.imageView.setImageResource(R.drawable.concetto_white);
                        holder.textViewDate.setText(model.getDate());
                        holder.textViewTime.setText(model.getTime());
                        holder.textViewTitle.setText(model.getLecture_name()+" by "+model.getGuest_name());
                    }



                    @NonNull
                    @Override
                    public listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        listViewHolder holder =
                                new listViewHolder(LayoutInflater.from(EventsActivity.this).inflate(R.layout.events_recycler_view_item, parent, false));
                        return holder;
                    }

                    @Override
                    public int getItemCount() {
                        return 1;
                    }
                };
                LinearLayoutManager mLinearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);


                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(mLinearLayoutManager);

                *//*guestLectures.add(new GuestLecture("guest_lecture_1","lecturer-name1","android.resource://com.example.vanshika.concetto/" + concetto_white,"7:434am"));
                guestLectures.add(new GuestLecture("guest_lecture_1","lecturer-name1","android.resource://com.example.vanshika.concetto/" + concetto_white,"7:434am"));
                guestLectures.add(new GuestLecture("guest_lecture_1","lecturer-name1","android.resource://com.example.vanshika.concetto/" + concetto_white,"7:434am"));
                guestLectures.add(new GuestLecture("guest_lecture_1","lecturer-name1","android.resource://com.example.vanshika.concetto/" + concetto_white,"7:434am"));
*//*
//                GuestLectureAdapter adapter=new GuestLectureAdapter(this,guestLectures);
//                recyclerView.setAdapter(adapter);
            */