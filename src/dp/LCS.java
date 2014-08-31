/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package dp;


public class LCS {
    
    public static int dplcs(String str1, String str2) {
        int [][] lcs = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i <= str1.length();i++) {
            for (int j=0;j<=str2.length();j++) {
                if (i==0 || j==0)
                    lcs[i][j] =0;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    lcs [i][j] = 1+lcs[i-1][j-1];
                else
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
            }
        }
        return lcs[str1.length()][str2.length()];
    }
    public static int lcs(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0)
            return 0;
        if (str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1))
            return 1+(lcs(str1.substring(0, str1.length()-1),str2.substring(0,str2.length()-1)));
        else
            return Math.max(lcs(str1.substring(0, str1.length()-1),str2), lcs(str1,str2.substring(0, str2.length()-1)));
    }
    public static void main(String args[]) {
        
        System.out.println(dplcs("aabc","aacgggbh"));
        System.out.println(Character.getNumericValue('Q') == Character.getNumericValue('q'));
        
    }

}
