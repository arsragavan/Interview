/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package dp;

import java.util.Arrays;


public class LIS {
    
	public static int lis(int[] arr) {
        int [] lis = new int[arr.length];
        for(int i = 0;i< arr.length;i++)
            lis[i] = 1;
        // a[i] - current element
        for (int i = 1;i<arr.length;i++)
        	//a[i] - elements that are before current element a[i]
            for (int j = 0;j<i;j++)
            	//check if a[i] (prev seq element) is less than the current element a[j]
            	// and if lis[i] is less than equal to the lis value at the prev elements
                if (arr[i] > arr[j] && lis[i] <= lis[j])
                    lis[i] = lis[j]+1;
        int max = Integer.MIN_VALUE;
        
        System.out.print(Arrays.toString(lis));
        for(int i=0;i<lis.length;i++)
            if (max < lis[i])
                max = lis[i];
        return max;
        
            
    }
    public static void main(String args[]) {
        int [] arr = {2,1,50,13,24};
        lis(arr);
        //System.out.println(lis(arr));
    }

}
