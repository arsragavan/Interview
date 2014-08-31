package Backtrack;

public class SumK {

	public static void sumk(int[] a, int k,int n ,int sum, String nos) {
		if (sum == k)
			System.out.println("Nos which sum to "+k+" = "+nos);
		else if (n > 0 && sum < k) {
			sumk(a, k, n-1, sum+a[n-1], nos+" "+a[n-1]);
			sumk(a, k, n-1, sum, nos);
		}
	}
	public static void main(String[] args) {
		int [] a = {1,2,3,4,5,6};
		sumk(a, 15, a.length, 0, "");
	}

}
