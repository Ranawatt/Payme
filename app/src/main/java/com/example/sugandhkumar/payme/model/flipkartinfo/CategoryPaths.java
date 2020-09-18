
package com.example.sugandhkumar.payme.model.flipkartinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryPaths {

    @SerializedName("categoryPath")
    @Expose
    private List<List<CategoryPath>> categoryPath = null;

    public List<List<CategoryPath>> getCategoryPath() {
        return categoryPath;
    }

    public void setCategoryPath(List<List<CategoryPath>> categoryPath) {
        this.categoryPath = categoryPath;
    }

}
