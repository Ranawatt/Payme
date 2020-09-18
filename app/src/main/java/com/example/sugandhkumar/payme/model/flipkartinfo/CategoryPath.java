
package com.example.sugandhkumar.payme.model.flipkartinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryPath {

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
