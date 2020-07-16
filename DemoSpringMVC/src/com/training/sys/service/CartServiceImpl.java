package com.training.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Cart;
import com.training.sys.dao.CartDAO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDAO cartDAO;
	
	@Override
	public int addCart(Cart cart) {
		// TODO Auto-generated method stub
		cartDAO.addCart(cart);
		return 1;
	}
}
