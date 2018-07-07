package com.padcmyanmar.padc_foodassignment_zmp.events;

public class ApiErrorEvent {
    private String errorMsg;

    public ApiErrorEvent(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
