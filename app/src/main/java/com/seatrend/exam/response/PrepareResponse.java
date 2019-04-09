package com.seatrend.exam.response;

import java.util.List;

public class PrepareResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"finished":0,"notFinished":3,"prepares":[{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984014848"},{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984342528"},{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984604672"}]}
     * total : 0
     * fileName : null
     */

    private boolean status;
    private int code;
    private String message;
    private DataBean data;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static class DataBean {
        /**
         * finished : 0
         * notFinished : 3
         * prepares : [{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984014848"},{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984342528"},{"examSite":"51000049","examSubject":"2","ksy":"朱建林","ksySfzmhm":"513101196502190054","confirmTime":1550549447000,"photo":"5c6b81c7cbffb21e7cae5b94","checkResult":"0","checkId":"8373587984604672"}]
         */

        private int finished;
        private int notFinished;
        private List<PreparesBean> prepares;

        public int getFinished() {
            return finished;
        }

        public void setFinished(int finished) {
            this.finished = finished;
        }

        public int getNotFinished() {
            return notFinished;
        }

        public void setNotFinished(int notFinished) {
            this.notFinished = notFinished;
        }

        public List<PreparesBean> getPrepares() {
            return prepares;
        }

        public void setPrepares(List<PreparesBean> prepares) {
            this.prepares = prepares;
        }

        public static class PreparesBean {
            /**
             * examSite : 51000049
             * examSubject : 2
             * ksy : 朱建林
             * ksySfzmhm : 513101196502190054
             * confirmTime : 1550549447000
             * photo : 5c6b81c7cbffb21e7cae5b94
             * checkResult : 0
             * checkId : 8373587984014848
             */

            private String examSite;
            private String examSubject;
            private String ksy;
            private String ksySfzmhm;
            private long confirmTime;
            private String photo;
            private String checkResult;
            private String checkId;
            private String checkState;

            public String getCheckState() {
                return checkState;
            }

            public void setCheckState(String checkState) {
                this.checkState = checkState;
            }

            public String getExamSite() {
                return examSite;
            }

            public void setExamSite(String examSite) {
                this.examSite = examSite;
            }

            public String getExamSubject() {
                return examSubject;
            }

            public void setExamSubject(String examSubject) {
                this.examSubject = examSubject;
            }

            public String getKsy() {
                return ksy;
            }

            public void setKsy(String ksy) {
                this.ksy = ksy;
            }

            public String getKsySfzmhm() {
                return ksySfzmhm;
            }

            public void setKsySfzmhm(String ksySfzmhm) {
                this.ksySfzmhm = ksySfzmhm;
            }

            public long getConfirmTime() {
                return confirmTime;
            }

            public void setConfirmTime(long confirmTime) {
                this.confirmTime = confirmTime;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getCheckResult() {
                return checkResult;
            }

            public void setCheckResult(String checkResult) {
                this.checkResult = checkResult;
            }

            public String getCheckId() {
                return checkId;
            }

            public void setCheckId(String checkId) {
                this.checkId = checkId;
            }
        }
    }
}
