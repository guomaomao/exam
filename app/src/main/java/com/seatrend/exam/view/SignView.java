package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface SignView extends BaseView {
    void success(BaseResponse response);
    void failed(BaseResponse response);
}
