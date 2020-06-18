package com.training.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.model.User;
import com.training.sys.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDAO.selectAllUser();
	}
}
