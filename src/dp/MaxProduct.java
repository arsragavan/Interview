/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;


public class MaxProduct {
    
    public static int product(int[]a, int n,int count) {
        if (n > 0)
        System.out.println(n+" "+count);
        if (n==0 || count == 0)
           return 1;
       int  current = count;
       return Math.max(a[n-1]*product(a,n-1,--count),product(a,n-1,current));
    }
    
    public static void main(String args[]){
        int [] a = {1,2,3,4,5,2,1};
        System.out.println(product(a, a.length,3));
        
    }
}
