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

public class Sumzero {
    
    public static boolean sumzero(int[] arr, int n, int sum, String nos) {
        if (n == 0 && sum == 0) {
            System.out.println(nos);
            return true;
        }    
        if(n == 0)
            return false;
        return(sumzero(arr,n-1,sum+arr[n-1],nos+arr[n-1]+" ") || 
                sumzero(arr,n-1,sum-arr[n-1],nos+(-1*arr[n-1])+" "));
            
        
    }
    public static void main(String args[]) {
        int [] arr = {1,2,3,4,6};
        
        System.out.println(sumzero(arr, arr.length, 0, ""));
        
        
    }

}
