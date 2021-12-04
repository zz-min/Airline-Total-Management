/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : AtmServiceImpl.java
 * 2. @package : com.web.atm.comtroller
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 2:30:12
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.dao.AirlineDao;
import com.web.atm.dao.FlightDao;
import com.web.atm.dao.FlightRequestDao;
import com.web.atm.dao.FlightSeatDao;
import com.web.atm.dao.UserDao;
import com.web.atm.di.entity.AirlineDo;
import com.web.atm.di.entity.FlightRequestDo;
import com.web.atm.di.entity.UserDo;
import com.web.atm.di.entity.ViewFlightDetailDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : AtmServiceImpl
 * @fileName  : AtmServiceImpl.java
 * @package   : com.web.atm.comtroller
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 2:30:12
 * </PRE>
 */
public class AtmServiceImpl implements AtmService {
	private UserDao userDao = null;
	private AirlineDao airlineDao = null;
	private FlightDao flightDao = null;
	private FlightRequestDao flightRequestDao = null;
	private FlightSeatDao flightSeatDao = null;
	
	public AtmServiceImpl() {
	}

	public AtmServiceImpl(UserDao userDao,AirlineDao airlineDao, FlightDao flightDao
			,FlightRequestDao flightRequestDao,FlightSeatDao flightSeatDao) {
		this.userDao = userDao;
		this.airlineDao = airlineDao;
		this.flightDao=flightDao;
		this.flightRequestDao=flightRequestDao;
		this.flightSeatDao=flightSeatDao;
	}
	
	/* User Dao */
	@Override
	public boolean loginAvailability(String id, String pwd) {
		return userDao.loginAvailability(id, pwd);	
	}
	@Override
	public boolean insertUser(UserDo user) {
		return userDao.insertUser(user);
	}

	@Override
	public UserDo getUser(String id) {
		return userDao.getUser(id);
	}
	@Override
	public int getUserSn(String id) {
		return userDao.getUserSn(id);
	}
	@Override
	public String getUserName(String id) {
		return  userDao.getUserName(id);
	}

	@Override
	public List<UserDo> getUserList(String query) {
		return null;
	}
	
	/* Airline Dao */
	@Override
	public boolean adminLoginAvailability(String id, String pwd) {
		return airlineDao.adminLoginAvailability(id,pwd);
	}
	@Override
	public boolean insertAirline(AirlineDo airline) {
		return airlineDao.insertAirline(airline);
	}
	@Override
	public boolean deleteAirline(AirlineDo airline) {
		return airlineDao.deleteAirline(airline);
	}

	@Override
	public AirlineDo getAirline(int sn) {
		return airlineDao.getAirline(sn);
	}

	@Override
	public List<AirlineDo> getAirlineList(String query) {
		return airlineDao.getAirlineList(query);
	}

	@Override
	public List<String> getAirlineNameList(String query) {
		return airlineDao.getAirlineNameList(query);
	}

	
	/* Fligh Dao */
	@Override
	public List<ViewFlightDetailDo> getFlightList(String query) {
		return flightDao.getFlightList(query);
	}

	@Override
	public ViewFlightDetailDo getFlight(int sn) {
		return flightDao.getFlight(sn);
	}
	/* FlightRequestJdbcDao */
	@Override
	public boolean insertFlightRequest(FlightRequestDo flightRequestDo) {
		return flightRequestDao.insertFlightRequest(flightRequestDo);
	}
	@Override
	public boolean deleteFlightRequest(int flightRequestSn) {
		return flightRequestDao.deleteFlightRequest(flightRequestSn);
	}
	
	/* FlightSeatJdbcDao */

}
