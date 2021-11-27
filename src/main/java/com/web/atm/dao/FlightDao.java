package com.web.atm.dao;

import java.util.List;

import com.web.atm.di.entity.VIEW_FLIGHT_DETAIL;

public interface FlightDao {
	List<VIEW_FLIGHT_DETAIL> getFlightList(String query);
	VIEW_FLIGHT_DETAIL getFlight(int sn);
}
