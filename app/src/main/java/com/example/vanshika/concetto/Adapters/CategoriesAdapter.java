package com.example.vanshika.concetto.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vanshika.concetto.CategoriesActivity;
import com.example.vanshika.concetto.EventsActivity;
import com.example.vanshika.concetto.Models.Category;
import com.example.vanshika.concetto.Models.Event;
import com.example.vanshika.concetto.R;

import java.util.List;

/**
 * Created by Shridhar on 28-Sep-18.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Category> categoriesList;

    //getting the context and product list with constructor
    public CategoriesAdapter(Context mCtx, List<Category> categoriesList) {
        this.mCtx = mCtx;
        this.categoriesList = categoriesList;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.categories_recycler_view_item, null);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CategoriesAdapter.CategoriesViewHolder holder, final int position) {
        //getting the product of the specified position
        Category category = categoriesList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(category.getTitle());
        holder.imageView.setImageURI(Uri.parse(category.getImage()));

        Log.d("CategoriesAdapter", "onBindViewHolder: "+Uri.parse(category.getImage()));
    }


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }


    class CategoriesViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle ;
        ImageView imageView;

        public CategoriesViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.category_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mCtx, EventsActivity.class);
                    intent.putExtra("Position", String.valueOf(getAdapterPosition()));
                    mCtx.startActivity(intent);
                }
            });
        }
    }
}
