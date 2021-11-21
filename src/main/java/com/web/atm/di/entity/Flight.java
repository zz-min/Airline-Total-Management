package com.web.atm.di.entity;

public class Flight {
	private int sn; // flight 테이블 시퀀스
	private int airlineSn; // Airline 테이블 시퀀스
	private int flight_typeSn; // flight_type 테이블 시퀀스
	private int avail_seat;//유효좌석수(일등석좌석수 + 이코노미좌석수 - 예약한 좌석수)
	private String dep_time;//출발시간
	private String arr_time;//도착시간
	private String destination;//출발지
	private String origin;//도착지
	private int gate;// 게이트 번호
	private int firstClass_fee;//일등석좌석 가격
	private int economy_fee;//이코노미좌석 가격
	
	public Flight() {
		
	}
	
	public Flight(int sn, int airlineSn, int flight_typeSn, int avail_seat, String dep_time, String arr_time,
			String destination, String origin, int gate, int firstClass_fee, int economy_fee) {
		super();
		this.sn = sn;
		this.airlineSn = airlineSn;
		this.flight_typeSn = flight_typeSn;
		this.avail_seat = avail_seat;
		this.dep_time = dep_time;
		this.arr_time = arr_time;
		this.destination = destination;
		this.origin = origin;
		this.gate = gate;
		this.firstClass_fee = firstClass_fee;
		this.economy_fee = economy_fee;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public int getAirlineSn() {
		return airlineSn;
	}

	public void setAirlineSn(int airlineSn) {
		this.airlineSn = airlineSn;
	}

	public int getFlight_typeSn() {
		return flight_typeSn;
	}

	public void setFlight_typeSn(int flight_typeSn) {
		this.flight_typeSn = flight_typeSn;
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
		return "Flight [sn=" + sn + ", airlineSn=" + airlineSn + ", flight_typeSn=" + flight_typeSn + ", avail_seat="
				+ avail_seat + ", dep_time=" + dep_time + ", arr_time=" + arr_time + ", destination=" + destination
				+ ", origin=" + origin + ", gate=" + gate + ", firstClass_fee=" + firstClass_fee + ", economy_fee="
				+ economy_fee + "]";
	}
}