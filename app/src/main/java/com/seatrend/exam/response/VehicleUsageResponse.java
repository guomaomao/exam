package com.seatrend.exam.response;

import java.io.Serializable;
import java.util.List;

public class VehicleUsageResponse extends BaseResponse implements Serializable {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"pageNo":1,"pageSize":3,"count":1,"list":[{"xh":"51001561","hpzl":"教练汽车","hphm":"川T0617","syzjcx":"C1","cllx":"K33","clpp":"东风雪铁龙牌 DC7160LYBM","ccdjrq":1436716800000,"qzbfqz":1752336000000,"fzjg":"四川省雅安地区公安局交通警察支队车辆管理所","zt":"正常","ksczt":"取消考试","ztyy":null,"yjbj":"1","kscly":"1","jxxh":"51000059","jbr":"杨帆","shbj":"1","shr":"舒健","shsj":1514273748000,"bj":"1","csbj":"0","bjcsbj":"0","cjsj":1437530306000,"gxsj":1514278825000,"jyw":"1A45881C67FCB86C4DE0EEBD30D3EEDD6281EEE805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E8","ipdz":null,"czzdcs":null,"czzdxh":null,"czzdbh":null,"czzdmac":null,"czzdip":null,"czzddk":"6666","czzdms":null,"gkjcs":null,"gkjxh":null,"gkjbh":null,"gkjmac":null,"gkjdk":"8888","gkjms":null,"jtbbh":null,"jdcxh":"51310015429787","kcbaxh":"51000532","czzdwg":null,"clbh":null,"resDrvExamVehicleModel":null}],"orderDirection":""}
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

    public static class DataBean implements Serializable {
        /**
         * pageNo : 1
         * pageSize : 3
         * count : 1
         * list : [{"xh":"51001561","hpzl":"教练汽车","hphm":"川T0617","syzjcx":"C1","cllx":"K33","clpp":"东风雪铁龙牌 DC7160LYBM","ccdjrq":1436716800000,"qzbfqz":1752336000000,"fzjg":"四川省雅安地区公安局交通警察支队车辆管理所","zt":"正常","ksczt":"取消考试","ztyy":null,"yjbj":"1","kscly":"1","jxxh":"51000059","jbr":"杨帆","shbj":"1","shr":"舒健","shsj":1514273748000,"bj":"1","csbj":"0","bjcsbj":"0","cjsj":1437530306000,"gxsj":1514278825000,"jyw":"1A45881C67FCB86C4DE0EEBD30D3EEDD6281EEE805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E8","ipdz":null,"czzdcs":null,"czzdxh":null,"czzdbh":null,"czzdmac":null,"czzdip":null,"czzddk":"6666","czzdms":null,"gkjcs":null,"gkjxh":null,"gkjbh":null,"gkjmac":null,"gkjdk":"8888","gkjms":null,"jtbbh":null,"jdcxh":"51310015429787","kcbaxh":"51000532","czzdwg":null,"clbh":null,"resDrvExamVehicleModel":null}]
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

        public static class ListBean implements Serializable {
            /**
             * xh : 51001561
             * hpzl : 教练汽车
             * hphm : 川T0617
             * syzjcx : C1
             * cllx : K33
             * clpp : 东风雪铁龙牌 DC7160LYBM
             * ccdjrq : 1436716800000
             * qzbfqz : 1752336000000
             * fzjg : 四川省雅安地区公安局交通警察支队车辆管理所
             * zt : 正常
             * ksczt : 取消考试
             * ztyy : null
             * yjbj : 1
             * kscly : 1
             * jxxh : 51000059
             * jbr : 杨帆
             * shbj : 1
             * shr : 舒健
             * shsj : 1514273748000
             * bj : 1
             * csbj : 0
             * bjcsbj : 0
             * cjsj : 1437530306000
             * gxsj : 1514278825000
             * jyw : 1A45881C67FCB86C4DE0EEBD30D3EEDD6281EEE805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E8
             * ipdz : null
             * czzdcs : null
             * czzdxh : null
             * czzdbh : null
             * czzdmac : null
             * czzdip : null
             * czzddk : 6666
             * czzdms : null
             * gkjcs : null
             * gkjxh : null
             * gkjbh : null
             * gkjmac : null
             * gkjdk : 8888
             * gkjms : null
             * jtbbh : null
             * jdcxh : 51310015429787
             * kcbaxh : 51000532
             * czzdwg : null
             * clbh : null
             * resDrvExamVehicleModel : null
             */

            private String xh;
            private String hpzl;
            private String hphm;
            private String syzjcx;
            private String cllx;
            private String clpp;
            private long ccdjrq;
            private long qzbfqz;
            private String fzjg;
            private String zt;
            private String ksczt;
            private Object ztyy;
            private String yjbj;
            private String kscly;
            private String jxxh;
            private String jbr;
            private String shbj;
            private String shr;
            private long shsj;
            private String bj;
            private String csbj;
            private String bjcsbj;
            private long cjsj;
            private long gxsj;
            private String jyw;
            private Object ipdz;
            private Object czzdcs;
            private Object czzdxh;
            private Object czzdbh;
            private Object czzdmac;
            private Object czzdip;
            private String czzddk;
            private Object czzdms;
            private Object gkjcs;
            private Object gkjxh;
            private Object gkjbh;
            private Object gkjmac;
            private String gkjdk;
            private Object gkjms;
            private Object jtbbh;
            private String jdcxh;
            private String kcbaxh;
            private Object czzdwg;
            private Object clbh;
            private Object resDrvExamVehicleModel;

            public String getXh() {
                return xh;
            }

            public void setXh(String xh) {
                this.xh = xh;
            }

            public String getHpzl() {
                return hpzl;
            }

            public void setHpzl(String hpzl) {
                this.hpzl = hpzl;
            }

            public String getHphm() {
                return hphm;
            }

            public void setHphm(String hphm) {
                this.hphm = hphm;
            }

            public String getSyzjcx() {
                return syzjcx;
            }

            public void setSyzjcx(String syzjcx) {
                this.syzjcx = syzjcx;
            }

            public String getCllx() {
                return cllx;
            }

            public void setCllx(String cllx) {
                this.cllx = cllx;
            }

            public String getClpp() {
                return clpp;
            }

            public void setClpp(String clpp) {
                this.clpp = clpp;
            }

            public long getCcdjrq() {
                return ccdjrq;
            }

            public void setCcdjrq(long ccdjrq) {
                this.ccdjrq = ccdjrq;
            }

            public long getQzbfqz() {
                return qzbfqz;
            }

            public void setQzbfqz(long qzbfqz) {
                this.qzbfqz = qzbfqz;
            }

            public String getFzjg() {
                return fzjg;
            }

            public void setFzjg(String fzjg) {
                this.fzjg = fzjg;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public String getKsczt() {
                return ksczt;
            }

            public void setKsczt(String ksczt) {
                this.ksczt = ksczt;
            }

            public Object getZtyy() {
                return ztyy;
            }

            public void setZtyy(Object ztyy) {
                this.ztyy = ztyy;
            }

            public String getYjbj() {
                return yjbj;
            }

            public void setYjbj(String yjbj) {
                this.yjbj = yjbj;
            }

            public String getKscly() {
                return kscly;
            }

            public void setKscly(String kscly) {
                this.kscly = kscly;
            }

            public String getJxxh() {
                return jxxh;
            }

            public void setJxxh(String jxxh) {
                this.jxxh = jxxh;
            }

            public String getJbr() {
                return jbr;
            }

            public void setJbr(String jbr) {
                this.jbr = jbr;
            }

            public String getShbj() {
                return shbj;
            }

            public void setShbj(String shbj) {
                this.shbj = shbj;
            }

            public String getShr() {
                return shr;
            }

            public void setShr(String shr) {
                this.shr = shr;
            }

            public long getShsj() {
                return shsj;
            }

            public void setShsj(long shsj) {
                this.shsj = shsj;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCsbj() {
                return csbj;
            }

            public void setCsbj(String csbj) {
                this.csbj = csbj;
            }

            public String getBjcsbj() {
                return bjcsbj;
            }

            public void setBjcsbj(String bjcsbj) {
                this.bjcsbj = bjcsbj;
            }

            public long getCjsj() {
                return cjsj;
            }

            public void setCjsj(long cjsj) {
                this.cjsj = cjsj;
            }

            public long getGxsj() {
                return gxsj;
            }

            public void setGxsj(long gxsj) {
                this.gxsj = gxsj;
            }

            public String getJyw() {
                return jyw;
            }

            public void setJyw(String jyw) {
                this.jyw = jyw;
            }

            public Object getIpdz() {
                return ipdz;
            }

            public void setIpdz(Object ipdz) {
                this.ipdz = ipdz;
            }

            public Object getCzzdcs() {
                return czzdcs;
            }

            public void setCzzdcs(Object czzdcs) {
                this.czzdcs = czzdcs;
            }

            public Object getCzzdxh() {
                return czzdxh;
            }

            public void setCzzdxh(Object czzdxh) {
                this.czzdxh = czzdxh;
            }

            public Object getCzzdbh() {
                return czzdbh;
            }

            public void setCzzdbh(Object czzdbh) {
                this.czzdbh = czzdbh;
            }

            public Object getCzzdmac() {
                return czzdmac;
            }

            public void setCzzdmac(Object czzdmac) {
                this.czzdmac = czzdmac;
            }

            public Object getCzzdip() {
                return czzdip;
            }

            public void setCzzdip(Object czzdip) {
                this.czzdip = czzdip;
            }

            public String getCzzddk() {
                return czzddk;
            }

            public void setCzzddk(String czzddk) {
                this.czzddk = czzddk;
            }

            public Object getCzzdms() {
                return czzdms;
            }

            public void setCzzdms(Object czzdms) {
                this.czzdms = czzdms;
            }

            public Object getGkjcs() {
                return gkjcs;
            }

            public void setGkjcs(Object gkjcs) {
                this.gkjcs = gkjcs;
            }

            public Object getGkjxh() {
                return gkjxh;
            }

            public void setGkjxh(Object gkjxh) {
                this.gkjxh = gkjxh;
            }

            public Object getGkjbh() {
                return gkjbh;
            }

            public void setGkjbh(Object gkjbh) {
                this.gkjbh = gkjbh;
            }

            public Object getGkjmac() {
                return gkjmac;
            }

            public void setGkjmac(Object gkjmac) {
                this.gkjmac = gkjmac;
            }

            public String getGkjdk() {
                return gkjdk;
            }

            public void setGkjdk(String gkjdk) {
                this.gkjdk = gkjdk;
            }

            public Object getGkjms() {
                return gkjms;
            }

            public void setGkjms(Object gkjms) {
                this.gkjms = gkjms;
            }

            public Object getJtbbh() {
                return jtbbh;
            }

            public void setJtbbh(Object jtbbh) {
                this.jtbbh = jtbbh;
            }

            public String getJdcxh() {
                return jdcxh;
            }

            public void setJdcxh(String jdcxh) {
                this.jdcxh = jdcxh;
            }

            public String getKcbaxh() {
                return kcbaxh;
            }

            public void setKcbaxh(String kcbaxh) {
                this.kcbaxh = kcbaxh;
            }

            public Object getCzzdwg() {
                return czzdwg;
            }

            public void setCzzdwg(Object czzdwg) {
                this.czzdwg = czzdwg;
            }

            public Object getClbh() {
                return clbh;
            }

            public void setClbh(Object clbh) {
                this.clbh = clbh;
            }

            public Object getResDrvExamVehicleModel() {
                return resDrvExamVehicleModel;
            }

            public void setResDrvExamVehicleModel(Object resDrvExamVehicleModel) {
                this.resDrvExamVehicleModel = resDrvExamVehicleModel;
            }
        }
    }
}
