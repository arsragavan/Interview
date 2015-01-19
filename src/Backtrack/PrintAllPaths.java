/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package Backtrack;

public class PrintAllPaths {

	public static void printPath(int[][] matrix, int i, int j, int row,
			int col, String path) {
		if (i == row - 1 && j == col - 1)
			System.out.println(path + matrix[i][j]);
		else if (i < row && j < col) {
			printPath(matrix, i + 1, j, row, col, path + matrix[i][j] + " ");
			printPath(matrix, i, j + 1, row, col, path + matrix[i][j] + " ");
			printPath(matrix, i + 1, j + 1, row, col, path + matrix[i][j] + " ");
		} else if (i < row)
			printPath(matrix, i + 1, j, row, col, path + matrix[i][col - 1]
					+ " ");
		else if (j < col)
			printPath(matrix, i, j + 1, row, col, path + matrix[row - 1][j]
					+ " ");
	}

	public static int countPath(int row, int col) {
		if (row == 1 || col == 1)
			return 1;
		return (countPath(row - 1, col) + countPath(row, col - 1) + countPath(
				row - 1, col - 1));
	}

	public static int countwithUnreachable(int row, int col, int[][] reachable) {
		if (row == 1 && col == 1)
			return 1;
		if (row < 1 || col < 1 || reachable[row - 1][col - 1] == 0)
			return 0;
		return (countwithUnreachable(row - 1, col, reachable) + countwithUnreachable(
				row, col - 1, reachable));
	}

	public static void main(String args[]) {

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printPath(matrix, 0, 0, 3, 3, "");
		System.out.println("" + countPath(3, 3));

		int[][] reachable = { { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println(countwithUnreachable(3, 3, reachable));

	}

}
