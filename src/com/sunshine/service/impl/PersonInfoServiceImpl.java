package com.sunshine.service.impl;

import java.sql.SQLException;

import com.sunshine.dao.PersonInfoDao;
import com.sunshine.dao.impl.PersonInfoDaoImpl;
import com.sunshine.pojo.User;
import com.sunshine.service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {
private PersonInfoDao dao=new PersonInfoDaoImpl();
	@Override
	public void update(User user) {
		try {
			dao.update(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
