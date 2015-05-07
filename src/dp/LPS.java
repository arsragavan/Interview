/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

public class LPS {

	public static int lps(String str, int i, int j) {
		// System.out.println(" "+i+" "+j);
		if (i > j)
			return 0;
		if (i == j)
			return 1;
		if (str.charAt(i) == str.charAt(j))
			return 2 + lps(str, i + 1, j - 1);
		return Math.max(lps(str, i + 1, j), lps(str, i, j - 1));
	}

	public static int dplps(String str, int i, int j, Integer[][] lps) {
		if (i > j)
			return 0;
		if (lps[i][j] != null)
			return lps[i][j];

		if (i == j) {
			lps[i][j] = 1;
			return lps[i][j];
		}
		if (str.charAt(i) == str.charAt(j))
			lps[i][j] = 2 + dplps(str, i + 1, j - 1, lps);
		else
			lps[i][j] = Math.max(dplps(str, i + 1, j, lps),
					dplps(str, i, j - 1, lps));
		return lps[i][j];
	}

	public static int dpLps(int[] a, int i, int j, Integer[][] lps) {
		if (i > j)
			return 0;
		if (lps[i][j] == null) {
			if (i == j)
				lps[i][j] = 1;
			else {
				if (a[i] == a[j])
					lps[i][j] = 2 + dpLps(a, i + 1, j - 1, lps);
				else
					lps[i][j] = Math.max(dpLps(a, i + 1, j, lps),
							dpLps(a, i, j - 1, lps));
			}
		}
		return lps[i][j];
	}

	public static void main(String args[]) {
		String str = "MxaydzaM";
		Integer lps[][] = new Integer[str.length()][str.length()];
		System.out.println(dplps(str, 0, str.length() - 1, lps));

		int[] a = { 4, 1, 2, 3, 4, 5, 6, 5, 4, 3, 4, 4, 4, 4, 4, 4, 4 };
		System.out.println(dpLps(a, 0, a.length - 1,
				new Integer[a.length][a.length]));
	}

}
