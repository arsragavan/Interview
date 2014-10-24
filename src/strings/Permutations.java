/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package strings;

import java.util.HashMap;

public class Permutations {

	public static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
	}

	// if we have to deal with the duplicates also
	public static HashMap<String, Integer> permutation(String prefix,
			String str, HashMap<String, Integer> map) {
		int n = str.length();
		if (n == 0) {
			map.put(prefix, 1);
		} else {
			for (int i = 0; i < n; i++)
				map = permutation(prefix + str.charAt(i), str.substring(0, i)
						+ str.substring(i + 1, n), map);
		}
		return map;

	}

	public static void main(String args[]) {

		permutation("", "ABC");
		HashMap<String, Integer> map = new HashMap<>();
		map = permutation("", "ABAC", map);
		System.out.println(map);

	}

}
