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
	async function fetch_flight(){//항공편현황관리 /api/flight
		const response = await fetch('/api/flight');
		const json = await response.json();
		if (json != null) {
			for (var value of json) {
					var str = "<tr id='sn"+value.flightSn+"'>"+
					"<td>"+value.flightSn+"</td>"+
					"<td>"+value.airlineName+"("+value.airlineId+")"+"</td>"+
					"<td>"+value.flight_typeSn+"</td>"+
					"<td>"+value.firstClass_counting+"</td>"+
					"<td>"+value.economy_counting+"</td>"+
					"<td>"+value.avail_seat+"</td>"+
					"<td>"+value.origin+"</td>"+
					"<td>"+value.destination+"</td>"+
					"<td>"+value.arr_time.substring(0,16)+" ~ "+value.dep_time.substring(11,16)+"</td>"+
					"<td><input type='button' value='선택' class='flightAdminBtn' id='flightAdminBtn"+value.flightSn+"' /></td></tr>";
					$("#flightAdminTable > tbody:last").append(str);
					let snNo=value.flightSn;
					$(`#flightAdminBtn${value.flightSn}`).on("click", function() {
						alert(`${snNo}항공편의 수정버튼 클릭`);
					});
			}
		}else alert("조회된 항공편이 없습니다!");
	};
	async function fetch_gate(){//게이트관리
		const response = await fetch('/api/flight');
		const json = await response.json();
		if (json != null) {
			for (var value of json) {
					var str = "<tr id='sn"+value.flightSn+"'>"+
					"<td>"+value.flightSn+"</td>"+
					"<td>"+value.airlineName+"("+value.airlineId+")"+"</td>"+
					"<td>"+value.flight_typeSn+"</td>"+
					"<td>"+value.arr_time.substring(0,16)+" ~ "+value.dep_time.substring(11,16)+"</td>"+
					"<td>"+value.gate+"</td>"+
					"<td><input type='button' value='선택' class='gateAdmin' id='gateAdmin"+value.flightSn+"' /></td></tr>";
					$("#gateAdminTable > tbody:last").append(str);
					let snNo=value.flightSn;
					$(`#gateAdmin${value.flightSn}`).on("click", function() {
						alert(`${snNo}항공편의 게이트 수정버튼 클릭`);
					});
			}
		}else alert("조회된 항공편이 없습니다!");
	};
	async function fetch_user(){//회원관리
		const response = await fetch('/api/users');
		const json = await response.json();
		if (json != null) {
			for (var value of json) {
					var str = "<tr id='sn"+value.sn+"'>"+
					"<td>"+value.sn+"</td>"+
					"<td>"+value.userId+"</td>"+
					"<td>"+value.userName+"</td>"+
					"<td>"+value.phone+"</td>"+
					"<td>"+value.address+"</td>"+
					"<td>"+value.birth+"</td>"+
					"<td>"+value.passportNo+"</td>"+
					"<td><input type='button' value='선택' class='userAdmin' id='userAdmin"+value.flightSn+"' /></td></tr>";
					$("#userAdminTable > tbody:last").append(str);
					let userId=value.userId;
					$(`#userAdmin${value.flightSn}`).on("click", function() {
						alert(`${userId}회원의 수정버튼 클릭`);
					});
			}
		}else alert("조회된 회원이 없습니다!");
	};
	$("#login-nav1").on("click", function() {//항공편현황관리
		$(".main_form").hide();
		$(".flightAdmin_form").show();
		$(".gateAdmin_form").hide();
		$(".userAdmin_form").hide();
		fetch_flight();
	});
	$("#login-nav2").on("click", function() {//게이트관리
		$(".main_form").hide();
		$(".flightAdmin_form").hide();
		$(".gateAdmin_form").show();
		$(".userAdmin_form").hide();
		fetch_gate();
	});
	$("#login-nav3").on("click", function() {//회원관리
		$(".main_form").hide();
		$(".flightAdmin_form").hide();
		$(".gateAdmin_form").hide();
		$(".userAdmin_form").show();
		fetch_user();
	});
	
});