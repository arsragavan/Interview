package Array;

public class SubsetSum {

	public static boolean isSubsetSum(int [] a, int n, int k, int sum) {
		System.out.println(sum+" "+n);
		if (sum == k)
			return true;
		if (n == 0 || sum > k)
			return false;
		return (isSubsetSum(a, n-1, k, sum+a[n-1]) || isSubsetSum(a, n-1, k, sum));
	}
}
