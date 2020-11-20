package com.example.vocalforlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.vocalforlocal.db.TinyDb;
import com.example.vocalforlocal.models.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private TextView headerCartTextView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        headerCartTextView = findViewById(R.id.headerCardText);
        mRecyclerView = findViewById(R.id.cartRv);
        TinyDb tinyDB = new TinyDb(getApplicationContext());
        ArrayList<Product> products = tinyDB.getListProducts("cart_products", Product.class);
        String totalPrice = getTotalPrice(products);
        headerCartTextView.setText("Total Price: " + totalPrice);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new CartProductAdapter(products);
        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private String getTotalPrice(ArrayList<Product> products) {

        int total=0;
        for (Product product : products) {
            total = total + Integer.parseInt(product.getProductPrice());
        }

        return String.valueOf(total);
    }
}