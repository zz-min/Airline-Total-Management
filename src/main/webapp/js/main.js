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

$(window).load(function() {
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
	$(".datepicker").datepicker({
           dateFormat: 'yy-mm-dd' //달력 날짜 형태
           ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
           ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
           ,changeYear: true //option값 년 선택 가능
           ,changeMonth: true //option값  월 선택 가능                
           ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
           ,buttonImage: "img/calendar.png" //버튼 이미지 경로
           ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
           ,buttonText: "선택" //버튼 호버 텍스트              
           ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
           ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
           ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
           ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
           ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
           ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
           ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)  
       });                    
       
    //초기값을 오늘 날짜로 설정해줘야 합니다.
    $('.datepicker').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후.
	$("#serchFlightBtn_").on("click",function(){
		var a1=$('select[name=checkedAirline_] option:selected').text().replace(/^\s+|\s+$/g, '');
		var a2=$('#checkedDep_date_').val();
		var a3=$('select[name=checkedOrigin_] option:selected').text().replace(/^\s+|\s+$/g, '');
		var a4=$('select[name=checkedDest_] option:selected').text().replace(/^\s+|\s+$/g, '');
		console.log("//"+a1+"//"+a2+"//"+a3+"//"+a4);
		//x = x.replace(/^\s+|\s+$/g, '');// 앞과 뒤의 공백 제거하기 
		if($('select[name=checkedAirline_] option:selected').val()==='none'){
			var url=`/api/flight/list?				
				checkedDate= ${a2}&
				checkedOrigin= ${encodeURI(encodeURIComponent(a3))}&
				checkedDest= ${encodeURI(encodeURIComponent(a4))}`;
		}else{
			var url=`/api/flight/list?
				checkedAirline=${encodeURI(encodeURIComponent(a1))} &
				checkedDate= ${a2}&
				checkedOrigin= ${encodeURI(encodeURIComponent(a3))}&
				checkedDest= ${encodeURI(encodeURIComponent(a4))}`;
		}
		fetchData(url);
	});
	async function fetchData(url){
		const response = await fetch(url);
		const json = await response.json();
		if (json != null) {
			for (var value of json) {
					var str = "<tr id='sn"+value.flightSn+"'>"+
					"<td>"+value.flightSn+"</td>"+
					"<td>"+value.airlineName+"("+value.airlineId+")"+"</td>"+
					"<td>"+value.origin+"</td>"+
					"<td>"+value.arr_time.substring(11,16)+"</td>"+
					"<td>"+value.destination+"</td>"+
					"<td>"+value.dep_time.substring(11,16)+"</td>"+
					"<td>"+value.firstClass_fee+"</td>"+
					"<td>"+value.economy_fee+"</td></tr>";
					//console.log(str);
					$("#flightListTable > tbody:last").append(str);
				}
		}else alert("조회된 항공편이 없습니다!");
	}
	$("#serchFlightBtn").on("click", function(){ //메인화면에서 button클릭시
		$(".main_form").hide();
		$(".join_form").hide();
		$(".flight_form").show();
		$("#checkedAirline_").val($("#checkedAirline").val()).prop("selected",true);
		$("#checkedDep_date_").val($("#checkedDep_date").val())
		$("#checkedOrigin_").val($("#checkedOrigin").val()).prop("selected",true);
		$("#checkedDest_").val($("#checkedDest").val()).prop("selected",true);
		$("#serchFlightBtn_").click();
	})
	
	$("#main-nav1").on("click", function() {//항공편조회 선택
		$(".main_form").hide();
		$(".join_form").hide();
		$(".flight_form").show();
	});
	$("#main-nav2").on("click", function() {//회원가입 선택
		$(".main_form").hide();
		$(".flight_form").hide();
		$(".join_form").show();
	});
	$("#loginZone").on("click", function() { //로그인버튼 클릭
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
			.then(location.replace("/main"))
			.catch(error => console.log(error))
	});
	
});