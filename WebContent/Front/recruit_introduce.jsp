<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
       <base href="<%=path%>/Front/">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>最新职位</title>

        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
  
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
  
        <link href="css/flexslider.css" rel="stylesheet" type="text/css" media="screen">
 
        <link href="css/animate.css" rel="stylesheet" type="text/css" media="screen">
 


        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
      
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="screen">
        <link href="css/owl.theme.css" rel="stylesheet" type="text/css" media="screen">
      
        <link href="css/yamm.css" rel="stylesheet" type="text/css">
      
        <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">

        <link href="sky-form/css/sky-forms.css" rel="stylesheet">
        
        <script src="../Back/js/jquery-1.11.3.min.js"></script>
        <script src="../Back/js/Popt.js"></script>
        <script src="../Back/js/cityJson.js"></script>
        <script src="../Back/js/citySet.js"></script>
        
		
        
        <style type="text/css">
      

        </style>   
        
       
</script>     
    </head>
    <body>

 <div class="top-bar-dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <ul class="list-inline socials-simple">
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    <li><a href="#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                </ul>
            </div>
            <div class="col-sm-8 hidden-xs text-right">
                <ul class="list-inline top-dark-right">
                    <li><i class="fa fa-envelope"></i> Soul@mail.com</li>
                    <li><i class="fa fa-phone"></i> +02 1212 121 2121</li>
                </ul>
            </div>
        </div>
    </div>
</div><!--top-bar-dark end here-->
<!--navigation -->
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top yamm sticky" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home.html"><img src="img/logo.png" alt="Soul"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active ">
                    <a href="home.jsp" class="dropdown-toggle" >首页</i></a>
                </li>
                <!--menu 首页 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">就业日历<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="#">宣讲会</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">招聘会</a>
                        </li>
                    </ul>
                </li>
                <!--menu 就业日历 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">就业指导<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="#">面试宝典</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">求职技巧</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">简历指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">就业指南</a>
                        </li>
                    </ul>
                </li>
                <!--menu 就业指导 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">创业指导<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="#">创业政策</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">创业导师</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">项目申报</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">创业动态</a>
                        </li>
                    </ul>
                </li>
                <!--menu 创业指导 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">服务指南<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu">
                        <li>
                            <a tabindex="-1" href="#">企业指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">学生指南</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#">资源下载</a>
                        </li>
                    </ul>
                </li>
                <!--menu 服务指南 li end here-->
                <li class="dropdown">
                    <a href="firm_introduce.jsp" class="dropdown-toggle " >名企介绍</a>
                </li>
                <!--menu 名企介绍 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">最新职位</a>
                </li>
                <!--menu 最新职位 li end here-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown"><i class="fa fa-lock"></i>登录入口<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu" style="text-align: center">
                        <li>
                            <a tabindex="-1" href="#"><i class="fa fa-user"></i>    学生登录</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#"><i class="fa fa-user"></i>    教师登录</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="#"><i class="fa fa-user"></i>    企业登录</a>
                        </li>
                    </ul>
                </li>
                <!--menu 登录入口 li end here-->
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--container-->
</div><!--navbar-default-->
        
        <div class="breadcrumb-wrap">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h4>最新职位</h4>
                    </div>          
                </div>
            </div>
        </div><!--breadcrumbs-->
        <div class="divide80"></div>
             
        <div class="container">     
                      
           <div class="row margin10">
              <form action="../FrontQueryRecruit.so" > 
                <div class="col-md-3">                 
                     <input type="text" name="firm" value="${firm }" class="form-control" placeholder="招聘企业" >                     
                </div>
                
                <div class="col-md-3">                  
					<input id="work" name="work" type="text" class="form-control" value="${work }" placeholder="查询职位"/>                                
                </div>
                
                <div class="col-md-3">                         
                    <select id="Type" name="EducationBgd"  class="form-control"   >
                    <c:if test="${EducationBgd!=null&&EducationBgd!='' }">
                    <option value="${EducationBgd }" selected="selected">${EducationBgd }</option>
                    </c:if>
					<option value="">请选择学历</option>
					<option value="大学本科">大学本科</option>
					<option value="大学专科" >大学专科</option>
					<option value="博士研究生" >博士研究生</option>
					<option value="硕士研究生" >硕士研究生</option>
					<option value="其它">其它</option>						
				</select>
                </div>
                <div class="col-md-3">
                   <input type="submit" class="btn btn border-theme" value="搜索" style="width:65px;height:35px;">&nbsp;&nbsp;&nbsp;
                   <input type="reset" class="btn btn border-theme" value="重置" style="width:65px;height:35px;">
                </div>
              </form>
            </div>
               
           <div class="row">
              <div class="col-md-10 col-md-offset-0">
                
                  <c:forEach items="${recruitlist}" var="rec">
                     <hr>
                   <table width="100%">
                   <tr width="100%"><td align="left" width="50%"><a href="../FrontRecruitDetailSet.so?ID=${rec.getID() }"><b>${rec.getJob() }</b></a></td><td width="50%" align="right"><i>${rec.getDate() }</i></td></tr>
                   <tr width="100%"><td align="left" width="50%"><a href="../firm_F_informaiton_detail.so?FirmName=${rec.getFirmName() }">${rec.getFirmName() }</a>|${rec.getJobNature() } | ${rec.getEducationBgd() }</td><td width="50%" align="right">${rec.getPay() }</td></tr>
                   </table>
                   
                 </c:forEach>
             	 <ul class="filter list-inline">
                    <li><a href="../FrontQueryRecruit.so?nowPage=1&firm=${firm }&work=${work}&EducationBgd=${EducationBgd }" >首页</a></li>
                    <li><a href="../FrontQueryRecruit.so?nowPage=${page.nowPage<=1?1:page.nowPage-1}&firm=${firm }&work=${work}&EducationBgd=${EducationBgd }" >上一页</a></li>
                    <li><a data-filter="*">${page.getNowPage()==null?1:page.getNowPage()}</a></li>
                    <li><a href="../FrontQueryRecruit.so?nowPage=${page.nowPage>=page.totalpage?page.totalpage:page.nowPage+1}&firm=${firm }&work=${work}&EducationBgd=${EducationBgd }" >下一页</a></li>
                    <li><a href="../FrontQueryRecruit.so?nowPage=${page.totalpage}&firm=${firm }&work=${work}&EducationBgd=${EducationBgd }">末页</a></li>
                </ul>
                </div>
            </div>
        </div><!--container-->

        <div class="divide40"></div>
