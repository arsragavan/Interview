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



public class MergeDup {
    
    public static char nonrepeating (String str) {
        char[] order = str.toCharArray();
        int [] charecters = new int[256];
        
        int i = 0;
        while(i < str.length())
            charecters[(int)str.charAt(i++)]++;
        i = 0;
        while(i < order.length) {
            if (charecters[(int)order[i]] == 1)
                return order[i];
            else
                i++;
        }
        return Character.MIN_VALUE;
    }
    public static String mergedup(String str) {
        
        if (str.length() <= 1)
            return str;
        StringBuilder strBuild = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            if (strBuild.length() == 0)
                strBuild.append(str.charAt(i));
            else if(strBuild.charAt(strBuild.length()-1) != str.charAt(i))
                strBuild.append(str.charAt(i));
            i++;
        }
        return strBuild.toString();
    }
    public static String removeDup(String str, int i) {
        if (i == str.length())
            return str;
        if (i+1 < str.length() && str.charAt(i) == str.charAt(i+1))
            return removeDup(str.substring(0, i)+str.substring(i+1, str.length()),i);
        else
            return removeDup(str,i+1);
                  
    }
    public static String removeDup(String str) {
        if(str.length() <= 1) {
            return str;
        }
        int i = 0;
        StringBuilder strBuilder = new StringBuilder();
        while(i<str.length()) {
            if(i+1 < str.length() && str.charAt(i) == str.charAt(i+1))
                i+=2;
            else {
                if(strBuilder.length()> 0 && strBuilder.charAt(strBuilder.length()-1) == str.charAt(i))
                    strBuilder.deleteCharAt(strBuilder.length()-1);
                else
                    strBuilder.append(str.charAt(i));
                i++;
            }
        }
        return strBuilder.toString();
    }
    public static void main(String args[]) {
        
        System.out.println(mergedup("aabccbccccdd8y"));
        //System.out.println(removeDup("aabccbccccdd"));
        System.out.println(removeDup("aabccbccccdd",0));
        System.out.println(nonrepeating("axsfdffsaxd"));
    }

}
