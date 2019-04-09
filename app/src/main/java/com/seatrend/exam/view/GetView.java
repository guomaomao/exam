package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface GetView extends BaseView {
    void getSuccess(BaseResponse response);
    void getFailed(BaseResponse response);
}
