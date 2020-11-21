package com.example.vocalforlocal.models;

import java.util.Objects;

public class Product {
    private int productImg;
    private String productName;
    private String productPrice;
    private String artistName;
    private String productInfo;

    public Product(int imageResource, String name, String price, String artistName, String productInfo){
        productImg = imageResource;
        productName = name;
        productPrice = price;
        this.artistName = artistName;
        this.productInfo=productInfo;
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

    public String getArtistName() {
        return artistName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productImg == product.productImg &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productImg, productName, productPrice);
    }
}
