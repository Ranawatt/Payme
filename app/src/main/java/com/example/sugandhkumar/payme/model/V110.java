
package com.example.sugandhkumar.payme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class V110 {

    @SerializedName("resourceName")
    @Expose
    private String resourceName;
    @SerializedName("delete")
    @Expose
    private Object delete;
    @SerializedName("post")
    @Expose
    private Object post;
    @SerializedName("put")
    @Expose
    private Object put;
    @SerializedName("get")
    @Expose
    private String get;
    @SerializedName("deltaGet")
    @Expose
    private String deltaGet;
    @SerializedName("top")
    @Expose
    private String top;

    /**
     * No args constructor for use in serialization
     * 
     */
    public V110() {
    }

    /**
     * 
     * @param put
     * @param post
     * @param deltaGet
     * @param get
     * @param delete
     * @param resourceName
     * @param top
     */
    public V110(String resourceName, Object delete, Object post, Object put, String get, String deltaGet, String top) {
        super();
        this.resourceName = resourceName;
        this.delete = delete;
        this.post = post;
        this.put = put;
        this.get = get;
        this.deltaGet = deltaGet;
        this.top = top;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Object getDelete() {
        return delete;
    }

    public void setDelete(Object delete) {
        this.delete = delete;
    }

    public Object getPost() {
        return post;
    }

    public void setPost(Object post) {
        this.post = post;
    }

    public Object getPut() {
        return put;
    }

    public void setPut(Object put) {
        this.put = put;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String getDeltaGet() {
        return deltaGet;
    }

    public void setDeltaGet(String deltaGet) {
        this.deltaGet = deltaGet;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this).append("resourceName", resourceName).append("delete", delete).append("post", post).append("put", put).append("get", get).append("deltaGet", deltaGet).append("top", top).toString();
//    }

}
