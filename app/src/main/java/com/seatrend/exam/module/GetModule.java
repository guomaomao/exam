package com.seatrend.exam.module;

import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.GetPresenter;
import com.seatrend.exam.response.BaseResponse;

import java.util.Map;

public class GetModule extends BaseModule {

    GetPresenter mPresenter;

    public GetModule(GetPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void doWork(Map<String, String> map, String url) {
        NetworkService.getInstance().getDataFromServer(map, url, Constants.GET, this);
    }

    @Override
    public void doWorkResults(BaseResponse response, boolean isSuccess) {
        mPresenter.requestResults(response, isSuccess);
    }
}
