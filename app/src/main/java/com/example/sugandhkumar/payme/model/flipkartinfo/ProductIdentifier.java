
package com.example.sugandhkumar.payme.model.flipkartinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductIdentifier {

    @SerializedName("productId")
    @Expose
    private String productId;
    @SerializedName("categoryPaths")
    @Expose
    private CategoryPaths categoryPaths;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public CategoryPaths getCategoryPaths() {
        return categoryPaths;
    }

    public void setCategoryPaths(CategoryPaths categoryPaths) {
        this.categoryPaths = categoryPaths;
    }

}
