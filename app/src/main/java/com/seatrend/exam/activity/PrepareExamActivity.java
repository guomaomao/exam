package com.seatrend.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonSyntaxException;
import com.seatrend.exam.R;
import com.seatrend.exam.adapter.PrepareAdapter;
import com.seatrend.exam.common.Constants;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.presenter.PostPresenter;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.response.CommonResponse;
import com.seatrend.exam.response.PrepareResponse;
import com.seatrend.exam.view.GetView;
import com.seatrend.exam.view.PostView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class PrepareExamActivity extends BaseActivity implements GetView, PostView {

    @BindView(R.id.m_recycler)
    RecyclerView mRecycler;
    @BindView(R.id.m_tv_completed)
    TextView mTvCompleted;
    @BindView(R.id.m_tv_incomplete)
    TextView mTvIncomplete;
    @BindView(R.id.m_ll_top)
    LinearLayout mLLTop;

    private GetPresenter presenter;
    private PostPresenter postPresenter;
    private PrepareAdapter adapter;
    private int mPosition;
    private PrepareResponse.DataBean data;

    @Override
    public int getLayout() {
        return R.layout.activity_prepare_exam;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        presenter = new GetPresenter(this);
        postPresenter = new PostPresenter(this);

        setTitle("考前准备");

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        getData();

    }

    private void getData() {
        mLoading.show();
        Map<String, String> map = new HashMap<>();
//        map.put("kcxh", Constants.kcxh);
        presenter.doNetworkTask(map, Constants.EXAM_PREPARE_STATUS);
    }

    @Override
    public int setBarColor() {
        return R.color.blue;
    }

    @Override
    public void getSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            PrepareResponse mResponse = gson.fromJson(response.getResponseString(), PrepareResponse.class);
            data = mResponse.getData();
            if (data != null) {
                mLLTop.setVisibility(View.VISIBLE);
                notShowEmpty();

                mTvCompleted.setText(String.valueOf(data.getFinished()));
                mTvIncomplete.setText(String.valueOf(data.getNotFinished()));

                List<PrepareResponse.DataBean.PreparesBean> prepares = data.getPrepares();

                if (prepares != null && prepares.size() > 0) {
                    adapter = new PrepareAdapter(PrepareExamActivity.this, prepares);
                    mRecycler.setAdapter(adapter);
                    adapter.setOnItemClickListener(new PrepareAdapter.OnItemClickListener() {
                        @Override
                        public void onClick(int position, String id) {
                            mPosition = position;

                            HashMap<String, String> map = new HashMap<>();
                            map.put("id", id);
                            mLoading.show();
                            postPresenter.doNetworkTask(map, Constants.START_EXAM);
                        }
                    });
                } else {
                    mLLTop.setVisibility(View.GONE);
                    showEmpty();
                }
            } else {
                mLLTop.setVisibility(View.GONE);
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

    @Override
    public void postSuccess(BaseResponse response) {
        try {
            mLoading.dismiss();
            CommonResponse baseEntity = gson.fromJson(response.getResponseString(), CommonResponse.class);
            showToast(baseEntity.getMessage());
            if (baseEntity.isStatus() && baseEntity.getCode() == 0) {
                if (data != null) {
                    List<PrepareResponse.DataBean.PreparesBean> prepares = data.getPrepares();
                    prepares.get(mPosition).setCheckState("2");
                    adapter.setData(mPosition, prepares);
                }
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
