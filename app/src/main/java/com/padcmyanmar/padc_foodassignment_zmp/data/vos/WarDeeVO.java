package com.padcmyanmar.padc_foodassignment_zmp.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WarDeeVO {

    @SerializedName("warDeeId")
    private String warDeeId;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private List<String> images;

    @SerializedName("generalTaste")
    private List<GeneralTasteVO> generalTastes;

    @SerializedName("suitedFor")
    private List<SuitedForVO> suitedFors;

    @SerializedName("priceRangeMin")
    private int priceRangeMin;

    @SerializedName("priceRangeMax")
    private int priceRangeMax;

    @SerializedName("matchWarDeeList")
    private List<WarDeeVO> warDeeLists;

    @SerializedName("shopByDistance")
    private List<ShopByDistanceVO> shopByDistances;

    @SerializedName("shopByPopularity")
    private List<ShopByPopularityVO> shopByPopularityLists;

    public String getWarDeeId() {
        return warDeeId;
    }

    public String getName() {
        return name;
    }

    public List<String> getImages() {
        return images;
    }

    public List<GeneralTasteVO> getGeneralTastes() {
        return generalTastes;
    }

    public List<SuitedForVO> getSuitedFors() {
        return suitedFors;
    }

    public int getPriceRangeMin() {
        return priceRangeMin;
    }

    public int getPriceRangeMax() {
        return priceRangeMax;
    }

    public List<WarDeeVO> getWarDeeLists() {
        return warDeeLists;
    }

    public List<ShopByDistanceVO> getShopByDistances() {
        return shopByDistances;
    }

    public List<ShopByPopularityVO> getShopByPopularityLists() {
        return shopByPopularityLists;
    }
}
