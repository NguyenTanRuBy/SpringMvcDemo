package com.training.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.model.Category;
import com.training.sys.dao.CategoryDAO;

public interface CategoryService {

	public List<Category> getAllCategory();
}
