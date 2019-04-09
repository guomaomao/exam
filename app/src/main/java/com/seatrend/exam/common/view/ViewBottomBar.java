package com.seatrend.exam.common.view;

/**
 * 底部导航栏
 * Created by dell on 2019年1月21日15:30:38
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seatrend.exam.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewBottomBar extends LinearLayout {

    @BindView(R.id.m_iv_first)
    ImageView mIvFirst;
    @BindView(R.id.m_tv_first)
    TextView mTvFirst;
    @BindView(R.id.first)
    FrameLayout first;
    @BindView(R.id.m_iv_second)
    ImageView mIvSecond;
    @BindView(R.id.m_tv_second)
    TextView mTvSecond;
    @BindView(R.id.second)
    FrameLayout second;
    @BindView(R.id.m_iv_third)
    ImageView mIvThird;
    @BindView(R.id.m_tv_third)
    TextView mTvThird;
    @BindView(R.id.third)
    FrameLayout third;

    private Context mContext;
    private OnBottomBarClick mOnBottomBarClick;

    public ViewBottomBar(Context context) {
        super(context);
        init(context);
    }

    public ViewBottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    private void init(Context context) {
        mContext = context;
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.view_bottom_bar, this, true);
        ButterKnife.bind(inflate);
        //获取控件id
        initId();
        onBottomBarClick();
    }

    private void initId() {
        clearSelected();
        mIvFirst.setImageResource(R.mipmap.first_select);
        mTvFirst.setTextColor(getResources().getColor(R.color.blue));

    }

    /**
     * 底部按钮点击监听器
     */
    private void onBottomBarClick() {
        first.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBottomBarClick != null) {
                    mOnBottomBarClick.onFirstClick();
                    clearSelected();
                    mIvFirst.setImageResource(R.mipmap.first_select);
                    mTvFirst.setTextColor(getResources().getColor(R.color.blue));

                }
            }
        });
        second.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBottomBarClick != null) {
                    mOnBottomBarClick.onSecondClick();
                    clearSelected();
                    mIvSecond.setImageResource(R.mipmap.second_select);
                    mTvSecond.setTextColor(getResources().getColor(R.color.blue));
                }
            }
        });
        third.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnBottomBarClick != null) {
                    mOnBottomBarClick.onThirdClick();
                    clearSelected();
                    mIvThird.setImageResource(R.mipmap.third_select);
                    mTvThird.setTextColor(getResources().getColor(R.color.blue));
                }
            }
        });
    }

    //清理掉选择图片
    private void clearSelected() {
        mIvFirst.setImageResource(R.mipmap.first);
        mIvSecond.setImageResource(R.mipmap.second);
        mIvThird.setImageResource(R.mipmap.third);

        mTvFirst.setTextColor(getResources().getColor(R.color.dark_gray));
        mTvSecond.setTextColor(getResources().getColor(R.color.dark_gray));
        mTvThird.setTextColor(getResources().getColor(R.color.dark_gray));
    }

    public void setOnBottomBarOnclick(OnBottomBarClick onBottomBarClick) {
        mOnBottomBarClick = onBottomBarClick;
    }

    public interface OnBottomBarClick {
        void onFirstClick();

        void onSecondClick();

        void onThirdClick();


    }
}
