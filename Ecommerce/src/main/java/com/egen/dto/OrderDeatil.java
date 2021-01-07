package com.egen.dto;

import java.util.List;

import com.egen.model.Item;
import com.egen.model.Order;
import com.egen.model.OrderItemMap;
import com.egen.model.Payment;

public class OrderDeatil {
	private Order order;
//	private List<Item> itemList;
	private List<OrderItemMap>  orderItemMapList;
	private List<Payment> paymentList;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

//	public List<Item> getItemList() {
//		return itemList;
//	}
//	public void setItemList(List<Item> itemList) {
//		this.itemList = itemList;
//	}
	public List<OrderItemMap> getOrderItemMapList() {
		return orderItemMapList;
	}
	public void setOrderItemMapList(List<OrderItemMap> orderItemMapList) {
		this.orderItemMapList = orderItemMapList;
	}
	public List<Payment> getPaymentList() {
		return paymentList;
	}
	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}
	
	
}
