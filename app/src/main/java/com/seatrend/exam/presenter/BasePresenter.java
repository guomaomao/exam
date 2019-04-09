package com.seatrend.exam.presenter;

import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.BaseView;

import java.util.Map;

public abstract class BasePresenter {
    public BaseView mView;
    public BasePresenter(BaseView view){
        mView=view;
    }
    public abstract void doNetworkTask(Map<String,String> map, String url);
    public abstract void requestResults(BaseResponse response, boolean isSuccess);

}
