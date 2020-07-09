package com.training.sys.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.model.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Item> selectAllItem() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ItemMapper.selectAllItem");
	}

	@Override
	public List<Item> getItemByCategory(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ItemMapper.getItemByCategory", name);
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ItemMapper.getItemById", id);
	}

	@Override
	public List<Item> getTopSale() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ItemMapper.getTopSale");
	}
}
