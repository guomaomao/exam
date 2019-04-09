package com.seatrend.exam.response;

import java.util.List;

public class WorkReportResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"pageNo":1,"pageSize":5,"count":2,"list":[{"id":"8562323151345664","examSite":"51000592","examSiteName":"雅安支队宝兴考场","report":"电话呢都很想你奖学金大家看大口大口","reportType":"2","userId":"zhujiye","userName":"朱继业","reportTime":1550136340000,"workTime":1550073600000},{"id":"8562294864533504","examSite":"51000592","examSiteName":"雅安支队宝兴考场","report":"还好还好哈好好的哈华东交大经济学家新锦江大酒店基督教","reportType":"1","userId":"zhujiye","userName":"朱继业","reportTime":1550135477000,"workTime":1550073600000}],"orderDirection":""}
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
         * pageNo : 1
         * pageSize : 5
         * count : 2
         * list : [{"id":"8562323151345664","examSite":"51000592","examSiteName":"雅安支队宝兴考场","report":"电话呢都很想你奖学金大家看大口大口","reportType":"2","userId":"zhujiye","userName":"朱继业","reportTime":1550136340000,"workTime":1550073600000},{"id":"8562294864533504","examSite":"51000592","examSiteName":"雅安支队宝兴考场","report":"还好还好哈好好的哈华东交大经济学家新锦江大酒店基督教","reportType":"1","userId":"zhujiye","userName":"朱继业","reportTime":1550135477000,"workTime":1550073600000}]
         * orderDirection :
         */

        private int pageNo;
        private int pageSize;
        private int count;
        private String orderDirection;
        private List<ListBean> list;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getOrderDirection() {
            return orderDirection;
        }

        public void setOrderDirection(String orderDirection) {
            this.orderDirection = orderDirection;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 8562323151345664
             * examSite : 51000592
             * examSiteName : 雅安支队宝兴考场
             * report : 电话呢都很想你奖学金大家看大口大口
             * reportType : 2
             * userId : zhujiye
             * userName : 朱继业
             * reportTime : 1550136340000
             * workTime : 1550073600000
             */

            private String id;
            private String examSite;
            private String examSiteName;
            private String report;
            private String reportType;
            private String userId;
            private String userName;
            private long reportTime;
            private long workTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getExamSite() {
                return examSite;
            }

            public void setExamSite(String examSite) {
                this.examSite = examSite;
            }

            public String getExamSiteName() {
                return examSiteName;
            }

            public void setExamSiteName(String examSiteName) {
                this.examSiteName = examSiteName;
            }

            public String getReport() {
                return report;
            }

            public void setReport(String report) {
                this.report = report;
            }

            public String getReportType() {
                return reportType;
            }

            public void setReportType(String reportType) {
                this.reportType = reportType;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public long getReportTime() {
                return reportTime;
            }

            public void setReportTime(long reportTime) {
                this.reportTime = reportTime;
            }

            public long getWorkTime() {
                return workTime;
            }

            public void setWorkTime(long workTime) {
                this.workTime = workTime;
            }
        }
    }
}
