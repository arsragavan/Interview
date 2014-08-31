/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dp;


public class LCSubstring {
    
    public static int lcSubstring (String str1, String str2) {
        if (str1.length() == 0 || str2.length() ==0)
            return 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int count = 0;
        while (len1 > 0 && len2 > 0 && str1.charAt(len1-1) == str2.charAt(len2-1)) {
            count++;
            len1--;
            len2--;
        }
        int max = Math.max(lcSubstring(str1.substring(0, len1-1), str2.substring(0, len2)),lcSubstring(str1.substring(0, len1), str2.substring(0, len2-1)));
        return Math.max(count, max);
    }
    public static int dplcSubstring (String str1, String str2) {
        int [][] lcs = new int[str1.length()+1][str2.length()+1];
        for(int i = 0;i<=str1.length();i++) {
            for(int j=0;j<=str2.length();j++) {
                if (i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                else
                    lcs[i][j] = 0;
            }
        }
        int max = 0;
        for(int i = 1;i <= str1.length(); i++)
            for (int j = 1; j<= str2.length();j++)
                if (max < lcs[i][j])
                    max = lcs[i][j];
        return max;
    }
    public static void main(String args[]) {
        System.out.println(dplcSubstring("abcvcxxasabc", "dabcvc"));
    }

}
