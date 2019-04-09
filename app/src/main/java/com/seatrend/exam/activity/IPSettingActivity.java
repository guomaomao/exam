package com.seatrend.exam.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

import com.seatrend.exam.R;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.utils.Utils;

import butterknife.BindView;
import butterknife.OnClick;

public class IPSettingActivity extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.m_scroll_view)
    ScrollView mScrollView;
    @BindView(R.id.m_et_ip)
    EditText mEtIp;
    @BindView(R.id.m_et_port)
    EditText mEtPort;

    @Override
    public int getLayout() {
        return R.layout.activity_ip_setting;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setButton(getString(R.string.ok));

        mEtIp.setText(SharedPreferencesUtils.getIpAddress());
        mEtPort.setText(SharedPreferencesUtils.getPort());

        mScrollView.setOnTouchListener(this);

    }

    @Override
    public int setBarColor() {
        return R.color.white;
    }

    @OnClick(R.id.m_button)
    public void onViewClicked() {
        String ip = mEtIp.getText().toString();
        String port = mEtPort.getText().toString();

        if (TextUtils.isEmpty(ip) || TextUtils.isEmpty(port)) {
            showToast("不能为空");
            return;
        }

        SharedPreferencesUtils.setIpAddress(ip);
        SharedPreferencesUtils.setPort(port);

        showToast("设置成功");
        finish();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Utils.hideSoftInput(this);
        return false;
    }
}
