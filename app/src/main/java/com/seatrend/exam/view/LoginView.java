package com.seatrend.exam.view;

import com.seatrend.exam.response.BaseResponse;

public interface LoginView extends BaseView {
    void loginSuccess(BaseResponse response);
    void loginFailed(BaseResponse response);
}
