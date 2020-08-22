<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header2.jsp" %>
    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(../img/bg-img/breadcumb3.jpg);">
        <div class="bradcumbContent">
            <p>See what’s new</p>
            <h2>Login / Register</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Login Area Start ##### -->
    <section class="login-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="login-content">
                        <h3>Welcome Back</h3>
                        <!-- Login Form -->
                        <div class="login-form">
                            <form action="#" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">I D</label>
                                    <input type="text" id="id" class="form-control" aria-describedby="emailHelp" placeholder="Enter ID">
                                    <small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" id="pw" class="form-control" placeholder="Password">
                                </div>
                                <button type=button id="btnLogin" class="btn oneMusic-btn mt-30">Login</button>
                                <a href="../web/join.jsp"><button type="button" class="btn oneMusic-btn mt-30">Register</button></a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Login Area End ##### -->
    
<script type="text/javascript">    

//로그인
    $("#btnLogin").on('click',function(){
	var query={"id":$("#id").val(), "pw":$("#pw").val()};
		$.ajax({
			type:"post",
			url:"../login.do",
			async:false,
			data:query,
			dataType:"text",
			success:function(data,textStatus){
				if(data==1){
					alert("success");
					location.href="mypage.jsp";
				}else if(data==0){
					alert("password error")
				}else{
					alert("id error")
				}
			},error:function(data,textStatus){
				alert("error")
			},complete:function(data,textStatus){}
		});
	});
    
</script>
    
<%@ include file="../include/footer.jsp" %>