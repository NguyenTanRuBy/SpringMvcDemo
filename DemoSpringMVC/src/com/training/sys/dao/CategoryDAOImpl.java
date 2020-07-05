package com.training.sys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("CategoryMapper.selectAllCategory");
	}
	
}
