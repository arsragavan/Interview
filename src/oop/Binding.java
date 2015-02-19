package oop;

class A {
	public A() {
		System.out.println("A");
	}

	void parent() {
		System.out.println("I am A class");
	}
}

class B extends A {
	public B() {
		System.out.println("B");
	}

	@Override
	void parent() {
		System.out.println("I am B class");
	}
}

public class Binding {

	public static void main(String[] args) {

		System.out.println("a2");
		A a2 = new B();
		a2.parent();
		System.out.println("\n\n\nb1");
		B b1 = new B();
		b1.parent();

	}

}
