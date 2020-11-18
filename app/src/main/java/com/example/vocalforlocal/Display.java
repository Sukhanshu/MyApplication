package com.example.vocalforlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Display extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ArrayList<Exampleitem> exampleitems= new ArrayList<>();
        exampleitems.add(new Exampleitem(R.drawable.ic_android, "Line 1", "Line2"));
        exampleitems.add(new Exampleitem(R.drawable.ic_bluetooth, "Line 3", "Line4"));


        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new GridProductLayoutAdapter(exampleitems);

        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);




    }
}