/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : AirlineJdbcDao.java
 * 2. @package : com.web.atm.dao.Impl
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 4:22:38
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.atm.dao.AirlineDao;
import com.web.atm.di.entity.AirlineDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : AirlineJdbcDao
 * @fileName  : AirlineJdbcDao.java
 * @package   : com.web.atm.dao.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오후 6:59:30
 * </PRE>
 */
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
	public boolean adminLoginAvailability(String id, String pwd) {
		boolean TF=false;
		String sql = "select * from AIRLINE where airlineId = ? AND airlinePwd = ?";
		System.out.println("adminLoginAvailability함수 sql>>"+sql);
		try {
			connect();
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			if (rs.next()) {
				TF=true;
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
		return TF;
	}

	@Override
	public boolean insertAirline(AirlineDo AirlineDo) {
		return false;
	}

	@Override
	public boolean deleteAirline(AirlineDo AirlineDo) {
		return false;
	}

	@Override
	public AirlineDo getAirline(int sn) {
		return null;
	}

	@Override
	public List<AirlineDo> getAirlineList(String query) {
		List<AirlineDo> AirlineDoList=null;
		String sql = "select * from AIRLINE";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				AirlineDoList=new ArrayList<AirlineDo>();
				
				while(rs.next()) {
					AirlineDo AirlineDo=new AirlineDo();
					AirlineDo.setSn(rs.getInt("sn"));
					AirlineDo.setAirlineId(rs.getString("airlineId"));
					AirlineDo.setAirlinePwd(rs.getString("airlinePwd"));
					AirlineDo.setAirlineName(rs.getString("airlineName"));
					AirlineDo.setPhone(rs.getString("phone"));
					AirlineDo.setAddress(rs.getString("address"));
					AirlineDoList.add(AirlineDo);
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
		return AirlineDoList;
	}

	@Override
	public List<String> getAirlineNameList(String query) {
		List<String> AirlineDoNameList=null;
		String sql = "select airlineName from AIRLINE";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				AirlineDoNameList=new ArrayList<String>();
				while(rs.next()) {
					String str=rs.getString("airlineName");
					AirlineDoNameList.add(str);
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
		return AirlineDoNameList;
	}

}
