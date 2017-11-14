package org.spring.interfaces;

public class DrawerImpl implements Drawer {
	private String picture;

	public void draw() {
		System.out.println("Drawing a picture: " + picture);
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}
