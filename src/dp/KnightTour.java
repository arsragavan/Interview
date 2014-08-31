package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightTour {

	public static int dpTotalPaths(int n) {
		int[][] count = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i - 2 >= 0 && j - 1 >= 0)
					count[i][j] += count[i - 2][j - 1] + 1;
				if (i - 2 >= 0 && j + 1 < n)
					count[i][j] += count[i - 2][j + 1] + 1;
				if (i - 1 >= 0 && j - 2 >= 0)
					count[i][j] += count[i - 1][j - 2] + 1;
				if (i - 1 >= 0 && j + 2 < n)
					count[i][j] += count[i - 1][j + 2] + 1;

				if (i + 2 < n && j - 1 >= 0)
					count[i][j] += count[i + 2][j - 1] + 1;
				if (i + 2 < n && j + 1 < n)
					count[i][j] += count[i + 2][j + 1] + 1;
				if (i + 1 < n && j - 2 >= 0)
					count[i][j] += count[i + 1][j - 2] + 1;
				if (i + 1 < n && j + 2 < n)
					count[i][j] += count[i + 1][j + 2] + 1;
			}
		}
		return count[n - 1][n - 1];
	}

	public static int bfsShortestPaths(int startI, int startJ, int endI,
			int endJ, int n) {
		int[][] count = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				count[i][j] = Integer.MAX_VALUE - 1;
		count[startI][startJ] = 0;
		Queue<Integer> queueI = new LinkedList<>();
		Queue<Integer> queueJ = new LinkedList<>();
		queueI.add(startI);
		queueJ.add(startJ);
		while (!queueI.isEmpty() && !queueJ.isEmpty()) {

			int i = queueI.remove();
			int j = queueJ.remove();

			if (i + 1 < n && j + 2 < n && count[i + 1][j + 2] > count[i][j] + 1) {
				count[i + 1][j + 2] = count[i][j] + 1;
				queueI.add(i + 1);
				queueJ.add(j + 2);
			}
			if (i + 1 < n && j - 2 >= 0
					&& count[i + 1][j - 2] > count[i][j] + 1) {
				count[i + 1][j - 2] = count[i][j] + 1;
				queueI.add(i + 1);
				queueJ.add(j - 2);
			}
			if (i - 1 >= 0 && j + 2 < n
					&& count[i - 1][j + 2] > count[i][j] + 1) {
				count[i - 1][j + 2] = count[i][j] + 1;
				queueI.add(i - 1);
				queueJ.add(j + 2);
			}
			if (i - 1 >= 0 && j - 2 >= 0
					&& count[i - 1][j - 2] > count[i][j] + 1) {
				count[i - 1][j - 2] = count[i][j] + 1;
				queueI.add(i - 1);
				queueJ.add(j - 2);
			}
			if (i - 2 >= 0 && j - 1 >= 0
					&& count[i - 2][j - 1] > count[i][j] + 1) {
				count[i - 2][j - 1] = count[i][j] + 1;
				queueI.add(i - 2);
				queueJ.add(j - 1);
			}
			if (i - 2 >= 0 && j + 1 < n
					&& count[i - 2][j + 1] > count[i][j] + 1) {
				count[i - 2][j + 1] = count[i][j] + 1;
				queueI.add(i - 2);
				queueJ.add(j + 1);
			}
			if (i + 2 < n && j - 1 >= 0
					&& count[i + 2][j - 1] > count[i][j] + 1) {
				count[i + 2][j - 1] = count[i][j] + 1;
				queueI.add(i + 2);
				queueJ.add(j - 1);
			}
			if (i + 2 < n && j + 1 < n && count[i + 2][j + 1] > count[i][j] + 1) {
				count[i + 2][j + 1] = count[i][j] + 1;
				queueI.add(i + 2);
				queueJ.add(j + 1);
			}
		}

		System.out.println(Arrays.toString(count[0]));
		System.out.println(Arrays.toString(count[1]));
		System.out.println(Arrays.toString(count[2]));
		System.out.println(Arrays.toString(count[3]));
		// System.out.println(Arrays.toString(count[4]));
		// System.out.println(Arrays.toString(count[5]));
		// System.out.println(Arrays.toString(count[6]));
		// System.out.println(Arrays.toString(count[7]));
		return count[endI][endJ];
	}

	public static void main(String[] args) {

		System.out.println(bfsShortestPaths(0, 0, 0, 2, 4));

	}

}
