package org.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dog-Type") // Changes the dtype value to be used in the dtype column
public class Dog extends Pet{
	private String dogFood;

	public String getDogFood() {
		return dogFood;
	}

	public void setDogFood(String dogFood) {
		this.dogFood = dogFood;
	}
	
}
