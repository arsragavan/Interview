/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;

import java.util.Arrays;


public class KthSmallest {
    
    public static int threePivotStrategy(int []a, int start, int end) {
        int mid = (end-start+1)/2;
        int big = Math.max(a[start], Math.max(a[mid], a[end]));
        int small = Math.min(a[start], Math.min(a[mid], a[end]));
        if (a[start] != big && a[start] != small)
            return start;
        else if (a[end] != big && a[end] != small)
            return end;
        return mid;
    }
    public static int partition(int []a, int start, int end) {
        int pivot = threePivotStrategy(a, start, end);
        int temp = a[end];
        a[end] = a[pivot];
        a[pivot] = temp;
        int pIndex = start;
        for(int i = start;i<end;i++) {
            if (a[i] <= a[pivot]) {
                temp = a[pIndex];
                a[pIndex] = a[i];
                a[i] = temp;
                pIndex++;
            }
        }
        temp = a[pivot];
        a[pivot] = a[pIndex];
        a[pIndex] = temp;
        return pIndex;
    }
    
    public static int kthSmall(int[]a, int start, int end,int k) {
        if (start <= end) {
            int pIndex = partition(a,start,end);
            if (pIndex == k)
                return a[pIndex];
            if (pIndex < k)
                return kthSmall(a, pIndex+1, end, k);
            if (pIndex > k)
                return kthSmall(a, start, pIndex-1, k);
        }
        return -1;
    }
    
    public static void main(String args[]) {
        int [] a = {7,4,1,2,6,3,8,5};
        
        for (int k = 1;k<=a.length;k++)
            System.out.println(kthSmall(a, 0, a.length-1, k-1));
        
    }

}
