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

import java.util.Stack;


public class Reverse {
    
    public static String reverseWords(String str) {
    	Stack<String> stack = new Stack<>();
    	String [] strArray = str.split("[ ,?]");
    	for (int i = 0;i<strArray.length;i++)
    		stack.push(strArray[i]);
    	str = "";
    	while(!stack.isEmpty())
    		str = str + stack.pop();
    	return str;
    }
	public static String rreverse(String str,int n) {
        if(n==1)
            return str;
        else            
            return (str.charAt(n-1)+rreverse(str.substring(0, n-1),n-1));
        
        
    }
    public static void rev(String str) {
        if (str.length()==0)
            return;
        rev(str.substring(1, str.length()));
        System.out.print(str.charAt(0));
    }
    public static String ireverse(String str, int n) {
        String rev="";
        while(str.length() > 0) {
            rev += str.charAt(str.length()-1);
            str = str.substring(0, n-1);
            n--;
        }
        return rev;
    }
    public static void main(String args[]) {
        
        String str1 = "hello";
        //System.out.println(rreverse(str1,str1.length()));
        //System.out.println(ireverse(str1,str1.length()));
        rev(str1);
        System.out.println();
        System.out.println(reverseWords("Hello,How are You?I am fine"));
        
        
    }

}
