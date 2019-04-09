package com.seatrend.exam.presenter;

import com.seatrend.exam.module.JsonModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.JsonView;

import java.util.Map;

public class JsonTypePresenter extends BasePresenter {
    private JsonView mLoginView;
    private JsonModule mLoginModule;

    public JsonTypePresenter(JsonView view) {
        super(view);
        mLoginView = view;
        mLoginModule = new JsonModule(this);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {

    }

    public void  doNetWorkTaskJson(String json, String url){
        mLoginModule.doWorkJson(json, url);
    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mLoginView.jsonSuccess(response);
        } else {
            mLoginView.jsonFailed(response);
        }
    }
}