<footer id="footer">
    <div class="container">

        <div class="row">
            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>关于我们</h3>
                    <p>
                        
                    </p>
                    <ul class="list-inline social-1">
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                        <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                    </ul>
                </div>
            </div><!--footer col-->



            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>留言</h3>
                    <p>
                        我们致力于为人民服务
                    </p>
                    <form role="form" class="subscribe-form">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="想对ss说些什么...">
                            <span class="input-group-btn">
                                        <button class="btn  btn-theme-dark btn-lg" type="submit">发送</button>
                                    </span>
                        </div>
                    </form>
                </div>
            </div><!--footer col-->
            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>联系我们</h3>
                    <ul class="list-unstyled contact">
                        <li><p><strong><i class="fa fa-map-marker"></i> 公司地址:</strong> 山东省济南市齐鲁工业大学</p></li>
                        <li><p><strong><i class="fa fa-envelope"></i> 电子邮箱:</strong> <a href="#">Soul@designmylife.com</a></p></li>
                        <li> <p><strong><i class="fa fa-phone"></i> 电话:</strong> +02 1212 121 2121</p></li>
                        <li> <p><strong><i class="fa fa-print"></i> 传真：</strong> 1821 2121 2121</p></li>
                        <li> <p><strong><i class="fa fa-skype"></i> 网络电话：</strong> soul.212</p></li>

                    </ul>
                </div>
            </div><!--footer col-->
        </div>
        <div class="row">
            <div class="col-md-12 text-center">
                <div class="footer-btm">
                    <span>&copy;2017. by soul</span>
                </div>
            </div>
        </div>
    </div>
</footer><!--底部 end here-->
        <!--scripts and plugins --> 
      
        <!--must need plugin jquery-->
             
        <!--bootstrap js plugin-->
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>       
        <!--easing plugin for smooth scroll-->
        <script src="js/jquery.easing.1.3.min.js" type="text/javascript"></script>
        <!--sticky header-->
        <script type="text/javascript" src="js/jquery.sticky.js"></script>
        <!--flex slider plugin-->
        <script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
        <!--parallax background plugin-->
        <script src="js/jquery.stellar.min.js" type="text/javascript"></script>

        <script src="js/jquery.isotope.min.js" type="text/javascript"></script>
        <!--digit countdown plugin-->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.3/waypoints.min.js"></script>
        <!--digit countdown plugin-->
        <script src="js/jquery.counterup.min.js" type="text/javascript"></script>
        <!--on scroll animation-->
        <script src="js/wow.min.js" type="text/javascript"></script> 
        <!--owl carousel slider-->
        <script src="js/owl.carousel.min.js" type="text/javascript"></script>
        <!--popup js-->
        <script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
        <!--you tube player-->
        <script src="js/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>
        <!--image loads plugin -->
        <script src="js/jquery.imagesloaded.min.js" type="text/javascript"></script>


        <!--customizable plugin edit according to your needs-->
        <script src="js/custom.js" type="text/javascript"></script>
        <script src="js/isotope-custom.js" type="text/javascript"></script>
   

        <script type="text/javascript">
        /*三级联动*/	
          $("#Area").click(function (e) {
	      SelCity(this,e);
          console.log("inout",$(this).val(),new Date())
           });
          

          
        </script>
    </body>
 </html>