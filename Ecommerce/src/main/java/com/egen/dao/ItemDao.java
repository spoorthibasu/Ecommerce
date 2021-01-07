package com.egen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egen.exception.DataNotFound;
import com.egen.model.Item;
import com.egen.model.Payment;
import com.egen.repository.ItemRepository;

@Component
public class ItemDao {

	
	@Autowired
	public ItemRepository itemRepository;
	
	public List<Item> getItemByIdAll(List<Long> itemId) throws Exception{
		return (List<Item>) itemRepository.findAllById(itemId);
	}

}
