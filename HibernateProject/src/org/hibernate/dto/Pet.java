package org.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // Base class and subclasses saved in separate tables. Redundant data
//@Inheritance(strategy=InheritanceType.JOINED) // Base class and subclasses saved in separate tables but does not repeat data.
//@DiscriminatorColumn(
//		name="pet_type", // Change the dtype column name
//		discriminatorType=DiscriminatorType.STRING) // Change the dtype column name
public class Pet {
	@Id
	@GeneratedValue
	@Column(name="pet_id")
	private int petId;
	
	private String petName;

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
}
