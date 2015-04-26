package dp;


public class MaxStockPrice {

	public static int getMaxProfit(int[] a) {
		int profit = 0;
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] - min > profit)
				profit = a[i] - min;
			if (a[i] < min)
				min = a[i];
		}
		return profit;
	}

	public static void main(String[] args) {
		int[] a = { 4, 5, 3, 6 };

		System.out.println(getMaxProfit(a));

	}
}
