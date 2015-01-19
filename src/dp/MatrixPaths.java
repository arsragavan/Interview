/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;

public class MatrixPaths {

	// No of different paths
	public static int dpCountPath(int m, int n) {
		int[][] count = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					count[i][j] = 1;
				else
					count[i][j] = count[i - 1][j] + count[i][j - 1];
				// + count[i - 1][j - 1];
			}
		}
		return count[m - 1][n - 1];
	}

	public static void printPaths(int m, int n) {

		int[][] count = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 || j == n - 1)
					count[i][j] = 1;
				else
					count[i][j] = count[i + 1][j] + count[i][j + 1];
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("Top-Down=" + dpCountPath(3, 3));
		System.out.println("Bottom-up=" + dpCountPath(3, 3));

	}
}
