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
		System.out.println("In save user in USER REPOSITORY IMPL");
		
		em.persist(user);
		System.out.println("Called em.persist");
		
		em.flush();
		System.out.println("Called em.flush");
		return user;
	}

}
