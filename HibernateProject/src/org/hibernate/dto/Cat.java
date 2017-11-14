package org.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cat-Type") // Changes the dtype value to be used in the dtype column
public class Cat extends Pet{
	private String catFood;

	public String getCatFood() {
		return catFood;
	}

	public void setCatFood(String catFood) {
		this.catFood = catFood;
	}
	
}
