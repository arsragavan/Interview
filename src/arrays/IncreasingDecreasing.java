/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;


public class IncreasingDecreasing {
    
    public static int largest(int[] a) {
        int low = 0;
        int high = a.length-1;
        while(low <= high) {
            int mid=(low+high)/2;
            if (mid >= a.length-1 || mid <= 0)
                return a[mid];
            if (a[mid] > a[mid+1] && a[mid] > a[mid-1])
                return a[mid];
            if(a[mid] < a[mid+1])
                low=mid+1;
            else
                high = mid - 1;
        }
        return -1;
    }
    public static void main(String args[]) {
        int[] a ={4,3,2,1};
        System.out.println(largest(a));
        
    }
}
