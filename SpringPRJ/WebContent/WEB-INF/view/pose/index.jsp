<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="poly.dto.HealthDTO" %>
    <%@ page import="java.util.List"%>    
    <%@ page import="java.util.ArrayList"%>
    
<!DOCTYPE html>

<%
String user_nickname = (String) session.getAttribute("user_nickname");
String user_auth = (String) session.getAttribute("user_auth");

List<HealthDTO> hList = (List<HealthDTO>) request.getAttribute("hList");

%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="FreeHTML5.co" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
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

<%if(user_auth == null){ %>


<%}else{ %>

			<div class="fh5co-counters" style="background-image: url(/img/hero.jpg);" data-stellar-background-ratio="0.5" id="counter-animate">
				<div class="fh5co-narrow-content animate-box">
					<div class="row" >
						<div class="col-md-4 text-center">
							<span class="fh5co-counter js-counter" data-from="0" data-to="10" data-speed="5000" data-refresh-interval="50"></span>
							<span class="fh5co-counter-label">접속일수</span>
						</div>
						<div class="col-md-4 text-center">
							<span class="fh5co-counter js-counter" data-from="0" data-to="11" data-speed="5000" data-refresh-interval="50"></span>
							<span class="fh5co-counter-label">운동개수</span>
						</div>
						<div class="col-md-4 text-center">
							<span class="fh5co-counter js-counter" data-from="0" data-to="5" data-speed="5000" data-refresh-interval="50"></span>
							<span class="fh5co-counter-label">목표달성개수</span>
						</div>
					</div>
				</div>
			</div>

<%}%>


		
			<div class="fh5co-narrow-content" style="border-bottom: 10px solid gainsboro;border-top:10px solid gainsboro;padding-top:20px;margin-top: 20px;padding-bottom: 20px;">
				<h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft"> 순위 </h2>
				<div class="row animate-box" data-animate-effect="fadeInLeft">
	



				
					<div class="col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item">
							<h3 class="fh5co-work-title">오늘의 운동왕</h3>

							<ul class="c">
								<li  class="a">순위</li>
								<li  class="d">닉네임</li>
								<li  class="d">개수</li>        
							</ul>
							<ul class="c">
								<li  class="a">1</li>
								<li  class="d">헐크</li>
								<li  class="d">100</li>        
							</ul>
							<ul class="c">
								<li  class="a">2</li>
								<li  class="d">토르</li>
								<li  class="d">30</li>        
							</ul>
							<ul class="c">
								<li  class="a">3</li>
								<li  class="d">아이언맨</li>
								<li  class="d">5</li>        
							</ul>
							<ul class="c">
								<li  class="a">1050</li>
								<li  class="d">윤여진</li>
								<li  class="d">1</li>        
							</ul>
					
					</div>





					<div class="col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item">
						<h3 class="fh5co-work-title">누적 운동왕</h3>
			
						<ul class="c">
							<li  class="a">순위</li>
							<li  class="d">닉네임</li>
							<li  class="d">개수</li>        
						</ul>
						<ul class="c">
							<li  class="a">1</li>
							<li  class="d">헐크</li>
							<li  class="d">100</li>        
						</ul>
						<ul class="c">
							<li  class="a">2</li>
							<li  class="d">토르</li>
							<li  class="d">30</li>        
						</ul>
						<ul class="c">
							<li  class="a">3</li>
							<li  class="d">아이언맨</li>
							<li  class="d">5</li>        
						</ul>
						<ul class="c">
							<li  class="a">1050</li>
							<li  class="d">윤여진</li>
							<li  class="d">1</li>        
						</ul>


					</div>


					<div class="clearfix visible-md-block visible-sm-block"></div>

					<div class="col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item">
						<h3 class="fh5co-work-title">목표달성왕</h3>
			
						<ul class="c">
							<li  class="a">순위</li>
							<li  class="d">닉네임</li>
							<li  class="d">개수</li>        
						</ul>
						<ul class="c">
							<li  class="a">1</li>
							<li  class="d">헐크</li>
							<li  class="d">100</li>        
						</ul>
						<ul class="c">
							<li  class="a">2</li>
							<li  class="d">토르</li>
							<li  class="d">30</li>        
						</ul>
						<ul class="c">
							<li  class="a">3</li>
							<li  class="d">아이언맨</li>
							<li  class="d">5</li>        
						</ul>
						<ul class="c">
							<li  class="a">1050</li>
							<li  class="d">윤여진</li>
							<li  class="d">1</li>        
						</ul>

					</div>

					
				</div>
			</div>

			<div class="fh5co-narrow-content" style="padding-top:20px;margin-top: 10px;">
				<div class="index_div2">

					<div class="index_div2_80"><h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft">운동 리스트 </h2></div>
					<div class="index_div2_20">	
						<div class="index2div">
						<input type="button" class="index2submit" value="운동등록" onclick="location.href='index_ready_1.do'">
					</div>
				</div>

				</div>
				
				<div class="row animate-box" data-animate-effect="fadeInLeft">
				
				  <!--for 시작-->
				  
				<% if(hList!=null){%>  
				<%for(HealthDTO hDTO : hList){%>
				
					<div class="col-md-4 col-sm-6 col-xs-6 col-xxs-12 work-item">
						<a href="index_ready.do?Health_no=<%=hDTO.getHealth_no()%>&Health_name=<%=hDTO.getHealth_name()%>">
							<img src="/pose/<%=hDTO.getHealth_no()%>/<%=hDTO.getHealth_img()%>" class="img-responsive" style="width: 100%;height:330px;">
							<h3 class="fh5co-work-title"><%=hDTO.getHealth_name()%></h3>
							
						</a>
					</div>
				<%} %>
<%} %>

				<!--for 끝-->	
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