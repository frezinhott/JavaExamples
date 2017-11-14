package org.hibernate.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Two-Wheeler-Type") // Changes the dtype value to be used in the dtype column
public class TwoWheeler extends Vehicle{
	private String handlebar;

	public String getHandlebar() {
		return handlebar;
	}

	public void setHandlebar(String handlebar) {
		this.handlebar = handlebar;
	}
	

}
