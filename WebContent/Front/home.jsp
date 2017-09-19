<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<%
	String  path = request.getContextPath();
	%>
	<base href="<%=path%>/Front/">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>大学生就业创业网</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- custom css-->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen">

    <!-- font awesome for icons -->
    <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- flex slider css -->
    <link href="css/flexslider.css" rel="stylesheet" type="text/css" media="screen">
    <!-- animated css  -->
    <link href="css/animate.css" rel="stylesheet" type="text/css" media="screen">
    <!--Revolution slider css-->
    <link href="rs-plugin/css/settings.css" rel="stylesheet" type="text/css" media="screen">
    <link href="css/rev-style.css" rel="stylesheet" type="text/css" media="screen">
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
                            <a tabindex="-1" href="../StudentLoginTransform.sdo">项目申报</a>
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
                    <a href="../FrontQueryRecruit.so" class="dropdown-toggle ">最新职位</a>
                </li>
                <!--menu 最新职位 li end here-->
                <li class="dropdown">
                
                    <a href="#" class="dropdown-toggle " data-toggle="dropdown"><i class="fa fa-lock"></i>登录入口<i class="fa fa-angle-down"></i></a>
                    <ul class="dropdown-menu multi-level" role="menu" style="text-align: center">
                        <li>
                            <a tabindex="-1" href="../Back/student-login.jsp"><i class="fa fa-user"></i>    学生登录</a>
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
<!--revolution slider-->
<article>
    <div>
        <div class="tp-banner-vertical" >
            <ul>    <!-- SLIDE  -->
                <li data-transition="slidevertical" data-slotamount="1" data-masterspeed="1000" data-thumb="img/construction/constro-bg-1.jpg"  data-saveperformance="off"  data-title="Slide">
                    <!-- MAIN IMAGE -->
                    <img src="img/construction/constro-bg-1.jpg"  alt="fullslide1"  data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption vertical-title lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="-70"
                         data-speed="600"
                         data-start="800"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >interior designs
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption vertical-caption lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="20"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >Nullam vulputate lorem ut leo. Sed volutpat.<br> Etiam non pede. Nullam et mauris.
                    </div>
                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption rev-buttons lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="110"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    ><a href="#" class="btn btn-lg border-white">Learn more</a>
                    </div>
                </li>
                <!-- SLIDE  -->
                <li data-transition="slidevertical" data-slotamount="1" data-masterspeed="1000" data-thumb="img/construction/constro-bg-2.jpg"  data-saveperformance="off"  data-title="Slide">
                    <!-- MAIN IMAGE -->
                    <img src="img/construction/constro-bg-2.jpg"  alt="fullslide1"  data-bgposition="center top" data-bgfit="cover" data-bgrepeat="no-repeat">
                    <!-- LAYERS -->

                    <!-- LAYER NR. 1 -->
                    <div class="tp-caption vertical-title lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="-70"
                         data-speed="600"
                         data-start="800"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >Construction management
                    </div>

                    <!-- LAYER NR. 2 -->
                    <div class="tp-caption vertical-caption lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="20"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    >Nullam vulputate lorem ut leo. Sed volutpat.<br> Etiam non pede. Nullam et mauris.
                    </div>
                    <!-- LAYER NR. 3 -->
                    <div class="tp-caption rev-buttons lfb ltt tp-resizeme"
                         data-x="left" data-hoffset="100"
                         data-y="center" data-voffset="110"
                         data-speed="600"
                         data-start="900"
                         data-easing="Power4.easeOut"
                         data-splitin="none"
                         data-splitout="none"
                         data-elementdelay="0.01"
                         data-endelementdelay="0.1"
                         data-endspeed="500"
                         data-endeasing="Power4.easeIn"
                    ><a href="#" class="btn btn-lg border-white">Learn more</a>
                    </div>
                </li>



            </ul>
            <div class="tp-bannertimer"></div>
        </div>
    </div>
</article>		<!--revolution vertical slider end-->

