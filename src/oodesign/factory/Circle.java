package oodesign.factory;

public class Circle extends Shape {

	private int radius;
	
	public Circle() {
		super.name = "Circle";
		this.radius = 1;
	}
	public Circle(int radius) {
		super.name = "Circle";
		this.radius = radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("Circle of radius : "+radius);
	}
	
}
