package com.seatrend.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.ExamPlanAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.ExamPlanResponse;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ExamPlanActivity extends BaseActivity implements GetView {

    private static final int REQUEST_CODE = 10;

    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_tv_username)
    TextView mTvUsername;

    private GetPresenter presenter;
    private ExamPlanAdapter examPlanAdapter;
    private List<ExamPlanResponse.DataBean> examPlanEntityData;

    @Override
    public int getLayout() {
        return R.layout.activity_exam_plan;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new GetPresenter(this);

        setTitle(getString(R.string.exam_plan));
        setButton("确认考试计划");
        mTvUsername.setText(Constants.xm);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        getData();

        String isComplete = intent.getStringExtra("isComplete");
        if ("1".equals(isComplete)) {
            setButton("考试计划已确认");
            mButton.setEnabled(false);
        }
    }

    private void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("ksrq", Constants.ksrq);
        map.put("ksy", Constants.xm);
        mLoading.show();
        presenter.doNetworkTask(map, Constants.EXAM_GROUP_PDA);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick(R.id.m_button)
    public void onViewClicked() {
        startActivity(new Intent(this, ConfirmExamPlanActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                finish();
            }
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            ExamPlanResponse examPlanResponse = gson.fromJson(response.getResponseString(), ExamPlanResponse.class);
            examPlanEntityData = examPlanResponse.getData();
            if (examPlanEntityData != null && examPlanEntityData.size() > 0) {
                notShowEmpty();
                examPlanAdapter = new ExamPlanAdapter(this, examPlanEntityData);
                mRecycler.setAdapter(examPlanAdapter);

            } else {
                showEmpty();
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
