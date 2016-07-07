package com.mywardrobe.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mywardrobe.model.Outfit;
import com.mywardrobe.service.ItemService;
import com.mywardrobe.service.OutfitService;

@Controller
@SessionAttributes("outfit")
public class OutfitController {

	@Autowired
	private OutfitService outfitService;
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "addOutfit", method = RequestMethod.GET)
	public String addOutfit(Model model) {
		Outfit outfit = new Outfit();
		outfit.setName("New Outfit Name");
		model.addAttribute("outfit", outfit);
		
		return "addOutfit";
	}
	
	@RequestMapping(value = "addOutfit", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("outfit") Outfit outfit, BindingResult result) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String username = auth.getName();
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + outfit.getName());
		
		Outfit outfitFirst = new Outfit();
	 List<Item>itemsList = itemService.findAllUserItems(username);
		outfitFirst.setUsername(username);
		Set<Item> items= new HashSet<Item>(itemsList);
		
		outfitFirst.setItems(items);
		if(result.hasErrors()) {
			return "addOutfit";
		}
		else {
			
			outfitService.save(outfitFirst);
		}
		
		return "index";
	}
	
	@RequestMapping(value = "planOutfit", method = RequestMethod.GET)
	public String getItems(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String username = auth.getName();
	     System.out.println(username);
		List<Item> items = itemService.findAllUserItems(username);
		
		model.addAttribute("items", items);
		
		return "getItems";
	}
	
	@RequestMapping(value = "getOutfits", method = RequestMethod.GET)
	public String getOutfits(Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String username = auth.getName();
	     System.out.println(username);
		List<Outfit> outfits = outfitService.findUserOutfits(username);
		
		model.addAttribute("outfits", outfits);
		
		
		return "getOutfits";
	}

}
