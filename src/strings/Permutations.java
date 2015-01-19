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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
	public static HashSet<String> permutation(String prefix, String str,
			HashSet<String> set) {
		int n = str.length();
		if (n == 0) {
			set.add(prefix);
		} else {
			for (int i = 0; i < n; i++)
				set = permutation(prefix + str.charAt(i), str.substring(0, i)
						+ str.substring(i + 1, n), set);
		}
		return set;

	}

	public static Set<String> dpPermutation(String prefix, String str,
			Map<String, Set<String>> map) {

		if (map.containsKey(str))
			return map.get(str);
		int n = str.length();
		for (int i = 0; i < n; i++) {
			Set<String> set = dpPermutation(prefix + str.charAt(i),
					str.substring(0, i) + str.substring(i + 1, n), map);
			Set<String> outputSet = new HashSet<String>();
		}
		return map.get(str);

	}

	public static void main(String args[]) {

		permutation("", "ABC");

		HashSet<String> set = new HashSet<>();
		set = permutation("", "ABAC", set);
		System.out.println(set);

	}

}
