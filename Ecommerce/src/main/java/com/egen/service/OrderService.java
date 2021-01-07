package com.egen.service;

import java.util.List;
import java.util.Map;

import com.egen.dto.OrderCreation;
import com.egen.dto.OrderDeatil;
import com.egen.model.Order;

public interface OrderService {
	
	public OrderDeatil getOrderDetails(long orderId) throws Exception;
	public Order cancelOrder(long orderId) throws Exception;
	public Order createOrder(OrderCreation orderCreation) throws Exception;
	public List<Order> batchCreateOrder(List<OrderCreation> orderCreationList) throws Exception;
	public List<Order> batchUpdateOrderStatus(Map<Long,String> orderIdStatusMap) throws Exception;
	

}
