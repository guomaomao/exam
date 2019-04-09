package com.seatrend.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.seatrend.exam.adapter.VisitExamineAdapter;
import com.seatrend.exam.adapter.WorkReportAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.VisitExamineResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 回访考生
 */
public class VisitExamineActivity extends BaseActivity implements GetView, PullLoadMoreRecyclerView.PullLoadMoreListener {

    private static final int REQUEST_CODE = 11;
    @BindView(R.id.m_recycler)
    PullLoadMoreRecyclerView mRecycler;
    @BindView(R.id.m_ll_header)
    LinearLayout mLlHeader;
    @BindView(R.id.m_bg)
    View mBg;
    private PopupWindow mWindow;
    private GetPresenter getPresenter;
    private String checktype = "";
    private String checktime = Constants.ksrq;
    private int cbData;
    private int cbType;
    private int page = 1;
    private VisitExamineAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_recycler;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("考生回访");
        setRight("筛选");

        getPresenter = new GetPresenter(this);

        mRecycler.setLinearLayout();
        mRecycler.setPushRefreshEnable(false);
        mRecycler.setPullRefreshEnable(false);
        mRecycler.setOnPullLoadMoreListener(this);

        getData();

    }

    private void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("ksrq", checktime);
        map.put("curPage", String.valueOf(page));
        map.put("pageSize", "20");
        map.put("myd", checktype); //0不满意 1满意 2很满意
        mLoading.show();
        getPresenter.doNetworkTask(map, Constants.VISIT_RECORD_PAGES);

    }

    @Override
    public int setBarColor() {
        return R.color.blue;
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

        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_visit_select, null);
        mWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mWindow.showAsDropDown(mLlHeader, 0, 0);
        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mBg.setBackgroundColor(getResources().getColor(R.color.transparent_dark));
            }
        });

        final RadioGroup mRgDate = view.findViewById(R.id.m_rg_date);
        final RadioGroup mRgCategory = view.findViewById(R.id.m_rg_satisfaction);

        Button mWindowBtn = view.findViewById(R.id.m_button);
        mWindowBtn.setText(getString(R.string.ok));

        final RadioButton mRbToday = view.findViewById(R.id.m_rb_today);
        final RadioButton mRbDateAll = view.findViewById(R.id.m_rb_date_all);

        if (cbData == 0) {
            mRbToday.setChecked(true);
        }else if (cbData == 1) {
            mRbDateAll.setChecked(true);
        }

        RadioButton mRbAll = view.findViewById(R.id.m_rb_all);
        RadioButton mRbVerySatisfied = view.findViewById(R.id.m_rb_very_satisfied);
        RadioButton mRbSatisfied = view.findViewById(R.id.m_rb_satisfied);
        RadioButton mRbDissatisfied = view.findViewById(R.id.m_rb_dissatisfied);

        if (cbType == 0) {
            mRbAll.setChecked(true);
        }else if (cbType == 1) {
            mRbVerySatisfied.setChecked(true);
        }else if (cbType == 2) {
            mRbSatisfied.setChecked(true);
        }else  if (cbType == 3) {
            mRbDissatisfied.setChecked(true);
        }

        mWindowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWindow.dismiss();

                int id = mRgDate.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.m_rb_today:
                        cbData = 0;
                        checktime = Utils.getCurrYearMonthDate();
                        break;

                    case R.id.m_rb_date_all:
                        cbData = 1;
                        checktime = "";
                        break;
                }

                int categoryId = mRgCategory.getCheckedRadioButtonId();
                switch (categoryId) {
                    case R.id.m_rb_all:
                        checktype = "";
                        cbType = 0;
                        break;

                    case R.id.m_rb_very_satisfied:
                        checktype = "2";
                        cbType = 1;
                        break;

                    case R.id.m_rb_satisfied:
                        checktype = "1";
                        cbType = 2;
                        break;

                    case R.id.m_rb_dissatisfied:
                        checktype = "0";
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
            VisitExamineResponse examEntity = gson.fromJson(response.getResponseString(), VisitExamineResponse.class);
            if (examEntity.getCode() == 0) {
                List<VisitExamineResponse.DataBean.ListBean> beanList = examEntity.getData().getList();
                notShowEmpty();

                if (1 == page) {
                    if (beanList.size() > 0) {
                        adapter = new VisitExamineAdapter(this, beanList);
                        mRecycler.setAdapter(adapter);
                        adapter.setOnItemClickListener(new VisitExamineAdapter.OnItemClickListener() {
                            @Override
                            public void onClick(String str1, String str2) {
                                startActivityForResult(new Intent(VisitExamineActivity.this, AddVisitRecordActivity.class).putExtra("hfzt", str1).putExtra("id", str2), REQUEST_CODE);
                            }
                        });

                    } else {
                        showEmpty();
                    }
                } else if (1 < page) {
                    if (0 == beanList.size()) {
                        showToast("没有更多数据了~");
                    } else {
                        adapter.refresh(beanList);
                    }
                }

                if (mRecycler.isLoadMore() || mRecycler.isRefresh()) {
                    mRecycler.setPullLoadMoreCompleted();
                }
            }else {
                showToast(examEntity.getMessage());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                getData();
            }
        }
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
