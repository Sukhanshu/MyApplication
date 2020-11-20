package com.example.vocalforlocal.categories;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocalforlocal.ProductAdapter;
import com.example.vocalforlocal.R;
import com.example.vocalforlocal.db.TinyDb;
import com.example.vocalforlocal.models.Product;

import java.util.ArrayList;

public class Sketches extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    private TinyDb tinyDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sketches);
        ArrayList<Product> sketchProducts = new ArrayList<>();
        tinyDb = new TinyDb(getApplicationContext());
        sketchProducts.add(new Product(R.drawable.ic_android, "Home Decor Product 1", "Rs 45"));
        sketchProducts.add(new Product(R.drawable.ic_bluetooth, "Home Decor Product 2", "Rs 55"));
        sketchProducts.add(new Product(R.drawable.ic_android, "Home Decor Product 3", "Rs 65"));
        sketchProducts.add(new Product(R.drawable.ic_bluetooth, "Home Decor Product 4", "Rs 75"));
        sketchProducts.add(new Product(R.drawable.ic_android, "Home Decor Product 5", "Rs 65"));
        sketchProducts.add(new Product(R.drawable.ic_bluetooth, "Home Decor Product 6", "Rs 75"));
        sketchProducts.add(new Product(R.drawable.ic_android, "Home Decor Product 7", "Rs 65"));
        sketchProducts.add(new Product(R.drawable.ic_bluetooth, "Home Decor Product 8", "Rs 75"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(sketchProducts,tinyDb);

        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
    }
}
