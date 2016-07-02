package com.mywardrobe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywardrobe.model.Item;
import com.mywardrobe.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Transactional
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> findAllItems() {
		
		return itemRepository.loadAll();
	}

}
