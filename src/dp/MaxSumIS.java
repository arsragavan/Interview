package dp;

import java.util.Arrays;

public class MaxSumIS {

	public static int maxSumIncreasingSubsequence(int[] a) {
        int [] maxSum = new int[a.length];
        for(int i = 0;i< a.length;i++)
            maxSum[i] = a[i];
        // a[i] - current element
        for (int i = 1;i<a.length;i++)
        	//a[i] - elements that are before current element a[i]
            for (int j = 0;j<i;j++)
            	//check if a[i] (prev seq element) is less than the current element a[j]
            	// and if lis[i] is less than equal to the lis value at the prev elements
                if (a[i] > a[j] && maxSum[i] < maxSum[j]+a[i])
                    maxSum[i] = maxSum[j] + a[i];
        System.out.print(Arrays.toString(maxSum));
        int max = Integer.MIN_VALUE;
        for(int i=0;i<maxSum.length;i++)
            if (max < maxSum[i])
                max = maxSum[i];
        return max;
        
            
    }
	public static void main(String[] args) {
		int [] arr = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(" = "+maxSumIncreasingSubsequence(arr));

	}

}
