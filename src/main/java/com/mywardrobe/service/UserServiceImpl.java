package com.mywardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywardrobe.model.User;
import com.mywardrobe.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public User save(User user) {
		System.out.println("In save USER method in USERSERVICEIMPL");
		user = userRepository.save(user);
		
		return user;
	}

}
