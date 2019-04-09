package com.seatrend.exam.entity;

import java.util.List;

public class BeforeExamEditRequest {


    /**
     * checker : string
     * checkerId : string
     * checkstate : string
     * checktime : 2019-02-14T05:31:51.663Z
     * checktype : string
     * examroom : string
     * examsubject : string
     * examtime : 2019-02-14T05:31:51.663Z
     * id : string
     * middlechecker : string
     * middleid : string
     * middletime : 2019-02-14T05:31:51.663Z
     * project : {"beforeexamcheck":"string","beforeexamcheckResult":"string","emergencies":"string","emergenciesResult":"string","examdata":"string","examdataPerson":"string","examnumber":"string","faultequipment":"string","faultequipmentResult":"string","id":"string","monitorsituation":"string","monitorsituationPhoto":"string","monitorsituationResult":"string","qualifiednumber":"string","qualifiedrate":"string","remark":"string","unusualdata":"string","unusualdataResult":"string","videosaved":"string","videosavedPerson":"string","videosavedResult":"string"}
     * projects : [{"checkpoint":"检查要点","id":"null","photo":"检查处置图片id","pointtype":"要点类别：候考区","remark":"处置","result":"检查处置结果","resultOrder":"检查处置结果的顺序"}]
     */

    private String checker;
    private String checkerId;
    private String checkstate;
    private String checktime;
    private String checktype;
    private String examroom;
    private String examsubject;
    private String examtime;
    private String id;
    private String middlechecker;
    private String middleid;
    private String middletime;
    private ProjectBean project;
    private List<ProjectsBean> projects;

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }

    public String getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(String checkstate) {
        this.checkstate = checkstate;
    }

    public String getChecktime() {
        return checktime;
    }

    public void setChecktime(String checktime) {
        this.checktime = checktime;
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype;
    }

    public String getExamroom() {
        return examroom;
    }

    public void setExamroom(String examroom) {
        this.examroom = examroom;
    }

    public String getExamsubject() {
        return examsubject;
    }

    public void setExamsubject(String examsubject) {
        this.examsubject = examsubject;
    }

    public String getExamtime() {
        return examtime;
    }

    public void setExamtime(String examtime) {
        this.examtime = examtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMiddlechecker() {
        return middlechecker;
    }

    public void setMiddlechecker(String middlechecker) {
        this.middlechecker = middlechecker;
    }

    public String getMiddleid() {
        return middleid;
    }

    public void setMiddleid(String middleid) {
        this.middleid = middleid;
    }

    public String getMiddletime() {
        return middletime;
    }

    public void setMiddletime(String middletime) {
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

    public void setProjects(List<ProjectsBean> projects) {
        this.projects = projects;
    }

    public static class ProjectBean {
        /**
         * beforeexamcheck : string
         * beforeexamcheckResult : string
         * emergencies : string
         * emergenciesResult : string
         * examdata : string
         * examdataPerson : string
         * examnumber : string
         * faultequipment : string
         * faultequipmentResult : string
         * id : string
         * monitorsituation : string
         * monitorsituationPhoto : string
         * monitorsituationResult : string
         * qualifiednumber : string
         * qualifiedrate : string
         * remark : string
         * unusualdata : string
         * unusualdataResult : string
         * videosaved : string
         * videosavedPerson : string
         * videosavedResult : string
         */

        private String beforeexamcheck;
        private String beforeexamcheckResult;
        private String emergencies;
        private String emergenciesResult;
        private String examdata;
        private String examdataPerson;
        private String examnumber;
        private String faultequipment;
        private String faultequipmentResult;
        private String id;
        private String monitorsituation;
        private String monitorsituationPhoto;
        private String monitorsituationResult;
        private String qualifiednumber;
        private String qualifiedrate;
        private String remark;
        private String unusualdata;
        private String unusualdataResult;
        private String videosaved;
        private String videosavedPerson;
        private String videosavedResult;

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

        public String getExamdata() {
            return examdata;
        }

        public void setExamdata(String examdata) {
            this.examdata = examdata;
        }

        public String getExamdataPerson() {
            return examdataPerson;
        }

        public void setExamdataPerson(String examdataPerson) {
            this.examdataPerson = examdataPerson;
        }

        public String getExamnumber() {
            return examnumber;
        }

        public void setExamnumber(String examnumber) {
            this.examnumber = examnumber;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMonitorsituation() {
            return monitorsituation;
        }

        public void setMonitorsituation(String monitorsituation) {
            this.monitorsituation = monitorsituation;
        }

        public String getMonitorsituationPhoto() {
            return monitorsituationPhoto;
        }

        public void setMonitorsituationPhoto(String monitorsituationPhoto) {
            this.monitorsituationPhoto = monitorsituationPhoto;
        }

        public String getMonitorsituationResult() {
            return monitorsituationResult;
        }

        public void setMonitorsituationResult(String monitorsituationResult) {
            this.monitorsituationResult = monitorsituationResult;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public String getVideosaved() {
            return videosaved;
        }

        public void setVideosaved(String videosaved) {
            this.videosaved = videosaved;
        }

        public String getVideosavedPerson() {
            return videosavedPerson;
        }

        public void setVideosavedPerson(String videosavedPerson) {
            this.videosavedPerson = videosavedPerson;
        }

        public String getVideosavedResult() {
            return videosavedResult;
        }

        public void setVideosavedResult(String videosavedResult) {
            this.videosavedResult = videosavedResult;
        }
    }

    public static class ProjectsBean {
        /**
         * checkpoint : 检查要点
         * id : null
         * photo : 检查处置图片id
         * pointtype : 要点类别：候考区
         * remark : 处置
         * result : 检查处置结果
         * resultOrder : 检查处置结果的顺序
         */

        private String checkpoint;
        private String id;
        private String photo;
        private String pointtype;
        private String remark;
        private String result;
        private String resultOrder;

        public String getCheckpoint() {
            return checkpoint;
        }

        public void setCheckpoint(String checkpoint) {
            this.checkpoint = checkpoint;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPointtype() {
            return pointtype;
        }

        public void setPointtype(String pointtype) {
            this.pointtype = pointtype;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getResultOrder() {
            return resultOrder;
        }

        public void setResultOrder(String resultOrder) {
            this.resultOrder = resultOrder;
        }
    }
}
