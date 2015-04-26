package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public static List<String> getAllVals(int n) {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		List<String> list = new ArrayList<String>();
		list.add("1");
		map.put(1, list);
		for (int i = 2; i <= n; i++) {
			list = new ArrayList<String>();
			for (int k = 1; k <= n / 2 && i > k; k++) {
				List<String> prevList = map.get(i - k);
				for (String comb : prevList)
					list.add(k + "+" + comb);
			}
			list.add("" + i);
			map.put(i, list);
		}
		return map.get(n);
	}

	public static void main(String[] args) {

		System.out.println(getAllVals(4));

	}

}
