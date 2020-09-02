<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header2.jsp"%>

<style>
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
#msg,#msg2{
	color: red;
}
</style>
<section class="breadcumb-area bg-img bg-overlay"
	style="background-image: url(img/web-img/main-back4-2.jpg);">
	<div class="bradcumbContent">
		<p></p>
		<h2>JOIN</h2>
	</div>
</section>
<form name="join" onsubmit="return validate();" action="join.do" method="post">
	<section class="latest-albums-area section-padding-100">
		<div class="row">
			<div class="col-6">
				<!-- Contact Form Area -->
				<div class="contact-form-area">
					<div class="row mb-50">
						<div class="col-6"></div>
						<h5></h5>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-md-6">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="email" class="form-control" name="email" id="email" placeholder="아이디 (이메일 형식 : test@xxxx.com)">
							</div>
						</div>
					</div>
					<div class="row mb-30">
						<div class="col-5"></div>
						<div class="col-md-4" id="msg"></div>
						<div class="col-md-2">
							<button type="button" id="btnEmailSend" class="btn">인증번호 발송</button>
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-md-6">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="text" class="form-control" name="inputAuthNum" id="authNum"
									placeholder="인증번호">
							</div>
						</div>
					</div>
					<div class="row mb-30">
						<div class="col-7"></div>
						<div class="col-md-2" id="msg"></div>
						<div class="col-md-2">
							<button type="button" id="btnAuthNumCheck" class="btn">인증번호 확인</button>
						</div>
					</div>
					<div class="row mb-30">
						<div class="col-4"></div>
						<div class="col-md-6">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="NAME">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-md-6">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="text" class="form-control" name="nickname" id="nickname"
									placeholder="NickName">
							</div>
						</div>
					</div>
					<div class="row mb-30">
						<div class="col-5"></div>
						<div class="col-md-4" id="msg2"></div>
						<div class="col-md-2"></div>
					</div>
					<div class="row mb-30">
						<div class="col-4"></div>
						<div class="col-md-6">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="password" class="form-control" name="pw" id="pw"
									placeholder="Password">
							</div>
						</div>
					</div>
					<div class="row mb-30">
						<div class="col-4"></div>
						<div class="col-md-6" style="text-align: center;">
							<div class="form-group wow fadeInUp" data-wow-delay="100ms">
								<input type="password" class="form-control" id="checkpw"
									placeholder="Password-confirm">
							</div>
							<div class="col-md-8" id="msg2"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-6">
				<!-- Contact Form Area -->
				<div class="contact-form-area">
					<div class="row mb-50">
						<div class="col-4"></div>
						<h5></h5>
					</div>
					<div class="row">
						<div class="col-2"></div>
						<div class="col-md-6">
							<label>좋아하는 술</label>
							<hr>
							<input type="radio" class="input-chek" name="one_s" id="red" onclick="autoImg(1);" value="소주" /><label for="red" class="form-chek">소주</label> 
							<input type="radio" class="input-chek" name="one_s" id="clear" onclick="autoImg(2);" value="맥주" /><label for="clear" class="form-chek">맥주</label>
							<input type="radio" class="input-chek" name="one_s" id="pink" onclick="autoImg(3);" value="소맥" /><label for="pink" class="form-chek">소맥</label>
							<input type="radio" class="input-chek" name="one_s" id="green" onclick="autoImg(4);" value="막걸리" /><label for="green" class="form-chek">막걸리</label>
							<input type="radio" class="input-chek" name="one_s" id="blue" onclick="autoImg(5);" value="와인" /><label for="blue" class="form-chek">와인 </label>
							<input type="radio" class="input-chek" name="one_s" id="whiskey" onclick="autoImg(6);" value="위스키" /><label for="whiskey" class="form-chek">위스키</label>
							<input type="radio" class="input-chek" name="one_s" id="sake" onclick="autoImg(7);" value="사케" /><label for="sake" class="form-chek">사케</label>
						</div>
					</div>
							<input type="hidden" id="img_name" name="img_name" />
					<div class="row mt-30">
						<div class="col-2"></div>
						<div class="col-md-6">
							<label>지역</label>
							<hr>
							<select name="area1"
								onChange="cat1_change(this.value,area2)">
								<option selected>-선택-</option>
								<option value='1'>서울</option>
								<option value='2'>부산</option>
								<option value='3'>대구</option>
								<option value='4'>인천</option>
								<option value='5'>광주</option>
								<option value='6'>대전</option>
								<option value='7'>울산</option>
								<option value='8'>강원</option>
								<option value='9'>경기</option>
								<option value='10'>경남</option>
								<option value='11'>경북</option>
								<option value='12'>전남</option>
								<option value='13'>전북</option>
								<option value='14'>제주</option>									
								<option value='15'>충남</option>
								<option value='16'>충북</option>
							</select> <select name="area2">
								<option selected>-선택-</option>
								<option value='215'>군산시</option>
								<option value='216'>김제시</option>
								<option value='217'>남원시</option>
								<option value='218'>익산시</option>									<option value='219'>전주시 덕진구</option>
								<option value='220'>전주시 완산구</option>
								<option value='221'>정읍시</option>
								<option value='222'>고창군</option>
								<option value='223'>무주군</option>
								<option value='224'>부안군</option>
								<option value='225'>순창군</option>
								<option value='226'>완주군</option>
								<option value='227'>임실군</option>
								<option value='228'>장수군</option>
								<option value='229'>진안군</option>
							</select>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center;">
			<button class="btn oneMusic-btn mt-20" type="submit" id="btnJoin">
				JOIN<i class="fa fa-angle-double-right"></i>
			</button>
		</div>
	</section>
