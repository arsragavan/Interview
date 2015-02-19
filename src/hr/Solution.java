package hr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			int k = scanner.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < k; j++)
				list.add(scanner.nextInt());
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				Integer head = iterator.next();
				if (!map.containsKey(head))
					break;
				iterator.remove();
			}
			if (list.size() > 0)
				map.put(list.get(0), list);
		}
		System.out.println("Output");
		while (map.size() > 0) {
			Integer key = map.keySet().iterator().next();
			List<Integer> list = map.get(key);
			map.remove(key);
			list.remove(key);
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				Integer head = iterator.next();
				if (!map.containsKey(head))
					break;
				iterator.remove();
			}
			if (list.size() > 0)
				map.put(list.get(0), list);
			System.out.print(key + " ");
		}
	}
}
// 29 3 35 9 88 35 39 8 27 12 65
// 29 3 88 35 9 39 8 27 12 65