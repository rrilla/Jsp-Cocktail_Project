<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header2.jsp" %>

<section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p></p>
            <h2>My Page</h2>
        </div>
    </section>
<!-- ##### Latest Albums Area Start ##### -->
    <section class="latest-albums-area section-padding-100">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-9">
                    <div class="ablums-text text-center mb-70">
                        <h5>${id }님이</h5>
                    </div>
                </div>
            </div>
<!-- 취향 선택하는 섹션 -->

            <div class="row">
               <div class="col-12">
                  <div class="text-center mb-70">
                      <h6>저장한 칵테일 리스트</h6><br>
                   </div>
                </div>
                <div class="col-12">
            <c:choose>
               <c:when test="${num eq 0}">
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
               <c:when test="${num <= 5}">
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
               </c:when>
               <c:when test="${num > 5 }">
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
                  </div>
               </c:when>
            </c:choose>

         </div>
            </div>
        </div>
    </section>
    <!-- ##### Latest Albums Area End ##### -->

<%@ include file="../include/footer.jsp" %>