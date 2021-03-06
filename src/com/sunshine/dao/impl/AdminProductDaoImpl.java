package com.sunshine.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sunshine.dao.AdminProductDao;
import com.sunshine.pojo.Product;
import com.sunshine.utils.DataSourceUtils;

public class AdminProductDaoImpl implements AdminProductDao{

	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public int save(Product product) throws SQLException {
		String sql="insert into product(pid,pname,pimage,price,succ_count,pdesc,is_hot,pdate,cid,pnumber,pflag) values(?,?,?,?,?,?,?,?,?,?,?)";
		int i = queryRunner.update(sql,product.getPid(),product.getPname(),product.getPimage(),product.getPrice()
				,product.getSucc_count(),product.getPdesc(),product.getIs_hot(),
				product.getPdate(),product.getCategory().getCid(),product.getPnumber(),product.getPflag()
				);
		return i;
		
		
	}

	@Override
	public List<Product> list() throws SQLException {
		String sql="select * from product";
		
		return queryRunner.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public void delete(String[] ids) throws SQLException {
		for (String  id : ids) {
			
			String sql="delete from product where pid = ?";
			queryRunner.update(sql,id);
		}
	}

}
