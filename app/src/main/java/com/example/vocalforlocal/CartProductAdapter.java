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

public class CartProductAdapter extends RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder> {

    private ArrayList<Product> cardProductArrayList;

    public CartProductAdapter(ArrayList<Product> cardProductArrayList) {
        this.cardProductArrayList = cardProductArrayList;
    }

    public class CartProductViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView productName;
        public TextView productPrice;

        public CartProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.txtProductName);
            productPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }

    @NonNull
    @Override
    public CartProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_product, parent,false);
        return new CartProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartProductViewHolder holder, int position) {
        Product currentProduct = cardProductArrayList.get(position);
        holder.mImageView.setImageResource(currentProduct.getproductImage());
        holder.productName.setText(currentProduct.getProductName());
        holder.productPrice.setText(currentProduct.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return cardProductArrayList.size();
    }




}

