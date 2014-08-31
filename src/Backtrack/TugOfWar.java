/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package Backtrack;


public class TugOfWar {
    
    public static boolean sumk(int [] a, int n, boolean [] index, int k,int sum,int total) {
        if (sum == k) {
            
            int i = 0;
            System.out.print("Sum1="+k+" :");
            while (i < index.length) {
                if (index[i])
                    System.out.print(a[i]+" ");
                i++;
            }
            
            System.out.print("\nSum2="+(total-k)+" :");
            i = 0;
            while (i < index.length) {
                if (!(index[i]))
                    System.out.print(a[i]+" ");
                i++;
            }
            return true;
        }
        if (n == 0)
            return false;
        index[n-1] = true;
        if (sumk(a,n-1,index,k,sum+a[n-1],total))
            return true;
        index[n-1] = false;
        if (sumk(a,n-1,index,k,sum,total))
            return true;
        return false;
    }
    public static void tugofwar(int [] a,int n) {
        int i = 0, sum = 0;
        while (i<n)
            sum+= a[i++];
        boolean [] index = new boolean[a.length];
        if (sumk(a,n,index,sum/2,0,sum));
        else
            for (i=1;i<100;i++)
                if(sumk(a,n,index,sum/2+i,0,sum) || sumk(a,n,index,sum/2-i,0,sum))
                    break;
        
    }
    public static void main(String args[]) {
        int [] a = {2,3,4,5,6,7,8,9,10,56};
        tugofwar(a, a.length);
    }

}
