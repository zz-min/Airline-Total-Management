/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightSeatJdbcDao.java
 * 2. @package : com.web.atm.dao.Impl
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 3:42:47
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 5. :            : 신규 개발.
 */
package com.web.atm.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.web.atm.dao.FlightSeatDao;
import com.web.atm.di.entity.FlightSeatDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightSeatJdbcDao
 * @fileName  : FlightSeatJdbcDao.java
 * @package   : com.web.atm.dao.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:42:47
 * </PRE>
 */
public class FlightSeatJdbcDao implements FlightSeatDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public FlightSeatJdbcDao(String driver, String url, String userName, String password) {
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
	public boolean insertFlightSeat(FlightSeatDo flightSeatDo) {
		return false;
	}

	@Override
	public boolean deleteFlightSeat(int flightRequestSn) {
		return false;
	}

}
