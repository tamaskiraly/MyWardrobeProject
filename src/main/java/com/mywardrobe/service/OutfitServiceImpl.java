package com.mywardrobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mywardrobe.model.Outfit;
import com.mywardrobe.repository.OutfitRepository;

@Service("outfitService")
public class OutfitServiceImpl implements OutfitService {

	
	@Autowired
	private OutfitRepository outfitRepository;
	
	@Transactional
	public Outfit save(Outfit outfit) {
		return outfitRepository.save(outfit);
	}
	
}
