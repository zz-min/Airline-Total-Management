package com.web.atm.di.entity;

public class Flight_Type {
	private int sn; // Flight_Type 테이블 시퀀스
	private String flightType; // Flight_Type 비행기명
	private int airline_sn; // Airline 테이블 시퀀스
	private int firstCalss_counting; // 일등석 좌석 수
	private int economy_counting; // 이코노미 좌석 수
	
	
	public Flight_Type() {
		
	}
	
	public Flight_Type(int sn, String flightType, int airline_sn, int firstCalss_counting, int economy_counting) {
		super();
		this.sn = sn;
		this.flightType = flightType;
		this.airline_sn = airline_sn;
		this.firstCalss_counting = firstCalss_counting;
		this.economy_counting = economy_counting;
	}
	
	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public int getAirline_sn() {
		return airline_sn;
	}

	public void setAirline_sn(int airline_sn) {
		this.airline_sn = airline_sn;
	}

	public int getFirstCalss_counting() {
		return firstCalss_counting;
	}

	public void setFirstCalss_counting(int firstCalss_counting) {
		this.firstCalss_counting = firstCalss_counting;
	}

	public int getEconomy_counting() {
		return economy_counting;
	}

	public void setEconomy_counting(int economy_counting) {
		this.economy_counting = economy_counting;
	}

	@Override
	public String toString() {
		return "Flight_Type [sn=" + sn + ", flightType=" + flightType + ", airline_sn=" + airline_sn
				+ ", firstCalss_counting=" + firstCalss_counting + ", economy_counting=" + economy_counting + "]";
	}
}
