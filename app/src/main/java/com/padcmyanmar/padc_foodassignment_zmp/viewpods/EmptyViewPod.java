package com.padcmyanmar.padc_foodassignment_zmp.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc_foodassignment_zmp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmptyViewPod extends RelativeLayout {

    @BindView(R.id.iv_empty_image)
    ImageView ivEmptyImage;

    @BindView(R.id.tv_empty_text)
    TextView tvEmptyText;

    public EmptyViewPod(Context context) {
        super(context);
    }

    public EmptyViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmptyViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setEmptyData(String emptyImgUrl, String emptyMsg) {

        Glide.with(getContext())
                .load(emptyImgUrl)
                .into(ivEmptyImage);

        tvEmptyText.setText(emptyMsg);
    }

    public void setEmptyData(int emptyImageResource, String emptyMsg) {
        ivEmptyImage.setImageResource(emptyImageResource);
        tvEmptyText.setText(emptyMsg);
    }
}
