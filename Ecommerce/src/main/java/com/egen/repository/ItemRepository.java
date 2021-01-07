package com.egen.repository;

import org.springframework.data.repository.CrudRepository;

import com.egen.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
