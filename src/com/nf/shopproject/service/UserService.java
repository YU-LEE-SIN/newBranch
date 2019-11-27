package com.nf.shopproject.service;

import com.nf.shopproject.dao.UserDao;
import com.nf.shopproject.entity.User;

public class UserService {
	UserDao userDao=new UserDao();
	public boolean insertUser(User user) {
		return userDao.insertUser(user);
	}
	public User getByCondition(User user) {
		return userDao.getByCondition(user);
	}
}
