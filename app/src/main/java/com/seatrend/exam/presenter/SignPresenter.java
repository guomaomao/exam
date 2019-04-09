package com.seatrend.exam.presenter;

import com.seatrend.exam.module.SignModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.LoginView;
import com.seatrend.exam.view.SignView;

import java.util.Map;

public class SignPresenter extends BasePresenter {
    private SignView mSignView;
    private SignModule mSignModule;

    public SignPresenter(SignView view) {
        super(view);
        mSignView = view;
        mSignModule = new SignModule(this);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {
        mSignModule.doWork(map, url);
    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mSignView.success(response);
        } else {
            mSignView.failed(response);
        }
    }
}
