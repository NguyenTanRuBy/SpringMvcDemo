package com.training.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Category;
import com.training.sys.dao.CategoryDAO;

@Service
public class CategoryServicesImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getAllCategory();
	}
}
