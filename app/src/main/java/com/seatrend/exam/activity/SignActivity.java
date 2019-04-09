package com.seatrend.exam.activity;

import android.os.Bundle;
import android.view.View;

import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.PainterView;

import butterknife.BindView;
import butterknife.OnClick;

public class SignActivity extends BaseActivity {

    @BindView(R.id.m_painter)
    PainterView mPainter;

    @Override
    public int getLayout() {
        return R.layout.activity_sign;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("签名");
        setLeftButton("重签");
        setRightButton("确定");
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick({R.id.m_btn_left, R.id.m_btn_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_btn_left:
                mPainter.clear();
                break;

            case R.id.m_btn_right:
                if (!mPainter.getTouched()) {
                    showToast("请先签名");
                    return;
                }
                Constants.mSign = mPainter.createBitmap();
                setResult(RESULT_OK);
                finish();
                break;
        }
    }
}
