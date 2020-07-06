package com.training.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.model.Category;
import com.training.model.Contact;
import com.training.model.Item;
import com.training.sys.service.CategoryService;
import com.training.sys.service.ItemService;

@Controller
public class HomeController {
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/")
	public String index(Model model) {

		Contact contact = new Contact("0332654897", "cong hoa", "cyberlogitech@gmail.com", "10 AM", "10 PM");
		List<Category> categories = categoryService.getAllCategory();
		List<Item> items = itemService.selectAllItem();
		
		model.addAttribute("items", items);
		model.addAttribute("categories", categories);
		model.addAttribute("contact", contact);
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/403")
	public String accessDenied() {
		return "403";
	}
	
	@RequestMapping(value = "/item")
	public String itemPage() {
		return "item";
	}
	
	
	
}
