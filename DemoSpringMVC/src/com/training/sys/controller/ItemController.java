package com.training.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.model.Item;
import com.training.sys.service.ItemService;


@Controller
@RequestMapping(value = "/item/*")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/getAllItem", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getAllItem() {
		return itemService.selectAllItem();
	}
}
