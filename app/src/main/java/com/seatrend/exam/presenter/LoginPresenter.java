package com.seatrend.exam.presenter;

import com.seatrend.exam.module.LoginModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.LoginView;

import java.util.Map;

public class LoginPresenter extends BasePresenter {
    private LoginView mLoginView;
    private LoginModule mLoginModule;

    public LoginPresenter(LoginView view) {
        super(view);
        mLoginView = view;
        mLoginModule = new LoginModule(this);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {
        mLoginModule.doWork(map, url);
    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mLoginView.loginSuccess(response);
        } else {
            mLoginView.loginFailed(response);
        }
    }
}
