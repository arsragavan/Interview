package Bits;

public class Rotate {

	public static int leftRotate(int n, int k) {
		return (n << 31 - k) | (n >> k);
	}

	public static void main(String[] args) {
		System.out.println(leftRotate(23, 3));
	}
}
