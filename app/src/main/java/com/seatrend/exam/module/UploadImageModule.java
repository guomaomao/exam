package com.seatrend.exam.module;

import com.seatrend.exam.network.NetworkService;
import com.seatrend.exam.presenter.UploadImagePresenter;
import com.seatrend.exam.response.BaseResponse;

import java.io.File;
import java.util.Map;

public class UploadImageModule extends BaseModule {

    UploadImagePresenter mPresenter;

    public UploadImageModule(UploadImagePresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void doWork(Map<String, String> map, String url) {

    }

    @Override
    public void doWorkResults(BaseResponse response, boolean isSuccess) {
        mPresenter.requestResults(response, isSuccess);
    }

    public void uploadFile(String url, File file, String type) {
        NetworkService.getInstance().uploadFileToServer(url, file, type, this);
    }

}
