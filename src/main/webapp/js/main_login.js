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
	var userInfoDialog,bookingDialog;
	userInfoDialog = $("#changeInfo-dialog-form").dialog({
		autoOpen: false,//페이지 로드시 다이얼로그가 자동으로 열리는 것 방지
		height: 550,
		width: 550,
		modal: true,//최상위에 다이알로그 표시
		resizable: false,//창크기 조절할 수 없도록 설정
		buttons: {
			"수정하기": function() {
				chageInfo();
			},
			"취소하기": function() {
				userInfoDialog.dialog("close");
			}
		}
	});
	bookingDialog = $("#booking-dialog-form").dialog({
		autoOpen: false,//페이지 로드시 다이얼로그가 자동으로 열리는 것 방지
		height: 400,
		width: 550,
		modal: true,//최상위에 다이알로그 표시
		resizable: false,//창크기 조절할 수 없도록 설정
		buttons: {
			"예약하기": function() {
				booking();
			},
			"취소하기": function() {
				bookingDialog.dialog("close");
			}
		}
	});
	function chageInfo() {//GET메소드
		var sn=$("#d_Sn").val();
		console.log(sn);
		var url = 'api/user/${sn})';
		/*
		fetch('/api/user/info', {// 유저 정보 POST요청보내기 - 유저정보수정
			method: "POST",
			headers: {
				"Content-Type": "application/json; charset=UTF-8"
			},
			body: JSON.stringify({
				checkedAirline: $('select[name=checkedAirline] option:selected').text(),
				checkedDate: $('#checkedDep_date').val(),
				checkedOrigin: $('select[name=checkedOrigin] option:selected').text(),
				checkedDest: $('select[name=checkedDest] option:selected').text()
			}),
			dataType: 'json'
		})
			.then(res => res.text())
			.then(res =>{ 
				if (res == 'true') {
					//document.location.href = "/main_login";
					alert("성공")
				} else {
					alert("실패")
				}
			})
			.then(alert("항공권 조회가 시작되었습니다d"))*/
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
					"<td>"+value.economy_fee+"</td>"+
					"<td><input type='button' value='선택' class='bookingBtn' id='bookingBtn"+value.flightSn+"' /></td></tr>";
					$("#flightListTable > tbody:last").append(str);
					let snNo=value.flightSn;
					$(`#bookingBtn${value.flightSn}`).on("click", function() {
						$(".flight_form").hide();
						$(".booking_form").show();
						flightChecked(`/api/flight/${snNo}`);
					});
			}
		}else alert("조회된 항공편이 없습니다!");
	}		
	async function flightChecked(url){
		const response = await fetch(url);
		const json = await response.json();
		if (json != null) {
			console.log(json.flightSn);
			var str='';
			$("#bookingTable1 td:eq(0)").html(json.flightSn);//항공편번호
			$("#bookingTable1 td:eq(1)").html(json.airlineName+"("+json.airlineId+")");//항공사
			$("#bookingTable1 td:eq(2)").html(json.arr_time.substring(0,10));//출발날짜
			$("#bookingTable1 td:eq(3)").html(json.origin);//출발지
			$("#bookingTable1 td:eq(4)").html(json.arr_time.substring(11,16));//출발시간
			$("#bookingTable1 td:eq(5)").html(json.destination);//도착지
			$("#bookingTable1 td:eq(6)").html(json.dep_time.substring(11,16));//도착시간
			
			$("#bookingTable2 td:eq(0)").html(json.firstClass_fee);//일등석 요금
			$("#bookingTable2 td:eq(2)").html(json.economy_fee);//일반석 요금
			$("#seatForm").empty();
			if(json.firstClass_counting!=0){
				var temp=1;
				str+=`<div class="fContainer">`;
				for(let i=0;i<(json.firstClass_counting/4);i++){//한줄에 4좌석
					str+=`<div class="seatBoxLine">
						<div class="seatBox1"><input type="checkbox" name="fCheckbox" value="${i + temp}"/><br>firstClass<br><span>${i + temp++}</span></div>
						<div class="seatBox1"><input type="checkbox" name="fCheckbox" value="${i + temp}"/><br>firstClass<br><span>${i + temp++}</span></div>
						<div class="seatBox0"></div>
						<div class="seatBox1"><input type="checkbox" name="fCheckbox" value="${i + temp}"/><br>firstClass<br><span>${i + temp++}</span></div>
						<div class="seatBox1"><input type="checkbox" name="fCheckbox" value="${i + temp}"/><br>firstClass<br><span>${i + temp}</span></div>
					</div>`;
				}
					str+=`</div>`;
			}
			if(json.economy_counting!=0){
				temp=1;
				str+=`<div class="eContainer">`;
				for(let i=0;i<(json.economy_counting/8);i++){//한줄에 8좌석
					str+=`<div class="seatBoxLine">
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox0"></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp++)}</span></div>
						<div class="seatBox1"><input type="checkbox" name="eCheckbox" value="${i + temp}"/><br><span>${i+(temp)}</span></div>
					</div>`;
				}
				str+=`</div>`;
			}
			$("#seatForm").append(str);
		}
	}
	$("#firstClass_count,#economy_count").change(function() {
		var total=$("#bookingTable2 td:eq(0)").text()*$("#firstClass_count").val()+
		$("#bookingTable2 td:eq(2)").text()*$("#economy_count").val();
		
		$("#bookingTable2 td:eq(4)").html(total);
	});

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
	$("#myInfoBtn").on("click", function() {
		userInfoDialog.dialog("open");
	});
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
	$("#notBookingBtn").on("click", function() {//예약페이지에서 돌아가기 버튼
		$(".flight_form").show();
		$(".booking_form").hide();
	});
	
	$("#bookingBtn").on("click", function() {//예약페이지에서 예약하기 버튼
		var select_obj_f='';
		var select_obj_e='';
		$("input:checkbox[name=fCheckbox]:checked").each(function(index){
			if (index != 0) {
            	select_obj_f += ',';
       		}
       		select_obj_f += $(this).val();
		});
		$("input:checkbox[name=eCheckbox]:checked").each(function(index){
			if (index != 0) {
           	 	select_obj_e += ', ';
       		}
       		select_obj_e += $(this).val();
		});
		booking(select_obj_f,select_obj_e);
		alert("예약완료");
		$(".rsv_form").show();//예약완료 후 예약 화면 띄워주기
		$(".booking_form").hide();
	});
	function booking(select_obj_f,select_obj_e,sn){
		fetch('/api/flightReq', {// 항공편 예약 POST요청보내기 
			method: "POST",
			headers: {
				"Content-Type": "application/json; charset=UTF-8"
			},
			body: JSON.stringify({
				flightSn: $("#bookingTable1 td:eq(0)").text(),
				select_obj_f: select_obj_f,
				select_obj_e: select_obj_e
			}),
			dataType: 'json'
		})
	}
});