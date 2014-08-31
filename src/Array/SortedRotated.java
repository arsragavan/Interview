/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Array;


public class SortedRotated {
    
    public static int find(int[] a,int x) {
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (low+high)/2;
            if(a[mid] == x)
                return mid;
            if (a[mid] <= a[high]) {
                if (x > a[mid] && x <= a[high])
                    low = mid+1;
                else
                    high = mid - 1;
            }
            else {
                if (x < a[mid] && x >= a[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }
    public static int timesrotated(int [] a) {
        int low = 0;
        int high = a.length-1;
        int mid;
        while(low <= high) {
            if (a[low] <= a[high])
                return low;
            mid = (low+high)/2;
            int  next = (mid+1)%a.length;
            int prev = (mid-1+a.length)%a.length;
            //System.out.println(prev+" "+next);
            if (a[mid] <= a[prev] && a[mid] <= a[next])
                return mid;
            else if (a[mid] <= a[high])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
    public static void main(String args[]) {
        int [] a = {2,3,4,5,0,1};
        System.out.println(find(a,5));
        System.out.println(timesrotated(a));
        
    }
}
