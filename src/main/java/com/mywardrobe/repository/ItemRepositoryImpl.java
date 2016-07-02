package com.mywardrobe.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Item> loadAll() {
		Query query = em.createQuery("Select g from Item g");
		
		List items = query.getResultList();
		
		return items;
	}

}
