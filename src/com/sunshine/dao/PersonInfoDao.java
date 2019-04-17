package com.sunshine.dao;

import java.sql.SQLException;

import com.sunshine.pojo.User;

public interface PersonInfoDao {

	void update(User user) throws SQLException;

}
