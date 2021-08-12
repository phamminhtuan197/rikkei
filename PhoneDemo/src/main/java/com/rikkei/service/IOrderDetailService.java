package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.OrderDetail;

public interface IOrderDetailService {
	OrderDetail getOrderDetail (long id);
	
	List<OrderDetail> getByOrder (long id);
	
	void updateOrderDetail (long id, OrderDetail orderDetail);
	
	void createOrderDetail (OrderDetail orderDetail);
}
