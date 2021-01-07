package com.egen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.model.OrderItemMap;
import com.egen.repository.OrderItemMapRepository;

@Component
public class OrderItemMapDao {


	@Autowired
	public OrderItemMapRepository orderItemMapRepository;

	
	public List<OrderItemMap> saveAll(List<OrderItemMap> orderItemMapList){
		return (List<OrderItemMap>) orderItemMapRepository.saveAll(orderItemMapList);
	}
	
	public List<OrderItemMap> getOrderItemMapListByOrderId(long orderId) throws Exception{
		return orderItemMapRepository.findByOrderId(orderId);
	}
}
