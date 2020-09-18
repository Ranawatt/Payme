
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiGroups {

    @SerializedName("affiliate")
    @Expose
    private Affiliate affiliate;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ApiGroups() {
    }

    /**
     * 
     * @param affiliate
     */
    public ApiGroups(Affiliate affiliate) {
        super();
        this.affiliate = affiliate;
    }

    public Affiliate getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(Affiliate affiliate) {
        this.affiliate = affiliate;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("affiliate", affiliate).toString();
//    }

}
