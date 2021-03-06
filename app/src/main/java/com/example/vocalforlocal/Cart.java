package com.example.vocalforlocal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vocalforlocal.db.TinyDb;
import com.example.vocalforlocal.models.Product;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private TextView headerCartTextView;
    private Button clearCart;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutmanager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        headerCartTextView = findViewById(R.id.headerCardText);
        mRecyclerView = findViewById(R.id.cartRv);
        clearCart = findViewById(R.id.clearCart);
        final TinyDb tinyDB = new TinyDb(getApplicationContext());
        ArrayList<Product> products = tinyDB.getListProducts("cart_products", Product.class);
        String totalPrice = getTotalPrice(products);
        headerCartTextView.setText("Total Price: " + totalPrice);
        mRecyclerView.setHasFixedSize(true);

        mlayoutmanager = new LinearLayoutManager(this);
        mAdapter = new CartProductAdapter(products);
        mRecyclerView.setLayoutManager(mlayoutmanager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        clearCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinyDB.putListObject("cart_products", new ArrayList<Product>());
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private String getTotalPrice(ArrayList<Product> products) {

        int total=0;
        for (Product product : products) {
            total = total + Integer.parseInt(product.getProductPrice());
        }

        return String.valueOf(total);
    }
}