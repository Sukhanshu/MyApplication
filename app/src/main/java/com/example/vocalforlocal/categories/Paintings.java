package com.example.vocalforlocal.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocalforlocal.Cart;
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
    private Button goToCartBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintings);
        goToCartBtn = findViewById(R.id.goToCartBtn);
        ArrayList<Product> paintingProducts = new ArrayList<>();
        tinyDb = new TinyDb(getApplicationContext());
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 1", "45","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 2", "55","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 3", "65","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 4", "75","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 5", "65","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 6", "75","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_android, "Painting Product 7", "65","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));
        paintingProducts.add(new Product(R.drawable.ic_bluetooth, "Painting Product 8", "75","Random Artist", "Lorem Ipsum Dior Random Text Goes Here Product Info Goes Here"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(paintingProducts,tinyDb);

        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        goToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Cart.class));
            }
        });
    }
}
