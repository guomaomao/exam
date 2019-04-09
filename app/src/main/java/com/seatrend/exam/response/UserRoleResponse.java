package com.seatrend.exam.response;

import java.util.List;

/**
 * Created by seatrend on 2018/10/17.
 */

public class UserRoleResponse extends BaseResponse {


    /**
     * data : [{"jsdh":"3","yhdh":"system"}]
     * total : 1
     * fileName : null
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
         * jsdh : 3
         * yhdh : system
         */

        private String jsdh;
        private String yhdh;

        public String getJsdh() {
            return jsdh;
        }

        public void setJsdh(String jsdh) {
            this.jsdh = jsdh;
        }

        public String getYhdh() {
            return yhdh;
        }

        public void setYhdh(String yhdh) {
            this.yhdh = yhdh;
        }
    }
}
