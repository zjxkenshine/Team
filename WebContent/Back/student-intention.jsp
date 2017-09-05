<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="css/tools.css">
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>选择意向职业</title>
</head>
<body>
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>意向职业：</label>
      <div class="formControls col-5">
       <input type="text" id="category" placeholder="请选择职业分类" readonly="readonly" />
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
    </form>
    <!--职位开始-->
<div id="msgbg" class="msgbg"></div>

<div id="msg" class="msg">
    <div class="panelBox panel_select_category_b">
        <h2>
            <span style="cursor:pointer;" id="close_bth" class="panel_closebtn close_layer">
                确定
            </span>
        </h2>
        <div class="titleBottom">
            <b class="titlebot_th">
                已选职位：
            </b>
            <span id="data_checkbox">

            </span>
        </div>
        <table width="100%" cellspacing="0" cellpadding="0" border="0" class="specialtyTable">
            <tbody>
                <tr class="">
                    <td class="tableTitle" rowspan="3">
                    选择你想要的就业方向
                    </td>
                    <td style="padding-left: 15px;">
                        <p class="twop">
                            <a href="javascript:void(0);">
                              计算机 | 互联网  | 通信 | 电子
                            </a></p>
                            <table class="tinfo">
                                <tr><td><a class="t24" href="javascript:void(0)">计算机软件开发</a></td><td><a class="t25" href="javascript:void(0)">计算机硬件开发</a></td></tr>
                                <tr><td><a class="t26" href="javascript:void(0)">互联网/电子商务/网游</a></td><td><a class="t27" href="javascript:void(0)">网店淘宝</a></td></tr>
                                <tr><td><a class="t28" href="javascript:void(0)">IT-品管、技术支持及其它</a></td><td><a class="t29" href="javascript:void(0)"> 通信技术开发及应用</a></td></tr>
                                <tr><td><a class="t30" href="javascript:void(0)">通信技术开发及应用</a></td><td><a class="t31" href="javascript:void(0)">电子/电器/半导体/仪器仪表</a></td></tr>
                            </table>
                    </td>
                    <td style="padding-left: 15px;">
                        <p class="twop">
                            <a href="javascript:void(0);">
                                    销售/客服/技术支持
                            </a>
                        </p>
                                <table class="tinfo">
                                <tr><td><a class="t32" href="javascript:void(0)">销售管理</a></td></tr>
                                <tr><td><a class="t33" href="javascript:void(0)">销售人员</a></td></tr>
                                <tr><td><a class="t34" href="javascript:void(0)">销售行政及商务</a></td></tr>
                                <tr><td><a class="t35" href="javascript:void(0)">客服及支持</a></td></tr>
                            </table>
                    </td>
                    <td style="padding-left: 15px;">
                        <p class="twop">
                            <a href="javascript:void(0);">
                                    会计/金融/银行/保险
                            </a>
                        </p>
                              <table class="tinfo">
                                <tr><td><a class="t36" href="javascript:void(0)">财务/审计/税务</a></td></tr>
                                <tr><td><a class="t37" href="javascript:void(0)">金融/证券/期货/投资</a></td></tr>
                                <tr><td><a class="t38" href="javascript:void(0)">银行</a></td></tr>
                                <tr><td><a class="t39" href="javascript:void(0)">保险</a></td></tr>
                            </table>
                    </td>
                </tr>
                <tr class="">
                    <td style="padding-left: 15px;">
                        <p  class="twop">
                            <a id="select_expect_funtype_data_6100" href="javascript:void(0);" data-value="6100">
                                生产/营运/采购/物流
                            </a>
                        </p>
                          <table class="tinfo">
                                <tr><td><a class="t40" href="javascript:void(0)">生产/营运</a></td><td><a class="t41" href="javascript:void(0)">质量安全</a></td></tr>
                                <tr><td><a class="t42" href="javascript:void(0)">工程/机械/能源</a></td><td><a class="t43" href="javascript:void(0)">汽车制造</a></td></tr>
                                <tr><td><a class="t44" href="javascript:void(0)">技工普工</a></td><td><a class="t45" href="javascript:void(0)">机械机床</a></td></tr>
                                <tr><td><a class="t46" href="javascript:void(0)">服装/纺织/皮革</a></td><td><a class="t47" href="javascript:void(0)">印刷包装</a></td></tr>
                                <tr><td><a class="t48" href="javascript:void(0)">采购</a></td><td><a class="t49" href="javascript:void(0)">贸易</a></td></tr>
                                <tr><td><a class="t50" href="javascript:void(0)">物流/仓储</a></td><td><a class="t51" href="javascript:void(0)">汽车销售与服务</a></td></tr>
                            </table>
                    </td>
                    <td style="padding-left: 15px;">
                        <p  class="twop">
                            <a id="select_expect_funtype_data_2600" href="javascript:void(0);" data-value="2600">
                               生物/制药/医疗/护理
                            </a>
                        </p>
                         <table class="tinfo">
                                <tr><td><a class="t52" href="javascript:void(0)">生物/制药/医疗器械</a></td></tr>
                                <tr><td><a class="t53" href="javascript:void(0)">化工</a></td></tr>
                                <tr><td><a class="t54" href="javascript:void(0)"> 医院/医疗/护理</a></td></tr>
                            </table>
                    </td>
                    <td style="padding-left: 15px;">
                        <p  class="twop">
                            <a id="select_expect_funtype_data_2700" href="javascript:void(0);" data-value="2700">
                                广告/市场/媒体/艺术
                            </a>
                        </p>
                         <table class="tinfo">
                                <tr><td><a class="t55" href="javascript:void(0)">广告</a></td></tr>
                                <tr><td><a class="t56" href="javascript:void(0)">公关/媒介</a></td></tr>
                                <tr><td><a class="t57" href="javascript:void(0)">市场/营销</a></td></tr>
                                <tr><td><a class="t58" href="javascript:void(0)">影视/媒体</a></td></tr>
                                <tr><td><a class="t59" href="javascript:void(0)">编辑出版</a></td></tr>
                                <tr><td><a class="t60" href="javascript:void(0)">艺术/设计</a></td></tr>
                            </table>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p class="twop">
                            <a id="select_expect_funtype_data_2800" href="javascript:void(0);" data-value="2800">
                                通信技术开发及应用
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_2900" href="javascript:void(0);" data-value="2900">
                                电子/电器/半导体/仪器仪表
                            </a>
                        </p>
                    </td>
                    <td colspan="1">&nbsp;
                        
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="2">
                        销售/客服/技术支持：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0200" href="javascript:void(0);" data-value="0200">
                                销售管理
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3000" href="javascript:void(0);" data-value="3000">
                                销售人员
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3100" href="javascript:void(0);" data-value="3100">
                                销售行政及商务
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3200" href="javascript:void(0);" data-value="3200">
                                客服及支持
                            </a>
                        </p>
                    </td>
                    <td colspan="2">&nbsp;
                        
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="2">
                        会计/金融/银行/保险：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0400" href="javascript:void(0);" data-value="0400">
                                财务/审计/税务
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3300" href="javascript:void(0);" data-value="3300">
                                金融/证券/期货/投资
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_2200" href="javascript:void(0);" data-value="2200">
                                银行
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3400" href="javascript:void(0);" data-value="3400">
                                保险
                            </a>
                        </p>
                    </td>
                    <td colspan="2">&nbsp;
                        
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="4">
                        生产/营运/采购/物流：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3500" href="javascript:void(0);" data-value="3500">
                                生产/营运
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3600" href="javascript:void(0);" data-value="3600">
                                质量安全
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0500" href="javascript:void(0);" data-value="0500">
                                工程/机械/能源
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5400" href="javascript:void(0);" data-value="5400">
                                汽车制造
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3700" href="javascript:void(0);" data-value="3700">
                                技工普工
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_6200" href="javascript:void(0);" data-value="6200">
                                机械机床
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3800" href="javascript:void(0);" data-value="3800">
                                服装/纺织/皮革
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_6300" href="javascript:void(0);" data-value="6300">
                                印刷包装
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_3900" href="javascript:void(0);" data-value="3900">
                                采购
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4000" href="javascript:void(0);" data-value="4000">
                                贸易
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0800" href="javascript:void(0);" data-value="0800">
                                物流/仓储
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5900" href="javascript:void(0);" data-value="5900">
                                汽车销售与服务
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td class="tableTitle" rowspan="1">
                        生物/制药/医疗/护理：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4100" href="javascript:void(0);" data-value="4100">
                                生物/制药/医疗器械
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5500" href="javascript:void(0);" data-value="5500">
                                化工
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1300" href="javascript:void(0);" data-value="1300">
                                医院/医疗/护理
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="2">
                        广告/市场/媒体/艺术：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4200" href="javascript:void(0);" data-value="4200">
                                广告
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4300" href="javascript:void(0);" data-value="4300">
                                公关/媒介
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0300" href="javascript:void(0);" data-value="0300">
                                市场/营销
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4400" href="javascript:void(0);" data-value="4400">
                                影视/媒体
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4500" href="javascript:void(0);" data-value="4500">
                                编辑出版
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0900" href="javascript:void(0);" data-value="0900">
                                艺术/设计
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="2">
                        建筑/房地产：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_2100" href="javascript:void(0);" data-value="2100">
                                建筑工程与装潢
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4600" href="javascript:void(0);" data-value="4600">
                                房地产开发
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4700" href="javascript:void(0);" data-value="4700">
                                物业管理
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_6000" href="javascript:void(0);" data-value="6000">
                                房地产销售与中介
                            </a>
                        </p>
                    </td>
                    <td colspan="2">&nbsp;
                        
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td class="tableTitle" rowspan="1">
                        人事/行政/高级管理：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0600" href="javascript:void(0);" data-value="0600">
                                人力资源
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_0700" href="javascript:void(0);" data-value="0700">
                                高级管理
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_2300" href="javascript:void(0);" data-value="2300">
                                行政/后勤
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="2">
                        咨询/法律/教育/科研：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1400" href="javascript:void(0);" data-value="1400">
                                咨询/顾问
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1100" href="javascript:void(0);" data-value="1100">
                                律师/法务/合规
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1200" href="javascript:void(0);" data-value="1200">
                                教师
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5700" href="javascript:void(0);" data-value="5700">
                                培训
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1000" href="javascript:void(0);" data-value="1000">
                                科研
                            </a>
                        </p>
                    </td>
                    <td colspan="1">&nbsp;
                        
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="3">
                        服务业：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4800" href="javascript:void(0);" data-value="4800">
                                餐饮服务
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_4900" href="javascript:void(0);" data-value="4900">
                                酒店旅游
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5000" href="javascript:void(0);" data-value="5000">
                                美容保健
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_6400" href="javascript:void(0);" data-value="6400">
                                运动健身
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_6500" href="javascript:void(0);" data-value="6500">
                                休闲娱乐
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5100" href="javascript:void(0);" data-value="5100">
                                百货零售
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1800" href="javascript:void(0);" data-value="1800">
                                交通运输服务
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5200" href="javascript:void(0);" data-value="5200">
                                家政保洁
                            </a>
                        </p>
                    </td>
                    <td colspan="1">&nbsp;
                        
                    </td>
                </tr>
                <tr class="">
                    <td class="tableTitle" rowspan="3">
                        公务员/翻译/其他：
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1500" href="javascript:void(0);" data-value="1500">
                                公务员
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_2000" href="javascript:void(0);" data-value="2000">
                                翻译
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1600" href="javascript:void(0);" data-value="1600">
                                在校学生
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1700" href="javascript:void(0);" data-value="1700">
                                储备干部/培训生/实习生
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5300" href="javascript:void(0);" data-value="5300">
                                兼职
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_1900" href="javascript:void(0);" data-value="1900">
                                其他
                            </a>
                        </p>
                    </td>
                </tr>
                <tr class="borderbtm">
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5600" href="javascript:void(0);" data-value="5600">
                                环保
                            </a>
                        </p>
                    </td>
                    <td style="padding-left: 15px;">
                        <p>
                            <a id="select_expect_funtype_data_5800" href="javascript:void(0);" data-value="5800">
                                农/林/牧/渔
                            </a>
                        </p>
                    </td>
                    <td colspan="1">&nbsp;
                        
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	var maxlength = 3;//设置最大允许选择的分类个数
	var height = $(window).height();
	var width = $(window).width();
	var mheight = $("#msg").height();
	var mwidth = $("#msg").width();
	//设置分类选择层的位置居中
