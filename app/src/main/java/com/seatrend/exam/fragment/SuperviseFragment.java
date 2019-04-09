package com.seatrend.exam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seatrend.exam.R;
import com.seatrend.exam.activity.PrepareExamActivity;
import com.seatrend.exam.activity.RemoteInspectionActivity;
import com.seatrend.exam.activity.RoomExamActivity;
import com.seatrend.exam.activity.VisitExamineActivity;
import com.seatrend.exam.activity.WorkReportActivity;
import com.seatrend.exam.adapter.SuperviseAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.SpacingItemDecoration;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.utils.Utils;

import butterknife.BindView;

/**
 * 首页--》监管中心
 */
public class SuperviseFragment extends BaseFragment implements SuperviseAdapter.OnClickListener {

    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;

    public static SuperviseFragment newInstance() {
        Bundle bundle = new Bundle();
        SuperviseFragment fragment = new SuperviseFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_supervise;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //给recyclerView设置manager
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecycler.addItemDecoration(new SpacingItemDecoration(3, Utils.dip2px(getActivity(), 5), false));
        SuperviseAdapter mAdapter = new SuperviseAdapter(getActivity(), Constants.catalogue2);
        mRecycler.setAdapter(mAdapter);
        mAdapter.setOnClickListener(this);

    }

    @Override
    public void onClick(int position) {
        switch (Constants.catalogue2.get(position).getName()) {
            case "考前准备": //考前准备
                startActivity(new Intent(getActivity(), PrepareExamActivity.class));
                break;

            case "考场检查": //考场检查
                startActivity(new Intent(getActivity(), RoomExamActivity.class));
                break;

            case "远程巡考"://远程巡考
                startActivity(new Intent(getActivity(), RemoteInspectionActivity.class));
                break;

            case "考生回访": //回访考生
                startActivity(new Intent(getActivity(), VisitExamineActivity.class));
                break;

            case "工作报告": //工作报告
                startActivity(new Intent(getActivity(), WorkReportActivity.class));
                break;
        }
    }
}
