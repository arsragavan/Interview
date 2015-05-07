/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;

public class MaxProduct {

	public static int product(int[] a) {
		int ans = a[0];
		int prev_min = a[0];
		int prev_max = a[0];
		for (int i = 1; i < a.length; i++) {
			// If no -ve numbers, min calcs are not needed
			int new_min = prev_min * a[i];
			int new_max = prev_max * a[i];
			// pre min is maintained so that if a -ve no comes in future and
			// multiplied it becomes +ve
			prev_min = Math.min(a[i], Math.min(new_min, new_max));
			prev_max = Math.max(a[i], Math.max(new_min, new_max));
			ans = Math.max(ans, prev_max);
		}
		return ans;
	}

	public static void main(String args[]) {
		int[] a = { 1, -2, 3, -4, 5, -2, 1 };
		System.out.println(product(a));
	}
}
