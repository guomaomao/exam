package com.seatrend.exam.response;

import java.util.List;

/**
 * Created by seatrend on 2018/10/8.
 */

public class LoginResponse extends BaseResponse {

    /**
     * Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ6aHVqaXllIiwiZXhwIjoxNTUwMTI3MjMxfQ.Bc8iQC8Zq4iRWHEunPEE8FuTRMNotJBPj9qc9eaL3FxACaGTja0of8E5BEu4QSqIOHdcF5Qwb5LbXdeJqJjQAw
     * applicationUser : {"password":null,"username":"zhujiye","authorities":[{"authority":"01#010101"},{"authority":"01#010102"},{"authority":"02#020101"},{"authority":"02#020102"},{"authority":"02#020103"},{"authority":"02#020104"},{"authority":"02#020105"},{"authority":"02#020106"},{"authority":"02#020107"},{"authority":"03#030101"},{"authority":"03#030102"},{"authority":"03#030103"},{"authority":"03#030104"},{"authority":"03#030105"},{"authority":"03#030106"},{"authority":"03#030107"},{"authority":"03#030108"},{"authority":"03#030109"},{"authority":"03#030110"},{"authority":"03#030111"},{"authority":"04#040101"},{"authority":"04#040102"},{"authority":"04#040103"},{"authority":"04#040104"},{"authority":"04#040105"},{"authority":"04#040106"},{"authority":"04#040107"},{"authority":"04#040108"},{"authority":"04#040109"},{"authority":"04#040110"},{"authority":"04#040111"},{"authority":"04#040112"},{"authority":"04#040113"},{"authority":"04#040114"},{"authority":"04#040115"},{"authority":"04#040116"},{"authority":"04#040117"},{"authority":"04#040118"},{"authority":"04#040119"},{"authority":"04#040120"},{"authority":"04#040121"},{"authority":"04#040122"},{"authority":"04#040123"},{"authority":"04#040124"},{"authority":"04#040125"},{"authority":"04#040126"},{"authority":"04#040127"},{"authority":"04#040128"},{"authority":"04#040129"},{"authority":"04#040130"},{"authority":"04#040131"},{"authority":"04#040132"},{"authority":"04#040133"},{"authority":"04#040134"},{"authority":"04#040135"},{"authority":"05#050101"},{"authority":"05#050102"},{"authority":"05#050103"},{"authority":"05#050104"},{"authority":"05#050105"},{"authority":"05#050106"},{"authority":"05#050107"},{"authority":"05#050108"},{"authority":"05#050109"},{"authority":"06#060101"},{"authority":"07#070101"},{"authority":"07#070102"},{"authority":"07#070103"},{"authority":"07#070104"},{"authority":"07#070105"},{"authority":"07#070106"},{"authority":"07#070107"},{"authority":"07#070108"},{"authority":"07#070109"},{"authority":"07#070110"},{"authority":"07#070111"},{"authority":"07#070112"},{"authority":"07#070113"},{"authority":"07#070114"}],"accountNonExpired":true,"accountNonLocked":true,"credentialsNonExpired":true,"enabled":true,"programs":[{"xtlb":"01","mldh":"0101","qxdm":"010101","qxmc":"首页","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/homepage/home","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"01","mldh":"0101","qxdm":"010102","qxmc":"首页V2","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/homepage/homev2","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020101","qxmc":"考场巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/sitIns","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020102","qxmc":"考台巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=1","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020103","qxmc":"考试车巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=2","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020104","qxmc":"候考区巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=3","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020105","qxmc":"监控中心巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=4","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0202","qxdm":"020106","qxmc":"视频查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/videoQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0202","qxdm":"020107","qxmc":"视频回放","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/videoPlayback","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030101","qxmc":"误判查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030102","qxmc":"误判申请","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missApply","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030103","qxmc":"误判审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030104","qxmc":"考试异常查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/examMissDeal","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030105","qxmc":"考试作弊采集","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/cheatCollection","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030106","qxmc":"考试作弊审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/cheatVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030107","qxmc":"手工扣分查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/deduction","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030108","qxmc":"手工结束考试查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/endExam","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030109","qxmc":"预警审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/waitVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030110","qxmc":"预警处理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/waitDeal","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030111","qxmc":"历史预警","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/warningHistory","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040101","qxmc":"考试场地","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examSite","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040102","qxmc":"考试设备","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDevice","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040103","qxmc":"考台","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDesktop","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040104","qxmc":"考试车辆","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examVehicle","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040105","qxmc":"考试员","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examPerson","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040106","qxmc":"考试系统","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examSystem","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040107","qxmc":"驾校","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDriverSchool","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040108","qxmc":"考场员工","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examStaff","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040109","qxmc":"考场员工黑名单","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/blackList","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040110","qxmc":"考试预约","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examBooking","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040111","qxmc":"考试计划","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examPlan","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040112","qxmc":"考台分配","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examTableAsign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040113","qxmc":"考试员签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examStaffSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040114","qxmc":"助考员签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examExtraStaffSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040115","qxmc":"考生签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/studentSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040116","qxmc":"考试签名查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/signQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040117","qxmc":"考试员签名","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examinerSign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040118","qxmc":"考生签名","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examineeSign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040119","qxmc":"考场检查查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040120","qxmc":"考前检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckBefore","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040121","qxmc":"考中检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckDoing","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040122","qxmc":"考后检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckFinish","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040123","qxmc":"设备检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/deviceCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0406","qxdm":"040124","qxmc":"批量打印","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/batchPrint","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0406","qxdm":"040125","qxmc":"成绩打印","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/singlePrint","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040126","qxmc":"抽查记录查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/processCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040127","qxmc":"考试过程抽查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/processQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040128","qxmc":"记录仪抽查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/recordMachineQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040129","qxmc":"回访情况查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/callbackCommand","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040130","qxmc":"考生意见查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/studentRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040131","qxmc":"回访考生","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/callbackStudent","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040132","qxmc":"工作报告","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/workRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040133","qxmc":"整改记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/rectifyRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040134","qxmc":"通报记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/avioRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040135","qxmc":"约谈记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/talkRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050101","qxmc":"综合分析","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/homepage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050102","qxmc":"考试地点","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/site","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050103","qxmc":"考试原因","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/reason","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050104","qxmc":"所属驾校","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/school","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050105","qxmc":"考试项目","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/subject","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050106","qxmc":"考试车型","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/car","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050107","qxmc":"考试员 ","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/person","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050108","qxmc":"考车编号","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/carNumber","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050109","qxmc":"本/异地考生","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/studentSource","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"06","mldh":"0601","qxdm":"060101","qxmc":"文档中心","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/documentCenter/doc","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070101","qxmc":"科目一科目四","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraManage14","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070102","qxmc":"科目二科目三","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraManage23","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070103","qxmc":"候考区","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraWaitRoom","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070104","qxmc":"监控区","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraMonitor","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0702","qxdm":"070105","qxmc":"用户管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/userManage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0703","qxdm":"070106","qxmc":"角色管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/roleManage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0704","qxdm":"070107","qxmc":"安全策略","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/visitControl","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070108","qxmc":"考试员签名设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/examinerSignSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070109","qxmc":"回访设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/returnVisit","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070110","qxmc":"预警设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/earlyWarning","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070111","qxmc":"抽查设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/seletedSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070112","qxmc":"本异地比例设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/scaleSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070113","qxmc":"8700参数设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraParameters","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070114","qxmc":"广告位管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/adsManager","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false}],"oneSeaCodeList":[{"xtlb":"50","dmlb":"0001","dmz":"01","mldh":"01","dmsm1":"首页","mlmc":"首页","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"02","mldh":"02","dmsm1":"考试监管","mlmc":"考试监管","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"03","mldh":"03","dmsm1":"异常管理","mlmc":"异常管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"04","mldh":"04","dmsm1":"工作管理","mlmc":"工作管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"05","mldh":"05","dmsm1":"统计分析","mlmc":"统计分析","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"06","mldh":"06","dmsm1":"文档中心","mlmc":"文档中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"07","mldh":"07","dmsm1":"系统设置","mlmc":"系统设置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null}],"twoSeaCodeList":[{"xtlb":"50","dmlb":"0002","dmz":"0101","mldh":"0101","dmsm1":"首页","mlmc":"首页","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0201","mldh":"0201","dmsm1":"实时巡查","mlmc":"实时巡查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0202","mldh":"0202","dmsm1":"视频中心","mlmc":"视频中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0301","mldh":"0301","dmsm1":"误判处置","mlmc":"误判处置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0302","mldh":"0302","dmsm1":"考试异常处理","mlmc":"考试异常处理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0303","mldh":"0303","dmsm1":"预警处理","mlmc":"预警处理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0401","mldh":"0401","dmsm1":"备案信息","mlmc":"备案信息","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0402","mldh":"0402","dmsm1":"考试安排","mlmc":"考试安排","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0403","mldh":"0403","dmsm1":"考试签到","mlmc":"考试签到","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0404","mldh":"0404","dmsm1":"考试签名","mlmc":"考试签名","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0405","mldh":"0405","dmsm1":"考场检查","mlmc":"考场检查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0406","mldh":"0406","dmsm1":"成绩打印","mlmc":"成绩打印","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0407","mldh":"0407","dmsm1":"过程抽查","mlmc":"过程抽查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0408","mldh":"0408","dmsm1":"回访记录","mlmc":"回访记录","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0409","mldh":"0409","dmsm1":"工作台账","mlmc":"工作台账","dmsm2":null,"dmsm3":null,"zt":null,"dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0501","mldh":"0501","dmsm1":"综合分析","mlmc":"综合分析","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0601","mldh":"0601","dmsm1":"文档中心","mlmc":"文档中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0701","mldh":"0701","dmsm1":"摄像头管理","mlmc":"摄像头管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0702","mldh":"0702","dmsm1":"用户管理","mlmc":"用户管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0703","mldh":"0703","dmsm1":"角色管理","mlmc":"角色管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0704","mldh":"0704","dmsm1":"安全策略","mlmc":"安全策略","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0705","mldh":"0705","dmsm1":"功能设置","mlmc":"功能设置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null}],"seaSysuser":{"yhdh":"zhujiye","xm":"朱继业","glbm":"511800000000","bmmc":"雅安交警支队","sjbm":null,"qxms":"1","ipstart":"11.1.1.1","ipend":"254.254.254.254","sfzmhm":"513101196502190054","pwd":"$2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC","zt":"1","ssxt":"1","klyzms":"1","mmyxqz":1552838400000,"zhyxqz":null,"gdip1":null,"gdip2":null,"gdip3":null,"kcxh":"51000592","photo":null,"ssjs":"5","cjsj":1543248000000,"gxsj":1542038400000},"sysUser":{"yhdh":"zhujiye","xm":"朱继业","glbm":"511800000000","bmmc":"雅安交警支队","sjbm":null,"qxms":"1","ipstart":"11.1.1.1","ipend":"254.254.254.254","sfzmhm":"513101196502190054","pwd":"$2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC","zt":"1","ssxt":"1","klyzms":"1","mmyxqz":1552838400000,"zhyxqz":null,"gdip1":null,"gdip2":null,"gdip3":null,"kcxh":"51000592","photo":null,"ssjs":"5","cjsj":1543248000000,"gxsj":1542038400000}}
     * loginSuccess : true
     */

