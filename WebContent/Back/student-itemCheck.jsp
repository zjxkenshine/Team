<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet" type="text/css" href="work/css.css" />
<link rel="stylesheet" type="text/css" href="work/alpha.css" />
<script type="text/javascript" src="work/jquery.js"></script>
<script type="text/javascript" src="work/drag.js"></script>
<script type="text/javascript" src="work/city_arr.js"></script>
<script type="text/javascript" src="work/nationality_arr.js"></script>
<script type="text/javascript" src="work/funtype_arr.js"></script>
<script type="text/javascript" src="work/industry_arr.js"></script>
<script type="text/javascript" src="work/major_arr.js"></script>
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
	<link rel="stylesheet" href="lib/kindeditor/themes/default/default.css" />
		<script src="lib/kindeditor/kindeditor.js"></script>
		<script src="lib/kindeditor/lang/zh_CN.js"></script>
		<script>
		KindEditor.ready(function(K) {
			var editor = K.editor({
				allowFileManager : true
			});
			K('#insertfile').click(function() {
				editor.loadPlugin('insertfile', function() {
					editor.plugin.fileDialog({
						fileUrl : K('#url').val(),
						clickFn : function(url, title) {
							K('#url').val(url);
							editor.hideDialog();
						}
					});
				});
			});
		});
		</script>
<title>项目审核</title>
</head>
<body>
<c:if test="${Item.getCheckStatus() eq '0' }">
<div class="pd-20">
 <form action="../StudentItemCheck.sdo" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>项目研究方向：</label>
      <div class="formControls col-5">
     		<script type="text/javascript" src="work/major_func.js"></script>
			<input id="btn_MajorID_2" type="button" value="请选择研究方向" onclick="majorSelect_2()" />
			<input id="MajorID_2" type="hidden" name="MajorID_2" value="" />单选
			<input id="MajorID_22" type="hidden" name="MajorID_22" value="" />
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>商业计划书：</label>
      <div class="formControls col-5">
      	<input type="text" name="BusinessPlan" id="url"  value="" />&nbsp;&nbsp;&nbsp;<a id="insertfile" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i>选择文件</a></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3">项目描述：</label>
      <div class="formControls col-5">
        <textarea name="Descripe" cols="" rows="" class="textarea"  placeholder="请详细描述你的创业项目" datatype="*10-100" dragonfly="true" nullmsg="项目描述不能为空！" onKeyUp="textarealength(this,100)"><c:out value="${Item.getDescripe() }"></c:out></textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
     </div>
     </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交认证&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</c:if>
<c:if test="${Item.getCheckStatus() eq '1' }">
<div class="pd-20">
 <form action="../StudentItemCheck.sdo" method="post" class="form form-horizontal" id="form-member-add">
    
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>商业计划书：</label>
      <div class="formControls col-5">
      	<input type="text" id="url" value="${Item.getBusinessPlan() }" />
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3">项目描述：</label>
      <div class="formControls col-5">
        <textarea name="Discripe" cols="" rows="" class="textarea"  placeholder="请详细描述你的创业项目" datatype="*10-100" dragonfly="true" nullmsg="项目描述不能为空！" onKeyUp="textarealength(this,100)"><c:out value="${Item.getDescripe() }"></c:out></textarea>
        <p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
      </div>
      </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-danger radius" type="button" value="&nbsp;&nbsp;您的项目正在审核中&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</c:if>
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<!-- alpha div -->
<div id="maskLayer" style="display:none">
<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
	<div id="drag">
		<h3 id="drag_h"></h3>
		<div id="drag_con"></div><!-- drag_con end -->
	</div>
</div><!-- maskLayer end -->
</div>
<!-- alpha div end -->
<div id="sublist" style="display:none"></div>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
		}
	});
});

//是否在数组内
function in_array(needle, haystack) {
	if(typeof needle == 'string' || typeof needle == 'number') {
		for(var i in haystack) {
			if(haystack[i] == needle) {
					return true;
			}
		}
	}
	return false;
}
</script>
</body>
</html>