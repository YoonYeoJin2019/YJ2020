<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String user_nickname = (String) session.getAttribute("user_nickname");
String user_auth = (String) session.getAttribute("user_auth");
%>

<html>
<head>
<meta charset="UTF-8">
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
	


	<link rel="stylesheet" href="/css/yyy.css">
	<!-- Animate.css -->
	<link rel="stylesheet" href="/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/css/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="/css/owl.carousel.min.css">
	<link rel="stylesheet" href="/css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/css/style.css">
	

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

			<div class="fh5co-narrow-content">
				<div class="row">

					<div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
						<figure class="text-center">
							<img src="/img/work.jpg" class="img-responsive" style="max-width: 60%; margin-left:auto;margin-right:auto" >
						</figure>
					</div>
					
					<div style="text-align: center;">
						
						
							<h1>Push up</h1>
							<p>푸쉬업을 합니덩</p>
                
                            
                    </div>
                    <div style="text-align: center;">
                        <p style="color:black">목표개수 설정 - 최소 50개 이상</p>
                    <input type="text" style="width:40%;padding-left: 10px;color: #000;">
					
					<div class="index2div">
						<input type="submit" class="index2submit" value="시작">
						<input type="button" class="index2submit" value="홈으로">
					</div>
					
					<div class="index2div2">
						<input type="button" class="index2submit" value="삭제">
						<input type="button" class="index2submit" value="수정">
                    </div>

                    </div>
				</div>

                <div>

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