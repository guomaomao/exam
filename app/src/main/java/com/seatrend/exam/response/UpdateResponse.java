package com.seatrend.exam.response;

public class UpdateResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"id":null,"pda":"5c12249bf5a8e34058c0109e","issueTime":null,"versions":"1"}
     * total : 0
     * fileName : null
     */

    private boolean status;
    private int code;
    private String message;
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * id : null
         * pda : 5c12249bf5a8e34058c0109e
         * issueTime : null
         * versions : 1
         */

        private Object id;
        private String pda;
        private Object issueTime;
        private String versions;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getPda() {
            return pda;
        }

        public void setPda(String pda) {
            this.pda = pda;
        }

        public Object getIssueTime() {
            return issueTime;
        }

        public void setIssueTime(Object issueTime) {
            this.issueTime = issueTime;
        }

        public String getVersions() {
            return versions;
        }

        public void setVersions(String versions) {
            this.versions = versions;
        }
    }
}
