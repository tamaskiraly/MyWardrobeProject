package com.mywardrobe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywardrobe.model.Outfit;
@Repository("outfitRepository")
public interface OutfitRepository extends JpaRepository<Outfit, Long>{
	
}
