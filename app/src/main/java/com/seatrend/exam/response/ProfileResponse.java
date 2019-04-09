package com.seatrend.exam.response;

public class ProfileResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"xh":"51000231","sszd":"川T","glbm":"雅安交警支队车管所","sfzmhm":"513101196502190054","xm":"朱继业","xb":"1","csrq":-153561600000,"zkcx":"A1A2D","fzrq":1477843200000,"kszyxqz":1572451200000,"kszzt":"A","gzdw":"雅安市交通警察支队","jbr":"杨帆","fzjg":"川T","jyw":"054BB11755FCEEBF4CFCF6A130D1EE8D55DC928D05B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E8","cjsj":1248019200000,"gxsj":1481695486000,"bz":null,"ksydm":"10231","sfzmmc":"A","dabh":"513100010071","csbj":"0","bj":"2","bjcsbj":"1","ztyy":null,"yjbj":null,"rylb":null,"rysf":null,"sjhm":null,"zslx":null,"zsbh":null,"gwlx":"1","jh":null,"examInvigilatorEducation":null,"examInvigilatorTrain":null}
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
         * xh : 51000231
         * sszd : 川T
         * glbm : 雅安交警支队车管所
         * sfzmhm : 513101196502190054
         * xm : 朱继业
         * xb : 1
         * csrq : -153561600000
         * zkcx : A1A2D
         * fzrq : 1477843200000
         * kszyxqz : 1572451200000
         * kszzt : A
         * gzdw : 雅安市交通警察支队
         * jbr : 杨帆
         * fzjg : 川T
         * jyw : 054BB11755FCEEBF4CFCF6A130D1EE8D55DC928D05B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E805B4A7E8
         * cjsj : 1248019200000
         * gxsj : 1481695486000
         * bz : null
         * ksydm : 10231
         * sfzmmc : A
         * dabh : 513100010071
         * csbj : 0
         * bj : 2
         * bjcsbj : 1
         * ztyy : null
         * yjbj : null
         * rylb : null
         * rysf : null
         * sjhm : null
         * zslx : null
         * zsbh : null
         * gwlx : 1
         * jh : null
         * examInvigilatorEducation : null
         * examInvigilatorTrain : null
         */

        private String xh;
        private String sszd;
        private String glbm;
        private String sfzmhm;
        private String xm;
        private String xb;
        private long csrq;
        private String zkcx;
        private long fzrq;
        private long kszyxqz;
        private String kszzt;
        private String gzdw;
        private String jbr;
        private String fzjg;
        private String jyw;
        private long cjsj;
        private long gxsj;
        private Object bz;
        private String ksydm;
        private String sfzmmc;
        private String dabh;
        private String csbj;
        private String bj;
        private String bjcsbj;
        private Object ztyy;
        private Object yjbj;
        private Object rylb;
        private Object rysf;
        private Object sjhm;
        private Object zslx;
        private Object zsbh;
        private String gwlx;
        private String jh;
        private Object examInvigilatorEducation;
        private Object examInvigilatorTrain;

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getSszd() {
            return sszd;
        }

        public void setSszd(String sszd) {
            this.sszd = sszd;
        }

        public String getGlbm() {
            return glbm;
        }

        public void setGlbm(String glbm) {
            this.glbm = glbm;
        }

        public String getSfzmhm() {
            return sfzmhm;
        }

        public void setSfzmhm(String sfzmhm) {
            this.sfzmhm = sfzmhm;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public long getCsrq() {
            return csrq;
        }

        public void setCsrq(long csrq) {
            this.csrq = csrq;
        }

        public String getZkcx() {
            return zkcx;
        }

        public void setZkcx(String zkcx) {
            this.zkcx = zkcx;
        }

        public long getFzrq() {
            return fzrq;
        }

        public void setFzrq(long fzrq) {
            this.fzrq = fzrq;
        }

        public long getKszyxqz() {
            return kszyxqz;
        }

        public void setKszyxqz(long kszyxqz) {
            this.kszyxqz = kszyxqz;
        }

        public String getKszzt() {
            return kszzt;
        }

        public void setKszzt(String kszzt) {
            this.kszzt = kszzt;
        }

        public String getGzdw() {
            return gzdw;
        }

        public void setGzdw(String gzdw) {
            this.gzdw = gzdw;
        }

        public String getJbr() {
            return jbr;
        }

        public void setJbr(String jbr) {
            this.jbr = jbr;
        }

        public String getFzjg() {
            return fzjg;
        }

        public void setFzjg(String fzjg) {
            this.fzjg = fzjg;
        }

        public String getJyw() {
            return jyw;
        }

        public void setJyw(String jyw) {
            this.jyw = jyw;
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

        public Object getBz() {
            return bz;
        }

        public void setBz(Object bz) {
            this.bz = bz;
        }

        public String getKsydm() {
            return ksydm;
        }

        public void setKsydm(String ksydm) {
            this.ksydm = ksydm;
        }

        public String getSfzmmc() {
            return sfzmmc;
        }

        public void setSfzmmc(String sfzmmc) {
            this.sfzmmc = sfzmmc;
        }

        public String getDabh() {
            return dabh;
        }

        public void setDabh(String dabh) {
            this.dabh = dabh;
        }

        public String getCsbj() {
            return csbj;
        }

        public void setCsbj(String csbj) {
            this.csbj = csbj;
        }

        public String getBj() {
            return bj;
        }

        public void setBj(String bj) {
            this.bj = bj;
        }

        public String getBjcsbj() {
            return bjcsbj;
        }

        public void setBjcsbj(String bjcsbj) {
            this.bjcsbj = bjcsbj;
        }

        public Object getZtyy() {
            return ztyy;
        }

        public void setZtyy(Object ztyy) {
            this.ztyy = ztyy;
        }

        public Object getYjbj() {
            return yjbj;
        }

        public void setYjbj(Object yjbj) {
            this.yjbj = yjbj;
        }

        public Object getRylb() {
            return rylb;
        }

        public void setRylb(Object rylb) {
            this.rylb = rylb;
        }

        public Object getRysf() {
            return rysf;
        }

        public void setRysf(Object rysf) {
            this.rysf = rysf;
        }

        public Object getSjhm() {
            return sjhm;
        }

        public void setSjhm(Object sjhm) {
            this.sjhm = sjhm;
        }

        public Object getZslx() {
            return zslx;
        }

        public void setZslx(Object zslx) {
            this.zslx = zslx;
        }

        public Object getZsbh() {
            return zsbh;
        }

        public void setZsbh(Object zsbh) {
            this.zsbh = zsbh;
        }

        public String getGwlx() {
            return gwlx;
        }

        public void setGwlx(String gwlx) {
            this.gwlx = gwlx;
        }

        public String getJh() {
            return jh;
        }

        public void setJh(String jh) {
            this.jh = jh;
        }

        public Object getExamInvigilatorEducation() {
            return examInvigilatorEducation;
        }

        public void setExamInvigilatorEducation(Object examInvigilatorEducation) {
            this.examInvigilatorEducation = examInvigilatorEducation;
        }

        public Object getExamInvigilatorTrain() {
            return examInvigilatorTrain;
        }

        public void setExamInvigilatorTrain(Object examInvigilatorTrain) {
            this.examInvigilatorTrain = examInvigilatorTrain;
        }
    }
}
