package com.perul.vanshika.concetto.Adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.perul.vanshika.concetto.Models.GuestLecture;
import com.perul.vanshika.concetto.R;

import java.util.List;

public class WorkshopAdapter  extends RecyclerView.Adapter <WorkshopAdapter.WorkshopViewHolder>{
    private Context context;
    private List<GuestLecture> workshopList;

    public WorkshopAdapter(Context context, List<GuestLecture> workshopList) {
        this.context = context;
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public WorkshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, null);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {
        GuestLecture guestLecture=workshopList.get(position);

        holder.textViewDate.setText(guestLecture.getDate());
        holder.textViewTime.setText(guestLecture.getTime());
        holder.textViewTitle.setText(guestLecture.getLecture_name());
        final String url=guestLecture.getAbout();
        holder.cardViewObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(url);
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.google.android.apps.docs");

                try {
                    context.startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse(url)));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (workshopList!=null)
        return workshopList.size();
        else return 0;
    }

    public class WorkshopViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewDate, textViewTime;
        ImageView imageView;
        CardView cardViewObject;
        public WorkshopViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.events_image);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            cardViewObject=itemView.findViewById(R.id.eventsCardView);
        }
    }
}
