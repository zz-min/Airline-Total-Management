/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : UserJdbcDao.java
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

import com.web.atm.dao.UserDao;
import com.web.atm.di.entity.UserDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : UserJdbcDao
 * @fileName  : UserJdbcDao.java
 * @package   : com.web.atm.dao.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 4:22:53
 * </PRE>
 */
public class UserJdbcDao implements UserDao {
	private String driver;
	private String url;
	private String userName;
	private String password;

	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public UserJdbcDao(String driver, String url, String userName, String password) {
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
	public boolean loginAvailability(String id, String pwd) {
		boolean TF=false;
		String sql = "select * from USER where userId = ? AND userPwd = ?";
		System.out.println("loginAvailability함수 sql>>"+sql);
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
	public UserDo getUser(String id) {
		UserDo user=null;
		String sql = "select * from USER where userId = ?";
		System.out.println("getUser함수 sql>>"+sql);
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				user=new UserDo();
				user.setSn(rs.getInt("sn"));
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setBirth(rs.getString("birth"));
				user.setPassportNo(rs.getString("passportNo"));
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
		return user;
	}
	@Override
	public int getUserSn(String id) {
		int userSn=0;
		String sql = "select sn from USER where userId = ?";
		try {
			connect();
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				userSn =rs.getInt("sn");
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
		return userSn;
	}
	@Override
	public String getUserName(String id) {
		String userName=null;
		String sql = "select userName from USER where userId = ?";
		System.out.println("getUserName함수 sql>>"+sql);
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, id);
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				userName =rs.getString("userName");
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
		return userName;
	}

	@Override
	public List<UserDo> getUserList(String query) {
		List<UserDo> userList=null;
		
		String sql = "select * from USER";
		sql = sql + (query != null && !query.equals("") ? " WHERE " + query : " ORDER BY sn");
		System.out.println("getUserList함수 sql>>"+sql);
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.isBeforeFirst()) {
				userList=new ArrayList<UserDo>();
				
				while(rs.next()) {
					UserDo user=new UserDo();
					user.setSn(rs.getInt("sn"));
					user.setUserId(rs.getString("userId"));
					user.setUserName(rs.getString("userName"));
					user.setPhone(rs.getString("phone"));
					user.setAddress(rs.getString("address"));
					user.setBirth(rs.getString("birth"));
					user.setPassportNo(rs.getString("passportNo"));
					
					userList.add(user);
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
		return userList;
	}

	@Override
	public boolean insertUser(UserDo user) {
		int TF=0;
		String sql = "INSERT INTO USER(userId, userPwd, userName, phone, address, birth,passportNo) VALUES(?,?,?,?,?,?,?)";
		try {
			connect();
			
			stmt =  conn.prepareStatement(sql);
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUserPwd());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getPhone());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getBirth());
			stmt.setString(7, user.getPassportNo());
			System.out.println("insertUser SQL = " + sql);
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

	
}
