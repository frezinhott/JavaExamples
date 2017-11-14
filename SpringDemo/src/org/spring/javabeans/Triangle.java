package org.spring.javabeans;

public class Triangle {
	private String type;
	private int height;
	
	public Triangle() {
		this.height=0;
	}
	
	public Triangle(String type) {
		this.type=type;
		this.height=0;
	}
	
	public Triangle(String type, int height) {
		this.type=type;
		this.height=height;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw() {
		System.out.println(getType() + " Triangle Drawn with height=" + getHeight());
	}

}
