package com.mywardrobe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mywardrobe.model.Item;
import com.mywardrobe.model.User;
import com.mywardrobe.service.ItemService;
import com.mywardrobe.service.UserService;

@Controller
@SessionAttributes("item")
public class ItemsController {
		
	

		@Autowired
		private ItemService itemService;
		
		
		@RequestMapping(value = "addItem", method = RequestMethod.GET)
		public String addItem(Model model) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     String user = auth.getName();
		     System.out.println(user);
			Item item = new Item();
			item.setName("new item name");
			model.addAttribute("item", item);
			
			
			
			return "addItem";
		}
		
		
		@RequestMapping(value = "addItem", method = RequestMethod.POST)
		public String updateItem(@Valid @ModelAttribute("item") Item item, HttpSession session, BindingResult result) {
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     String username = auth.getName();
		     System.out.println(username);
			System.out.println("result has errors: " + result.hasErrors());
			
			System.out.println("Item NAME: " + item.getName());
			
			if(result.hasErrors()) {
				return "addItem";
			}
			else {
				User userinsession = (User)session.getAttribute("user");
				if(userinsession != null){
				System.out.println(userinsession.getUsername()+" - From ITEMS controller");
				}else{
					System.err.println("User in session is null when in Items controller");
				}
				item.setUsername(username);
				itemService.saveItem(item);
				
				
				
			}
			//START Debugging
			User userinsession = (User)session.getAttribute("user");
			if(userinsession != null){
			System.out.println(userinsession.getUsername()+" - From ITEMS controller");
			}else{
				System.err.println("User in session is null when in Items controller");
			}
			//END Debugging 
			
			return "addItem";
		}
		
		@RequestMapping(value = "getItems", method = RequestMethod.GET)
		public String getItems(Model model){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     String username = auth.getName();
		     System.out.println(username);
			List<Item> items = itemService.findAllUserItems(username);
			
			model.addAttribute("items", items);
			
			return "getItems";
		}
		
}
