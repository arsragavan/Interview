package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Isomorphic {
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
		System.out.println(isIsomorphic("turtle", "tletur"));
	}

}
