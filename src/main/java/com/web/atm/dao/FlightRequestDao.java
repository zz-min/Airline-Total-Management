/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightRequestDao.java
 * 2. @package : com.web.atm.dao
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 3:23:13
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 5. :            : 신규 개발.
 */
package com.web.atm.dao;

import com.web.atm.di.entity.FlightRequestDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightRequestDao
 * @fileName  : FlightRequestDao.java
 * @package   : com.web.atm.dao
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:23:13
 * </PRE>
 */
public interface FlightRequestDao {
	boolean insertFlightRequest(FlightRequestDo flightRequestDo);
	boolean deleteFlightRequest(int flightRequestSn);
}
