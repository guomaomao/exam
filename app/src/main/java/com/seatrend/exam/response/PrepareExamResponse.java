//package com.seatrend.exam.response;
//
//import java.io.Serializable;
//import java.util.List;
//
///**
// * 考前准备
// */
//
//public class PrepareExamResponse extends BaseResponse implements Serializable {
//
//    /**
//     * data : {"pageNo":1,"pageSize":20,"count":399,"list":[{"id":"8108430034666496","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"1","checktime":1536308470000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":"5b923438e5c60b16f8612ab8","id":"8108430034666496"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":"444","photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":"123","photo":null,"id":"8108430034666496"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"}],"project":null},{"id":"8108430034797568","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考中检查","checkstate":"1","checktime":1536308485000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"}],"project":null},{"id":"8108430034895872","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考后检查","checkstate":"1","checktime":1536306858000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430034895872"}},{"id":"8108430034994176","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"ksq21,物理隔离应保证未经身份认证的人员不得进入考试区。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"ksq22,考试项目标线应清晰，桩杆、圆饼、单边桥等项目设施应无移位。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"ksq23,考试项目区域应无标记物、标记线或标准要求以外的设施（小型汽车至少应检查倒车入库、坡道定点停车和起步、侧方停车、直角转弯项目区域，大型汽车至少应检查桩考、通过连续障碍、通过单边桥、坡道定点停车和起步、侧方停车、直角转弯等项目区域）。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"kscl03,考试车辆应无固定油门等现象。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"yspjk01,场地监控应覆盖所有考试项目区域，应能分辨车辆类型及编号。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"yspjk02,车内视频应覆盖驾驶、副驾驶区域及考生考试时操作情况，清晰度应能分辨面部特征，车内拾音器应工作正常。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"yspjk03,音视频监控设备时间应与考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"}],"project":null},{"id":"8108430035256320","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"}],"project":null},{"id":"8108430035354624","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430035354624"}},{"id":"8108430035420160","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"yspjk11,驾驶室监控，应反映驾驶区域考生考试时操作情况和随车考试员情况，能分辨考生面部特征。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"yspjk12,车辆运行前方视频，应能清晰反映车辆运行前方道路和交通情况","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"yspjk13,音视频监控设备的时间应与机动车驾驶人考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"}],"project":null},{"id":"8108430035551232","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"}],"project":null},{"id":"8108430035649536","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430035649536"}},{"id":"8108430035715072","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"}],"project":null},{"id":"8108430035878912","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"}],"project":null},{"id":"8108430036042752","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036042752"}},{"id":"8108430036075520","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"ksq21,物理隔离应保证未经身份认证的人员不得进入考试区。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"ksq22,考试项目标线应清晰，桩杆、圆饼、单边桥等项目设施应无移位。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"ksq23,考试项目区域应无标记物、标记线或标准要求以外的设施（小型汽车至少应检查倒车入库、坡道定点停车和起步、侧方停车、直角转弯项目区域，大型汽车至少应检查桩考、通过连续障碍、通过单边桥、坡道定点停车和起步、侧方停车、直角转弯等项目区域）。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"kscl03,考试车辆应无固定油门等现象。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"yspjk01,场地监控应覆盖所有考试项目区域，应能分辨车辆类型及编号。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"yspjk02,车内视频应覆盖驾驶、副驾驶区域及考生考试时操作情况，清晰度应能分辨面部特征，车内拾音器应工作正常。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"yspjk03,音视频监控设备时间应与考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"}],"project":null},{"id":"8108430036206592","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"}],"project":null},{"id":"8108430036435968","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036435968"}},{"id":"8108430036501504","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"yspjk11,驾驶室监控，应反映驾驶区域考生考试时操作情况和随车考试员情况，能分辨考生面部特征。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"yspjk12,车辆运行前方视频，应能清晰反映车辆运行前方道路和交通情况","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"yspjk13,音视频监控设备的时间应与机动车驾驶人考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"}],"project":null},{"id":"8108430036632576","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"}],"project":null},{"id":"8108430036796416","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036796416"}},{"id":"8108430036829184","examroom":"成都车管所犀浦科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"1","checktime":1538123088000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"}],"project":null}],"orderDirection":""}
//     * total : 0
//     */
//
//    private DataBean data;
//    private int total;
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
//    public static class DataBean implements Serializable {
//        /**
//         * pageNo : 1
//         * pageSize : 20
//         * count : 399
//         * list : [{"id":"8108430034666496","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"1","checktime":1536308470000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":"5b923438e5c60b16f8612ab8","id":"8108430034666496"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":"444","photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":"123","photo":null,"id":"8108430034666496"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"}],"project":null},{"id":"8108430034797568","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考中检查","checkstate":"1","checktime":1536308485000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"1","remark":null,"photo":null,"id":"8108430034797568"}],"project":null},{"id":"8108430034895872","examroom":"成都市青白江祥安汽车驾驶人科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考后检查","checkstate":"1","checktime":1536306858000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430034895872"}},{"id":"8108430034994176","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"ksq21,物理隔离应保证未经身份认证的人员不得进入考试区。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"ksq22,考试项目标线应清晰，桩杆、圆饼、单边桥等项目设施应无移位。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"ksq23,考试项目区域应无标记物、标记线或标准要求以外的设施（小型汽车至少应检查倒车入库、坡道定点停车和起步、侧方停车、直角转弯项目区域，大型汽车至少应检查桩考、通过连续障碍、通过单边桥、坡道定点停车和起步、侧方停车、直角转弯等项目区域）。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"kscl03,考试车辆应无固定油门等现象。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":1,"checkpoint":"yspjk01,场地监控应覆盖所有考试项目区域，应能分辨车辆类型及编号。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"yspjk02,车内视频应覆盖驾驶、副驾驶区域及考生考试时操作情况，清晰度应能分辨面部特征，车内拾音器应工作正常。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"yspjk03,音视频监控设备时间应与考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430034994176"}],"project":null},{"id":"8108430035256320","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035256320"}],"project":null},{"id":"8108430035354624","examroom":"成都市青白江祥安科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430035354624"}},{"id":"8108430035420160","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":1,"checkpoint":"yspjk11,驾驶室监控，应反映驾驶区域考生考试时操作情况和随车考试员情况，能分辨考生面部特征。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"yspjk12,车辆运行前方视频，应能清晰反映车辆运行前方道路和交通情况","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"yspjk13,音视频监控设备的时间应与机动车驾驶人考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430035420160"}],"project":null},{"id":"8108430035551232","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035551232"}],"project":null},{"id":"8108430035649536","examroom":"成都市青白江祥安科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430035649536"}},{"id":"8108430035715072","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430035715072"}],"project":null},{"id":"8108430035878912","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430035878912"}],"project":null},{"id":"8108430036042752","examroom":"成都市机动车驾驶人金堂科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036042752"}},{"id":"8108430036075520","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"ksq21,物理隔离应保证未经身份认证的人员不得进入考试区。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"ksq22,考试项目标线应清晰，桩杆、圆饼、单边桥等项目设施应无移位。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"ksq23,考试项目区域应无标记物、标记线或标准要求以外的设施（小型汽车至少应检查倒车入库、坡道定点停车和起步、侧方停车、直角转弯项目区域，大型汽车至少应检查桩考、通过连续障碍、通过单边桥、坡道定点停车和起步、侧方停车、直角转弯等项目区域）。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"kscl03,考试车辆应无固定油门等现象。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":1,"checkpoint":"yspjk01,场地监控应覆盖所有考试项目区域，应能分辨车辆类型及编号。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"yspjk02,车内视频应覆盖驾驶、副驾驶区域及考生考试时操作情况，清晰度应能分辨面部特征，车内拾音器应工作正常。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"yspjk03,音视频监控设备时间应与考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036075520"}],"project":null},{"id":"8108430036206592","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036206592"}],"project":null},{"id":"8108430036435968","examroom":"成都市机动车驾驶人金堂科目二考场","checker":null,"checkerId":null,"examsubject":"科目二","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036435968"}},{"id":"8108430036501504","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考前检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"kscl01,考试车辆状态应正常（至少包括车载天线位置、离合器、档位、方向盘、后视镜、油量等）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"kscl02,考试车辆应无标记物及标记线（至少应包括引擎盖、风窗玻璃、车门、中控台、货厢等位置）。","pointtype":"考试车辆","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"ksxt01,考试系统的卫星定位工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":1,"checkpoint":"yspjk11,驾驶室监控，应反映驾驶区域考生考试时操作情况和随车考试员情况，能分辨考生面部特征。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"yspjk12,车辆运行前方视频，应能清晰反映车辆运行前方道路和交通情况","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"yspjk13,音视频监控设备的时间应与机动车驾驶人考试监管系统同步。","pointtype":"音视频系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":2,"checkpoint":"ksxt02,考试系统网络状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":3,"checkpoint":"ksxt03,车载信号(安全带、转向灯、点火开关等）采集设备的工作状态。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"},{"resultOrder":4,"checkpoint":"ksxt04,播报语音考试指令应清晰。","pointtype":"考试系统","result":"0","remark":null,"photo":null,"id":"8108430036501504"}],"project":null},{"id":"8108430036632576","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考中检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"kzjc01,考试区秩序。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":2,"checkpoint":"kzjc02,公示、公告设备工作状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":3,"checkpoint":"kzjc03,考试用计算机。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"},{"resultOrder":4,"checkpoint":"kzjc04,音视频监控设备状态。","pointtype":"考中检查","result":"0","remark":null,"photo":null,"id":"8108430036632576"}],"project":null},{"id":"8108430036796416","examroom":"成都市机动车驾驶人金堂科目三考场","checker":null,"checkerId":null,"examsubject":"科目三","checktype":"考后检查","checkstate":"0","checktime":null,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":null,"project":{"monitorsituation":null,"monitorsituationResult":null,"monitorsituationPhoto":null,"examnumber":null,"qualifiednumber":null,"qualifiedrate":null,"examdataPerson":null,"examdata":null,"unusualdata":null,"unusualdataResult":null,"emergencies":null,"emergenciesResult":null,"beforeexamcheck":null,"beforeexamcheckResult":null,"faultequipment":null,"faultequipmentResult":null,"videosaved":null,"videosavedResult":null,"videosavedPerson":null,"remark":null,"id":"8108430036796416"}},{"id":"8108430036829184","examroom":"成都车管所犀浦科目一考场","checker":null,"checkerId":null,"examsubject":"科目一/四","checktype":"考前检查","checkstate":"1","checktime":1538123088000,"examtime":1536249600000,"middleid":null,"middlechecker":null,"middletime":null,"projects":[{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430036829184"}],"project":null}]
//         * orderDirection :
//         */
//
//        private int pageNo;
//        private int pageSize;
//        private int count;
//        private String orderDirection;
//        private List<ListBean> list;
//
//        public int getPageNo() {
//            return pageNo;
//        }
//
//        public void setPageNo(int pageNo) {
//            this.pageNo = pageNo;
//        }
//
//        public int getPageSize() {
//            return pageSize;
//        }
//
//        public void setPageSize(int pageSize) {
//            this.pageSize = pageSize;
//        }
//
//        public int getCount() {
//            return count;
//        }
//
//        public void setCount(int count) {
//            this.count = count;
//        }
//
//        public String getOrderDirection() {
//            return orderDirection;
//        }
//
//        public void setOrderDirection(String orderDirection) {
//            this.orderDirection = orderDirection;
//        }
//
//        public List<ListBean> getList() {
//            return list;
//        }
//
//        public void setList(List<ListBean> list) {
//            this.list = list;
//        }
//
//        public static class ListBean implements Serializable {
//            /**
//             * id : 8108430034666496
//             * examroom : 成都市青白江祥安汽车驾驶人科目一考场
//             * checker : null
//             * checkerId : null
//             * examsubject : 科目一/四
//             * checktype : 考前检查
//             * checkstate : 1
//             * checktime : 1536308470000
//             * examtime : 1536249600000
//             * middleid : null
//             * middlechecker : null
//             * middletime : null
//             * projects : [{"resultOrder":1,"checkpoint":"hkq01,身份认证设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"hkq02,考试区视频实时视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":null,"photo":"5b923438e5c60b16f8612ab8","id":"8108430034666496"},{"resultOrder":3,"checkpoint":"hkq03,交通安全宣传视频播放设备应能正常工作。","pointtype":"候考区","result":"0","remark":"444","photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"hkq04,考试组织动态信息公告设备应能正常工作。","pointtype":"候考区","result":"0","remark":"123","photo":null,"id":"8108430034666496"},{"resultOrder":1,"checkpoint":"ksq01,视频监控应能清晰反映所有考位及考位周围情况。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":2,"checkpoint":"ksq02,身份认证设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":3,"checkpoint":"ksq03,照明设备等应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":4,"checkpoint":"ksq04,屏蔽和干扰作弊设备应能正常工作。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":5,"checkpoint":"ksq05,考试用计算机数量应与备案一致。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":6,"checkpoint":"ksq06,考试用计算机应禁用USB、光驱、软驱等设备。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"},{"resultOrder":7,"checkpoint":"ksq07,考试用计算机的操作键盘或鼠标功能应正常。","pointtype":"考试区","result":"0","remark":null,"photo":null,"id":"8108430034666496"}]
//             * project : null
//             */
//
//            private String id;
//            private String examroom;
//            private Object checker;
//            private String checkerId;
//            private String examsubject;
//            private String checktype;
//            private String checkstate;
//            private String status;
//            private long checktime;
//            private long examtime;
//            private Object middleid;
//            private Object middlechecker;
//            private Object middletime;
//            private ProjectBean project;
//            private List<ProjectsBean> projects;
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public String getId() {
//                return id;
//            }
//
//            public void setId(String id) {
//                this.id = id;
//            }
//
//            public String getExamroom() {
//                return examroom;
//            }
//
//            public void setExamroom(String examroom) {
//                this.examroom = examroom;
//            }
//
//            public Object getChecker() {
//                return checker;
//            }
//
//            public void setChecker(Object checker) {
//                this.checker = checker;
//            }
//
//            public String getCheckerId() {
//                return checkerId;
//            }
//
//            public void setCheckerId(String checkerId) {
//                this.checkerId = checkerId;
//            }
//
//            public String getExamsubject() {
//                return examsubject;
//            }
//
//            public void setExamsubject(String examsubject) {
//                this.examsubject = examsubject;
//            }
//
//            public String getChecktype() {
//                return checktype;
//            }
//
//            public void setChecktype(String checktype) {
//                this.checktype = checktype;
//            }
//
//            public String getCheckstate() {
//                return checkstate;
//            }
//
//            public void setCheckstate(String checkstate) {
//                this.checkstate = checkstate;
//            }
//
//            public long getChecktime() {
//                return checktime;
//            }
//
//            public void setChecktime(long checktime) {
//                this.checktime = checktime;
//            }
//
//            public long getExamtime() {
//                return examtime;
//            }
//
//            public void setExamtime(long examtime) {
//                this.examtime = examtime;
//            }
//
//            public Object getMiddleid() {
//                return middleid;
//            }
//
//            public void setMiddleid(Object middleid) {
//                this.middleid = middleid;
//            }
//
//            public Object getMiddlechecker() {
//                return middlechecker;
//            }
//
//            public void setMiddlechecker(Object middlechecker) {
//                this.middlechecker = middlechecker;
//            }
//
//            public Object getMiddletime() {
//                return middletime;
//            }
//
//            public void setMiddletime(Object middletime) {
//                this.middletime = middletime;
//            }
//
//            public ProjectBean getProject() {
//                return project;
//            }
//
//            public void setProject(ProjectBean project) {
//                this.project = project;
//            }
//
//            public List<ProjectsBean> getProjects() {
//                return projects;
//            }
//
//            public void setProjects(List<ProjectsBean> projects) {
//                this.projects = projects;
//            }
//
//            public static class ProjectsBean implements Serializable {
//                /**
//                 * resultOrder : 1
//                 * checkpoint : hkq01,身份认证设备应能正常工作。
//                 * pointtype : 候考区
//                 * result : 0
//                 * remark : null
//                 * photo : null
//                 * id : 8108430034666496
//                 */
//
//                private int resultOrder;
//                private String checkpoint;
//                private String pointtype;
//                private String result;
//                private Object remark;
//                private String photo;
//                private String id;
//                private String examroom;
//                private String checker;
//                private long checktime;
//
//                public String getExamroom() {
//                    return examroom;
//                }
//
//                public void setExamroom(String examroom) {
//                    this.examroom = examroom;
//                }
//
//                public String getChecker() {
//                    return checker;
//                }
//
//                public void setChecker(String checker) {
//                    this.checker = checker;
//                }
//
//                public long getChecktime() {
//                    return checktime;
//                }
//
//                public void setChecktime(long checktime) {
//                    this.checktime = checktime;
//                }
//
//                public int getResultOrder() {
//                    return resultOrder;
//                }
//
//                public void setResultOrder(int resultOrder) {
//                    this.resultOrder = resultOrder;
//                }
//
//                public String getCheckpoint() {
//                    return checkpoint;
//                }
//
//                public void setCheckpoint(String checkpoint) {
//                    this.checkpoint = checkpoint;
//                }
//
//                public String getPointtype() {
//                    return pointtype;
//                }
//
//                public void setPointtype(String pointtype) {
//                    this.pointtype = pointtype;
//                }
//
//                public String getResult() {
//                    return result;
//                }
//
//                public void setResult(String result) {
//                    this.result = result;
//                }
//
//                public Object getRemark() {
//                    return remark;
//                }
//
//                public void setRemark(Object remark) {
//                    this.remark = remark;
//                }
//
//                public String getPhoto() {
//                    return photo;
//                }
//
//                public void setPhoto(String photo) {
//                    this.photo = photo;
//                }
//
//                public String getId() {
//                    return id;
//                }
//
//                public void setId(String id) {
//                    this.id = id;
//                }
//            }
//
//            public static class ProjectBean implements Serializable {
//                /**
//                 * beforeexamcheck : string
//                 * beforeexamcheckResult : string
//                 * emergencies : string
//                 * emergenciesResult : string
//                 * examdata : string
//                 * examdataPerson : string
//                 * examnumber : string
//                 * faultequipment : string
//                 * faultequipmentResult : string
//                 * id : string
//                 * monitorsituation : string
//                 * monitorsituationPhoto : string
//                 * monitorsituationResult : string
//                 * qualifiednumber : string
//                 * qualifiedrate : string
//                 * remark : string
//                 * unusualdata : string
//                 * unusualdataResult : string
//                 * videosaved : string
//                 * videosavedPerson : string
//                 * videosavedResult : string
//                 */
//
//                private String beforeexamcheck;
//                private String beforeexamcheckResult;
//                private String emergencies;
//                private String emergenciesResult;
//                private String examdata;
//                private String examdataPerson;
//                private String examnumber;
//                private String faultequipment;
//                private String faultequipmentResult;
//                private String id;
//                private String monitorsituation;
//                private String monitorsituationPhoto;
//                private String monitorsituationResult;
//                private String qualifiednumber;
//                private String qualifiedrate;
//                private String remark;
//                private String unusualdata;
//                private String unusualdataResult;
//                private String videosaved;
//                private String videosavedPerson;
//                private String videosavedResult;
//
//                public String getBeforeexamcheck() {
//                    return beforeexamcheck;
//                }
//
//                public void setBeforeexamcheck(String beforeexamcheck) {
//                    this.beforeexamcheck = beforeexamcheck;
//                }
//
//                public String getBeforeexamcheckResult() {
//                    return beforeexamcheckResult;
//                }
//
//                public void setBeforeexamcheckResult(String beforeexamcheckResult) {
//                    this.beforeexamcheckResult = beforeexamcheckResult;
//                }
//
//                public String getEmergencies() {
//                    return emergencies;
//                }
//
//                public void setEmergencies(String emergencies) {
//                    this.emergencies = emergencies;
//                }
//
//                public String getEmergenciesResult() {
//                    return emergenciesResult;
//                }
//
//                public void setEmergenciesResult(String emergenciesResult) {
//                    this.emergenciesResult = emergenciesResult;
//                }
//
//                public String getExamdata() {
//                    return examdata;
//                }
//
//                public void setExamdata(String examdata) {
//                    this.examdata = examdata;
//                }
//
//                public String getExamdataPerson() {
//                    return examdataPerson;
//                }
//
//                public void setExamdataPerson(String examdataPerson) {
//                    this.examdataPerson = examdataPerson;
//                }
//
//                public String getExamnumber() {
//                    return examnumber;
//                }
//
//                public void setExamnumber(String examnumber) {
//                    this.examnumber = examnumber;
//                }
//
//                public String getFaultequipment() {
//                    return faultequipment;
//                }
//
//                public void setFaultequipment(String faultequipment) {
//                    this.faultequipment = faultequipment;
//                }
//
//                public String getFaultequipmentResult() {
//                    return faultequipmentResult;
//                }
//
//                public void setFaultequipmentResult(String faultequipmentResult) {
//                    this.faultequipmentResult = faultequipmentResult;
//                }
//
//                public String getId() {
//                    return id;
//                }
//
//                public void setId(String id) {
//                    this.id = id;
//                }
//
//                public String getMonitorsituation() {
//                    return monitorsituation;
//                }
//
//                public void setMonitorsituation(String monitorsituation) {
//                    this.monitorsituation = monitorsituation;
//                }
//
//                public String getMonitorsituationPhoto() {
//                    return monitorsituationPhoto;
//                }
//
//                public void setMonitorsituationPhoto(String monitorsituationPhoto) {
//                    this.monitorsituationPhoto = monitorsituationPhoto;
//                }
//
//                public String getMonitorsituationResult() {
//                    return monitorsituationResult;
//                }
//
//                public void setMonitorsituationResult(String monitorsituationResult) {
//                    this.monitorsituationResult = monitorsituationResult;
//                }
//
//                public String getQualifiednumber() {
//                    return qualifiednumber;
//                }
//
//                public void setQualifiednumber(String qualifiednumber) {
//                    this.qualifiednumber = qualifiednumber;
//                }
//
//                public String getQualifiedrate() {
//                    return qualifiedrate;
//                }
//
//                public void setQualifiedrate(String qualifiedrate) {
//                    this.qualifiedrate = qualifiedrate;
//                }
//
//                public String getRemark() {
//                    return remark;
//                }
//
//                public void setRemark(String remark) {
//                    this.remark = remark;
//                }
//
//                public String getUnusualdata() {
//                    return unusualdata;
//                }
//
//                public void setUnusualdata(String unusualdata) {
//                    this.unusualdata = unusualdata;
//                }
//
//                public String getUnusualdataResult() {
//                    return unusualdataResult;
//                }
//
//                public void setUnusualdataResult(String unusualdataResult) {
//                    this.unusualdataResult = unusualdataResult;
//                }
//
//                public String getVideosaved() {
//                    return videosaved;
//                }
//
//                public void setVideosaved(String videosaved) {
//                    this.videosaved = videosaved;
//                }
//
//                public String getVideosavedPerson() {
//                    return videosavedPerson;
//                }
//
//                public void setVideosavedPerson(String videosavedPerson) {
//                    this.videosavedPerson = videosavedPerson;
//                }
//
//                public String getVideosavedResult() {
//                    return videosavedResult;
//                }
//
//                public void setVideosavedResult(String videosavedResult) {
//                    this.videosavedResult = videosavedResult;
//                }
//            }
//        }
//
//    }
//}
