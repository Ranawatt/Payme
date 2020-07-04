package com.example.myapplicati.networking.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Product extends RealmObject {
    @PrimaryKey
    public long id;
    public String name;
    public float price;
    @SerializedName("image")
    public String imageUrl;

}
