<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import = "dao.*"  %>
<%@page import = "java.util.*"  %>
<%@page import = "model.*"  %>
<%@page import = "model.Comment" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
<%
	//PlateDao plateDao= new PlateDao();	
	//int plateId = Integer.parseInt(request.getParameter("plateId"));
	
	//Plate plate = plateDao.checkPlateById(plateId);
	
 	
	//List<Post> posts = plateDao.getAllPost(plateId);
	//Post post = postDao.getPostById(pid);
	//double proportion = post.getCommentCount()/20.0 *100;
	//proportion =100;
	//pageContext.setAttribute("PostList",posts);
	//pageContext.setAttribute("Plate",plate);
	//pageContext.setAttribute("CommentList",comments);
	//pageContext.setAttribute("proportion",proportion);
	//pageContext.setAttribute("postId",pid);
	
	
	
	
	// 确认用户登录信息部分
	String ID=""; 
	String username="";
	int id;	
	Cookie[] cookies= request.getCookies();
	for(Cookie cookie:cookies)
	{
		if(cookie.getName().equals("id"))
		{
			ID = cookie.getValue();
		}
	}
	if(!ID.equals(""))
	{
		id = Integer.parseInt(ID);
		UserDao userDao = new UserDao();
		User user = userDao.checkUserById(id);
		username = user.getSname();
		pageContext.setAttribute("User",user);
		pageContext.setAttribute("userId",id);
		pageContext.setAttribute("userName",username);
	}
	else 
		pageContext.setAttribute("userName","未登录");

%>
<script>
	
