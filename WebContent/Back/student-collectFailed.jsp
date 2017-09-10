<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="lib/jquery/1.9.1/jquery.min.js" type="text/javascript" ></script>
<script src="lib/layer/layer.js" type="text/javascript"></script>
</head>
<body>
 	<script type="text/javascript">	
 	top.layer.alert('申请失败，您已有项目或已加入项目！',{
  	  	  			               title: '提示框',				
  	  	  						   icon:2,		
  	  	  						  });
 	parent.location.reload();
 	</script>
</body>
</html>