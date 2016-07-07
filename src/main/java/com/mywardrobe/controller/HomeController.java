package com.mywardrobe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mywardrobe.model.Item;

@Controller
public class HomeController {

	@RequestMapping(value={"/","/index"})
	public String goHome(){
		Item item = new Item();
		
		return "index";
	}
}
