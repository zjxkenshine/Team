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
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>创业项目管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 管理员后台 <span class="c-gray en">&gt;</span> 学生管理<span class="c-gray en">&gt;</span>创业项目管理 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">项目名</th>
				<th width="100">负责人ID</th>
				<th width="100">负责人</th>
				<th width="100">所在地</th>
				<th width="90">扶持公司</th>
				<th width="150">研究方向</th>
				<th width="150">商业计划书</th>
				<th width="70">状态</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${itemlist }" var="ite"> 
			<tr class="text-c">
				<td><input btn_name='checkid' type="checkbox" value="${ite.getID() }" class="ace" ></td>
				<td><c:out value="${ite.getItemName() }"></c:out></td>
				<td><c:out value="${ite.getStuID() }"></c:out></td>
				<td><c:out value="${ite.getStuName() }"></c:out></td>
				<td><c:out value="${ite.getAddresss() }"></c:out></td>
				<td><c:out value="${ite.getFirmName() }"></c:out></td>
				<td><c:out value="${ite.getIntention() }"></c:out></td>
				<td><c:if test="${ite.getBusinessPlan()==null}">无</c:if>
					<c:if test="${ite.getBusinessPlan()!=null}"><a href="${ite.getBusinessPlan() }">点击下载</a></c:if>
				</td>
				<td>
				<c:if test="${ite.getStatus() eq '0' }"><span class="label label-defaunt radius">已停用</span></c:if>
				<c:if test="${ite.getStatus() eq '1' }"><span class="label label-success radius">正常</span></c:if>
				</td>
				<td> 
				<c:if test="${ite.getStatus() eq '0' }"><a style="text-decoration:none" onClick="start(this,${ite.getID()})" href="javascript:;" title="启动该项目"><i class="Hui-iconfont">&#xe6e1;</i></a></c:if>
				<c:if test="${ite.getStatus() eq '1' }"><a style="text-decoration:none" onClick="stop(this,${ite.getID()})" href="javascript:;" title="禁用该项目"><i class="Hui-iconfont">&#xe631;</i></a></c:if>
				</td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,2,8]}// 制定列不参与排序
		]
	});
	$('.table-sort tbody').on( 'click', 'tr', function () {
		if ( $(this).hasClass('selected') ) {
			$(this).removeClass('selected');
		}
		else {
			table.$('tr.selected').removeClass('selected');
			$(this).addClass('selected');
		}
	});
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*用户-停用*/
function stop(obj,id){
	layer.confirm('确认要关闭该项目吗？',function(index){
		layer.msg('已停用!',{icon: 5,time:1000});
		window.location.href="../StopItem.do?id="+id;
	});
}

function start(obj,id){
	layer.confirm('确认要启用该项目吗？',function(index){
		layer.msg('已启用!',{icon: 6,time:1000});
		window.location.href="../OpenItem.do?id="+id;
	});
}


/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}

/*用户-启用*/
function apply(obj,id){
		layer.open({
		    type: 2 //Page层类型
		   	,area: ['700px', '530px']
		    ,title: '申请加入项目'
		    ,shade: 0.6 //遮罩透明度
		    ,maxmin: true //允许全屏最小化
		    ,anim: 2 //0-6的动画形式，-1不开启
		    ,content: 'student-applyItem.jsp?ID='+id,
		  
		});
}

</script> 
</body>
</html>