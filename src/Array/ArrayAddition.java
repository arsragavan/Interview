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

import java.util.Arrays;


public class ArrayAddition {
    
    public static int[] add(int [] a, int [] b) {
        int [] result = new int[Math.max(a.length, b.length)+1];
        a = reverseArray(a);
        b = reverseArray(b);
        int i = 0,carry = 0, sum = 0;
        while (i < Math.min(a.length, b.length)) {
        	sum = a[i]+b[i]+carry;
        	carry = sum/10;
        	result[i] = sum%10;
        	i++;
        }
        while(i < a.length) {
        	sum = a[i] + carry;
        	carry = sum/10;
        	result[i] = sum%10;
        	i++;
        }
        while(i < b.length) {
        	sum = b[i] + carry;
        	carry = sum/10;
        	result[i] = sum%10;
        	i++;
        }
        result [i] = carry;
        result = reverseArray(result);
        return result;
    }
    public static int [] reverseArray (int [] a) {
    	int p = 0,q=a.length-1;
    	while(p<=q) {
    		int temp = a[p];
    		a[p] = a[q];
    		a[q] = temp;
    		p++;
    		q--;
    	}
    	return a;
    }
    public static void main(String args[]) {
        int [] a = {9,9,9,9};
        int [] b = {9,9,9};
        System.out.print("Aray addition");
        System.out.println(Arrays.toString(add(a, b)));
    }

}
