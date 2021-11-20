package com.web.atm.di.entity;

public class User {	
	private int sn; // User 테이블 시퀀스
	private String userId; // 유저 아이디
	private String userPwd; // 유저 비밀번호
	private String userName; // 유저 이름
	private String phone; // 유저 핸드폰번호
	private String address; // 유저 주소
	private String birth; // 유저 생년월일
	private String passportNo; // 유저 여권번호
	
	public User() {
		
	}
	
	public User(int sn, String userId, String userPwd, String userName, String phone, String address, String birth,
			String passportNo) {
		super();
		this.sn = sn;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.birth = birth;
		this.passportNo = passportNo;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	@Override
	public String toString() {
		return "User [sn=" + sn + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone="
				+ phone + ", address=" + address + ", birth=" + birth + ", passportNo=" + passportNo + "]";
	}
	
	
}
