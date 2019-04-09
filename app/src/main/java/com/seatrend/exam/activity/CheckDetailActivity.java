package com.seatrend.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.ItemTitleAdapter;
import com.seatrend.exam.adapter.PrepareWaitAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.PrepareDetailResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 考前准备--》检查详情
 */
public class CheckDetailActivity extends BaseActivity implements GetView {

    @BindView(R.id.m_recycler_title)
    RecyclerView mRecyclerTitle;
    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.m_tv_username)
    TextView mTvUsername;
    @BindView(R.id.m_tv_time)
    TextView mTvTime;
    @BindView(R.id.m_tv_exam_room)
    TextView mTvExamRoom;
    @BindView(R.id.m_tv_state)
    TextView mTvState;
    @BindView(R.id.m_scroll_view)
    ScrollView mScrollView;
    @BindView(R.id.m_tv_monitor_state)
    TextView mTvMonitorState;
    @BindView(R.id.m_iv_monitor_photo)
    ImageView mIvMonitorPhoto;
    @BindView(R.id.m_tv_exam_num)
    TextView mTvExamNum;
    @BindView(R.id.m_tv_qualified_num)
    TextView mTvQualifiedNum;
    @BindView(R.id.m_tv_pass_rate)
    TextView mTvPassRate;
    @BindView(R.id.m_tv_exam_charge)
    TextView mTvExamCharge;
    @BindView(R.id.m_tv_exam_detail)
    TextView mTvExamDetail;
    @BindView(R.id.m_tv_exception)
    TextView mTvException;
    @BindView(R.id.m_tv_check)
    TextView mTvCheck;
    @BindView(R.id.m_tv_check_detail)
    TextView mTvCheckDetail;
    @BindView(R.id.m_tv_situation)
    TextView mTvSituation;
    @BindView(R.id.m_tv_situation_detail)
    TextView mTvSituationDetail;
    @BindView(R.id.m_tv_fault_equipment)
    TextView mTvFaultEquipment;
    @BindView(R.id.m_tv_fault_equipment_detail)
    TextView mTvFaultEquipmentDetail;
    @BindView(R.id.m_tv_video)
    TextView mTvVideo;
    @BindView(R.id.m_tv_video_detail)
    TextView mTvVideoDetail;
    @BindView(R.id.m_tv_remark)
    TextView mTvRemark;
    private GetPresenter getPresenter;
    ArrayList<String> titleList = new ArrayList<>();
    private ItemTitleAdapter mTitleAdapter;
    private PrepareWaitAdapter waitAdapter;
    private List<PrepareDetailResponse.DataBean.ProjectsBean> projects;
    private List<PrepareDetailResponse.DataBean.ProjectsBean> newProjects = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.activity_check_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("检查详情");

        getPresenter = new GetPresenter(this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerTitle.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerTitle.setLayoutManager(manager);
        mTitleAdapter = new ItemTitleAdapter(this, titleList);
        mRecyclerTitle.setAdapter(mTitleAdapter);

        mTitleAdapter.setOnItemClickListener(new ItemTitleAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                mTitleAdapter.setThisPosition(position);
                mTitleAdapter.notifyDataSetChanged();
            }
        });

        if (mTitleAdapter != null) {
            mTitleAdapter.setOnItemClickListener(new ItemTitleAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position) {
                    mTitleAdapter.setThisPosition(position);
                    newProjects.clear();
                    for (int i = 0; i < projects.size(); i++) {
                        if (titleList.get(position).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }

                    if (waitAdapter != null) {
                        waitAdapter.refresh(newProjects);
                    }
                }
            });
        }

        waitAdapter = new PrepareWaitAdapter(this, newProjects);
        mRecycler.setAdapter(waitAdapter);

        getData();
    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("checkId", intent.getStringExtra("checkId"));
        getPresenter.doNetworkTask(map, Constants.GET_EXAM_CHECK);

    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            PrepareDetailResponse mResponse = gson.fromJson(response.getResponseString(), PrepareDetailResponse.class);
            PrepareDetailResponse.DataBean data = mResponse.getData();

            mTvUsername.setText(data.getChecker());
            mTvExamRoom.setText(data.getExamroom());
            if ("0".equals(data.getCheckstate())) {
                mTvState.setText("正常");
                mTvState.setBackgroundResource(R.drawable.my_bg_green_20);

            } else {
                mTvState.setText("异常");
                mTvState.setBackgroundResource(R.drawable.my_bg_dark_orange_20);
            }
            mTvTime.setText(Utils.formatTime(data.getExamtime()));

            if ("考后检查".equals(data.getChecktype())) {
                mScrollView.setVisibility(View.VISIBLE);

                PrepareDetailResponse.DataBean.ProjectBean project = data.getProject();

                //考试监管平台
                if ("0".equals(project.getMonitorsituationResult())) {
                    mTvMonitorState.setText("正常");

                } else {
                    mTvMonitorState.setText("异常");
                }

                Glide.with(this).load(NetworkService.httpUrl + Constants.DOWNLOAD_FILE_BY_ID + "?fileId=" + project.getMonitorsituationPhoto()).error(R.color.light_gray).into(mIvMonitorPhoto);

                //数据统计
                mTvExamNum.setText(project.getExamnumber());
                mTvQualifiedNum.setText(project.getQualifiednumber());
                mTvPassRate.setText(project.getQualifiedrate());

                //数据复核
                mTvExamCharge.setText(project.getExamdataPerson());
                mTvExamDetail.setText(project.getExamdata());

                //异常数据
                if ("0".equals(project.getUnusualdataResult())) {
                    mTvException.setText("正常");

                } else {
                    mTvException.setText("异常");
                }

                //考前设备
                mTvCheck.setText(project.getBeforeexamcheck());
                mTvCheckDetail.setText(project.getBeforeexamcheckResult());

                //突发情况
                if ("0".equals(project.getEmergenciesResult())) {
                    mTvSituation.setText("正常");

                } else {
                    mTvSituation.setText("异常");
                }
                mTvSituationDetail.setText(project.getEmergencies());

                //故障设备
                if ("0".equals(project.getFaultequipmentResult())) {
                    mTvFaultEquipment.setText("正常");

                } else {
                    mTvFaultEquipment.setText("异常");

                }
                mTvFaultEquipmentDetail.setText(project.getFaultequipment());

                //考试录像
                mTvVideo.setText(project.getVideosavedPerson());
                if ("0".equals(project.getVideosavedResult())) {
                    mTvVideoDetail.setText("正常");

                } else {
                    mTvVideoDetail.setText("异常");
                }

                //其他
                mTvRemark.setText(project.getRemark());

            } else {
                mRecycler.setVisibility(View.VISIBLE);
                if ("考前检查".equals(data.getChecktype())) {
                    mRecyclerTitle.setVisibility(View.VISIBLE);
                } else {
                    mRecyclerTitle.setVisibility(View.GONE);
                }
                projects = data.getProjects();
                if (projects != null && projects.size() > 0) {
                    for (int i = 0; i < projects.size(); i++) {
                        if (!titleList.contains(projects.get(i).getPointtype())) {
                            titleList.add(projects.get(i).getPointtype());
                        }
                    }
                    mTitleAdapter.refresh(titleList);

                    newProjects.clear();
                    for (int i = 0; i < projects.size(); i++) {
                        if (titleList.get(0).equals(projects.get(i).getPointtype())) {
                            newProjects.add(projects.get(i));
                        }
                    }
                    waitAdapter.refresh(newProjects);
                }
            }

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
