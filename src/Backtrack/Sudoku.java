package Backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sudoku {

	public static boolean solveSudoku(char[][] board, int startX, int startY,
			int n) {
		int i = startX, j = 0;
		boolean found = false;
		for (; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					found = true;
					break;
				}
			}
			if (found)
				break;
		}

		if (!found)
			return true;
		char[] possible = getAllPossibleNos(board, i, j, n);
		for (int k = 0; k < possible.length; k++) {
			board[i][j] = possible[k];
			if (solveSudoku(board, i, j, n))
				return true;
		}
		board[i][j] = '.';
		return false;

	}

	public static char[] getAllPossibleNos(char[][] board, int x, int y, int n) {
		Set<Character> set = getAllChars(n);
		for (int i = 0; i < n; i++) {
			if (i != y && set.contains(board[x][i]))
				set.remove(board[x][i]);
			if (i != x && set.contains(board[i][y]))
				set.remove(board[i][y]);
		}
		int sqX = (x / 3) * 3;
		int sqY = (y / 3) * 3;
		for (int i = sqX; i < sqX + 3; i++)
			for (int j = sqY; j < sqY + 3; j++)
				if (board[i][j] != '.' && set.contains(board[i][j]))
					set.remove(board[i][j]);

		char[] possible = new char[set.size()];
		int i = 0;
		for (char c : set)
			possible[i++] = c;
		return possible;
	}

	public static Set<Character> getAllChars(int n) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			set.add((char) (i + 49));
		return set;
	}

	public static boolean isValidSolution(char[][] board, int n) {
		Map<Integer, Set<Character>> rowMap = new HashMap<Integer, Set<Character>>();
		Map<Integer, Set<Character>> colMap = new HashMap<Integer, Set<Character>>();
		Map<Integer, Set<Character>> boxMap = new HashMap<Integer, Set<Character>>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Set<Character> rowSet = null;
				Set<Character> colSet = null;
				if (i == 0 && j == 0) {
					rowSet = new HashSet<Character>();
					colSet = new HashSet<Character>();
					rowMap.put(i, rowSet);
					colMap.put(j, colSet);
				} else if (i == 0) {
					rowSet = rowMap.get(i);
					if (rowSet.contains(board[i][j]))
						return false;
					colSet = new HashSet<Character>();
					colMap.put(j, colSet);
				} else if (j == 0) {
					colSet = colMap.get(j);
					if (colSet.contains(board[i][j]))
						return false;
					rowSet = new HashSet<Character>();
					rowMap.put(i, rowSet);
				} else {
					rowSet = rowMap.get(i);
					colSet = colMap.get(j);
					if (rowSet.contains(board[i][j])
							|| colSet.contains(board[i][j]))
						return false;
				}
				rowSet.add(board[i][j]);
				colSet.add(board[i][j]);

				int box = (i / 3) * 3 + j / 3;
				Set<Character> boxSet = boxMap.get(box);
				if (boxSet == null)
					boxSet = new HashSet<Character>();
				else if (boxSet.contains(board[i][j]))
					return false;
				boxSet.add(board[i][j]);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		int n = board.length;
		solveSudoku(board, 0, 0, n);
		if (solveSudoku(board, 0, 0, n) && isValidSolution(board, n)) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
