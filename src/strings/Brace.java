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
import java.util.Stack;


public class Brace {
    
    public static int brace(String str,HashMap<String,Integer> hash) {
        
        if(hash.containsKey(str)) {
            System.out.println("Hash contains"+str);
            return hash.get(str);
        }
            
        if (str.equals("")) {
            hash.put(str, 0);
            return 0;
        }
        if (str.equals("{")) {
            hash.put(str, 1);
            return 1;
        }
        if (str.equals("}")) {
            hash.put(str, -1);
            return -1;
        }
             
        int len = str.length();
        int mid = str.length()/2;
        
        int sum = brace(str.substring(0, mid),hash)+brace(str.substring(mid, len),hash);
        
        hash.put(str, sum);
        
        return (hash.get(str));
    }
    public static void main(String args[]) {
        
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        if(brace("{}{}{}{}{}{}",hash) == 0)
        System.out.println("Matching");
        
        
        
        
    }

}
