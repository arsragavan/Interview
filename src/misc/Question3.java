package misc;

import java.util.HashSet;
import java.util.Set;

//Sample output: cat -> bat -> bet -> beg

public class Question3 {

	public static void path(String input, String output, Set<String> set) {

		// Write your solution here

	}

	public static boolean oneCharDiff(String str1, String str2) {
		if (str1.equals(str2) || str1.length() != str2.length())
			return false;
		int count = 0, i = 0;
		while (i < str1.length()) {
			if (str1.charAt(i) != str2.charAt(i))
				count++;
			if (count > 1)
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("bat");
		set.add("bet");
		set.add("bot");
		set.add("bog");
		set.add("beg");
		set.add("dog");
		set.add("rat");
		set.add("boo");
		set.add("can");
		set.add("cal");
		set.add("cot");

		path("cat", "beg", set);
	}

}
