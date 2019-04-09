package com.seatrend.exam.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.RoomExamAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.PostPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.RoomExamResponse;
import com.seatrend.exam.view.PostView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddVisitRecordActivity extends BaseActivity implements PostView {

    @BindView(R.id.m_et_content)
    EditText mEtContent;
    private PostPresenter postPresenter;
    private String hfzt;
    private String id;

    @Override
    public int getLayout() {
        return R.layout.activity_visit_record;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("添加回访记录");
        setRight("保存");

        hfzt = intent.getStringExtra("hfzt");
        id = intent.getStringExtra("id");

        postPresenter = new PostPresenter(this);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @OnClick(R.id.m_tv_right)
    public void onViewClicked() {
        String trim = mEtContent.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            showToast("内容不能为空");
            return;
        }

        HashMap<String, String> map = new HashMap<>();
        if ("已回访".equals(hfzt)) {
            map.put("isVisit", "1"); //0未回访1已回访
        }else if ("未回访".equals(hfzt)) {
            map.put("isVisit", "0");
        }
        map.put("id", id);
        map.put("visitor", Constants.xm);
        map.put("visitMessage", trim);
        postPresenter.doNetworkTask(map, Constants.VISIT_RECORD_MESSAGE);

    }

    @Override
    public void postSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            CommonResponse commonResponse = gson.fromJson(response.getResponseString(), CommonResponse.class);
            showToast(commonResponse.getMessage());
            if (commonResponse.isStatus() && commonResponse.getCode() == 0) {
                setResult(RESULT_OK);
                finish();
            }

        } catch (JsonSyntaxException e) {
            showErrorDialog("JsonSyntaxException  " + e.getMessage());
        }
    }

    @Override
    public void postFailed(BaseResponse response) {
        mLoading.dismiss();
        showErrorDialog(response.getResponseString());
    }
}
