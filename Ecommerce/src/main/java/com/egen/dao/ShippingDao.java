package com.egen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.exception.DataNotFound;
import com.egen.model.Shipping;
import com.egen.repository.ShippingRepository;

@Component
public class ShippingDao {
	
	@Autowired
	ShippingRepository shippingRepository;
	
	public Shipping findById(long id) throws DataNotFound {
		return shippingRepository.findById(id).orElseThrow(()-> new DataNotFound("Payment data not found"));
	}

}
