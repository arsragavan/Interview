/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;


public class LP {
    
    public static int lp(String str,int i, int j) {
        
        if(i>j)
            return 0;
        if (palindrome(str, i, j))
        	return j-i+1;
        return Math.max(lp(str, i, j-1), lp(str, i+1, j));
        
    }
    public static boolean palindrome(String str,int p, int q) {
        while (p<q) {
            if(str.charAt(p) != str.charAt(q))
                return false;
            p++;
            q--;
        }
        return true;    
    }
    public static void main(String args[]) {
        System.out.println(lp("maraceeeamaram", 0, 13));
    }

}
