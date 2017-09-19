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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />

<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>学生登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="login.do" method="post">
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-8">
          <input id="user" name="username" type="text" placeholder="用户名/身份证/邮箱/手机号" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-8">
          <input id="pwd" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-8 col-offset-3">
          <input name="code" id="code" class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img  src="student-number.jsp" id="rcode"> <a id="kanbuq">看不清，换一张</a> </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
        </div>
      </div>
      <div class="row">
        <div class="formControls col-8 col-offset-3">
          <input name="loginbtn" id="loginbtn" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <a href="student-register.jsp"><input name="" id="" type="button" class="btn btn-default radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;"></a>
          <a onclick="history.go(-1)"><input name="" id="" type="button" class="btn btn-danger radius size-L" value="&nbsp;返&nbsp;&nbsp;&nbsp;&nbsp;回&nbsp;"></a>
          <a href="student-forgetPassword.jsp">忘记密码</a>
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">学生登录</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script>

	$("#rcode").click(function(){
		$("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
		
	})
	
	$("#kanbuq").on("click", function(){
		$("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
	})
	
	$("#loginbtn").on('click', function(){
		var username=$("#user").val();
		var password=$("#pwd").val();
		var code=$("#code").val();
		//验证空值
		 if(username==""){
			 layer.alert('用户名/电话/邮箱不能为空！',{
		               title: '提示框',				
					   icon:2,		
					  });
			 $("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
			 layer.close(index);
			 return false;
		 }else if(password==""){
			 layer.alert('密码不能为空！',{
	               title: '提示框',				
				   icon:2,		
				  });
		 $("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
		 layer.close(index);
		 return false;
	 	}else if(code=="验证码:"){
	 		 layer.alert('验证码不能为空！',{
	               title: '提示框',				
				   icon:2,		
				  });
		 $("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
		 layer.close(index);
		 return false;
	 	}else{
	 		$.ajax({
  				url:"../StudentLoginCheck.sdo",        //验证账号密码
  				type:"POST",
  				dataType:"json",
  				data:{username:username,password:password},
  				success:function(data){
  					if(code!=data["rcode"]){
  						layer.alert('验证码错误',{            //验证码
    			               title: '提示框',				
    						   icon:2,		
    						  });
  						 $("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
   						layer.close(index);
   						return false;
  					}
  					if(data["flag"]=="1"){				//登录成功
  							layer.alert(data["msg"],{
  			               title: '提示框',				
  						   icon:1,		
  						  });
  					
  						location.href="../StudentLogin.sdo?ID="+data["stuid"];
  						layer.close(index);	
  					}else if(data["flag"]=="0"){        //登录失败
  						layer.alert(data["msg"],{
   			               title: '提示框',				
   						   icon:2,		
   						  });
  						 $("#rcode").attr("src","student-number.jsp?"+new Date().getTime());
  						layer.close(index);
  						return false;
  					}
  				}
	 		})
	 	}
		
	})
</script>
</body>
</html>