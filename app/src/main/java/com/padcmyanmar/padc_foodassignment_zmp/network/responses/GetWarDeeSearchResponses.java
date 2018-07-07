package com.padcmyanmar.padc_foodassignment_zmp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;

import java.util.List;

public class GetWarDeeSearchResponses {

    @SerializedName("code")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("tasteType")
    private String tasteType;

    @SerializedName("suited")
    private String suited;

    @SerializedName("minPrice")
    private String minPrice;

    @SerializedName("maxPrice")
    private String maxprice;

    @SerializedName("isNearBy")
    private String isNearBy;

    @SerializedName("currentTownship")
    private String currentTownShip;

    @SerializedName("currentTLat")
    private String currentTLat;

    @SerializedName("currentLng")
    private String currentLng;

    @SerializedName("searchResults")
    private List<WarDeeVO> searchLists;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getTasteType() {
        return tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public String getMaxprice() {
        return maxprice;
    }

    public String getIsNearBy() {
        return isNearBy;
    }

    public String getCurrentTownShip() {
        return currentTownShip;
    }

    public String getCurrentTLat() {
        return currentTLat;
    }

    public String getCurrentLng() {
        return currentLng;
    }

    public List<WarDeeVO> getSearchLists() {
        return searchLists;
    }
}
