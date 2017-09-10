<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String  path = request.getContextPath();
%>
<base href="<%=path%>/Back/">
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
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<style type="text/css">
*{margin:0;padding:0;outline:none;}
body{padding:20px;font:12px "微软雅黑";background:#FFF;}
ul li{list-style:none;}
#schoolName{width:200px;height:30px;line-height:30px;border:1px solid #ccc;padding:0 8px;cursor:pointer;font-size:12px;}
.provinceSchool{display:none;position:relative;width:580px;height:auto;border:1px solid #72B9D7;}
.provinceSchool .title{width:100%;height:30px;background:#72B9D7;cursor:move;}
.provinceSchool .title span{margin-left:10px;font-weight:600;color:#FFF;line-height:30px;}
.provinceSchool .proSelect{width:550px;text-align:center;padding:15px 0;}
.provinceSchool .proSelect select{width:136px;}
.provinceSchool .proSelect span{padding-left:10px;}
.provinceSchool .proSelect input{display:none;}
.provinceSchool .schoolList{width:550px;height:180px;padding:10px 0;overflow-y:auto;border:1px solid #ddd;}
.provinceSchool .schoolList ul{width:510px;clear:both;}
.provinceSchool .schoolList ul span.entertext{display:block;height:180px;font:normal 16px/180px 'microsoft yahei';color:#999;}
.provinceSchool .schoolList ul li{float:left;text-align:center;width:160px;margin:5px;height:25px;line-height:25px;cursor:pointer;background:#fafafa;border-radius:3px;}
.provinceSchool .schoolList ul li.DoubleWidthLi{overflow:hidden;}
.provinceSchool .schoolList ul li:hover{background:#72B9D7;color:#fff;}
.provinceSchool .button{width:100%;height:40px;margin-top:8px;}
.provinceSchool .button button{float:right;height:30px;margin-right:15px;padding:2px 15px;background:#72B9D7;border:none;color:#FFF;font-weight:600;cursor:pointer;border-radius:3px;}
.provinceSchool .button button:hover{background:#2e90bd;}

		/* reset */
		html,body,h1,h2,h3,h4,h5,h6,div,dl,dt,dd,ul,ol,li,p,blockquote,pre,hr,figure,table,caption,th,td,form,fieldset,legend,input,button,textarea,menu{margin:0;padding:0;} 
		
		h1{font-size: 26px;}
		p{font-size: 14px; margin-top: 10px;}
		pre{background:#eee;border:1px solid #ddd;border-left:4px solid #f60;padding:15px;margin-top: 15px;}
		h2{font-size: 20px;margin-top: 20px;}
		.case{margin-top: 15px;width:400px;}

		.bMap{position: relative;}
		.bMap .map-warp{position: absolute;left:0;width:150%;height:350px;top:34px;display: none;}
		.bMap input{width:100%;height:30px;line-height: 30px;border:1px solid #d7d7d7;}
		.tangram-suggestion-main{z-index: 9999}
</style>

<script type="text/javascript" src="lib/school/jquery.min.js"></script>
<script type="text/javascript" src="lib/school/school.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EZPCgQ6zGu6hZSmXlRrUMTpr"></script>
	
<script type="text/javascript" src="lib/Map/map.jquery.js"></script>
<title>招募管理</title>
</head>
<body>
<div class="pd-20">
  <form action="../StudentUpdateItemAddress.sdo" method="post" class="form form-horizontal" id="form-member-add">
   <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>选择地点：</label>
       <div class="formControls col-5">
       	<div class="case">
			 <div class="bMap" id='case1'></div>
		</div>
       </div>
         <div class="col-4"> </div>
    </div>
      <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>关联学校：</label>
       <div class="formControls col-5">
     	<input type="text" class="input-text" value="${Item.getSchool() }" name="School" id="school" placeholder="请点击选择学校" readonly />
     	</div>
	<div id="proSchool" class="provinceSchool">
    <div class="title"><span>请选择学校</span></div>
    <div class="proSelect">
        <select></select>
        <span>如没找到选择项，请选择其他手动填写</span>
        <input type="text" />
    </div>
    <div class="schoolList">
        <ul></ul>
    </div>
    <div class="button">
        
    </div>
</div>	
      <div class="col-4"> </div>
    </div>
	
	<input type="hidden" id="adress_hidden" value="${Item.getAddresss() }">

    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;
        <input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</div>
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>

<!-- alpha div -->
<div id="maskLayer" style="display:none">
<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
	<div id="drag">
		<h3 id="drag_h"></h3>
		<div id="drag_con"></div><!-- drag_con end -->
	</div>
</div><!-- maskLayer end -->
</div>
<!-- alpha div end -->
<div id="sublist" style="display:none"></div>
<script type="text/javascript">
$(function(){

	$("#case1").bMap();
	
	var adress=$("#adress_hidden").val()//百度地图文本框赋初值
	$("#Map_input_map").val(adress);//百度地图文本框赋初值

	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").Validform({
		tiptype:2,
		callback:function(){
		}
	});
});



</script>
</body>
</html>