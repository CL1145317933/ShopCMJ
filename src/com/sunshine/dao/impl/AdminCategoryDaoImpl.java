package com.sunshine.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sunshine.dao.AdminCategoryDao;
import com.sunshine.pojo.Category;
import com.sunshine.utils.DataSourceUtils;

public class AdminCategoryDaoImpl implements AdminCategoryDao{

	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public List<Category> list() throws SQLException {
		String sql="select * from category";
		List<Category> list = queryRunner.query(sql,new BeanListHandler<>(Category.class));
		return list;
	}


}
