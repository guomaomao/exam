package com.seatrend.exam.presenter;

import com.seatrend.exam.module.GetModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.GetView;

import java.util.Map;

public class GetPresenter extends BasePresenter {
    private GetView mView;
    private GetModule mModule;

    public GetPresenter(GetView view) {
        super(view);
        mView = view;
        mModule = new GetModule(this);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {
        mModule.doWork(map, url);
    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mView.getSuccess(response);
        } else {
            mView.getFailed(response);
        }
    }
}
