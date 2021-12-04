/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightSeatDo.java
 * 2. @package : com.web.atm.di.entity
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 3:24:19
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 5. :            : 신규 개발.
 */
package com.web.atm.di.entity;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightSeatDo
 * @fileName  : FlightSeatDo.java
 * @package   : com.web.atm.di.entity
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:24:19
 * </PRE>
 */
public class FlightSeatDo {
	private int sn; // FlightSeat 테이블 시퀀스
	private int flight_sn;//항공편 번호
	private int seatNo;//seat번호
	private String seatGrade;//seat등급 - 일등석, 일반석
	private String status;//결제전, 결제 완료, 환불
	private String bookId;//예약 번호
	private int userId;//좌석별 유저 아이디
	
	
	public FlightSeatDo() {}
	public FlightSeatDo(int sn, int flight_sn, int seatNo, String seatGrade, String status, String bookId, int userId) {
		super();
		this.sn = sn;
		this.flight_sn = flight_sn;
		this.seatNo = seatNo;
		this.seatGrade = seatGrade;
		this.status = status;
		this.bookId = bookId;
		this.userId = userId;
	}
	
	
	public int getSn() {
		return sn;
	}


	public void setSn(int sn) {
		this.sn = sn;
	}


	public int getFlight_sn() {
		return flight_sn;
	}


	public void setFlight_sn(int flight_sn) {
		this.flight_sn = flight_sn;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public String getSeatGrade() {
		return seatGrade;
	}


	public void setSeatGrade(String seatGrade) {
		this.seatGrade = seatGrade;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBookId() {
		return bookId;
	}


	public void setBookId(String bookId) {
		this.bookId = bookId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "FlightSeatDo [sn=" + sn + ", flight_sn=" + flight_sn + ", seatNo=" + seatNo + ", seatGrade=" + seatGrade
				+ ", status=" + status + ", bookId=" + bookId + ", userId=" + userId + "]";
	}
	
	
}
