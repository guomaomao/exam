package com.seatrend.exam.response;

import java.util.List;

public class TaskTopResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : [{"kskm":"3","ykrs":"161","dkrs":"0","hgl":".5268"}]
     * total : 1
     * fileName : null
     */

    private boolean status;
    private int code;
    private String message;
    private int total;
    private Object fileName;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * kskm : 3
         * ykrs : 161
         * dkrs : 0
         * hgl : .5268
         */

        private String kskm;
        private String ykrs;
        private String dkrs;
        private String hgl;

        public String getKskm() {
            return kskm;
        }

        public void setKskm(String kskm) {
            this.kskm = kskm;
        }

        public String getYkrs() {
            return ykrs;
        }

        public void setYkrs(String ykrs) {
            this.ykrs = ykrs;
        }

        public String getDkrs() {
            return dkrs;
        }

        public void setDkrs(String dkrs) {
            this.dkrs = dkrs;
        }

        public String getHgl() {
            return hgl;
        }

        public void setHgl(String hgl) {
            this.hgl = hgl;
        }
    }
}
