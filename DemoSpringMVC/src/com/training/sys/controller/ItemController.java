package com.training.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.model.Item;
import com.training.sys.service.ItemService;


@Controller
@RequestMapping(value = "/item/*")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "")
	public String itemPage() {
		return "item";
	}
	
	@RequestMapping(value = "/getAllItem", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getAllItem() {
		return itemService.selectAllItem();
	}
	
	@RequestMapping(value = "/getItemByCategory", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getItemByCategory(@RequestParam("name") String name) {
		return itemService.getItemByCategory(name);
	}
	
	@RequestMapping(value = "/getItemById", method = RequestMethod.GET)
	@ResponseBody
	public Item getItemById(@RequestParam("id") String id) {
		return itemService.getItemById(Integer.parseInt(id));
	}
	
	@RequestMapping(value = "/getTopSale", method = RequestMethod.GET)
	@ResponseBody
	public List<Item> getTopSale() {
		return itemService.getTopSale();
	}	
}
