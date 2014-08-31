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


public class ReverseWords {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
        
    }
    
    public static String reverseWords(String str) {
        String [] strArr = str.split("\\s");
        int i = 0;
        while(i<strArr.length) {
            strArr[i] = reverse(strArr[i]);
            i++;
        }
        i = 0;
        str="";
        while(i<strArr.length) {
            str+=strArr[i]+" "; 
            i++;
        }
        return str.trim();
    }
    public static int atoi(String str) {
        int num=0;
        
        int i = 0;
        while(i<str.length()) {
            
            if ((int)str.charAt(i) < 48 || (int)str.charAt(i) > 57) {
                System.out.println("Error");
                num = 0;
                break;
            }
            
            num= num*10+(int)str.charAt(i)-'0';
            i++;
        }
            
        return num;
    }
   
    
    public static void main(String args[]) {
        System.out.println(reverseWords(reverse("Hello world")));
        System.out.println(""+atoi("034390"));
    }

}
