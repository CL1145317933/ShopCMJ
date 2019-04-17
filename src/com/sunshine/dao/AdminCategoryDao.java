package com.sunshine.dao;


import java.sql.SQLException;
import java.util.List;

import com.sunshine.pojo.Category;

public interface AdminCategoryDao {
   public List<Category> list() throws SQLException;
}
