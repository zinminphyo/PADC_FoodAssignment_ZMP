package com.padcmyanmar.padc_foodassignment_zmp.network;

import android.telecom.Call;

import com.padcmyanmar.padc_foodassignment_zmp.network.responses.GetWarDeeListResponses;
import com.padcmyanmar.padc_foodassignment_zmp.utils.WarDeeListConstants;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface WarDeeApi {

    @FormUrlEncoded
    @POST(WarDeeListConstants.GET_WARDEE)
    retrofit2.Call<GetWarDeeListResponses> loadWarDee(
            @Field(WarDeeListConstants.PARAM_ACCESS_TOKEN) String accessToken
    );
}
