package com.seatrend.exam.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.RemoteInspectionAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.view.GetView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class SecondFragment extends BaseFragment implements GetView {

    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.m_et_search_exam_room)
    EditText mEtSearchExamRoom;
    @BindView(R.id.m_iv_search_exam_room)
    ImageView mIvSearchExamRoom;
    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_ll_search)
    LinearLayout mLlSearch;

    private GetPresenter getPresenter;

    public static SecondFragment newInstance() {
        Bundle bundle = new Bundle();
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_second;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mTvTitle.setText("远程巡考");
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        getPresenter = new GetPresenter(this);

        HashMap<String, String> map = new HashMap<>();
        map.put("type", "5");
        if ("2".equals(Constants.ssjs)) {
            map.put("kcmc", Constants.kcxh);
            mLlSearch.setVisibility(View.GONE);
        }
        getPresenter.doNetworkTask(map, Constants.SELECT_EXAMINATION_SITE_CARMERA_LIST);

        init();

    }

    private void init() {
        mRecycler.setAdapter(new RemoteInspectionAdapter(getActivity(), Constants.secondData));
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            ExamRoomRemoteResponse mResponse = gson.fromJson(response.getResponseString(), ExamRoomRemoteResponse.class);
            Constants.secondData = mResponse.getData();
            init();

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
