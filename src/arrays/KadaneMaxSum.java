package arrays;

public class KadaneMaxSum {

	public static int maxSubSum(int[] a) {
		int max_ending_here = a[0];
		int max_so_far = a[0];
		for (int i = 1; i < a.length; i++) {
			max_ending_here = Math.max(a[i], max_ending_here + a[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		int[] a = { -11, -2, -3, -1, -4, -17, 100, -1, 2 };
		System.out.println(maxSubSum(a));

	}

}
