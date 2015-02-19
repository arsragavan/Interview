package Array;

import java.util.HashSet;
import java.util.Set;

public class TwoDiff {

	public static int pairs(int[] a, int k) {
		/* Complete this function */
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			int b = a[i] + k;
			int c = a[i] - k;
			if (set.contains(b))
				count++;
			if (set.contains(c))
				count++;
			set.add(a[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
