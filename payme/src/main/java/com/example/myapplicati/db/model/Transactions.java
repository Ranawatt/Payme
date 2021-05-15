package com.example.myapplicati.db.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Transactions extends RealmObject {

    @PrimaryKey
    int id;
    public Order order;
    public String created_at;
}
