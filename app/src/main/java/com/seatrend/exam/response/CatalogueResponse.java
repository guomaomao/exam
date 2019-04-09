package com.seatrend.exam.response;

import java.util.List;

public class CatalogueResponse {
    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"catalogue2":[{"name":"考前准备","number":null},{"name":"考场检查","number":null},{"name":"考生回访","number":null},{"name":"工作报告","number":null},{"name":"远程巡考","number":null}],"catalogue1":[{"name":"考试计划确认","number":"0"},{"name":"考前检查","number":"0"},{"name":"考中检查","number":"0"},{"name":"考后检查","number":"0"},{"name":"工作报告","number":"0"}]}
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
        private List<Catalogue2Bean> catalogue2;
        private List<Catalogue1Bean> catalogue1;

        public List<Catalogue2Bean> getCatalogue2() {
            return catalogue2;
        }

        public void setCatalogue2(List<Catalogue2Bean> catalogue2) {
            this.catalogue2 = catalogue2;
        }

        public List<Catalogue1Bean> getCatalogue1() {
            return catalogue1;
        }

        public void setCatalogue1(List<Catalogue1Bean> catalogue1) {
            this.catalogue1 = catalogue1;
        }

        public static class Catalogue2Bean {
            /**
             * name : 考前准备
             * number : null
             */

            private String name;
            private Object number;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getNumber() {
                return number;
            }

            public void setNumber(Object number) {
                this.number = number;
            }
        }

        public static class Catalogue1Bean {
            /**
             * name : 考试计划确认
             * number : 0
             */

            private String name;
            private String number;

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

//    /**
//     * status : true
//     * code : 0
//     * message : 成功
//     * data : {"catalogue2":[{"name":"考前准备","number":null},{"name":"考场检查","number":null},{"name":"考生回访","number":null},{"name":"工作报告","number":null},{"name":"远程巡考","number":null}],"catalogue1":[{"name":"考生回访","number":null},{"name":"工作报告","number":"0"}]}
//     * total : 0
//     * fileName : null
//     */
//
//    private boolean status;
//    private int code;
//    private String message;
//    private DataBean data;
//    private int total;
//    private String fileName;
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public int getTotal() {
//        return total;
//    }
//
//    public void setTotal(int total) {
//        this.total = total;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public static class DataBean {
//        private List<Catalogue2Bean> catalogue2;
//        private List<Catalogue1Bean> catalogue1;
//
//        public List<Catalogue2Bean> getCatalogue2() {
//            return catalogue2;
//        }
//
//        public void setCatalogue2(List<Catalogue2Bean> catalogue2) {
//            this.catalogue2 = catalogue2;
//        }
//
//        public List<Catalogue1Bean> getCatalogue1() {
//            return catalogue1;
//        }
//
//        public void setCatalogue1(List<Catalogue1Bean> catalogue1) {
//            this.catalogue1 = catalogue1;
//        }
//
//        public static class Catalogue2Bean {
//            /**
//             * name : 考前准备
//             * number : null
//             */
//
//            private String name;
//            private String number;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getNumber() {
//                return number;
//            }
//
//            public void setNumber(String number) {
//                this.number = number;
//            }
//        }
//
//        public static class Catalogue1Bean {
//            /**
//             * name : 考生回访
//             * number : null
//             */
//
//            private String name;
//            private String number;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getNumber() {
//                return number;
//            }
//
//            public void setNumber(String number) {
//                this.number = number;
//            }
//        }
//    }


}
