package matrix;

public class SquareMatrix {

	public static int findLargestMatrix(int[][] a) {

		int[][] size = new int[a.length][a[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 0)
					size[i][j] = 0;
				else {
					size[i][j] = 1;
					if (i > 0 && j > 0)
						size[i][j] = Math.min(size[i - 1][j - 1],
								Math.min(size[i - 1][j], size[i][j - 1])) + 1;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < size.length; i++)
			for (int j = 0; j < size[0].length; j++)
				if (size[i][j] > max)
					max = size[i][j];
		return max;
	}

	public static void main(String[] args) {

		int[][] a = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1 } };
		System.out.println(findLargestMatrix(a));

	}

}
