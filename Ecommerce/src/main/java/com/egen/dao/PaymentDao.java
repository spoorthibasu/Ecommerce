package com.egen.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.exception.DataNotFound;
import com.egen.model.OrderItemMap;
import com.egen.model.Payment;
import com.egen.repository.PaymentRepository;
@Component
public class PaymentDao {

	@Autowired
	public PaymentRepository paymentRepository;
	
	public Payment getPaymentById(long paymentId) throws Exception{
		return paymentRepository.findById(paymentId).orElseThrow(()-> new DataNotFound("Payment data not found"));
	}
	
	public List<Payment> getPaymentListByOrderId(long orderId) throws Exception{
		return paymentRepository.findByOrderId(orderId);
	}
	
	public List<Payment> saveAll(List<Payment>paymentList) throws Exception{
		return (List<Payment>) paymentRepository.saveAll(paymentList);
	}
}
