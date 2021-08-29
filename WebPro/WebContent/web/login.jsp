<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header2.jsp" %>
    <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/main-back4-2.jpg);">
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
                            <form name="login" action="login.do" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">I D</label>
                                    <input type="text" id="id" name="id" class="form-control" aria-describedby="emailHelp" placeholder="ID(이메일 형식 : test@xxxx.com)">
                                    <small id="emailHelp" class="form-text text-muted"><i class="fa fa-lock mr-2"></i>We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input type="password" id="pw" name="pw" class="form-control" placeholder="Password">
                                </div>
                                <button type=button id="btnLogin" class="btn oneMusic-btn mt-30">Login</button>
                                <a href="p_join.do"><button type="button" class="btn oneMusic-btn mt-30">Register</button></a>
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
    	if(validate()){
			$.ajax({
				type:"post",
				url:"login.do",
				async:false,
				data:{"id":$("#id").val(), "pw":$("#pw").val()},
				dataType:"text",
				success:function(data,textStatus){
					if(data==1){
						alert("로그인 되었습니다.");
						location.href=document.referrer;
					}else if(data==0){
						alert("password를 확인해주세요.")
					}else{
						alert("id를 확인해주세요.")
					}
				},error:function(data,textStatus){
					alert("서버 에러.")
				}
			});
    	}
	});
	
    function validate() {
		if(login.id.value=="") {
			alert("아이디를 입력해 주세요.");
			login.id.focus();
			return false;
		}
		if(login.pw.value=="") {
			alert("비밀번호를 입력해 주세요.");
			login.pw.focus();
			return false;
		}
		return true;
    }
    
</script>
    
<%@ include file="../include/footer.jsp" %>