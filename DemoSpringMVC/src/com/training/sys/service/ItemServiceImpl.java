package com.training.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Item;
import com.training.sys.dao.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;
	
	@Override
	public List<Item> selectAllItem() {
		// TODO Auto-generated method stub
		return itemDAO.selectAllItem();
	}
	
	@Override
	public List<Item> getItemByCategory(String name) {
		// TODO Auto-generated method stub
		return itemDAO.getItemByCategory(name);
	}
	
	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return itemDAO.getItemById(id);
	}
	
	@Override
	public List<Item> getTopSale() {
		// TODO Auto-generated method stub
		return itemDAO.getTopSale();
	}
}
