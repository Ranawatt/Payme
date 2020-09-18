package com.example.sugandhkumar.payme.model;

import com.example.sugandhkumar.payme.model.flipkartinfo.ProductInfoList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sugandh kumar on 15-02-2018.
 */

public class FlipkartProducts {
    @SerializedName("nextUrl")
    @Expose
    private String nextUrl;
    @SerializedName("validTill")
    @Expose
    private Long validTill;
    @SerializedName("products")
    @Expose
    private ArrayList<ProductInfoList> productInfoList = new ArrayList<>();
    @SerializedName("lastProductId")
    @Expose
    private String lastProductId;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public Long getValidTill() {
        return validTill;
    }

    public void setValidTill(Long validTill) {
        this.validTill = validTill;
    }

    public ArrayList<ProductInfoList> getProductInfoList() {
        return productInfoList;
    }

    public void setProductInfoList(ArrayList<ProductInfoList> productInfoList) {
        this.productInfoList = (ArrayList<ProductInfoList>) productInfoList;
    }

    public String getLastProductId() {
        return lastProductId;
    }

    public void setLastProductId(String lastProductId) {
        this.lastProductId = lastProductId;
    }

}
