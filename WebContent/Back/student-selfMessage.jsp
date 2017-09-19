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
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />

<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>学生首页</title>
</head>
<body>
<div class="pd-20" style="padding-top:20px;">
  <p class="f-20 text-success">欢迎登录学生个人中心</p>
  <p>登录次数：<c:out value="${student.getLoginNum() }"></c:out> </p>
  <p>上次登录时间：<c:out value="${student.getLastLoginTime() }"></c:out></p>
  <c:if test="${student.getCheckStatus() eq '0' }"><a href="../StudentSchoolSet.sdo"><button class="btn btn-primary radius">绑定学校</button></a>&nbsp;&nbsp;&nbsp;&nbsp;</c:if><a href="student-updateSelfMessage.jsp"><button class="btn btn-primary radius">修改信息</button></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="student-updatePassword.jsp"><button class="btn btn-primary radius">修改密码</button></a><c:if test="${student.getCheckStatus() eq '2' }">&nbsp;&nbsp;&nbsp;&nbsp;<button id="intention" class="btn btn-primary radius">求职意向</button></c:if>
  <table class="table table-border table-bordered table-bg mt-20">
    <thead>
      <tr>
        <th colspan="2" scope="col">学生信息（若修改信息后未及时更新请重新登录）</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th width="200">学生编号(不可修改)</th>
        <td><c:out value="${student.getID() }"></c:out></td>
      </tr>
      <c:if test="${student.getCheckStatus() eq '2' }">
      <tr>
        <td>用户照片</td>
        <td><img src="${student.getPicture()}" width="150px" height="150px"></td>
      </tr>
     </c:if>
      <tr>
        <td>用户名</td>
        <td><c:out value="${student.getStudentName() }"></c:out></td>
      </tr>
      <tr>
        <td>性别</td>
        <td><c:out value="${student.getSex() }"></c:out></td>
      </tr>
      <tr>
        <td>年龄</td>
        <td><c:out value="${student.getAge() }"></c:out></td>
      </tr>
      <tr>
        <td>学习所在省份</td>
        <td><c:out value="${student.getProvince() }"></c:out></td>
      </tr>
      <tr>
        <td>学校 </td>
        <td><c:out value="${student.getSchool() }"></c:out></td>
      </tr>
      <tr>
        <td>学院 </td>
        <td><c:out value="${student.getAcademy() }"></c:out></td>
      </tr>
      <tr>
        <td>专业 </td>
        <td><c:out value="${student.getMajor() }"></c:out></td>
      </tr>
      <tr>
        <td>籍贯</td>
        <td><c:out value="${student.getHome() }"></c:out></td>
      </tr>
      <tr>
        <td>电话 </td>
        <td><c:out value="${student.getTel() }"></c:out></td>
      </tr>
      <tr>
        <td>邮箱 (不可修改)</td>
        <td><c:out value="${student.getEmail() }"></c:out></td>
      </tr>
      <tr>
        <td>身份证号</td>
        <td><c:out value="${student.getID_Card() }"></c:out></td>
      </tr>
      <tr>
        <td>座右铭 </td>
        <td><c:out value="${student.getMotto() }"></c:out></td>
      </tr>
      <tr>
        <td>求职意向 </td>
        <td><c:out value="${student.getIntention() }"></c:out></td>
      </tr>
      <tr>
        <td>学历 </td>
        <td><c:out value="${student.getEducationBgd() }"></c:out></td>
      </tr>
      <tr>
        <td>真实姓名 </td>
        <td><c:out value="${student.getRealName() }"></c:out></td>
      </tr>
    </tbody>
  </table>
</div>
<footer class="footer">
</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script>

$(intention).click(function(){
	layer.open({
	    type: 2 //Page层类型
	   	,area: ['1000px', '530px']
	    ,title: '设置求职意向'
	    ,shade: 0.6 //遮罩透明度
	    ,maxmin: true //允许全屏最小化
	    ,anim: 2 //0-6的动画形式，-1不开启
	    ,content: 'student-intention2.jsp',	  
	});
})


var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>