<div class="divide70"></div>
<div class="schedule">
    <div class="container">
        <div class="center-heading">
            <h2>招聘会</h2>
            <span class="center-line"></span>
            <p class="margin40">
                But I must explain to you how all this mistaken idea of denouncing <br>pleasure and praising pain was born and I will give you a complete account of the system
            </p>
        </div>
        <div class="row">
            <div class="col-sm-6">

                <div class="event-box animated fadeInLeft">
                    <span class="time"><i class="fa fa-clock-o"></i> 9:00 PM</span>

                    <h3 class="title">
                        lorem ipsum dolor sit amet
                    </h3>

                    <p>
                        But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure,
                    </p>
                    <span class="author">Daniel Smith</span>
                </div><!--event box-->
                <div class="event-box animated fadeInLeft">
                    <span class="time"><i class="fa fa-clock-o"></i> 1:00 PM</span>

                    <h3 class="title">
                        lorem ipsum dolor sit amet
                    </h3>

                    <p>
                        But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure,
                    </p>
                    <span class="author">Daniel Smith</span>
                </div><!--event box-->
            </div>
            <div class="col-sm-6">

                <div class="event-box animated fadeInLeft">
                    <span class="time"><i class="fa fa-clock-o"></i> 11:00 PM</span>

                    <h3 class="title">
                        lorem ipsum dolor sit amet
                    </h3>

                    <p>
                        But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure,
                    </p>
                    <span class="author">Daniel Smith</span>
                </div><!--event box-->
                <div class="event-box animated fadeInLeft">
                    <span class="time"><i class="fa fa-clock-o"></i> 3:30 PM</span>

                    <h3 class="title">
                        lorem ipsum dolor sit amet
                    </h3>

                    <p>
                        But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure,
                    </p>
                    <span class="author">Daniel Smith</span>
                </div><!--event box-->
            </div>
        </div>
    </div>
</div><!--招聘会 end-->
<div class="divide70"></div>
<div class="featured-work">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="center-heading">
                    <h2>名企招聘</h2>
                    <span class="center-line"></span>
                </div>
            </div>
        </div>
    </div>
    <!--owl carousel start-->
    <div id="featured-work">

        <div class="item">
            <div class="work-wrap">
                <img src="img/img-1.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-1.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-2.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-2.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-3.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-3.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-4.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-4.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-5.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-5.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-6.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-6.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-7.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-7.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
        <div class="item">
            <div class="work-wrap">
                <img src="img/img-8.jpg" class="img-responsive" alt="">
                <div class="img-overlay">
                    <div class="inner-overlay">
                        <h2>Title</h2>
                        <p>Date / Time</p>
                        <a class="link" href="#"><i class="fa fa-search"></i></a>
                        <a class="zoom show-image" href="img/img-8.jpg"><i class="fa fa-image"></i></a>
                    </div>
                </div><!--img-overlay-->
            </div><!--work-image-wrap end-->
        </div><!--owl item end-->
    </div>
</div><!--名企招聘 end-->
<div class="divide70"></div>
<div class="assan-features">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="center-heading">
                    <h2>最新<strong>职位</strong></h2>
                    <span class="center-line"></span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="100ms">
                    <div class="services-box-icon">
                        <i class="fa fa-image"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>Sliders</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="200ms">
                    <div class="services-box-icon">
                        <i class="fa fa-envelope"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>Advanced Forms</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="300ms">
                    <div class="services-box-icon">
                        <i class="fa fa-users"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>Customer Support</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->

            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="400ms">
                    <div class="services-box-icon">
                        <i class="fa fa-crop"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>Pixel perfect design</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="500ms">
                    <div class="services-box-icon">
                        <i class="fa fa-twitter"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>bootstrap 3.3.4</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.
                        </p>
                    </div>
                </div><!--services box-->
            </div><!--services col-->
            <div class="col-md-4 col-sm-6 margin20">
                <div class="services-box wow animated fadeIn" data-wow-duration="700ms" data-wow-delay="600ms">
                    <div class="services-box-icon">
                        <i class="fa fa-flag"></i>
                    </div><!--services icon-->
                    <div class="services-box-info">
                        <h4>Font Awesome icons</h4>
                        <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.

                        </p>

                    </div>
                </div><!--services box-->
            </div><!--services col-->
        </div><!--services row-->
    </div>
