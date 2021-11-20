package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.di.entity.User;

public interface AtmService {
	/* User Dao */
	boolean loginAvailability(String id,String pwd);
	boolean insertUser(User user);
	User getUser(String id);

	String getUserName(String id);

	List<User> getUserList(String query);
}
