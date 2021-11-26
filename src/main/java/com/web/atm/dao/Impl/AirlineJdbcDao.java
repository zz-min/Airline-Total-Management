package com.web.atm.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.atm.dao.AirlineDao;
import com.web.atm.di.entity.Airline;
import com.web.atm.di.entity.User;

public class AirlineJdbcDao implements AirlineDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public AirlineJdbcDao(String driver, String url, String userName, String password) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
	}

	private void disconnect() throws SQLException {
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
	public boolean insertAirline(Airline airline) {
		return false;
	}

	@Override
	public boolean deleteAirline(Airline airline) {
		return false;
	}

	@Override
	public Airline getAirline(int sn) {
		return null;
	}

	@Override
	public List<Airline> getAirlineList(String query) {
		List<Airline> airlineList=null;
		String sql = "select * from AIRLINE";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				airlineList=new ArrayList<Airline>();
				
				while(rs.next()) {
					Airline airline=new Airline();
					airline.setSn(rs.getInt("sn"));
					airline.setAirlineId(rs.getString("airlineId"));
					airline.setAirlinePwd(rs.getString("airlinePwd"));
					airline.setAirlineName(rs.getString("airlineName"));
					airline.setPhone(rs.getString("phone"));
					airline.setAddress(rs.getString("address"));
					airlineList.add(airline);
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
		return airlineList;
	}

	@Override
	public List<String> getAirlineNameList(String query) {
		List<String> airlineNameList=null;
		String sql = "select airlineName from AIRLINE";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				airlineNameList=new ArrayList<String>();
				while(rs.next()) {
					String str=rs.getString("airlineName");
					airlineNameList.add(str);
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
		return airlineNameList;
	}
}
