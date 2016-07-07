package com.mywardrobe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywardrobe.model.User;

@Service("userService")
public interface UserService {
	User save(User user);
	
	List<User> getAllUsers();
}
