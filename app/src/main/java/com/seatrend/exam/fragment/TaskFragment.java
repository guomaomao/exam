package com.seatrend.exam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.activity.AddWorkReportActivity;
import com.seatrend.exam.activity.AfterExamEditActivity;
import com.seatrend.exam.activity.BeforeExamEditActivity;
import com.seatrend.exam.activity.ExamPlanActivity;
import com.seatrend.exam.activity.RemoteInspectionActivity;
import com.seatrend.exam.activity.VisitExamineActivity;
import com.seatrend.exam.adapter.TaskAdapter;
import com.seatrend.exam.adapter.TaskTopAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.common.view.SemicircleProgressBar;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CatalogueResponse;
import com.seatrend.exam.response.TaskTopResponse;
import com.seatrend.exam.view.GetView;

import java.text.DecimalFormat;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页--》考试员
 */
public class TaskFragment extends BaseFragment implements TaskAdapter.OnClickListener, GetView {

    private static final int REQUEST_CODE = 10;
    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_recycler_top)
    RecyclerView mRecyclerTop;
    @BindView(R.id.m_tv_project_num)
    TextView mTvProjectNum;
    @BindView(R.id.progressbar)
    SemicircleProgressBar progressbar;
    @BindView(R.id.m_tv_pass_rate)
    TextView mTvPassRate;
    @BindView(R.id.m_tv_exam_num)
    TextView mTvExamNum;
    @BindView(R.id.m_tv_waiting_num)
    TextView mTvWaitingNum;
    @BindView(R.id.m_ll_1)
    LinearLayout mLl1;
    @BindView(R.id.m_tv_project_num_2)
    TextView mTvProjectNum2;
    @BindView(R.id.progressbar_2)
    SemicircleProgressBar progressbar2;
    @BindView(R.id.m_tv_pass_rate_2)
    TextView mTvPassRate2;
    @BindView(R.id.m_tv_exam_num_2)
    TextView mTvExamNum2;
    @BindView(R.id.m_tv_waiting_num_2)
    TextView mTvWaitingNum2;
    @BindView(R.id.m_ll_2)
    LinearLayout mLl2;
    @BindView(R.id.m_ll_top)
    LinearLayout mLlTop;

    private GetPresenter getPresenter;

    public static TaskFragment newInstance() {
        Bundle bundle = new Bundle();
        TaskFragment fragment = new TaskFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_task;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerTop.setNestedScrollingEnabled(false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        mRecyclerTop.setLayoutManager(manager);

        init();
        initTop();

        getPresenter = new GetPresenter(this);

    }

    private void init() {
        TaskAdapter adapter = new TaskAdapter(getActivity(), Constants.catalogue1);
        mRecycler.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }

    private void initTop() {
        if (Constants.taskTop.size() > 2) {
            TaskTopAdapter taskTopAdapter = new TaskTopAdapter(getActivity(), Constants.taskTop);
            mRecyclerTop.setAdapter(taskTopAdapter);
            mLlTop.setVisibility(View.GONE);
            mRecyclerTop.setVisibility(View.VISIBLE);

        }else {
            mLlTop.setVisibility(View.VISIBLE);
            mRecyclerTop.setVisibility(View.GONE);
            if (Constants.taskTop.size() > 0) {
                if (Constants.taskTop.size() == 1) {
                    mLl2.setVisibility(View.GONE);

                    TaskTopResponse.DataBean dataBean = Constants.taskTop.get(0);
                    if ("1".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目一");

                    }else if ("2".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目二");

                    }else if ("3".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目三");

                    }else if ("4".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目四");
                    }

                    mTvExamNum.setText(dataBean.getYkrs());
                    mTvWaitingNum.setText(dataBean.getDkrs());
                    DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%
                    if (dataBean.getHgl() != null) {
                        mTvPassRate.setText(df1.format(Double.parseDouble(dataBean.getHgl())));
                        progressbar.setProgress(Double.parseDouble(dataBean.getHgl()) * 100);
                    }

                }else if (Constants.taskTop.size() == 2) {
                    TaskTopResponse.DataBean dataBean = Constants.taskTop.get(0);
                    if ("1".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目一");

                    }else if ("2".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目二");

                    }else if ("3".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目三");

                    }else if ("4".equals(dataBean.getKskm())) {
                        mTvProjectNum.setText("科目四");
                    }

                    mTvExamNum.setText(dataBean.getYkrs());
                    mTvWaitingNum.setText(dataBean.getDkrs());
                    DecimalFormat df1 = new DecimalFormat("##.00%");    //##.00%
                    if (dataBean.getHgl() != null) {
                        mTvPassRate.setText(df1.format(Double.parseDouble(dataBean.getHgl())));
                        progressbar.setProgress(Double.parseDouble(dataBean.getHgl()) * 100);
                    }

                    //2
                    TaskTopResponse.DataBean dataBean1 = Constants.taskTop.get(1);
                    if ("1".equals(dataBean1.getKskm())) {
                        mTvProjectNum2.setText("科目一");

                    }else if ("2".equals(dataBean1.getKskm())) {
                        mTvProjectNum2.setText("科目二");

                    }else if ("3".equals(dataBean1.getKskm())) {
                        mTvProjectNum2.setText("科目三");

                    }else if ("4".equals(dataBean1.getKskm())) {
                        mTvProjectNum2.setText("科目四");
                    }

                    mTvExamNum2.setText(dataBean1.getYkrs());
                    mTvWaitingNum2.setText(dataBean1.getDkrs());
                    DecimalFormat df12 = new DecimalFormat("##.00%");    //##.00%
                    if (dataBean.getHgl() != null) {
                        mTvPassRate2.setText(df12.format(Double.parseDouble(dataBean.getHgl())));
                        progressbar2.setProgress(Double.parseDouble(dataBean.getHgl()) * 100);
                    }
                }
            }
        }
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();

            CatalogueResponse catalogueResponse = gson.fromJson(response.getResponseString(), CatalogueResponse.class);
            if (catalogueResponse.getCode() == 0) {
                Constants.catalogue1 = catalogueResponse.getData().getCatalogue1();
                Constants.catalogue2 = catalogueResponse.getData().getCatalogue2();
                init();
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

    @Override
    public void onClick(int position) {
        switch (Constants.catalogue1.get(position).getName()) {
            case "考试计划确认": //考试计划
                startActivityForResult(new Intent(getActivity(), ExamPlanActivity.class).putExtra("isComplete", Constants.catalogue1.get(position).getNumber()), REQUEST_CODE);
                break;

            case "考前检查": //考前检查
                startActivityForResult(new Intent(getActivity(), BeforeExamEditActivity.class).putExtra("type", "before").putExtra("isComplete", Constants.catalogue1.get(position).getNumber()), REQUEST_CODE); //考前
                break;

            case "考中检查": //考中检查
                startActivityForResult(new Intent(getActivity(), BeforeExamEditActivity.class).putExtra("type", "between").putExtra("isComplete", Constants.catalogue1.get(position).getNumber()), REQUEST_CODE);//考中
                break;

            case "考后检查": //考后检查
                startActivityForResult(new Intent(getActivity(), AfterExamEditActivity.class).putExtra("isComplete", Constants.catalogue1.get(position).getNumber()), REQUEST_CODE); //考后
                break;

            case "远程巡考": //远程巡考
                startActivityForResult(new Intent(getActivity(), RemoteInspectionActivity.class), REQUEST_CODE);
                break;

            case "回访考生": //回访考生
                startActivityForResult(new Intent(getActivity(), VisitExamineActivity.class), REQUEST_CODE);
                break;

            case "工作报告": //工作报告
                startActivityForResult(new Intent(getActivity(), AddWorkReportActivity.class).putExtra("isComplete", Constants.catalogue1.get(position).getNumber()), REQUEST_CODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            mLoading.show();
            HashMap<String, String> map = new HashMap<>();
            map.put("jsdh", Constants.ssjs);
            map.put("ksrq", Constants.ksrq);
            map.put("sfzmhm", Constants.sfzmhm);
            getPresenter.doNetworkTask(map, Constants.GET_CATALOGUE);
        }
    }
}
