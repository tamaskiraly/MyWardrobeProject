package com.mywardrobe.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywardrobe.model.Outfit;
import com.mywardrobe.repository.OutfitRepository;

@Service("outfitService")
public class OutfitServiceImpl implements OutfitService {


	@Autowired
	private OutfitRepository outfitRepository;
	@PersistenceContext
	private EntityManager em;
	@Transactional
	public Outfit save(Outfit outfit) {
		return outfitRepository.save(outfit);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Outfit> findUserOutfits(String username) {
		
		Query query = em.createQuery("SELECT g FROM Outfit g WHERE g.username LIKE :arg1");
		@SuppressWarnings("rawtypes")
		List outfits = query.setParameter("arg1", username).getResultList();
		System.out.println("The parameter is : "+ query.getParameter("arg1"));
		System.out.println(username);
		
		System.out.println("items in the list: " + outfits.size());
		
		return outfits;
	}
	
	
}
