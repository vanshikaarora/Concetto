package com.example.vanshika.concetto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vanshika.concetto.Adapters.EventsAdapter;
import com.example.vanshika.concetto.Adapters.GuestLectureAdapter;
import com.example.vanshika.concetto.Adapters.WorkshopAdapter;
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

import static com.example.vanshika.concetto.R.drawable.aqua_rise;
import static com.example.vanshika.concetto.R.drawable.baffling_planet;
import static com.example.vanshika.concetto.R.drawable.bizathonic;
import static com.example.vanshika.concetto.R.drawable.blind;
import static com.example.vanshika.concetto.R.drawable.blinddateic;
import static com.example.vanshika.concetto.R.drawable.buildabiltic;
import static com.example.vanshika.concetto.R.drawable.chemcarnivalic;
import static com.example.vanshika.concetto.R.drawable.chemecaric;
import static com.example.vanshika.concetto.R.drawable.concetto_white;
import static com.example.vanshika.concetto.R.drawable.csgoic;
import static com.example.vanshika.concetto.R.drawable.electrabuzzic;
import static com.example.vanshika.concetto.R.drawable.erth;
import static com.example.vanshika.concetto.R.drawable.fifaic;
import static com.example.vanshika.concetto.R.drawable.flashic;
import static com.example.vanshika.concetto.R.drawable.googlemineric;
import static com.example.vanshika.concetto.R.drawable.idpic;
import static com.example.vanshika.concetto.R.drawable.informal;
import static com.example.vanshika.concetto.R.drawable.leverthehudge;
//import static com.example.vanshika.concetto.R.drawable.magl_o_cartic;
import static com.example.vanshika.concetto.R.drawable.memewr;
import static com.example.vanshika.concetto.R.drawable.modelthecarvel;
import static com.example.vanshika.concetto.R.drawable.moneybuffet;
import static com.example.vanshika.concetto.R.drawable.munic;
import static com.example.vanshika.concetto.R.drawable.ocr;
//import static com.example.vanshika.concetto.R.drawable.paperdance;
import static com.example.vanshika.concetto.R.drawable.paperdanceicon;
import static com.example.vanshika.concetto.R.drawable.pubgic;
import static com.example.vanshika.concetto.R.drawable.robowarsic;
import static com.example.vanshika.concetto.R.drawable.routethetruckic;
import static com.example.vanshika.concetto.R.drawable.sin;
import static com.example.vanshika.concetto.R.drawable.sinwinic;
import static com.example.vanshika.concetto.R.drawable.spardhaic;
import static com.example.vanshika.concetto.R.drawable.symposiumic;
import static com.example.vanshika.concetto.R.drawable.techproic;
import static com.example.vanshika.concetto.R.drawable.teslaic;
import static com.example.vanshika.concetto.R.drawable.thebigbangquiz;
import static com.example.vanshika.concetto.R.drawable.thrillofrill;
import static com.example.vanshika.concetto.R.drawable.topographiaic;
import static com.example.vanshika.concetto.R.drawable.trusstheframeic;
import static com.example.vanshika.concetto.R.drawable.unravelic;

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
    WorkshopAdapter wAdapter;
    LinearLayout llProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_events, R.id.content_main_linear_layout);
        
       // Animation openScale = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.activity_open_scale);
       // overridePendingTransition(R.anim.popup_in,R.anim.activity_open_translate);
        getSupportActionBar().hide();


        placeholder = (TextView) findViewById(R.id.placeholder_text);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        guestLectures = new ArrayList<>();
        wAdapter=new WorkshopAdapter(EventsActivity.this,guestLectures);
        recyclerView.setAdapter(wAdapter);
        String whichClass = getIntent().getStringExtra("activity");

        if (whichClass.equals("events")) {
            //initializing the productlist
            eventsList = new ArrayList<>();

            String position = getIntent().getStringExtra("Position");

            //adding some items to our list

            ref = FirebaseDatabase.getInstance().getReference("EventTimings");

            if (position.equals("0")) {
                eventsList.add(
                        new Event("Paper Dance", "android.resource://com.example.vanshika.concetto/" + paperdanceicon));

                eventsList.add(
                        new Event("Blind Date", "android.resource://com.example.vanshika.concetto/" +blinddateic ));

                eventsList.add(
                        new Event("Meme War", "android.resource://com.example.vanshika.concetto/" + memewr));

                eventsList.add(
                        new Event("Laser Tag", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Sin and Win", "android.resource://com.example.vanshika.concetto/" + sinwinic));

                eventsList.add(
                        new Event("PUBG", "android.resource://com.example.vanshika.concetto/" + pubgic));

                eventsList.add(
                        new Event("CS Go", "android.resource://com.example.vanshika.concetto/" + csgoic));

                eventsList.add(
                        new Event("FIFA", "android.resource://com.example.vanshika.concetto/" + fifaic ));

            } else if (position.equals("3")) {

                eventsList.add(
                        new Event("Robo Wars", "android.resource://com.example.vanshika.concetto/" + robowarsic));

                eventsList.add(
                        new Event("Obstacle Course Racing", "android.resource://com.example.vanshika.concetto/" + ocr));

                eventsList.add(
                        new Event("Flash", "android.resource://com.example.vanshika.concetto/" + flashic));
            } else if (position.equals("4")) {
                eventsList.add(
                        new Event("Buffet Money", "android.resource://com.example.vanshika.concetto/" + moneybuffet));

                eventsList.add(
                        new Event("Unravel The Whizz", "android.resource://com.example.vanshika.concetto/" + unravelic));
            } else if (position.equals("5")) {
                eventsList.add(
                        new Event("EArTh", "android.resource://com.example.vanshika.concetto/" + erth));
                eventsList.add(
                        new Event("BUILD A BIT", "android.resource://com.example.vanshika.concetto/" + buildabiltic));

            } else if (position.equals("6")) {
                eventsList.add(
                        new Event("Electrabuzz", "android.resource://com.example.vanshika.concetto/" + electrabuzzic));
            } else if (position.equals("7")) {
                eventsList.add(
                        new Event("Electrocharades", "android.resource://com.example.vanshika.concetto/" + concetto_white));

                eventsList.add(
                        new Event("Tesla", "android.resource://com.example.vanshika.concetto/" + teslaic));
            } else if (position.equals("8")) {
                eventsList.add(
                        new Event("Lever The Huge", "android.resource://com.example.vanshika.concetto/" + leverthehudge));

                eventsList.add(
                        new Event("Model The Caravel", "android.resource://com.example.vanshika.concetto/" + modelthecarvel));
            } else if (position.equals("9")) {
                eventsList.add(
                        new Event("Tech Triathlon", "android.resource://com.example.vanshika.concetto/" + R.drawable.techtriathlon));

                eventsList.add(
                        new Event("Truss The Frame", "android.resource://com.example.vanshika.concetto/" + trusstheframeic));
            } else if (position.equals("10")) {
                eventsList.add(
                        new Event("Industrial Design Problem", "android.resource://com.example.vanshika.concetto/" + idpic));
                eventsList.add(
                        new Event("SURVEY TOPOGRAPHIA", "android.resource://com.example.vanshika.concetto/" + topographiaic));
            }

            else if (position.equals("11")) {
                eventsList.add(
                        new Event("Aqua Rise", "android.resource://com.example.vanshika.concetto/" + aqua_rise));
            }

            else if (position.equals("12")) {
                eventsList.add(

                        new Event("Thrill of Drill", "android.resource://com.example.vanshika.concetto/" + thrillofrill));
            } else if (position.equals("13")) {
                eventsList.add(
                        new Event("Google Miner", "android.resource://com.example.vanshika.concetto/" + googlemineric));

                eventsList.add(
                        new Event("TechPro", "android.resource://com.example.vanshika.concetto/" + techproic));
            }

            else if (position.equals("14")) {
                eventsList.add(
                        new Event("The Baffling Planet", "android.resource://com.example.vanshika.concetto/" + baffling_planet));
            }

            else if(position.equals("15")) {

                eventsList.add(
                        new Event("Symposium", "android.resource://com.example.vanshika.concetto/" + symposiumic));

            } else if (position.equals("16")) {
                eventsList.add(
                        new Event("Chem-e-car", "android.resource://com.example.vanshika.concetto/" + chemecaric));

                eventsList.add(

                        new Event("Chem-e-carnival", "android.resource://com.example.vanshika.concetto/" + chemcarnivalic));
            } else if (position.equals("17")) {
                eventsList.add(
                        new Event("Magl-o-cart", "android.resource://com.example.vanshika.concetto/" + R.drawable.maglocart));
            }

            else if (position.equals("18")) {
                eventsList.add(
                        new Event("Spardha Tech Bizz", "android.resource://com.example.vanshika.concetto/" + spardhaic));
            }

            else if (position.equals("19")) {
                eventsList.add(
                        new Event("Model United Nations", "android.resource://com.example.vanshika.concetto/" + munic));

                eventsList.add(
                        new Event("Route The Truck", "android.resource://com.example.vanshika.concetto/" + routethetruckic));

            }
            else if (position.equals("1")) {

                eventsList.add(
                        new Event("BIZATHON", "android.resource://com.example.vanshika.concetto/" + bizathonic));

                eventsList.add(
                        new Event("BUILD A BIT", "android.resource://com.example.vanshika.concetto/" + buildabiltic));


            }
            else if(position.equals("2")){
                eventsList.add(
                        new Event("BIG BANG QUIZ", "android.resource://com.example.vanshika.concetto/" + thebigbangquiz));
            }

//creating recyclerview adapter
            EventsAdapter adapter = new EventsAdapter(this, eventsList);

            //setting adapter to recyclerview
            recyclerView.setAdapter(adapter);


        } else if (whichClass.equals("guest_lectures")) {
            llProgress = (LinearLayout) findViewById(R.id.llProgress);
            showProgress("Loading...");
            guestLectures = new ArrayList<>();
            adapter=new GuestLectureAdapter(EventsActivity.this,guestLectures);
            recyclerView.setAdapter(adapter);
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference();//HAve you made this reference already in the database?
            DatabaseReference dRef = ref.child("GuestLectures");


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            Query query = reference.child("GuestLectures");

            //GuestLectureAdapter adapter=new GuestLectureAdapter(getApplicationContext(),)

            //DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
            /*Query query1 = reference.child("GuestLectures");
            query1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    childCount = (int) dataSnapshot.getChildrenCount();
                    for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                        if (singleSnapshot != null) {
                            Log.v("mainactivity", singleSnapshot.getValue().toString());

                                GuestLecture newOrder = singleSnapshot.getValue(GuestLecture.class);//singleSshot he or neeche isi line pe datasnapshot use ki ho
                                if (newOrder != null) {// sir maine code run kiya hua h aur adapter main screen par bhi data aa rha h and notification bhi
                                        *//*newOrder.setOrderid(singleSnapshot.getKey());
                                        setId = singleSnapshot.getKey();
                                        orderId = singleSnapshot.getKey();*//*
                                        Log.v("ondatachange",newOrder.getDate()+" "+newOrder.getTime()+" "+newOrder.getGuest_name()+" "+newOrder.getLecture_name());
                                    adapter.notifyDataSetChanged();
                                }


                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/

            query.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    if (dataSnapshot.getKey().equals("guest_lecture_1")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_1",R.drawable.ayan_mishra));

                        adapter.notifyDataSetChanged();
                    }
                    else if (dataSnapshot.getKey().equals("guest_lecture_2")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_2",R.drawable.mihir_ojha));

                        adapter.notifyDataSetChanged();
                    }
                    else if (dataSnapshot.getKey().equals("guest_lecture_3")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_3",R.drawable.guest_lecture));

                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_4")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_4",R.drawable.guest_lecture));

                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_5")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_5",R.drawable.guest_lecture));

                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_6")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_6",R.drawable.guest_lecture));

                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_7")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),dataSnapshot.child("guest_name").getValue().toString(),dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),"guest_lecture_7",R.drawable.guest_lecture));

                        adapter.notifyDataSetChanged();
                    }llProgress.setVisibility(View.GONE);
                }


                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getKey().equals("guest_lecture_1")){
                        guestLectures.remove(0);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_2")){
                        guestLectures.remove(1);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_3")){
                        guestLectures.remove(2);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_4")){
                        guestLectures.remove(3);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_5")){
                        guestLectures.remove(4);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_6")){
                        guestLectures.remove(5);
                        adapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("guest_lecture_7")){
                        guestLectures.remove(6);
                        adapter.notifyDataSetChanged();
                    }
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
        else if (whichClass.equals("workshop")){
            llProgress = (LinearLayout) findViewById(R.id.llProgress);
            showProgress("Loading...");

            //guestLectures.add(new GuestLecture("Internet of things","","6/10/2018","9am to 4pm","https://drive.google.com/file/d/1yXd7znVEM-IVODXwyjGD0jWMmC00elWR/view"));

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            Query query = reference.child("Workshop");
            query.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    if (dataSnapshot.getKey().equals("workshop_1")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),"",dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("about").getValue().toString()));
                        wAdapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("workshop_2")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),"",dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("about").getValue().toString()));
                        wAdapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("workshop_3")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),"",dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("about").getValue().toString()));
                        wAdapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("workshop_4")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),"",dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("about").getValue().toString()));
                        wAdapter.notifyDataSetChanged();
                    }
                    if (dataSnapshot.getKey().equals("workshop_5")){
                        guestLectures.add(new GuestLecture(dataSnapshot.child("lecture_name").getValue().toString(),"",dataSnapshot.child("date").getValue().toString(),dataSnapshot.child("time").getValue().toString(),dataSnapshot.child("about").getValue().toString()));
                        wAdapter.notifyDataSetChanged();
                    }llProgress.setVisibility(View.GONE);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getKey().toString().equals("workshop_1")){
                            guestLectures.remove(0);
                            wAdapter.notifyDataSetChanged();
                        }
                    if(dataSnapshot.getKey().toString().equals("workshop_2")){
                        guestLectures.remove(1);
                        wAdapter.notifyDataSetChanged();
                    }
                    if(dataSnapshot.getKey().toString().equals("workshop_3")){
                        guestLectures.remove(2);
                        wAdapter.notifyDataSetChanged();
                    }
                    if(dataSnapshot.getKey().toString().equals("workshop_4")){
                        guestLectures.remove(3);
                        wAdapter.notifyDataSetChanged();
                    }
                    if(dataSnapshot.getKey().toString().equals("workshop_5")){
                        guestLectures.remove(4);
                        wAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }
    }

    private void showProgress(String s) {
        ((TextView) llProgress.findViewById(R.id.tvMessage)).setText(s);
        llProgress.setVisibility(View.VISIBLE);
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