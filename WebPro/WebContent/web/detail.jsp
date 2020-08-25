<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

<style>
	.cock_title{
		position: relative;
	    border-top: 2px solid #000;
	    border-bottom: 1px solid rgb(230, 230, 230);
    }
    .title_banner{
    
    }
    .text_area{
    	width: 80%;
    	float: left;
	    padding: 0px 100px 0px 0;
		border-right: 2px solid rgb(228, 228, 228);
    }
	.name{
		text-align: center;
		font-size: 40px;
	    line-height: 26px;
	    letter-spacing: 10px;
	    font-weight: 600;
	    padding: 15px 100px 50px 0;
    }
    .single-widget-area {
		position: relative;
		z-index: 1;
		background-color: #fff;
		border: 0px solid #d8d8d8; 
	}
	.single-widget-area .widget-title {
	    padding: 10px 10px;
	    border: 0px;
	}
    .single-widget-area .widget-content {
 		padding: 0px 10px; 
 	}	
</style>

<!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/bg-1.jpg)">
        <div class="bradcumbContent">
            <p>상세보기</p>
            <h2>${cock.name }</h2>
            <input type="hidden" id="addMyCockNo" value="${cock.no }"/>
            <input type="hidden" id="commId" value="${session_id }"/>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->
    
    <!-- ##### Blog Area Start ##### -->
    <div class="blog-area section-padding-100">
	<div class="container">
		<div class="row">
			<div class="col-12 col-lg-5">

				<!-- Single Post Start -->
				<div class="single-blog-post mb-100 wow fadeInUp"
					data-wow-delay="100ms">
					<!-- Post Thumb -->
					<div class="blog-post-thumb mt-30">
						<a href="#"><img src="img/web-img/orgasm.jpg" alt="" style=" width: 100%; height: 100%;"></a>
						<!-- Post Date -->
					</div>

				</div>
			</div>
			<div class="col-12 col-lg-7">

				<!-- Single Post Start -->
				<div class="single-blog-post mb-100 wow fadeInUp"
					data-wow-delay="100ms">
					<!-- Post Thumb -->
					<div class="blog-post-thumb mt-30">
						<div class="cock_title">
							<div class="text_area">
								<div class="name">${cock.name }</div>
								<c:choose>
									<c:when test="${empty session_id }">
										<div class="icon" id="loginGo" >
                                    		<span class="icon-favorites"></span>
                                		</div>
                                	</c:when>
                                	<c:otherwise>
                                		<div class="icon" id="addMyCocktail" >
                                    		<span class="icon-favorites"></span>
                                		</div>
                                	</c:otherwise>
                                </c:choose>
							</div>
							<div >
								
							</div>

							<!-- <div class="post-date">	
	                                <div id="addMyCocktail">mycock추가</div>
	                            </div> -->
							<div class="mt-70"></div>
							<div class="mt-40" style="padding: 0px 140px 20px 10px;">
								||||||간단한 칵테일 설명|||||| ${cock.tmi }</div>
						</div>

						<div class="single-widget-area">
							<div class="widget-title" style="color: #808080">
								<b>맛</b>
							</div>
							<div class="widget-content">
								<ul class="tags">
									<li><a>달달</a></li>
									<c:forEach items="${relevant }" var="cockList">
										<li><a href="detail.do?no=${cockList.no }">${cockList.name }</a>
										</li>
										<!-- <li><a href="#">performers</a></li> -->
									</c:forEach>
								</ul>
							</div>
						</div>
						
						<div class="single-widget-area">
							<div class="widget-title" style="color: #808080">
								<b>연관 칵테일</b>
							</div>
							<div class="widget-content">
								<ul class="tags">
									<li><a>지우면 되는 것</a></li>
									<c:forEach items="${relevant }" var="cockList">
										<li><a href="detail.do?no=${cockList.no }">${cockList.name }</a>
										</li>
										<!-- <li><a href="#">performers</a></li> -->
									</c:forEach>
								</ul>
							</div>
						</div>


					</div>

				</div>
			</div>
		</div>

	<div class="single-blog-post mb-100 wow fadeInUp" data-wow-delay="100ms">
		<div class="blog-content">
			<a href="#" class="post-title">집에서 간단하게 만들기</a>
			<div class="post-meta d-flex mb-30">
				<p class="tags">
					<a href="#">럼</a>
				</p>
				<p class="tags">
					<a href="#">럼2</a>
				</p>
			</div>
			<p>술을 준비하고 섞습니다. !!!!테이블에서 술 레시피 가지고 오는 곳!!!!</p>
			<br> <br>


			<div class="oneMusic-tabs-content" >
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link" id="tab--1"
						data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1"
						aria-selected="true">유래</a></li>
					<li class="nav-item"><a class="nav-link" id="tab--2"
						data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
						aria-selected="false">페어링하기 좋은 음식</a></li>
					<li class="nav-item"><a class="nav-link active" id="tab--3"
						data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3"
						aria-selected="false">후기</a></li>
				</ul>

				<div class="tab-content mb-100" id="myTabContent">
					<div class="tab-pane fade" id="tab1" role="tabpanel"
						aria-labelledby="tab--1">
						<div class="oneMusic-tab-content">
							<!-- Tab Text -->
							<div class="oneMusic-tab-text">
								<p>Nㅎ롱ㄱe ex vel magna tincidunt, ut porta nisl finibus.
									Vivamus eu dolor eu quam varius rutrum. Fusce nec justo id sem
									aliquam fringilla nec non lacus. Suspendisse eget lobortis
									nisi, ac cursus odio. Vivamus nibh velit, rutrum at ipsum ac,
									dignissim iaculis ante.</p>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="tab2" role="tabpanel"
						aria-labelledby="tab--2">
						<div class="oneMusic-tab-content">
							<!-- Tab Text -->
							<div class="oneMusic-tab-text">
								<p>ㅁㄴㅇㄻㅈㄷㄺㅁx vel magna tincidunt, ut porta nisl finibus.
									Vivamus eu dolor eu quam varius rutrum. Fusce nec justo id sem
									aliquam fringilla nec non lacus. Suspendisse eget lobortis
									nisi, ac cursus odio. Vivamus nibh velit, rutrum at ipsum ac,
									dignissim iaculis ante.</p>
							</div>
						</div>
					</div>
					<div class="tab-pane fade show active" id="tab3" role="tabpanel"
						aria-labelledby="tab--3">
						<div class="oneMusic-tab-content">
							<!-- Tab Text -->
							<div class="oneMusic-tab-text">
										<!-- ========== reply Boxes ========== -->
								
								<br>
								<br>
								<div class="col-12">
									<div class="row">
						
										<!-- Single Service Area -->
										<c:forEach items="${listComm }" var="comm">
											<div class="col-12 col-md-6">
												<div class="single-service-area d-flex flex-wrap mb-100">
													<div class="icon">
														<span class="icon-favorites"></span>
													</div>
													<div class="text">
														<h5>${comm.id }</h5>
														<p>${comm.content }</p>
													</div>
												</div>
											</div>
										</c:forEach>
										<div id="commArea" class="col-12 col-md-6"></div>
									</div>
								</div>
								
								
								<!-- ========== reply Boxes ========== -->
						
								<div class="newsletter-area mb-100">
									<div class="section-heading text-left mb-50">
										<img src="img/member-img/bascMember.jpg" alt="" />
										<h2 >${session_id }</h2>
									</div>
									<div class="newsletter-form">
										<c:choose>
											<c:when test="${not empty session_id }">
												<input type="text" name="content" id="content"
												placeholder="댓글 입력">
											</c:when>
											<c:otherwise>
												<input type="text" name="content" id="loginGo2"
												placeholder="로그인 후 댓글 작성 가능">
											</c:otherwise>	
										</c:choose>			
											<button id="addComm" class="btn oneMusic-btn">
												댓글 쓰기 <i class="fa fa-angle-double-right"></i>
											</button>
									</div>
								</div>
						
								<!-- Pagination -->
								<div class="oneMusic-pagination-area wow fadeInUp"
									data-wow-delay="300ms">
									<nav>
										<ul class="pagination">
											<li class="page-item active"><a class="page-link" href="#">01</a></li>
											<li class="page-item"><a class="page-link" href="#">02</a></li>
											<li class="page-item"><a class="page-link" href="#">03</a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>



	
	</div>

