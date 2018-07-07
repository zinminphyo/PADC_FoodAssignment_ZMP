package com.padcmyanmar.padc_foodassignment_zmp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealShopVO {

    @SerializedName("shopId")
    private String shopId;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    @SerializedName("township")
    private String townShip;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("shopImages")
    private List<String> shopImages;

    @SerializedName("reviews")
    private List<ReviewVO> reviewLists;

    public String getShopId() {
        return shopId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getTownShip() {
        return townShip;
    }

    public String getPopularity() {
        return popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public List<ReviewVO> getReviewLists() {
        return reviewLists;
    }
}
