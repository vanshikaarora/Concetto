package com.example.vanshika.concetto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.vanshika.concetto.Adapters.CategoriesAdapter;
import com.example.vanshika.concetto.Adapters.EventsAdapter;
import com.example.vanshika.concetto.Models.Category;
import com.example.vanshika.concetto.Models.Event;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends MainActivity {

    private RecyclerView recyclerView;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        super.replaceContentLayout(R.layout.activity_categories, R.id.content_main_linear_layout);

        getSupportActionBar().hide();

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.categories_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        categoryList = new ArrayList<>();


        //adding some items to our list
        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.mipmap.ic_launcher, "Category A"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.mipmap.ic_launcher, "Category B"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.mipmap.ic_launcher, "Category C"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.mipmap.ic_launcher, "Category D"));

        //creating recyclerview adapter
        CategoriesAdapter adapter = new CategoriesAdapter(this, categoryList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
