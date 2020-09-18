
package com.example.sugandhkumar.payme.model.flipkartinfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductAttributes {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("productDescription")
    @Expose
    private String productDescription;
    @SerializedName("imageUrls")
    @Expose
    private ImageUrls imageUrls;
    @SerializedName("maximumRetailPrice")
    @Expose
    private MaximumRetailPrice maximumRetailPrice;
    @SerializedName("sellingPrice")
    @Expose
    private SellingPrice sellingPrice;
    @SerializedName("productUrl")
    @Expose
    private String productUrl;
    @SerializedName("productBrand")
    @Expose
    private String productBrand;
    @SerializedName("inStock")
    @Expose
    private Boolean inStock;
    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("codAvailable")
    @Expose
    private Boolean codAvailable;
    @SerializedName("emiAvailable")
    @Expose
    private Object emiAvailable;
    @SerializedName("discountPercentage")
    @Expose
    private Double discountPercentage;
    @SerializedName("cashBack")
    @Expose
    private Object cashBack;
    @SerializedName("offers")
    @Expose
    private List<Object> offers = null;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("sizeUnit")
    @Expose
    private String sizeUnit;
    @SerializedName("sizeVariants")
    @Expose
    private String sizeVariants;
    @SerializedName("colorVariants")
    @Expose
    private String colorVariants;
    @SerializedName("styleCode")
    @Expose
    private Object styleCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ImageUrls getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ImageUrls imageUrls) {
        this.imageUrls = imageUrls;
    }

    public MaximumRetailPrice getMaximumRetailPrice() {
        return maximumRetailPrice;
    }

    public void setMaximumRetailPrice(MaximumRetailPrice maximumRetailPrice) {
        this.maximumRetailPrice = maximumRetailPrice;
    }

    public SellingPrice getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(SellingPrice sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Boolean getCodAvailable() {
        return codAvailable;
    }

    public void setCodAvailable(Boolean codAvailable) {
        this.codAvailable = codAvailable;
    }

    public Object getEmiAvailable() {
        return emiAvailable;
    }

    public void setEmiAvailable(Object emiAvailable) {
        this.emiAvailable = emiAvailable;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Object getCashBack() {
        return cashBack;
    }

    public void setCashBack(Object cashBack) {
        this.cashBack = cashBack;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public String getSizeVariants() {
        return sizeVariants;
    }

    public void setSizeVariants(String sizeVariants) {
        this.sizeVariants = sizeVariants;
    }

    public String getColorVariants() {
        return colorVariants;
    }

    public void setColorVariants(String colorVariants) {
        this.colorVariants = colorVariants;
    }

    public Object getStyleCode() {
        return styleCode;
    }

    public void setStyleCode(Object styleCode) {
        this.styleCode = styleCode;
    }

}
