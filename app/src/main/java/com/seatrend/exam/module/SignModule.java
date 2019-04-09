package com.seatrend.exam.module;

import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.LoginPresenter;
import com.seatrend.exam.presenter.SignPresenter;
import com.seatrend.exam.response.BaseResponse;

import java.util.Map;

public class SignModule extends BaseModule {

    SignPresenter mSignPresenter;

    public SignModule(SignPresenter mSignPresenter) {
        this.mSignPresenter = mSignPresenter;
    }

    @Override
    public void doWork(Map<String, String> map, String url) {
        NetworkService.getInstance().getDataFromServer(map, url, Constants.POST, this);
    }

    @Override
    public void doWorkResults(BaseResponse response, boolean isSuccess) {
        mSignPresenter.requestResults(response, isSuccess);
    }
}
