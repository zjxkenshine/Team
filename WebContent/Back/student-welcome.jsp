<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE HTML>
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
<title>我的首页</title>
</head>
<body>
<div class="pd-20" style="padding-top:20px;">
  <p class="f-20 text-success">欢迎登录学生个人中心</p>
  <p>登录次数：<c:out value="${student.getLoginNum() }"></c:out> </p>
  <p>上次登录时间：<c:out value="${student.getLastLoginTime() }"></c:out></p>
  <table class="table table-border table-bordered table-bg mt-20">
    <thead>
      <tr>
        <th colspan="2" scope="col">学生信息</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th width="200">服务器计算机名</th>
        <td><span id="lbServerName">http://127.0.0.1/</span></td>
      </tr>
      <tr>
        <td>服务器IP地址</td>
        <td>192.168.1.1</td>
      </tr>
      <tr>
        <td>服务器域名</td>
        <td>www.h-ui.net</td>
      </tr>
      <tr>
        <td>服务器端口 </td>
        <td>80</td>
      </tr>
      <tr>
        <td>服务器IIS版本 </td>
        <td>Microsoft-IIS/6.0</td>
      </tr>
      <tr>
        <td>本文件所在文件夹 </td>
        <td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
      </tr>
      <tr>
        <td>服务器操作系统 </td>
        <td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
      </tr>
      <tr>
        <td>系统所在文件夹 </td>
        <td>C:\WINDOWS\system32</td>
      </tr>
      <tr>
        <td>服务器脚本超时时间 </td>
        <td>30000秒</td>
      </tr>
      <tr>
        <td>服务器的语言种类 </td>
        <td>Chinese (People's Republic of China)</td>
      </tr>
      <tr>
        <td>.NET Framework 版本 </td>
        <td>2.050727.3655</td>
      </tr>
      <tr>
        <td>服务器当前时间 </td>
        <td>2014-6-14 12:06:23</td>
      </tr>
      <tr>
        <td>服务器IE版本 </td>
        <td>6.0000</td>
      </tr>
      <tr>
        <td>服务器上次启动到现在已运行 </td>
        <td>7210分钟</td>
      </tr>
      <tr>
        <td>逻辑驱动器 </td>
        <td>C:\D:\</td>
      </tr>
      <tr>
        <td>CPU 总数 </td>
        <td>4</td>
      </tr>
      <tr>
        <td>CPU 类型 </td>
        <td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
      </tr>
      <tr>
        <td>虚拟内存 </td>
        <td>52480M</td>
      </tr>
      <tr>
        <td>当前程序占用内存 </td>
        <td>3.29M</td>
      </tr>
      <tr>
        <td>Asp.net所占内存 </td>
        <td>51.46M</td>
      </tr>
      <tr>
        <td>当前Session数量 </td>
        <td>8</td>
      </tr>
      <tr>
        <td>当前SessionID </td>
        <td>gznhpwmp34004345jz2q3l45</td>
      </tr>
      <tr>
        <td>当前系统用户名 </td>
        <td>NETWORK SERVICE</td>
      </tr>
    </tbody>
  </table>
</div>
<footer class="footer">
</footer>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script>
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
</html