    private String Authorization;
    private ApplicationUserBean applicationUser;
    private boolean success;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String Authorization) {
        this.Authorization = Authorization;
    }

    public ApplicationUserBean getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUserBean applicationUser) {
        this.applicationUser = applicationUser;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class ApplicationUserBean {
        /**
         * password : null
         * username : zhujiye
         * authorities : [{"authority":"01#010101"},{"authority":"01#010102"},{"authority":"02#020101"},{"authority":"02#020102"},{"authority":"02#020103"},{"authority":"02#020104"},{"authority":"02#020105"},{"authority":"02#020106"},{"authority":"02#020107"},{"authority":"03#030101"},{"authority":"03#030102"},{"authority":"03#030103"},{"authority":"03#030104"},{"authority":"03#030105"},{"authority":"03#030106"},{"authority":"03#030107"},{"authority":"03#030108"},{"authority":"03#030109"},{"authority":"03#030110"},{"authority":"03#030111"},{"authority":"04#040101"},{"authority":"04#040102"},{"authority":"04#040103"},{"authority":"04#040104"},{"authority":"04#040105"},{"authority":"04#040106"},{"authority":"04#040107"},{"authority":"04#040108"},{"authority":"04#040109"},{"authority":"04#040110"},{"authority":"04#040111"},{"authority":"04#040112"},{"authority":"04#040113"},{"authority":"04#040114"},{"authority":"04#040115"},{"authority":"04#040116"},{"authority":"04#040117"},{"authority":"04#040118"},{"authority":"04#040119"},{"authority":"04#040120"},{"authority":"04#040121"},{"authority":"04#040122"},{"authority":"04#040123"},{"authority":"04#040124"},{"authority":"04#040125"},{"authority":"04#040126"},{"authority":"04#040127"},{"authority":"04#040128"},{"authority":"04#040129"},{"authority":"04#040130"},{"authority":"04#040131"},{"authority":"04#040132"},{"authority":"04#040133"},{"authority":"04#040134"},{"authority":"04#040135"},{"authority":"05#050101"},{"authority":"05#050102"},{"authority":"05#050103"},{"authority":"05#050104"},{"authority":"05#050105"},{"authority":"05#050106"},{"authority":"05#050107"},{"authority":"05#050108"},{"authority":"05#050109"},{"authority":"06#060101"},{"authority":"07#070101"},{"authority":"07#070102"},{"authority":"07#070103"},{"authority":"07#070104"},{"authority":"07#070105"},{"authority":"07#070106"},{"authority":"07#070107"},{"authority":"07#070108"},{"authority":"07#070109"},{"authority":"07#070110"},{"authority":"07#070111"},{"authority":"07#070112"},{"authority":"07#070113"},{"authority":"07#070114"}]
         * accountNonExpired : true
         * accountNonLocked : true
         * credentialsNonExpired : true
         * enabled : true
         * programs : [{"xtlb":"01","mldh":"0101","qxdm":"010101","qxmc":"首页","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/homepage/home","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"01","mldh":"0101","qxdm":"010102","qxmc":"首页V2","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/homepage/homev2","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020101","qxmc":"考场巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/sitIns","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020102","qxmc":"考台巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=1","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020103","qxmc":"考试车巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=2","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020104","qxmc":"候考区巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=3","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0201","qxdm":"020105","qxmc":"监控中心巡查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/inspection?vedio=4","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0202","qxdm":"020106","qxmc":"视频查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/videoQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"02","mldh":"0202","qxdm":"020107","qxmc":"视频回放","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/supervision/videoPlayback","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030101","qxmc":"误判查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030102","qxmc":"误判申请","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missApply","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0301","qxdm":"030103","qxmc":"误判审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/missVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030104","qxmc":"考试异常查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/examMissDeal","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030105","qxmc":"考试作弊采集","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/cheatCollection","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030106","qxmc":"考试作弊审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/cheatVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030107","qxmc":"手工扣分查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/deduction","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0302","qxdm":"030108","qxmc":"手工结束考试查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/endExam","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030109","qxmc":"预警审核","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/waitVerify","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030110","qxmc":"预警处理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/waitDeal","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"03","mldh":"0303","qxdm":"030111","qxmc":"历史预警","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/exception/warningHistory","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040101","qxmc":"考试场地","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examSite","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040102","qxmc":"考试设备","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDevice","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040103","qxmc":"考台","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDesktop","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040104","qxmc":"考试车辆","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examVehicle","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040105","qxmc":"考试员","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examPerson","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040106","qxmc":"考试系统","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examSystem","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040107","qxmc":"驾校","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examDriverSchool","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040108","qxmc":"考场员工","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examStaff","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0401","qxdm":"040109","qxmc":"考场员工黑名单","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/blackList","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040110","qxmc":"考试预约","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examBooking","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040111","qxmc":"考试计划","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examPlan","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0402","qxdm":"040112","qxmc":"考台分配","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examTableAsign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040113","qxmc":"考试员签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examStaffSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040114","qxmc":"助考员签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examExtraStaffSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0403","qxdm":"040115","qxmc":"考生签到","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/studentSignIn","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040116","qxmc":"考试签名查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/signQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040117","qxmc":"考试员签名","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examinerSign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0404","qxdm":"040118","qxmc":"考生签名","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/examineeSign","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040119","qxmc":"考场检查查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040120","qxmc":"考前检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckBefore","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040121","qxmc":"考中检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckDoing","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040122","qxmc":"考后检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/siteCheckFinish","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0405","qxdm":"040123","qxmc":"设备检查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/deviceCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0406","qxdm":"040124","qxmc":"批量打印","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/batchPrint","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0406","qxdm":"040125","qxmc":"成绩打印","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/singlePrint","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040126","qxmc":"抽查记录查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/processCheck","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040127","qxmc":"考试过程抽查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/processQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0407","qxdm":"040128","qxmc":"记录仪抽查","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/recordMachineQuery","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040129","qxmc":"回访情况查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/callbackCommand","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040130","qxmc":"考生意见查询","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/studentRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0408","qxdm":"040131","qxmc":"回访考生","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/callbackStudent","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040132","qxmc":"工作报告","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/workRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040133","qxmc":"整改记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/rectifyRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040134","qxmc":"通报记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/avioRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"04","mldh":"0409","qxdm":"040135","qxmc":"约谈记录","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/workManage/talkRecord","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050101","qxmc":"综合分析","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/homepage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050102","qxmc":"考试地点","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/site","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050103","qxmc":"考试原因","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/reason","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050104","qxmc":"所属驾校","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/school","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050105","qxmc":"考试项目","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/subject","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050106","qxmc":"考试车型","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/car","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050107","qxmc":"考试员 ","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/person","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050108","qxmc":"考车编号","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/carNumber","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"05","mldh":"0501","qxdm":"050109","qxmc":"本/异地考生","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/analysisManage/studentSource","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"06","mldh":"0601","qxdm":"060101","qxmc":"文档中心","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/documentCenter/doc","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070101","qxmc":"科目一科目四","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraManage14","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070102","qxmc":"科目二科目三","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraManage23","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070103","qxmc":"候考区","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraWaitRoom","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0701","qxdm":"070104","qxmc":"监控区","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraMonitor","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0702","qxdm":"070105","qxmc":"用户管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/userManage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0703","qxdm":"070106","qxmc":"角色管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/roleManage","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0704","qxdm":"070107","qxmc":"安全策略","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/visitControl","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070108","qxmc":"考试员签名设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/examinerSignSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070109","qxmc":"回访设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/returnVisit","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070110","qxmc":"预警设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/earlyWarning","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070111","qxmc":"抽查设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/seletedSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070112","qxmc":"本异地比例设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/scaleSetting","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070113","qxmc":"8700参数设置","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/cameraParameters","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false},{"xtlb":"07","mldh":"0705","qxdm":"070114","qxmc":"广告位管理","hbbj":"0","ssxt":"T","ssks":null,"sfxf":null,"zt":"1","url":"/dashboard/systemManage/adsManager","sxh":null,"qxsx":null,"ckms":null,"ctrlUrl":null,"btn":null,"xzbj":false,"anbj":false}]
         * oneSeaCodeList : [{"xtlb":"50","dmlb":"0001","dmz":"01","mldh":"01","dmsm1":"首页","mlmc":"首页","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"02","mldh":"02","dmsm1":"考试监管","mlmc":"考试监管","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"03","mldh":"03","dmsm1":"异常管理","mlmc":"异常管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"04","mldh":"04","dmsm1":"工作管理","mlmc":"工作管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"05","mldh":"05","dmsm1":"统计分析","mlmc":"统计分析","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"06","mldh":"06","dmsm1":"文档中心","mlmc":"文档中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0001","dmz":"07","mldh":"07","dmsm1":"系统设置","mlmc":"系统设置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null}]
         * twoSeaCodeList : [{"xtlb":"50","dmlb":"0002","dmz":"0101","mldh":"0101","dmsm1":"首页","mlmc":"首页","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0201","mldh":"0201","dmsm1":"实时巡查","mlmc":"实时巡查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0202","mldh":"0202","dmsm1":"视频中心","mlmc":"视频中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0301","mldh":"0301","dmsm1":"误判处置","mlmc":"误判处置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0302","mldh":"0302","dmsm1":"考试异常处理","mlmc":"考试异常处理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0303","mldh":"0303","dmsm1":"预警处理","mlmc":"预警处理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0401","mldh":"0401","dmsm1":"备案信息","mlmc":"备案信息","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0402","mldh":"0402","dmsm1":"考试安排","mlmc":"考试安排","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0403","mldh":"0403","dmsm1":"考试签到","mlmc":"考试签到","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0404","mldh":"0404","dmsm1":"考试签名","mlmc":"考试签名","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0405","mldh":"0405","dmsm1":"考场检查","mlmc":"考场检查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0406","mldh":"0406","dmsm1":"成绩打印","mlmc":"成绩打印","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0407","mldh":"0407","dmsm1":"过程抽查","mlmc":"过程抽查","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0408","mldh":"0408","dmsm1":"回访记录","mlmc":"回访记录","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0409","mldh":"0409","dmsm1":"工作台账","mlmc":"工作台账","dmsm2":null,"dmsm3":null,"zt":null,"dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0501","mldh":"0501","dmsm1":"综合分析","mlmc":"综合分析","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0601","mldh":"0601","dmsm1":"文档中心","mlmc":"文档中心","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0701","mldh":"0701","dmsm1":"摄像头管理","mlmc":"摄像头管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0702","mldh":"0702","dmsm1":"用户管理","mlmc":"用户管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0703","mldh":"0703","dmsm1":"角色管理","mlmc":"角色管理","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0704","mldh":"0704","dmsm1":"安全策略","mlmc":"安全策略","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null},{"xtlb":"50","dmlb":"0002","dmz":"0705","mldh":"0705","dmsm1":"功能设置","mlmc":"功能设置","dmsm2":null,"dmsm3":null,"zt":"1","dmsm4":null}]
         * seaSysuser : {"yhdh":"zhujiye","xm":"朱继业","glbm":"511800000000","bmmc":"雅安交警支队","sjbm":null,"qxms":"1","ipstart":"11.1.1.1","ipend":"254.254.254.254","sfzmhm":"513101196502190054","pwd":"$2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC","zt":"1","ssxt":"1","klyzms":"1","mmyxqz":1552838400000,"zhyxqz":null,"gdip1":null,"gdip2":null,"gdip3":null,"kcxh":"51000592","photo":null,"ssjs":"5","cjsj":1543248000000,"gxsj":1542038400000}
         * sysUser : {"yhdh":"zhujiye","xm":"朱继业","glbm":"511800000000","bmmc":"雅安交警支队","sjbm":null,"qxms":"1","ipstart":"11.1.1.1","ipend":"254.254.254.254","sfzmhm":"513101196502190054","pwd":"$2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC","zt":"1","ssxt":"1","klyzms":"1","mmyxqz":1552838400000,"zhyxqz":null,"gdip1":null,"gdip2":null,"gdip3":null,"kcxh":"51000592","photo":null,"ssjs":"5","cjsj":1543248000000,"gxsj":1542038400000}
         */

        private Object password;
        private String username;
        private boolean accountNonExpired;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        private boolean enabled;
        private SeaSysuserBean seaSysuser;
        private SysUserBean sysUser;
        private List<AuthoritiesBean> authorities;
        private List<ProgramsBean> programs;
        private List<OneSeaCodeListBean> oneSeaCodeList;
        private List<TwoSeaCodeListBean> twoSeaCodeList;

        public Object getPassword() {
            return password;
        }

        public void setPassword(Object password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
        }

        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
        }

        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public SeaSysuserBean getSeaSysuser() {
            return seaSysuser;
        }

        public void setSeaSysuser(SeaSysuserBean seaSysuser) {
            this.seaSysuser = seaSysuser;
        }

        public SysUserBean getSysUser() {
            return sysUser;
        }

        public void setSysUser(SysUserBean sysUser) {
            this.sysUser = sysUser;
        }

        public List<AuthoritiesBean> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(List<AuthoritiesBean> authorities) {
            this.authorities = authorities;
        }

        public List<ProgramsBean> getPrograms() {
            return programs;
        }

        public void setPrograms(List<ProgramsBean> programs) {
            this.programs = programs;
        }

        public List<OneSeaCodeListBean> getOneSeaCodeList() {
            return oneSeaCodeList;
        }

        public void setOneSeaCodeList(List<OneSeaCodeListBean> oneSeaCodeList) {
            this.oneSeaCodeList = oneSeaCodeList;
        }

        public List<TwoSeaCodeListBean> getTwoSeaCodeList() {
            return twoSeaCodeList;
        }

        public void setTwoSeaCodeList(List<TwoSeaCodeListBean> twoSeaCodeList) {
            this.twoSeaCodeList = twoSeaCodeList;
        }

        public static class SeaSysuserBean {
            /**
             * yhdh : zhujiye
             * xm : 朱继业
             * glbm : 511800000000
             * bmmc : 雅安交警支队
             * sjbm : null
             * qxms : 1
             * ipstart : 11.1.1.1
             * ipend : 254.254.254.254
             * sfzmhm : 513101196502190054
             * pwd : $2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC
             * zt : 1
             * ssxt : 1
             * klyzms : 1
             * mmyxqz : 1552838400000
             * zhyxqz : null
             * gdip1 : null
             * gdip2 : null
             * gdip3 : null
             * kcxh : 51000592
             * photo : null
             * ssjs : 5
             * cjsj : 1543248000000
             * gxsj : 1542038400000
             */

            private String yhdh;
            private String xm;
            private String glbm;
            private String bmmc;
            private Object sjbm;
            private String qxms;
            private String ipstart;
            private String ipend;
            private String sfzmhm;
            private String pwd;
            private String zt;
            private String ssxt;
            private String klyzms;
            private long mmyxqz;
            private Object zhyxqz;
            private Object gdip1;
            private Object gdip2;
            private Object gdip3;
            private String kcxh;
            private Object photo;
            private String ssjs;
            private long cjsj;
            private long gxsj;

            public String getYhdh() {
                return yhdh;
            }

            public void setYhdh(String yhdh) {
                this.yhdh = yhdh;
            }

            public String getXm() {
                return xm;
            }

            public void setXm(String xm) {
                this.xm = xm;
            }

            public String getGlbm() {
                return glbm;
            }

            public void setGlbm(String glbm) {
                this.glbm = glbm;
            }

            public String getBmmc() {
                return bmmc;
            }

            public void setBmmc(String bmmc) {
                this.bmmc = bmmc;
            }

            public Object getSjbm() {
                return sjbm;
            }

            public void setSjbm(Object sjbm) {
                this.sjbm = sjbm;
            }

            public String getQxms() {
                return qxms;
            }

            public void setQxms(String qxms) {
                this.qxms = qxms;
            }

            public String getIpstart() {
                return ipstart;
            }

            public void setIpstart(String ipstart) {
                this.ipstart = ipstart;
            }

            public String getIpend() {
                return ipend;
            }

            public void setIpend(String ipend) {
                this.ipend = ipend;
            }

            public String getSfzmhm() {
                return sfzmhm;
            }

            public void setSfzmhm(String sfzmhm) {
                this.sfzmhm = sfzmhm;
            }

            public String getPwd() {
                return pwd;
            }

            public void setPwd(String pwd) {
                this.pwd = pwd;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public String getSsxt() {
                return ssxt;
            }

            public void setSsxt(String ssxt) {
                this.ssxt = ssxt;
            }

            public String getKlyzms() {
                return klyzms;
            }

            public void setKlyzms(String klyzms) {
                this.klyzms = klyzms;
            }

            public long getMmyxqz() {
                return mmyxqz;
            }

            public void setMmyxqz(long mmyxqz) {
                this.mmyxqz = mmyxqz;
            }

            public Object getZhyxqz() {
                return zhyxqz;
            }

            public void setZhyxqz(Object zhyxqz) {
                this.zhyxqz = zhyxqz;
            }

            public Object getGdip1() {
                return gdip1;
            }

            public void setGdip1(Object gdip1) {
                this.gdip1 = gdip1;
            }

            public Object getGdip2() {
                return gdip2;
            }

            public void setGdip2(Object gdip2) {
                this.gdip2 = gdip2;
            }

            public Object getGdip3() {
                return gdip3;
            }

            public void setGdip3(Object gdip3) {
                this.gdip3 = gdip3;
            }

            public String getKcxh() {
                return kcxh;
            }

            public void setKcxh(String kcxh) {
                this.kcxh = kcxh;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public String getSsjs() {
                return ssjs;
            }

            public void setSsjs(String ssjs) {
                this.ssjs = ssjs;
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
        }

        public static class SysUserBean {
            /**
             * yhdh : zhujiye
             * xm : 朱继业
             * glbm : 511800000000
             * bmmc : 雅安交警支队
             * sjbm : null
             * qxms : 1
             * ipstart : 11.1.1.1
             * ipend : 254.254.254.254
             * sfzmhm : 513101196502190054
             * pwd : $2a$10$SEsOQCXu7Ryhz3MLmLusS.LCFmCsiCuyuep/CHKgTOc/pHeKc/UBC
             * zt : 1
             * ssxt : 1
             * klyzms : 1
             * mmyxqz : 1552838400000
             * zhyxqz : null
             * gdip1 : null
             * gdip2 : null
             * gdip3 : null
             * kcxh : 51000592
             * photo : null
             * ssjs : 5
             * cjsj : 1543248000000
             * gxsj : 1542038400000
             */

            private String yhdh;
            private String xm;
            private String glbm;
            private String bmmc;
            private String sjbm;
            private String qxms;
            private String ipstart;
            private String ipend;
            private String sfzmhm;
            private String pwd;
            private String zt;
            private String ssxt;
            private String klyzms;
            private long mmyxqz;
            private String zhyxqz;
            private String gdip1;
            private String gdip2;
            private String gdip3;
            private String kcxh;
            private String photo;
            private String ssjs;
            private long cjsj;
            private long gxsj;

            public String getYhdh() {
                return yhdh;
            }

            public void setYhdh(String yhdh) {
                this.yhdh = yhdh;
            }

            public String getXm() {
                return xm;
            }

            public void setXm(String xm) {
                this.xm = xm;
            }

            public String getGlbm() {
                return glbm;
            }

            public void setGlbm(String glbm) {
                this.glbm = glbm;
            }

            public String getBmmc() {
                return bmmc;
            }

            public void setBmmc(String bmmc) {
                this.bmmc = bmmc;
            }

            public String getSjbm() {
                return sjbm;
            }

            public void setSjbm(String sjbm) {
                this.sjbm = sjbm;
            }

            public String getQxms() {
                return qxms;
            }

            public void setQxms(String qxms) {
                this.qxms = qxms;
            }

            public String getIpstart() {
                return ipstart;
            }

            public void setIpstart(String ipstart) {
                this.ipstart = ipstart;
            }

            public String getIpend() {
                return ipend;
            }

            public void setIpend(String ipend) {
                this.ipend = ipend;
            }

            public String getSfzmhm() {
                return sfzmhm;
            }

            public void setSfzmhm(String sfzmhm) {
                this.sfzmhm = sfzmhm;
            }

            public String getPwd() {
                return pwd;
            }

            public void setPwd(String pwd) {
                this.pwd = pwd;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public String getSsxt() {
                return ssxt;
            }

            public void setSsxt(String ssxt) {
                this.ssxt = ssxt;
            }

            public String getKlyzms() {
                return klyzms;
            }

            public void setKlyzms(String klyzms) {
                this.klyzms = klyzms;
            }

            public long getMmyxqz() {
                return mmyxqz;
            }

            public void setMmyxqz(long mmyxqz) {
                this.mmyxqz = mmyxqz;
            }

            public String getZhyxqz() {
                return zhyxqz;
            }

            public void setZhyxqz(String zhyxqz) {
                this.zhyxqz = zhyxqz;
            }

            public String getGdip1() {
                return gdip1;
            }

            public void setGdip1(String gdip1) {
                this.gdip1 = gdip1;
            }

            public String getGdip2() {
                return gdip2;
            }

            public void setGdip2(String gdip2) {
                this.gdip2 = gdip2;
            }

            public String getGdip3() {
                return gdip3;
            }

            public void setGdip3(String gdip3) {
                this.gdip3 = gdip3;
            }

            public String getKcxh() {
                return kcxh;
            }

            public void setKcxh(String kcxh) {
                this.kcxh = kcxh;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getSsjs() {
                return ssjs;
            }

            public void setSsjs(String ssjs) {
                this.ssjs = ssjs;
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
        }

        public static class AuthoritiesBean {
            /**
             * authority : 01#010101
             */

            private String authority;

            public String getAuthority() {
                return authority;
            }

            public void setAuthority(String authority) {
                this.authority = authority;
            }
        }

        public static class ProgramsBean {
            /**
             * xtlb : 01
             * mldh : 0101
             * qxdm : 010101
             * qxmc : 首页
             * hbbj : 0
             * ssxt : T
             * ssks : null
             * sfxf : null
             * zt : 1
             * url : /dashboard/homepage/home
             * sxh : null
             * qxsx : null
             * ckms : null
             * ctrlUrl : null
             * btn : null
             * xzbj : false
             * anbj : false
             */

            private String xtlb;
            private String mldh;
            private String qxdm;
            private String qxmc;
            private String hbbj;
            private String ssxt;
            private Object ssks;
            private Object sfxf;
            private String zt;
            private String url;
            private Object sxh;
            private Object qxsx;
            private Object ckms;
            private Object ctrlUrl;
            private Object btn;
            private boolean xzbj;
            private boolean anbj;

            public String getXtlb() {
                return xtlb;
            }

            public void setXtlb(String xtlb) {
                this.xtlb = xtlb;
            }

            public String getMldh() {
                return mldh;
            }

            public void setMldh(String mldh) {
                this.mldh = mldh;
            }

            public String getQxdm() {
                return qxdm;
            }

            public void setQxdm(String qxdm) {
                this.qxdm = qxdm;
            }

            public String getQxmc() {
                return qxmc;
            }

            public void setQxmc(String qxmc) {
                this.qxmc = qxmc;
            }

            public String getHbbj() {
                return hbbj;
            }

            public void setHbbj(String hbbj) {
                this.hbbj = hbbj;
            }

            public String getSsxt() {
                return ssxt;
            }

            public void setSsxt(String ssxt) {
                this.ssxt = ssxt;
            }

            public Object getSsks() {
                return ssks;
            }

            public void setSsks(Object ssks) {
                this.ssks = ssks;
            }

            public Object getSfxf() {
                return sfxf;
            }

            public void setSfxf(Object sfxf) {
                this.sfxf = sfxf;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Object getSxh() {
                return sxh;
            }

            public void setSxh(Object sxh) {
                this.sxh = sxh;
            }

            public Object getQxsx() {
                return qxsx;
            }

            public void setQxsx(Object qxsx) {
                this.qxsx = qxsx;
            }

            public Object getCkms() {
                return ckms;
            }

            public void setCkms(Object ckms) {
                this.ckms = ckms;
            }

            public Object getCtrlUrl() {
                return ctrlUrl;
            }

            public void setCtrlUrl(Object ctrlUrl) {
                this.ctrlUrl = ctrlUrl;
            }

            public Object getBtn() {
                return btn;
            }

            public void setBtn(Object btn) {
                this.btn = btn;
            }

            public boolean isXzbj() {
                return xzbj;
            }

            public void setXzbj(boolean xzbj) {
                this.xzbj = xzbj;
            }

            public boolean isAnbj() {
                return anbj;
            }

            public void setAnbj(boolean anbj) {
                this.anbj = anbj;
            }
        }

        public static class OneSeaCodeListBean {
            /**
             * xtlb : 50
             * dmlb : 0001
             * dmz : 01
             * mldh : 01
             * dmsm1 : 首页
             * mlmc : 首页
             * dmsm2 : null
             * dmsm3 : null
             * zt : 1
             * dmsm4 : null
             */

            private String xtlb;
            private String dmlb;
            private String dmz;
            private String mldh;
            private String dmsm1;
            private String mlmc;
            private Object dmsm2;
            private Object dmsm3;
            private String zt;
            private Object dmsm4;

            public String getXtlb() {
                return xtlb;
            }

            public void setXtlb(String xtlb) {
                this.xtlb = xtlb;
            }

            public String getDmlb() {
                return dmlb;
            }

            public void setDmlb(String dmlb) {
                this.dmlb = dmlb;
            }

            public String getDmz() {
                return dmz;
            }

            public void setDmz(String dmz) {
                this.dmz = dmz;
            }

            public String getMldh() {
                return mldh;
            }

            public void setMldh(String mldh) {
                this.mldh = mldh;
            }

            public String getDmsm1() {
                return dmsm1;
            }

            public void setDmsm1(String dmsm1) {
                this.dmsm1 = dmsm1;
            }

            public String getMlmc() {
                return mlmc;
            }

            public void setMlmc(String mlmc) {
                this.mlmc = mlmc;
            }

            public Object getDmsm2() {
                return dmsm2;
            }

            public void setDmsm2(Object dmsm2) {
                this.dmsm2 = dmsm2;
            }

            public Object getDmsm3() {
                return dmsm3;
            }

            public void setDmsm3(Object dmsm3) {
                this.dmsm3 = dmsm3;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public Object getDmsm4() {
                return dmsm4;
            }

            public void setDmsm4(Object dmsm4) {
                this.dmsm4 = dmsm4;
            }
        }

        public static class TwoSeaCodeListBean {
            /**
             * xtlb : 50
             * dmlb : 0002
             * dmz : 0101
             * mldh : 0101
             * dmsm1 : 首页
             * mlmc : 首页
             * dmsm2 : null
             * dmsm3 : null
             * zt : 1
             * dmsm4 : null
             */

            private String xtlb;
            private String dmlb;
            private String dmz;
            private String mldh;
            private String dmsm1;
            private String mlmc;
            private Object dmsm2;
            private Object dmsm3;
            private String zt;
            private Object dmsm4;

            public String getXtlb() {
                return xtlb;
            }

            public void setXtlb(String xtlb) {
                this.xtlb = xtlb;
            }

            public String getDmlb() {
                return dmlb;
            }

            public void setDmlb(String dmlb) {
                this.dmlb = dmlb;
            }

            public String getDmz() {
                return dmz;
            }

            public void setDmz(String dmz) {
                this.dmz = dmz;
            }

            public String getMldh() {
                return mldh;
            }

            public void setMldh(String mldh) {
                this.mldh = mldh;
            }

            public String getDmsm1() {
                return dmsm1;
            }

            public void setDmsm1(String dmsm1) {
                this.dmsm1 = dmsm1;
            }

            public String getMlmc() {
                return mlmc;
            }

            public void setMlmc(String mlmc) {
                this.mlmc = mlmc;
            }

            public Object getDmsm2() {
                return dmsm2;
            }

            public void setDmsm2(Object dmsm2) {
                this.dmsm2 = dmsm2;
            }

            public Object getDmsm3() {
                return dmsm3;
            }

            public void setDmsm3(Object dmsm3) {
                this.dmsm3 = dmsm3;
            }

            public String getZt() {
                return zt;
            }

            public void setZt(String zt) {
                this.zt = zt;
            }

            public Object getDmsm4() {
                return dmsm4;
            }

            public void setDmsm4(Object dmsm4) {
                this.dmsm4 = dmsm4;
            }
        }
    }
}
