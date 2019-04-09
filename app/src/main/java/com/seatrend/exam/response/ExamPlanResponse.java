package com.seatrend.exam.response;

import java.util.List;

public class ExamPlanResponse extends BaseResponse {


    /**
     * data : [{"xh":null,"gxsj":null,"kskm":"3","ksrq":1520179200000,"ksdd":"51310003","kscx":"C1","kscc":"1","kchp":null,"ksy":"杨帆","ksxm":null,"glbm":"511800000400","ksxl":"5100004902","kcxh":"51000049","jyw":null,"count":"0"},{"xh":null,"gxsj":null,"kskm":"3","ksrq":1520179200000,"ksdd":"51310003","kscx":"C1","kscc":"1","kchp":null,"ksy":"杨帆","ksxm":null,"glbm":"511800000400","ksxl":"5100004902","kcxh":"51000049","jyw":null,"count":"0"},{"xh":null,"gxsj":null,"kskm":"3","ksrq":1520179200000,"ksdd":"51310003","kscx":"C1","kscc":"1","kchp":null,"ksy":"杨帆","ksxm":null,"glbm":"511800000400","ksxl":"5100004902","kcxh":"51000049","jyw":null,"count":"0"},{"xh":null,"gxsj":null,"kskm":"3","ksrq":1520179200000,"ksdd":"51310003","kscx":"C1","kscc":"1","kchp":null,"ksy":"杨帆","ksxm":null,"glbm":"511800000400","ksxl":"5100004902","kcxh":"51000049","jyw":null,"count":"0"}]
     * total : 4
     */

    private int total;
    private List<DataBean> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * xh : null
         * gxsj : null
         * kskm : 3
         * ksrq : 1520179200000
         * ksdd : 51310003
         * kscx : C1
         * kscc : 1
         * kchp : null
         * ksy : 杨帆
         * ksxm : null
         * glbm : 511800000400
         * ksxl : 5100004902
         * kcxh : 51000049
         * jyw : null
         * count : 0
         */

        private Object xh;
        private Object gxsj;
        private String kskm;
        private long ksrq;
        private String ksdd;
        private String kscx;
        private String kscc;
        private Object kchp;
        private String ksy;
        private Object ksxm;
        private String glbm;
        private String ksxl;
        private String kcxh;
        private Object jyw;
        private String count;
        private String jczt;
        private String qrzt;

        public String getJczt() {
            return jczt;
        }

        public void setJczt(String jczt) {
            this.jczt = jczt;
        }

        public String getQrzt() {
            return qrzt;
        }

        public void setQrzt(String qrzt) {
            this.qrzt = qrzt;
        }

        public Object getXh() {
            return xh;
        }

        public void setXh(Object xh) {
            this.xh = xh;
        }

        public Object getGxsj() {
            return gxsj;
        }

        public void setGxsj(Object gxsj) {
            this.gxsj = gxsj;
        }

        public String getKskm() {
            return kskm;
        }

        public void setKskm(String kskm) {
            this.kskm = kskm;
        }

        public long getKsrq() {
            return ksrq;
        }

        public void setKsrq(long ksrq) {
            this.ksrq = ksrq;
        }

        public String getKsdd() {
            return ksdd;
        }

        public void setKsdd(String ksdd) {
            this.ksdd = ksdd;
        }

        public String getKscx() {
            return kscx;
        }

        public void setKscx(String kscx) {
            this.kscx = kscx;
        }

        public String getKscc() {
            return kscc;
        }

        public void setKscc(String kscc) {
            this.kscc = kscc;
        }

        public Object getKchp() {
            return kchp;
        }

        public void setKchp(Object kchp) {
            this.kchp = kchp;
        }

        public String getKsy() {
            return ksy;
        }

        public void setKsy(String ksy) {
            this.ksy = ksy;
        }

        public Object getKsxm() {
            return ksxm;
        }

        public void setKsxm(Object ksxm) {
            this.ksxm = ksxm;
        }

        public String getGlbm() {
            return glbm;
        }

        public void setGlbm(String glbm) {
            this.glbm = glbm;
        }

        public String getKsxl() {
            return ksxl;
        }

        public void setKsxl(String ksxl) {
            this.ksxl = ksxl;
        }

        public String getKcxh() {
            return kcxh;
        }

        public void setKcxh(String kcxh) {
            this.kcxh = kcxh;
        }

        public Object getJyw() {
            return jyw;
        }

        public void setJyw(Object jyw) {
            this.jyw = jyw;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }
}
