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
}
