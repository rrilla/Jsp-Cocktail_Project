<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

<style>

	.footer-area{
		bottom: 0px;
		position:fixed;
		width: 100%;
	}
	
	.searchbar{
		margin-left:auto;
		margin-right:auto;
		position: fixed;
		width: 80%;
		height: 80px;
		bottom: 10%;
		left: 0px;
		z-index: 1000; 
		background: red;
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
	<!-- 도수는 표준레시피 기준으로 계산,맛은 다포함되더라도 가장 강한맛을 기준으로 분류,,맛은 주관적이라 참고용으로만  -->
     <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(../img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p>Search</p>
            <h2>List</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100-0">
        <div class="container">
            <div class="row oneMusic-albums" id=searchList>
            
            
				<%-- <c:forEach items="${list }" var="cocktail">
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
                </c:forEach> --%>
                

            </div>

            <!-- <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center mt-70">
                        <a href="#" class="btn oneMusic-btn">Load More <i class="fa fa-angle-double-right"></i></a>
                    </div>
                </div>
            </div> -->
        </div>

        
        
        <div class="searchbar">
        	<div class="category" >
        		<input type="radio" name="abv" onclick="abvCE(9);" >선택해제
        		<input type="radio" name="abv" onclick="abvCE(0);" >무알콜 
        		<input type="radio" name="abv" onclick="abvCE(1);" >0~15 
        		<input type="radio" name="abv" onclick="abvCE(2);" >15~30 
        		<input type="radio" name="abv" onclick="abvCE(3);" >30도이상 
        	</div>
        	<div class="category">
        	<form >
        		<input type="radio" name="color" onclick="colorCE(9);" >선택해제
        		<input type="radio" name="color" onclick="colorCE(0);" >흰색
        		<input type="radio" name="color" onclick="colorCE(1);" >검정,검붉은
        		<input type="radio" name="color" onclick="colorCE(2);" >빨강
        		<input type="radio" name="color" onclick="colorCE(3);" >노랑
        		<input type="radio" name="color" onclick="colorCE(4);" >파랑
        		<input type="radio" name="color" onclick="colorCE(5);" >초록 
        		<input type="radio" name="color" onclick="colorCE(6);" >혼합 
        	</form>
        	</div>
        	<div class="category">
        	<form >
        		<input type="radio" name="taste" onclick="tasteCE(9);" >선택해제
        		<input type="radio" name="taste" onclick="tasteCE(0);" >스위트(단맛)
        		<input type="radio" name="taste" onclick="tasteCE(1);" >사워(신맛,상큼)
        		<input type="radio" name="taste" onclick="tasteCE(2);" >드라이(도수높고 드라이,쓴맛)
        		<input type="radio" name="taste" onclick="tasteCE(4);" >탄산
        		<input type="radio" name="taste" onclick="tasteCE(3);" >기타
        	</form>
        	</div>
        	        	        	
        </div>
    </section>
   			
<script type="text/javascript">

var abv=9;
var color=9;
var taste=9;

	$(document).ready(function(){
		$.ajax({
			type:"post",
			url:"searchTaste.do",
			data:{"abv":abv, "color":color, "taste":taste},
			success:function(data,textStatus){
				getList(data);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	});

	function abvCE(a) {
		$.ajax({
			type:"post",
			url:"searchTaste.do",
			data:{"abv":a, "color":color, "taste":taste},
			success:function(data,textStatus){
				abv = a;
				getList(data);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	}
	
	function colorCE(a) {
		$.ajax({
			type:"post",
			url:"searchTaste.do",
			data:{"abv":abv, "color":a, "taste":taste},
			success:function(data,textStatus){
				color = a;
				getList(data);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	}
	
	function tasteCE(a) {
		$.ajax({
			type:"post",
			url:"searchTaste.do",
			data:{"abv":abv, "color":color, "taste":a},
			success:function(data,textStatus){
				taste = a;
				getList(data);
			}, error:function(data,textStatus){
				alert("error");
			}, complete:function(data,textStatus){}
		});
	}
	
	function getList(list) {
		var str = '';
		
		for(let cocktail of list){
			str += '<div class="col-12 col-sm-4 col-md-3 col-lg-2 single-album-item ' + cocktail.f_letter + '">';
			str += '<div class="single-album">';
			str += '<a href="detail.do?no=' + cocktail.no + '">';
			str += '<img src="img/cock-img/' + cocktail.img_name + '" alt="">';
			str += '<div class="album-info">'
			str += '<h5>' + cocktail.name + '</h5>';
			str += '<h6>(' + cocktail.ename + ')</h6>'
			str += '<p>' + cocktail.base + '</p>'
			str += '</div>'
			str += '</a>'
			str += '</div>'
			str += '</div>'
		}
		$("#searchList").html(str);
	};

</script>

<%@ include file="../include/footer.jsp" %>