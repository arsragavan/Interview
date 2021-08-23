/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;


public class Majority {
    
    public static int boyerMoore(int[] a) {
        Integer candidate = null, counter = 0;
        for (int num: a) {
            if (candidate != null && candidate == num)
                counter++;
            else if (counter == 0) {
                candidate = num;
                counter++;
            } else
                counter--;            
        }
        return candidate;
    }
    public static void main(String args[]) {
        int [] a = {3,3,3,3,2,3,3,5,4,3,5,6,7};
        System.out.println(boyerMoore(a));
    }

}
