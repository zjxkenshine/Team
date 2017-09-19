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
<!DOCTYPE html>
<html lang="en">
    <head>
   		<base href="<%=path%>/Front/">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>创业导师</title>

        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- custom css (blue color by default) -->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">
        <!-- custom css (green color ) -->
        <!--      <link href="css/style-green.css" rel="stylesheet" type="text/css" media="screen">-->
        <!-- custom css (red color ) -->
        <!--        <link href="css/style-red.css" rel="stylesheet" type="text/css" media="screen">-->
        <!-- custom css (yellow color ) -->
        <!--       <link href="css/style-yellow.css" rel="stylesheet" type="text/css" media="screen">-->
        <!-- custom css (sea-greean color ) -->
        <!--      <link href="css/style-sea-green.css" rel="stylesheet" type="text/css" media="screen">-->
        <!-- custom css (style-gold color ) -->
        <!--       <link href="css/style-gold.css" rel="stylesheet" type="text/css" media="screen">-->
        <!-- font awesome for icons -->
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- flex slider css -->
        <link href="css/flexslider.css" rel="stylesheet" type="text/css" media="screen">
        <!-- animated css  -->
        <link href="css/animate.css" rel="stylesheet" type="text/css" media="screen">
        <!--web fonts-->  
        <!--google fonts-->
        
        
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
        <!--owl carousel css-->
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" media="screen">
        <link href="css/owl.theme.css" rel="stylesheet" type="text/css" media="screen">
        <!--mega menu -->
        <link href="css/yamm.css" rel="stylesheet" type="text/css">
        <!--popups css-->
        <link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->


    </head>
    <body>

        <div id="header-top" class="hidden-xs">
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
                    <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="ASSAN"></a>
                </div>
                <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown active ">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">首页</i></a>
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
                        <li>
                            <a tabindex="-1" href="#">招聘信息</a>
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
                            <a tabindex="-1" href="../teacher_info.so">创业导师</a>
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
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown">名企介绍</a>
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
                            <a tabindex="-1" href="../Back/T_teacher_login.jsp"><i class="fa fa-user"></i>    教师登录</a>
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
                        <h4>${teacher.teacherName}</h4>&nbsp;&nbsp;&nbsp;
                        <h5>导师</h5>
                    </div>
                    <div class="col-sm-6 hidden-xs text-right">
                        <ol class="breadcrumb">
                            <li><a href="../teacher_info.so">创业导师</a></li>
                            <li>${teacher.teacherName}导师</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div><!--breadcrumbs-->
        <div class="divide80"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="blog-post">
                            <div>
                                <img src="${teacher.picture}" class="img-responsive" alt="教师照片" style="width:500px;height:500px">
                          
                            </div>                       
                        <ul class="list-inline post-detail">
                            <li>${teacher.sex}</li>
                            
                            <li><i class="fa fa-tag"></i> <a href="#">${teacher.school}/ ${teacher.academy}</a></li>
                            <li><i class="fa fa-comment"></i>${teacher.email}</li>
                        </ul>
                        <h2>个人简介:</h2>
                        <p class="lead">
 							${teacher.des}
 	                    </p>
                        <h2>特长方面:</h2>
                        <p class="dropcap">
                       		${teacher.speciality}
                        </p> 
                    </div><!--blog post-->
                  
                    <div class="comment-post">
                        <h3>${commentlist.size() }条留言</h3>
                        <c:forEach items="${commentlist }" var="msg">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="comment-list">
                                    <h4><img src="${msg.getStuPicture() }" class="img-responsive" alt="">
                                       	${msg.getStuName() } <a  class="btn btn-xs btn-theme-dark">学生留言</a>
                                    </h4>
                                    <p>
                                       ${msg.getMessage() }
                                    </p>
                                    <p>
                                    ${msg.getDate() }
                                    </p>
                                </div><!--comments list-->
                            </div>
                           <c:forEach items="${replylist }" var="reply">
                           <c:if test="${reply.getReplyID()==msg.getID() }">
                            <div class="col-md-8 col-md-offset-2">
                                <div class="comment-list">
                                    <h4><img src="${teacher.getPicture() }" class="img-responsive" alt="">
                                     	   ${reply.getTeacherName() } <a  class="btn btn-xs btn-theme-dark">老师回复</a> 
                                    </h4>
                                    <p>
                                       ${reply.getMessage() }
                                    </p>
                                     <p>
                                    ${msg.getDate() }
                                    </p>
                                </div><!--comments list-->
                            </div>
                            </c:if>
                            </c:forEach>
                        </div>
                        </c:forEach>
                    </div><!--comments-->
					
                    <ul class="pager">
                        <li class="previous"><a href="../teacher_singleinfo.so?nowPage=${page.nowPage<=1?1:page.nowPage-1}&ID=${teacher.getID()}">&larr;上一页</a></li>
                        <li>1</li>
                        <li class="next"><a href="../teacher_singleinfo.so?nowPage=${page.nowPage>=page.totalpage?page.totalpage:page.nowPage+1}&ID=${teacher.getID()}">下一页&rarr;</a></li>
                    </ul><!--pager-->
                    <div class="divide60"></div>
                    <c:if test="${student!=null }">
	                    <div class="comment-form">
	                        <h3>留言</h3>
	                        <div class="form-contact">
	                            <form action="../FrontAddLeaveComment.so" role="form">
	                        		<input type="hidden" name="ID" value="${teacher.getID() }">
	                                <div class="form-group">
	                                    <label for="message">内容</label>
	                                    <textarea class="form-control" rows="7" name="mesg" id="message" required=""></textarea>
	                                </div>                      
	                                <button type="submit" class="btn btn-theme-bg btn-lg pull-right">留言</button>
	                            </form>
	                        </div>
	                    </div>
                    </c:if>
                    <c:if test="${student==null }">
	                    <div class="comment-form">
	                        <h3>留言</h3>
	                        <div class="form-contact">
	                            <form action="" role="form">
	                                <div class="form-group">
	                                    <label for="message">内容</label>
	                                    <textarea class="form-control" rows="7" id="message" required=""></textarea>
	                                </div>                      
	                                <a href="../Back/student-login.jsp"><button type="button" class="btn btn-theme-bg btn-lg pull-right">留言</button></a>
	                            </form>
	                        </div>
	                    </div>
                    </c:if>
                </div><!--col-->
                <div class="col-md-3 col-md-offset-1">
                    
                    <div class="sidebar-box margin40">
                        <h4>推荐导师</h4>
                       <ul class="list-unstyled popular-post">
                       <c:forEach items="${tuijianlist }" var="tuijian">
                            <li>
                                <div class="popular-img">
                                    <a href="../teacher_singleinfo.so?ID=${tuijian.ID}&TeacherName=${tuijian.teacherName}"> <img src="${tuijian.getPicture() }" class="img-responsive" alt=""></a>
                                </div>
                                <div class="popular-desc">
                                    <h5> <a href="../teacher_singleinfo.so?ID=${tuijian.ID}&TeacherName=${tuijian.teacherName}">${tuijian.teacherName }</a></h5>
                                    <h6>${tuijian.school }</h6>
                                </div>
                            </li>
                       </c:forEach>
                        </ul>
                    </div><!--sidebar-box-->
                </div><!--sidebar-col-->
            </div><!--row for blog post-->
        </div><!--blog full main container-->
        <div class="divide60"></div>
             <footer id="footer">
            <div class="container">

                <div class="row">
                    <div class="col-md-3 col-sm-6 margin30">
                        <div class="footer-col">
                            <h3>About assan</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer lorem quam, adipiscing condimentum tristique vel, eleifend sed turpis. Pellentesque cursus arcu id magna euismod in elementum purus molestie.
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
                    <div class="col-md-3 col-sm-6 margin30">
                        <div class="footer-col">
                            <h3>Contact</h3>

                            <ul class="list-unstyled contact">
                                <li><p><strong><i class="fa fa-map-marker"></i> Address:</strong> vaisahali, jaipur, 302012</p></li> 
                                <li><p><strong><i class="fa fa-envelope"></i> Mail Us:</strong> <a href="#">Support@designmylife.com</a></p></li>
                                <li> <p><strong><i class="fa fa-phone"></i> Phone:</strong> +91 1800 2345 2132</p></li>
                                <li> <p><strong><i class="fa fa-print"></i> Fax</strong> 1800 2345 2132</p></li>
                                <li> <p><strong><i class="fa fa-skype"></i> Skype</strong> assan.856</p></li>

                            </ul>
                        </div>                        
                    </div><!--footer col-->
                    <div class="col-md-3 col-sm-6 margin30">
                        <div class="footer-col">
                            <h3>Featured Work</h3>
                            <ul class="list-inline f2-work">
                                <li><a href="portfolio-single.html"><img src="img/img-1.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-2.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-3.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-4.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-5.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-6.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-7.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-8.jpg" class="img-responsive" alt=""></a></li>
                                <li><a href="portfolio-single.html"><img src="img/img-9.jpg" class="img-responsive" alt=""></a></li>
                            </ul>
                        </div>                        
                    </div><!--footer col-->
                    <div class="col-md-3 col-sm-6 margin30">
                        <div class="footer-col">
                            <h3>Newsletter</h3>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer lorem quam, 
                            </p>
                            <form role="form" class="subscribe-form">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Enter email to subscribe">
                                    <span class="input-group-btn">
                                        <button class="btn  btn-theme-dark btn-lg" type="submit">Ok</button>
                                    </span>
                                </div>
                            </form>
                        </div>                        
                    </div><!--footer col-->

                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="footer-btm">
                            <span>&copy;2014. Theme by Design_mylife</span>
                        </div>
                    </div>
                </div>
            </div>
        </footer><!--default footer end here-->
       <!--scripts and plugins -->
        <!--must need plugin jquery-->
        <script src="js/jquery.min.js"></script>        
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
        
        
        <!--customizable plugin edit according to your needs-->
        <script src="js/custom.js" type="text/javascript"></script>
    </body>
</html>
