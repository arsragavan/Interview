/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Backtrack;

public class Maze {

	static int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 },
			{ 1, 1, 1, 1 } };
	static int[][] path = new int[maze.length][maze[0].length];

	public static Integer findPathDP(int x, int y, int endx, int endy,
			Integer[][] path) {
		if (x > endx || y > endy)
			return null;
		else if (path[x][y] != null)
			return path[x][y];
		else if (x == endx && y == endy)
			path[x][y] = 1;
		else if (isSafe(x + 1, y) && isSafe(x, y + 1))
			path[x][y] = 1 + Math.min(findPathDP(x + 1, y, endx, endy, path),
					findPathDP(x, y + 1, endx, endy, path));
		else if (isSafe(x + 1, y))
			path[x][y] = 1 + findPathDP(x + 1, y, endx, endy, path);
		else if (isSafe(x, y + 1))
			path[x][y] = 1 + findPathDP(x, y + 1, endx, endy, path);
		return path[x][y];
	}

	public static boolean findPath(int x, int y, int endx, int endy) {
		if (x == endx && y == endy) {
			path[x][y] = 1;
			return true;
		}
		if (isSafe(x, y)) {
			path[x][y] = 1;
			if (findPath(x + 1, y, endx, endy)) {
				return true;
			}
			if (findPath(x, y + 1, endx, endy)) {
				return true;
			}
			path[x][y] = 0;
		}
		return false;
	}

	public static boolean isSafe(int x, int y) {
		try {
			return (maze[x][y] == 1);
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public static void main(String args[]) {
		if (findPath(0, 0, 3, 3)) {
			for (int i = 0; i < maze.length; i++)
				for (int j = 0; j < maze[0].length; j++)
					if (path[i][j] == 1)
						System.out.println(i + " " + j);

		}

		System.out.println("shortest="
				+ findPathDP(0, 0, 3, 3, new Integer[4][4]));
	}
}
