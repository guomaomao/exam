package com.seatrend.exam.module;

import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.JsonTypePresenter;
import com.seatrend.exam.presenter.PostPresenter;
import com.seatrend.exam.response.BaseResponse;

import java.util.Map;

public class JsonModule extends BaseModule {

    JsonTypePresenter mPresenter;

    public JsonModule(JsonTypePresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void doWork(Map<String, String> map, String url) {
        NetworkService.getInstance().getDataFromServer(map, url, Constants.POST, this);
    }

    public void doWorkJson(String json, String url) {
        NetworkService.getInstance().getDataFromServerByJson(json, url, this);
    }

    @Override
    public void doWorkResults(BaseResponse response, boolean isSuccess) {
        mPresenter.requestResults(response, isSuccess);
    }
}
