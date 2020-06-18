package com.training.sys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("UserMapper.selectAllUser");
	}

}
