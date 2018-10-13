package com.example.vanshika.concetto.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.Models.GuestLecture;
import com.example.vanshika.concetto.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class GuestLectureAdapter  extends RecyclerView.Adapter<GuestLectureAdapter.GuestViewHolder>{
    private Context mCtx;
    private List<GuestLecture> lectureList;

    public GuestLectureAdapter(Context mCtx, List<GuestLecture> lectureList) {
        this.mCtx = mCtx;
        this.lectureList = lectureList;
    }

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_view, null);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        final GuestLecture guestLecture=lectureList.get(position);

        holder.textViewDate.setText(guestLecture.getDate());
        holder.textViewTitle.setText(guestLecture.getLecture_name());
        holder.textViewTime.setText(guestLecture.getTime());
        holder.cardViewObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                Query query = reference.child("GuestLectures");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(guestLecture.getAbout())){
                            String message=dataSnapshot.child(guestLecture.getAbout()).child("about").getValue().toString();
                            AlertDialog.Builder builder=new AlertDialog.Builder(mCtx)
                                    .setTitle("About")
                                    .setMessage(message)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Log.d("MainActivity", "Sending atomic bombs to Jupiter");
                                        }
                                    });
                            AlertDialog dialog = builder.create();
                            dialog.getWindow().getAttributes().windowAnimations=R.anim.activity_open_translate;
                            dialog.show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {
        return lectureList.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDate, textViewTime;
        ImageView imageView;
        CardView cardViewObject;
        public GuestViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.events_image);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            cardViewObject=itemView.findViewById(R.id.eventsCardView);

        }
    }
}
