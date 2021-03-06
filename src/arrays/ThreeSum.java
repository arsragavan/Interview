/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	public static void twoDiff(int[] a, int diff) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++)
			map.put(diff + a[i], i);
		for (int i = 0; i < a.length; i++)
			if (map.containsKey(a[i]) || map.containsKey(-a[i]))
				System.out.println(a[i] + " " + map.get(a[i]));
	}

	public static void twoSum(int[] a, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		while (i < a.length) {
			map.put(sum - a[i], i);
			i++;
		}
		i = 0;
		while (i < a.length) {
			Integer pair = map.get(a[i]);
			if (pair != null) {
				System.out.println("Pair of values:" + a[i] + " "
						+ (sum - a[i]));
				map.remove(a[i]);
				map.remove(sum - a[i]);
			}
			i++;
		}
	}

	public static void threesum(ArrayList<Integer> arr) {
		Collections.sort(arr);
		int p, q, sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			p = i + 1;
			q = arr.size() - 1;
			while (p < q) {
				sum = arr.get(i) + arr.get(p) + arr.get(q);
				if (sum > 0) {
					q--;
				} else if (sum < 0) {
					p++;
				} else {
					System.out.println(arr.get(i) + " " + arr.get(p) + " "
							+ arr.get(q));
					p++;
					q--;
				}

			}
		}
	}

	public static void sumthreeArrays(int[] a, int[] b, int[] c, int sum) {
		int i = 0;
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		while (i < a.length) {
			hashmap.put(a[i], i);
			i++;
		}
		for (i = 0; i < b.length; i++) {
			for (int j = 0; j < c.length; j++)
				if (hashmap.get(sum - b[i] - c[j]) != null) {
					System.out.println((sum - b[i] - c[j]) + " " + b[i] + " "
							+ c[j]);
					hashmap.remove(sum - b[i] - c[j]);
				}
		}
	}

	public static void oddeven(ArrayList<Integer> arr) {
		int p = 0, q = arr.size() - 1;
		while (p < q) {
			if (arr.get(p) % 2 == 0) {
				int temp = arr.get(p);
				arr.set(p, arr.get(q));
				arr.set(q, temp);
				q--;
			} else
				p++;
		}
		p = arr.size() - 1;
		while (p >= 0) {
			System.out.print(arr.get(p) + " ");
			p--;
		}
	}

	public static long maxProd(int[] a) {
		long prod = 1;
		int i = 0, min = Integer.MAX_VALUE;
		while (i < a.length) {
			if (a[i] != 0) {
				prod = prod * a[i];
				if (a[i] < min)
					min = a[i];
			}
			i++;
		}
		return prod;
	}

	public static void main(String args[]) {

		int[] a = { 1, 2, 3, 4, 5, 6 };
		int[] b = { 7, 8, 9, 10, 11, 12 };
		int[] c = { -1, -2, -3, -4, -5, -6 };

		// sumthreeArrays(a, b, c, 7);

		int[] arr = { 0, 7, 0, 2, 3, -2, -7 };
		// twoSum(arr, 9);

		twoDiff(arr, -4);
	}
}
