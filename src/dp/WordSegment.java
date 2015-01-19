package dp;

import java.util.HashMap;
import java.util.Map;

public class WordSegment {

	public static boolean isValidWord(String str) {
		return (str == null || str.equals("") || str.equals("i")
				|| str.equals("a") || str.equals("am") || str.equals("go")
				|| str.equals("going") || str.equals("to") || str.equals("tow")
				|| str.equals("or") || str.equals("work") || str.equals("day")
				|| str.equals("today") || str.equals("asynchronous") || str
					.equals("shop"));

	}

	public static String wordSeg(String str, Map<String, String> wordMap) {

		if (wordMap.containsKey(str)) {
			System.out.println("DP = " + str + "->" + wordMap.get(str));
			return wordMap.get(str);
		}
		if (str.isEmpty())
			wordMap.put("", "");
		else if (isValidWord(str))
			wordMap.put(str, str);
		else {
			for (int i = 1; i <= str.length(); i++) {
				if (isValidWord(str.substring(0, i))) {
					// if the rest of the characters form valid word, then this
					// word is also valid
					String remaining = wordSeg(str.substring(i), wordMap);
					if (remaining != null) {
						wordMap.put(str, str.substring(0, i) + " " + remaining);
						for (String str1 : wordMap.keySet())
							;// System.out.println(str1 + "->" +
								// wordMap.get(str1));
						System.out.println("==================");
						break;
					}
				}
			}
		}

		if (!wordMap.containsKey(str))
			wordMap.put(str, null);
		return wordMap.get(str);
	}

	public static void main(String[] args) {

		System.out.println(wordSeg(
				"iamgoingtoshoptodayasynchronoustodayiamgoingtoshop",
				new HashMap<String, String>()));

	}

}
