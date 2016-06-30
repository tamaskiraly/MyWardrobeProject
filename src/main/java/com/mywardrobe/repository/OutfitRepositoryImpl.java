package com.mywardrobe.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mywardrobe.model.Outfit;

@Repository("outfitRepository")
public class OutfitRepositoryImpl implements OutfitRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	public Outfit save(Outfit outfit) {
		
		em.persist(outfit);
		
		em.flush();
		
		return outfit;
	}

}
