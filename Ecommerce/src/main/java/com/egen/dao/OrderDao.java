package com.egen.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.egen.exception.DataNotFound;
import com.egen.model.Order;
import com.egen.repository.OrderRepository;

@Component
public class OrderDao {
	
	@Autowired
	public OrderRepository orderRepository;
	
	public Order getOrderById(long orderId) throws Exception {
		return orderRepository.findById(orderId).orElseThrow(() -> new DataNotFound("date not found for id" + orderId));
	}
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> saveOrderList(List<Order> orderList) {
		return (List<Order>) orderRepository.saveAll(orderList);
	}
	

	public List<Order> getOrderListByIdList(Set<Long> orderIdList) {
		return (List<Order>) orderRepository.findAllById(orderIdList);
	}

}
