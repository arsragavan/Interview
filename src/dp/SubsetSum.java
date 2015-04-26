package dp;

public class SubsetSum {

	public static boolean isSubsetSum(int[] a, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		return (isSubsetSum(a, n - 1, sum) || isSubsetSum(a, n - 1, sum
				- a[n - 1]));
	}

	public static boolean dpIsSubsetSum(int[] a, int n, int sum) {
		return false;
	}

	public static void main(String[] args) {

		int[] a = { 3, 34, 4, 12, 5, 2 };
		System.out.println(isSubsetSum(a, a.length, 9));
	}
}
