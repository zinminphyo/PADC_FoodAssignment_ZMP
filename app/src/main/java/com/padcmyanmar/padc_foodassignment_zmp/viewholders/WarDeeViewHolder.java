package com.padcmyanmar.padc_foodassignment_zmp.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc_foodassignment_zmp.R;
import com.padcmyanmar.padc_foodassignment_zmp.data.vos.WarDeeVO;
import com.padcmyanmar.padc_foodassignment_zmp.delegates.WarDeeDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeViewHolder extends BaseWarDeeViewHolder {

    private WarDeeVO mWarDee;
    private WarDeeDelegates mWarDeeDelegates;

    @BindView(R.id.iv_food_image)
    ImageView ivFoodImage;

    @BindView(R.id.tv_food_price)
    TextView tvFoodPrice;

    @BindView(R.id.tv_food_rating)
    TextView tvFoodRating;

    @BindView(R.id.tv_food_name)
    TextView tvFoodName;

    @BindView(R.id.tv_food_type)
    TextView tvFoodType;


    public WarDeeViewHolder(View itemView, WarDeeDelegates warDeeDelegates) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mWarDeeDelegates = warDeeDelegates;


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWarDeeDelegates.onTapWarDeeLists(mWarDee);
            }
        });
    }

    @Override
    public void setBindData(WarDeeVO warDee) {
        super.setBindData(warDee);

        mWarDee = warDee;

        Glide.with(ivFoodImage.getContext())
                .load(warDee.getImages().get(0))
                .into(ivFoodImage);

        tvFoodName.setText(warDee.getName());

        tvFoodType.setText(warDee.getGeneralTastes().get(0).getTaste());


    }

}
