package com.mywardrobe.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mywardrobe.model.User;
import com.mywardrobe.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "addUser", method = RequestMethod.GET)
	public String addUser(Model model, HttpSession session) {
		User user = new User();
		user.setFirstname("New User Name");
		model.addAttribute("user", user);
		
		User userinsession = (User)session.getAttribute("user");
		if(userinsession != null){
		System.out.println(userinsession.getFirstname());
		}else{
			System.err.println("User in session is null");
		}
		return "addUser";
	}
	
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + user.getFirstname());
		
		if(result.hasErrors()) {
			return "addOutfit";
		}
		else {
			userService.save(user);
		}
		
		return "index";
	}
	
}
