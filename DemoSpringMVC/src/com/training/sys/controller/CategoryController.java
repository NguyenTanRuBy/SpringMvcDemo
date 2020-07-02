package com.training.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.model.Category;
import com.training.sys.service.CategoryService;

@Controller
@RequestMapping(value = "/category/*")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/getAllCategory", method = RequestMethod.GET)
	@ResponseBody
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
}
