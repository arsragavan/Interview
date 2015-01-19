package Bits;

public class ConvertAToB {

	public static int aToB(int a, int b) {
		int count = 0;
		int xor = a ^ b;
		while (xor > 0) {
			xor = xor & xor - 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(aToB(2, 7));
	}

}
