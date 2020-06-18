package com.training.sys.service;

import java.util.List;

import com.training.model.User;
import com.training.sys.dao.UserDAO;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDAO.selectAllUser();
	}
}
