package com.seatrend.exam.response;

public class UploadImageResponse {


    /**
     * status : true
     * code : 0
     * message : 成功
     * data : 5c64f473cbffb206581851c7
     * total : 0
     * fileName : 2019_02_14_12_54_03.jpg
     */

    private boolean status;
    private int code;
    private String message;
    private String data;
    private int total;
    private String fileName;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
