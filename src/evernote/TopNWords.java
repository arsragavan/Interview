package evernote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TopNWords {

	public static void main(String[] args) {

		List<Entry<String, Integer>> wordList = new ArrayList<Map.Entry<String, Integer>>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		while (n > 0) {
			String word = scanner.nextLine();
			Integer wordCount = map.get(word);
			if (wordCount == null)
				wordCount = 0;
			map.put(word, wordCount + 1);
			n--;
		}
		int k = Integer.parseInt(scanner.nextLine());
		scanner.close();

		for (Entry<String, Integer> entry : map.entrySet()) {
			wordList.add(entry);
		}

		Collections.sort(wordList, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				int compare = o2.getValue().compareTo(o1.getValue());
				if (compare == 0)
					compare = o1.getKey().compareTo(o2.getKey());
				return compare;
			}
		});

		int i = 0;
		for (Entry<String, Integer> entry : wordList) {
			System.out.println(entry.getKey());
			i++;
			if (i == k)
				break;
		}

	}
}