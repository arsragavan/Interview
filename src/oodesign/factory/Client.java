package oodesign.factory;

public class Client {
	

	public static void main(String[] args) {
		Factory factory = new Factory();
		
		Shape shape1 = factory.getShape(5,null);
		shape1.draw();
		
		Shape shape2 = factory.getShape(null,10);
		shape2.draw();
		
		Shape shape3 = factory.getShapeById(2);
		shape3.draw();
		
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		System.out.println(max+1);
	
	}
}
