package com.example.myapplicati.db.model;

import com.example.myapplicati.networking.model.Order;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Transaction extends RealmObject {

    @PrimaryKey
    int id;
//    public Order order;
//    public String created_at;
}
