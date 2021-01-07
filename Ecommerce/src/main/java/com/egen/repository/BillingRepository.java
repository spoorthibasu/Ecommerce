package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.BillingAddr;

/*One Interface can extend another interface
*/
public interface BillingRepository extends CrudRepository<BillingAddr, Long> {

}
