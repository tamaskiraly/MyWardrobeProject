package com.mywardrobe.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mywardrobe.model.User;

@Repository("userRepository")
public class UserReposirotyImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User save(User user) {
		
		em.persist(user);
		
		em.flush();
		
		return user;
	}

}
