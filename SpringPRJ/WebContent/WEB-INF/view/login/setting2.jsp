<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String user_nickname = (String) session.getAttribute("user_nickname");
String user_auth = (String) session.getAttribute("user_auth");
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
	
	<script>

var getPassword= RegExp(/^[a-zA-Z0-9!@#$]{8,20}$/); 						//비밀번호 정규표현식

function checkpass(){
	var orgpass = $("#orgpass").val();
	var orgpassCheck = $("#orgpassCheck").val();
    $.ajax({
        type : 'POST',
        data : {'orgpass':orgpass},
        url : '/passCheck.do',
        success : function(data) {
        	console.log(data);
        	console.log("success");
        	console.log("count");
        	
        	if (data == 1) {
        		$("#orgpassCheck").val('1');
                $("#cc_pp1").hide();
        	}else{
        		$("#orgpassCheck").val('0');
        		$("#cc_pp1").show();
        	}    	
        },
        error : function(error) {
            
            alert("error : " + error);
        }
    });
}


function checkPwd2(){

	var newpass = $("input[name=newpass]").val();
	var newpass2 = $("input[name=newpass2]").val();
	var orgpass = $("input[name=orgpass]").val();
	
	if($("input[name=newpass]").val()==""){
		$("#cc_pp2").show();
        $("#cc_pp3").hide();
        $("#cc_pp4").hide();
        $("#cc_pp5").hide();
        $("#newpassCheck").val('0');
	}else if($("input[name=newpass]").val()==$("input[name=orgpass]").val()){
		$("#cc_pp2").hide();
        $("#cc_pp3").show();
        $("#cc_pp4").hide();
        $("#cc_pp5").hide();
        $("#newpassCheck").val('0');
	}else if(!getPassword.test($("input[name=newpass]").val())){
		$("#cc_pp2").hide();
        $("#cc_pp3").hide();
        $("#cc_pp4").hide();
        $("#cc_pp5").show();
        $("#newpassCheck").val('0');			
	}else{
		$("#cc_pp2").hide();
        $("#cc_pp3").hide();
        $("#cc_pp4").hide();
        $("#cc_pp5").hide();
        $("#newpassCheck").val('1');
        
	}
}
	
	function checkPwd3(){

		var newpass = $("input[name=newpass]").val();
		var newpass2 = $("input[name=newpass2]").val();
		var orgpass = $("input[name=orgpass]").val();
		
		if($("input[name=newpass]").val()==""){
			$("#cc_pp2").show();
	        $("#cc_pp3").hide();
	        $("#cc_pp4").hide();
	        $("#cc_pp5").hide();
	        $("#newpassCheck").val('0');
		}else if($("input[name=newpass]").val()==$("input[name=orgpass]").val()){
			$("#cc_pp2").hide();
	        $("#cc_pp3").show();
	        $("#cc_pp4").hide();
	        $("#cc_pp5").hide();
	        $("#newpassCheck").val('0');
		}else if(!getPassword.test($("input[name=newpass]").val())){
			$("#cc_pp2").hide();
	        $("#cc_pp3").hide();
	        $("#cc_pp4").hide();
	        $("#cc_pp5").show();
	        $("#newpassCheck").val('0');			
		}else if($("input[name=newpass]").val()!=$("input[name=newpass2]").val()){
			$("#cc_pp2").hide();
	        $("#cc_pp3").hide();
	        $("#cc_pp4").show();
	        $("#cc_pp5").hide();
	        $("#newpassCheck").val('0');
		}else{
			$("#cc_pp2").hide();
	        $("#cc_pp3").hide();
	        $("#cc_pp4").hide();
	        $("#cc_pp5").hide();
	        $("#newpassCheck").val('1');
	        
		}
	
	}

function setting2(){
	
	var orgpassCheck = $("input[name=orgpassCheck]").val();
	var newpassCheck = $("input[name=newpassCheck]").val();
	
	if(orgpassCheck==='0'){
		alert("입력을 확인해주세요")
		$("input[name=orgpassCheck]").focus();		
		return false;
	}else if(newpassCheck==='0'){
		alert("입력을 확인해주세요")
		$("input[name=newpassCheck]").focus();		
		return false;
	}else{	
		return true;
	}
	return false;
}

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
                <h2 class="fh5co-heading"> 나의 정보 </h2>
                
			
				<div class="loginwindow">

                <form method="post" action="/setting2_sh.do">
                    <div class="setting1">현재 비밀번호</div>
                    <div style="float:left; color:red; display:none;" id="cc_pp1">비밀번호가 일치하지 않습니다.</div>
                    <div class="signup1"><input type="password" class="signinput1" name="orgpass" id="orgpass" oninput="checkpass()" required maxlength="20"></div>
                    <div class="setting1">새 비밀번호</div>
                    <div style="float:left; color:red; display:none;" id="cc_pp2">8자리 이상 입력해주시기 바랍니다.</div>
                    <div style="float:left; color:red; display:none;" id="cc_pp3">기존 비밀번호와 일치합니다.</div>
                    <div style="float:left; color:red; display:none;" id="cc_pp5">비밀번호 형식에 맞지 않습니다.</div>
                    <div class="signup1"><input type="password" class="signinput1" name="newpass" id="newpass" oninput="checkPwd2()" required maxlength="20"></div>
                    <div class="setting1">새 비밀번호 확인</div>
                    <div style="float:left; color:red; display:none;" id="cc_pp4">새 비밀번호와 일치하지 않습니다.</div>
                    <div class="signup1"><input type="password" class="signinput1" name="newpass2" id="newpass2" oninput="checkPwd3()" required maxlength="20"></div>
                    
				  <input type="hidden" name="orgpassCheck" id="orgpassCheck" value ="0">
                  <input type="hidden" name="newpassCheck" id="newpassCheck" value ="0">
                  
                    <div class="signup2">
                        <input type="button" class="signupsubmit2" value="취소" onclick="location.href='/setting.do'">
                        <input type="submit" class="signupsubmit" value="확인" onclick="return setting2()">
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
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

	</body>
</html>