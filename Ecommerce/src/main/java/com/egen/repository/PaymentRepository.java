package com.egen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{
	
	public List<Payment> findByOrderId(long id); 

}
