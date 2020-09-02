<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

<style>
.footer-area{
	position: fixed;
	bottom: 0px;
}




#modal {
  display:none;

  position:relative;
  width:100%;
  height:100%;
  z-index:1;
}

#modal h2 {
  margin:0;   
}

#modal button {
  display:inline-block;
  width:100px;
  margin-left:calc(100% - 100px - 10px);
}

#modal .modal_content {
  width:300px;
  margin:100px auto;
  padding:20px 10px;
  background:#fff;
  border:2px solid #666;
}

#modal .modal_layer {
  position:fixed;
  top:0;
  left:0;
  width:100%;
  height:100%;
  background:rgba(0, 0, 0, 0.5);
  z-index:-1;
}   



</style>
	<!-- 도수는 표준레시피 기준으로 계산,맛은 다포함되더라도 가장 강한맛을 기준으로 분류,,맛은 주관적이라 참고용으로만  -->
     <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(../img/web-img/main-back4-2.jpg);">
        <div class="bradcumbContent">
            <p id="login_a">Taste Search</p>
            <h2>List</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100-0">
        <div class="container">
            <div class="row oneMusic-albums" id=searchList>
                

            </div>

            <div class="row">
                <div class="col-12">
                    <div class="load-more-btn text-center mt-70">
                        <a href="#" id="modal_opne_btn" class="btn oneMusic-btn">Load More <i class="fa fa-angle-double-right"></i></a>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- <div class="searchbar">
        	<div class="category" >
        		<input type="radio" name="abv" onclick="abvCE(9);" >선택해제
        		<input type="radio" name="abv" onclick="abvCE(0);" >무알콜 
        		<input type="radio" name="abv" onclick="abvCE(1);" >0~15 
        		<input type="radio" name="abv" onclick="abvCE(2);" >15~30 
        		<input type="radio" name="abv" onclick="abvCE(3);" >30도이상 
        	</div>
        	<div class="category">
        		<input type="radio" name="color" onclick="colorCE(9);" >선택해제
        		<input type="radio" name="color" onclick="colorCE(0);" >흰색
        		<input type="radio" name="color" onclick="colorCE(1);" >검정,검붉은
        		<input type="radio" name="color" onclick="colorCE(2);" >빨강
        		<input type="radio" name="color" onclick="colorCE(3);" >노랑
        		<input type="radio" name="color" onclick="colorCE(4);" >파랑
        		<input type="radio" name="color" onclick="colorCE(5);" >초록 
        		<input type="radio" name="color" onclick="colorCE(6);" >혼합 
        	</div>
        	<div class="category">
        		<input type="radio" name="taste" onclick="tasteCE(9);" >선택해제
        		<input type="radio" name="taste" onclick="tasteCE(0);" >스위트(단맛)
        		<input type="radio" name="taste" onclick="tasteCE(1);" >사워(신맛,상큼)
        		<input type="radio" name="taste" onclick="tasteCE(2);" >드라이(도수높고 드라이,쓴맛)
        		<input type="radio" name="taste" onclick="tasteCE(4);" >탄산
        		<input type="radio" name="taste" onclick="tasteCE(3);" >기타
        	</div>
        	        	        	
        </div> -->
    </section>
    
    
    <div id="modal">
    	<div class="modal_content">
        	<h2>모달 창</h2>
        	<p>모달 창 입니다.</p>
        	<button type="button" id="modal_close_btn">모달 창 닫기</button>
    	</div>
    	<div class="modal_layer"></div>
	</div>
    
    
   			
<script type="text/javascript">

document.getElementById("modal_opne_btn").onclick = function() {
    document.getElementById("modal").style.display="block";
}

document.getElementById("modal_close_btn").onclick = function() {
    document.getElementById("modal").style.display="none";
}   










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