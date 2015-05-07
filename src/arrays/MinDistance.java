package arrays;

import java.util.ArrayList;
import java.util.List;

public class MinDistance {

	public static int findDistance(List<String> list, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		int w1 = -1;
		int w2 = -1;
		int index = -1;
		for (String str : list) {
			index++;
			if (str.equals(word1))
				w1 = index;
			if (str.equals(word2))
				w2 = index;
			if (w1 != -1 && w2 != -1)
				distance = Math.min(distance, Math.abs(w1 - w2));
		}
		return distance;

	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("the");
		list.add("quick");
		list.add("brown");
		list.add("fox");
		list.add("quick");
		System.out.println(findDistance(list, "fox", "the"));
		System.out.println(findDistance(list, "quick", "fox"));

	}

}