</div>

                   
    <!-- ##### Blog Area End ##### -->

<script type="text/javascript">
	
	//칵테일 즐겨찾기 추가
	$("#addMyCocktail").on('click', function(){
		$.ajax({
			type:"post",
			url:"addmycock.do",
			data:{"no":$("#addMyCockNo").val()},
			success:function(data,textStatus){
				if(data == '0'){
					alert("추가 완료");
				}
				else if(data == '1'){
					alert("삭제 완료");
				}else if(data == '-1'){
					alert("로그인 후 가능합니다.");
				}
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	});
	
	
	$("#loginGo").on('click',function(){
		var check = confirm('로그인시 가능한 서비스 입니다. 로그인 하시겠습니까?');
        if(check){
        	location.href="p_login.do";
        }else{
			return;        
        }
	});
	
	$("#loginGo2").on('click',function(){
		var check = confirm('로그인시 가능한 서비스 입니다. 로그인 하시겠습니까?');
        if(check){
        	location.href="p_login.do";
        }else{
			return;        
        }
	});

	//댓글작성 클릭시 데이터 입력
	$("#addComm").on('click',function(){
		var check = $("#content").val();
		if(check == ""){
			alert("댓글 내용을 입력하세요");
			$("#content").focus();
			return ;
		}
		$.ajax({
			type:"post",
			url:"addComm.do",
			data:{"id":$("#commId").val(), "no":$("#addMyCockNo").val(), "content":$("#content").val()},
			success:function(data,textStatus){
				if(data != null){
					getList(data);
					alert("댓글 작성 완료");
				}else{
					alert("댓글 작성 실패");
				}
			},error:function(data,textStatus){
				alert("error");
			}
		});
	});

	//댓글 작성 완료시 댓글목록 갱신 함수
	function getList(list) {
	var str = '';
	
		for(let comm of list){
			str += '<div class="col-12 col-md-6">';
			str += '<div class="single-service-area d-flex flex-wrap mb-100">';
			str += '<div class="icon">';
			str += '<span class="icon-favorites"></span></div>';
			str += '<div class="text">';
			str += '<h5>'+ comm.id + '</h5>';
			str += '<p>' + comm.content + '<p>';
			str += '</div></div></div>';
		}
	$("#commArea").html(str);
	};
	
</script>

<%@ include file="../include/footer.jsp" %>
