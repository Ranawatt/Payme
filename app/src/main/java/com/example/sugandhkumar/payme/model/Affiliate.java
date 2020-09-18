
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Affiliate {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("apiListings")
    @Expose
    private ApiListings apiListings;

    public Affiliate() {
    }

    /**
     * 
     * @param name
     * @param apiListings
     */
    public Affiliate(String name, ApiListings apiListings) {
        super();
        this.name = name;
        this.apiListings = apiListings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApiListings getApiListings() {
        return apiListings;
    }

    public void setApiListings(ApiListings apiListings) {
        this.apiListings = apiListings;
    }



}
