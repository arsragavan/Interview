package strings;

import java.util.HashSet;

//check whether palindrome is possible with this string
public class IsPalindromePossible {

	public static boolean isPossible(String str) {
		HashSet<Character> set = new HashSet<>();
		for (int i = 0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if (set.contains(ch))
				set.remove(ch);
			else 
				set.add(ch);
		}
		if (set.size() <= 1)
			return true;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(isPossible("mmaadda"));
		String str1  = "hello";
		String str2 = str1;
		System.out.println(str1.hashCode() == str2.hashCode());

	}

}
