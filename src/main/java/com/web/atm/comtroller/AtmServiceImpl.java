package com.web.atm.comtroller;

import java.util.List;

import com.web.atm.dao.UserDao;
import com.web.atm.di.entity.User;

public class AtmServiceImpl implements AtmService {
	private UserDao userDao = null;
	
	public AtmServiceImpl() {
	}

	public AtmServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/* User Dao */
	@Override
	public boolean loginAvailability(String id, String pwd) {
		return userDao.loginAvailability(id, pwd);	
	}

	@Override
	public User getUser(String id) {
		return null;
	}

	@Override
	public String getUserName(String id) {
		return null;
	}

	@Override
	public List<User> getUserList(String query) {
		return null;
	}

}
