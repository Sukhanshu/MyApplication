package com.example.vocalforlocal.categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vocalforlocal.R;
import com.example.vocalforlocal.categories.DigiArt;
import com.example.vocalforlocal.categories.HomeDecor;
import com.example.vocalforlocal.categories.Paintings;
import com.example.vocalforlocal.categories.Sketches;
import com.example.vocalforlocal.db.TinyDb;
import com.example.vocalforlocal.models.Product;

import java.util.ArrayList;

public class Categories extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Categories";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    @Override
    public void onClick(View v) {
        TinyDb tinyDb = new TinyDb(getApplication());
        ArrayList<Product> products = new ArrayList<>();
        tinyDb.putListObject("cart_products",products);
        switch (v.getId()){
            case R.id.btnDigiArt:
                Log.d(TAG,"Digital Art");
                startActivity(new Intent(this, DigiArt.class));
                break;
            case R.id.btnHomeDecor:
                startActivity(new Intent(this, HomeDecor.class));
                break;
            case R.id.btnPaintings:
                startActivity(new Intent(this, Paintings.class));
                break;
            case R.id.btnSketches:
                startActivity(new Intent(this, Sketches.class));
                break;
        }
    }
}