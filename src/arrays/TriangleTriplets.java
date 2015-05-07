package arrays;

import java.util.Arrays;

public class TriangleTriplets {

	public static int getTriplets(int[] a) {
		int count = 0;
		Arrays.sort(a);
		for (int k = a.length - 1; k >= 2; k--) {
			int i = 0, j = k - 1;
			while (i < j) {
				if (a[i] + a[j] > a[k]) {
					count += (j - i);
					j--;
				} else
					i++;
			}
		}
		return count++;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(getTriplets(a));

	}

}
