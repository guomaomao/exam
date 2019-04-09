package com.seatrend.exam.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.seatrend.exam.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedbackActivity extends BaseActivity {

    @BindView(R.id.m_tv_phone_1)
    TextView mTvPhone1;
    @BindView(R.id.m_tv_phone_2)
    TextView mTvPhone2;
    @BindView(R.id.m_iv_qr)
    ImageView mIvQr;

    @Override
    public int getLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("意见反馈");
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick({R.id.m_ll_phone_1, R.id.m_ll_phone_2, R.id.m_iv_qr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_ll_phone_1:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + mTvPhone1.getText().toString().trim());
                intent.setData(data);
                startActivity(intent);
                break;

            case R.id.m_ll_phone_2:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                Uri data2 = Uri.parse("tel:" + mTvPhone2.getText().toString().trim());
                intent2.setData(data2);
                startActivity(intent2);
                break;

            case R.id.m_iv_qr:
                break;
        }
    }
}
