<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header2.jsp" %>

<section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p>${session_nickname }`s</p>
            <h2>Page</h2>
        </div>
    </section>
<!-- ##### Latest Albums Area Start ##### -->
    <section class="events-area section-padding-100-0">
        <div class="container">

            <div class="row">
	            <div class="col-12">
    	        	<div class="text-center mb-70">
        	        	<h5>저장된 칵테일 리스트</h5><br>
            	    </div>
                </div>
                <div class="col-12">
                    <div class="browse-by-catagories catagory-menu d-flex flex-wrap align-items-center mb-70">
                        <a href="#" data-filter="*">Browse All</a>
                        <a href="#" data-filter=".A" class="active">A</a>
                        <a href="#" data-filter=".B">B</a>
                        <a href="#" data-filter=".C">C</a>
                        <a href="#" data-filter=".D">D</a>
                        <a href="#" data-filter=".E">E</a>
                        <a href="#" data-filter=".F">F</a>
                        <a href="#" data-filter=".G">G</a>
                        <a href="#" data-filter=".H">H</a>
                        <a href="#" data-filter=".I">I</a>
                        <a href="#" data-filter=".J">J</a>
                        <a href="#" data-filter=".K">K</a>
                        <a href="#" data-filter=".L">L</a>
                        <a href="#" data-filter=".M">M</a>
                        <a href="#" data-filter=".N">N</a>
                        <a href="#" data-filter=".O">O</a>
                        <a href="#" data-filter=".P">P</a>
                        <a href="#" data-filter=".Q">Q</a>
                        <a href="#" data-filter=".R">R</a>
                        <a href="#" data-filter=".S">S</a>
                        <a href="#" data-filter=".T">T</a>
                        <a href="#" data-filter=".U">U</a>
                        <a href="#" data-filter=".V">V</a>
                        <a href="#" data-filter=".W">W</a>
                        <a href="#" data-filter=".X">X</a>
                        <a href="#" data-filter=".Y">Y</a>
                        <a href="#" data-filter=".Z">Z</a>
                        <a href="#" data-filter=".number">0-9</a>
                    </div>
                </div>
            </div>
                <div class="row oneMusic-albums">

                <!-- Single Album -->
                <c:choose>
               <c:when test="${empty num}">
                  <p style="text-align: center;">
                     <b>저장된 리스트가 없습니다</b>
                  </p>
                  <br>
                  <div class="text-center">
                     <a data-animation="fadeInUp" data-delay="500ms"
                        href="p_tasteSearch.do" class="btn oneMusic-btn mt-50">취향으로
                        칵테일 찾기 <i class="fa fa-angle-double-right"></i>
                     </a><br />
                  </div>
               </c:when>
               <c:otherwise>
                <c:forEach items="${myList }" var="cocktail">
                	<div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item ${cocktail.f_letter }">
                    	<div class="single-album">
                    		<a href="detail.do?no=${cocktail.no }">
                        		<img src="img/cock-img/${cocktail.img_name }" alt="">
                        		<div class="album-info">
                                	<h5>${cocktail.name }</h5>
                            		<h6>(${cocktail.ename })</h6>
                            		<p>${cocktail.base }</p>
                        		</div>
                        	</a>
                    	</div>
                	</div>
                </c:forEach>
                </c:otherwise>
				</c:choose>
            </div>
        </div>
    </section>
    <!-- ##### Latest Albums Area End ##### -->

<%@ include file="../include/footer.jsp" %>