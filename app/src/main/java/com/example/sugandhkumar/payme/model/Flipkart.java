
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Flipkart {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("apiGroups")
    @Expose
    private ApiGroups apiGroups;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Flipkart() {
    }

    /**
     * 
     * @param apiGroups
     * @param title
     * @param description
     */
    public Flipkart(String title, String description, ApiGroups apiGroups) {
        super();
        this.title = title;
        this.description = description;
        this.apiGroups = apiGroups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApiGroups getApiGroups() {
        return apiGroups;
    }

    public void setApiGroups(ApiGroups apiGroups) {
        this.apiGroups = apiGroups;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("title", title).append("description", description).append("apiGroups", apiGroups).toString();
//    }

}
