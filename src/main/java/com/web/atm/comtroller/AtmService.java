/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : AtmService.java
 * 2. @package : com.web.atm.comtroller
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 2:28:48
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.di.entity.AirlineDo;
import com.web.atm.di.entity.UserDo;
import com.web.atm.di.entity.ViewFlightDetailDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : AtmService
 * @fileName  : AtmService.java
 * @package   : com.web.atm.comtroller
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 2:28:48
 * </PRE>
 */
public interface AtmService {
	/* User Dao */
	boolean loginAvailability(String id,String pwd);
	boolean insertUser(UserDo user);
	UserDo getUser(String id);
	String getUserName(String id);
	List<UserDo> getUserList(String query);
	
	/* Airline Dao */
	boolean adminLoginAvailability(String id,String pwd);
	boolean insertAirline(AirlineDo airline);
	boolean deleteAirline(AirlineDo airline);
	AirlineDo getAirline(int sn);
	List<AirlineDo> getAirlineList(String query);
	List<String> getAirlineNameList(String query);
	
	/* Fligh Dao */
	List<ViewFlightDetailDo> getFlightList(String query);
	ViewFlightDetailDo getFlight(int sn);
}
