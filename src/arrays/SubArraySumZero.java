package arrays;

import java.util.HashMap;

public class SubArraySumZero {

	public static boolean isSumZero(int [] a) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0;i<a.length;i++) {
			sum +=a[i];
			if (a[i] == 0 || sum == 0 || map.get(sum)!= null)
				return true;
			map.put(sum, i);
		}
		return false;
	}
	public static void main(String[] args) {
		int [] a = {4,2,1,6,-3,-4,-2};
		System.out.println(isSumZero(a));

	}

}
