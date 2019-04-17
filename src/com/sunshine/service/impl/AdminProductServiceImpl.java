package com.sunshine.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sunshine.dao.AdminProductDao;
import com.sunshine.dao.impl.AdminProductDaoImpl;
import com.sunshine.pojo.Product;
import com.sunshine.service.AdminProductService;

public class AdminProductServiceImpl implements AdminProductService{
  private AdminProductDao dao=new AdminProductDaoImpl();
	@Override
	public boolean save(Product product) throws SQLException {
		int i=dao.save(product);
		return i>0?true:false;
	}
	@Override
	public List<Product> list() throws SQLException {
		
		return dao.list();
	}
	@Override
	public void delete(String[] ids) throws SQLException {
		dao.delete(ids);
		
	}

}
