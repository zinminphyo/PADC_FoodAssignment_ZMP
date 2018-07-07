package com.padcmyanmar.padc_foodassignment_zmp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.padc_foodassignment_zmp.R;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;
import com.padcmyanmar.padc_foodassignment_zmp.delegates.WarDeeDelegates;
import com.padcmyanmar.padc_foodassignment_zmp.viewholders.WarDeeViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WarDeeAdapters extends RecyclerView.Adapter<WarDeeViewHolder> {

    private List<WarDeeVO> mWarDeeLists;
    private WarDeeDelegates mWarDeeDelegates;

    public WarDeeAdapters(WarDeeDelegates warDeeDelegates) {
        mWarDeeDelegates = warDeeDelegates;
        mWarDeeLists = new ArrayList<>();
    }

    @NonNull
    @Override
    public WarDeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_holder_each_wardee, parent, false);
        return new WarDeeViewHolder(view, mWarDeeDelegates);
    }

    @Override
    public void onBindViewHolder(@NonNull WarDeeViewHolder holder, int position) {

        holder.setBindData(mWarDeeLists.get(position));


    }

    @Override
    public int getItemCount() {
        return mWarDeeLists.size();
    }


    public void setWarDeeLists(List<WarDeeVO> WarDeeLists) {
        this.mWarDeeLists = WarDeeLists;
        notifyDataSetChanged();
    }
}
