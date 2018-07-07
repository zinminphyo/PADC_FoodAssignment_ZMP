package com.padcmyanmar.padc_foodassignment_zmp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;

public abstract class BaseWarDeeViewHolder extends RecyclerView.ViewHolder {

    public BaseWarDeeViewHolder(View itemView) {
        super(itemView);
    }

    public void setBindData(WarDeeVO warDee) {

    }
}
