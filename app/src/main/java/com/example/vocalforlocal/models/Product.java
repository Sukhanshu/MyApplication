package com.example.vocalforlocal.models;

public class Product {
    private int mImageresource;
    private String mText1;
    private String mtext2;

    public Product(int imageResource, String text1, String text2){
        mImageresource= imageResource;
        mText1= text1;
        mtext2= text2;
    }

    public int getmImageresource(){
        return mImageresource;
    }

    public String getmText1(){
        return mText1;
    }

    public String getMtext2(){
        return mtext2;
    }
}
