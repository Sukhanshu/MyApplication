package com.example.vocalforlocal.models;

public class Product {
    private int productImg;
    private String productName;
    private String productPrice;

    public Product(int imageResource, String name, String price){
        productImg = imageResource;
        productName = name;
        productPrice = price;
    }

    public int getproductImage(){
        return productImg;
    }

    public String getProductName(){
        return productName;
    }

    public String getProductPrice(){
        return productPrice;
    }
}
