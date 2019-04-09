package com.seatrend.exam.common;

import android.graphics.Bitmap;

import com.seatrend.exam.response.CatalogueResponse;
import com.seatrend.exam.response.ExamRoomRemoteResponse;
import com.seatrend.exam.response.KTUsageResponse;
import com.seatrend.exam.response.TaskTopResponse;
import com.seatrend.exam.response.VehicleUsageResponse;
import com.seatrend.exam.utils.Utils;

import java.util.List;

/**
 * Created by seatrend on 2018/8/20.
 */

public final class Constants {

    public static String sfzmhm; //身份证号
    public static String xm;//姓名
    public static String yhdh;//用户代号
    public static String bmmc;
    public static String kcxh;
    public static String ssjs;// 用户的角色 1 监管中心 2考试员 3系统管理员 4考场工作人员 5民警
    public static String glbm;
    public static String sjbm;
    public static String qxms;
    public static String ipstart;
    public static String ipend;
    public static String pwd;
    public static String zt;
    public static String ssxt;
    public static String klyzms;
    public static long mmyxqz;
    public static String zhyxqz;
    public static String gdip1;
    public static String gdip2;
    public static String gdip3;
    public static String photo;
    public static long cjsj;
    public static long gxsj;
    public static String authorization;

    public static Bitmap mSign;


    public static String ksrq = Utils.getCurrYearMonthDate();
//    public static String ksrq = "2018/7/5";

    public static List<CatalogueResponse.DataBean.Catalogue1Bean> catalogue1;
    public static List<CatalogueResponse.DataBean.Catalogue2Bean> catalogue2;
    public static List<TaskTopResponse.DataBean> taskTop;
    public static List<ExamRoomRemoteResponse.DataBean> secondData;

    public static String GET = "GET";
    public static String POST = "POST";///vio/getVioByCar

    public static String USER_LOGIN = "/security_check";
    public static String GET_CATALOGUE = "/pda/getCatalogue"; //获取首页菜单
    public static String EXAM_GROUP_PDA = "/pda/selectExamPrepare"; //获取 考试计划
    public static String SET_AUTOGRAPH = "/pda/setAutograph"; //确认考试计划
    public static String EXAM_PREPARE_STATUS = "/pda/examPrepareStatus"; //获取 考前准备
    public static String VISIT_RECORD_PAGES = "/visitRecord/visitRecordPages"; //获取分页visitRecord列表
    public static String DOWNLOAD_FILE_BY_ID = "/download/downloadFile"; //按id下载文件
    public static String GET_EXAM_CHECK = "/pda/getExamCheck"; //获取考场检查详情
    public static String START_EXAM = "/pda/startExam"; //开始考试
    public static String EXAM_CHECK_PAGES = "/pda/examCheckPages"; //分页搜索考场检查
    public static String VISIT_RECORD_MESSAGE = "/visitRecord/visitRecordMessage"; //回访
    public static String SELECT_INVIGILATOR_BY_SFZMHM = "/pda/selectInvigilatorBySfzmhm"; //通过身份证获取单条考试员数据
    public static String UPLOAD_IMAGE = "/download/uploadImage";
    public static String CHANGE_PASSWORD_PDA = "/admin/user/changePasswordPDA"; //修改密码PDA
    public static String INSERT_WORK_REPORT = "/workReport/insertWorkReport"; //添加工作日报
    public static String SELECT_WORK_REPORT = "/workReport/selectWorkReport"; //查询工作日报
    public static String INSERT_AFTER = "/pda/insertAfter"; //修改考场检查
    public static String SELECT_EXAMINATION_SITE_CARMERA_LIST = "/recordManagement/selectExaminationSiteCarmeraList"; //获取考场摄像头列表
    public static String SELECT_KT_USAGE = "/examinationRegulation/selectKtUsage"; //获取 考台使用情况
    public static String GET_PDA_NUMBERS= "/pda/getPdaNumbers"; //获取首页数据列表
    public static String CAMERA_SUBJECT_ONE = "/examinationRegulation/CameraSubjectOne"; //根据考位获取摄像头信息
    public static String CAMERA_SUBJECT_TWO = "/examinationRegulation/CameraSubjectTwo"; //根据考位获取摄像头信息
    public static String SELECT_VEHICLE_PAGES = "/recordManagement/selectVehiclePages"; //获取分页考试车俩列表
    public static String GET_PDA_INFORMATION = "/pda/getPdaInformation"; //获取pda信息
    public static String SELECT_CONFIG = "/functionConfig/selectConfig"; //查询设置信息
    public static String SELECT_VEHICLE_BY_KCXH = "/recordManagement/selectVehicleByKcxh"; //根据考场序号获取考车+编号


    //相关的key值
    public static String SETTING = "setting";
    public static String IP_K = "ip";
    public static String PORT_K = "port";
    public static String ADMAIN = "admian";
    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String IS_FIRST = "is_first";
    public static String LOGIN_TIME = "login_time";

    /**
     * Intent相关常量
     */
    public interface IntentKey {
        /**
         * 获取根节点数据
         */
        String GET_ROOT_NODE = "getRootNode";
        /**
         * 获取子节点列表
         */
        String GET_SUB_NODE = "getChildNode";
        /**
         * 父节点类型
         */
        String PARENT_NODE_TYPE = "parentNodeType";
        /**
         * 父节点ID
         */
        String PARENT_ID = "parentId";
        /**
         * 监控点资源
         */
        String CAMERA = "Camera";
    }

    public static String mKcdm;
    public static String mksjh;
    public static String mKcxh;
    public static String mKchp;
    public static String mKskm;
    public static List<KTUsageResponse.DataBean> mListKTUsage;
    public static List<VehicleUsageResponse.DataBean.ListBean> mListVehicleUsage;

}
