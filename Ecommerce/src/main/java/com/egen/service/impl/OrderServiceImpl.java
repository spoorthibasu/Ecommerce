package com.egen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.controller.OrderController;
import com.egen.dao.CustomerDao;
import com.egen.dao.ItemDao;
import com.egen.dao.OrderDao;
import com.egen.dao.OrderItemMapDao;
import com.egen.dao.PaymentDao;
import com.egen.dao.ShippingDao;
import com.egen.dto.OrderCreation;
import com.egen.dto.OrderDeatil;
import com.egen.dto.PaymentDetail;
import com.egen.model.BillingAddr;
import com.egen.model.Customer;
import com.egen.model.Item;
import com.egen.model.Order;
import com.egen.model.OrderItemMap;
import com.egen.model.Payment;
import com.egen.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	public OrderDao orderDao;
	@Autowired
	public ItemDao itemDao;
	@Autowired
	public OrderItemMapDao orderItemMapDao;
	@Autowired
	public PaymentDao paymentDao;
	@Autowired
	public CustomerDao customerDao;
	@Autowired
	public ShippingDao shippingDao;
	private static double TAX=.10;
	
	private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class.getName());
	
	@Override
	public OrderDeatil getOrderDetails(long orderId) throws Exception {
		OrderDeatil orderDeatil =new OrderDeatil();
		Order order=orderDao.getOrderById(orderId);
		orderDeatil.setOrder(order);
		List<OrderItemMap> orderItemMapList=orderItemMapDao.getOrderItemMapListByOrderId(order.getId());
		//orderDeatil.setItemList(itemDao.getItemByIdAll(orderItemMapList.stream().map(n->n.getItem().getId()).collect(Collectors.toList())));
		orderDeatil.setOrderItemMapList(orderItemMapList);
		orderDeatil.setPaymentList(paymentDao.getPaymentListByOrderId(order.getId()));
		return orderDeatil;
	}

	@Override
	public Order cancelOrder(long orderId) throws Exception {
		Order order=orderDao.getOrderById(orderId);
		order.setStatus(Order.Status.CANCELLED.toString());
		return orderDao.saveOrder(order);
	}

	@Override
	public Order createOrder(OrderCreation orderCreation) throws Exception {
		Order order =new Order();
		Customer customer=customerDao.findCustomerById(orderCreation.getCustomerId());
		List<PaymentDetail> paymentDetails = orderCreation.getPaymentDetailList();
		order.setCustomer(customer);
		order.setShipping(shippingDao.findById(orderCreation.getShippingId()));
		order.setStatus(Order.Status.IN_PROGRESS.toString());
		double totalCharge =paymentDetails.stream().map(n->n.getCharge()).collect(Collectors.toList()).stream().mapToDouble(Double::doubleValue).sum();
		order.setTotal(totalCharge);
		order.setTax(totalCharge * TAX/(1+TAX));
		final Order orderResult = orderDao.saveOrder(order);
		List<OrderItemMap> orderItemMapList =new ArrayList<OrderItemMap>();
		orderCreation.getItemDetailList().forEach(n->{
			OrderItemMap orderItemMap =new OrderItemMap();
			orderItemMap.setItem(new Item(n.getId()));
			orderItemMap.setOrder(orderResult);
			orderItemMap.setPrice(n.getPrice());
			orderItemMap.setQty(n.getQty());
			orderItemMapList.add(orderItemMap);
		});
		List<Payment> paymentList=new ArrayList<Payment>();
		paymentDetails.forEach(n->{
			Payment payment =new Payment();
			payment.setBillingAddr(new BillingAddr(n.getBillingId()));
			payment.setCharge(n.getCharge());
			payment.setOrder(orderResult);
			payment.setPaymentConfirmation(n.getPaymentConfirmation());
			payment.setPaymentMethod(n.getType());
			paymentList.add(payment);
		});
		
		orderItemMapDao.saveAll(orderItemMapList);
		paymentDao.saveAll(paymentList);
		
		return orderResult;
	}

	@Override
	public List<Order> batchCreateOrder(List<OrderCreation> orderCreationList) throws Exception {
		List<Order> orderList =new ArrayList<Order>();
		orderCreationList.forEach(n->{
			Order order;
			try {
				order = createOrder(n);
				orderList.add(order);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("Inside batch editor catch error: {} ",e.getMessage());
				e.printStackTrace();
			}
			
			});
		return orderList;
	}

	@Override
	public List<Order> batchUpdateOrderStatus(Map<Long,String> orderIdStatusMap) {
		List<Order> orderList=orderDao.getOrderListByIdList(orderIdStatusMap.keySet());
		orderList.forEach(order->{
			order.setStatus(orderIdStatusMap.get(order.getId()));
		});
		return orderDao.saveOrderList(orderList);
	}




	

}
