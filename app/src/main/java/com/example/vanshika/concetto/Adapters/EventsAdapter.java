package com.example.vanshika.concetto.Adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.provider.CalendarContract;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.Models.Event;
import com.example.vanshika.concetto.R;

import java.util.List;

/**
 * Created by Shridhar on 27-Sep-18.
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
        public void onBindViewHolder(EventsViewHolder holder, int position) {
            //getting the product of the specified position
            Event event = eventsList.get(position);

            //binding the data with the viewholder views
            holder.textViewTitle.setText(event.getName());
            holder.textViewDate.setText(event.getDate());
            holder.textViewTime.setText(String.valueOf(event.getTime()));

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

                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewDate = itemView.findViewById(R.id.textViewDate);
                textViewTime = itemView.findViewById(R.id.textViewTime);
            }
        }

    }

