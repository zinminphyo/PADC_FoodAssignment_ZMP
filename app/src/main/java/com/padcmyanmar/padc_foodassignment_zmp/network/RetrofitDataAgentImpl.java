package com.padcmyanmar.padc_foodassignment_zmp.network;

import com.padcmyanmar.padc_foodassignment_zmp.events.ApiErrorEvent;
import com.padcmyanmar.padc_foodassignment_zmp.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.padc_foodassignment_zmp.network.responses.GetWarDeeListResponses;
import com.padcmyanmar.padc_foodassignment_zmp.utils.WarDeeListConstants;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements WarDeeListDataAgent {

    private static RetrofitDataAgentImpl sObjInstance;
    private WarDeeApi mTheApi;

    private RetrofitDataAgentImpl() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WarDeeListConstants.WARDEE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mTheApi = retrofit.create(WarDeeApi.class);
    }

    public static RetrofitDataAgentImpl getsObjInstance() {

        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgentImpl();
        }
        return sObjInstance;
    }

    @Override
    public void loadWarDeeLists(String accessToken) {
        Call<GetWarDeeListResponses> responses = mTheApi.loadWarDee(accessToken);
        responses.enqueue(new Callback<GetWarDeeListResponses>() {
            @Override
            public void onResponse(Call<GetWarDeeListResponses> call, Response<GetWarDeeListResponses> response) {
                GetWarDeeListResponses wardeResponse = response.body();
                if (wardeResponse != null && wardeResponse.isResponseOk()) {
                    SuccessGetWarDeeEvent event = new SuccessGetWarDeeEvent(wardeResponse.getWarDeeLists());
                    EventBus.getDefault().post(event);
                } else {
                    if (wardeResponse == null) {
                        ApiErrorEvent event = new ApiErrorEvent("Empty responses in network call");
                        EventBus.getDefault().post(event);
                    } else {
                        ApiErrorEvent event = new ApiErrorEvent(wardeResponse.getMessage());
                        EventBus.getDefault().post(event);
                    }
                }
            }

            @Override
            public void onFailure(Call<GetWarDeeListResponses> call, Throwable t) {

                ApiErrorEvent event = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });
    }
}
