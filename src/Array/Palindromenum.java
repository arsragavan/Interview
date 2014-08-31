/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package Array;


public class Palindromenum {
    
    public static boolean isPali(int n,int dup) {
        int reverse=0;
        while(n>0) {
            reverse = reverse*10+(n%10);
            n/=10;
        }
        return(reverse == dup);
    }
    
    
    public static void main(String args[]) {
        System.out.println(isPali(132231, 132231));
    }

}
