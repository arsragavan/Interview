package misc;

public class TryCatchFinally {
	
	public static int divide(int a, int b) {
		try {
			return a/b;
		}
		catch(ArithmeticException e) {
			return 0;
		}
		finally {
			//If something returned from finally, this will always be returned
			//return 2;
		}
	}

	public static void main(String[] args) {
		System.out.println("Answer = "+divide(25, 0));

	}

}
