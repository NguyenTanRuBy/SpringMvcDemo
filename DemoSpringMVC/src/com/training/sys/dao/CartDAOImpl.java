package com.training.sys.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		sqlSession.insert("CartMapper.addToCart");
		return 1;
	}
	
	
}
