package misc;

class Outer {
	int val;
	
	class InnerInc {
		public void inc() {
			val++;
		}
	}
	
	
	public int getVal() {
		InnerInc inner = new InnerInc();
		inner.inc();
		return val;
	}
	
	public static class InnerDec {
		public int dec(int n) {
			return --n;
		}
	}
}
public class InnerClass {

	public static void main(String[] args) {
		Outer outer = new Outer();
		System.out.println(outer.getVal());
		
		Outer.InnerDec oid = new Outer.InnerDec();
		int x = oid.dec(outer.getVal());
		
		System.out.println(x);
		

	}

}
