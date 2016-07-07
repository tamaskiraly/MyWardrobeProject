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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Item> allUserItems(String username) {
Query query = em.createQuery("SELECT g FROM Item g WHERE g.username LIKE :arg1");
		List items = query.setParameter("arg1", username).getResultList();
		System.out.println("The parameter is : "+ query.getParameter("arg1"));
		System.out.println(username);
		
		System.out.println("items in the list: " + items.size());
		
		return items;
	}

}
