package com.seatrend.exam.activity;

import android.os.Bundle;

import com.seatrend.exam.R;
import com.seatrend.exam.fragment.MainFragment;
import com.seatrend.exam.utils.SharedPreferencesUtils;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fragment_container, MainFragment.newInstance());
        }
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtils.setLoginTime(String.valueOf(System.currentTimeMillis()));

    }
}
