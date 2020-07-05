package com.training.sys.service;

import java.util.List;

import com.training.model.Item;

public interface ItemService {

	public List<Item> selectAllItem();
	public List<Item> getItemByCategory(String name);
}
