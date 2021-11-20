package com.web.atm.dao;

import java.util.List;

import com.web.atm.di.entity.User;

public interface UserDao {
	boolean loginAvailability(String id, String pwd);
	
	User getUser(String id);
	
	String getUserName(String id);
	
	List<User> getUserList(String query);
}
