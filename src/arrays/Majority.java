/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;


public class Majority {
    
    public static int boyerMoore(int[] a) {
        int current,counter;
        counter = 0;
        current = a[0];
        for(int i = 0;i<a.length;i++) {
            if (current == a[i])
                counter++;
            else
                counter--;
            if (counter == 0) {
                current = a[i];
                counter++;
            }
            
        }
        return current;
    }
    public static void main(String args[]) {
        int [] a = {3,3,3,3,2,3,3,5,4,3,5,6,7};
        System.out.println(boyerMoore(a));
    }

}
