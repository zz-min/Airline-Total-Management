package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.di.entity.Airline;
import com.web.atm.di.entity.User;
import com.web.atm.di.entity.VIEW_FLIGHT_DETAIL;

public interface AtmService {
	/* User Dao */
	boolean loginAvailability(String id,String pwd);
	boolean insertUser(User user);
	User getUser(String id);
	String getUserName(String id);
	List<User> getUserList(String query);
	
	/* Airline Dao */
	boolean insertAirline(Airline airline);
	boolean deleteAirline(Airline airline);
	Airline getAirline(int sn);
	List<Airline> getAirlineList(String query);
	List<String> getAirlineNameList(String query);
	
	/* Fligh Dao */
	List<VIEW_FLIGHT_DETAIL> getFlightList(String query);
}
