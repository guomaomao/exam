package com.seatrend.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.RemoteInspectionAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RemoteInspectionActivity extends BaseActivity implements GetView {

    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_et_search_exam_room)
    EditText mEtSearchExamRoom;
    @BindView(R.id.m_iv_search_exam_room)
    ImageView mIvSearchExamRoom;
    private GetPresenter getPresenter;
    @BindView(R.id.m_ll_search)
    LinearLayout mLlSearch;

    @Override
    public int getLayout() {
        return R.layout.activity_remote_inspection;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("远程巡考");
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        getPresenter = new GetPresenter(this);

        HashMap<String, String> map = new HashMap<>();
        map.put("type", "5");
        if ("2".equals(Constants.ssjs)) {
            map.put("kcmc", Constants.kcxh);
            mLlSearch.setVisibility(View.GONE);

        }
        mLoading.show();
        getPresenter.doNetworkTask(map, Constants.SELECT_EXAMINATION_SITE_CARMERA_LIST);

    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            ExamRoomRemoteResponse mResponse = gson.fromJson(response.getResponseString(), ExamRoomRemoteResponse.class);
            List<ExamRoomRemoteResponse.DataBean> data = mResponse.getData();

            if (data.size() > 0) {
                mRecycler.setAdapter(new RemoteInspectionAdapter(this, data));
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

    @OnClick(R.id.m_iv_search_exam_room)
    public void onViewClicked() {
        String examRoom = mEtSearchExamRoom.getText().toString().trim();

        HashMap<String, String> map = new HashMap<>();
        map.put("type", "5");
        map.put("kcmc", examRoom);

        getPresenter.doNetworkTask(map, Constants.SELECT_EXAMINATION_SITE_CARMERA_LIST);
    }
}
