//
//
//$("user_id").blur(function(){
//
//	var idck = $("#idCheck").val();
//    var user_id =  $("#user_id").val(); 
//    $.ajax({
//        type : 'POST',
//        data : {'user_id':user_id},
//        url : '${pageContext.request.contextPath}/idCheck.do',
//        success : function(data) {
//        	console.log(data);
//        	console.log("success");
//        	console.log("count");
//            if (data ==  '0') {
//                $("#cc_id1").show();
//                $("#cc_id2").hide();
//                $("#idCheck").val('1');
//            } else {
//                $("#cc_id2").show();
//                $("#cc_id1").hide();
//                $("#idCheck").val('1');
//            }
//        },
//        error : function(error) {
//            
//            alert("error : " + error);
//        }
//    });
//});
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//	//아이디 체크여부 확인 (아이디 중복일 경우 = 1 , 중복이 아닐경우 = 0 )
//var idck = "0";
//    $(function() {
//        //idck 버튼을 클릭했을 때 
//        $("user_id").blur(function() {
//            
////        	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/); 	//이메일 정규표현식
////        	var getCheck= RegExp(/^[a-z0-9]{5,20}$/); 									//아이디 정규표현식
////        	var getPassword= RegExp(/^[a-zA-Z0-9!@#$]{6,20}$/); 						//비밀번호 정규표현식
////        	var getName= RegExp(/^[가-힣]{2,20}$/);										//이름 정규표현식	
////        	var getTel= RegExp(/^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/);										//전화번호 정규표현식	
////        	var fmt = RegExp(/^\d{6}[1234]\d{6}$/); 									//형식 설정 
////
////        	
////        	//아이디 입력여부 검사
////        	if($("input[name=user_id]").val()==""){
////        		alert("아이디를 입력해 주세요.");
////        		$("input[name=user_id]").focus();
////        		return false;
////        	}
////        	//아이디 유효성 검사 
////        	else if(!getCheck.test($("input[name=user_id]").val())){ 
////        		alert("아이디를 5자리 이상 20자리 이하 대문자 및 한글이 아닌것으로 입력해주세요")
////        		$("input[name=user_id]").val("");
////        		$("input[name=user_id]").focus();
////        		return false; 
////        	}
//        	
//        	
//            //userid 를 parameter로.
//        	var idck = $("#idCheck").val();
//            var user_id =  $("#user_id").val(); 
//            $.ajax({
//                type : 'POST',
//                data : {'user_id':user_id},
//                url : "/idCheck.do",
//                success : function(data) {
//                	console.log(data);
//                	console.log("success");
//                	console.log("count");
//                    if (data ==  '0') {
//                    	alert('사용 가능한 아이디입니다.');
//                        //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인 
//                        $("#user_password").focus();
//                        //아이디가 중복하지 않으면  idck = 1 
//                        $("#idCheck").val('1');
//                    } else {
//                    	alert('아이디가 존재합니다. 다른 아이디를 입력해주세요.');
//    	                //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
//    	                $('#user_id').focus();
//                    }
//                },
//                error : function(error) {
//                    
//                    alert("error : " + error);
//                }
//            });
//        });
//    });
//    
//    /*===============================================================
//     * 아이디 중복검사를 위한 구문
//     *===============================================================
//     */	
//    	//아이디 체크여부 확인 (아이디 중복일 경우 = 1 , 중복이 아닐경우 = 0 )
//     
//    
//var nickck = "0";
//        $(function() {
//            //idck 버튼을 클릭했을 때 
//            $("#nickck").click(function() {
//            	
//            	
//                
//            	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/); 	//이메일 정규표현식
//            	var getCheck= RegExp(/^[a-z0-9]{5,20}$/); 									//아이디 정규표현식
//            	var getPassword= RegExp(/^[a-zA-Z0-9!@#$]{6,20}$/); 						//비밀번호 정규표현식
//            	var getName= RegExp(/^[가-힣]{2,20}$/);										//이름 정규표현식	
//            	var getTel= RegExp(/^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/);										//전화번호 정규표현식	
//            	var fmt = RegExp(/^\d{6}[1234]\d{6}$/); 									//형식 설정 
//
//            	
//            	//닉네임 입력여부 검사
//            	if($("input[name=user_nick]").val()==""){
//            		alert("닉네임을 입력해 주세요.");
//            		$("input[name=user_nick]").focus();
//            		return false;
//            	}
//                
//                //userid 를 parameter로.
//            	var nickck = $("#nickCheck").val();
//                var user_nick=  $("#user_nick").val(); 
//                $.ajax({
//                    type : 'POST',
//                    data : {'user_nick':user_nick},
//                    url : "/nickCheck.do",
//                    success : function(data) {
//                    	console.log(data);
//                    	console.log("success");
//                    	console.log("count");
//                        if (data ==  '0') {
//                        	alert('사용 가능한 닉네임입니다.');
//                            //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인 
//                            $("#user_email").focus();
//                            //아이디가 중복하지 않으면  idck = 1 
//                            $("#nickCheck").val('1');
//                        } else {
//                        	alert('닉네임이 존재합니다. 다른 닉네임를 입력해주세요.');
//        	                //아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
//        	                $('#user_nick').focus();
//                        }
//                    },
//                    error : function(error) {
//                        
//                        alert("error : " + error);
//                    }
//                });
//            });
//        });   
//        
///*===============================================================
// * 첫번째 유효성 검사를 위한 구문(alert로 나옴)
// *==============================================================*/
// 	    
//function check(){
////	
//	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/); 	//이메일 정규표현식
//	var getCheck= RegExp(/^[a-z0-9]{5,20}$/); 									//아이디 정규표현식
//	var getPassword= RegExp(/^[a-zA-Z0-9!@#$]{6,20}$/); 						//비밀번호 정규표현식
//	var getName= RegExp(/^[가-힣]{2,20}$/);										//이름 정규표현식	
//	var getTel= RegExp(/^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/);										//전화번호 정규표현식	
//	var fmt = RegExp(/^\d{6}[1234]\d{6}$/); 									//형식 설정 

