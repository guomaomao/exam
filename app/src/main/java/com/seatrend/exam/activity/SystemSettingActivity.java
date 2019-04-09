package com.seatrend.exam.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.ActivityCollector;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.CommonDialog;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.UpdateResponse;
import com.seatrend.exam.service.UpdateService;
import com.seatrend.exam.utils.ClearCacheUtils;
import com.seatrend.exam.utils.SharedPreferencesUtils;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class SystemSettingActivity extends BaseActivity implements GetView {

    @BindView(R.id.m_tv_version)
    TextView mTvVersion;
    @BindView(R.id.m_tv_check_version)
    TextView mTvCheckVersion;
    @BindView(R.id.m_tv_update_date)
    TextView mTvUpdateDate;
    @BindView(R.id.m_tv_clear_catch)
    TextView mTvClearCatch;
    private GetPresenter getPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_system_setting;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("系统设置");
        setButton("退出登录");

        getPresenter = new GetPresenter(this);

        mTvVersion.setText("V" + Utils.getVersionName(this));
        try {
            mTvClearCatch.setText(ClearCacheUtils.getTotalCacheSize(this));
        } catch (Exception e) {
            mTvClearCatch.setText("0MB");
        }
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick({R.id.m_ll_instructions, R.id.m_tv_check_version, R.id.m_ll_clear_catch, R.id.m_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_ll_instructions:

                break;

            case R.id.m_tv_check_version:
                getPresenter.doNetworkTask(new HashMap<String, String>(), Constants.GET_PDA_INFORMATION);
                break;

            case R.id.m_ll_clear_catch:
                final Dialog dialog = CommonDialog.CenterDialog(this, R.layout.dialog_tips, false);
                dialog.show();

                TextView mTvText = dialog.findViewById(R.id.m_tv_text);
                mTvText.setText("您确定要清除当前应用的缓存数据吗?");

                Button mBtnLeft = dialog.findViewById(R.id.m_btn_left);
                mBtnLeft.setText("取消");
                mBtnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                Button mBtnRight = dialog.findViewById(R.id.m_btn_right);
                mBtnRight.setText("确定");
                mBtnRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        clearCache();
                    }
                });
                break;

            case R.id.m_button:
                SharedPreferencesUtils.setPassword("");

                startActivity(new Intent(this, LoginActivity.class));
                ActivityCollector.finishAll();
                break;
        }
    }

    private void clearCache() {
        ClearCacheUtils.clearAllCache(this);

        try {
            mTvClearCatch.setText(ClearCacheUtils.getTotalCacheSize(this));
        } catch (Exception e) {
            mTvClearCatch.setText("0MB");
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            UpdateResponse updateResponse = gson.fromJson(response.getResponseString(), UpdateResponse.class);

            if (updateResponse.getCode() == 0) {
                final UpdateResponse.DataBean data = updateResponse.getData();
                if (data.getVersions() != null) {
                    if (!data.getVersions().equals(Utils.getVersionName(this))) {
                        final Dialog dialog = CommonDialog.CenterDialog(this, R.layout.dialog_info, false);
                        dialog.show();

                        TextView mTvText = dialog.findViewById(R.id.m_tv_info);
                        mTvText.setText("有新版本，请下载更新");

                        Button mBtn = dialog.findViewById(R.id.m_button);
                        mBtn.setText("立即更新");

                        mBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                SystemSettingActivity.this.startService(new Intent(SystemSettingActivity.this, UpdateService.class).putExtra("pda", data.getPda()));
                            }
                        });

                    }else {
                        showToast("已是最新版本！");
                    }
                }
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }
}
