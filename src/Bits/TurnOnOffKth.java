package Bits;

public class TurnOnOffKth {

	public static int turnOn(int i, int k) {
		return i | (1 << k - 1);
	}

	public static int turnOff(int i, int k) {
		int no = Integer.MAX_VALUE;
		int tmp = 1 << k - 1;
		return i & (no ^ tmp);
	}

	public static void main(String[] args) {
		System.out.println(turnOn(10, 5));
		System.out.println(turnOff(10, 2));
	}

}
