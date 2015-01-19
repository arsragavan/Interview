package Array;

import java.util.LinkedList;

// Next greatest num with the same digits
public class NextGreatestNum {

	public static Integer getNextHighest(int n) {
		// Store the digits in reverse order
		LinkedList<Integer> list = new LinkedList<>();
		int max = -1;
		while (n > 0) {
			int lastDigit = n % 10;
			// if we found a digit less than the max digit swap
			// the max digit with the current digit
			if (lastDigit < max) {
				n /= 10;
				n = n * 10 + max;
				while (!list.isEmpty()) {
					int temp = list.removeLast();
					if (temp == max) {
						temp = lastDigit;
						max = lastDigit;
					}

					n = n * 10 + temp;
				}
				return n;

			} else if (lastDigit > max)
				max = lastDigit;
			list.add(lastDigit);
			n /= 10;
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println("Next greatest = " + getNextHighest(9909090));

	}

}
