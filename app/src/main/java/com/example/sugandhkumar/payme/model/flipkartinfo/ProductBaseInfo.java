
package com.example.sugandhkumar.payme.model.flipkartinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductBaseInfo {

    @SerializedName("productIdentifier")
    @Expose
    private ProductIdentifier productIdentifier;
    @SerializedName("productAttributes")
    @Expose
    private ProductAttributes productAttributes;

    public ProductIdentifier getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(ProductIdentifier productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public ProductAttributes getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(ProductAttributes productAttributes) {
        this.productAttributes = productAttributes;
    }

}
