package com.mywardrobe.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "outfits")
public class Outfit {
	
	@Id
	@GeneratedValue
	@Column(name = "OUTFIT_ID")
	private Long id;
	
	@Column(name ="NAME")
	private String name;
	
	@Column(name = "USERNAME")
	private String username;
	
	private Set<Item> items = new HashSet<Item>(0);
	
	@Access(AccessType.PROPERTY)
	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "OUTFIT_ITEMS", joinColumns = @JoinColumn(name = "OUTFIT_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
