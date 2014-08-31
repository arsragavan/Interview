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

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Arrays;


public class Sorting {
    
    public static boolean anagram(String str1,  String str2) {
        str1 = sort(str1);
        str2 = sort(str2);
        return (str1.equals(str2));
    }
    public static String sort(String str) {
        if (str.contains("d"))
            System.out.println("d");
        
        StringBuilder str2 = new StringBuilder(str);
        
        char [] str1 = str.toCharArray();
        Arrays.sort(str1);
        
        System.out.println(str1);
        return new String(str1);
        
    }
    public static String sorting(String str) {
        int n = str.length(),i=0;
        Integer val = 0, key = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        while(i<n) {
            key = (int)str.charAt(i);
            val = hashmap.get(key);
            if (val == null)
                val = 1;
            else
                val++;
            hashmap.put(key, val);
            i++;
        }
        i = 0;
        
        String sorted="";
        
        
        while(i< 256) {
            if(hashmap.containsKey(i)) {
                val = hashmap.get(i);
                while(val > 0) {
                    sorted+=(char)i;
                    val--;
                }
            }
            i++;
        }
        return sorted;
    }
    public static void main(String args[]) {
        System.out.println(anagram("delfdina", "anfieldd"));
    }
}
