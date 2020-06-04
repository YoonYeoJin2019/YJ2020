<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<script type="text/javascript">
    $(function() {
        $("#imgInp").on('change', function(){
            readURL(this);
        });
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();

var immg = document.getElementById('imgInp').value
var immg2 = immg.split("\\");

        reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
            $("#imgName").html(immg2[2]);

          reader.readAsDataURL(input.files[0]);
        }
    }
</script>

<script type="text/javascript">
    $(function() {
        $("#fileInp").on('change', function(){
            readURL2(this);
        });
    });

    function readURL2(input) {
        var reader = new FileReader();
        var ffile = document.getElementById('fileInp').value
        var ffile2 = ffile.split("\\");
        

        $("#fileName").html(ffile2[2]);

    }
</script>

<script type="text/javascript">
    $(function() {
        $("#fileInp2").on('change', function(){
            readURL3(this);
        });
    });

    function readURL3(input) {
        var reader = new FileReader();
        var ffile3 = document.getElementById('fileInp2').value
        var ffile4 = ffile3.split("\\");
        

        $("#fileName2").html(ffile4[2]);

    }
</script>


<script type='text/javaScript'>
    // textarea 줄바꿈 제한
    var str = $("#aaaa").val();

var str_arr = str.split("\n");  // 줄바꿈 기준으로 나눔 

var row = str_arr.length;  // row = 줄 수 

if(row >10){

//마지막 입력문자 삭제

alert("10줄 이상 입력할 수 없습니다.")

var lastChar = str.slice(0,-1); //열 

$("#aaaa").val(lastChar)
}
}
</script>


	</head>
	<body>
	<div id="fh5co-page">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary" class="border js-fullheight">

			<h1 id="fh5co-logo"><a href="index.html"><img src="/img/logo3.png" alt="Free HTML5 Bootstrap Website Template"></a></h1>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
					<li class="fh5co-active"><a href="index.html">HOME</a></li>
					<li><a href="login.html">LOGIN</a></li>
				</ul>
			</nav>



		</aside>

		<div id="fh5co-main">

			<div class="fh5co-narrow-content" style="border-bottom: 10px solid gainsboro;border-top:10px solid gainsboro;padding-top:20px;margin-top: 20px;padding-bottom: 20px;">
                <h2 class="fh5co-heading animate-box" data-animate-effect="fadeInLeft"> 운동등록2 </h2>

			<div class="fh5co-narrow-content" style="padding: 0;">
				<div class="row" style="margin-top: 0;">
					<div class="col-md-12 animate-box" data-animate-effect="fadeInLeft">
						<figure class="text-center" style="text-align: left;">
							<img id="blah" src="#" alt="이미지를 등록해주세요" class="img-responsive" style="max-width:80%; margin-left:auto;margin-right:auto;max-height:600px;"/>
						</figure>
					</div>
                    <div>
                        <span class="btn btn-default btn-file">
                            이미지 등록
                    <input type="file" id="imgInp" name="imgInp"/>
                        </span>
                </div>
                <div class="creaname" id="imgName"  name="imgName">
                  
                </div>

                
                <div class="creaname">
                운동 설명
                </div>
                <div style="width:100%;" class="creaname">
                <textarea class="index2textarea" rows="5" name="textarea" id="textarea"></textarea>
                </div>


					<div class="index2div2">
                        <input type="submit" class="index2submit" value="등록">
                        <input type="submit" class="index2submit" value="취소">
                    </div>

                    </div>
				</div>

                <div>

                </div>

            </div>
            

        </div>>


		
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