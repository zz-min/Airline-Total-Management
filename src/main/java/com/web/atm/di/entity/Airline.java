package com.web.atm.di.entity;

public class Airline {
	private int sn; // Airline 테이블 시퀀스
	private String airlineId; // 항공사 아이디
	private String airlinePwd; // 항공사 비밀번호
	private String airlineName; // 항공사 이름
	private String phone; // 항공사 전화번호
	private String address; // 항공사 주소
	
	public Airline() {
		
	}
	
	public Airline(int sn, String airlineId, String airlinePwd, String airlineName, String phone, String address) {
		super();
		this.sn = sn;
		this.airlineId = airlineId;
		this.airlinePwd = airlinePwd;
		this.airlineName = airlineName;
		this.phone = phone;
		this.address = address;
	}
	
	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlinePwd() {
		return airlinePwd;
	}

	public void setAirlinePwd(String airlinePwd) {
		this.airlinePwd = airlinePwd;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Airline [sn=" + sn + ", airlineId=" + airlineId + ", airlinePwd=" + airlinePwd + ", airlineName="
				+ airlineName + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
