package oodesign.factory;

public class Square extends Shape {
	
	private int side;
	public Square() {
		super.name = "Square";
		this.side = 1;
	}
	public Square(int side) {
		super.name = "Square";
		this.side = side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	
	@Override
	public void draw() {
		System.out.println("Square of side: "+side);
		
	}
}
