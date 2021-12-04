/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : BookingInfo.java
 * 2. @package : com.web.atm.di.entity
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 4:37:45
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
 * @className : BookingInfo
 * @fileName  : BookingInfo.java
 * @package   : com.web.atm.di.entity
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 4:37:45
 * </PRE>
 */
public class BookingInfo {
	private int flightSn;
	private String select_obj_f;
	private String select_obj_e;
	
	
	public BookingInfo() {}
	public BookingInfo(int flightSn, String select_obj_f, String select_obj_e) {
		super();
		this.flightSn = flightSn;
		this.select_obj_f = select_obj_f;
		this.select_obj_e = select_obj_e;
	}

	public int getFlightSn() {
		return flightSn;
	}
	public void setFlightSn(int flightSn) {
		this.flightSn = flightSn;
	}
	public String getSelect_obj_f() {
		return select_obj_f;
	}
	public void setSelect_obj_f(String select_obj_f) {
		this.select_obj_f = select_obj_f;
	}
	public String getSelect_obj_e() {
		return select_obj_e;
	}
	public void setSelect_obj_e(String select_obj_e) {
		this.select_obj_e = select_obj_e;
	}
	@Override
	public String toString() {
		return "BookingInfo [flightSn=" + flightSn + ", select_obj_f=" + select_obj_f + ", select_obj_e=" + select_obj_e
				+ "]";
	}
	
}
