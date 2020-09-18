
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class AvailableVariants {

    @SerializedName("v0.1.0")
    @Expose
    private V010 v010;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AvailableVariants() {
    }

    /**
     * 
     * @param v010
     */
    public AvailableVariants(V010 v010) {
        super();
        this.v010 = v010;
    }

    public V010 getV010() {
        return v010;
    }

    public void setV010(V010 v010) {
        this.v010 = v010;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("v010", v010).toString();
//    }

}
