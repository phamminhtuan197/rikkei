package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Order;

public interface IOrderService {
	
	List<Order> getAllOrders();
	
	List<Order> getAllOrderWait();
	
	Order getOrder(long id);
	
	List<Order> getAllByUser(long id);
	
	List<Order> getAllWaitByUser(long id);
	
	List<Order> getAllConfirmedByUser(long id);
	
	List<Order> getAllPaidByUser (long id);
	
	List<Order> getAllCancelByUser (long id);
	
	void createOrder (Order order);
	
	void updateOrder (long id, Order order);
	
}
