package com.egen.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.egen.dto.OrderCreation;
import com.egen.dto.OrderDeatil;
import com.egen.model.Order;
import com.egen.service.OrderService;

import io.swagger.annotations.*;


@RestController
@RequestMapping("/order-service")
@Api(value = "order service")
public class OrderController {
	
	@Autowired
	public OrderService orderService;
	
	private static Logger logger = LoggerFactory.getLogger(OrderController.class.getName());
	
	@GetMapping("/getOrderDetails")
	@ApiOperation(value = "Get order deatils", notes = "", response = OrderDeatil.class)
	@ResponseStatus(value = HttpStatus.OK)
	public OrderDeatil getOrderDetails(@RequestParam long orderId) throws Exception {
		logger.info("order id: {}",orderId);
		return orderService.getOrderDetails(orderId);
	}
	
	@PostMapping("/createOrder")
	@ApiOperation(value = "Create a single order", notes = " ", response = Order.class)
	@ResponseStatus(value = HttpStatus.OK)
	public Order createOrder(@RequestBody OrderCreation orderCreation) throws Exception{
		logger.info("orderCreation: {}",orderCreation);
		return orderService.createOrder(orderCreation);
	}
	
	@PutMapping("/cancelOrder")
	@ApiOperation(value = "Cancel Order", notes = "Input is order id", response = Order.class)
	@ResponseStatus(value = HttpStatus.OK)
	public Order cancelOrder(@RequestParam long orderId) throws Exception{
		logger.info("order id: {}",orderId);
		return orderService.cancelOrder(orderId);
	}

	@PostMapping("/batchCreateOrder")
	@ApiOperation(value = "Create multiple orders", notes = " ", response = Object.class)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Order> batchCreateOrder(@RequestBody List<OrderCreation> orderCreationList) throws Exception{
		logger.info("orderCreationList size: {}",orderCreationList.size());
		return orderService.batchCreateOrder(orderCreationList);
	}
	
	@PutMapping("/batchUpdateStatusOrder")
	@ApiOperation(value = "Update status of order", notes = " ", response = Object.class)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Order> batchUpdateOrderStatus(@RequestBody Map<Long,String> orderIdStatusMap) throws Exception {
		logger.info("orderIdStatusMap size: {}",orderIdStatusMap.size());
		return orderService.batchUpdateOrderStatus(orderIdStatusMap);
	}
}
