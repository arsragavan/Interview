package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TransformWord {

	public static void path(String input, String output, Set<String> set) {
		Map<String, List<String>> map = constructGraph(set);
		Map<String, String> path = new HashMap<String, String>();
		Map<String, String> parentWord = new HashMap<String, String>();

		Queue<String> queue = new LinkedList<>();
		String parent = null;
		queue.add(input);
		parentWord.put(input, parent);

		while (!queue.isEmpty()) {
			input = queue.remove();
			parent = parentWord.get(input);
			if (!path.containsKey(input)) {
				path.put(input, parent);
				if (input.equals(output)) {
					System.out.println(output);
					while (parent != null) {
						System.out.println(parent);
						parent = path.get(parent);
					}
					return;
				}
				List<String> list = map.get(input);
				if (list != null) {
					for (String child : list) {
						queue.add(child);
						parentWord.put(child, input);
					}
				}

			}
		}
		System.out.println("No such path found");
	}

	public static Map<String, List<String>> constructGraph(Set<String> set) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : set) {
			for (String match : set) {
				if (oneCharDiff(str, match)) {
					List<String> list = map.get(str);
					if (list == null) {
						list = new LinkedList<String>();
						map.put(str, list);
					}
					list.add(match);
				}
			}
		}
		return map;
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
