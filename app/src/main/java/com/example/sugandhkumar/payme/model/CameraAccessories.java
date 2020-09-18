
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class CameraAccessories {

    @SerializedName("availableVariants")
    @Expose
    private AvailableVariants availableVariants;
    @SerializedName("apiName")
    @Expose
    private String apiName;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CameraAccessories() {
    }

    /**
     * 
     * @param availableVariants
     * @param apiName
     */
    public CameraAccessories(AvailableVariants availableVariants, String apiName) {
        super();
        this.availableVariants = availableVariants;
        this.apiName = apiName;
    }

    public AvailableVariants getAvailableVariants() {
        return availableVariants;
    }

    public void setAvailableVariants(AvailableVariants availableVariants) {
        this.availableVariants = availableVariants;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("availableVariants", availableVariants).append("apiName", apiName).toString();
//    }

}
