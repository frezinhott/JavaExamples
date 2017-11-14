package org.spring.javabeans;

import java.util.List;

public class TrianglePtList {
	private List <Point> points;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		System.out.println("Draw Triangle with Points: ");
		
		// For each point in the points collection...
		for(Point point : points) {
			System.out.println("(" + point.getX() + ", " + point.getY() + ")");
		}
	}
	
	
}
