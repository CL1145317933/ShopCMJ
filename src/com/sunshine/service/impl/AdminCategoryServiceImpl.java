package com.sunshine.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sunshine.dao.AdminCategoryDao;
import com.sunshine.dao.impl.AdminCategoryDaoImpl;
import com.sunshine.pojo.Category;
import com.sunshine.service.AdminCategoryService;

public class AdminCategoryServiceImpl implements AdminCategoryService{
private AdminCategoryDao dao=new AdminCategoryDaoImpl();

	@Override
	public List<Category> list() throws SQLException {
		// TODO Auto-generated method stub
		return dao.list();
	}


}
