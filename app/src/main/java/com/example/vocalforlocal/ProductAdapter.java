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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> productArrayList;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView productName;
        public TextView productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.txtProductName);
            productPrice = itemView.findViewById(R.id.txtProductPrice);
        }
    }

    public ProductAdapter(ArrayList<Product> productList) {
        productArrayList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentItem = productArrayList.get(position);

        holder.mImageView.setImageResource(currentItem.getproductImage());
        holder.productName.setText(currentItem.getProductName());
        holder.productPrice.setText(currentItem.getProductPrice());

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
