<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>One Music - Modern Music HTML5 Template</title>

    <!-- Favicon -->
    <link rel="icon" href="../img/core-img/favicon.ico">
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="style.css">


<style>
	.searchBar {
	  margin-top: 4px;
	  position: relative;
	  z-index: 1;
	  display: inline-block;
	  min-width: 212px;
	  height: 35px;
	  color: #000;
	  border: 1px solid #000;
	  border-radius: 0;
	  padding: 0 30px;
	  font-size: 15px;
	  line-height: 47px;
	  font-weight: 700;
	  text-transform: capitalize; 
	}
	.oneMusic-btn.btn-2 {
    	background-color: #000000;
    	color: #ffffff; 
    }
    .oneMusic-btn.btn-2:hover{
      background-color: #ffffff;
      color: #000000; 
    }
</style>
<script src="../js/jquery/jquery-3.5.1.min.js"></script>
<script src="js/jquery/jquery-3.5.1.min.js"></script>
</head>

<body>
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="lds-ellipsis">
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    <header class="header-area">
        <!-- Navbar Area -->
        <div class="oneMusic-main-menu">
            <div class="classy-nav-container breakpoint-off" style="background: #000000;">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="oneMusicNav">

                        <!-- Nav brand -->
                        <a href="main.jsp" class="nav-brand"><img src="../img/web-img/logoM.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Nav Start -->
                            <div class="classynav">
                            	<form action="../search.do" method="post">
	                                <ul>
	                                    <li><input type="text" id="cockName" class="searchBar" name="cName" value="옥보단"><!-- placeholder는 임의의 값 보일 수 있게 함 --></li>
	                                    <li><a href="#" id="searchBtn" class="btn oneMusic-btn btn-2 m-2" style="margin-top:5px;">Send <i class="fa fa-angle-double-right"></i></a></li>
	                                    <!-- <li><input type="submit" class="btn oneMusic-btn btn-2 m-2" style="margin-top:5px;">Send <i class="fa fa-angle-double-right"></i></a></li> -->
	                               </ul>
	                            </form>   

                                <!-- Login/Register & Cart Button -->
                                <div class="login-register-cart-button d-flex align-items-center">
                                    <!-- Login/Register -->
                                    <div class="login-register-btn mr-50">
                                    	<c:choose>
                                    		<c:when test="${empty session_id }">
                                        		<a href="../web/login.jsp" id="loginBtn">Login / Register</a>
                                        	</c:when>
                                        	<c:otherwise>
                                        		<a href="#" id="logoutBtn">Logout[${session_id }]</a>
                                        	</c:otherwise>	
                                        </c:choose>	
                                    </div>

                                    <!-- Cart Button -->
                                    <div class="cart-btn">
                                    <c:choose>
                                    	<c:when test="${not empty session_id }">
                                        	<a href="../web/mypage.jsp" ><p><span class="icon-shopping-cart"></span> <span class="quantity">1</span></p></a>
                                        </c:when>
                                        </c:choose>	
                                    </div>
                                </div>
                            </div>
                            <!-- Nav End -->

                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    
<script type="text/javascript">
	 
	$("#searchBtn").on('click',function(){
		var cName = {"cName":$("#cockName").val()};
			$.ajax({
				type:"post",
				url:"../search.do",
				async : false,
				data : cName,
				dataType : "text",
				success :function(data,textStatus){
					location.href="list.jsp";
				},error:function(data,textStatus){
					alert("error")
				},complete:function(data,textStatus){}
			});
		});
		
	//로그아웃
	$("#logoutBtn").on('click', function (event) {
    	event.stopPropagation(); // 부모요소에 동일한 클릭이벤트 전파를 막기
    	
    	$.ajax({
    		type:"get",
    		url:"../logout.do",
    		async:false,
    		dataType:"text",
    		success:function(data,textStatus){
    			if(data=="success"){
    				alert("success");
    				location.href="main.jsp";
    			} 
    		},error:function(data,textStatus){
    			alert("error")
    		},complete:function(data,textStatus){}
    	});
    });
</script>