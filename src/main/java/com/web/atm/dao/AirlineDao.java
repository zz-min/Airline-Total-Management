package com.web.atm.dao;

import java.util.List;

import com.web.atm.di.entity.Airline;

public interface AirlineDao {
	boolean insertAirline(Airline airline);
	boolean deleteAirline(Airline airline);
	
	Airline getAirline(int sn);
	
	List<Airline> getAirlineList(String query);
	List<String> getAirlineNameList(String query);
}
