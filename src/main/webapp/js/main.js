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
	$("#logoutSection").css('display','none');
	var userLoginDialog;
	var userLoginField = $([]).add("#id").add("#pwd");
	
	userLoginDialog = $("#user-login-dialog-form").dialog({
		autoOpen: false,//페이지 로드시 다이얼로그가 자동으로 열리는 것 방지
		height: 250,
		width: 450,
		modal: true,//최상위에 다이알로그 표시
		resizable: false,//창크기 조절할 수 없도록 설정
		buttons: {
			"확인": function() {
				userLoginCheckLength();
			},
			"취소": function() {
				userLoginDialog.dialog("close");
			}
		},
		close: function() {
			userLoginField.removeClass("ui-state-error");//에러 없애기
		}
	});
	
	function userLoginCheckLength() {//로그인 요청시 들어오는 함수
		userLoginField.removeClass("ui-state-error"); //에러 없애기
		if (userLoginField.val().length > 15 || userLoginField.val().length < 5) {
			//false - ID,PWD 재요청
			userLoginField.addClass("ui-state-error");
			alert("아이디와 비밀번호를 다시 확인해 주세요.");
		} else {
			//true - 로그인 유효성 검사
			const userId = btoa($("#id").val());//base64 인코딩
			const userPwd = btoa($("#pwd").val());
			var url = `/api/login/user?id=${userId}&pwd=${userPwd}`;// 로그인 요청보내기
			loginFetch(url, userId, userPwd);
		}
	}
	
	function loginFetch(url, id, pwd) {//GET메소드
		fetch(url)
			.then(res => res.text())
			.then(res => {
				if (res == 'true') {
					document.location.href="/main_login";
				} else{
					userLoginField.addClass("ui-state-error");
					alert("아이디와 비밀번호를 다시 확인해 주세요.");
				}  
			});
	}
	
	$("#loginZone").on("click", function() {
		userLoginDialog.dialog("open");
	});
	
	$("#joinSubmitBtn").on("click", function() {
		fetch('/api/users', {// 회원가입 요청보내기
			method: "POST",
			headers: {
				"Content-Type": "application/json; charset=UTF-8"
			},
			body: JSON.stringify({
				userName: $('#userName').val(),
				userId: $('#userId').val(),
				userPwd: $('#userPwd').val(),
				phone: $('#userPhone').val(),
				address: $('#userAddr').val(),
				birth: $('#userBirth').val(),
				passportNo: $('#userpass').val()
			}),
			dataType: 'json'
		})
			.then(alert("회원가입이 되었습니다"))
			.then(location.reload())
			.catch(error => console.log(error))
	});
	
	$("#main-nav1").on("click", function() {
		$(".main_form").hide();
		$(".flight_form").show();
		$(".join_form").hide();
	});
	$("#main-nav2").on("click", function() {
		$(".main_form").hide();
		$(".flight_form").hide();
		$(".join_form").show();
	});
	
});