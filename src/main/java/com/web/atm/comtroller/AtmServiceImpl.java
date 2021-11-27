package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.dao.AirlineDao;
import com.web.atm.dao.FlightDao;
import com.web.atm.dao.UserDao;
import com.web.atm.di.entity.Airline;
import com.web.atm.di.entity.User;
import com.web.atm.di.entity.VIEW_FLIGHT_DETAIL;

public class AtmServiceImpl implements AtmService {
	private UserDao userDao = null;
	private AirlineDao airlineDao = null;
	private FlightDao flightDao = null;
	
	public AtmServiceImpl() {
	}

	public AtmServiceImpl(UserDao userDao,AirlineDao airlineDao, FlightDao flightDao) {
		this.userDao = userDao;
		this.airlineDao = airlineDao;
		this.flightDao=flightDao;
	}
	
	/* User Dao */
	@Override
	public boolean loginAvailability(String id, String pwd) {
		return userDao.loginAvailability(id, pwd);	
	}
	@Override
	public boolean insertUser(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public String getUserName(String id) {
		return  userDao.getUserName(id);
	}

	@Override
	public List<User> getUserList(String query) {
		return null;
	}
	
	/* Airline Dao */
	@Override
	public boolean insertAirline(Airline airline) {
		return airlineDao.insertAirline(airline);
	}
	@Override
	public boolean deleteAirline(Airline airline) {
		return airlineDao.deleteAirline(airline);
	}

	@Override
	public Airline getAirline(int sn) {
		return airlineDao.getAirline(sn);
	}

	@Override
	public List<Airline> getAirlineList(String query) {
		return airlineDao.getAirlineList(query);
	}

	@Override
	public List<String> getAirlineNameList(String query) {
		return airlineDao.getAirlineNameList(query);
	}

	
	/* Fligh Dao */
	@Override
	public List<VIEW_FLIGHT_DETAIL> getFlightList(String query) {
		return flightDao.getFlightList(query);
	}

	@Override
	public VIEW_FLIGHT_DETAIL getFlight(int sn) {
		return flightDao.getFlight(sn);
	}

	

}
