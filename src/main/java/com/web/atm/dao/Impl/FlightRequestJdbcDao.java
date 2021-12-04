/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : FlightRequestJdbcDao.java
 * 2. @package : com.web.atm.dao.Impl
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 5. 오전 3:42:27
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
import java.time.LocalDate;

import com.web.atm.dao.FlightRequestDao;
import com.web.atm.di.entity.FlightRequestDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : FlightRequestJdbcDao
 * @fileName  : FlightRequestJdbcDao.java
 * @package   : com.web.atm.dao.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 3:42:27
 * </PRE>
 */
public class FlightRequestJdbcDao implements FlightRequestDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public FlightRequestJdbcDao(String driver, String url, String userName, String password) {
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
	public boolean insertFlightRequest(FlightRequestDo flightRequestDo) {
		int TF=0;
		LocalDate ld=LocalDate.now();
		String sql = "INSERT INTO FLIGHT_REQUEST(bookId, flight_sn, user_sn,rsv_date,status) VALUES(?,?,?,?,?)";
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, flightRequestDo.getBookId());
			stmt.setInt(2, flightRequestDo.getFlight_sn());
			stmt.setInt(3, flightRequestDo.getUser_sn());
			stmt.setString(4, ld.toString());//시스템날짜
			stmt.setString(5, flightRequestDo.getStatus());
			
			TF=stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		System.out.println("insertUser 결과 >"+TF);
		
		return TF==1?true:false;
	}

	@Override
	public boolean deleteFlightRequest(int flightRequestSn) {
		return false;
	}

}
