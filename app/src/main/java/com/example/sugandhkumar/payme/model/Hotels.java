package com.example.sugandhkumar.payme.model;

/**
 * Created by sugandh kumar on 31-08-2017.
 */

public class Hotels {
    public String hName;
    public String url;
    public String cost;
    public String hRemarks;
    public String hDistance;
    public String hRatingPoint;

    public Hotels() {
    }

    public Hotels(String url) {
        this.url = url;
    }

    public Hotels(String hName, String url, String cost) {
        this.hName = hName;
        this.url = url;
        this.cost = cost;
    }

    public Hotels(String hName, String url, String cost, String hRemarks, String hDistance, String hRatingPoint) {
        this.hName = hName;
        this.url = url;
        this.cost = cost;
        this.hRemarks = hRemarks;
        this.hDistance = hDistance;
        this.hRatingPoint = hRatingPoint;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String gethRemarks() {
        return hRemarks;
    }

    public void sethRemarks(String hRemarks) {
        this.hRemarks = hRemarks;
    }

    public String gethDistance() {
        return hDistance;
    }

    public void sethDistance(String hDistance) {
        this.hDistance = hDistance;
    }

    public String gethRatingPoint() {
        return hRatingPoint;
    }

    public void sethRatingPoint(String hRatingPoint) {
        this.hRatingPoint = hRatingPoint;
    }

}
