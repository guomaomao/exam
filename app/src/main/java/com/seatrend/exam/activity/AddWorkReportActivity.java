package com.seatrend.exam.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.PostPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.UploadImageResponse;
import com.seatrend.exam.response.WorkReportResponse;
import com.seatrend.exam.utils.Utils;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.PostView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddWorkReportActivity extends BaseActivity implements PostView, GetView {

    @BindView(R.id.m_rg_category)
    RadioGroup mRgCategory;
    @BindView(R.id.m_et_content)
    EditText mEtContent;
    @BindView(R.id.m_rb_daily)
    RadioButton mRbDaily;
    @BindView(R.id.m_rb_weekly)
    RadioButton mRbWeekly;
    @BindView(R.id.m_rb_monthly)
    RadioButton mRbMonthly;
    @BindView(R.id.m_tv_num)
    TextView mTvNum;
    private String type;
    private PostPresenter presenter;
    private String isComplete;
    private GetPresenter getPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_add_work_report;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new PostPresenter(this);
        getPresenter = new GetPresenter(this);

        setTitle("添加工作报告");
        setRight("保存");

        isComplete = intent.getStringExtra("isComplete");

        if ("1".equals(isComplete)) {
            getData();
        }

        mEtContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mEtContent.getText().toString().length() > 0) {
                    mTvNum.setText(String.valueOf(mEtContent.getText().toString().length()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void getData() { //查询工作报告
        HashMap<String, String> map = new HashMap<>();
        map.put("id", Constants.yhdh);
        map.put("examSite", Constants.kcxh);
        map.put("curPage ", "1");
        map.put("pageSize ", "10");
        map.put("startTime", Constants.ksrq);
        map.put("endTime", Constants.ksrq);

        getPresenter.doNetworkTask(map, Constants.SELECT_WORK_REPORT);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick(R.id.m_tv_right)
    public void onViewClicked() {
        // 1日报 2周报 3月报
        int categoryId = mRgCategory.getCheckedRadioButtonId();
        switch (categoryId) {
            case R.id.m_rb_daily:
                type = "1";
                break;

            case R.id.m_rb_weekly:
                type = "2";
                break;

            case R.id.m_rb_monthly:
                type = "3";
                break;
        }

        String content = mEtContent.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("内容不能为空");
            return;
        }

        if (content.length() < 100) {
            showToast("工作日报不能少于100字");
            return;
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("isNewRecord", "true");
        hashMap.put("examSite", Constants.kcxh);
        hashMap.put("examSiteName", Constants.bmmc);
        hashMap.put("report", content);
        hashMap.put("reportType", type);
        hashMap.put("userId", Constants.yhdh);
        hashMap.put("userName", Constants.xm);
        hashMap.put("reportTime", Utils.getCurrTime(null));
        hashMap.put("workTime", Utils.getCurrTime(null));

        mLoading.show();
        presenter.doNetworkTask(hashMap, Constants.INSERT_WORK_REPORT);

    }

    @Override
    public void postSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            UploadImageResponse mResponse = gson.fromJson(response.getResponseString(), UploadImageResponse.class);

            showToast(mResponse.getMessage());

            if (mResponse.getCode() == 0) {
                finish();
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException" + e.getMessage());
        }
    }

    @Override
    public void postFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            WorkReportResponse entity = gson.fromJson(response.getResponseString(), WorkReportResponse.class);
            List<WorkReportResponse.DataBean.ListBean> list = entity.getData().getList();
            if (list.size() > 0) {
                WorkReportResponse.DataBean.ListBean listBean = list.get(0);
                mEtContent.setText(listBean.getReport());
                if ("1".equals(listBean.getReportType())) {
                    mRbDaily.setChecked(true);

                } else if ("2".equals(listBean.getReportType())) {
                    mRbWeekly.setChecked(true);

                } else if ("3".equals(listBean.getReportType())) {
                    mRbMonthly.setChecked(true);
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
