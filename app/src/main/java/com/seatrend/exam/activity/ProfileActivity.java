package com.seatrend.exam.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.ProfileResponse;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends BaseActivity implements GetView {

    @BindView(R.id.m_tv_username)
    TextView mTvUsername;
    @BindView(R.id.m_tv_post)
    TextView mTvPost;
    @BindView(R.id.m_tv_badge_number)
    TextView mTvBadgeNumber;
    @BindView(R.id.m_tv_subordinate_detachment)
    TextView mTvSubordinateDetachment;
    @BindView(R.id.m_tv_department)
    TextView mTvDepartment;
    @BindView(R.id.m_tv_vehicle_type)
    TextView mTvVehicleType;
    @BindView(R.id.m_ll_badge_number)
    LinearLayout mLlBadgeNumber;
    @BindView(R.id.m_ll_subordinate_detachment)
    LinearLayout mLlSubordinateDetachment;
    @BindView(R.id.m_ll_vehicle_type)
    LinearLayout mLlVehicleType;
    private GetPresenter getPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_profile;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("个人信息");
        getPresenter = new GetPresenter(this);

        mTvUsername.setText(Constants.xm);
        //1 监管中心 2考试员
        if ("1".equals(Constants.ssjs)) {
            mTvPost.setText("监管民警");
            mLlBadgeNumber.setVisibility(View.GONE);
            mLlVehicleType.setVisibility(View.GONE);
            mLlSubordinateDetachment.setVisibility(View.GONE);
            mTvDepartment.setText(Constants.bmmc);

        } else if ("2".equals(Constants.ssjs)) {
            mTvPost.setText("考试员");

            HashMap<String, String> map = new HashMap<>();
            map.put("sfzmhm ", Constants.sfzmhm);
            getPresenter.doNetworkTask(map, Constants.SELECT_INVIGILATOR_BY_SFZMHM);
        }
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            ProfileResponse profileResponse = gson.fromJson(response.getResponseString(), ProfileResponse.class);
            ProfileResponse.DataBean data = profileResponse.getData();
            mTvDepartment.setText(data.getGlbm());
            mTvSubordinateDetachment.setText(data.getGzdw());
            mTvVehicleType.setText(data.getZkcx());
            mTvBadgeNumber.setText(data.getJh());

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void getFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

}
