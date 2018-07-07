package com.padcmyanmar.padc_foodassignment_zmp.events;

import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;

import java.util.List;

public class SuccessGetWarDeeEvent {

    private List<WarDeeVO> warDeeLists;

    public SuccessGetWarDeeEvent(List<WarDeeVO> warDeeLists) {
        this.warDeeLists = warDeeLists;
    }

    public List<WarDeeVO> getWarDeeLists() {
        return warDeeLists;
    }
}
