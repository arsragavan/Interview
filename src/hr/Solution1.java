package hr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Log {
	int id;
	String pageType;
	Integer timestamp;

	public Log(int id, String pageType) {
		this.id = id;
		this.pageType = pageType;
		this.timestamp = 1;
	}
}

public class Solution1 {

	public static String mostFrequent(List<Log> list) {

		Collections.sort(list, new Comparator<Log>() {

			@Override
			public int compare(Log o1, Log o2) {
				return o1.timestamp.compareTo(o2.timestamp);
			}
		});

		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (Log log : list) {
			List<String> pageTypes = map.get(log.id);
			if (pageTypes == null) {
				pageTypes = new ArrayList<String>();
			}
			pageTypes.add(log.pageType);
			map.put(log.id, pageTypes);
		}
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (List<String> seq : map.values()) {
			int n = seq.size();
			if (n >= 3) {
				int i = 0;
				while (i + 2 < n) {
					List<String> sub = seq.subList(i, i + 3);
					String sequence = sub.get(0) + sub.get(1) + sub.get(2);
					Integer val = countMap.get(sequence);
					if (val == null)
						val = 0;
					countMap.put(sequence, ++val);
					i++;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		String retVal = "";
		for (String seq : countMap.keySet()) {
			if (countMap.get(seq) > max) {
				max = countMap.get(seq);
				retVal = seq;
			}
		}
		return retVal;
	}

	public static void main(String[] args) {
		List<Log> list = new ArrayList<Log>();
		list.add(new Log(1, "G"));
		list.add(new Log(8, "G"));
		list.add(new Log(8, "G"));
		list.add(new Log(5, "D"));
		list.add(new Log(1, "S"));
		list.add(new Log(8, "S"));
		list.add(new Log(1, "D"));
		list.add(new Log(5, "S"));
		list.add(new Log(5, "Y"));
		list.add(new Log(5, "D"));
		list.add(new Log(8, "D"));
		list.add(new Log(8, "G"));
		list.add(new Log(2, "H"));

		System.out.println(mostFrequent(list));

	}
}
