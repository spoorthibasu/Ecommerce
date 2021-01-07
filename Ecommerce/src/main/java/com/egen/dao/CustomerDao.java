package com.egen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.exception.DataNotFound;
import com.egen.model.Customer;
import com.egen.repository.CustomerRepository;
/*
 * DAO stands for data access object
 * Encapsulating the details of the persistence layer 
 * Provide a CRUD interface for a single entity
 * */

@Component
public class CustomerDao {
	
	@Autowired 
	CustomerRepository customerRepository;
	
	public Customer findCustomerById(long id) throws DataNotFound {
		return customerRepository.findById(id).orElseThrow(()->new DataNotFound("Data not found for given customer id"));
	}

}
