package com.seatrend.exam.module;

import com.seatrend.exam.response.BaseResponse;

import java.util.Map;

public abstract class BaseModule {

    public abstract void doWork(Map<String,String> map , String url);
    public abstract void doWorkResults(BaseResponse response, boolean isSuccess);

}
