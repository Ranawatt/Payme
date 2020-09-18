
package com.example.sugandhkumar.payme.model.flipkartinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductInfoList {

    @SerializedName("productBaseInfo")
    @Expose
    private ProductBaseInfo productBaseInfo;
    @SerializedName("productShippingBaseInfo")
    @Expose
    private ProductShippingBaseInfo productShippingBaseInfo;
    @SerializedName("offset")
    @Expose
    private Object offset;

    public ProductBaseInfo getProductBaseInfo() {
        return productBaseInfo;
    }

    public void setProductBaseInfo(ProductBaseInfo productBaseInfo) {
        this.productBaseInfo = productBaseInfo;
    }

    public ProductShippingBaseInfo getProductShippingBaseInfo() {
        return productShippingBaseInfo;
    }

    public void setProductShippingBaseInfo(ProductShippingBaseInfo productShippingBaseInfo) {
        this.productShippingBaseInfo = productShippingBaseInfo;
    }

    public Object getOffset() {
        return offset;
    }

    public void setOffset(Object offset) {
        this.offset = offset;
    }

}
