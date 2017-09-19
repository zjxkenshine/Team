<%@page import="java.util.*"%>
<%@page import="com.back.model.Teacher"%>
<%@page import="com.back.dao.teacher_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     //项目的发布路径，例如：/abcd
     String path=request.getContextPath();
     /*
            全路径，形式如下： http://127.0.0.1:8001/abcd/
     request.getScheme()       ——>http 获取协议
     request.getServerName()   ——>127.0.0.1 获取服务器名
     request.getServerPort()   ——>8001 获取端口号
     path                      ——> /abcd 获取访问的路径
     */
     String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EZPCgQ6zGu6hZSmXlRrUMTpr"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/map.jquery.min.js"></script>
<script type="text/javascript" src="js/school.js"></script>
<style type="text/css">
/*头像预览显示的代码*/
#preview,
.img,
img {
width: 150px;
height: 150px;
}
#preview {
border: 1px solid #000;
}

</style>

<% String teachername =(String) session.getAttribute("TeacherName");
	
%>
<title>教师认证</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/teacher_approve_submit.do" method="post" class="form form-horizontal" id="form-goods-add" enctype="multipart/form-data">
	
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value=<%=teachername %> placeholder="" id="" name="TeacherName" datatype="*" nullmsg="姓名不能为空！"  readonly="readonly">
			</div>
		</div>
		
		
		<div class="row cl">
	        
			<label class="form-label col-2"><span class="c-red">*</span>教师资格证件：</label>
			<div class="formControls col-10">
			    <div id="preview"></div>
				
				<input name="QualificationCard" type="file" onchange="preview(this)" placeholder="请上传手持教师资格证的照片" datatype="*" nullmsg="证件不能为空！" value=""/>
			</div>
		</div>
		
		
		<div class="row cl">
	        
			<label class="form-label col-2"><span class="c-red">*</span>教师工作证件：</label>
			<div class="formControls col-10">
			    <div id="preview"></div>
				
				<input name="WorkCard" type="file" onchange="preview(this)" placeholder="请上传手持学校工作证的照片" datatype="*" nullmsg="证件不能为空！" value=""/>
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-10 col-offset-2">
					<input  class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交认证&nbsp;&nbsp;">&nbsp;&nbsp;&nbsp;
			</div>
		</div>
	
	</form>
</div>
</body>
</html>