package oodesign.factory;

import java.util.HashMap;

public class Factory {
	
	private HashMap<Integer, Shape> map;
	private Shape shape;
	
	public Factory() {
		map = new HashMap<>();
		map.put(1, new Circle());
		map.put(2, new Square());
	}
	
	public Shape getShape(Integer radius, Integer side) {
		if (radius != null)
			return ((Shape) new Circle(radius));
		else if (side != null)
			return ((Shape) new Square(side));
		return null;
	}
	
	public Shape getShapeById(int id) {
		if (id == 1) {
			shape = map.get(1);
		}
		else if (id == 2) {
			shape = map.get(2);
		}
		return shape;
	}

}
