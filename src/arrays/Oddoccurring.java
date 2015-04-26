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


public class Oddoccurring {
    
    public static int oddoccurrence(int[] a) {
        int temp = 0;
        for(int i =0;i<a.length;i++) {
            if (temp == 0)
                temp = a[i];
            else
                temp ^= a[i];
        }
        return temp;
    }
    public static void main(String args[]) {
        int [] a = {0,1,1,2,2,0,2,3,3};
        
        System.out.println(oddoccurrence(a));
        
        
    }
}
