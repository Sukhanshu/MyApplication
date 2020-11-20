package com.example.vocalforlocal.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.example.vocalforlocal.models.Product;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class TinyDb {

    private SharedPreferences sharedPreferences;

    public TinyDb(Context appContext) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    private void checkForNullKey(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
    }

    public ArrayList<String> getListString(String key) {
        return new ArrayList<>(Arrays.asList(TextUtils.split(sharedPreferences.getString(key, ""), "‚‗‚")));
    }

    public ArrayList<Product> getListProducts(String key, Class<?> mClass) {
        Gson gson = new Gson();
        ArrayList<String> objStrings = getListString(key);
        ArrayList<Product> objects = new ArrayList<>();

        for (String jObjString : objStrings) {
            Product value = (Product) gson.fromJson(jObjString, mClass);
            objects.add(value);
        }
        return objects;
    }

    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        sharedPreferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    public void putListObject(String key, ArrayList<Product> objArray) {
        checkForNullKey(key);
        Gson gson = new Gson();
        ArrayList<String> objStrings = new ArrayList<String>();
        for (Object obj : objArray) {
            objStrings.add(gson.toJson(obj));
        }
        putListString(key, objStrings);
    }

}
