package com.seatrend.exam.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.WorkReportAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.WorkReportResponse;
import com.seatrend.exam.view.GetView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class WorkReportActivity extends BaseActivity implements GetView, PullLoadMoreRecyclerView.PullLoadMoreListener {

    @BindView(R.id.m_recycler)
    PullLoadMoreRecyclerView mRecycler;

    @BindView(R.id.m_ll_header)
    LinearLayout mLlHeader;
    @BindView(R.id.m_bg)
    View mBg;

    private PopupWindow mWindow;
    private String date = Constants.ksrq;
    private String type = "";
    private GetPresenter presenter;
    private int cbData;
    private int cbType;
    private int page = 1;
    private WorkReportAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_recycler;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new GetPresenter(this);

        setTitle("工作报告");
        setRight("筛选");

        mRecycler.setLinearLayout();
        mRecycler.setPushRefreshEnable(true);
        mRecycler.setPullRefreshEnable(true);
        mRecycler.setOnPullLoadMoreListener(this);

        getData();
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    private void getData() {
        mLoading.show();

        HashMap<String, String> map = new HashMap<>();
        map.put("id", Constants.yhdh);
        map.put("examSite", Constants.kcxh);
        map.put("curPage ", String.valueOf(page));
        map.put("pageSize ", "20");
        map.put("reportType", type);
        map.put("reportTime", date);

        presenter.doNetworkTask(map, Constants.SELECT_WORK_REPORT);
    }

    @OnClick(R.id.m_tv_right)
    public void onViewClicked() {
        if (mWindow != null) {
            if (mWindow.isShowing()) {
                mWindow.dismiss();
            } else {
                showWindow();
            }
        } else {
            showWindow();
        }
    }

    private void showWindow() {
        mBg.setBackgroundColor(getResources().getColor(R.color.black_50));

        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_work_report_select, null);
        mWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.showAsDropDown(mLlHeader, 0, 0);
        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mBg.setBackgroundColor(getResources().getColor(R.color.transparent_dark));
            }
        });

        final RadioGroup mRgDate = view.findViewById(R.id.m_rg_date);
        final RadioGroup mRgCategory = view.findViewById(R.id.m_rg_category);

        Button mWindowBtn = view.findViewById(R.id.m_button);
        mWindowBtn.setText(getString(R.string.ok));

        final RadioButton mRbToday = view.findViewById(R.id.m_rb_today);
        final RadioButton mRbDateAll = view.findViewById(R.id.m_rb_date_all);

        if (cbData == 0) {
            mRbToday.setChecked(true);
        } else if (cbData == 1) {
            mRbDateAll.setChecked(true);
        }

        RadioButton mRbAll = view.findViewById(R.id.m_rb_all);
        RadioButton mRbDaily = view.findViewById(R.id.m_rb_daily);
        RadioButton mRbWeekly = view.findViewById(R.id.m_rb_weekly);
        RadioButton mRbMonthly = view.findViewById(R.id.m_rb_monthly);

        if (cbType == 0) {
            mRbAll.setChecked(true);
        } else if (cbType == 1) {
            mRbDaily.setChecked(true);
        } else if (cbType == 2) {
            mRbWeekly.setChecked(true);
        } else if (cbType == 3) {
            mRbMonthly.setChecked(true);
        }

        mWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWindow.dismiss();

                switch (mRgDate.getCheckedRadioButtonId()) {
                    case R.id.m_rb_today:
                        date = Constants.ksrq;
                        cbData = 0;
                        break;

                    case R.id.m_rb_date_all:
                        date = "";
                        cbData = 1;
                        break;
                }

                switch (mRgCategory.getCheckedRadioButtonId()) { //报告类型 1日报 2周报 3月报
                    case R.id.m_rb_all:
                        type = "";
                        cbType = 0;
                        break;

                    case R.id.m_rb_daily:
                        type = "1";
                        cbType = 1;
                        break;

                    case R.id.m_rb_weekly:
                        type = "2";
                        cbType = 2;
                        break;

                    case R.id.m_rb_monthly:
                        type = "3";
                        cbType = 3;
                        break;
                }

                page = 1;
                getData();

            }
        });
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            WorkReportResponse entity = gson.fromJson(response.getResponseString(), WorkReportResponse.class);
            if (entity.getCode() == 0) {
                List<WorkReportResponse.DataBean.ListBean> list = entity.getData().getList();
                notShowEmpty();

                if (1 == page) {
                    if (list.size() > 0) {
                        adapter = new WorkReportAdapter(this, list);
                        mRecycler.setAdapter(adapter);

                    } else {
                        showEmpty();
                    }
                } else if (1 < page) {
                    if (0 == list.size()) {
                        showToast("没有更多数据了~");
                    } else {
                        adapter.refresh(list);
                    }
                }

                if (mRecycler.isLoadMore() || mRecycler.isRefresh()) {
                    mRecycler.setPullLoadMoreCompleted();
                }

            } else {
                showToast(entity.getMessage());
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
    public void onRefresh() {
        if (mLoading.isShowing()) {
            mRecycler.setPullLoadMoreCompleted();
            return;
        }
        page = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        page += 1;
        getData();
    }
}
