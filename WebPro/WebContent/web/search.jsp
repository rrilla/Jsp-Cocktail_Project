<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

<style>
	.searchbar{
		position: fixed;
		width: 100%;
		height: 80px;
		bottom: 0px;
		left: 0px;
		z-index: 1000; 
		background: black;
		opacity: 1;
	}
	
    .searchbar .category{
	    float:left;
	    width: 33%;
	    opacity: 1;
	    color: white;
	    text-align: center;
    }
    .input-info {
	display: flex;
	justify-content: center;
	align-content: center;
}

.form-chek {
	display: inline-block;
	line-height: 20px;
	vertical-align: middle;
}

.form-chek::before{
	content: "";
	display: inline-block;
	width: 10px;
	height: 10px;
	background: #ffffff;
	border: 1px solid #e0e0e0;
	margin-right: 8px;
	color: white;
}

.input-chek{
	display: none;
}

.input-chek:checked+.form-chek::before{
	background: #749fbb;
}

.input-chek:checked+.form-chek{
	color: #749fbb;
}

input[type=range] {
	width: 100%;
	height: 8.4px;
	cursor: pointer;
	box-shadow: 1px 1px 1px #000000, 0px 0px 1px #0d0d0d;
	background: #000000;
	border-radius: 1.3px;
	border: 0.2px solid #010101;
}
</style>

     <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(../img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p>Search</p>
            <h2>List</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100">
        <div class="container">
            <div class="row">

                <!-- Single Event Area -->
                <c:forEach items="${list }" var="cocktail">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-event-area mb-30">
                        <div class="event-thumbnail">
                            <img src="../img/web-img/${cocktail.img_name }" alt="">
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

            </div>

            <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center mt-70">
                        <a href="#" class="btn oneMusic-btn">Load More <i class="fa fa-angle-double-right"></i></a>
                    </div>
                </div>
            </div>
        </div>

        
        
        <div class="searchbar">
        	<div class="category" >
        		<span id="abv0"> 무알콜 </span>
        		<span id="abv1"> 0~15 </span>
        		<span id="abv2"> 15~30 </span>
        		<span id="abv3"> 30 이상 </span>
        	</div>
        	<div class="category">
        		<span id="cWhite"> 화이트 </span>
        		<span id="cBlack"> 블랙 </span>
        		<span id="cRed"> 레드 </span>
        		<span id="cYellow"> 옐로우 </span>
        		<span id="cBlue"> 블루 </span>
        		<span id="cGreen"> 그린 </span>
        		<span id="cMix"> 믹스 </span>
        	</div>
        	<div class="category">
        		<input type="checkbox" class="input-chek" name="base" id="lum" value="lum"><label for="lum" class="form-chek">럼</label>
				<input type="checkbox" class="input-chek" name="base" id="vodka" value="vodka"><label for="vodka" class="form-chek">보드카</label>
        		<input type="checkbox" class="input-chek" name="base" id="jin" value="jin"><label for="jin" class="form-chek">진</label>
        	</div>
        	        	        	
        </div>
    </section>
   			
<script type="text/javascript">
var abv;
var color;
var taste;

//0도 무알콜 클릭시
	$("#abv0").on('click', function(){
		$.ajax({
			type:"post",
			url:"test.do",
			data:{"abv":"2"},
			success:function(data,textStatus){
				abv = 2;
				console.log(data);
				console.log(abv);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	});
	
	$("#cWhite").on('click', function(){
		$.ajax({
			type:"post",
			url:"test2.do",
			data:{"color":"1", "abv":abv},
			success:function(data,textStatus){
				var color = 1;
				console.log(data);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	});

</script>

<%@ include file="../include/footer.jsp" %>