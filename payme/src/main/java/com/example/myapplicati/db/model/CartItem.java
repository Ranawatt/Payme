package com.example.myapplicati.db.model;

import com.example.myapplicati.networking.model.Product;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CartItem extends RealmObject {
    @PrimaryKey
    public String id = UUID.randomUUID().toString();
    public Product product;
    public int quantity = 0;
}
