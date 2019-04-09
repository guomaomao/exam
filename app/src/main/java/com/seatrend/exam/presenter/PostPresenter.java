package com.seatrend.exam.presenter;

import com.seatrend.exam.module.PostModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.PostView;

import java.util.Map;

public class PostPresenter extends BasePresenter {
    private PostView mView;
    private PostModule mModule;

    public PostPresenter(PostView view) {
        super(view);
        mView = view;
        mModule = new PostModule(this);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {
        mModule.doWork(map, url);
    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mView.postSuccess(response);
        } else {
            mView.postFailed(response);
        }
    }
}
