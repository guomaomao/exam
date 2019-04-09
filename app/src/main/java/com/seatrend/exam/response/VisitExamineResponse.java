package com.seatrend.exam.response;

import java.util.List;

public class VisitExamineResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"pageNo":1,"pageSize":10,"count":3,"list":[{"id":"c1901d01eb9d4f21b528ab3cf855a37b","ksxh":"17510005180613075579","ksrq":1550505600000,"kcxh":"51000746","kcdm":"51014C","kskm":"科目三","xm":"赵成哲","sfzmhm":"511526200005180724","lxdh":"18308322054","myd":"不满意","yjjy":"答案设置3,答案设置7,考试设备性能","pjsj":1538273998000,"gxsj":1548059830000,"hfzt":"已回访","hfr":"中丁","visitRecordMessages":[{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"监管中心","visitMessage":"地覆天翻","visitTime":1548059830000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123123","visitTime":1539758630000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123213","visitTime":1539758609000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"中丁","visitMessage":"回复完美","visitTime":1539755269000}]},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","ksxh":"2018070511125874","ksrq":1530720000000,"kcxh":"51000915","kcdm":"51011P","kskm":"科目一","xm":"邓琴","sfzmhm":"510104200001124863","lxdh":"13255555555","myd":"很满意","yjjy":"--","pjsj":1539941500000,"gxsj":1548059809000,"hfzt":"已回访","hfr":null,"visitRecordMessages":[{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"监管中心","visitMessage":"hhj","visitTime":1548059809000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"系统管理员","visitMessage":"哈哈哈哈","visitTime":1541488454000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"已经回访过了。","visitTime":1541140705000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"胡明明","visitTime":1541052689000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"兔兔我我","visitTime":1541051170000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":null,"visitTime":1541051127000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":null,"visitTime":1541050768000}]},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","ksxh":"17510005180628216322","ksrq":1550505600000,"kcxh":"51000162","kcdm":"510114","kskm":"科目二","xm":"徐美雄","sfzmhm":"511011198412188019","lxdh":"18408248884","myd":"不满意","yjjy":null,"pjsj":1538208798000,"gxsj":1539754662000,"hfzt":"已回访","hfr":"系统管理员","visitRecordMessages":[{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"123123","visitTime":1538289866000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"123","visitTime":1538289847000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"231321","visitTime":1538289487000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"我选择","visitTime":1538274345000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"我选择","visitTime":1538274345000}]}],"orderDirection":""}
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
         * pageNo : 1
         * pageSize : 10
         * count : 3
         * list : [{"id":"c1901d01eb9d4f21b528ab3cf855a37b","ksxh":"17510005180613075579","ksrq":1550505600000,"kcxh":"51000746","kcdm":"51014C","kskm":"科目三","xm":"赵成哲","sfzmhm":"511526200005180724","lxdh":"18308322054","myd":"不满意","yjjy":"答案设置3,答案设置7,考试设备性能","pjsj":1538273998000,"gxsj":1548059830000,"hfzt":"已回访","hfr":"中丁","visitRecordMessages":[{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"监管中心","visitMessage":"地覆天翻","visitTime":1548059830000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123123","visitTime":1539758630000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123213","visitTime":1539758609000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"中丁","visitMessage":"回复完美","visitTime":1539755269000}]},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","ksxh":"2018070511125874","ksrq":1530720000000,"kcxh":"51000915","kcdm":"51011P","kskm":"科目一","xm":"邓琴","sfzmhm":"510104200001124863","lxdh":"13255555555","myd":"很满意","yjjy":"--","pjsj":1539941500000,"gxsj":1548059809000,"hfzt":"已回访","hfr":null,"visitRecordMessages":[{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"监管中心","visitMessage":"hhj","visitTime":1548059809000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"系统管理员","visitMessage":"哈哈哈哈","visitTime":1541488454000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"已经回访过了。","visitTime":1541140705000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"胡明明","visitTime":1541052689000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":"兔兔我我","visitTime":1541051170000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":null,"visitTime":1541051127000},{"id":"2a45bdeb7fdf4f58b73b6d27a8c189a1","isVisit":"1","visitor":"4123","visitMessage":null,"visitTime":1541050768000}]},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","ksxh":"17510005180628216322","ksrq":1550505600000,"kcxh":"51000162","kcdm":"510114","kskm":"科目二","xm":"徐美雄","sfzmhm":"511011198412188019","lxdh":"18408248884","myd":"不满意","yjjy":null,"pjsj":1538208798000,"gxsj":1539754662000,"hfzt":"已回访","hfr":"系统管理员","visitRecordMessages":[{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"123123","visitTime":1538289866000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"123","visitTime":1538289847000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"231321","visitTime":1538289487000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"我选择","visitTime":1538274345000},{"id":"613a6a3d3a074e6ebcd4aca76e6737ad","isVisit":"1","visitor":"系统管理员","visitMessage":"我选择","visitTime":1538274345000}]}]
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
             * id : c1901d01eb9d4f21b528ab3cf855a37b
             * ksxh : 17510005180613075579
             * ksrq : 1550505600000
             * kcxh : 51000746
             * kcdm : 51014C
             * kskm : 科目三
             * xm : 赵成哲
             * sfzmhm : 511526200005180724
             * lxdh : 18308322054
             * myd : 不满意
             * yjjy : 答案设置3,答案设置7,考试设备性能
             * pjsj : 1538273998000
             * gxsj : 1548059830000
             * hfzt : 已回访
             * hfr : 中丁
             * visitRecordMessages : [{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"监管中心","visitMessage":"地覆天翻","visitTime":1548059830000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123123","visitTime":1539758630000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"系统管理员","visitMessage":"123213","visitTime":1539758609000},{"id":"c1901d01eb9d4f21b528ab3cf855a37b","isVisit":"1","visitor":"中丁","visitMessage":"回复完美","visitTime":1539755269000}]
             */

            private String id;
            private String ksxh;
            private long ksrq;
            private String kcxh;
            private String kcdm;
            private String kskm;
            private String xm;
            private String sfzmhm;
            private String lxdh;
            private String myd;
            private String yjjy;
            private long pjsj;
            private long gxsj;
            private String hfzt;
            private String hfr;
            private List<VisitRecordMessagesBean> visitRecordMessages;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getKsxh() {
                return ksxh;
            }

            public void setKsxh(String ksxh) {
                this.ksxh = ksxh;
            }

            public long getKsrq() {
                return ksrq;
            }

            public void setKsrq(long ksrq) {
                this.ksrq = ksrq;
            }

            public String getKcxh() {
                return kcxh;
            }

            public void setKcxh(String kcxh) {
                this.kcxh = kcxh;
            }

            public String getKcdm() {
                return kcdm;
            }

            public void setKcdm(String kcdm) {
                this.kcdm = kcdm;
            }

            public String getKskm() {
                return kskm;
            }

            public void setKskm(String kskm) {
                this.kskm = kskm;
            }

            public String getXm() {
                return xm;
            }

            public void setXm(String xm) {
                this.xm = xm;
            }

            public String getSfzmhm() {
                return sfzmhm;
            }

            public void setSfzmhm(String sfzmhm) {
                this.sfzmhm = sfzmhm;
            }

            public String getLxdh() {
                return lxdh;
            }

            public void setLxdh(String lxdh) {
                this.lxdh = lxdh;
            }

            public String getMyd() {
                return myd;
            }

            public void setMyd(String myd) {
                this.myd = myd;
            }

            public String getYjjy() {
                return yjjy;
            }

            public void setYjjy(String yjjy) {
                this.yjjy = yjjy;
            }

            public long getPjsj() {
                return pjsj;
            }

            public void setPjsj(long pjsj) {
                this.pjsj = pjsj;
            }

            public long getGxsj() {
                return gxsj;
            }

            public void setGxsj(long gxsj) {
                this.gxsj = gxsj;
            }

            public String getHfzt() {
                return hfzt;
            }

            public void setHfzt(String hfzt) {
                this.hfzt = hfzt;
            }

            public String getHfr() {
                return hfr;
            }

            public void setHfr(String hfr) {
                this.hfr = hfr;
            }

            public List<VisitRecordMessagesBean> getVisitRecordMessages() {
                return visitRecordMessages;
            }

            public void setVisitRecordMessages(List<VisitRecordMessagesBean> visitRecordMessages) {
                this.visitRecordMessages = visitRecordMessages;
            }

            public static class VisitRecordMessagesBean {
                /**
                 * id : c1901d01eb9d4f21b528ab3cf855a37b
                 * isVisit : 1
                 * visitor : 监管中心
                 * visitMessage : 地覆天翻
                 * visitTime : 1548059830000
                 */

                private String id;
                private String isVisit;
                private String visitor;
                private String visitMessage;
                private long visitTime;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getIsVisit() {
                    return isVisit;
                }

                public void setIsVisit(String isVisit) {
                    this.isVisit = isVisit;
                }

                public String getVisitor() {
                    return visitor;
                }

                public void setVisitor(String visitor) {
                    this.visitor = visitor;
                }

                public String getVisitMessage() {
                    return visitMessage;
                }

                public void setVisitMessage(String visitMessage) {
                    this.visitMessage = visitMessage;
                }

                public long getVisitTime() {
                    return visitTime;
                }

                public void setVisitTime(long visitTime) {
                    this.visitTime = visitTime;
                }
            }
        }
    }
}
