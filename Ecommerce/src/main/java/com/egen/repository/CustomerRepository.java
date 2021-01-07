package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
