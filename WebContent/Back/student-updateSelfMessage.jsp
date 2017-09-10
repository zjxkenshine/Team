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
<title>学生基本信息修改</title>
</head>
<body>
<div class="pd-20">
  <form action="../StudentUpdateSelfMessage.sdo" method="post" class="form form-horizontal" id="updatemessage">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>用户名：</label>
      <div class="formControls col-5">
      <!--  -->
        <input type="text" class="input-text" value="${student.getStudentName() }" placeholder="必填" id="StudentName" name="StudentName" datatype="*2-16" nullmsg="用户名不能为空" ajaxurl="../StudentUpdateSelfMessageCheck.sdo?stuname=${student.getStudentName() }">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>手机：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getTel() }"  placeholder="必填" id="Tel" name="Tel" datatype="m" nullmsg="手机号不能为空" ajaxurl="../StudentUpdateSelfMessageCheck.sdo?tel=${student.getTel() }">
      </div>
      <div class="col-4"> </div>
    </div>
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>真实姓名(学生认证成功后不可修改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getRealName() }" <c:if test="${student.getCheckStatus() eq '2' }">readonly="readonly"</c:if> placeholder="必填" id="RealName" name="RealName">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证号(创业认证成功后不可修改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getID_Card() }" <c:if test="${student.getCreaStatus() eq '2' }">readonly="readonly"</c:if> placeholder="必填" id="ID_Card" name="ID_Card" datatype="idcard" nullmsg="身份证号不能为空" ajaxurl="../StudentUpdateSelfMessageCheck.sdo?idcard=${student.getID_Card() }">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>年龄：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getAge() }" placeholder="" id="Age" name="Age" readonly="readonly" ajaxurl="../StudentUpdateSelfMessageCheck.sdo">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>性别：</label>
      <div class="formControls col-5 skin-minimal">
        <div class="radio-box">
          <input type="radio" id="Sex1" name="sex" value="男" onclick="return false" <c:if test="${student.getSex() eq '男' }">checked="checked"</c:if>>
          <label for="Sex1">男</label>
        </div>
        <div class="radio-box">
          <input type="radio" id="Sex2" name="sex" value="女" onclick="return false" <c:if test="${student.getSex() eq '女' }">checked="checked"</c:if>>
          <label for="Sex2">女</label>
        </div>
      </div>
      <div class="col-4"> </div>
    </div>
   
   <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>籍贯：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getHome() }" placeholder="选填" id="Home" name="Home" >
      </div>
      <div class="col-4"> </div>
    </div>
    
     <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>座右铭：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getMotto() }" placeholder="选填" id="Motto" name="Motto">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
        <a href="student-selfMessage.jsp"><input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;"></a>
      </div>
    </div>
  </form>
</div>

<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script src="lib/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#updatemessage").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
	$("#ID_Card").change(function(){
		var idcard=$("#ID_Card").val();
		if(idcard.trim().charAt(16)%2==0){
			$("#Sex2").attr("checked","true");
		}else{
			$("#Sex1").attr("checked","true");
		}
		$("#Age").val(parseInt(laydate.now().substring(0,5))-parseInt(idcard.substring(6,10))+1);
		alert(parseInt(laydate.now().substring(0,5))-parseInt(idcard.substring(6,10))+1);
	})
	
});


</script>
</body>
</html>