</script>
    <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <!-- Search Box-->
          <div class="search-box">
            <button class="dismiss"><i class="icon-close"></i></button>
            <form id="searchForm" action="#" role="search">
              <input type="search" placeholder="What are you looking for..." class="form-control">
            </form>
          </div>
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.jsp" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block"><span>SCU</span><strong>BBS</strong></div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="javascript:;"><i class="icon-search"></i></a></li>
                <!-- Notifications-->
                <li class="nav-item dropdown"> <a id="notifications" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-bell-o"></i><span class="badge bg-red badge-corner">12</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-envelope bg-green"></i>You have 6 new messages </div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-upload bg-orange"></i>Server Rebooted</div>
                          <div class="notification-time"><small>4 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> 
                        <div class="notification">
                          <div class="notification-content"><i class="fa fa-twitter bg-blue"></i>You have 2 followers</div>
                          <div class="notification-time"><small>10 minutes ago</small></div>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>view all notifications                                            </strong></a></li>
                  </ul>
                </li>
                <!-- Messages                        -->
                <li class="nav-item dropdown"> <a id="messages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link"><i class="fa fa-envelope-o"></i><span class="badge bg-orange badge-corner">10</span></a>
                  <ul aria-labelledby="notifications" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Jason Doe</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-2.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Frank Williams</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item d-flex"> 
                        <div class="msg-profile"> <img src="img/avatar-3.jpg" alt="..." class="img-fluid rounded-circle"></div>
                        <div class="msg-body">
                          <h3 class="h5">Ashley Wood</h3><span>Sent You Message</span>
                        </div></a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item all-notifications text-center"> <strong>Read all messages   </strong></a></li>
                  </ul>
                </li>
                <!-- Languages dropdown    -->
                <li class="nav-item dropdown"><a id="languages" rel="nofollow" data-target="#" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link language dropdown-toggle"><img src="img/flags/16/GB.png" alt="English"><span class="d-none d-sm-inline-block">English</span></a>
                  <ul aria-labelledby="languages" class="dropdown-menu">
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/DE.png" alt="English" class="mr-2">German</a></li>
                    <li><a rel="nofollow" href="#" class="dropdown-item"> <img src="img/flags/16/FR.png" alt="English" class="mr-2">French</a></li>
                  </ul>
                </li>
                <!-- Logout    -->
                <li class="nav-item"><a href="login.jsp" class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">yanay</h1>
              <p>Web Designer</p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus--><span class="heading">${userName}</span>
          <ul class="list-unstyled">
                    <li class="active"><a href="index.jsp"> <i class="icon-home"></i>主页 </a></li>
                    <li><a href="#分类" aria-expanded="false" data-toggle="collapse"> <i class="icon-grid"></i>看帖 </a></li>
                    <ul id="分类" class="collapse list-unstyled ">
                        <li><a href="plate.jsp?plateId=1">校园</a></li>
                        <li><a href="plate.jsp?plateId=2">交友</a></li>
                        <li><a href="plate.jsp?plateId=3">科技</a></li>
                        <li><a href="plate.jsp?plateId=4">招领</a></li>
                      </ul>
                    </li>
                       <li><a href="postcommit.jsp"> <i class="icon-padnote"></i>发帖</a></li>                                 		
              		<li><a href="admin.jsp"> <i class="icon-interface-windows"></i>管理员界面</a></li>
            		<li> <a href="search.jsp"> <i class="icon-flask"></i>搜索 </a></li>
                    
          </ul><span class="heading">暂未开放</span>
          <ul class="list-unstyled">
         	 <li><a href="user.jsp"> <i class="icon-interface-windows"></i>用户 </a></li>
            <li> <a href='javascript:;'> <i class="icon-mail"></i>消息 </a></li>
            <li> <a href='javascript:;'> <i class="icon-screen"></i>Demo </a></li>
            <li> <a href='javascript:;'> <i class="icon-picture"></i>Demo </a></li>
          </ul>
        </nav>
        <div class="content-inner">
          <!-- Page Header-->
          
        
            <!-- Breadcrumb-->
          <div class="breadcrumb-holder container-fluid">
            <ul class="breadcrumb">
              <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
              <li class="breadcrumb-item active">Forms            </li>
            </ul>
          </div>
          <!-- Dashboard Counts Section-->
           <section class="forms ">
            <div class="container-fluid" >
            <div class="row">
              <!-- Project-->
       
       
       		<!-- Form Elements -->
                <div class="col-lg-12">
                  <div class="card">
                    <div class="card-close">
                      <div class="dropdown">
                        <button type="button" id="closeCard5" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-ellipsis-v"></i></button>
                        <div aria-labelledby="closeCard5" class="dropdown-menu dropdown-menu-right has-shadow"><a href="#" class="dropdown-item remove"> <i class="fa fa-times"></i>Close</a><a href="#" class="dropdown-item edit"> <i class="fa fa-gear"></i>Edit</a></div>
                      </div>
                    </div>
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">发布您的帖子</h3>
                    </div>
                    <div class="card-body">
                      <form class="form-horizontal" method="post" action="PostCommit">
            
            			<div class="line"> </div>
                        <div class="row">
                          <label class="col-sm-3 form-control-label">说点什么吧</label>
                          <div class="col-sm-9">
                            <div class="form-group-material">
                              <input id="register-username" type="text" name="title" required class="input-material">
                              <label for="register-username" class="label-material">帖子标题</label>
                           
                            </div>
                            <!-- 
                             <div class="form-group-material">
                              <input id="register-email" type="text" name="plateno" required class="input-material">
                              <label for="register-email" class="label-material">发表到的板块号 ${userId}   </label>
                            </div> -->
                            
                            <div class="form-group-material">
                            <textarea  id="register" placeholder="不支持markdown，不支持图片，对，我们啥都不支持。。。"  class="form-control" required data-msg="你总不能啥也不填丫" name ="content" ></textarea>                        
                            </div class="form-group-material">
                          </div>
                        </div>
                        <div class="line"></div>
                      
                        <div class="form-group row">
                          <label class="col-sm-3 form-control-label">发布到哪个板块？</label>
                          <div class="col-sm-9 offset-sm-3">
                            <select name="plate" class="form-control">
                              <option value ="1">校园</option>
                              <option value ="3">科技</option>
                              <option value ="2">交友</option>
                              <option value ="4">招领</option>
                            </select>
                          </div>
            			</div> 
            			<c:choose>
            				<c:when test="${cookie.isLogin.value==\"true\"}">
                        <div class="line"></div>
            			<div class="form-group row">
                          <div class="col-sm-4 offset-sm-3">    
                            <input type="hidden" name="userId" value="${userId}" >           
                            <input type="submit" class="btn btn-primary" value="立刻发表吧"></input>
                          </div>
                        </div>
                        </c:when>
                        <c:when test="${cookie.isLogin==null || cookie.isLogin.value==\"false\"}">
                        <div class="line"></div>
            			<div class="form-group row">
                          <div class="col-sm-4 offset-sm-3">
	                  				<h5>抱歉，您在登录后才能回复</h5>	     
	                  	  </div>
                        </div>             			
	                  			</c:when>
                	</c:choose>
            		 </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          
          </section>
            
       
          
          
          
          
          
          
             <!-- Page Footer-->
             
           <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>Copyright &copy; 2019.SCU. HCY && JZ</p>
                </div>
                <div class="col-sm-6 text-right">
                  <p></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
     
          
       <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="js/charts-home.js"></script>
    <!-- Main File-->
    <script src="js/front.js"></script>
  </body>
</html>        