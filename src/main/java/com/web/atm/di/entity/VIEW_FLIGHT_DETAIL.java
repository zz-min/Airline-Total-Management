package com.web.atm.di.entity;

public class VIEW_FLIGHT_DETAIL {
	private int flightSn; // flight 테이블 시퀀스
	
	private int airlineSn; // Airline 테이블 시퀀스
	private String airlineId; // 항공사 아이디
	private String airlineName; // 항공사 이름
	
	private int flight_typeSn; // flight_type 테이블 시퀀스
	private int firstClass_counting; // 일등석 좌석 수
	private int economy_counting; // 이코노미 좌석 수
	
	private int avail_seat;//유효좌석수(일등석좌석수 + 이코노미좌석수 - 예약한 좌석수)
	private String dep_time;//출발시간
	private String arr_time;//도착시간
	private String origin;//출발지
	private String destination;//도착지
	private int gate;// 게이트 번호
	private int firstClass_fee;//일등석좌석 가격
	private int economy_fee;//이코노미좌석 가격
	
	public VIEW_FLIGHT_DETAIL(){
		
	}
	
	public VIEW_FLIGHT_DETAIL(int flightSn, int airlineSn, String airlineId, String airlineName, int flight_typeSn,
			int firstClass_counting, int economy_counting, int avail_seat, String dep_time, String arr_time,
			String destination, String origin, int gate, int firstClass_fee, int economy_fee) {
		super();
		this.flightSn = flightSn;
		this.airlineSn = airlineSn;
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.flight_typeSn = flight_typeSn;
		this.firstClass_counting = firstClass_counting;
		this.economy_counting = economy_counting;
		this.avail_seat = avail_seat;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.destination = destination;
		this.origin = origin;
		this.gate = gate;
		this.firstClass_fee = firstClass_fee;
		this.economy_fee = economy_fee;
	}

	public int getFlightSn() {
		return flightSn;
	}

	public void setFlightSn(int flightSn) {
		this.flightSn = flightSn;
	}

	public int getAirlineSn() {
		return airlineSn;
	}

	public void setAirlineSn(int airlineSn) {
		this.airlineSn = airlineSn;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public int getFlight_typeSn() {
		return flight_typeSn;
	}

	public void setFlight_typeSn(int flight_typeSn) {
		this.flight_typeSn = flight_typeSn;
	}

	public int getFirstClass_counting() {
		return firstClass_counting;
	}

	public void setFirstClass_counting(int firstClass_counting) {
		this.firstClass_counting = firstClass_counting;
	}

	public int getEconomy_counting() {
		return economy_counting;
	}

	public void setEconomy_counting(int economy_counting) {
		this.economy_counting = economy_counting;
	}

	public int getAvail_seat() {
		return avail_seat;
	}

	public void setAvail_seat(int avail_seat) {
		this.avail_seat = avail_seat;
	}

	public String getDep_time() {
		return dep_time;
	}

	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}

	public String getArr_time() {
		return arr_time;
	}

	public void setArr_time(String arr_time) {
		this.arr_time = arr_time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getGate() {
		return gate;
	}

	public void setGate(int gate) {
		this.gate = gate;
	}

	public int getFirstClass_fee() {
		return firstClass_fee;
	}

	public void setFirstClass_fee(int firstClass_fee) {
		this.firstClass_fee = firstClass_fee;
	}

	public int getEconomy_fee() {
		return economy_fee;
	}

	public void setEconomy_fee(int economy_fee) {
		this.economy_fee = economy_fee;
	}

	@Override
	public String toString() {
		return "VIEW_FLIGHT_DETAIL [flightSn=" + flightSn + ", airlineSn=" + airlineSn + ", airlineId=" + airlineId
				+ ", airlineName=" + airlineName + ", flight_typeSn=" + flight_typeSn + ", firstClass_counting="
				+ firstClass_counting + ", economy_counting=" + economy_counting + ", avail_seat=" + avail_seat
				+ ", dep_time=" + dep_time + ", arr_time=" + arr_time + ", destination=" + destination + ", origin="
				+ origin + ", gate=" + gate + ", firstClass_fee=" + firstClass_fee + ", economy_fee=" + economy_fee
				+ "]";
	}
	
	
	
}
