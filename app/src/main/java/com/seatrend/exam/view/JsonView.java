package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface JsonView extends BaseView {
    void jsonSuccess(BaseResponse response);
    void jsonFailed(BaseResponse response);
}
