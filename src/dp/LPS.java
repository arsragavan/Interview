/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;


public class LPS {
    
    public static int lps(String str,int i, int j) {
        //System.out.println(" "+i+" "+j);
        if(i>j)
            return 0;
        if (i==j)
            return 1;
        if (str.charAt(i) == str.charAt(j))
            return 2+lps(str,i+1,j-1);
        return Math.max(lps(str,i+1,j), lps(str,i,j-1));
    }
    public static int dplps(String str,int i, int j, Integer[][] lps) {
        if(i > j)
            return 0;
        if (lps[i][j] != null)
            return lps[i][j];
            
        if (i==j) {
            lps[i][j] = 1;
            return lps[i][j];
        }
        if(str.charAt(i) == str.charAt(j))
            lps[i][j] = 2+dplps(str, i+1, j-1, lps);
        else
            lps[i][j] = Math.max(dplps(str, i+1, j, lps), dplps(str, i, j-1, lps));
        return lps[i][j];
    }
    public static void main(String args[]) {
        String str = "MxaydzaM";
        Integer lps[][] = new Integer[str.length()][str.length()];
        System.out.println(dplps(str, 0, str.length()-1, lps));
    }

}
