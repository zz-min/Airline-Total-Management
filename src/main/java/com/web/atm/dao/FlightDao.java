/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightDao.java
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

import java.util.List;

import com.web.atm.di.entity.ViewFlightDetailDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightDao
 * @fileName  : FlightDao.java
 * @package   : com.web.atm.dao
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 2:31:51
 * </PRE>
 */
public interface FlightDao {
	List<ViewFlightDetailDo> getFlightList(String query);
	ViewFlightDetailDo getFlight(int sn);
}
