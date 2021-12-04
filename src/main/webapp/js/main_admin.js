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
	async function fetch_flight(){
		
	};
	async function fetch_gate(){
		
	};
	async function fetch_user(){
		
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
	
}