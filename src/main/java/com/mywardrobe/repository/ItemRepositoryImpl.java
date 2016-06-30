package com.mywardrobe.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mywardrobe.model.Item;

@Repository("itemRepository")
public class ItemRepositoryImpl implements ItemRepository {

	@PersistenceContext
	private EntityManager em; 
	
	@Override
	public Item save(Item item) {
		em.persist(item);
		
		em.flush();
		
		return item;
	}

}
