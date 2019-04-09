package com.seatrend.exam.presenter;

import com.seatrend.exam.module.UploadImageModule;
import com.seatrend.exam.response.BaseResponse;
import com.seatrend.exam.view.UploadImageView;

import java.io.File;
import java.util.Map;

public class UploadImagePresenter extends BasePresenter {
    private UploadImageView mView;
    private UploadImageModule mModule;

    public UploadImagePresenter(UploadImageView view) {
        super(view);
        mView = view;
        mModule = new UploadImageModule(this);
    }

    public void uploadFile(String url, File file, String type) {
        mModule.uploadFile(url, file, type);
    }

    @Override
    public void doNetworkTask(Map<String, String> map, String url) {

    }

    @Override
    public void requestResults(BaseResponse response, boolean isSuccess) {
        if (isSuccess) {
            mView.uploadImageSuccess(response);
        } else {
            mView.uploadImageFailed(response);
        }
    }
}
