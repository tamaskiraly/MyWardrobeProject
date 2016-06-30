package com.mywardrobe.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mywardrobe.model.Outfit;
import com.mywardrobe.service.OutfitService;

@Controller
@SessionAttributes("outfit")
public class OutfitController {

	@Autowired
	private OutfitService outfitService;
	
	@RequestMapping(value = "addOutfit", method = RequestMethod.GET)
	public String addOutfit(Model model) {
		Outfit outfit = new Outfit();
		outfit.setName("New Outfit Name");
		model.addAttribute("outfit", outfit);
		
		return "addOutfit";
	}
	
	@RequestMapping(value = "addOutfit", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("outfit") Outfit outfit, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + outfit.getName());
		
		if(result.hasErrors()) {
			return "addOutfit";
		}
		else {
			outfitService.save(outfit);
		}
		
		return "index";
	}
	


}
