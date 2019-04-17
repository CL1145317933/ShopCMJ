package com.sunshine.service;

import java.sql.SQLException;
import java.util.List;

import com.sunshine.pojo.Category;

public interface AdminCategoryService  {
	public List<Category> list() throws SQLException;
}
