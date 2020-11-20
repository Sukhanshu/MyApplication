package com.example.vocalforlocal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocalforlocal.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ExampleViewHolder> {
    private ArrayList<Product> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
         public ImageView mImageView;
         public TextView mTextView3;
         public TextView mTextView4;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            mTextView3= itemView.findViewById(R.id.textView6);
            mTextView4= itemView.findViewById(R.id.textView5);
        }
    }
    public ProductAdapter(ArrayList<Product> exampleList){
        mExampleList= exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(V);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        Product currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getmImageresource());
        holder.mTextView3.setText(currentItem.getmText1());
        holder.mTextView4.setText(currentItem.getMtext2());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
