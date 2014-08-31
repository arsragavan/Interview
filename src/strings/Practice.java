package strings;

class ClassName {
	int member1;
	public ClassName() {
		member1 = 100;
	}
}

public class Practice {

	
	public static void main(String[] args) throws ClassNotFoundException {
		String a = "Test";
		String b = "Test";
		System.out.println(a.hashCode() == b.hashCode()); //true
		StringBuilder strA = new StringBuilder(a);
		StringBuilder strB = new StringBuilder(b);
		System.out.println(strA.hashCode() == strB.hashCode()); //false
		
		a = "hello";
		b = "hello";
		String c = new String("hello");
		System.out.println(a == b); //true
		System.out.println((a == c || b ==c)); //false
		
		b = b.intern();
		System.out.println(a == b);
		
		ClassName cn1 = new ClassName();
		
		
		
	}
}