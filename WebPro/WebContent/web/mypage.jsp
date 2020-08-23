<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header2.jsp" %>

<section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p>zz</p>
            <h2>My Page</h2>
        </div>
    </section>
<!-- ##### Latest Albums Area Start ##### -->
    <section class="latest-albums-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-9">
                    <div class="ablums-text text-center mb-70">
                        <p>체크박스를 넣을 것인가 개인 정보 수정 페이지를 만들 것인가</p>
                    </div>
                </div>
            </div>
<!-- 취향 선택하는 섹션 -->

            <div class="row">
	            <div class="col-12">
    	        	<div class="text-center mb-70">
        	        	<h5>저장된 칵테일 리스트</h5><br>
            	    </div>
                </div>
                <div class="col-12">
                    <div class="albums-slideshow owl-carousel">
                        <!-- Single Album -->
                        <c:forEach items="${myList }" var="myList">
                        	<a href="detail.do?no=${myList.no }">
                        		<div class="single-album">
                            		<img src="img/cock-img/${myList.img_name }" alt="">
                            		<div class="album-info">
                                    	<h5>${myList.name }</h5>
                                		<p>${myList.base }</p>
                            		</div>
                        		</div>
                        	</a>
                        </c:forEach>

                        <!-- Single Album -->
                        <div class="single-album">
                            <img src="img/bg-img/a6.jpg" alt="">
                            <div class="album-info">
                                <a href="#">
                                    <h5>The Ustopable</h5>
                                </a>
                                <p>Unplugged</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- ##### Latest Albums Area End ##### -->

<%@ include file="../include/footer.jsp" %>