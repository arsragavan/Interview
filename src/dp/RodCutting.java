package dp;

public class RodCutting {
	
	// same as Knapsack problem: length <=> weight, cost <=> cost, capacity <=> rodLength 

	//O(2^n)
	public static int cutRod(int [] length, int [] cost, int rodLength, int n) {
		if (rodLength <= 0 || n == 0)
			return 0;
		if (length[n-1] <= rodLength)
			return Math.max(cost[n-1]+cutRod(length,cost,rodLength-length[n-1],n-1),cutRod(length, cost, rodLength, n-1));
		return cutRod(length, cost, rodLength, n-1);
	}
	//O(n^2 = n*rodLength)
	public static int dpCutRod(int [] length, int [] cost, int rodLength, int n) {
		int [][] rod = new int[n+1][rodLength+1];
		for (int i = 0;i<=n;i++) {
			for(int j = 0;j<=rodLength;j++) {
				if (i==0 || j == 0)
					rod[i][j] = 0;
				else if (length[i-1]<=j)
					rod[i][j] = Math.max(cost[i-1]+rod[i-1][j-length[i-1]], rod[i-1][j]);
				else
					rod [i][j] = rod [i-1][j];
			}
		}
		return rod[n][rodLength];
	}
	public static void main(String[] args) {
		int [] length = {1,2,3,4,5,6,7,8};
		int [] cost = {1, 5, 8, 9, 10, 17, 17, 20};
		System.out.println(cutRod(length, cost, 8, 8));
		System.out.println(dpCutRod(length, cost, 8, 8));

	}

}
