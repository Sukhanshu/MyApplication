package com.example.vocalforlocal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vocalforlocal.db.TinyDb;
import com.example.vocalforlocal.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private static final String TAG = "ProductAdapter";
    private ArrayList<Product> productArrayList;
    public TinyDb tinyDb;
    public boolean flag=false;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView productName;
        public TextView productPrice;
        public ImageButton btnAddToCart;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.txtProductName);
            productPrice = itemView.findViewById(R.id.txtProductPrice);
            btnAddToCart = itemView.findViewById(R.id.addToCartImg);

        }
    }

    public ProductAdapter(ArrayList<Product> productList, TinyDb tinyDb) {
        productArrayList = productList;
        this.tinyDb = tinyDb;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Product currentItem = productArrayList.get(position);
        final Context context = holder.btnAddToCart.getContext();


        holder.mImageView.setImageResource(currentItem.getproductImage());
        holder.productName.setText(currentItem.getProductName());
        holder.productPrice.setText(currentItem.getProductPrice());
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switches Icon
                flag = !flag;
                toggleBtnDrawable(holder, context, currentItem, flag);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }


    void toggleBtnDrawable(ProductViewHolder holder, Context context, Product product, boolean flag){
        if(flag){
            holder.btnAddToCart.setImageDrawable(context.getDrawable(R.drawable.ic_done));
            ArrayList<Product> products = tinyDb.getListProducts("cart_products",Product.class);
            if(!products.contains(product)) products.add(product);
            Log.d(TAG +" if",products.toString());
            tinyDb.putListObject("cart_products",products);
        }

        else {
            holder.btnAddToCart.setImageDrawable(context.getDrawable(R.drawable.ic_add_shopping_cart));
            ArrayList<Product> products = tinyDb.getListProducts("cart_products",Product.class);
            products.remove(product);
            Log.d(TAG + " else",products.toString());
            tinyDb.putListObject("cart_products",products);
        }

    }
}
