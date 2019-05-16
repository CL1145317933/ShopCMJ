package com.sunshine.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.sunshine.dao.PersonInfoDao;
import com.sunshine.pojo.User;
import com.sunshine.utils.DataSourceUtils;

public class PersonInfoDaoImpl implements PersonInfoDao {

	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public void update(User user) throws SQLException {
		queryRunner.update("update user set name=?,sex=? where uid= ?",user.getName(),user.getSex(),user.getUid());
	}

}
