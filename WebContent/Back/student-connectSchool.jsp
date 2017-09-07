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
<title>绑定学校（矫正）</title>
</head>
<body>
<div class="pd-20">
  <form action="../StudentConnectSchool2.sdo" method="post" class="form form-horizontal" id="schoolbind">
    <div class="row cl">
      <label class="form-label col-3">学校所在省份：</label>
      <div class="formControls col-5"> <span class="select-box">
        <select class="select" size="1" name="Province" id="Province">
          <c:if test="${student.getProvince()!=null||student.getProvince()!='' }">
          <option value="${student.getProvince() }" selected><c:out value="${student.getProvince() }"></c:out></option>
        </c:if> 
        <c:if test="${student.getProvince()==null||student.getProvince()=='' }">
          	<option value="" selected>请选择省份</option>
        </c:if> 
        <c:forEach items="${prolist}" var="pro">
			<option value="${pro.getProvince() }"><c:out value="${pro.getProvince() }"></c:out></option>
		</c:forEach>
        </select>
        </span> </div>
      <div class="col-4"> </div>
    </div>
    
   <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>学校：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getSchool() }" placeholder="" id="School" name="School" datatype="*2-16" nullmsg="学校不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>学院：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getAcademy() }" placeholder="" id="Academy" name="Academy" datatype="*2-16" nullmsg="学院不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>专业：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${student.getMajor() }" placeholder="" id="Major" name="Major" datatype="*2-16" nullmsg="专业不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;确认绑定&nbsp;&nbsp;">
        <a href="../StudentSchoolSet.sdo"><input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;返回&nbsp;&nbsp;"></a>
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
<script type="text/javascript">


$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#schoolbind").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	
});

$(function(){
	
});


</script>
</body>
</html>
