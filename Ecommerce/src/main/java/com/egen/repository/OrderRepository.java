package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
