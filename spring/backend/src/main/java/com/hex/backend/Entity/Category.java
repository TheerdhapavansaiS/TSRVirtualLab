package com.hex.backend.Entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="category")
public class Category {

	@Column(name="catname")
	@Id
	private String catName;
	
	
	public Category() {}


	public Category(String catName) {
		super();
		this.catName = catName;
	}


	public String getCatName() {
		return catName;
	}


	public void setCatName(String catName) {
		this.catName = catName;
	}


	@Override
	public String toString() {
		return "Category [catName=" + catName + "]";
	}
	
}