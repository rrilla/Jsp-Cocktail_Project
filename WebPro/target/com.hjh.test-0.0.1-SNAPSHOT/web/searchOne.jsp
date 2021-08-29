<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp" %>

<style>
	.logo {
	    width: auto; height: auto;
	    max-width: 130px;
	    max-height: 130px;
	}

	.footer-area {
		position: fixed;
		width: 100%;
		bottom: 0;
	}
	
</style>
	<!-- 도수는 표준레시피 기준으로 계산,맛은 다포함되더라도 가장 강한맛을 기준으로 분류,,맛은 주관적이라 참고용으로만  -->
     <!-- ##### Breadcumb Area Start ##### -->
    <section class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/web-img/back3.jpg);">
        <div class="bradcumbContent">
            <p>Taste Search</p>
            <h2>Pages</h2>
        </div>
    </section>
    <!-- ##### Breadcumb Area End ##### -->

    <!-- ##### Events Area Start ##### -->
    <section class="events-area section-padding-100-0" id="test">
        <div class="container">
            
                <div class="col-12">
                <h2>취향 선택</h2><br />
                    <div class="oneMusic-tabs-content">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link" id="tab--1" data-toggle="tab" href="#tab1" role="tab" aria-controls="tab1" aria-selected="false">도수</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="tab--2" data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2" aria-selected="false">색</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" id="tab--3" data-toggle="tab" href="#tab3" role="tab" aria-controls="tab3" aria-selected="true">맛</a>
                            </li>
                        </ul>

                        <div class="tab-content mb-100" id="myTabContent">
                            <div class="tab-pane fade" id="tab1" role="tabpanel" aria-labelledby="tab--1">
                                <div class="oneMusic-tab-content">
                                    <!-- Tab Text -->
                                    <div class="oneMusic-tab-text">
                                    <p>
                                        <input type="radio" name="abv" onclick="abvCE(9);" checked="checked">선택안함&nbsp&nbsp
						        		<input type="radio" name="abv" onclick="abvCE(0);" >무알콜&nbsp&nbsp
						        		<input type="radio" name="abv" onclick="abvCE(1);" >0~15&nbsp&nbsp
						        		<input type="radio" name="abv" onclick="abvCE(2);" >15~30&nbsp&nbsp
						        		<input type="radio" name="abv" onclick="abvCE(3);" >30도이상&nbsp&nbsp
						        	</p> 
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="tab2" role="tabpanel" aria-labelledby="tab--2">
                                <div class="oneMusic-tab-content">
                                    <!-- Tab Text -->
                                    <div class="oneMusic-tab-text">
                                    <p>
                                        <input type="radio" name="color" onclick="colorCE(9);" checked="checked">선택안함&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(0);" >흰색&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(1);" >검정, 검붉은&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(2);" >빨강&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(3);" >노랑&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(4);" >파랑&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(5);" >초록&nbsp&nbsp
						        		<input type="radio" name="color" onclick="colorCE(6);" >혼합&nbsp&nbsp
						        	</p> 
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade show active" id="tab3" role="tabpanel" aria-labelledby="tab--3">
                                <div class="oneMusic-tab-content">
                                    <!-- Tab Text -->
                                    <div class="oneMusic-tab-text">
                                    <p>
                                        <input type="radio" name="taste" onclick="tasteCE(9);" checked="checked">선택안함&nbsp&nbsp
						        		<input type="radio" name="taste" onclick="tasteCE(0);" >단맛&nbsp&nbsp
						        		<input type="radio" name="taste" onclick="tasteCE(1);" >신맛,상큼&nbsp&nbsp
						        		<input type="radio" name="taste" onclick="tasteCE(2);" >도수높고 드라이,쓴맛&nbsp&nbsp
						        		<input type="radio" name="taste" onclick="tasteCE(4);" >탄산o&nbsp&nbsp
						        		<input type="radio" name="taste" onclick="tasteCE(3);" >기타&nbsp&nbsp
						        	</p>	
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h2>검색 결과</h2><br />
                <div class="row oneMusic-albums" id=searchList>

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
		str += '<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />';
		$("#searchList").html(str);
	};

</script>

<%@ include file="../include/footer.jsp" %>