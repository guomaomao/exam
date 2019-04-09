package com.seatrend.exam.response;

public class BaseResponse {

    public String url; //接口
    public String responseString; //响应信息

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }
}
