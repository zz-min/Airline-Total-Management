/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightRequestDo.java
 * 2. @package : com.web.atm.di.entity
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 3:24:04
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
 * @className : FlightRequestDo
 * @fileName  : FlightRequestDo.java
 * @package   : com.web.atm.di.entity
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:24:04
 * </PRE>
 */
public class FlightRequestDo {
	private int sn; // FlightRequest 테이블 시퀀스
	private String bookId;//예약 번호
	private int flight_sn;//항공편 번호
	private int user_sn;//유저 번호
	private String rsv_date;//예약 날짜 - sysdate
	private String payId;//결제 완료시 결제번호
	private String status;//결제전, 결제 완료, 환불
	
	public FlightRequestDo() {}
	public FlightRequestDo(int sn, String bookId, int flight_sn, int user_sn, String rsv_date, String payId,
			String status) {
		super();
		this.sn = sn;
		this.bookId = bookId;
		this.flight_sn = flight_sn;
		this.user_sn = user_sn;
		this.rsv_date = rsv_date;
		this.payId = payId;
		this.status = status;
	}

	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getFlight_sn() {
		return flight_sn;
	}
	public void setFlight_sn(int flight_sn) {
		this.flight_sn = flight_sn;
	}
	public int getUser_sn() {
		return user_sn;
	}
	public void setUser_sn(int user_sn) {
		this.user_sn = user_sn;
	}
	public String getRsv_date() {
		return rsv_date;
	}
	public void setRsv_date(String rsv_date) {
		this.rsv_date = rsv_date;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FlightRequestDo [sn=" + sn + ", bookId=" + bookId + ", flight_sn=" + flight_sn + ", user_sn=" + user_sn
				+ ", rsv_date=" + rsv_date + ", payId=" + payId + ", status=" + status + "]";
	}
	
	
}
