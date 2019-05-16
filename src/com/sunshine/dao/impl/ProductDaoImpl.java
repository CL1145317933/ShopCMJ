package com.sunshine.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.sunshine.dao.ProductDao;
import com.sunshine.pojo.Address;
import com.sunshine.pojo.Product;
import com.sunshine.pojo.User;
import com.sunshine.utils.DataSourceUtils;

public class ProductDaoImpl implements ProductDao {

	private QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());

	@Override
	public User login(String username, String password) throws SQLException {
		String sql="select * from user where username = ? and password = ?";
		return 	queryRunner.query(sql, new BeanHandler<>(User.class),username,password);
	}

	@Override
	public void register(User user) throws SQLException {
		String sql="insert into user(uid,username,password,name,sex,email) values(?,?,?,?,?,?)";
		queryRunner.update(sql,user.getUid(), user.getUsername(),user.getPassword(),user.getName(),user.getSex(),user.getEmail());
	}

	@Override
	public List<Product> cateProductList(String cid) throws SQLException {
		String sql="select * from product where cid=?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<>(Product.class),cid);
		return list;
	}

	@Override
	public Product findProductById(String pid) throws SQLException {
		String sql="select * from product where pid = ?";
		Product product = queryRunner.query(sql, new BeanHandler<>(Product.class),pid);
		return product;
	}

	@Override
	public void saveAddress(Address address) throws SQLException {
		String sql="insert into address(did,province,city,area,address,code,phone,telephone,name)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		queryRunner.update(sql,address.getDid(),address.getProvince(),address.getCity(),address.getArea(),address.getAddress(),
				address.getCode(),address.getPhone(),address.getTelephone(),address.getName());
		
	}

	@Override
	public Address findAddressByDid(String did) throws SQLException {
		String sql="select * from address where did = ?";
		
		return queryRunner.query(sql, new BeanHandler<>(Address.class),did);
	}

	@Override
	public void updateStateByOid(String r6_Order) throws SQLException {
		String sql="update orders set state= ? where oid = ?";
		queryRunner.update(sql,r6_Order);
		
	}

	@Override
	public List<Product> searchProduct(String title) throws SQLException {
		String sql="select * from product where pname like ?";
		List<Product> list = queryRunner.query(sql,new BeanListHandler<>(Product.class),"%"+title+"%");
		
		return list;
	}

	@Override
	public List<Product> priceAreaOrder(String min, String max) throws SQLException {
		String sql="select * from product where price between  ? and ?";

		return queryRunner.query(sql, new BeanListHandler<>(Product.class),Integer.parseInt(min),Integer.parseInt(max));
	}

	@Override
	public List<Object> findProductListByName(String name) throws SQLException {
		String sql="select pname from product where pname  like ? limit 0,8";
		List<Object> list = queryRunner.query(sql, new ColumnListHandler("pname"),"%"+name+"%");
		return list;
	}

	
}
