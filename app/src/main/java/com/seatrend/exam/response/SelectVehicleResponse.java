package com.seatrend.exam.response;

import java.util.List;

public class SelectVehicleResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : [{"name":"川TMJ559","number":null},{"name":"川T29082","number":null},{"name":"川T29080","number":null},{"name":"川T29285","number":null},{"name":"川T29090","number":null},{"name":"川T29092","number":null},{"name":"川TAT013","number":null},{"name":"川TAT016","number":null},{"name":"川TAT021","number":null},{"name":"川TAT023","number":null},{"name":"川TAT029","number":null},{"name":"川TAT102","number":null},{"name":"川TAT105","number":null},{"name":"川TAT106","number":null},{"name":"川TAT109","number":null},{"name":"川TAT110","number":null},{"name":"川TAT160","number":null},{"name":"川TKH777","number":null},{"name":"川TLA017","number":null},{"name":"川TLA908","number":null},{"name":"川TLB510","number":null},{"name":"川TLB576","number":null},{"name":"川TLC728","number":null},{"name":"川TLM276","number":null},{"name":"川TLW355","number":null},{"name":"川TLZ115","number":null},{"name":"川TLB569","number":null}]
     * total : 27
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
         * name : 川TMJ559
         * number : null
         */

        private String name;
        private String number;
        private boolean isChecked;

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
