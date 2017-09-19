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
        <title>assan - Professional theme</title>

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
                    <a href="../home.so" class="dropdown-toggle" >首页</i></a>
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
                    <a href="../firm_F_information.so" class="dropdown-toggle " >名企招聘</a>
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
                        <h4>企业详情</h4>
                    </div>          
                </div>
            </div>
        </div><!--breadcrumbs-->
        
        <div class="container">
        
          <div class="row">          
            <div class="col-md-10 col-md-offset-0">                      
               <div class="about-author">           
                  <img src="${firm.logo}" class="img-responsive" alt="" style="width:120px;height:120px;">
                  <h4 class="colored-text">${firm.firmName}</h4>
                  <p>区域：${firm.area}||企业类型：${firm.type}||企业规模：${firm.peopleNumber}</p>
                  <p>详细地址:${firm.adress}||联系人:${firm.linkMan}||电话：${firm.tel}||邮箱：${firm.email}</p>                                                                    
                </div><!--about author-->           
                                
                <h4>企业介绍</h4>               
                <hr>
                <p>
                   ${firm.des}                             
                </p>
                <c:if test="${student==null }">                       
                <p><a href="../Back/student-login.jsp" class="btn btn-lg btn-theme-bg">关注该公司</a></p>
                </c:if>
                <c:if test="${student!=null&&checkfirmcollect }">
                <p><a href="../FrontCollectFirm.so?id=${firm.getID()}" class="btn btn-lg btn-theme-bg">关注该公司</a></p>
                </c:if>
                <c:if test="${student!=null&&!checkfirmcollect }">
                <p><a class="btn btn-lg btn-theme-bg">已收藏</a></p>
                </c:if>
                <br>                                                             
             </div>            
           </div> 
           
           <div class="row">
              <div class="col-md-10 col-md-offset-0">
              <h4>该企业还在招职位</h4>
               
                 <c:forEach items="${list}" var="recruit">
                   <hr>
                   <table width="100%">
                   <tr width="100%"><td align="left" width="50%"><a href="" class="colored-text">${recruit.job}</a></td><td width="50%" align="right">${recruit.date}</td></tr>
                   <tr width="100%"><td align="left" width="50%">学历：${recruit.educationBgd}||工作性质：${recruit.jobNature}</td><td width="50%" align="right">${recruit.pay}</td></tr>
                   </table>
                 </c:forEach>                    
                  
                                                                   
              </div>            
           </div>
                            
        </div>  
          
        <div class="divide80"></div>
 <footer id="footer">
    <div class="container">

        <div class="row">
            <div class="col-md-4 col-sm-6 margin30">
                <div class="footer-col">
                    <h3>关于我们</h3>
                    <p>
                        我们注重品质，绝对不卖乱七八糟的宝贝，不找乱七八糟的伙伴，想要做卧底侦探的请绕道，虽然我们很简单很善良，但是有必要时我们也很黄很暴力！
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
</html>