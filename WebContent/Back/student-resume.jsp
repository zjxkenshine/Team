<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String  path = request.getContextPath();
%>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<link href="lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
<title>我的简历</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 学生后台 <span class="c-gray en">&gt;</span> 个人信息 <span class="c-gray en">&gt;</span> 我的简历 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a onclick="Competence_upload(this,${student.getID()})"   class="btn btn-primary radius"> 上传简历（替换掉原来的简历）</a>
	<div class="portfolio-content">
		<ul class="cl portfolio-area">
			<li class="item">
				<div class="portfoliobox">
					<div class="picbox"><a href="${sturesume }" data-lightbox="gallery" data-title="简历"><img src="${sturesume }"></a></div>
					<div class="textbox">我的简历 </div>
				</div>
			</li>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="lib/lightbox2/2.8.1/js/lightbox-plus-jquery.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$.Huihover(".portfolio-area li");
});

function Competence_upload(obj,id){
	layer.open({
	    type: 2 //Page层类型
	   	,area: ['700px', '530px']
	    ,title: '上传照片'
	    ,shade: 0.6 //遮罩透明度
	    ,maxmin: true //允许全屏最小化
	    ,anim: 2 //0-6的动画形式，-1不开启
	    ,content: 'student-uploadResume.jsp',	  
	});
}
</script>
</body>
</html>