<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

     <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p>리스트</p>
            <h2>'${cName }' 검색 결과</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100">
        <div class="container">
            <div class="row">

                <!-- Single Event Area -->
                <c:forEach items="${nameResult }" var="cocktail">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-event-area mb-30">
                        <div class="event-thumbnail">
                            <img src="img/cock-img/${cocktail.img_name }" alt="">
                        </div>
                        <div class="event-text">
                            <h4>${cocktail.name }</h4>
                            <div class="event-meta-data">
                                <a href="#" class="event-place">${cocktail.base }</a>
                                <a href="#" class="event-date">${cocktail.alike }</a>
                            </div>
                            <a href="#" class="btn see-more-btn">상세보기</a>
                        </div>
                    </div>
                </div>
                </c:forEach>

                <!-- <!-- Single Event Area 
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-event-area mb-30">
                        <div class="event-thumbnail">
                            <img src="img/web-img/cock2.jpg" alt="">
                        </div>
                        <div class="event-text">
                            <h4>The Mission</h4>
                            <div class="event-meta-data">
                                <a href="#" class="event-place">Gold Arena</a>
                                <a href="#" class="event-date">June 15, 2018</a>
                            </div>
                            <a href="#" class="btn see-more-btn">See Event</a>
                        </div>
                    </div>
                </div> -->

            </div>

            <!-- <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center mt-70">
                        <a href="#" class="btn oneMusic-btn">Load More <i class="fa fa-angle-double-right"></i></a>
                    </div>
                </div>
            </div> -->
        </div>
    </section>
    <!-- ##### Events Area End ##### -->

<%@ include file="../include/footer.jsp" %>