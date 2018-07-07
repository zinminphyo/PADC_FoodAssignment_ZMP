package com.padcmyanmar.padc_foodassignment_zmp.activies;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.padcmyanmar.padc_foodassignment_zmp.R;
import com.padcmyanmar.padc_foodassignment_zmp.adapters.WarDeeAdapters;
import com.padcmyanmar.padc_foodassignment_zmp.data.model.WarDeeModel;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;
import com.padcmyanmar.padc_foodassignment_zmp.delegates.WarDeeDelegates;
import com.padcmyanmar.padc_foodassignment_zmp.events.ApiErrorEvent;
import com.padcmyanmar.padc_foodassignment_zmp.events.SuccessGetWarDeeEvent;
import com.padcmyanmar.padc_foodassignment_zmp.viewpods.EmptyViewPod;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements WarDeeDelegates {

    @BindView(R.id.rv_shopsList)
    RecyclerView rvShopsList;
    @BindView(R.id.vp_empty)
    EmptyViewPod vpEmpty;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.et_search_restaurant)
    EditText etSearchRestaurant;


    private WarDeeAdapters mWarDeeAdapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        mWarDeeAdapters = new WarDeeAdapters(this);
        rvShopsList.setAdapter(mWarDeeAdapters);
        rvShopsList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        WarDeeModel.getObjInstance().loadWarDee();

        etSearchRestaurant.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetWarDee(SuccessGetWarDeeEvent event) {

        Log.d("onSuccessGetWarDee", "onSuccessGetWarDee :" + event.getWarDeeLists());
        mWarDeeAdapters.setWarDeeLists(event.getWarDeeLists());
        swipeRefreshLayout.setRefreshing(false);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFailGetWarDee(ApiErrorEvent event) {

        if (mWarDeeAdapters.getItemCount() <= 0) {
            vpEmpty.setVisibility(View.VISIBLE);
            coordinatorLayout.setVisibility(View.GONE);
        } else {
            vpEmpty.setVisibility(View.GONE);
        }

        Log.d("onFailGetWarDee", "onFailGetWarDee" + event.getErrorMsg());
    }

    @Override
    public void onTapWarDeeLists(WarDeeVO warDee) {
        Intent intent = new Intent(getApplicationContext(), WarDeeDetailActivity.class);
        intent.putExtra("warDeeId", warDee.getWarDeeId());
        startActivity(intent);
    }


}
