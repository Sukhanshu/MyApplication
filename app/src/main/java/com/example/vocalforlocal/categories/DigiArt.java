package com.example.vocalforlocal.categories;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocalforlocal.ProductAdapter;
import com.example.vocalforlocal.R;
import com.example.vocalforlocal.models.Product;

import java.util.ArrayList;

public class DigiArt  extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digiart);
        ArrayList<Product> digiArtproducts = new ArrayList<>();
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 1", "Rs 45"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 2", "Rs 55"));
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 3", "Rs 65"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 4", "Rs 75"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(digiArtproducts);

        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
