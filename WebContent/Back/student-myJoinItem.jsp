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
<title>我的项目</title>
</head>
<body>
<div class="pd-20" style="padding-top:20px;">
  <p class="f-20 text-success">我的项目</p>
  <c:if test="${item.getID()!=0 }"><a id="itemquit"><button class="btn btn-danger radius">退出该项目</button></a></c:if>  <c:if test="${item.getID()==0 }"><a ><button class="btn btn-danger radius">您未加入任何项目</button></a></c:if>
  <table class="table table-border table-bordered table-bg mt-20">
    <thead>
      <tr>
        <th colspan="2" scope="col">项目详情</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th width="200">项目编号</th>
        <td><c:out value="${item.getID() }"></c:out></td>
      </tr>
      <tr>
        <td>项目名</td>
        <td><c:out value="${item.getItemName() }"></c:out></td>
      </tr>
      <tr>
        <td>负责人</td>
        <td><c:out value="${item.getStuName() }"></c:out></td>
      </tr>
      <tr>
        <td>项目总人数(目前)</td>
        <td><c:out value="${item.getNumber() }"></c:out></td>
      </tr>
      <tr>
        <td>所在地</td>
        <td><c:out value="${item.getAddresss() }"></c:out></td>
      </tr>
      <tr>
        <td>关联学校 </td>
        <td><c:out value="${item.getSchool() }"></c:out></td>
      </tr>
      <tr>
        <td>扶持公司 </td>
        <td><c:out value="${item.getFirmName() }"></c:out></td>
      </tr>
      <tr>
        <td>研究方向 </td>
        <td><c:out value="${item.getIntention() }"></c:out></td>
      </tr>
      <tr>
        <td>专利数量</td>
        <td><c:out value="${item.getPatentNum() }"></c:out>项</td>
      </tr>
      <tr>
        <td>负责人电话 </td>
        <td><c:out value="${item.getTel() }"></c:out></td>
      </tr>
      <tr>
        <td>负责人邮箱</td>
        <td><c:out value="${item.getEmail() }"></c:out></td>
      </tr>
      <tr>
        <td>负责人QQ</td>
        <td><c:out value="${item.getQQ() }"></c:out></td>
      </tr>
      <tr>
        <td>需要人数 </td>
        <td><c:out value="${item.getNeedNumber() }"></c:out></td>
      </tr>
      <tr>
        <td>需要人才描述 </td>
        <td><c:out value="${item.getNeedDiscripe() }"></c:out></td>
      </tr>
      <tr>
        <td>项目描述 </td>
        <td><c:out value="${item.getDescripe() }"></c:out></td>
      </tr>
      <tr>
        <td>状态 </td>
        <td>
        <c:if test="${item.getStatus() eq '0' }">禁用</c:if>
        <c:if test="${item.getStatus() eq '1' }">正常</c:if>
        </td>
      </tr>
      <tr>
        <td>审核状态 </td>
        <td>
        <c:if test="${item.getCheckStatus() eq '0' }">未审核或未通过</c:if>
        <c:if test="${item.getCheckStatus() eq '1' }">正在审核</c:if>
        <c:if test="${item.getCheckStatus() eq '2' }">已审核通过</c:if>
        </td>
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

$("#itemquit").click(function(){
	layer.confirm('确认退出该项目吗？',{icon:0,},function(index){
	layer.open({
	    type: 2 //Page层类型
	   	,area: ['800px', '530px']
	    ,title: '退出项目'
	    ,shade: 0.6 //遮罩透明度
	    ,maxmin: true //允许全屏最小化
	    ,anim: 2 //0-6的动画形式，-1不开启
	    ,content: '../StudentQuitItem.sdo',	  
	});
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