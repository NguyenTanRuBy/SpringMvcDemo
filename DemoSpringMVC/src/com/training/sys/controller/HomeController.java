package com.training.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.model.Contact;
import com.training.model.User;
import com.training.sys.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public String index(Model model) {

		Contact contact = new Contact("0332654897", "cong hoa", "cyberlogitech@gmail.com", "10 AM", "10 PM");
		model.addAttribute(contact);
		return "index";
	}

	@RequestMapping(value = "/user")
	@ResponseBody
	public List<User> getAllUser() {
		List<User> output = new ArrayList<>();
		/*
		 * User u1 = new User(2, "a@gmail.com", "123456"); output.add(u1);
		 */

		if (userService.selectAllUser().isEmpty()) {
			User u2 = new User(2, "a@gmail.com", "123456");
			output.add(u2);
		}

		return output;
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
}
