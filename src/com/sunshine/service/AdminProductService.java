package com.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import com.sunshine.pojo.Product;

public interface AdminProductService  {
public boolean save(Product product) throws SQLException;
public List<Product> list() throws SQLException;
public void  delete(String[] ids) throws SQLException;
}
