package Array;

import java.util.ArrayList;
import java.util.List;

public class MaxElement {

	public static Integer getMaxElement(List<Integer> a) {

		if (a.size() == 0)
			return null;
		else if (a.size() == 1)
			return a.get(0);
		else {
			Integer max1 = getMaxElement(a.subList(0, a.size() / 2));
			Integer max2 = getMaxElement(a.subList(a.size() / 2, a.size()));
			if (max1 == null)
				return max2;
			else if (max2 == null)
				return max1;
			else
				return Integer.max(max1, max2);
		}

	}
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(-10);
		list.add(2);
		list.add(9);
		list.add(3);
		list.add(8);
		list.add(4);
		list.add(7);
		list.add(5);
		list.add(6);
		list.add(5);
		list.add(6);

		System.out.println(getMaxElement(list));
	}

}
