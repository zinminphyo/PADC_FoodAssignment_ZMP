package com.padcmyanmar.padc_foodassignment_zmp.activies;

import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc_foodassignment_zmp.R;
import com.padcmyanmar.padc_foodassignment_zmp.data.model.WarDeeModel;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_detail_food_image)
    ImageView ivDetailFoodImage;

    @BindView(R.id.tv_detail_food_name)
    TextView tvDetailFoodName;

    @BindView(R.id.tv_detail_food_text)
    TextView tvDetailFoodText;

    @BindView(R.id.tv_detail_food_price)
    TextView tvDetailFoodPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_detail_wardee);
        ButterKnife.bind(this, this);

        String warDeeId = getIntent().getStringExtra("warDeeId");
        Log.d("detailWarDee", "WarDeeDetail" + warDeeId);
        WarDeeVO warDee = WarDeeModel.getObjInstance().getWarDeeById(warDeeId);
        if (warDee != null) {
            bindData(warDee);
        } else {

        }
    }

    public void bindData(WarDeeVO warDee) {
        Glide.with(ivDetailFoodImage.getContext())
                .load(warDee.getImages().get(0))
                .into(ivDetailFoodImage);
        tvDetailFoodName.setText(warDee.getName());

        tvDetailFoodText.setText(warDee.getGeneralTastes().get(0).getTasteDesc());

    }
}
