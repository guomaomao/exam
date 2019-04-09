package com.seatrend.exam.response;

import java.util.List;

public class ConfigResponse extends BaseResponse {


    /**
     * status : true
     * code : 0
     * message : 成功
     * data : [{"moduleId":"0404","functionId":"02","content":"1","state":null,"describeInfo":"考试员签名是否需要现场照片 0不需要 1需要","updateTime":null}]
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
         * moduleId : 0404
         * functionId : 02
         * content : 1
         * state : null
         * describeInfo : 考试员签名是否需要现场照片 0不需要 1需要
         * updateTime : null
         */

        private String moduleId;
        private String functionId;
        private String content;
        private Object state;
        private String describeInfo;
        private Object updateTime;

        public String getModuleId() {
            return moduleId;
        }

        public void setModuleId(String moduleId) {
            this.moduleId = moduleId;
        }

        public String getFunctionId() {
            return functionId;
        }

        public void setFunctionId(String functionId) {
            this.functionId = functionId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Object getState() {
            return state;
        }

        public void setState(Object state) {
            this.state = state;
        }

        public String getDescribeInfo() {
            return describeInfo;
        }

        public void setDescribeInfo(String describeInfo) {
            this.describeInfo = describeInfo;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
