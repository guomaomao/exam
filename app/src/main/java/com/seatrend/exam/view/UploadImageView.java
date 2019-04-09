package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface UploadImageView extends BaseView {
    void uploadImageSuccess(BaseResponse response);
    void uploadImageFailed(BaseResponse response);
}
