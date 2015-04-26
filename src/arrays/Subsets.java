/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;

import java.util.LinkedList;
import java.util.List;

public class Subsets {

	// subsets of a string
	public static void subset(String input, String output, int length, int start) {
		for (int i = start; i < length; i++) {
			output += input.charAt(i);
			System.out.println(output);

			if (i < length - 1) {
				subset(input, output, length, i + 1);
			}
			output = output.substring(0, output.length() - 1);
		}
	}

	// subsets of array
	public static void subset(int[] a, List<Integer> subsets, int n, int start) {
		for (int i = start; i < n; i++) {
			subsets.add(a[i]);
			System.out.println(subsets);
			if (i < n - 1) {
				subset(a, subsets, n, i + 1);
			}
			subsets.remove(subsets.size() - 1);
		}
	}
	public static void main(String args[]) {
		subset("abcd", "", 4, 0);
		int[] a = {1, 2, 3, 4};
		subset(a, new LinkedList<Integer>(), a.length, 0);
	}

}
