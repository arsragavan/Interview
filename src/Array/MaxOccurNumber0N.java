/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Array;

import java.util.Arrays;


public class MaxOccurNumber0N {
    
    public static int maxOccurring(int[] a, int max) {
        Arrays.sort(a);
        int i = 0;
        int count = 0,maxcount = 0; 
        while(i < a.length) {
            //System.out.println(a[i]);
            count = 1;
            if (i+1 < a.length && a[i] == a[i+1]) {
                while (a[i] == a[i+1]) {
                    i++;
                    count++;
                }
                if (maxcount < count)
                    maxcount = count;
            }
            else
                i++;
        }
        return maxcount;
    }
    public static void main(String args[]) {
        int [] a = {1,2,1,2,2,1,2,4,1};
        System.out.println(maxOccurring(a,2));
    }

}
