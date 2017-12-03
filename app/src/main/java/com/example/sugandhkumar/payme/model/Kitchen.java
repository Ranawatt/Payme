package com.example.sugandhkumar.payme.model;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class Kitchen {
    public String kName;
    public String kCost;
    public String kUrl;
    public String kRating;

    public Kitchen() {
    }

    public Kitchen(String kName) {
        this.kName = kName;
    }

    public Kitchen(String kName, String kUrl) {
        this.kName = kName;
        this.kUrl = kUrl;
    }

    public Kitchen(String kName, String kCost, String kUrl) {
        this.kName = kName;
        this.kCost = kCost;
        this.kUrl = kUrl;
    }

    public Kitchen(String kName, String kCost, String kUrl, String kRating) {
        this.kName = kName;
        this.kCost = kCost;
        this.kUrl = kUrl;
        this.kRating = kRating;
    }

    public String getkName() {
        return kName;
    }

    public void setkName(String kName) {
        this.kName = kName;
    }

    public String getkCost() {
        return kCost;
    }

    public void setkCost(String kCost) {
        this.kCost = kCost;
    }

    public String getkUrl() {
        return kUrl;
    }

    public void setkUrl(String kUrl) {
        this.kUrl = kUrl;
    }

    public String getkRating() {
        return kRating;
    }

    public void setkRating(String kRating) {
        this.kRating = kRating;
    }
}
