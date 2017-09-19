<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     //项目的发布路径，例如：/abcd
     String path=request.getContextPath();
     /*
            全路径，形式如下： http://127.0.0.1:8001/abcd/
     request.getScheme()       ——>http 获取协议
     request.getServerName()   ——>127.0.0.1 获取服务器名
     request.getServerPort()   ——>8001 获取端口号
     path                      ——> /abcd 获取访问的路径
     */
     String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=path%>/Back/">
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />


<link href="css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EZPCgQ6zGu6hZSmXlRrUMTpr"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/map.jquery.min.js"></script>
<script type="text/javascript" src="js/school.js"></script>
<style type="text/css">
/*头像预览显示的代码*/
#preview,
.img,
img {
width: 150px;
height: 150px;
}
#preview {
border: 1px solid #000;
}

</style>

<style type="text/css">
/*加载学校*/
*{margin:0;padding:0;outline:none;}
body{padding:20px;font:12px "微软雅黑";background:#FFF;}
ul li{list-style:none;}
#schoolName{width:200px;height:30px;line-height:30px;border:1px solid #ccc;padding:0 8px;cursor:pointer;font-size:12px;}
.provinceSchool{display:none;position:absolute;width:580px;height:auto;border:1px solid #72B9D7;}
.provinceSchool .title{width:100%;height:30px;background:#72B9D7;cursor:move;}
.provinceSchool .title span{margin-left:10px;font-weight:600;color:#FFF;line-height:30px;}
.provinceSchool .proSelect{width:550px;text-align:center;padding:15px 0;}
.provinceSchool .proSelect select{width:136px;}
.provinceSchool .proSelect span{padding-left:10px;}
.provinceSchool .proSelect input{display:none;}
.provinceSchool .schoolList{width:550px;height:180px;padding:10px 0;overflow-y:auto;border:1px solid #ddd;}
.provinceSchool .schoolList ul{width:510px;clear:both;}
.provinceSchool .schoolList ul span.entertext{display:block;height:180px;font:normal 16px/180px 'microsoft yahei';color:#999;}
.provinceSchool .schoolList ul li{float:left;text-align:center;width:160px;margin:5px;height:25px;line-height:25px;cursor:pointer;background:#fafafa;border-radius:3px;}
.provinceSchool .schoolList ul li.DoubleWidthLi{overflow:hidden;}
.provinceSchool .schoolList ul li:hover{background:#72B9D7;color:#fff;}
.provinceSchool .button{width:100%;height:40px;margin-top:8px;}
.provinceSchool .button button{float:right;height:30px;margin-right:15px;padding:2px 15px;background:#72B9D7;border:none;color:#FFF;font-weight:600;cursor:pointer;border-radius:3px;}
.provinceSchool .button button:hover{background:#2e90bd;}
</style>
<title>信息修改</title>
</head>
<body>
<div class="pd-20">
	<form action="/Team/teacher_information_update.do" method="post" class="form form-horizontal" id="form-goods-add" enctype="multipart/form-data">
	   
	    <div class="row cl">
	        
			<label class="form-label col-2"><span class="c-red">*</span>照片：</label>
			<div class="formControls col-10">
			    <div id="preview"></div>
				
				<input name="Picture" type="file" onchange="preview(this)" datatype="*" nullmsg="个人照片不能为空"  value="${teacher.picture}"/>
			</div>
		</div>
	
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${teacher.teacherName}" placeholder="" id="" name="TeacherName" datatype="*" nullmsg="姓名不能为空！"  readonly="readonly">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-2"> <span class="select-box">
				<select id="sex" name="Sex" class="select" nullmsg="性别不能为空！" datatype="*"  >
					<option value="">请选择</option>
					<option value="男" >男</option>
					<option value="女">女</option>						
				</select>
				</span>
		    </div>
		</div>
		
	    <div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>年龄：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${teacher.age}" placeholder="" id="" name="Age" datatype="*" nullmsg="年龄不能为空！" >
				<font size="3" color=red>${mes}</font>
			</div>
		</div>
		
		 <div class="row cl">
			<label class="form-label col-2">个人邮箱：</label>
			<div class="formControls col-3">
				<input type="text"  class="input-text" value="${teacher.email}" placeholder="" id="" name="Email"   datatype="e" readonly="readonly">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>特长：</label>
			<div class="formControls col-6">
				<textarea name="Speciality" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="特长不能为空！" onKeyUp="textarealength(this,200)">${teacher.speciality}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>个人简介：</label>
			<div class="formControls col-6">
				<textarea name="Des" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*10-200" dragonfly="true" nullmsg="个人简介不能为空！" onKeyUp="textarealength(this,200)">${teacher.des}</textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
		</div>
		
		
		<div class="row cl">
			<label class="form-label col-2" for='schoolName'><span class="c-red">*</span>所在学校：</label>
			<div class="formControls col-2">
				<input type="text" value="${teacher.school }" name="school" id="school" placeholder="请点击选择学校" readonly />
					<div id="proSchool" class="provinceSchool">
					    <div class="title"><span>请选择学校</span></div>
					    <div class="proSelect">
					        <select></select>
					        <span>如没找到选择项，请选择其他手动填写</span>
					        <input type="text" />
					    </div>
					    <div class="schoolList">
					        <ul></ul>
					    </div>
					    <div class="button">
					        <button flag='0'>取消</button>
					        <button flag='1'>确定</button>
					    </div>
					</div>	
		    </div>
		</div>
		 
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>学院：</label>
			<div class="formControls col-2">
				<input type="text" class="input-text" value="${teacher.academy}" placeholder="" id="" name="Academy" datatype="*" nullmsg="学院不能为空！" >
			</div>
		</div>
		
				    
		<div class="row cl">${msg}
		<input type="hidden" id="picture_hidden" name="picture_hidden" value="${teacher.picture}"> <%--隐藏域获取地址基本信息 --%>
		<input type="hidden" id="sex_hidden" name="sex_hidden" value="${teacher.sex}"> <%--隐藏域获取地址基本信息 --%>
		</div>
	    
		<div class="row cl">
			<div class="col-10 col-offset-2">
					<input  class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">&nbsp;&nbsp;&nbsp;
				    <button  class="btn btn-default radius" type="reset">&nbsp;&nbsp;重置&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>

 
<script type="text/javascript" src="lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="/Team/Back/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="js/H-ui.js"></script> 
<script type="text/javascript" src="js/H-ui.admin.js"></script> 
<script type="text/javascript">
/*头像上传*/
function preview(file) {
	var prevDiv = document.getElementById('preview');
	if (file.files && file.files[0]) {
	var reader = new FileReader();
	reader.onload = function(evt) {
	prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
	}
	reader.readAsDataURL(file.files[0]);
	} else {
	prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
	}
	}	
/*三级联动*/	
$("#city").click(function (e) {
	SelCity(this,e);
    console.log("inout",$(this).val(),new Date())
});	

	
/*--------------------------*/
$(function(){

	
	
	/*头像*/
	var img = document.createElement("img");//图片可从数据库调出初始化看见。
	var logo=$("#picture_hidden").val();
	var imgObj= $("<img>").attr("src", logo);  
	imgObj.appendTo("#preview");
	
	/*下拉框默认选中*/
	var temp=$("#sex_hidden").val()
	
	 $("select option").each(function(){  
         if($(this).val()==temp){  
             $(this).attr("selected","selected");  
         }  
     }); 

 
	/*提示*/

	/*提交表单*/
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-goods-add").Validform({
		tiptype:'3'	
	});

});

</script>
</body>
</html>