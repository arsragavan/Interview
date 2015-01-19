package dp;

public class MaxEndSum {

	public static int sumGame(Integer[] arr, int start, int end,
			Integer[][] result) {
		if (result[start][end] != null) {
			System.out.println(start + " " + end);
			return result[start][end];
		}
		if (start < end) {
			result[start][end] = Math.max(
					arr[start]
							+ Math.min(
									arr[start + 1]
											+ sumGame(arr, start + 2, end,
													result),
									arr[end]
											+ sumGame(arr, start + 1, end - 1,
													result)),
					arr[end]
							+ Math.min(
									arr[start]
											+ sumGame(arr, start + 1, end - 1,
													result),
									arr[end - 1]
											+ sumGame(arr, start, end - 2,
													result)));
		} else
			result[start][end] = 0;
		return result[start][end];
	}

	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 3, 4, 6 };

		Integer[][] result = new Integer[arr.length][arr.length];
		System.out.println(sumGame(arr, 0, arr.length - 1, result));

	}
}
