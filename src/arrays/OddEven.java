/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package arrays;


public class OddEven {
    
    public static int[] oddeven(int[]a, int n) {
        int p = 0;
        int q = n-1;
        int temp;
        while(p<=q) {
            if(a[p]%2 == 0) {
                temp = a[p];
                a[p] = a[q];
                a[q] = temp;
                q--;
            }
            else if (a[q]%2 == 1) {
                temp = a[p];
                a[p] = a[q];
                a[q] = temp;
                p++;
            }
            else {
                p++;
                q--;
            }
        }
        return a;
    }
    public static void main(String args[]) {
        int [] a = {2,3,4,5,6,7};
        a = oddeven(a, a.length);
        int i = 0;
        while(i < a.length)
            System.out.print(a[i++]);
    }

}
