package com.training.sys.dao;

import java.util.List;

import com.training.model.Item;

public interface ItemDAO {
	public List<Item> selectAllItem();
	public List<Item> getItemByCategory(String name);
	public Item getItemById(int id);
	public List<Item> getTopSale();

}
