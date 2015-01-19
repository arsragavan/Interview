package hr;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		long no = Integer.MAX_VALUE;
		no <<= 1;
		no |= 1;
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		long[] input = new long[T];
		for (int i = 0; i < T; i++)
			input[i] = scanner.nextLong();
		for (int i = 0; i < T; i++)
			System.out.println(no ^ input[i]);
	}
}