//	$("#msg").css({ "left": (width - mwidth)/2 + "px", "bottom": (height - mheight)/4 + "px" });
	//分类文本框点击时切换分类选择层的显示与隐藏
	$("#category").click(function () {
		$("#msgbg").toggle().siblings("#msg").toggle();
	});
	//二级分类标题点击时切换三级分类的显示与隐藏
	$(".twop").click(function () {
		$(this).siblings(".tinfo").toggle();
	});
	//三层分类层鼠标离开时隐藏
	$(".tinfo").mouseleave(function () {
		window.setTimeout($(this).hide());
		;
	});
	//三级分类点击时开始判断并且设置获取分类
	$(".tinfo a").click(function () {
		var classname = $(this).attr("class");//获取被点击的三级分类的class，唯一，一般为分类id
		var valinfo = $(this).text();//获取三级分类的值
		//循环已经选择过的三级分类，如果存在去除
		$("#data_checkbox span").each(function () {
			if ($(this).attr("class") == classname) {
				$(this).remove();
			}
		});
		//获取已经选择的分类的个数，如果超过最大选择项，提示返回
		var length = $("#data_checkbox span").length;
		if (length >= maxlength) {
			alert("最多只能选择"+maxlength+"个职业方向");
			return;
		}
		//将选择的分类追加至指定的区域
		$("#data_checkbox").append('<span class="' + classname + '"><label><b style="color:#0297fd">' + valinfo + '</b></label></span>&nbsp;&nbsp;&nbsp;&nbsp;');
		//分类文本框赋值
		setval();
	});
	//已选择文本框区域的分类项绑定单击事件，点击移除
	$("#data_checkbox span").live("click",function(){
		$(this).remove();
		
		//分类文本框重新赋值
		setval();
	});
	//关闭按钮
	$("#close_bth").click(function () {
		$("#msgbg").hide();
		$("#msg").hide();
	});
	//重新获取最新的选择的分类赋值给分类文本框
	function setval()
	{
		var carray = "";
		$("#data_checkbox span").each(function () {
			carray += $(this).find("b").text()+",";
		});
		carray=carray.substring(0,carray.length-1);
		$("#category").val(carray);
	}
});
</script>
</body>
</html>