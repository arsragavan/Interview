package cc.arraysnstrings;

import java.util.ArrayList;
import java.util.List;

public class UniqueChars {

	// Time: O(n), Space:O(n)
	public static boolean isUniqueChars(String str) {
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (list.contains(str.charAt(i)))
				return false;
			list.add(str.charAt(i));
		}
		return true;
	}

	// Time: O(n^2), Space:O(1)
	public static boolean isUniqueChars2(String str) {
		for (int i = 0; i < str.length(); i++)
			for (int j = i + 1; j < str.length(); j++)
				if (str.charAt(i) == str.charAt(j))
					return false;
		return true;
	}

	public static boolean isUniqueChars3(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {

		/*
		 * String str = "gfh788"; System.out.println(isUniqueChars(str));
		 * System.out.println(isUniqueChars2(str));
		 * System.out.println(isUniqueChars3(str));
		 * 
		 * List<Integer> list = new ArrayList<Integer>(); list.add(15);
		 * list.add(10); System.out.println("0=" + list.get(0));
		 * 
		 * Collections.sort(list); System.out.println(list);
		 * 
		 * str = "10101"; str = Integer.toBinaryString(0);
		 */

		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Math.pow(2, 500));

	}
}
