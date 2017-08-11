<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>学生注册</title>
</head>
<body>
<div class="pd-20">
  <form action="../StudentRegister.sdo" method="post" class="form form-horizontal" id="studentregister">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="必填" id="StudentName" name="StudentName" datatype="*2-16" nullmsg="用户名不能为空" ajaxurl="../StudentRegisterCheck.sdo">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text" value="" placeholder="必填,5~16位" id="password" name="password" datatype="*5-16" nullmsg="密码不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>确认密码：</label>
      <div class="formControls col-5">
        <input type="password" class="input-text" value="" placeholder="必填" autocomplete="off" id="pwd2" name="pwd2" datatype="*5-16" errormsg="两次输入密码不一样" nullmsg="请再输入一次密码" recheck="password"  >
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="必填" id="Tel" name="Tel" datatype="m" nullmsg="手机号不能为空" ajaxurl="../StudentRegisterCheck.sdo">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>邮箱：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="必填，用于验证激活" id="Email" name="Email" datatype="e" nullmsg="邮箱不能为空" ajaxurl="../StudentRegisterCheck.sdo">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" id="register" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">&nbsp;&nbsp;&nbsp;
        <a href="student-login.jsp"><input class="btn btn-default radius" type="button" id="back" value="&nbsp;&nbsp;返回登录&nbsp;&nbsp;"></a>&nbsp;&nbsp;&nbsp;
        <a href="student-registerCheck.jsp">已注册账号,点击激活</a>
      </div>
    </div>
  </form>
</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#studentregister").Validform({		
		 tiptype:2,
		callback:function(data){
		//form[0].submit();
		if(data.status==1){ 
               layer.msg(data.info, {icon: data.status,time: 1000}, function(){ 
                   location.reload();//刷新页面 
                   });   
           } 
           else{ 
               layer.msg(data.info, {icon: data.status,time: 3000}); 
           } 		  
			var index =parent.$("#iframe").attr("src");
			parent.layer.close(index);
			//
		}				
	});
});
</script>
</body>
</html>