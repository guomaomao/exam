package com.seatrend.exam.response;

public class CommonResponse extends BaseResponse {


    /**
     * status : true
     * code : 0
     * message : 成功
     * data : no content
     * total : 0
     * fileName : null
     */

    private boolean status;
    private int code;
    private String message;
    private String data;
    private int total;
    private Object fileName;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getFileName() {
        return fileName;
    }

    public void setFileName(Object fileName) {
        this.fileName = fileName;
    }
}