</form>

<script type="text/javascript">

var test = null;
var checkEmail;
var checkNum;
var checkNname;

//id(email)입력, 중복검사
	$('#email').focusout(function () {
		var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 이메일이 적합한지 검사할 정규식
		var email = document.getElementById("email");
		if(join.email.value==""){
			$("#msg").html("아이디를 입력해 주세요.");
			return false;
		}else if(!check2(re2, email, "적합하지 않은 이메일 형식입니다.")) {
	    	   checkEmail = 0;
	           return false;
	       }
		$.ajax({
			type:"post",
			url:"overappedId.do",
			data:{"id":$("#email").val()},
			dataType:"text",
			success:function(data,textStatus){
				if(data == '0'){
					$("#msg").html("사용 가능");
					checkEmail = 1;
				}
				else if(data == '1'){
					$("#msg").html("사용 불가능");
					checkEmail = 0;
				}
			}, error:function(data,textStatus){
				alert("서버 에러");
			}
		});
	});
	
//nickname 입력, 중복검사	
	$('#nickname').focusout(function () {
		var nickname = document.getElementById("nickname");
	       if(join.nickname.value=="") {
	    	   $("#msg2").html("닉네임을 입력해 주세요.");
				return false;
	       }
		$.ajax({
			type:"post",
			url:"overappedNname.do",
			data:{"nickname":$("#nickname").val()},
			dataType:"text",
			success:function(data,textStatus){
				if(data == '0'){
					$("#msg2").html("사용 가능");
					checkNname = 1;
				}
				else if(data == '1'){
					$("#msg2").html("사용 불가능");
					checkNname = 0;
				}
			}, error:function(data,textStatus){
				alert("서버 에러");
			}
		});
	});
	
