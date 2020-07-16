package com.training.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.model.Cart;
import com.training.sys.service.CartService;

@Controller
@RequestMapping(value = "/cart/*")
public class CartController {

	@Autowired
	CartService cartService;
	
	
	@RequestMapping(value = "/addCart", method = RequestMethod.POST)
	public String addCart(@RequestBody Cart cart) {
		
		try {
			cartService.addCart(cart);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "add thanh cong";
	}
	
}
