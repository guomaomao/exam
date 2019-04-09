package com.seatrend.exam.module;

import com.seatrend.exam.common.Constants;
import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.LoginPresenter;
import com.seatrend.exam.response.BaseResponse;

import java.util.Map;

public class LoginModule extends BaseModule {

    LoginPresenter mLoginPresenter;

    public LoginModule(LoginPresenter mLoginPresenter) {
        this.mLoginPresenter = mLoginPresenter;
    }

    @Override
    public void doWork(Map<String, String> map, String url) {
        if (url.equals(Constants.USER_LOGIN)) {
            NetworkService.getInstance().getDataFromServer(map, url, Constants.POST, this);
        } else {
            NetworkService.getInstance().getDataFromServer(map, url, Constants.GET, this);
        }
    }

    @Override
    public void doWorkResults(BaseResponse response, boolean isSuccess) {
        mLoginPresenter.requestResults(response, isSuccess);
    }
}
