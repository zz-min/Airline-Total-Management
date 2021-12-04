/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightSeatDao.java
 * 2. @package : com.web.atm.dao
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 2:31:51
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.dao;

import com.web.atm.di.entity.FlightSeatDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightSeatDao
 * @fileName  : FlightSeatDao.java
 * @package   : com.web.atm.dao
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:40:05
 * </PRE>
 */
public interface FlightSeatDao {
	boolean insertFlightSeat(FlightSeatDo flightSeatDo);
	boolean deleteFlightSeat(int flightRequestSn);
}
