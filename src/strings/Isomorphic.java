package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {

	// best version
	public static boolean isIsomorphic2(String str1, String str2) {
		return (str1.length() == str2.length() && mapping(str1).equals(
				mapping(str2)));
	}

	private static String mapping(String str) {
		String output = "";
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		for (Character c : str.toCharArray()) {
			Integer n = map.get(c);
			if (n == null) {
				n = count++;
				map.put(c, n);
			}
			output += n;
		}
		return output;
	}

	public static boolean isIsomorphic1(String str1, String str2) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Integer one, two;
		int count1 = -1, count2 = -1;
		for (Character c : str1.toCharArray()) {
			Integer n = map.get(c);
			if (n == null) {
				map.put(c, ++count1);
				n = count1;
			}
			one = n;
		}
		return true;
	}

	public static boolean isIsomorphic(String str1, String str2) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> charSet = new HashSet<Character>();
		if (str1.length() != str2.length())
			return false;
		int i = 0;
		while (i < str1.length()) {
			// System.out.println(map + " " + charSet);
			Character mappedChar = map.get(str1.charAt(i));
			if (mappedChar == null) {
				if (charSet.contains(str2.charAt(i)))
					return false;
				map.put(str1.charAt(i), str2.charAt(i));
				charSet.add(str2.charAt(i));
			} else if (!mappedChar.equals(str2.charAt(i)))
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic2("foo", "app"));
	}

}
