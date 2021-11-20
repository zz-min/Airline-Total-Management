const toggleBtn=document.querySelector('.navbar_toogleBtn');
const menu=document.querySelector('.navbar_menu');
const menuChild=menu.childNodes;
const icons=document.querySelector('.navbar_icons');
const faqTest=document.querySelector('#faqTest');
const mainContatiner=document.querySelector('#mainContatiner');

toggleBtn.addEventListener('click',()=>{
    menu.classList.toggle('active');
    icons.classList.toggle('active');
});
$(function() {
	
	
	function getCookie(cookie_name) {
		//document.cookie => userId=600548; userName=홍길동; login=true
		var x, y;
		var val = document.cookie.split(';');
		for (var item of val) {
			x = item.substr(0, item.indexOf('='));
			y = item.substr(item.indexOf('=') + 1);
			x = x.replace(/^\s+|\s+$/g, '');// 앞과 뒤의 공백 제거하기 
			if (x == cookie_name) { return unescape(y); }// unescape로 디코딩 후 값 리턴 
		}
	} 
	function delCookie(cookie_name) {
		let date = new Date();
		date.setDate(date.getDate() - 100);
		let Cookie = `${cookie_name}=;Expires=Thu, 01 Jan 1970 00:00:00 GMT`
		document.cookie = Cookie;
	}
	function delAllCookie() {
		var x, y;
		var val = document.cookie.split(';');
		for (var item of val) {
			x = item.substr(0, item.indexOf('='));
			y = item.substr(item.indexOf('=') + 1);
			x = x.replace(/^\s+|\s+$/g, '');// 앞과 뒤의 공백 제거하기 
			console.log(x);
			document.cookie = `${x}=;Expires=Thu, 01 Jan 1970 00:00:00 GMT`;
		}
	}

	$("#logoutBtn").on("click", function() {
		alert("로그아웃");
		$(".logoutSection").removeClass('active');
		$("#loginZone").children(":eq(1)").text('Login');
		delAllCookie();
		location.replace('/main');//뒤집어씌우기
	});
	$("#login-nav1").on("click", function() {//항공편조회
		$(".main_form").hide();
		$(".flight_form").show();
		$(".rsv_form").hide();
		$(".mypage_form").hide();
	});
	$("#login-nav2").on("click", function() {//예약조회
		$(".main_form").hide();
		$(".flight_form").hide();
		$(".rsv_form").show();
		$(".mypage_form").hide();
	});
	$("#login-nav3").on("click", function() {//마이페이지
		$(".main_form").hide();
		$(".flight_form").hide();
		$(".rsv_form").hide();
		$(".mypage_form").show();
	});
});