package Bits;

public class MultiplyBy7 {

	public static int multiply(int x) {

		return ((x << 3) - x);

	}

	public static void main(String[] args) {
		System.out.println(multiply(2));

	}

}
