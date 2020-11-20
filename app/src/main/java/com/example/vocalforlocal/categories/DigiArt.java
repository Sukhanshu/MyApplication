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

public class DigiArt  extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    private TinyDb tinyDb;
    private Button goToCartBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digiart);
        ArrayList<Product> digiArtproducts = new ArrayList<>();
        goToCartBtn = findViewById(R.id.goToCartBtn);
        tinyDb = new TinyDb(getApplicationContext());
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 1", "45"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 2", "55"));
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 3", "65"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 4", "75"));
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 5", "65"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 6", "75"));
        digiArtproducts.add(new Product(R.drawable.ic_android, "Digi Art Product 7", "65"));
        digiArtproducts.add(new Product(R.drawable.ic_bluetooth, "Digi Art Product 8", "75"));

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new ProductAdapter(digiArtproducts,tinyDb);

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