//인증번호 발송,미입력 검사
	$("#btnEmailSend").on('click', function(){
		var check = $("#email").val();
		if(check == ""){
			alert("이메일을 입력하세요");
			$("#email").focus();
			return false;
		}
		if(checkEmail=='1'){
			$.ajax({
				type:"post",
				url:"authNumSend.do",
				data:{"email":$("#email").val()},
				success:function(data,textStatus){
					test = null;
					test = data;
					console.log(test);
					if(data == '0'){
						alert("서버 에러");
					}else{
						alert("인증번호 전송 완료.");
					}
				},error:function(data,textStatus){
					alert("인증번호 발송 에러.");
				}
			});
		}else{
			alert("이메일을 확인 해주세요.");
		}
	});
	
	$("#btnAuthNumCheck").on('click', function(){
		var inputAuthNum = $("#authNum").val();
		var authNum = test;
		if($("#authNum").val() == ""){
			alert("인증번호를 입력하세요.");
			return false;
		}else if(inputAuthNum != authNum){
			alert("인증 번호가 다릅니다.");
			$("#authNum").val("");
			return false;
		}else if(inputAuthNum == authNum){
			checkNum = 1;
			alert("이메일 인증 성공.");
		}
	});
	
	//member 좋아하는 술 선택시 img 자동 추가
	function autoImg(a) {
		switch(a){
		case 1: $('#img_name').val('soju.png');break;
		case 2: $('#img_name').val('beer.png');break;
		case 3: $('#img_name').val('soju_beer.png');break;
		case 4: $('#img_name').val('mak.png');break;
		case 5: $('#img_name').val('wine.png');break;
		case 6: $('#img_name').val('whiskey.png');break;
		case 7: $('#img_name').val('sake.png');break;
		default : $('#img_name').val('basic.png');
		}
	}
	
	//지역선택
	var cat1_num = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
			16);
	var cat1_name = new Array('서울', '부산', '대구', '인천', '광주', '대전', '울산', '강원',
			'경기', '경남', '경북', '전남', '전북', '제주', '충남', '충북');

	var cat2_num = new Array();
	var cat2_name = new Array();

	cat2_num[1] = new Array(17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
			30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41);
	cat2_name[1] = new Array('강남구', '강동구', '강북구', '강서구', '관악구', '광진구', '구로구',
			'금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구', '서초구', '성동구',
			'성북구', '송파구', '양천구', '영등포구', '용산구', '은평구', '종로구', '중구', '중랑구');

	cat2_num[2] = new Array(42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
			55, 56, 57);
	cat2_name[2] = new Array('강서구', '금정구', '남구', '동구', '동래구', '부산진구', '북구',
			'사상구', '사하구', '서구', '수영구', '연제구', '영도구', '중구', '해운대구', '기장군');

	cat2_num[3] = new Array(58, 59, 60, 61, 62, 63, 64, 65);
	cat2_name[3] = new Array('남구', '달서구', '동구', '북구', '서구', '수성구', '중구', '달성군');

	cat2_num[4] = new Array(66, 67, 68, 69, 70, 71, 72, 73, 74, 75);
	cat2_name[4] = new Array('계양구', '남구', '남동구', '동구', '부평구', '서구', '연수구',
			'중구', '강화군', '옹진군');

	cat2_num[5] = new Array(76, 77, 78, 79, 80);
	cat2_name[5] = new Array('광산구', '남구', '동구', '북구', '서구');

	cat2_num[6] = new Array(81, 82, 83, 84, 85);
	cat2_name[6] = new Array('대덕구', '동구', '서구', '유성구', '중구');

	cat2_num[7] = new Array(86, 87, 88, 89, 90);
	cat2_name[7] = new Array('남구', '동구', '북구', '중구', '울주군');

	cat2_num[8] = new Array(91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102,
			103, 104, 105, 106, 107, 108);
	cat2_name[8] = new Array('강릉시', '동해시', '삼척시', '속초시', '원주시', '춘천시', '태백시',
			'고성군', '양구군', '양양군', '영월군', '인제군', '정선군', '철원군', '평창군', '홍천군',
			'화천군', '횡성군');

	cat2_num[9] = new Array(109, 110, 111, 112, 113, 114, 115, 116, 117, 118,
			119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131,
			132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
			145, 146, 147, 148);
	cat2_name[9] = new Array('고양시 덕양구', '고양시 일산구', '과천시', '광명시', '광주시', '구리시',
			'군포시', '김포시', '남양주시', '동두천시', '부천시 소사구', '부천시 오정구', '부천시 원미구',
			'성남시 분당구', '성남시 수정구', '성남시 중원구', '수원시 권선구', '수원시 장안구', '수원시 팔달구',
			'시흥시', '안산시 단원구', '안산시 상록구', '안성시', '안양시 동안구', '안양시 만안구', '오산시',
			'용인시', '의왕시', '의정부시', '이천시', '파주시', '평택시', '하남시', '화성시', '가평군',
			'양주군', '양평군', '여주군', '연천군', '포천군');

	cat2_num[10] = new Array(149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
			159, 160, 161, 162, 163, 164, 165, 166, 167, 168);
	cat2_name[10] = new Array('거제시', '김해시', '마산시', '밀양시', '사천시', '양산시', '진주시',
			'진해시', '창원시', '통영시', '거창군', '고성군', '남해군', '산청군', '의령군', '창녕군',
			'하동군', '함안군', '함양군', '합천군');

	cat2_num[11] = new Array(169, 170, 171, 172, 173, 174, 175, 176, 177, 178,
			179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191,
			192);
	cat2_name[11] = new Array('경산시', '경주시', '구미시', '김천시', '문경시', '상주시', '안동시',
			'영주시', '영천시', '포항시 남구', '포항시 북구', '고령군', '군위군', '봉화군', '성주군',
			'영덕군', '영양군', '예천군', '울릉군', '울진군', '의성군', '청도군', '청송군', '칠곡군');

	cat2_num[12] = new Array(193, 194, 195, 196, 197, 198, 199, 200, 201, 202,
			203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214);
	cat2_name[12] = new Array('광양시', '나주시', '목포시', '순천시', '여수시', '강진군', '고흥군',
			'곡성군', '구례군', '담양군', '무안군', '보성군', '신안군', '영광군', '영암군', '완도군',
			'장성군', '장흥군', '진도군', '함평군', '해남군', '화순군');

	cat2_num[13] = new Array(215, 216, 217, 218, 219, 220, 221, 222, 223, 224,
			225, 226, 227, 228, 229);
	cat2_name[13] = new Array('군산시', '김제시', '남원시', '익산시', '전주시 덕진구', '전주시 완산구',
			'정읍시', '고창군', '무주군', '부안군', '순창군', '완주군', '임실군', '장수군', '진안군');

	cat2_num[14] = new Array(230, 231, 232, 233);
	cat2_name[14] = new Array('서귀포시', '제주시', '남제주군', '북제주군');

	cat2_num[15] = new Array(234, 235, 236, 237, 238, 239, 240, 241, 242, 243,
			244, 245, 246, 247, 248);
	cat2_name[15] = new Array('공주시', '논산시', '보령시', '서산시', '아산시', '천안시', '금산군',
			'당진군', '부여군', '서천군', '연기군', '예산군', '청양군', '태안군', '홍성군');

	cat2_num[16] = new Array(249, 250, 251, 252, 253, 254, 255, 256, 257, 258,
			259, 260);
	cat2_name[16] = new Array('제천시', '청주시 상당구', '청주시 흥덕구', '충주시', '괴산군', '단양군',
			'보은군', '영동군', '옥천군', '음성군', '진천군', '청원군');

	function cat1_change(key, sel) {
		if (key == '')
			return;
		var name = cat2_name[key];
		var val = cat2_num[key];

		for (i = sel.length - 1; i >= 0; i--)
			sel.options[i] = null;
		sel.options[0] = new Option('-선택-', '', '', 'true');
		for (i = 0; i < name.length; i++) {
			sel.options[i + 1] = new Option(name[i], val[i]);
		}
	}
	
	//회원가입 클릭시 유효성 검사
	   function validate() {
	       var id = document.getElementById("id");
	       var pw = document.getElementById("pw");
	       var email = document.getElementById("email");

	       
	       if(checkEmail != '1') {
	           alert("이메일을 확인 해주세요.");
	           email.focus();
	           return false;
	       }
	       if(checkNum != '1') {
	           alert("이메일 인증을 해주세요.");
	           email.focus();
	           return false;
	       }
	       if(join.name.value=="") {
	           alert("이름을 입력해 주세요.");
	           join.name.focus();
	           return false;
	       }
	       if(join.nickname.value=="") {
	           alert("닉네임을 입력해 주세요.");
	           join.nickname.focus();
	           return false;
	       }
	       if(checkNname != '1'){
	    	   alert("닉네임을 확인 해주세요.");
	           join.nickname.focus();
	           return false;
	       }
	       if(join.pw.value=="") {
	           alert("비밀번호를 입력해 주세요.");
	           join.pw.focus();
	           return false;
	       }
	       if(join.pw.value != join.checkpw.value) {
	           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
	           join.checkpw.value = "";
	           join.checkpw.focus();
	           return false;
	       }
	       if(join.one_s[0].checked==false &&
	           join.one_s[1].checked==false &&
	           join.one_s[2].checked==false &&
	           join.one_s[3].checked==false &&
	           join.one_s[4].checked==false &&
	           join.one_s[5].checked==false &&
	           join.one_s[6].checked==false) {
	           alert("좋아하는 술을 선택 해주세요.");
	           return false;
	       }
	       if(join.area2.value == "-선택-" ||
	    	   join.area1.value == "-선택-" ||
	    	   join.area2.value == null){
	    	   alert("지역을 선택 해주세요.");
	           return false;
	       }
	       alert("회원가입이 완료되었습니다.");
	   }

	   function check(re, what, message) {
	       if(re.test(what.value)) {
	           return true;
	       }
	       alert(message);
	       what.value = "";
	       what.focus();
	       return false;
	   }
	   
	   function check2(re, what, message) {
	       if(re.test(what.value)) {
	           return true;
	       }
	       $("#msg").html(message);
	       return false;
	   }
	   
//인증번호 확인
	/* $("#btnAuthNumCheck").on('click', function(){
		var check = $("#authNum").val();
		if(check == ""){
			alert("인증번호를 입력하세요");
			$("#authNum").focus();
			return false;
		}
		$.ajax({
			type:"post",
			url:"authNumCheck.do",
			data:{"authNum":$("#authNum").val()},
			success:function(data,textStatus){
				if(data == '1'){
					alert("이메일 인증 성공");
				}else{
					alert("인증 번호가 다릅니다.");
				}
			},error:function(data,textStatus){
				alert("시스템 에러.");
			}
		});
	}); */

	//비밀번호 검사
	/* $('#pw_ck').focusout(function () {
       var pwd1 = $("#pw").val();
       var pwd2 = $("#pw_ck").val();

       if ( pwd1 != '' && pwd2 == '' ) {
           null;
       } else if (pwd1 != "" || pwd2 != "") {
           if (pwd1 == pwd2) {
           	$("#msg2").html("비밀번호 일치");
           } else {
           	$("#msg2").html("비밀번호 불일치");
               alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
               $("#pw").val("");
               $("#pw_ck").val("");
           }
       }
   }); */
   
</script>

<%@ include file="../include/footer.jsp"%>
