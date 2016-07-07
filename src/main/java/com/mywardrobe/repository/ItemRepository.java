package com.mywardrobe.repository;

import java.util.List;

import com.mywardrobe.model.Item;

public interface ItemRepository {

	Item save(Item item);

	List<Item> loadAll();
	
	List<Item> allUserItems(String username);
}
