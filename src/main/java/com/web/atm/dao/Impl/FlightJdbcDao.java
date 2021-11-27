package com.web.atm.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.atm.dao.FlightDao;
import com.web.atm.di.entity.User;
import com.web.atm.di.entity.VIEW_FLIGHT_DETAIL;

public class FlightJdbcDao implements FlightDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public FlightJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
		
		//System.out.println("UserJdbcDao  DB연결성공");
	}

	private void disconnect() throws SQLException {
		//System.out.println("UserJdbcDao  DB연결해제");
		
		if (rs != null && !rs.isClosed()) {
			rs.close();
			rs = null;
		}
		if (stmt != null && !stmt.isClosed()) {
			stmt.close();
			stmt = null;
		}
		if (conn != null && !conn.isClosed()) {
			conn.close();
			conn = null;
		}
	}
	
	@Override
	public List<VIEW_FLIGHT_DETAIL> getFlightList(String query) {
		List<VIEW_FLIGHT_DETAIL> flightList=null;
		String sql = "select * from VIEW_FLIGHT_DETAIL";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		System.out.println("getFlightList함수 sql>>"+sql);
		try {
			connect();
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				flightList=new ArrayList<VIEW_FLIGHT_DETAIL>();
				
				while(rs.next()) {
					VIEW_FLIGHT_DETAIL vfd=new VIEW_FLIGHT_DETAIL();
					vfd.setFlightSn(rs.getInt("sn"));
					vfd.setAirlineSn(rs.getInt("airline_sn"));
					vfd.setAirlineId(rs.getString("airlineId"));
					vfd.setAirlineName(rs.getString("airlineName"));
					vfd.setFlight_typeSn(rs.getInt("flight_type_sn"));
					vfd.setFirstClass_counting(rs.getInt("firstClass_counting"));
					vfd.setEconomy_counting(rs.getInt("economy_counting"));
					vfd.setAvail_seat(rs.getInt("avail_seat"));
					vfd.setDep_time(rs.getString("dep_time"));
					vfd.setArr_time(rs.getString("arr_time"));
					vfd.setDestination(rs.getString("destination"));
					vfd.setOrigin(rs.getString("origin"));
					vfd.setGate(rs.getInt("gate"));
					vfd.setFirstClass_fee(rs.getInt("firstClass_fee"));
					vfd.setEconomy_fee(rs.getInt("economy_fee"));
					
					flightList.add(vfd);
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return flightList;
	}

	@Override
	public VIEW_FLIGHT_DETAIL getFlight(int sn) {
		VIEW_FLIGHT_DETAIL vfd=null;
		String sql = "select * from VIEW_FLIGHT_DETAIL WHERE sn= ?";
		System.out.println("getFlightList함수 sql>>"+sql);
		try {
			connect();
			stmt =  conn.prepareStatement(sql);
			stmt.setInt(1, sn);
			rs = stmt.executeQuery();
			while(rs.next()) {
				vfd=new VIEW_FLIGHT_DETAIL();
				vfd.setFlightSn(rs.getInt("sn"));
				vfd.setAirlineSn(rs.getInt("airline_sn"));
				vfd.setAirlineId(rs.getString("airlineId"));
				vfd.setAirlineName(rs.getString("airlineName"));
				vfd.setFlight_typeSn(rs.getInt("flight_type_sn"));
				vfd.setFirstClass_counting(rs.getInt("firstClass_counting"));
				vfd.setEconomy_counting(rs.getInt("economy_counting"));
				vfd.setAvail_seat(rs.getInt("avail_seat"));
				vfd.setDep_time(rs.getString("dep_time"));
				vfd.setArr_time(rs.getString("arr_time"));
				vfd.setDestination(rs.getString("destination"));
				vfd.setOrigin(rs.getString("origin"));
				vfd.setGate(rs.getInt("gate"));
				vfd.setFirstClass_fee(rs.getInt("firstClass_fee"));
				vfd.setEconomy_fee(rs.getInt("economy_fee"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return vfd;
	}

}
