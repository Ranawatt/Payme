
package com.example.sugandhkumar.payme.model.flipkartinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductShippingBaseInfo {

    @SerializedName("shippingOptions")
    @Expose
    private Object shippingOptions;

    public Object getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(Object shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

}
