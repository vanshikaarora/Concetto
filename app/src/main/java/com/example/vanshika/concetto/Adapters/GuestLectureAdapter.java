package com.example.vanshika.concetto.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.Models.GuestLecture;
import com.example.vanshika.concetto.R;

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
        View view = inflater.inflate(R.layout.events_recycler_view_item, null);
        return new GuestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {
        GuestLecture guestLecture=lectureList.get(position);

        holder.imageView.setImageURI(Uri.parse(guestLecture.getImage()));
        holder.textViewTitle.setText(guestLecture.getLectureName()+" by "+guestLecture.getGuestName());
        holder.textViewTime.setText(guestLecture.getTime());

    }

    @Override
    public int getItemCount() {
        return lectureList.size();
    }

    public class GuestViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDate, textViewTime;
        ImageView imageView;
        public GuestViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.events_image);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(mCtx)
                            .setTitle("About")
                            .setMessage("Note that nuking planet Jupiter will destroy everything in there.")
                            .setPositiveButton("Nuke", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Log.d("MainActivity", "Sending atomic bombs to Jupiter");
                                }
                            }).show();
                }
            });
        }
    }
}
