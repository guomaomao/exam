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
import com.seatrend.exam.adapter.RoomExamAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 考场检查
 */
public class RoomExamActivity extends BaseActivity implements GetView, PullLoadMoreRecyclerView.PullLoadMoreListener {

    @BindView(R.id.m_recycler)
    PullLoadMoreRecyclerView mRecycler;
    @BindView(R.id.m_ll_header)
    LinearLayout mLlHeader;
    @BindView(R.id.m_bg)
    View mBg;

    private GetPresenter presenter;

    private PopupWindow mWindow;
    private String checktype = "";
    private String checktime = Constants.ksrq;
    private int cbData;
    private int cbType;
    private String type;
    private int page = 1;
    private RoomExamAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.activity_recycler;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new GetPresenter(this);

        setTitle("考场检查");
        setRight("筛选");

        mRecycler.setLinearLayout();
        mRecycler.setPushRefreshEnable(true);
        mRecycler.setPullRefreshEnable(true);
        mRecycler.setOnPullLoadMoreListener(this);

        type = intent.getStringExtra("type");

        getData();

    }

    private void getData() {
        mLoading.show();
        Map<String, String> map = new HashMap<>();
        map.put("checktime", checktime);
        map.put("checktype", checktype);
        map.put("curPage", String.valueOf(page));
        map.put("pageSize", "10");
        if ("mine".equals(type) && "2".equals(Constants.ssjs)) {
            map.put("checkerId", Constants.sfzmhm);
        }
        presenter.doNetworkTask(map, Constants.EXAM_CHECK_PAGES);
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

        View view = LayoutInflater.from(this).inflate(R.layout.item_popup_room_exam_select, null);
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
        RadioButton mRbBefore = view.findViewById(R.id.m_rb_before);
        RadioButton mRbBetween = view.findViewById(R.id.m_rb_between);
        RadioButton mRbAfter = view.findViewById(R.id.m_rb_after);

        if (cbType == 0) {
            mRbAll.setChecked(true);
        } else if (cbType == 1) {
            mRbBefore.setChecked(true);
        } else if (cbType == 2) {
            mRbBetween.setChecked(true);
        } else if (cbType == 3) {
            mRbAfter.setChecked(true);
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

                    case R.id.m_rb_before:
                        checktype = "1";
                        cbType = 1;
                        break;

                    case R.id.m_rb_between:
                        checktype = "2";
                        cbType = 2;
                        break;

                    case R.id.m_rb_after:
                        checktype = "3";
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
            RoomExamResponse examEntity = gson.fromJson(response.getResponseString(), RoomExamResponse.class);
            if (examEntity.getCode() == 0) {
                List<RoomExamResponse.DataBean.ListBean> list = examEntity.getData().getList();
                notShowEmpty();
                if (1 == page) {
                    if (list.size() > 0) {
                        adapter = new RoomExamAdapter(this, list);
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
