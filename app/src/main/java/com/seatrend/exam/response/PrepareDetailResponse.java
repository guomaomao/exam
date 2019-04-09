package com.seatrend.exam.response;

import java.util.List;

public class PrepareDetailResponse extends BaseResponse {

    /**
     * status : true
     * code : 0
     * message : 成功
     * data : {"id":"8373587984342528","examroom":"雅安市草坝汽车驾驶人考场","checker":"朱建林","checkerId":null,"examsubject":"2","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1550505600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":2,"checkpoint":"公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":3,"checkpoint":"考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":4,"checkpoint":"音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"}],"project":null}
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
         * id : 8373587984342528
         * examroom : 雅安市草坝汽车驾驶人考场
         * checker : 朱建林
         * checkerId : null
         * examsubject : 2
         * checktype : 考中检查
         * checkstate : 0
         * checktime : null
         * examtime : 1550505600000
         * middleid : null
         * middlechecker : null
         * middletime : null
         * projects : [{"resultOrder":1,"checkpoint":"考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":2,"checkpoint":"公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":3,"checkpoint":"考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"},{"resultOrder":4,"checkpoint":"音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8373587984342528"}]
         * project : null
         */

        private String id;
        private String examroom;
        private String checker;
        private Object checkerId;
        private String examsubject;
        private String checktype;
        private String checkstate;
        private Object checktime;
        private long examtime;
        private Object middleid;
        private Object middlechecker;
        private Object middletime;
        private ProjectBean project;
        private List<ProjectsBean> projects;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getExamroom() {
            return examroom;
        }

        public void setExamroom(String examroom) {
            this.examroom = examroom;
        }

        public String getChecker() {
            return checker;
        }

        public void setChecker(String checker) {
            this.checker = checker;
        }

        public Object getCheckerId() {
            return checkerId;
        }

        public void setCheckerId(Object checkerId) {
            this.checkerId = checkerId;
        }

        public String getExamsubject() {
            return examsubject;
        }

        public void setExamsubject(String examsubject) {
            this.examsubject = examsubject;
        }

        public String getChecktype() {
            return checktype;
        }

        public void setChecktype(String checktype) {
            this.checktype = checktype;
        }

        public String getCheckstate() {
            return checkstate;
        }

        public void setCheckstate(String checkstate) {
            this.checkstate = checkstate;
        }

        public Object getChecktime() {
            return checktime;
        }

        public void setChecktime(Object checktime) {
            this.checktime = checktime;
        }

        public long getExamtime() {
            return examtime;
        }

        public void setExamtime(long examtime) {
            this.examtime = examtime;
        }

        public Object getMiddleid() {
            return middleid;
        }

        public void setMiddleid(Object middleid) {
            this.middleid = middleid;
        }

        public Object getMiddlechecker() {
            return middlechecker;
        }

        public void setMiddlechecker(Object middlechecker) {
            this.middlechecker = middlechecker;
        }

        public Object getMiddletime() {
            return middletime;
        }

        public void setMiddletime(Object middletime) {
            this.middletime = middletime;
        }

        public ProjectBean getProject() {
            return project;
        }

        public void setProject(ProjectBean project) {
            this.project = project;
        }

        public List<ProjectsBean> getProjects() {
            return projects;
        }

        public static class ProjectBean {
            /**
             * monitorsituation : null
             * monitorsituationResult : 0
             * monitorsituationPhoto : null
             * examnumber : null
             * qualifiednumber : null
             * qualifiedrate : null
             * examdataPerson : null
             * examdata : null
             * unusualdata : null
             * unusualdataResult : 0
             * emergencies : null
             * emergenciesResult : 0
             * beforeexamcheck : null
             * beforeexamcheckResult : null
             * faultequipment : null
             * faultequipmentResult : 0
             * videosaved : null
             * videosavedResult : 0
             * videosavedPerson : null
             * remark : null
             * id : 8581245363670016
             */

            private String monitorsituation;
            private String monitorsituationResult;
            private String monitorsituationPhoto;
            private String examnumber;
            private String qualifiednumber;
            private String qualifiedrate;
            private String examdataPerson;
            private String examdata;
            private String unusualdata;
            private String unusualdataResult;
            private String emergencies;
            private String emergenciesResult;
            private String beforeexamcheck;
            private String beforeexamcheckResult;
            private String faultequipment;
            private String faultequipmentResult;
            private String videosaved;
            private String videosavedResult;
            private String videosavedPerson;
            private String remark;
            private String id;

