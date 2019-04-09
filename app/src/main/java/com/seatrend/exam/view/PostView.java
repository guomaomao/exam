package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface PostView extends BaseView {
    void postSuccess(BaseResponse response);
    void postFailed(BaseResponse response);
}