</div><!--最新职位 end-->
<div class="divide70"></div>
<div class="constro-cta parallax" data-stellar-background-ratio="0.5">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <p>Lorem ipsum dolor sit amet</p>
                <h1>Interior design Award</h1>
                <i class="fa fa-trophy"></i>
                <p><a href="#" class="btn btn-theme-bg btn-lg">See all award <i class="fa fa-chevron-right"></i></a></p>
            </div>
        </div>
    </div>
</div><!--constro cta-->
<div class="testimonials-v-2 construction wow animated fadeInUp" data-wow-duration="700ms" data-wow-delay="100ms">
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="center-heading">
                    <h2>名师交流</h2>
                    <span class="center-line"></span>

                </div>
            </div>
        </div><!--center heading end-->

        <div class="row">

            <div class="col-sm-8 col-sm-offset-2">
                <div class="testi-slide">
                    <ul class="slides">
                        <li>
                            <img src="img/customer-1.jpg" alt="">
                            <p>
                                <i class="ion-quote"></i>
                                It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters.
                            </p>
                            <h4 class="test-author">
                                Rick man - <em>rock inc</em>
                            </h4>
                        </li><!--testi item-->
                        <li>
                            <img src="img/customer-2.jpg" alt="">
                            <p>
                                <i class="ion-quote"></i>
                                Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years </p>
                            <h4 class="test-author">
                                Jellia - <em>Founder of tinka inc</em>
                            </h4>
                        </li><!--testi item-->
                        <li>
                            <img src="img/customer-3.jpg" alt="">
                            <p>
                                <i class="ion-quote"></i>
                                Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor.</p>
                            <h4 class="test-author">
                                Smith - <em>Ceo, company inc.</em>
                            </h4>
                        </li><!--testi item-->
                    </ul>
                </div><!--flex slider testimonials end here-->
            </div>
        </div><!--testi slider row end-->
    </div>
</div><!--名师交流 end-->
<div class="divide70"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="center-heading">
                <h2>政策·动态</h2>
                <span class="center-line"></span>
            </div>
        </div>
        <div class="margin40">
                <div class="col-md-6">
                    <a href="#">
                        <div class="news-desc">
                            <span>Sports</span>
                            <h4><a href="#">Lorem ipsum dollor Sit amet</a></h4>
                            <span>By <a href="#">Author</a> on 24 july 2014</span>
                            <span>Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.</span>
                            <span><a href="#">Read more...</a></span>
                        </div><!--news desc-->
                    </a><!--news link-->
                </div>
            <div class="col-md-6">
                <a href="#">
                    <div class="news-desc">
                        <span>Sports</span>
                        <h4><a href="#">Lorem ipsum dollor Sit amet</a></h4>
                        <span>By <a href="#">Author</a> on 24 july 2014</span>
                        <span>Lorem ipsum dolor sit amet, consectetur adipiscing metus. elit. Quisque rutrum pellentesque imperdiet.</span>
                        <span><a href="#">Read more...</a></span>
                    </div><!--news desc-->
                </a><!--news link-->
            </div>
        </div><!--col 7 end use for latest news owl carousel slide-->
    </div>
</div><!--政策·动态 end-->
<div class="divide70"></div>



<div class="divide40"></div>

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
<!--scripts and plugins -->
<!--must need plugin jquery-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery-migrate.min.js"></script>
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

<script src="js/jquery.isotope.min.js" type="text/javascript"></script>
<!--image loads plugin -->
<script src="js/jquery.imagesloaded.min.js" type="text/javascript"></script>
<!--owl carousel slider-->
<script src="js/owl.carousel.min.js" type="text/javascript"></script>
<!--popup js-->
<script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
<!--you tube player-->
<script src="js/jquery.mb.YTPlayer.min.js" type="text/javascript"></script>
<!--customizable plugin edit according to your needs-->
<script src="js/custom.js" type="text/javascript"></script>

<!--revolution slider plugins-->
<script src="rs-plugin/js/jquery.themepunch.tools.min.js" type="text/javascript"></script>
<script src="rs-plugin/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script>
<script src="js/revolution-custom.js" type="text/javascript"></script>
<script src="js/isotope-custom.js" type="text/javascript"></script>
</body>
</html>