            public String getMonitorsituation() {
                return monitorsituation;
            }

            public void setMonitorsituation(String monitorsituation) {
                this.monitorsituation = monitorsituation;
            }

            public String getMonitorsituationResult() {
                return monitorsituationResult;
            }

            public void setMonitorsituationResult(String monitorsituationResult) {
                this.monitorsituationResult = monitorsituationResult;
            }

            public String getMonitorsituationPhoto() {
                return monitorsituationPhoto;
            }

            public void setMonitorsituationPhoto(String monitorsituationPhoto) {
                this.monitorsituationPhoto = monitorsituationPhoto;
            }

            public String getExamnumber() {
                return examnumber;
            }

            public void setExamnumber(String examnumber) {
                this.examnumber = examnumber;
            }

            public String getQualifiednumber() {
                return qualifiednumber;
            }

            public void setQualifiednumber(String qualifiednumber) {
                this.qualifiednumber = qualifiednumber;
            }

            public String getQualifiedrate() {
                return qualifiedrate;
            }

            public void setQualifiedrate(String qualifiedrate) {
                this.qualifiedrate = qualifiedrate;
            }

            public String getExamdataPerson() {
                return examdataPerson;
            }

            public void setExamdataPerson(String examdataPerson) {
                this.examdataPerson = examdataPerson;
            }

            public String getExamdata() {
                return examdata;
            }

            public void setExamdata(String examdata) {
                this.examdata = examdata;
            }

            public String getUnusualdata() {
                return unusualdata;
            }

            public void setUnusualdata(String unusualdata) {
                this.unusualdata = unusualdata;
            }

            public String getUnusualdataResult() {
                return unusualdataResult;
            }

            public void setUnusualdataResult(String unusualdataResult) {
                this.unusualdataResult = unusualdataResult;
            }

            public String getEmergencies() {
                return emergencies;
            }

            public void setEmergencies(String emergencies) {
                this.emergencies = emergencies;
            }

            public String getEmergenciesResult() {
                return emergenciesResult;
            }

            public void setEmergenciesResult(String emergenciesResult) {
                this.emergenciesResult = emergenciesResult;
            }

            public String getBeforeexamcheck() {
                return beforeexamcheck;
            }

            public void setBeforeexamcheck(String beforeexamcheck) {
                this.beforeexamcheck = beforeexamcheck;
            }

            public String getBeforeexamcheckResult() {
                return beforeexamcheckResult;
            }

            public void setBeforeexamcheckResult(String beforeexamcheckResult) {
                this.beforeexamcheckResult = beforeexamcheckResult;
            }

            public String getFaultequipment() {
                return faultequipment;
            }

            public void setFaultequipment(String faultequipment) {
                this.faultequipment = faultequipment;
            }

            public String getFaultequipmentResult() {
                return faultequipmentResult;
            }

            public void setFaultequipmentResult(String faultequipmentResult) {
                this.faultequipmentResult = faultequipmentResult;
            }

            public String getVideosaved() {
                return videosaved;
            }

            public void setVideosaved(String videosaved) {
                this.videosaved = videosaved;
            }

            public String getVideosavedResult() {
                return videosavedResult;
            }

            public void setVideosavedResult(String videosavedResult) {
                this.videosavedResult = videosavedResult;
            }

            public String getVideosavedPerson() {
                return videosavedPerson;
            }

            public void setVideosavedPerson(String videosavedPerson) {
                this.videosavedPerson = videosavedPerson;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public void setProjects(List<ProjectsBean> projects) {
            this.projects = projects;
        }

        public static class ProjectsBean {
            /**
             * resultOrder : 1
             * checkpoint : 考试区秩序。
             * pointtype : 考中检查
             * result : 0
             * remark : null
             * photo : null
             * id : 8373587984342528
             */

            private int resultOrder;
            private String checkpoint;
            private String pointtype;
            private String result;
            private String remark;
            private String photo;
            private String id;

            public int getResultOrder() {
                return resultOrder;
            }

            public void setResultOrder(int resultOrder) {
                this.resultOrder = resultOrder;
            }

            public String getCheckpoint() {
                return checkpoint;
            }

            public void setCheckpoint(String checkpoint) {
                this.checkpoint = checkpoint;
            }

            public String getPointtype() {
                return pointtype;
            }

            public void setPointtype(String pointtype) {
                this.pointtype = pointtype;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
