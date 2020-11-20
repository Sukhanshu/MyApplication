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

public class Paintings extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    private TinyDb tinyDb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintings);
        ArrayList<Product> paintingProducts = new ArrayList<>();
        tinyDb = new TinyDb(getApplicationContext());
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 1", "Rs 45"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 2", "Rs 55"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 3", "Rs 65"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 4", "Rs 75"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 5", "Rs 65"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 6", "Rs 75"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 7", "Rs 65"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 8", "Rs 75"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(paintingProducts,tinyDb);

        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
    }
}
