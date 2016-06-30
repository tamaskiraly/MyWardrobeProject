package com.mywardrobe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Outfit outfit;
	
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

	public Outfit getOutfit() {
		return outfit;
	}

	public void setOutfit(Outfit outfit) {
		this.outfit = outfit;
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

	public User getUser() {
		return user;
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

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserid(Long userid) {
		this.id = userid;
	}
	
}
