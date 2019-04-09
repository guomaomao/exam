package com.seatrend.exam.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ExamRoomRemoteResponse extends BaseResponse implements Serializable{


    /**
     * status : true
     * code : 0
     * message : 成功
     * data : [{"xh":"51000035","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安市新车管所科目一考场","kcdddh":"51310001","kkcx":"A1A2A3B1B2C1C2C3C4C5DEF","sfsxt":"1","seaExamSiteCamera":[{"id":"54c9f2a57cbf433ea67ff29af38a3823","venueCode":"51310001","venueName":"雅安市新车管所科目一考场","cameraNumber":"547ab14c626d411db78939e7ee3e5126","cameraName":"IPCamera 01","locationNumber":"01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20"},{"id":"db1ed508bbda4c59a0b6cca29b3d168e","venueCode":"51310001","venueName":"雅安市新车管所科目一考场","cameraNumber":"72f8105f1d7c49869cdcbc7ec6263a5e","cameraName":"IPCamera 02","locationNumber":"21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40"}],"seaExamRoadCamera":[],"examinationRegulation":[]},{"xh":"51000041","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队汉源考场","kcdddh":"51312401","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000049","fzjg":"川T","glbm":"511800000400","kskm":"3","kcmc":"雅安市草坝汽车驾驶人考场","kcdddh":"51310003","kkcx":"A1A2A3B1B2C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000532","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队雅安考场","kcdddh":"51310002","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000586","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队名山考场","kcdddh":"51312202","kkcx":"EDF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000588","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队芦山考场","kcdddh":"51312702","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000590","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队天全考场","kcdddh":"51312602","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000592","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队宝兴考场","kcdddh":"51312802","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000594","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队荥经考场","kcdddh":"51312302","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000596","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队汉源考场","kcdddh":"51312402","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000598","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队石棉考场","kcdddh":"51312502","kkcx":"DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000637","fzjg":"川T","glbm":"511800000400","kskm":"3","kcmc":"雅安支队科目三异地考试虚拟考场","kcdddh":"5103006","kkcx":"A1A2A3B1B2","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000836","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安支队科目二异地考试考场(自贡)","kcdddh":"5103034","kkcx":"A1A2A3B1B2","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000843","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安市对岩汽车驾驶人考场","kcdddh":"51180020","kkcx":"A1A2A3B1B2C1C2C3C4C5","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51001106","fzjg":"川T","glbm":"511800000400","kskm":"2","kcmc":"雅安市均田汽车驾驶人考场","kcdddh":"51180022","kkcx":"C1C2","sfsxt":"1","seaExamSiteCamera":[],"seaExamRoadCamera":[{"id":"440aca370f6f41b895026dd4bf2e1d6d","venueNumber":"51001106","venueName":"雅安市均田汽车驾驶人考场(0)","cameraNumber":"0ff0b133620a4da986eedc7fb265ca49","cameraName":"川TRL509 1号车","machineNumber":null,"licenseNumber":"川TRL509","venueCode":"51180022"}],"examinationRegulation":[]},{"xh":"51001109","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安市草坝机动车驾驶人理论考场","kcdddh":"51180011","kkcx":"A1A2A3B1B2C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000036","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队名山考场","kcdddh":"51312201","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000037","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队芦山考场","kcdddh":"51312701","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000038","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队天全考场","kcdddh":"51312601","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000039","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队宝兴考场","kcdddh":"51312801","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000040","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队荥经考场","kcdddh":"51312301","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null},{"xh":"51000042","fzjg":"川T","glbm":"511800000400","kskm":"1","kcmc":"雅安支队石棉考场","kcdddh":"51312501","kkcx":"A1A2A3B2B1C1C2C3C4C5DEF","sfsxt":"0","seaExamSiteCamera":null,"seaExamRoadCamera":null,"examinationRegulation":null}]
     * total : 22
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

    public static class DataBean implements Serializable{
        /**
         * xh : 51000035
         * fzjg : 川T
         * glbm : 511800000400
         * kskm : 1
         * kcmc : 雅安市新车管所科目一考场
         * kcdddh : 51310001
         * kkcx : A1A2A3B1B2C1C2C3C4C5DEF
         * sfsxt : 1
         * seaExamSiteCamera : [{"id":"54c9f2a57cbf433ea67ff29af38a3823","venueCode":"51310001","venueName":"雅安市新车管所科目一考场","cameraNumber":"547ab14c626d411db78939e7ee3e5126","cameraName":"IPCamera 01","locationNumber":"01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20"},{"id":"db1ed508bbda4c59a0b6cca29b3d168e","venueCode":"51310001","venueName":"雅安市新车管所科目一考场","cameraNumber":"72f8105f1d7c49869cdcbc7ec6263a5e","cameraName":"IPCamera 02","locationNumber":"21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40"}]
         * seaExamRoadCamera : []
         * examinationRegulation : []
         */

        private String xh;
        private String fzjg;
        private String glbm;
        private String kskm;
        private String kcmc;
        private String kcdddh;
        private String kkcx;
        private String sfsxt;
        private List<SeaExamSiteCameraBean> seaExamSiteCamera;
        private List<SeaExamRoadCameraBean> seaExamRoadCamera;
        private List<?> examinationRegulation;

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getFzjg() {
            return fzjg;
        }

        public void setFzjg(String fzjg) {
            this.fzjg = fzjg;
        }

        public String getGlbm() {
            return glbm;
        }

        public void setGlbm(String glbm) {
            this.glbm = glbm;
        }

        public String getKskm() {
            return kskm;
        }

        public void setKskm(String kskm) {
            this.kskm = kskm;
        }

        public String getKcmc() {
            return kcmc;
        }

        public void setKcmc(String kcmc) {
            this.kcmc = kcmc;
        }

        public String getKcdddh() {
            return kcdddh;
        }

        public void setKcdddh(String kcdddh) {
            this.kcdddh = kcdddh;
        }

        public String getKkcx() {
            return kkcx;
        }

        public void setKkcx(String kkcx) {
            this.kkcx = kkcx;
        }

        public String getSfsxt() {
            return sfsxt;
        }

        public void setSfsxt(String sfsxt) {
            this.sfsxt = sfsxt;
        }

        public List<SeaExamSiteCameraBean> getSeaExamSiteCamera() {
            return seaExamSiteCamera;
        }

        public void setSeaExamSiteCamera(List<SeaExamSiteCameraBean> seaExamSiteCamera) {
            this.seaExamSiteCamera = seaExamSiteCamera;
        }

        public List<SeaExamRoadCameraBean> getSeaExamRoadCamera() {
            return seaExamRoadCamera;
        }

        public void setSeaExamRoadCamera(List<SeaExamRoadCameraBean> seaExamRoadCamera) {
            this.seaExamRoadCamera = seaExamRoadCamera;
        }

        public List<?> getExaminationRegulation() {
            return examinationRegulation;
        }

        public void setExaminationRegulation(List<?> examinationRegulation) {
            this.examinationRegulation = examinationRegulation;
        }

        public static class SeaExamSiteCameraBean implements Serializable {
            /**
             * id : 54c9f2a57cbf433ea67ff29af38a3823
             * venueCode : 51310001
             * venueName : 雅安市新车管所科目一考场
             * cameraNumber : 547ab14c626d411db78939e7ee3e5126
             * cameraName : IPCamera 01
             * locationNumber : 01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20
             */

            private String id;
            private String venueCode;
            private String venueName;
            private String cameraNumber;
            private String cameraName;
            private String locationNumber;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getVenueCode() {
                return venueCode;
            }

            public void setVenueCode(String venueCode) {
                this.venueCode = venueCode;
            }

            public String getVenueName() {
                return venueName;
            }

            public void setVenueName(String venueName) {
                this.venueName = venueName;
            }

            public String getCameraNumber() {
                return cameraNumber;
            }

            public void setCameraNumber(String cameraNumber) {
                this.cameraNumber = cameraNumber;
            }

            public String getCameraName() {
                return cameraName;
            }

            public void setCameraName(String cameraName) {
                this.cameraName = cameraName;
            }

            public String getLocationNumber() {
                return locationNumber;
            }

            public void setLocationNumber(String locationNumber) {
                this.locationNumber = locationNumber;
            }
        }


        public static class SeaExamRoadCameraBean implements Serializable{
            /**
             * id : c007d63796704100944f0bb5a49fec25
             * venueNumber : 51001106
             * venueName : 雅安市均田汽车驾驶人考场(3)
             * cameraNumber : 1a1fd4893b58446fa42522f1d401e35b
             * cameraName : 川TRL509 1号车
             * machineNumber : null
             * licenseNumber : null
             * venueCode : 51180022
             */

            private String id;
            private String venueNumber;
            private String venueName;
            private String cameraNumber;
            private String cameraName;
            private Object machineNumber;
            private Object licenseNumber;
            private String venueCode;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getVenueNumber() {
                return venueNumber;
            }

            public void setVenueNumber(String venueNumber) {
                this.venueNumber = venueNumber;
            }

            public String getVenueName() {
                return venueName;
            }

            public void setVenueName(String venueName) {
                this.venueName = venueName;
            }

            public String getCameraNumber() {
                return cameraNumber;
            }

            public void setCameraNumber(String cameraNumber) {
                this.cameraNumber = cameraNumber;
            }

            public String getCameraName() {
                return cameraName;
            }

            public void setCameraName(String cameraName) {
                this.cameraName = cameraName;
            }

            public Object getMachineNumber() {
                return machineNumber;
            }

            public void setMachineNumber(Object machineNumber) {
                this.machineNumber = machineNumber;
            }

            public Object getLicenseNumber() {
                return licenseNumber;
            }

            public void setLicenseNumber(Object licenseNumber) {
                this.licenseNumber = licenseNumber;
            }

            public String getVenueCode() {
                return venueCode;
            }

            public void setVenueCode(String venueCode) {
                this.venueCode = venueCode;
            }
        }
    }
}
