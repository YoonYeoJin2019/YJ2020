<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="poly.dto.LoginDTO" %>
<!DOCTYPE html>

<%
String user_nickname = (String) session.getAttribute("user_nickname");
String user_auth = (String) session.getAttribute("user_auth");
LoginDTO lDTO = (LoginDTO) request.getAttribute("lDTO");

%>

<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Nitro &mdash; Free HTML5 Bootstrap Website Template by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="FreeHTML5.co" />

  <!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FreeHTML5.co
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	


	<link rel="stylesheet" href="/css/yyy.css?after">
	<!-- Animate.css -->
	<link rel="stylesheet" href="/css/animate.css?after">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/css/icomoon.css?after">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/css/bootstrap.css?after">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="/css/owl.carousel.min.css?after">
	<link rel="stylesheet" href="/css/owl.theme.default.min.css?after">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/css/style.css?after">
	

	<!-- Modernizr JS -->
	<script src="/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
	<div id="fh5co-page">
	
<%if(user_auth == null){ %>

<%@include file="/WEB-INF/view/bar/user.jsp"%>

<%}else if(user_auth.equals("0")){%>

<%@include file="/WEB-INF/view/bar/userlogin.jsp"%>

<%}else{ %>

<%@include file="/WEB-INF/view/bar/manager.jsp"%>

<%}%>

		<div id="fh5co-main">


		
			<div class="fh5co-narrow-content" style="border-bottom: 10px solid gainsboro;border-top:10px solid gainsboro;padding-top:20px;margin-top: 20px;padding-bottom: 20px;">
                <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft"> 나의 정보 </h2>
                
		

				<div class="loginwindow">

                <form>
                    <div class="setting1">회원번호</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_no() %></div></div>
                    <div class="setting1">아이디</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_id() %></div></div>
                    <div class="setting1">닉네임</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_nickname()%></div></div>
                    <div class="setting1">이름</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_name() %></div></div>
                    <div class="setting1">이메일</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_email()%></div></div>
                    <div class="setting1">권한</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_auth()%></div></div>
                    <div class="setting1">상태</div>
                    <div class="signup1"><div class="setting_div_in"><%=lDTO.getUser_stat()%></div></div>
                  
                    <div class="signup2">
						<input type="button" class="settingsubmit" value="강제탈퇴">
                        <input type="button" class="settingsubmit" value="권한변경">
                        <input type="button" class="settingsubmit" value="상태변경">
                    </div>
                    
                </form>
                </div>




                    
                    

               
                

			</div>
	


		</div>
	</div>

	<!-- jQuery -->
	<script src="/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/js/bootstrap.min.js"></script>
	<!-- Carousel -->
	<script src="/js/owl.carousel.min.js"></script>
	<!-- Stellar -->
	<script src="/js/jquery.stellar.min.js"></script>
	<!-- Waypoints -->
	<script src="/js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="/js/jquery.countTo.js"></script>
	
	
	<!-- MAIN JS -->
	<script src="/js/main.js"></script>

	</body>
</html>