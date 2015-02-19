/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package dp;

public class Fibonacci {
	// O(n) - DP bottom up approach
	public static int fib(int n) {
		int[] f = new int[n + 1];
		f[1] = 0;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			System.out.println(f[i]);
		}

		return f[n];
	}

	// O(n) - DP top down approach
	public static Integer fib(int n, Integer[] f) {
		if (f[n] == null) {
			System.out.println("Calculating: " + n);
			if (n == 1)
				f[n] = 0;
			else if (n == 2)
				f[n] = 1;
			else
				f[n] = fib(n - 1, f) + fib(n - 2, f);
		}
		return f[n];
	}

	public static void main(String args[]) {
		System.out.println("Fib = " + fib(20));
		// System.out.println("Fib = " + fib(20, new Integer[21]));
	}

}
