/**
 * 
 */
package com.egen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.OrderItemMap;

/**
 * @author spoorthi
 *
 */
public interface OrderItemMapRepository extends CrudRepository<OrderItemMap, Long> {
	
	public List<OrderItemMap> findByOrderId(long id);

}
