package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByValues {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("One", 1);
		map.put("Three", 3);
		map.put("Five", 5);
		map.put("Two", 2);
		map.put("Four", 4);

		List<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
				map.entrySet());
		System.out.print("Before: ");
		for (Entry<String, Integer> entry : list) {
			System.out.print(entry.getKey() + " ");
		}

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		System.out.print("\nAfter: ");
		for (Entry<String, Integer> entry : list) {
			System.out.print(entry.getKey() + " ");
		}
	}
}
