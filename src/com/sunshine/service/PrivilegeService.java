package com.sunshine.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.sunshine.pojo.Address;
import com.sunshine.pojo.Order;
import com.sunshine.pojo.OrderItem;

public interface PrivilegeService {
	public List<Address> addressList() throws SQLException;
	public void updateAddress(Address address) throws SQLException;
	public Address findAddressById(String parameter) throws SQLException;
	public void deleteAddress(String did);
	public void saveOrderItem(List<OrderItem> list);
	public void saveOrder(Order order);
	List<Order> myOrder(String uid) throws SQLException;
	List<Map<String, Object>> myOrderItemList(String oid) throws SQLException;
}
