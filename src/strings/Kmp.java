/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//  Assignment # :
//          Name : Srinivasaragavan Annamalai Rajamohan
//    Student ID : 1206282242
// Lecture Topic :
//  Description  :

package strings;

import java.util.Arrays;


public class Kmp {
    
    public static void kmpSearch(String str, String pat) {
        int[] lps = kmpTable(pat);
        int i = 0,j=0;
        System.out.println(Arrays.toString(pat.toCharArray()));
        System.out.println(Arrays.toString(lps));
        
        while(i<str.length()) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == pat.length()) {
                System.out.println("Pattern found at index :"+(i-j));
                j = lps[j-1];
            }
            else if (i < str.length() && str.charAt(i) != pat.charAt(j)) {
                if (j != 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }
    public static int[] kmpTable(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0,i=0;
        lps[i++] = 0;
        while(i<pat.length()) {
            if(pat.charAt(i) == pat.charAt(len))
                lps[i++]=++len;
            else {
                if (len != 0)
                	len = lps[len-1];
                else
                    lps[i++]=0;
            }
        }
        return lps;
    }
    
    public static void main(String args[]) {
        kmpSearch("Baaaabaaabaa", "aaabaaab");
        
    }

}
