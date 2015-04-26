package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Next greatest num with the same digits
public class NextGreatestNum {

	public static Integer getNextBiggestNum(int n) {
		List<Character> list = new ArrayList<Character>();
		String str = String.valueOf(n);
		String output = null;
		int q = str.length() - 1;
		list.add(str.charAt(q));
		q--;
		while (q >= 0) {
			list.add(str.charAt(q));
			if (str.charAt(q) < str.charAt(q + 1)) {
				list.sort(new Comparator<Character>() {
					@Override
					public int compare(Character o1, Character o2) {
						return o1.compareTo(o2);
					}
				});
				Character found = null;
				// find the smallest digit that is greater than the current
				// digit
				for (Character ch : list) {
					if (ch > str.charAt(q)) {
						output = str.substring(0, q) + ch;
						found = ch;
						break;
					}
				}
				list.remove(found);
				break;
			}
			q--;
		}
		if (q >= 0) {
			// add the remaining digits in sorted order
			for (Character ch : list)
				output += ch;
		} else
			System.out.println("Not possible");
		if (output == null)
			return null;
		else
			return Integer.parseInt(output);
	}

	public static void main(String[] args) {
		System.out.println("Next greatest = " + getNextBiggestNum(165432));
	}

}
