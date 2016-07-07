package com.mywardrobe.service;

import java.util.List;

import com.mywardrobe.model.Outfit;

public interface OutfitService {
	
	Outfit save(Outfit outfit);
	
	List<Outfit> findUserOutfits(String username);
}
