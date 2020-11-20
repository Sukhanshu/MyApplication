package com.example.vocalforlocal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vocalforlocal.categories.DigiArt;
import com.example.vocalforlocal.categories.HomeDecor;
import com.example.vocalforlocal.categories.Paintings;
import com.example.vocalforlocal.categories.Sketches;

public class Categories extends AppCompatActivity implements View.OnClickListener {

    private Button btnPaintings, btnSketches, btnDigiArt, btnHomeDecor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDigiArt:
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