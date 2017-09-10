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
				K('#image1').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							imageUrl : K('#url1').val(),
							clickFn : function(url, title, width, height, border, align) {
								K('#url1').val(url);
								K('#image1').val("上传成功");
								K('#img1').attr("src",url);
								editor.hideDialog();
							}
						});
					});
				});
				K('#image2').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							showLocal : false,
							imageUrl : K('#url2').val(),
							clickFn : function(url, title, width, height, border, align) {
								K('#url2').val(url);
								
								editor.hideDialog();
							}
						});
					});
				});
				K('#image3').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							showRemote : false,
							imageUrl : K('#url3').val(),
							clickFn : function(url, title, width, height, border, align) {
								K('#url3').val(url);
								K('#image3').val("上传成功");
								K('#img3').attr("src",url);
								editor.hideDialog();
							}
						});
					});
				});
			});
		</script>
<title>创业认证</title>
</head>
<body>
<c:if test="${student.getCreaStatus() eq '0' }">
<div class="pd-20">
  <form action="../StudentCreatCheck.sdo" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>真实姓名(不可更改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getRealName() }" placeholder="" id="RealName" name="RealName" readonly="readonly">
      </div>
      <div class="col-4"> </div>
    </div>
      <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证号：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getID_Card() }" placeholder="" id="ID_Card" name="ID_Card"  datatype="*" nullmsg="请填写身份证号">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证正面照片：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url3" name="IdPic"  value=""  datatype="*" nullmsg="请上传身份证照片" /><img src="" width="200px" height="200px" id="img3">&nbsp;&nbsp;&nbsp;<a id="image3" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i>选择图片</a></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>大学生创业证正面照片：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url1" name="CreaPic" value=""  datatype="*" nullmsg="请上传大学生创业证照片" /><img width="200px" height="200px" src="" id="img1">&nbsp;&nbsp;&nbsp;<a id="image1" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont">&#xe642;</i>选择图片</a></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交认证&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</c:if>
<c:if test="${student.getCreaStatus() eq '1' }">
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>真实姓名(不可更改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getRealName() }" placeholder="" id="RealName" name="RealName" readonly="readonly">
      </div>
      <div class="col-4"> </div>
    </div>
      <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证号：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getID_Card() }" readonly="readonly" placeholder="" id="ID_Card" name="ID_Card"  datatype="*" nullmsg="请填写身份证号">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证正面照片(不可更改)：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url3" name="IdPic"  value="" /><img src="${student.getIdPic() }" width="200px" height="200px"></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>大学生创业证正面照片(不可更改)：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url1" name="CreaPic" value=""  /><img width="200px" height="200px" src="${student.getCreaPic() }" ></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-danger radius" type="botton" value="&nbsp;&nbsp;您的认证正在审核&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</c:if>
<c:if test="${student.getCreaStatus() eq '2' }">
<div class="pd-20">
  <form action="" method="post" class="form form-horizontal" id="form-member-add">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>真实姓名(不可更改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getRealName() }" placeholder="" id="RealName" name="RealName" readonly="readonly">
      </div>
      <div class="col-4"> </div>
    </div>
      <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证号(不可更改)：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text"  value="${student.getID_Card() }" readonly="readonly" placeholder="" id="ID_Card" name="ID_Card"  datatype="*" nullmsg="请填写身份证号">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>身份证正面照片(不可更改)：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url3" name="IdPic"  value="" /><img src="${student.getIdPic() }" width="200px" height="200px"></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>大学生创业证正面照片(不可更改)：</label>
      <div class="formControls col-5">
      	<p><input type="hidden" id="url1" name="CreaPic" value=""  /><img width="200px" height="200px" src="${student.getCreaPic() }" ></p>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input class="btn btn-primary radius" type="botton" value="&nbsp;&nbsp;您的认证已通过&nbsp;&nbsp;">
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
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});
</script>
</body>
</html>