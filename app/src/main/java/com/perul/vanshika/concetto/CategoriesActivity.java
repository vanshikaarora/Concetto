package com.perul.vanshika.concetto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.perul.vanshika.concetto.Adapters.CategoriesAdapter;
import com.perul.vanshika.concetto.Adapters.EventsAdapter;
import com.perul.vanshika.concetto.Models.Category;
import com.perul.vanshika.concetto.Models.Event;

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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        //initializing the productlist
        categoryList = new ArrayList<>();


        //adding some items to our list
        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.fifaic, "Informal"));
        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.exhibition, "OVERNIGHT EVENT"));
        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.thebigbangquiz, "QUIZ"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.robo, "Robotics"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.maths, "Applied Mathematics"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.cse, "Computer Science and Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.electronics, "Electronics Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.elec, "Electrical Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.mech, "Mechanical Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.civil, "Civil Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.mining, "Mining Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.manage, "Mining Machinery Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.petro, "Petroleum Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.mineral, "Fuel and Mineral Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.geology, "Applied Geology"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.geophysics, "Applied Geophysics"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.chem, "Chemical Engineering"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.physics, "Engineering Physics"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.manage, "Management Studies"));

        categoryList.add(
                new Category("android.resource://com.example.vanshika.concetto/" + R.drawable.enviro , "Environmental Engineering"));







        //creating recyclerview adapter
        CategoriesAdapter adapter = new CategoriesAdapter(this, categoryList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}































