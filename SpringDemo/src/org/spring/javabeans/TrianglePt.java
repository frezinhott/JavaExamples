package org.spring.javabeans;

public class TrianglePt {
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointB() {
		return pointB;
	}
	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
	public Point getPointC() {
		return pointC;
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("Draw Triangle with Points: (" 
				+ this.getPointA().getX() + ", " + this.getPointA().getY() + ") (" 
				+ this.getPointB().getX() + ", " + this.getPointB().getY() + ") (" 
				+ this.getPointC().getX() + ", " + this.getPointC().getY() + ")");
	}
	
	
}
