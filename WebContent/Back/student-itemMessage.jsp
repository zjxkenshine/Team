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

<title>基本信息</title>
</head>
<body>
<div class="pd-20">
  <form action="../StudentUpdateItemMessage.sdo" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>项目名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getItemName() }" placeholder="" id="ItemName" name="ItemName" datatype="*2-16" nullmsg="项目名不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>负责人：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getStuName() }" readonly="readonly" placeholder="">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>联系电话：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getTel() }" placeholder="" id="Tel" name="Tel"  datatype="m" nullmsg="手机不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>联系QQ：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getQQ() }" placeholder="" id="QQ" name="QQ">
      </div>
      <div class="col-4"> </div>
    </div>
   <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getEmail() }" placeholder="@" name="Email" id="Email" datatype="e" nullmsg="请输入邮箱！">
      </div>
      <div class="col-4"> </div>
    </div>
      <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>目前项目总人数：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getNumber() }" placeholder="" name="Number" id="Number" datatype="n" nullmsg="请填写项目总人数！">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>专利数量：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${Item.getPatentNum() }" placeholder="" name="PatentNum" id="PatentNum" datatype="n" nullmsg="请填写专利数！">
      </div>
      <div class="col-4"> </div>
    </div>
 	
    <div class="row cl">
      <label class="form-label col-3">项目描述：</label>
      <div class="formControls col-5">
        <textarea name="Discripe" cols="" rows="" class="textarea"  placeholder="请详细描述你的创业项目" datatype="*10-100" dragonfly="true" nullmsg="项目描述不能为空！" onKeyUp="textarealength(this,100)"><c:out value="${Item.getDescripe() }"></c:out></textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;&nbsp;
        <input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;重置&nbsp;&nbsp;">
      </div>
    </div>
  </form>
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
	
	$("#form-member-add").Validform({
		tiptype:2,
		callback:function(){
		}
	});
});




</script>
</body>
</html>