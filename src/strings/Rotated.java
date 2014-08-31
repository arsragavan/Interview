/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package strings;


public class Rotated {
    
    public static void main(String args[]) {
        String str1 = "Hello World !!! ";
        String str2 = "World !!! Hello ";
        if (str1.length() == str2.length()) {
            str1 = str1 + str1;
            System.out.println(str1.contains(str2));
        }
    }

}
