package com.seatrend.exam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seatrend.exam.R;
import com.seatrend.exam.activity.FeedbackActivity;
import com.seatrend.exam.activity.ProfileActivity;
import com.seatrend.exam.activity.RoomExamActivity;
import com.seatrend.exam.activity.SystemSettingActivity;
import com.seatrend.exam.activity.VisitExamineActivity;
import com.seatrend.exam.activity.WorkReportActivity;
import com.seatrend.exam.common.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ThirdFragment extends BaseFragment {

    @BindView(R.id.m_tv_username)
    TextView mTvUsername;
    @BindView(R.id.m_tv_role)
    TextView mTvRole;

    public static ThirdFragment newInstance() {
        Bundle bundle = new Bundle();
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_third;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTvUsername.setText(Constants.xm);
        //1 监管中心 2考试员
        if ("1".equals(Constants.ssjs)) {
            mTvRole.setText("监管中心");
        }else if ("2".equals(Constants.ssjs)) {
            mTvRole.setText("考试员");
        }
    }

    @OnClick({R.id.m_tv_profile, R.id.m_ll_room_exam, R.id.m_ll_work_report, R.id.m_ll_visit_examine, R.id.m_ll_feedback, R.id.m_ll_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_tv_profile:
                startActivity(new Intent(getActivity(), ProfileActivity.class));
                break;

            case R.id.m_ll_room_exam:
                startActivity(new Intent(getActivity(), RoomExamActivity.class).putExtra("type", "mine"));
                break;

            case R.id.m_ll_work_report:
                startActivity(new Intent(getActivity(), WorkReportActivity.class));
                break;

            case R.id.m_ll_visit_examine:
                startActivity(new Intent(getActivity(), VisitExamineActivity.class));
                break;

            case R.id.m_ll_feedback:
                startActivity(new Intent(getActivity(), FeedbackActivity.class));
                break;

            case R.id.m_ll_setting:
                startActivity(new Intent(getActivity(), SystemSettingActivity.class));
                break;
        }
    }
}
