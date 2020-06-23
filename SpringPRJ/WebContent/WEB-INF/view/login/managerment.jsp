<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="poly.dto.LoginDTO"%>
<!DOCTYPE html>

<%
String user_nickname = (String) session.getAttribute("user_nickname");
String user_auth = (String) session.getAttribute("user_auth");
List<LoginDTO> lList = (List<LoginDTO>) request.getAttribute("lList");
int pgNum = (int) request.getAttribute("pgNum");
int cnt = (int)request.getAttribute("cnt");


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
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>




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
	-->
	
	</head>
	<body>

<script>
	$(document).on("click", "#btnSearch", function(){


		var url = "managerment.do";

		url = url + "?searchType=" + $('#searchType').val();

		url = url + "&keyword=" + $('#keyword').val();

		location.href = url;

		console.log(url);
	});

</script>
	
	
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
                <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft"> 회원관리 </h2>



			<div class="managerwindow">

                <div class="m_management_window1">
                    <li>
                         <select name="searchType" id="searchType" style="height:39px;">
                             <option value="user_id">아이디</option>
                             <option value="user_name">이름</option>
                             <option value="user_nickname">닉네임</option>
                             <option value="user_auth">권한</option>
                             <option value="user_stat">상태</option>
                         </select>
                     </li>
                     <li><input type="text" name="keyword" id="keyword" style="height:39px;"></li>
                     <li><button class="pg_movebtn2" name="btnSearch" id="btnSearch" style="height:39px; background-color: white;">검색</button></li>
                </div>

                  <div style="display:table;table-layout:fixed; width:100%;">    
                    <ul style="display: table-row; background-color: white;">
                    <li class="tfont tbottomline" style="display:table-cell;width:10%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">NO</li>
					<li class="tfont tbottomline" style="display:table-cell;width:18%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">아이디</li>
					<li class="tfont tbottomline" style="display:table-cell;width:18%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">닉네임</li>
                    <li class="tfont tbottomline" style="display:table-cell;width:18%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">이름</li>
                    <li class="tfont tbottomline" style="display:table-cell;width:18%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">권한</li>
					<li class="tfont tbottomline" style="display:table-cell;width:18%;text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">상태</li> 					
					</ul>
						<%for(LoginDTO lDTO : lList){%>
					
					
					<ul class="manaul">
						<li class="tfont tbottomline" style="width:10%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>"><%=lDTO.getUser_no() %></a></li>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>"><%=lDTO.getUser_id() %></a></li>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>"><%=lDTO.getUser_nickname() %></a></li>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>"><%=lDTO.getUser_name() %></a></li>
						<%if("0".equals(lDTO.getUser_auth())){%>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">회원</a></li>
						<%}else{%>	
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">관리자</a></li>
						<%}%>
						<%if("0".equals(lDTO.getUser_stat())){%>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">정상</a></li>
						<%}else if("1".equals(lDTO.getUser_stat())){%>	
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">정지</a></li>
						<%}else{%>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">탈퇴</a></li>
						<%} %>
						<li class="tfont tbottomline" style="width:18%;"><a href="managerment2.do?user_no=<%=lDTO.getUser_no()%>">상태</a></li>	
					</ul>
					
				
					<%}%>
				</div>
				
				<div class="pg_movebtn_box">

					<a href="managerment_1.do?pgNum=<%=pgNum-1%>" class="pg_movebtn">이전</a> 
					
					<a href="managerment_2.do?pgNum=<%=pgNum+1%>" class="pg_movebtn">다음</a>
								
				</div>
				
               
            </div>
 




         

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