//	
//	//이름 입력여부 검사
//	if($("input[name=user_name]").val()==""){
//		alert("이름을 입력해 주세요.");
//		$("input[name=user_name]").focus();
//		return false;
//	}
//	//닉네임 입력여부 검사
//	if($("input[name=user_nick]").val()==""){
//		alert("닉네임을 입력해 주세요.");
//		$("input[name=user_nick]").focus();
//		return false;
//	}
//	//이름 유효성 검사 
//	else if(!getName.test($("input[name=user_name]").val())){ 
//		alert("이름 형식에 맞게 입력해주세요")
//		$("input[name=user_name]").val("");
//		$("input[name=user_name]").focus();
//		return false; 
//	}
//	//아이디 입력여부 검사
//	else if($("input[name=user_id]").val()==""){
//		alert("아이디를 입력해 주세요.");
//		$("input[name=user_id]").focus();
//		return false;
//	}
//	//아이디 유효성 검사 
//	else if(!getCheck.test($("input[name=user_id]").val())){ 
//		alert("아이디를 5자리 이상 20자리 이하 대문자 및 한글이 아닌것으로 입력해주세요")
//		$("input[name=user_id]").val("");
//		$("input[name=user_id]").focus();
//		return false; 
//	}
//	//비밀번호 입력여부 검사
//	else if($("input[name=user_password]").val()==""){
//		alert("비밀번호를 입력해 주세요.")
//		$("input[name=user_password]").focus();
//		return false;
//	}
//	//아이디, 비밀번호 일치 확인
//	else if($("input[name=user_name]").val() === $("input[name=user_password]").val()){ 
//		alert("아이디와 비밀번호가 일치합니다")
//		$("input[name=user_password]").val("");
//		$("input[name=user_password]").focus();
//		return false; 
//		}
//
//	//비밀번호 유효성검사 
//	else if(!getPassword.test($("input[name=user_password]").val())){
//		alert("비밀번호를 6자리 이상 20자리 이하로 입력해주세요"); 
//		$("input[name=user_password]").val("");
//		$("input[name=user_password]").focus();
//		return false;
//		}
//
//	//비밀번호 확인 입력여부 검사
//	else if($("input[name=user_password2]").val()==""){
//		alert("비밀번호확인을 입력해 주세요.")
//		$("input[name=user_password2]").focus();
//		return false;
//	}
//	
//	//비밀번호 일치여부 검사
//	else if($("input[name=user_password]").val()!=$("input[name=user_password2]").val()){
//		alert("비밀번호가 일치하지 않습니다.")
//		$("input[name=user_password2]").val("");
//		$("input[name=user_password2]").focus();
//		return false;
//	}
//	
//	//생년월일 입력여부 검사
//	else if($("input[name=user_date]").val()==""){
//		alert("생년월일을 입력해 주세요.")
//		$("input[name=user_date]").focus();
//		return false;
//	}
//	
//
//	//이메일 입력여부 검사
//	else if($("input[name=user_email]").val()==""){
//		alert("이메일을 입력해 주세요.")
//		$("input[name=user_email]").focus();
//		return false;
//	}
//	
//    // 회원가입 버튼
//    var idck = $("#idCheck").val();
//    var nickck = $("#nickCheck").val();   
//    if(confirm("회원가입을 하시겠습니까?")){
//        if(idck=='0'){
//            alert('아이디 중복체크를 해주세요');
//            return false;
//        }
//        if(nickck=='0'){
//        	alert('닉네임 중복체크를 해주세요');
//        	return false;
//        }
//    }
//}
