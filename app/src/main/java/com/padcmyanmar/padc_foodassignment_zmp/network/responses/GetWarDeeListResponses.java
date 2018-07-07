package com.padcmyanmar.padc_foodassignment_zmp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;

import java.util.List;

public class GetWarDeeListResponses {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("astlWarDee")
    private List<WarDeeVO> warDeeLists;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public List<WarDeeVO> getWarDeeLists() {
        return warDeeLists;
    }

    public boolean isResponseOk() {
        return (code == 200 && warDeeLists != null);
    }
}
