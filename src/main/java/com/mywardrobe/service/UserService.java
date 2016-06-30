package com.mywardrobe.service;

import org.springframework.stereotype.Service;

import com.mywardrobe.model.User;

@Service("userService")
public interface UserService {
	User save(User user);
}
