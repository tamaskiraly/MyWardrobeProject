package com.mywardrobe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
		user.setUsername("New User Name");
		model.addAttribute("user", user);

		User userinsession = (User) session.getAttribute("user");
		if (userinsession != null) {
			System.out.println(userinsession.getUsername());
		} else {
			System.err.println("User in session is null");
		}
		return "addUser";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		String user3 = "nothing";
		System.out.println("result has errors: " + result.hasErrors());

		System.out.println("User set: " + user.getUsername());

		if (result.hasErrors()) {
			return "addOutfit";
		} else {
			System.out.println("In save User in User controller");
			List<User> userslist = userService.getAllUsers();

			for (User user2 : userslist) {
				if (user2.getUsername().equals(user.getUsername())) {
					System.out.println("USERNAME IS NOT UNIC");
					 user3 = user2.getUsername();
					 break;
				} else {
					System.out.println("Usernam is UNIC");
					 user3 = "index";
				}
			}
			if (!user3.equals(user.getUsername())) {
				user.setEnabled(true);
				user.setPassword("1234");
				userService.save(user);
			} else {
				System.out.println("Not unic username :" + user.getUsername());
			}
		}
		return "index";
	}

}
