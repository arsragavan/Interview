/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrays;


public class ThreeWayPartition {
    
    public static char[] twoWay(char[] arr) {
        int p =0;
        int i = 0;
        while (i<arr.length) {
            if (arr[i] == 'R') {
                char temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                i++;
                p++;
            }
            else
                i++;
        }
        return arr;
    }
    public static char[] threeWay(char[] arr) {
        int p = 0;
        int q = arr.length-1;
        int i = 0;
        while(i <= q) {
            if(arr[i] == 'R') {
                char temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                i++;
                p++;
            }
            else if (arr[i] =='B') {
                char temp = arr[i];
                arr[i] = arr[q];
                arr[q] = temp;
                q--;
            }
            else
                i++;
        }
        return arr;
    }
    public static void main(String args[]) {
        String str = "RRRGBGBGBGRGBBBGRRBGGBB";
        char [] arr = threeWay(str.toCharArray());
        int i = 0;
        while (i < str.length())
            System.out.print(arr[i++]);
        System.out.println();
        str = "RBBBRRBBBRBBBRRBBB";
        arr = twoWay(str.toCharArray());
        i = 0;
        while (i < str.length())
            System.out.print(arr[i++]);
    }

}
