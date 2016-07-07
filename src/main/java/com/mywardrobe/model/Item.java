package com.mywardrobe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "DESCRIPTION")
	private String descritpion;

	@Column(name = "RECOMMENDATION")
	private String recommendation;
	
	@Column(name = "COLOR")
	private String color;
	
	@Column(name = "SIZE")
	private String size;
	
	
	private Set<Outfit> outfits = new HashSet<Outfit>(0);
	
	@Access(AccessType.PROPERTY)
	@ManyToMany(mappedBy = "items")
	public Set<Outfit> getOutfits() {
		return outfits;
	}

	public void setOutfits(Set<Outfit> outfits) {
		this.outfits = outfits;
	}

	public String getCategory() {
		return category;
	}

	public String getColor() {
		return color;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public Long getid() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public String getSize() {
		return size;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public void setSize(String size) {
		this.size = size;
	}

	

	public void setUserid(Long userid) {
		this.id = userid;
	}
	
}
