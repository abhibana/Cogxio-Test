package com.cogxio.android.test.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Abhishek on 28/11/15.
 */
public class SnowyResult {

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("colour")
    private String colour;

    @SerializedName("size")
    private String size;

    @SerializedName("price")
    private String price;

    @SerializedName("name")
    private String productLink;

    @SerializedName("description")
    private String description;

    @SerializedName("image/_source")
    private String imageSource;

    @SerializedName("name/_text")
    private String name;

    @SerializedName("name/_source")
    private String nameSource;

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getColour() { return colour; }

    public void setColour(String colour) { this.colour = colour; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public String getProductLink() { return productLink; }

    public void setProductLink(String productLink) { this.productLink = productLink; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImageSource() { return imageSource; }

    public void setImageSource(String imageSource) { this.imageSource = imageSource; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNameSource() { return nameSource; }

    public void setNameSource(String nameSource) { this.nameSource = nameSource; }
}
