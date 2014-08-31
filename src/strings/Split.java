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

import java.util.Hashtable;


public class Split {
    public static void main(String args[]) {
        String str1 ="Hello";
        String str2="elbow";
        Hashtable<Character,Integer> hash = new Hashtable<Character,Integer>();
        for(int i = 0;i<str1.length();i++)
            hash.put(str1.charAt(i), 1);
        for(int j = 0;j<str2.length();j++)
            if(hash.containsKey(str2.charAt(j)))
                System.out.print(str2.charAt(j));
    }

}
