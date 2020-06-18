package com.training.sys.dao;

import java.util.List;

import com.training.model.User;

public interface UserDAO {
	public List<User> selectAllUser();
}
