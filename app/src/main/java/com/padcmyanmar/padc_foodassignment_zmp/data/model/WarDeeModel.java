package com.padcmyanmar.padc_foodassignment_zmp.data.model;

import android.util.Log;

import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;
import com.padcmyanmar.padc_foodassignment_zmp.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.padc_foodassignment_zmp.network.RetrofitDataAgentImpl;
import com.padcmyanmar.padc_foodassignment_zmp.network.WarDeeListDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class WarDeeModel {

    private static WarDeeModel objInstance;
    private WarDeeListDataAgent mWarDeeDataAgent;
    private Map<String, WarDeeVO> mWarDeeMap;

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private WarDeeModel() {

        mWarDeeDataAgent = RetrofitDataAgentImpl.getsObjInstance();

        mWarDeeMap = new HashMap<>();
        EventBus.getDefault().register(this);
    }

    public void loadWarDee() {
        mWarDeeDataAgent.loadWarDeeLists(DUMMY_ACCESS_TOKEN);
    }

    public static WarDeeModel getObjInstance() {

        if (objInstance == null) {
            objInstance = new WarDeeModel();
        }
        return objInstance;
    }

    public WarDeeVO getWarDeeById(String warDeeId) {
        return mWarDeeMap.get(warDeeId);
    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {

        for (WarDeeVO warDees : event.getWarDeeLists()) {
            mWarDeeMap.put(warDees.getWarDeeId(), warDees);
        }


    }


}
