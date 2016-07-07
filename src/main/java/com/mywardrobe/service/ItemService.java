package com.mywardrobe.service;

import java.util.List;

import com.mywardrobe.model.Item;

public interface ItemService {
	
	Item saveItem(Item item);

	List<Item> findAllItems();
	
	List<Item> findAllUserItems(String username);
}
